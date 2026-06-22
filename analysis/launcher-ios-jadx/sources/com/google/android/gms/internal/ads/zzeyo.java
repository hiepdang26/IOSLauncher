package com.google.android.gms.internal.ads;

import android.os.Bundle;
import defpackage.hs0;
import defpackage.k92;
import defpackage.x32;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzeyo implements zzevn {
    private final Bundle zza;

    public zzeyo(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final void zzj(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (this.zza != null) {
            try {
                hs0.x(hs0.x(jSONObject, "device"), "play_store").put("parental_controls", x32.f.a.g(this.zza));
            } catch (JSONException unused) {
                k92.a("Failed putting parental controls bundle.");
            }
        }
    }
}
