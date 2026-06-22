package defpackage;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class mv {
    public long a;
    public final String b;
    public final String c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final List h;

    public mv(String str, String str2, long j, long j2, long j3, long j4, List list) {
        this.b = str;
        this.c = "".equals(str2) ? null : str2;
        this.d = j;
        this.e = j2;
        this.f = j3;
        this.g = j4;
        this.h = list;
    }

    public static mv a(nv nvVar) throws IOException {
        if (ov.i(nvVar) != 538247942) {
            throw new IOException();
        }
        String strK = ov.k(nvVar);
        String strK2 = ov.k(nvVar);
        long j = ov.j(nvVar);
        long j2 = ov.j(nvVar);
        long j3 = ov.j(nvVar);
        long j4 = ov.j(nvVar);
        int i = ov.i(nvVar);
        if (i < 0) {
            throw new IOException(k31.k(i, "readHeaderList size="));
        }
        List arrayList = i == 0 ? Collections.EMPTY_LIST : new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new jb0(ov.k(nvVar).intern(), ov.k(nvVar).intern()));
        }
        return new mv(strK, strK2, j, j2, j3, j4, arrayList);
    }

    public final ef b(byte[] bArr) {
        ef efVar = new ef();
        efVar.a = bArr;
        efVar.b = this.c;
        efVar.c = this.d;
        efVar.d = this.e;
        efVar.e = this.f;
        efVar.f = this.g;
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        List<jb0> list = this.h;
        for (jb0 jb0Var : list) {
            treeMap.put(jb0Var.a, jb0Var.b);
        }
        efVar.g = treeMap;
        efVar.h = Collections.unmodifiableList(list);
        return efVar;
    }

    public final boolean c(BufferedOutputStream bufferedOutputStream) {
        try {
            ov.n(bufferedOutputStream, 538247942);
            ov.p(bufferedOutputStream, this.b);
            String str = this.c;
            if (str == null) {
                str = "";
            }
            ov.p(bufferedOutputStream, str);
            ov.o(bufferedOutputStream, this.d);
            ov.o(bufferedOutputStream, this.e);
            ov.o(bufferedOutputStream, this.f);
            ov.o(bufferedOutputStream, this.g);
            List<jb0> list = this.h;
            if (list != null) {
                ov.n(bufferedOutputStream, list.size());
                for (jb0 jb0Var : list) {
                    ov.p(bufferedOutputStream, jb0Var.a);
                    ov.p(bufferedOutputStream, jb0Var.b);
                }
            } else {
                ov.n(bufferedOutputStream, 0);
            }
            bufferedOutputStream.flush();
            return true;
        } catch (IOException e) {
            gv1.a("%s", e.toString());
            return false;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.util.List] */
    public mv(String str, ef efVar) {
        String str2 = efVar.b;
        long j = efVar.c;
        long j2 = efVar.d;
        long j3 = efVar.e;
        long j4 = efVar.f;
        ?? arrayList = efVar.h;
        if (arrayList == 0) {
            Map map = efVar.g;
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new jb0((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(str, str2, j, j2, j3, j4, arrayList);
    }
}
