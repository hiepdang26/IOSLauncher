package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class di0 extends d21 {
    public final Method c;
    public final Method d;
    public final Method e;
    public final Class f;
    public final Class g;

    public di0(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.c = method;
        this.d = method2;
        this.e = method3;
        this.f = cls;
        this.g = cls2;
    }

    @Override // defpackage.d21
    public final void a(SSLSocket sSLSocket) {
        try {
            this.e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AssertionError("failed to remove ALPN", e);
        }
    }

    @Override // defpackage.d21
    public final void g(SSLSocket sSLSocket, String str, List list) {
        try {
            this.c.invoke(null, sSLSocket, Proxy.newProxyInstance(d21.class.getClassLoader(), new Class[]{this.f, this.g}, new ci0(d21.b(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AssertionError("failed to set ALPN", e);
        }
    }

    @Override // defpackage.d21
    public final String j(SSLSocket sSLSocket) {
        try {
            ci0 ci0Var = (ci0) Proxy.getInvocationHandler(this.d.invoke(null, sSLSocket));
            boolean z = ci0Var.b;
            if (!z && ci0Var.c == null) {
                d21.a.m(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                return null;
            }
            if (z) {
                return null;
            }
            return ci0Var.c;
        } catch (IllegalAccessException e) {
            e = e;
            throw new AssertionError("failed to get ALPN selected protocol", e);
        } catch (InvocationTargetException e2) {
            e = e2;
            throw new AssertionError("failed to get ALPN selected protocol", e);
        }
    }
}
