package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class ei0 extends d21 {
    public final Method c;
    public final Method d;

    public ei0(Method method, Method method2) {
        this.c = method;
        this.d = method2;
    }

    @Override // defpackage.d21
    public final void g(SSLSocket sSLSocket, String str, List list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            ArrayList arrayListB = d21.b(list);
            this.c.invoke(sSLParameters, arrayListB.toArray(new String[arrayListB.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AssertionError("failed to set SSL parameters", e);
        }
    }

    @Override // defpackage.d21
    public final String j(SSLSocket sSLSocket) {
        try {
            String str = (String) this.d.invoke(sSLSocket, null);
            if (str != null) {
                if (!str.equals("")) {
                    return str;
                }
            }
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to get ALPN selected protocol", e);
        } catch (InvocationTargetException e2) {
            if (!(e2.getCause() instanceof UnsupportedOperationException)) {
                throw new AssertionError("failed to get ALPN selected protocol", e2);
            }
        }
        return null;
    }
}
