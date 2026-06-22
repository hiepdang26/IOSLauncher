package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class yl {
    public static final yl e;
    public static final yl f;
    public final boolean a;
    public final boolean b;
    public final String[] c;
    public final String[] d;

    static {
        qi qiVar = qi.q;
        qi qiVar2 = qi.r;
        qi qiVar3 = qi.s;
        qi qiVar4 = qi.k;
        qi qiVar5 = qi.m;
        qi qiVar6 = qi.l;
        qi qiVar7 = qi.n;
        qi qiVar8 = qi.p;
        qi qiVar9 = qi.o;
        qi[] qiVarArr = {qiVar, qiVar2, qiVar3, qiVar4, qiVar5, qiVar6, qiVar7, qiVar8, qiVar9};
        qi[] qiVarArr2 = {qiVar, qiVar2, qiVar3, qiVar4, qiVar5, qiVar6, qiVar7, qiVar8, qiVar9, qi.i, qi.j, qi.g, qi.h, qi.e, qi.f, qi.d};
        xl xlVar = new xl(true);
        xlVar.a(qiVarArr);
        do1 do1Var = do1.TLS_1_3;
        do1 do1Var2 = do1.TLS_1_2;
        xlVar.c(do1Var, do1Var2);
        if (!xlVar.a) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }
        xlVar.d = true;
        new yl(xlVar);
        xl xlVar2 = new xl(true);
        xlVar2.a(qiVarArr2);
        xlVar2.c(do1Var, do1Var2);
        if (!xlVar2.a) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }
        xlVar2.d = true;
        e = new yl(xlVar2);
        xl xlVar3 = new xl(true);
        xlVar3.a(qiVarArr2);
        xlVar3.c(do1Var, do1Var2, do1.TLS_1_1, do1.TLS_1_0);
        if (!xlVar3.a) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }
        xlVar3.d = true;
        new yl(xlVar3);
        f = new yl(new xl(false));
    }

    public yl(xl xlVar) {
        this.a = xlVar.a;
        this.c = xlVar.b;
        this.d = xlVar.c;
        this.b = xlVar.d;
    }

    public final boolean a(SSLSocket sSLSocket) {
        if (!this.a) {
            return false;
        }
        String[] strArr = this.d;
        if (strArr != null && !wq1.n(wq1.i, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.c;
        return strArr2 == null || wq1.n(qi.b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof yl)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        yl ylVar = (yl) obj;
        boolean z = ylVar.a;
        boolean z2 = this.a;
        if (z2 != z) {
            return false;
        }
        if (z2) {
            return Arrays.equals(this.c, ylVar.c) && Arrays.equals(this.d, ylVar.d) && this.b == ylVar.b;
        }
        return true;
    }

    public final int hashCode() {
        if (this.a) {
            return ((((527 + Arrays.hashCode(this.c)) * 31) + Arrays.hashCode(this.d)) * 31) + (!this.b ? 1 : 0);
        }
        return 17;
    }

    public final String toString() {
        List listUnmodifiableList;
        if (!this.a) {
            return "ConnectionSpec()";
        }
        StringBuilder sb = new StringBuilder("ConnectionSpec(cipherSuites=");
        List listUnmodifiableList2 = null;
        String[] strArr = this.c;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(qi.a(str));
            }
            listUnmodifiableList = Collections.unmodifiableList(arrayList);
        } else {
            listUnmodifiableList = null;
        }
        sb.append(Objects.toString(listUnmodifiableList, "[all enabled]"));
        sb.append(", tlsVersions=");
        String[] strArr2 = this.d;
        if (strArr2 != null) {
            ArrayList arrayList2 = new ArrayList(strArr2.length);
            for (String str2 : strArr2) {
                arrayList2.add(do1.a(str2));
            }
            listUnmodifiableList2 = Collections.unmodifiableList(arrayList2);
        }
        sb.append(Objects.toString(listUnmodifiableList2, "[all enabled]"));
        sb.append(", supportsTlsExtensions=");
        sb.append(this.b);
        sb.append(")");
        return sb.toString();
    }
}
