package defpackage;

import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class wv implements Closeable, AutoCloseable {
    public final File g;
    public final File h;
    public final File i;
    public final File j;
    public final long l;
    public BufferedWriter o;
    public int q;
    public long n = 0;
    public final LinkedHashMap p = new LinkedHashMap(0, 0.75f, true);
    public long r = 0;
    public final ThreadPoolExecutor s = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new tv());
    public final sv t = new sv(this, 0);
    public final int k = 1;
    public final int m = 1;

    public wv(File file, long j) {
        this.g = file;
        this.h = new File(file, "journal");
        this.i = new File(file, "journal.tmp");
        this.j = new File(file, "journal.bkp");
        this.l = j;
    }

    public static wv A(File file, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                F(file2, file3, false);
            }
        }
        wv wvVar = new wv(file, j);
        if (wvVar.h.exists()) {
            try {
                wvVar.C();
                wvVar.B();
                return wvVar;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                wvVar.close();
                yq1.a(wvVar.g);
            }
        }
        file.mkdirs();
        wv wvVar2 = new wv(file, j);
        wvVar2.E();
        return wvVar2;
    }

    public static void F(File file, File file2, boolean z) throws IOException {
        if (z) {
            h(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void a(wv wvVar, uv uvVar, boolean z) {
        synchronized (wvVar) {
            vv vvVar = (vv) uvVar.i;
            if (vvVar.f != uvVar) {
                throw new IllegalStateException();
            }
            if (z && !vvVar.e) {
                for (int i = 0; i < wvVar.m; i++) {
                    if (!((boolean[]) uvVar.g)[i]) {
                        uvVar.c();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                    if (!vvVar.d[i].exists()) {
                        uvVar.c();
                        return;
                    }
                }
            }
            for (int i2 = 0; i2 < wvVar.m; i2++) {
                File file = vvVar.d[i2];
                if (!z) {
                    h(file);
                } else if (file.exists()) {
                    File file2 = vvVar.c[i2];
                    file.renameTo(file2);
                    long j = vvVar.b[i2];
                    long length = file2.length();
                    vvVar.b[i2] = length;
                    wvVar.n = (wvVar.n - j) + length;
                }
            }
            wvVar.q++;
            vvVar.f = null;
            if (vvVar.e || z) {
                vvVar.e = true;
                wvVar.o.append((CharSequence) "CLEAN");
                wvVar.o.append(' ');
                wvVar.o.append((CharSequence) vvVar.a);
                wvVar.o.append((CharSequence) vvVar.a());
                wvVar.o.append('\n');
                if (z) {
                    wvVar.r++;
                }
            } else {
                wvVar.p.remove(vvVar.a);
                wvVar.o.append((CharSequence) "REMOVE");
                wvVar.o.append(' ');
                wvVar.o.append((CharSequence) vvVar.a);
                wvVar.o.append('\n');
            }
            n(wvVar.o);
            if (wvVar.n > wvVar.l || wvVar.z()) {
                wvVar.s.submit(wvVar.t);
            }
        }
    }

    public static void b(BufferedWriter bufferedWriter) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            bufferedWriter.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            bufferedWriter.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void h(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void n(BufferedWriter bufferedWriter) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            bufferedWriter.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            bufferedWriter.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public final void B() throws IOException {
        h(this.i);
        Iterator it = this.p.values().iterator();
        while (it.hasNext()) {
            vv vvVar = (vv) it.next();
            uv uvVar = vvVar.f;
            int i = this.m;
            int i2 = 0;
            if (uvVar == null) {
                while (i2 < i) {
                    this.n += vvVar.b[i2];
                    i2++;
                }
            } else {
                vvVar.f = null;
                while (i2 < i) {
                    h(vvVar.c[i2]);
                    h(vvVar.d[i2]);
                    i2++;
                }
                it.remove();
            }
        }
    }

    public final void C() {
        File file = this.h;
        xj1 xj1Var = new xj1(new FileInputStream(file), yq1.a);
        try {
            String strA = xj1Var.a();
            String strA2 = xj1Var.a();
            String strA3 = xj1Var.a();
            String strA4 = xj1Var.a();
            String strA5 = xj1Var.a();
            if (!"libcore.io.DiskLruCache".equals(strA) || !"1".equals(strA2) || !Integer.toString(this.k).equals(strA3) || !Integer.toString(this.m).equals(strA4) || !"".equals(strA5)) {
                throw new IOException("unexpected journal header: [" + strA + ", " + strA2 + ", " + strA4 + ", " + strA5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    D(xj1Var.a());
                    i++;
                } catch (EOFException unused) {
                    this.q = i - this.p.size();
                    if (xj1Var.k == -1) {
                        E();
                    } else {
                        this.o = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), yq1.a));
                    }
                    try {
                        xj1Var.close();
                        return;
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                xj1Var.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final void D(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        LinkedHashMap linkedHashMap = this.p;
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                linkedHashMap.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        vv vvVar = (vv) linkedHashMap.get(strSubstring);
        if (vvVar == null) {
            vvVar = new vv(this, strSubstring);
            linkedHashMap.put(strSubstring, vvVar);
        }
        if (iIndexOf2 == -1 || iIndexOf != 5 || !str.startsWith("CLEAN")) {
            if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
                vvVar.f = new uv(this, vvVar);
                return;
            } else {
                if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
        vvVar.e = true;
        vvVar.f = null;
        if (strArrSplit.length != vvVar.g.m) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
        }
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            try {
                vvVar.b[i2] = Long.parseLong(strArrSplit[i2]);
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
            }
        }
    }

    public final synchronized void E() {
        try {
            BufferedWriter bufferedWriter = this.o;
            if (bufferedWriter != null) {
                b(bufferedWriter);
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.i), yq1.a));
            try {
                bufferedWriter2.write("libcore.io.DiskLruCache");
                bufferedWriter2.write("\n");
                bufferedWriter2.write("1");
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.k));
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.m));
                bufferedWriter2.write("\n");
                bufferedWriter2.write("\n");
                for (vv vvVar : this.p.values()) {
                    if (vvVar.f != null) {
                        bufferedWriter2.write("DIRTY " + vvVar.a + '\n');
                    } else {
                        bufferedWriter2.write("CLEAN " + vvVar.a + vvVar.a() + '\n');
                    }
                }
                b(bufferedWriter2);
                if (this.h.exists()) {
                    F(this.h, this.j, true);
                }
                F(this.i, this.h, false);
                this.j.delete();
                this.o = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.h, true), yq1.a));
            } catch (Throwable th) {
                b(bufferedWriter2);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void G() {
        while (this.n > this.l) {
            String str = (String) ((Map.Entry) this.p.entrySet().iterator().next()).getKey();
            synchronized (this) {
                try {
                    if (this.o == null) {
                        throw new IllegalStateException("cache is closed");
                    }
                    vv vvVar = (vv) this.p.get(str);
                    if (vvVar != null && vvVar.f == null) {
                        for (int i = 0; i < this.m; i++) {
                            File file = vvVar.c[i];
                            if (file.exists() && !file.delete()) {
                                throw new IOException("failed to delete " + file);
                            }
                            long j = this.n;
                            long[] jArr = vvVar.b;
                            this.n = j - jArr[i];
                            jArr[i] = 0;
                        }
                        this.q++;
                        this.o.append((CharSequence) "REMOVE");
                        this.o.append(' ');
                        this.o.append((CharSequence) str);
                        this.o.append('\n');
                        this.p.remove(str);
                        if (z()) {
                            this.s.submit(this.t);
                        }
                    }
                } finally {
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.o == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.p.values());
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                uv uvVar = ((vv) obj).f;
                if (uvVar != null) {
                    uvVar.c();
                }
            }
            G();
            b(this.o);
            this.o = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final uv k(String str) {
        synchronized (this) {
            try {
                if (this.o == null) {
                    throw new IllegalStateException("cache is closed");
                }
                vv vvVar = (vv) this.p.get(str);
                if (vvVar == null) {
                    vvVar = new vv(this, str);
                    this.p.put(str, vvVar);
                } else if (vvVar.f != null) {
                    return null;
                }
                uv uvVar = new uv(this, vvVar);
                vvVar.f = uvVar;
                this.o.append((CharSequence) "DIRTY");
                this.o.append(' ');
                this.o.append((CharSequence) str);
                this.o.append('\n');
                n(this.o);
                return uvVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized nx0 r(String str) {
        if (this.o == null) {
            throw new IllegalStateException("cache is closed");
        }
        vv vvVar = (vv) this.p.get(str);
        if (vvVar == null) {
            return null;
        }
        if (!vvVar.e) {
            return null;
        }
        for (File file : vvVar.c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.q++;
        this.o.append((CharSequence) "READ");
        this.o.append(' ');
        this.o.append((CharSequence) str);
        this.o.append('\n');
        if (z()) {
            this.s.submit(this.t);
        }
        return new nx0(vvVar.c, 11);
    }

    public final boolean z() {
        int i = this.q;
        return i >= 2000 && i >= this.p.size();
    }
}
