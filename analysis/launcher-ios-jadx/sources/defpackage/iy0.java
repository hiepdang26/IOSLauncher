package defpackage;

import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public final class iy0 implements Cloneable, nf {
    public static final List D = wq1.k(z31.HTTP_2, z31.HTTP_1_1);
    public static final List E = wq1.k(yl.e, yl.f);
    public final int A;
    public final int B;
    public final int C;
    public final ol1 g;
    public final List h;
    public final List i;
    public final List j;
    public final List k;
    public final s9 l;
    public final ProxySelector m;
    public final ka0 n;
    public final SocketFactory o;
    public final SSLSocketFactory p;
    public final p02 q;
    public final hy0 r;
    public final fh s;
    public final s9 t;
    public final s9 u;
    public final ow1 v;
    public final s9 w;
    public final boolean x;
    public final boolean y;
    public final boolean z;

    static {
        ka0.q = new ka0(29);
    }

    public iy0() {
        boolean z;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ol1 ol1Var = new ol1();
        s9 s9Var = new s9();
        ProxySelector ey0Var = ProxySelector.getDefault();
        ey0Var = ey0Var == null ? new ey0() : ey0Var;
        ka0 ka0Var = ka0.i;
        SocketFactory socketFactory = SocketFactory.getDefault();
        hy0 hy0Var = hy0.a;
        fh fhVar = fh.c;
        s9 s9Var2 = s9.g;
        ow1 ow1Var = new ow1(8);
        s9 s9Var3 = s9.h;
        this.g = ol1Var;
        this.h = D;
        List list = E;
        this.i = list;
        this.j = wq1.j(arrayList);
        this.k = wq1.j(arrayList2);
        this.l = s9Var;
        this.m = ey0Var;
        this.n = ka0Var;
        this.o = socketFactory;
        Iterator it = list.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z = z || ((yl) it.next()).a;
            }
        }
        if (z) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers.length == 1) {
                    TrustManager trustManager = trustManagers[0];
                    if (trustManager instanceof X509TrustManager) {
                        X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                        try {
                            d21 d21Var = d21.a;
                            SSLContext sSLContextI = d21Var.i();
                            sSLContextI.init(null, new TrustManager[]{x509TrustManager}, null);
                            this.p = sSLContextI.getSocketFactory();
                            this.q = d21Var.c(x509TrustManager);
                        } catch (GeneralSecurityException e) {
                            throw new AssertionError("No System TLS", e);
                        }
                    }
                }
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            } catch (GeneralSecurityException e2) {
                throw new AssertionError("No System TLS", e2);
            }
        }
        this.p = null;
        this.q = null;
        SSLSocketFactory sSLSocketFactory = this.p;
        if (sSLSocketFactory != null) {
            d21.a.f(sSLSocketFactory);
        }
        this.r = hy0Var;
        p02 p02Var = this.q;
        this.s = Objects.equals(fhVar.b, p02Var) ? fhVar : new fh(fhVar.a, p02Var);
        this.t = s9Var2;
        this.u = s9Var2;
        this.v = ow1Var;
        this.w = s9Var3;
        this.x = true;
        this.y = true;
        this.z = true;
        this.A = 10000;
        this.B = 10000;
        this.C = 10000;
        if (this.j.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.j);
        }
        if (this.k.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.k);
        }
    }
}
