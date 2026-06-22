package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public final class t4 implements jp1 {
    public final X509TrustManager a;
    public final Method b;

    public t4(X509TrustManager x509TrustManager, Method method) {
        this.b = method;
        this.a = x509TrustManager;
    }

    @Override // defpackage.jp1
    public final X509Certificate a(X509Certificate x509Certificate) {
        try {
            TrustAnchor trustAnchor = (TrustAnchor) this.b.invoke(this.a, x509Certificate);
            if (trustAnchor != null) {
                return trustAnchor.getTrustedCert();
            }
        } catch (IllegalAccessException e) {
            throw new AssertionError("unable to get issues and signature", e);
        } catch (InvocationTargetException unused) {
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t4)) {
            return false;
        }
        t4 t4Var = (t4) obj;
        return this.a.equals(t4Var.a) && this.b.equals(t4Var.b);
    }

    public final int hashCode() {
        return (this.b.hashCode() * 31) + this.a.hashCode();
    }
}
