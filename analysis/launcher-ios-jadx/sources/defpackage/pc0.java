package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;

/* JADX INFO: loaded from: classes.dex */
public final class pc0 implements f10 {
    public final iy0 a;
    public final e81 b;
    public final b81 c;
    public final a81 d;
    public int e = 0;
    public long f = 262144;

    public pc0(iy0 iy0Var, e81 e81Var, b81 b81Var, a81 a81Var) {
        this.a = iy0Var;
        this.b = e81Var;
        this.c = b81Var;
        this.d = a81Var;
    }

    @Override // defpackage.f10
    public final fi1 a(tb1 tb1Var) {
        if (!md0.b(tb1Var)) {
            return i(0L);
        }
        if ("chunked".equalsIgnoreCase(tb1Var.a("Transfer-Encoding"))) {
            od0 od0Var = tb1Var.g.a;
            if (this.e == 4) {
                this.e = 5;
                return new lc0(this, od0Var);
            }
            throw new IllegalStateException("state: " + this.e);
        }
        long jA = md0.a(tb1Var);
        if (jA != -1) {
            return i(jA);
        }
        if (this.e == 4) {
            this.e = 5;
            this.b.i();
            return new oc0(this);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    @Override // defpackage.f10
    public final void b() {
        this.d.flush();
    }

    @Override // defpackage.f10
    public final void c() {
        this.d.flush();
    }

    @Override // defpackage.f10
    public final void cancel() {
        e81 e81Var = this.b;
        if (e81Var != null) {
            wq1.d(e81Var.d);
        }
    }

    @Override // defpackage.f10
    public final ih1 d(ia1 ia1Var, long j) throws ProtocolException {
        la1 la1Var = ia1Var.d;
        if (la1Var != null && la1Var.isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if ("chunked".equalsIgnoreCase(ia1Var.c.c("Transfer-Encoding"))) {
            if (this.e == 1) {
                this.e = 2;
                return new kc0(this);
            }
            throw new IllegalStateException("state: " + this.e);
        }
        if (j == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        if (this.e == 1) {
            this.e = 2;
            return new nc0(this);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    @Override // defpackage.f10
    public final sb1 e(boolean z) {
        int i = this.e;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.e);
        }
        try {
            String strA = this.c.A(this.f);
            this.f -= (long) strA.length();
            xk xkVarC = xk.c(strA);
            int i2 = xkVarC.b;
            sb1 sb1Var = new sb1();
            sb1Var.b = (z31) xkVarC.c;
            sb1Var.c = i2;
            sb1Var.d = (String) xkVarC.d;
            sb1Var.f = j().e();
            if (z && i2 == 100) {
                return null;
            }
            if (i2 == 100) {
                this.e = 3;
                return sb1Var;
            }
            this.e = 4;
            return sb1Var;
        } catch (EOFException e) {
            e81 e81Var = this.b;
            throw new IOException("unexpected end of stream on " + (e81Var != null ? e81Var.c.a.a.k() : "unknown"), e);
        }
    }

    @Override // defpackage.f10
    public final long f(tb1 tb1Var) {
        if (!md0.b(tb1Var)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(tb1Var.a("Transfer-Encoding"))) {
            return -1L;
        }
        return md0.a(tb1Var);
    }

    @Override // defpackage.f10
    public final void g(ia1 ia1Var) {
        Proxy.Type type = this.b.c.b.type();
        StringBuilder sb = new StringBuilder();
        sb.append(ia1Var.b);
        sb.append(' ');
        od0 od0Var = ia1Var.a;
        if (od0Var.a.equals("https") || type != Proxy.Type.HTTP) {
            int length = od0Var.a.length() + 3;
            String str = od0Var.i;
            int iIndexOf = str.indexOf(47, length);
            String strSubstring = str.substring(iIndexOf, wq1.g(iIndexOf, str.length(), str, "?#"));
            String strE = od0Var.e();
            if (strE != null) {
                strSubstring = strSubstring + '?' + strE;
            }
            sb.append(strSubstring);
        } else {
            sb.append(od0Var);
        }
        sb.append(" HTTP/1.1");
        k(ia1Var.c, sb.toString());
    }

    @Override // defpackage.f10
    public final e81 h() {
        return this.b;
    }

    public final mc0 i(long j) {
        if (this.e == 4) {
            this.e = 5;
            return new mc0(this, j);
        }
        throw new IllegalStateException("state: " + this.e);
    }

    public final ob0 j() throws EOFException {
        nb0 nb0Var = new nb0();
        while (true) {
            String strA = this.c.A(this.f);
            this.f -= (long) strA.length();
            if (strA.length() == 0) {
                return new ob0(nb0Var);
            }
            ka0.q.getClass();
            int iIndexOf = strA.indexOf(":", 1);
            if (iIndexOf != -1) {
                nb0Var.a(strA.substring(0, iIndexOf), strA.substring(iIndexOf + 1));
            } else if (strA.startsWith(":")) {
                nb0Var.a("", strA.substring(1));
            } else {
                nb0Var.a("", strA);
            }
        }
    }

    public final void k(ob0 ob0Var, String str) {
        if (this.e != 0) {
            throw new IllegalStateException("state: " + this.e);
        }
        a81 a81Var = this.d;
        a81Var.t(str);
        a81Var.t("\r\n");
        int iG = ob0Var.g();
        for (int i = 0; i < iG; i++) {
            a81Var.t(ob0Var.d(i));
            a81Var.t(": ");
            a81Var.t(ob0Var.h(i));
            a81Var.t("\r\n");
        }
        a81Var.t("\r\n");
        this.e = 1;
    }
}
