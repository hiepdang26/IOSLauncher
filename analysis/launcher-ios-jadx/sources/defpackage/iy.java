package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.util.Base64;
import com.bumptech.glide.a;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class iy implements xo, qe, mu0, iw, j20, k4, ua1, yo1 {
    public static final /* synthetic */ iy g = new iy();
    public static final iy h = new iy();
    public static final /* synthetic */ iy i = new iy();
    public static final iy j = new iy();
    public static final iy k = new iy();
    public static final Object l = new Object();
    public static iy m;

    public static ByteArrayInputStream h(String str) {
        if (!str.startsWith("data:image")) {
            throw new IllegalArgumentException("Not a valid image data URL.");
        }
        int iIndexOf = str.indexOf(44);
        if (iIndexOf == -1) {
            throw new IllegalArgumentException("Missing comma in data URL.");
        }
        if (str.substring(0, iIndexOf).endsWith(";base64")) {
            return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
        }
        throw new IllegalArgumentException("Not a base64 image data URL.");
    }

    public static iy n(Context context) {
        iy iyVar;
        synchronized (l) {
            try {
                if (m == null) {
                    if (ar1.f) {
                        m = new rq1(context.getApplicationContext());
                    } else if (ar1.m) {
                        m = new qq1(context.getApplicationContext());
                    } else if (ar1.o) {
                        m = new pq1(context.getApplicationContext());
                    } else {
                        m = new iy();
                    }
                }
                iyVar = m;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iyVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0045, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0082, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006c A[EDGE_INSN: B:92:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085], EDGE_INSN: B:93:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085, LOOP_LABEL: LOOP:2: B:47:0x006e->B:58:0x0085]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a2 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean u(defpackage.dz r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.iy.u(dz, android.text.Editable, int, int, boolean):boolean");
    }

    @Override // defpackage.qe
    public Class a() {
        return ByteBuffer.class;
    }

    @Override // defpackage.yo1
    public wo1 c(int i2) {
        return ox0.g;
    }

    @Override // defpackage.j20
    public void d(Object obj) {
        ((List) obj).clear();
    }

    @Override // defpackage.ua1
    public sa1 e(a aVar, wm0 wm0Var, wa1 wa1Var, Context context) {
        return new v90(aVar, wm0Var, wa1Var, context);
    }

    @Override // defpackage.k4
    public boolean g(l4 l4Var, l4 l4Var2, int i2, int i3, int i4) {
        return l4Var.c.b == 1;
    }

    public int k(String str) {
        int iIndexOf;
        if (str.isEmpty() || (iIndexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-".indexOf(str.substring(0, 1).toUpperCase())) == -1) {
            return 36;
        }
        return iIndexOf;
    }

    public String l(int i2) {
        return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-".substring(i2, i2 + 1);
    }

    @Override // defpackage.qe
    public Object m(byte[] bArr) {
        return ByteBuffer.wrap(bArr);
    }

    public long o(jq1 jq1Var) {
        return 0L;
    }

    public Signature[] p(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    public long q(jq1 jq1Var) {
        return 0L;
    }

    public jq1 r(long j2) {
        return jq1.b();
    }

    @Override // defpackage.mu0
    public lu0 s(qm0 qm0Var) {
        return new re(new jl1(10), 0);
    }

    public List t() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(jq1.b());
        return arrayList;
    }

    public boolean v(jq1 jq1Var) {
        return false;
    }

    @Override // defpackage.iw
    public void f() {
    }

    public void i() {
    }

    @Override // defpackage.iw
    public void b(oc ocVar, Bitmap bitmap) {
    }

    public CharSequence j(CharSequence charSequence, jq1 jq1Var) {
        return charSequence;
    }
}
