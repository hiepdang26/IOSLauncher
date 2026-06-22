package defpackage;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class u4 extends d21 {
    public final Class c;
    public final Method d;
    public final Method e;
    public final Method f;
    public final Method g;
    public final s4 h;

    public u4(Class cls, Method method, Method method2, Method method3, Method method4) throws NoSuchMethodException {
        Method method5;
        Method method6;
        Method method7 = null;
        try {
            Class<?> cls2 = Class.forName("dalvik.system.CloseGuard");
            Method method8 = cls2.getMethod("get", null);
            method6 = cls2.getMethod("open", String.class);
            method5 = cls2.getMethod("warnIfOpen", null);
            method7 = method8;
        } catch (Exception unused) {
            method5 = null;
            method6 = null;
        }
        this.h = new s4(method7, method6, method5);
        this.c = cls;
        this.d = method;
        this.e = method2;
        this.f = method3;
        this.g = method4;
    }

    public static boolean o(String str, Class cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            try {
                return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", null).invoke(obj, null)).booleanValue();
            } catch (NoSuchMethodException unused2) {
                return true;
            }
        }
    }

    @Override // defpackage.d21
    public final p02 c(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new r4(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.c(x509TrustManager);
        }
    }

    @Override // defpackage.d21
    public final jp1 d(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new t4(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.d(x509TrustManager);
        }
    }

    @Override // defpackage.d21
    public void g(SSLSocket sSLSocket, String str, List list) {
        if (this.c.isInstance(sSLSocket)) {
            if (str != null) {
                try {
                    this.d.invoke(sSLSocket, Boolean.TRUE);
                    this.e.invoke(sSLSocket, str);
                } catch (IllegalAccessException e) {
                    e = e;
                    throw new AssertionError(e);
                } catch (InvocationTargetException e2) {
                    e = e2;
                    throw new AssertionError(e);
                }
            }
            this.g.invoke(sSLSocket, d21.e(list));
        }
    }

    @Override // defpackage.d21
    public final void h(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!wq1.m(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e2;
            }
            throw new IOException("Exception in connect", e2);
        }
    }

    @Override // defpackage.d21
    public final SSLContext i() {
        if (Build.VERSION.SDK_INT < 22) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    @Override // defpackage.d21
    public String j(SSLSocket sSLSocket) {
        if (this.c.isInstance(sSLSocket)) {
            try {
                byte[] bArr = (byte[]) this.f.invoke(sSLSocket, null);
                if (bArr != null) {
                    return new String(bArr, StandardCharsets.UTF_8);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new AssertionError(e);
            }
        }
        return null;
    }

    @Override // defpackage.d21
    public final Object k() {
        s4 s4Var = this.h;
        Method method = s4Var.a;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(null, null);
                s4Var.b.invoke(objInvoke, "response.body().close()");
                return objInvoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // defpackage.d21
    public final boolean l(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return o(str, cls, cls.getMethod("getInstance", null).invoke(null, null));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return true;
        } catch (IllegalAccessException e) {
            e = e;
            throw new AssertionError("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw new AssertionError("unable to determine cleartext support", e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new AssertionError("unable to determine cleartext support", e);
        }
    }

    @Override // defpackage.d21
    public final void m(int i, String str, Throwable th) {
        int iMin;
        int i2 = i != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int iIndexOf = str.indexOf(10, i3);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i3 = iMin;
                }
            }
            i3 = iMin + 1;
        }
    }

    @Override // defpackage.d21
    public final void n(Object obj, String str) {
        s4 s4Var = this.h;
        s4Var.getClass();
        if (obj != null) {
            try {
                s4Var.c.invoke(obj, null);
                return;
            } catch (Exception unused) {
            }
        }
        m(5, str, null);
    }
}
