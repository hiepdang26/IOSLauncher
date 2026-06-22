package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzbnz implements zzbjm {
    private final zzbzt zza;

    public zzbnz(zzboa zzboaVar, zzbzt zzbztVar) {
        this.zza = zzbztVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final void zza(String str) {
        try {
            if (str == null) {
                this.zza.zzd(new zzbnd());
            } else {
                this.zza.zzd(new zzbnd(str));
            }
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final void zzb(JSONObject jSONObject) {
        try {
            this.zza.zzc(jSONObject);
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zza.zzd(e);
        }
    }
}
