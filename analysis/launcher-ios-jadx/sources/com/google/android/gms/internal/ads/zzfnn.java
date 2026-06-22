package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzfnn {
    private JSONObject zza;
    private final zzfnw zzb;

    public zzfnn(zzfnw zzfnwVar) {
        this.zzb = zzfnwVar;
    }

    public final JSONObject zza() {
        return this.zza;
    }

    public final void zzb() {
        this.zzb.zzb(new zzfnx(this));
    }

    public final void zzc(JSONObject jSONObject, HashSet hashSet, long j) {
        this.zzb.zzb(new zzfny(this, hashSet, jSONObject, j));
    }

    public final void zzd(JSONObject jSONObject, HashSet hashSet, long j) {
        this.zzb.zzb(new zzfnz(this, hashSet, jSONObject, j));
    }

    public final void zze(JSONObject jSONObject) {
        this.zza = jSONObject;
    }
}
