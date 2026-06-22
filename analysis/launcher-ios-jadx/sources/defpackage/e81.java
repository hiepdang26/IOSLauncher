package defpackage;

import androidx.appcompat.widget.ActivityChooserView;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public final class e81 extends yc0 {
    public final f81 b;
    public final tc1 c;
    public Socket d;
    public Socket e;
    public fb0 f;
    public z31 g;
    public bd0 h;
    public b81 i;
    public a81 j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public int o = 1;
    public final ArrayList p = new ArrayList();
    public long q = Long.MAX_VALUE;

    public e81(f81 f81Var, tc1 tc1Var) {
        this.b = f81Var;
        this.c = tc1Var;
    }

    @Override // defpackage.yc0
    public final void a(bd0 bd0Var) {
        synchronized (this.b) {
            this.o = bd0Var.h();
        }
    }

    @Override // defpackage.yc0
    public final void b(id0 id0Var) {
        id0Var.c(null, 5);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c0 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(int r10, int r11, int r12, boolean r13, defpackage.iy r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e81.c(int, int, int, boolean, iy):void");
    }

    public final void d(int i, int i2, iy iyVar) throws IOException {
        tc1 tc1Var = this.c;
        Proxy proxy = tc1Var.b;
        InetSocketAddress inetSocketAddress = tc1Var.c;
        this.d = (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) ? tc1Var.a.c.createSocket() : new Socket(proxy);
        iyVar.getClass();
        this.d.setSoTimeout(i2);
        try {
            d21.a.h(this.d, inetSocketAddress, i);
            try {
                this.i = new b81(jy0.b(this.d));
                this.j = new a81(jy0.a(this.d));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + inetSocketAddress);
            connectException.initCause(e2);
            throw connectException;
        }
    }

    public final void e(int i, int i2, int i3, iy iyVar) throws IOException {
        ga1 ga1Var = new ga1();
        tc1 tc1Var = this.c;
        od0 od0Var = tc1Var.a.a;
        if (od0Var == null) {
            throw new NullPointerException("url == null");
        }
        ga1Var.a = od0Var;
        ga1Var.b("CONNECT", null);
        c3 c3Var = tc1Var.a;
        ga1Var.c.c("Host", wq1.i(c3Var.a, true));
        ga1Var.c.c("Proxy-Connection", "Keep-Alive");
        ga1Var.c.c("User-Agent", "okhttp/3.14.9");
        ia1 ia1VarA = ga1Var.a();
        sb1 sb1Var = new sb1();
        sb1Var.a = ia1VarA;
        sb1Var.b = z31.HTTP_1_1;
        sb1Var.c = 407;
        sb1Var.d = "Preemptive Authenticate";
        sb1Var.g = wq1.d;
        sb1Var.k = -1L;
        sb1Var.l = -1L;
        sb1Var.f.c("Proxy-Authenticate", "OkHttp-Preemptive");
        sb1Var.a();
        c3Var.d.getClass();
        d(i, i2, iyVar);
        String str = "CONNECT " + wq1.i(ia1VarA.a, true) + " HTTP/1.1";
        b81 b81Var = this.i;
        pc0 pc0Var = new pc0(null, null, b81Var, this.j);
        yn1 yn1VarTimeout = b81Var.h.timeout();
        long j = i2;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        yn1VarTimeout.g(j);
        this.j.h.timeout().g(i3);
        pc0Var.k(ia1VarA.c, str);
        pc0Var.b();
        sb1 sb1VarE = pc0Var.e(false);
        sb1VarE.a = ia1VarA;
        tb1 tb1VarA = sb1VarE.a();
        long jA = md0.a(tb1VarA);
        if (jA != -1) {
            mc0 mc0VarI = pc0Var.i(jA);
            wq1.p(mc0VarI, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            mc0VarI.close();
        }
        int i4 = tb1VarA.i;
        if (i4 != 200) {
            if (i4 != 407) {
                throw new IOException(k31.k(i4, "Unexpected response code for CONNECT: "));
            }
            c3Var.d.getClass();
            throw new IOException("Failed to authenticate with proxy");
        }
        if (!this.i.g.h() || !this.j.g.h()) {
            throw new IOException("TLS tunnel buffered too many bytes!");
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void f(zl zlVar, iy iyVar) throws Throwable {
        SSLSocket sSLSocket;
        tc1 tc1Var = this.c;
        c3 c3Var = tc1Var.a;
        SSLSocketFactory sSLSocketFactory = c3Var.h;
        z31 z31VarA = z31.HTTP_1_1;
        if (sSLSocketFactory == null) {
            z31 z31Var = z31.H2_PRIOR_KNOWLEDGE;
            if (!c3Var.e.contains(z31Var)) {
                this.e = this.d;
                this.g = z31VarA;
                return;
            } else {
                this.e = this.d;
                this.g = z31Var;
                j();
                return;
            }
        }
        iyVar.getClass();
        c3 c3Var2 = tc1Var.a;
        SSLSocketFactory sSLSocketFactory2 = c3Var2.h;
        od0 od0Var = c3Var2.a;
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) sSLSocketFactory2.createSocket(this.d, od0Var.d, od0Var.e, true);
            } catch (AssertionError e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            yl ylVarA = zlVar.a(sSLSocket);
            String str = od0Var.d;
            boolean z = ylVarA.b;
            if (z) {
                d21.a.g(sSLSocket, str, c3Var2.e);
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            fb0 fb0VarA = fb0.a(session);
            boolean zVerify = c3Var2.i.verify(str, session);
            List list = fb0VarA.c;
            if (zVerify) {
                c3Var2.j.a(str, list);
                String strJ = z ? d21.a.j(sSLSocket) : null;
                this.e = sSLSocket;
                this.i = new b81(jy0.b(sSLSocket));
                this.j = new a81(jy0.a(this.e));
                this.f = fb0VarA;
                if (strJ != null) {
                    z31VarA = z31.a(strJ);
                }
                this.g = z31VarA;
                d21.a.a(sSLSocket);
                if (this.g == z31.HTTP_2) {
                    j();
                    return;
                }
                return;
            }
            if (list.isEmpty()) {
                throw new SSLPeerUnverifiedException("Hostname " + str + " not verified (no certificates)");
            }
            X509Certificate x509Certificate = (X509Certificate) list.get(0);
            throw new SSLPeerUnverifiedException("Hostname " + str + " not verified:\n    certificate: " + fh.b(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + hy0.a(x509Certificate));
        } catch (AssertionError e2) {
            e = e2;
            if (!wq1.m(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                d21.a.a(sSLSocket2);
            }
            wq1.d(sSLSocket2);
            throw th;
        }
    }

    public final boolean g(boolean z) {
        if (!this.e.isClosed() && !this.e.isInputShutdown() && !this.e.isOutputShutdown()) {
            bd0 bd0Var = this.h;
            if (bd0Var == null) {
                if (z) {
                    try {
                        int soTimeout = this.e.getSoTimeout();
                        try {
                            this.e.setSoTimeout(1);
                            return !this.i.a();
                        } finally {
                            this.e.setSoTimeout(soTimeout);
                        }
                    } catch (SocketTimeoutException unused) {
                    } catch (IOException unused2) {
                    }
                }
                return true;
            }
            long jNanoTime = System.nanoTime();
            synchronized (bd0Var) {
                if (bd0Var.m) {
                    return false;
                }
                if (bd0Var.s < bd0Var.r) {
                    if (jNanoTime >= bd0Var.t) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final f10 h(iy0 iy0Var, g81 g81Var) throws SocketException {
        if (this.h != null) {
            return new cd0(iy0Var, this, g81Var, this.h);
        }
        Socket socket = this.e;
        int i = g81Var.h;
        socket.setSoTimeout(i);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.i.h.timeout().g(i);
        this.j.h.timeout().g(g81Var.i);
        return new pc0(iy0Var, this, this.i, this.j);
    }

    public final void i() {
        synchronized (this.b) {
            this.k = true;
        }
    }

    public final void j() throws SocketException {
        this.e.setSoTimeout(0);
        wc0 wc0Var = new wc0();
        wc0Var.l = yc0.a;
        wc0Var.g = true;
        Socket socket = this.e;
        String str = this.c.a.a.d;
        b81 b81Var = this.i;
        a81 a81Var = this.j;
        wc0Var.h = socket;
        wc0Var.i = str;
        wc0Var.j = b81Var;
        wc0Var.k = a81Var;
        wc0Var.l = this;
        bd0 bd0Var = new bd0(wc0Var);
        this.h = bd0Var;
        jd0 jd0Var = bd0Var.z;
        synchronized (jd0Var) {
            try {
                if (jd0Var.k) {
                    throw new IOException("closed");
                }
                if (jd0Var.h) {
                    Logger logger = jd0.m;
                    if (logger.isLoggable(Level.FINE)) {
                        String strE = qc0.a.e();
                        byte[] bArr = wq1.a;
                        Locale locale = Locale.US;
                        logger.fine(">> CONNECTION " + strE);
                    }
                    jd0Var.g.m((byte[]) qc0.a.g.clone());
                    jd0Var.g.flush();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        bd0Var.z.A(bd0Var.w);
        if (bd0Var.w.e() != 65535) {
            bd0Var.z.B(0, r0 - 65535);
        }
        new Thread(bd0Var.A).start();
    }

    public final boolean k(od0 od0Var) {
        int i = od0Var.e;
        od0 od0Var2 = this.c.a.a;
        if (i == od0Var2.e) {
            String str = od0Var.d;
            if (str.equals(od0Var2.d)) {
                return true;
            }
            fb0 fb0Var = this.f;
            if (fb0Var != null && hy0.c(str, (X509Certificate) fb0Var.c.get(0))) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        tc1 tc1Var = this.c;
        sb.append(tc1Var.a.a.d);
        sb.append(":");
        sb.append(tc1Var.a.a.e);
        sb.append(", proxy=");
        sb.append(tc1Var.b);
        sb.append(" hostAddress=");
        sb.append(tc1Var.c);
        sb.append(" cipherSuite=");
        fb0 fb0Var = this.f;
        sb.append(fb0Var != null ? fb0Var.b : "none");
        sb.append(" protocol=");
        sb.append(this.g);
        sb.append('}');
        return sb.toString();
    }
}
