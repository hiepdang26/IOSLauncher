package defpackage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class d21 {
    public static final d21 a;
    public static final Logger b;

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001d  */
    static {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d21.<clinit>():void");
    }

    public static ArrayList b(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            z31 z31Var = (z31) list.get(i);
            if (z31Var != z31.HTTP_1_0) {
                arrayList.add(z31Var.g);
            }
        }
        return arrayList;
    }

    public static byte[] e(List list) {
        fe feVar = new fe();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            z31 z31Var = (z31) list.get(i);
            if (z31Var != z31.HTTP_1_0) {
                feVar.K(z31Var.g.length());
                String str = z31Var.g;
                feVar.O(0, str.length(), str);
            }
        }
        return feVar.j();
    }

    public p02 c(X509TrustManager x509TrustManager) {
        return new tb(d(x509TrustManager));
    }

    public jp1 d(X509TrustManager x509TrustManager) {
        return new vb(x509TrustManager.getAcceptedIssuers());
    }

    public void h(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public SSLContext i() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    public String j(SSLSocket sSLSocket) {
        return null;
    }

    public Object k() {
        if (b.isLoggable(Level.FINE)) {
            return new Throwable("response.body().close()");
        }
        return null;
    }

    public boolean l(String str) {
        return true;
    }

    public void m(int i, String str, Throwable th) {
        b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void n(Object obj, String str) {
        if (obj == null) {
            str = uo.h(str, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        m(5, str, (Throwable) obj);
    }

    public final String toString() {
        return getClass().getSimpleName();
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void f(SSLSocketFactory sSLSocketFactory) {
    }

    public void g(SSLSocket sSLSocket, String str, List list) {
    }
}
