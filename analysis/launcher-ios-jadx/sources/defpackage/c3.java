package defpackage;

import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public final class c3 {
    public final od0 a;
    public final s9 b;
    public final SocketFactory c;
    public final s9 d;
    public final List e;
    public final List f;
    public final ProxySelector g;
    public final SSLSocketFactory h;
    public final hy0 i;
    public final fh j;

    public c3(String str, int i, s9 s9Var, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, hy0 hy0Var, fh fhVar, s9 s9Var2, List list, List list2, ProxySelector proxySelector) {
        nd0 nd0Var = new nd0();
        String str2 = sSLSocketFactory != null ? "https" : "http";
        if (str2.equalsIgnoreCase("http")) {
            nd0Var.a = "http";
        } else {
            if (!str2.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(str2));
            }
            nd0Var.a = "https";
        }
        if (str == null) {
            throw new NullPointerException("host == null");
        }
        String strB = wq1.b(od0.g(false, str, 0, str.length()));
        if (strB == null) {
            throw new IllegalArgumentException("unexpected host: ".concat(str));
        }
        nd0Var.d = strB;
        if (i <= 0 || i > 65535) {
            throw new IllegalArgumentException(k31.k(i, "unexpected port: "));
        }
        nd0Var.e = i;
        this.a = nd0Var.a();
        if (s9Var == null) {
            throw new NullPointerException("dns == null");
        }
        this.b = s9Var;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.c = socketFactory;
        if (s9Var2 == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.d = s9Var2;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.e = wq1.j(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f = wq1.j(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.g = proxySelector;
        this.h = sSLSocketFactory;
        this.i = hy0Var;
        this.j = fhVar;
    }

    public final boolean a(c3 c3Var) {
        return this.b.equals(c3Var.b) && this.d.equals(c3Var.d) && this.e.equals(c3Var.e) && this.f.equals(c3Var.f) && this.g.equals(c3Var.g) && Objects.equals(this.h, c3Var.h) && Objects.equals(this.i, c3Var.i) && Objects.equals(this.j, c3Var.j) && this.a.e == c3Var.a.e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c3)) {
            return false;
        }
        c3 c3Var = (c3) obj;
        return this.a.equals(c3Var.a) && a(c3Var);
    }

    public final int hashCode() {
        return Objects.hashCode(this.j) + ((Objects.hashCode(this.i) + ((Objects.hashCode(this.h) + ((this.g.hashCode() + ((this.f.hashCode() + ((this.e.hashCode() + ((this.d.hashCode() + ((this.b.hashCode() + ((this.a.i.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 961)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Address{");
        od0 od0Var = this.a;
        sb.append(od0Var.d);
        sb.append(":");
        sb.append(od0Var.e);
        sb.append(", proxySelector=");
        sb.append(this.g);
        sb.append("}");
        return sb.toString();
    }
}
