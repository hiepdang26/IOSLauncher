package defpackage;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ia1 {
    public final od0 a;
    public final String b;
    public final ob0 c;
    public final la1 d;
    public final Map e;
    public volatile gf f;

    public ia1(ga1 ga1Var) {
        this.a = ga1Var.a;
        this.b = ga1Var.b;
        nb0 nb0Var = ga1Var.c;
        nb0Var.getClass();
        this.c = new ob0(nb0Var);
        this.d = ga1Var.d;
        Map map = ga1Var.e;
        byte[] bArr = wq1.a;
        this.e = map.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public final ga1 a() {
        ga1 ga1Var = new ga1();
        Map linkedHashMap = Collections.EMPTY_MAP;
        ga1Var.e = linkedHashMap;
        ga1Var.a = this.a;
        ga1Var.b = this.b;
        ga1Var.d = this.d;
        Map map = this.e;
        if (!map.isEmpty()) {
            linkedHashMap = new LinkedHashMap(map);
        }
        ga1Var.e = linkedHashMap;
        ga1Var.c = this.c.e();
        return ga1Var;
    }

    public final String toString() {
        return "Request{method=" + this.b + ", url=" + this.a + ", tags=" + this.e + '}';
    }
}
