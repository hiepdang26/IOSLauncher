package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzbnr implements zzbjm {
    final /* synthetic */ zzbns zza;
    private final zzbmu zzb;
    private final zzbzt zzc;

    public zzbnr(zzbns zzbnsVar, zzbmu zzbmuVar, zzbzt zzbztVar) {
        this.zza = zzbnsVar;
        this.zzb = zzbmuVar;
        this.zzc = zzbztVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final void zza(String str) {
        try {
            if (str == null) {
                this.zzc.zzd(new zzbnd());
            } else {
                this.zzc.zzd(new zzbnd(str));
            }
        } catch (IllegalStateException unused) {
        } catch (Throwable th) {
            this.zzb.zzb();
            throw th;
        }
        this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final void zzb(JSONObject jSONObject) {
        try {
            try {
                this.zzc.zzc(this.zza.zza.zza(jSONObject));
            } catch (IllegalStateException unused) {
            } catch (JSONException e) {
                this.zzc.zzd(e);
            }
        } finally {
            this.zzb.zzb();
        }
    }
}
