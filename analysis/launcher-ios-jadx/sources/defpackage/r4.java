package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes.dex */
public final class r4 extends p02 {
    public final Object m;
    public final Method n;

    public r4(Object obj, Method method) {
        this.m = obj;
        this.n = method;
    }

    @Override // defpackage.p02
    public final List c(String str, List list) throws SSLPeerUnverifiedException {
        try {
            return (List) this.n.invoke(this.m, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
            sSLPeerUnverifiedException.initCause(e2);
            throw sSLPeerUnverifiedException;
        }
    }

    public final boolean equals(Object obj) {
        return obj instanceof r4;
    }

    public final int hashCode() {
        return 0;
    }
}
