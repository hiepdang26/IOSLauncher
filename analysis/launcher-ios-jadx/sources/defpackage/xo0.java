package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class xo0 extends h2 {
    public final wb1 e;

    public xo0(int i, String str, String str2, h2 h2Var, wb1 wb1Var) {
        super(i, str, str2, h2Var);
        this.e = wb1Var;
    }

    @Override // defpackage.h2
    public final JSONObject b() throws JSONException {
        JSONObject jSONObjectB = super.b();
        wb1 wb1Var = this.e;
        if (wb1Var == null) {
            jSONObjectB.put("Response Info", "null");
            return jSONObjectB;
        }
        jSONObjectB.put("Response Info", wb1Var.a());
        return jSONObjectB;
    }

    @Override // defpackage.h2
    public final String toString() {
        try {
            return b().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }
}
