package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class iv0 extends la1 {
    public static final ks0 e = ks0.a("multipart/mixed");
    public static final ks0 f;
    public static final byte[] g;
    public static final byte[] h;
    public static final byte[] i;
    public final df a;
    public final ks0 b;
    public final List c;
    public long d = -1;

    static {
        ks0.a("multipart/alternative");
        ks0.a("multipart/digest");
        ks0.a("multipart/parallel");
        f = ks0.a("multipart/form-data");
        g = new byte[]{58, 32};
        h = new byte[]{13, 10};
        i = new byte[]{45, 45};
    }

    public iv0(df dfVar, ks0 ks0Var, ArrayList arrayList) {
        this.a = dfVar;
        this.b = ks0.a(ks0Var + "; boundary=" + dfVar.l());
        this.c = wq1.j(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long a(ne neVar, boolean z) {
        fe feVar;
        ne feVar2;
        if (z) {
            feVar2 = new fe();
            feVar = feVar2;
        } else {
            feVar = 0;
            feVar2 = neVar;
        }
        List list = this.c;
        int size = list.size();
        long j = 0;
        int i2 = 0;
        while (true) {
            df dfVar = this.a;
            byte[] bArr = i;
            byte[] bArr2 = h;
            if (i2 >= size) {
                feVar2.m(bArr);
                feVar2.w(dfVar);
                feVar2.m(bArr);
                feVar2.m(bArr2);
                if (!z) {
                    return j;
                }
                long j2 = j + feVar.h;
                feVar.a();
                return j2;
            }
            hv0 hv0Var = (hv0) list.get(i2);
            ob0 ob0Var = hv0Var.a;
            feVar2.m(bArr);
            feVar2.w(dfVar);
            feVar2.m(bArr2);
            if (ob0Var != null) {
                int iG = ob0Var.g();
                for (int i3 = 0; i3 < iG; i3++) {
                    feVar2.t(ob0Var.d(i3)).m(g).t(ob0Var.h(i3)).m(bArr2);
                }
            }
            la1 la1Var = hv0Var.b;
            ks0 ks0VarContentType = la1Var.contentType();
            if (ks0VarContentType != null) {
                feVar2.t("Content-Type: ").t(ks0VarContentType.a).m(bArr2);
            }
            long jContentLength = la1Var.contentLength();
            if (jContentLength != -1) {
                feVar2.t("Content-Length: ").u(jContentLength).m(bArr2);
            } else if (z) {
                feVar.a();
                return -1L;
            }
            feVar2.m(bArr2);
            if (z) {
                j += jContentLength;
            } else {
                la1Var.writeTo(feVar2);
            }
            feVar2.m(bArr2);
            i2++;
        }
    }

    @Override // defpackage.la1
    public final long contentLength() {
        long j = this.d;
        if (j != -1) {
            return j;
        }
        long jA = a(null, true);
        this.d = jA;
        return jA;
    }

    @Override // defpackage.la1
    public final ks0 contentType() {
        return this.b;
    }

    @Override // defpackage.la1
    public final void writeTo(ne neVar) {
        a(neVar, false);
    }
}
