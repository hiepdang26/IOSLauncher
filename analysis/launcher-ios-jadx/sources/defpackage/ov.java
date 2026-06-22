package defpackage;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ov {
    public final oz1 c;
    public final LinkedHashMap a = new LinkedHashMap(16, 0.75f, true);
    public long b = 0;
    public final int d = 5242880;

    public ov(oz1 oz1Var) {
        this.c = oz1Var;
    }

    public static String c(String str) {
        int length = str.length() / 2;
        StringBuilder sbM = uo.m(String.valueOf(str.substring(0, length).hashCode()));
        sbM.append(String.valueOf(str.substring(length).hashCode()));
        return sbM.toString();
    }

    public static int h(nv nvVar) throws IOException {
        int i = nvVar.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    public static int i(nv nvVar) {
        return (h(nvVar) << 24) | h(nvVar) | (h(nvVar) << 8) | (h(nvVar) << 16);
    }

    public static long j(nv nvVar) {
        return (((long) h(nvVar)) & 255) | ((((long) h(nvVar)) & 255) << 8) | ((((long) h(nvVar)) & 255) << 16) | ((((long) h(nvVar)) & 255) << 24) | ((((long) h(nvVar)) & 255) << 32) | ((((long) h(nvVar)) & 255) << 40) | ((((long) h(nvVar)) & 255) << 48) | ((255 & ((long) h(nvVar))) << 56);
    }

    public static String k(nv nvVar) {
        return new String(m(nvVar, j(nvVar)), "UTF-8");
    }

    public static byte[] m(nv nvVar, long j) throws IOException {
        long j2 = nvVar.g - nvVar.h;
        if (j >= 0 && j <= j2) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(nvVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + j2);
    }

    public static void n(BufferedOutputStream bufferedOutputStream, int i) {
        bufferedOutputStream.write(i & 255);
        bufferedOutputStream.write((i >> 8) & 255);
        bufferedOutputStream.write((i >> 16) & 255);
        bufferedOutputStream.write((i >> 24) & 255);
    }

    public static void o(BufferedOutputStream bufferedOutputStream, long j) {
        bufferedOutputStream.write((byte) j);
        bufferedOutputStream.write((byte) (j >>> 8));
        bufferedOutputStream.write((byte) (j >>> 16));
        bufferedOutputStream.write((byte) (j >>> 24));
        bufferedOutputStream.write((byte) (j >>> 32));
        bufferedOutputStream.write((byte) (j >>> 40));
        bufferedOutputStream.write((byte) (j >>> 48));
        bufferedOutputStream.write((byte) (j >>> 56));
    }

    public static void p(BufferedOutputStream bufferedOutputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        o(bufferedOutputStream, bytes.length);
        bufferedOutputStream.write(bytes, 0, bytes.length);
    }

    public final synchronized ef a(String str) {
        mv mvVar = (mv) this.a.get(str);
        if (mvVar == null) {
            return null;
        }
        File fileB = b(str);
        try {
            nv nvVar = new nv(new BufferedInputStream(new FileInputStream(fileB)), fileB.length());
            try {
                mv mvVarA = mv.a(nvVar);
                if (TextUtils.equals(str, mvVarA.b)) {
                    return mvVar.b(m(nvVar, nvVar.g - nvVar.h));
                }
                gv1.a("%s: key=%s, found=%s", fileB.getAbsolutePath(), str, mvVarA.b);
                mv mvVar2 = (mv) this.a.remove(str);
                if (mvVar2 != null) {
                    this.b -= mvVar2.a;
                }
                return null;
            } finally {
                nvVar.close();
            }
        } catch (IOException e) {
            gv1.a("%s: %s", fileB.getAbsolutePath(), e.toString());
            l(str);
            return null;
        }
    }

    public final File b(String str) {
        return new File(this.c.c(), c(str));
    }

    public final synchronized void d() {
        synchronized (this) {
            File fileC = this.c.c();
            if (!fileC.exists()) {
                if (!fileC.mkdirs()) {
                    gv1.a("Unable to create cache dir %s", fileC.getAbsolutePath());
                }
                return;
            }
            File[] fileArrListFiles = fileC.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            for (File file : fileArrListFiles) {
                try {
                    long length = file.length();
                    nv nvVar = new nv(new BufferedInputStream(new FileInputStream(file)), length);
                    try {
                        mv mvVarA = mv.a(nvVar);
                        mvVarA.a = length;
                        g(mvVarA.b, mvVarA);
                        nvVar.close();
                    } catch (Throwable th) {
                        nvVar.close();
                        throw th;
                    }
                } catch (IOException unused) {
                    file.delete();
                }
            }
        }
    }

    public final void e() {
        long j = this.b;
        int i = this.d;
        if (j < i) {
            return;
        }
        if (gv1.a) {
            gv1.b("Pruning old cache entries.", new Object[0]);
        }
        long j2 = this.b;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator it = this.a.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            mv mvVar = (mv) ((Map.Entry) it.next()).getValue();
            if (b(mvVar.b).delete()) {
                this.b -= mvVar.a;
            } else {
                String str = mvVar.b;
                gv1.a("Could not delete cache entry for key=%s, filename=%s", str, c(str));
            }
            it.remove();
            i2++;
            if (this.b < i * 0.9f) {
                break;
            }
        }
        if (gv1.a) {
            gv1.b("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.b - j2), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    public final synchronized void f(String str, ef efVar) {
        BufferedOutputStream bufferedOutputStream;
        mv mvVar;
        long length = this.b + ((long) efVar.a.length);
        int i = this.d;
        if (length <= i || r4.length <= i * 0.9f) {
            File fileB = b(str);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileB));
                mvVar = new mv(str, efVar);
            } catch (IOException unused) {
                if (!fileB.delete()) {
                    gv1.a("Could not clean up file %s", fileB.getAbsolutePath());
                }
                if (!this.c.c().exists()) {
                    gv1.a("Re-initializing cache after external clearing.", new Object[0]);
                    this.a.clear();
                    this.b = 0L;
                    d();
                }
            }
            if (!mvVar.c(bufferedOutputStream)) {
                bufferedOutputStream.close();
                gv1.a("Failed to write header for %s", fileB.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(efVar.a);
            bufferedOutputStream.close();
            mvVar.a = fileB.length();
            g(str, mvVar);
            e();
        }
    }

    public final void g(String str, mv mvVar) {
        LinkedHashMap linkedHashMap = this.a;
        if (linkedHashMap.containsKey(str)) {
            this.b = (mvVar.a - ((mv) linkedHashMap.get(str)).a) + this.b;
        } else {
            this.b += mvVar.a;
        }
        linkedHashMap.put(str, mvVar);
    }

    public final synchronized void l(String str) {
        boolean zDelete = b(str).delete();
        mv mvVar = (mv) this.a.remove(str);
        if (mvVar != null) {
            this.b -= mvVar.a;
        }
        if (!zDelete) {
            gv1.a("Could not delete cache entry for key=%s, filename=%s", str, c(str));
        }
    }
}
