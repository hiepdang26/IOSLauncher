package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzfwy extends zzfwl {
    final /* synthetic */ zzfxa zza;
    private final Object zzb;
    private int zzc;

    public zzfwy(zzfxa zzfxaVar, int i) {
        this.zza = zzfxaVar;
        this.zzb = zzfxa.zzg(zzfxaVar, i);
        this.zzc = i;
    }

    private final void zza() {
        int i = this.zzc;
        if (i == -1 || i >= this.zza.size() || !zzfur.zza(this.zzb, zzfxa.zzg(this.zza, this.zzc))) {
            this.zzc = this.zza.zzw(this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfwl, java.util.Map.Entry
    public final Object getKey() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfwl, java.util.Map.Entry
    public final Object getValue() {
        Map mapZzl = this.zza.zzl();
        if (mapZzl != null) {
            return mapZzl.get(this.zzb);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            return null;
        }
        return zzfxa.zzj(this.zza, i);
    }

    @Override // com.google.android.gms.internal.ads.zzfwl, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Map mapZzl = this.zza.zzl();
        if (mapZzl != null) {
            return mapZzl.put(this.zzb, obj);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            this.zza.put(this.zzb, obj);
            return null;
        }
        zzfxa zzfxaVar = this.zza;
        Object objZzj = zzfxa.zzj(zzfxaVar, i);
        zzfxa.zzn(zzfxaVar, this.zzc, obj);
        return objZzj;
    }
}
