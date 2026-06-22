package defpackage;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class wb1 {
    public final u82 a;
    public final ArrayList b = new ArrayList();
    public final z2 c;

    public wb1(u82 u82Var) {
        this.a = u82Var;
        if (u82Var != null) {
            try {
                List<ed2> listZzj = u82Var.zzj();
                if (listZzj != null) {
                    for (ed2 ed2Var : listZzj) {
                        z2 z2Var = ed2Var != null ? new z2(ed2Var) : null;
                        if (z2Var != null) {
                            this.b.add(z2Var);
                        }
                    }
                }
            } catch (RemoteException unused) {
                k92.f();
            }
        }
        u82 u82Var2 = this.a;
        if (u82Var2 == null) {
            return;
        }
        try {
            ed2 ed2VarZzf = u82Var2.zzf();
            if (ed2VarZzf != null) {
                this.c = new z2(ed2VarZzf);
            }
        } catch (RemoteException unused2) {
            k92.f();
        }
    }

    public final JSONObject a() throws JSONException {
        String strZzi;
        Bundle bundleZze;
        JSONObject jSONObject = new JSONObject();
        u82 u82Var = this.a;
        String strZzg = null;
        if (u82Var != null) {
            try {
                strZzi = u82Var.zzi();
            } catch (RemoteException unused) {
                k92.f();
                strZzi = null;
            }
        } else {
            strZzi = null;
        }
        if (strZzi == null) {
            jSONObject.put("Response ID", "null");
        } else {
            jSONObject.put("Response ID", strZzi);
        }
        if (u82Var != null) {
            try {
                strZzg = u82Var.zzg();
            } catch (RemoteException unused2) {
                k92.f();
            }
        }
        if (strZzg == null) {
            jSONObject.put("Mediation Adapter Class Name", "null");
        } else {
            jSONObject.put("Mediation Adapter Class Name", strZzg);
        }
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            jSONArray.put(((z2) obj).a());
        }
        jSONObject.put("Adapter Responses", jSONArray);
        z2 z2Var = this.c;
        if (z2Var != null) {
            jSONObject.put("Loaded Adapter Response", z2Var.a());
        }
        if (u82Var != null) {
            try {
                bundleZze = u82Var.zze();
            } catch (RemoteException unused3) {
                k92.f();
                bundleZze = new Bundle();
            }
        } else {
            bundleZze = new Bundle();
        }
        if (bundleZze != null) {
            jSONObject.put("Response Extras", x32.f.a.g(bundleZze));
        }
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
