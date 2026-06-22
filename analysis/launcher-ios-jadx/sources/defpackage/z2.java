package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class z2 {
    public final ed2 a;
    public final h2 b;

    public z2(ed2 ed2Var) {
        this.a = ed2Var;
        j92 j92Var = ed2Var.i;
        this.b = j92Var == null ? null : j92Var.a();
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ed2 ed2Var = this.a;
        jSONObject.put("Adapter", ed2Var.g);
        jSONObject.put("Latency", ed2Var.h);
        String str = ed2Var.k;
        if (str == null) {
            jSONObject.put("Ad Source Name", "null");
        } else {
            jSONObject.put("Ad Source Name", str);
        }
        String str2 = ed2Var.l;
        if (str2 == null) {
            jSONObject.put("Ad Source ID", "null");
        } else {
            jSONObject.put("Ad Source ID", str2);
        }
        String str3 = ed2Var.m;
        if (str3 == null) {
            jSONObject.put("Ad Source Instance Name", "null");
        } else {
            jSONObject.put("Ad Source Instance Name", str3);
        }
        String str4 = ed2Var.n;
        if (str4 == null) {
            jSONObject.put("Ad Source Instance ID", "null");
        } else {
            jSONObject.put("Ad Source Instance ID", str4);
        }
        JSONObject jSONObject2 = new JSONObject();
        for (String str5 : ed2Var.j.keySet()) {
            jSONObject2.put(str5, ed2Var.j.get(str5));
        }
        jSONObject.put("Credentials", jSONObject2);
        h2 h2Var = this.b;
        if (h2Var == null) {
            jSONObject.put("Ad Error", "null");
            return jSONObject;
        }
        jSONObject.put("Ad Error", h2Var.b());
        return jSONObject;
    }

    public final String toString() {
        try {
            return a().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }
}
