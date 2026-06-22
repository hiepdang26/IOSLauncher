package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import defpackage.hd2;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
final class zzbin implements zzbix {
    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        try {
            JSONArray jSONArray = new JSONArray((String) map.get("args"));
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(zzcejVar.getContext()).edit();
            for (int i = 0; i < jSONArray.length(); i++) {
                editorEdit.remove(jSONArray.getString(i));
            }
            editorEdit.apply();
        } catch (JSONException e) {
            hd2.B.g.zzw(e, "GMSG clear local storage keys handler");
        }
    }
}
