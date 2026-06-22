package defpackage;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes.dex */
public final class tc1 {
    public final c3 a;
    public final Proxy b;
    public final InetSocketAddress c;

    public tc1(c3 c3Var, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (c3Var == null) {
            throw new NullPointerException("address == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.a = c3Var;
        this.b = proxy;
        this.c = inetSocketAddress;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof tc1)) {
            return false;
        }
        tc1 tc1Var = (tc1) obj;
        return tc1Var.a.equals(this.a) && tc1Var.b.equals(this.b) && tc1Var.c.equals(this.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + ((this.a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Route{" + this.c + "}";
    }
}
