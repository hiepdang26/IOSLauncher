package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h2 {
    public final int a;
    public final String b;
    public final String c;
    public final h2 d;

    public h2(int i, String str, String str2, h2 h2Var) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = h2Var;
    }

    public final j92 a() {
        h2 h2Var = this.d;
        return new j92(this.a, this.b, this.c, h2Var == null ? null : new j92(h2Var.a, h2Var.b, h2Var.c, null, null), null);
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Code", this.a);
        jSONObject.put("Message", this.b);
        jSONObject.put("Domain", this.c);
        h2 h2Var = this.d;
        if (h2Var == null) {
            jSONObject.put("Cause", "null");
            return jSONObject;
        }
        jSONObject.put("Cause", h2Var.b());
        return jSONObject;
    }

    public String toString() {
        try {
            return b().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }
}
