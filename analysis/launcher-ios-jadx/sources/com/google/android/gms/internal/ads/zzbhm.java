package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.hs0;
import defpackage.k92;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbhm implements zzbix {
    private final zzbhn zza;

    public zzbhm(zzbhn zzbhnVar) {
        this.zza = zzbhnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final void zza(Object obj, Map map) {
        if (this.zza == null) {
            return;
        }
        String str = (String) map.get("name");
        if (str == null) {
            k92.g("Ad metadata with no name parameter.");
            str = "";
        }
        Bundle bundleT = null;
        if (map.containsKey("info")) {
            try {
                bundleT = hs0.t(new JSONObject((String) map.get("info")));
            } catch (JSONException unused) {
                k92.f();
            }
        }
        if (bundleT == null) {
            k92.e("Failed to convert ad metadata to Bundle.");
        } else {
            this.zza.zza(str, bundleT);
        }
    }
}
