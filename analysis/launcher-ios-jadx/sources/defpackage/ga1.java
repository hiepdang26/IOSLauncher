package defpackage;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ga1 {
    public od0 a;
    public la1 d;
    public Map e = Collections.EMPTY_MAP;
    public String b = "GET";
    public nb0 c = new nb0();

    public final ia1 a() {
        if (this.a != null) {
            return new ia1(this);
        }
        throw new IllegalStateException("url == null");
    }

    public final void b(String str, la1 la1Var) {
        if (str == null) {
            throw new NullPointerException("method == null");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("method.length() == 0");
        }
        if (la1Var != null && !qg0.D(str)) {
            throw new IllegalArgumentException(uo.t("method ", str, " must not have a request body."));
        }
        if (la1Var == null && (str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT"))) {
            throw new IllegalArgumentException(uo.t("method ", str, " must have a request body."));
        }
        this.b = str;
        this.d = la1Var;
    }

    public final void c(String str) {
        this.c.b(str);
    }

    public final void d(Class cls, Object obj) {
        if (cls == null) {
            throw new NullPointerException("type == null");
        }
        if (obj == null) {
            this.e.remove(cls);
            return;
        }
        if (this.e.isEmpty()) {
            this.e = new LinkedHashMap();
        }
        this.e.put(cls, cls.cast(obj));
    }

    public final void e() {
        String str = "http://localhost/".regionMatches(true, 0, "ws:", 0, 3) ? "http:p://localhost/" : "http://localhost/".regionMatches(true, 0, "wss:", 0, 4) ? "https:://localhost/" : "http://localhost/";
        nd0 nd0Var = new nd0();
        nd0Var.b(null, str);
        this.a = nd0Var.a();
    }
}
