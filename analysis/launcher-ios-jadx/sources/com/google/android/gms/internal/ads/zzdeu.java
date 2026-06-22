package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzdeu {
    private final List zza;
    private final zzfll zzb;
    private boolean zzc;

    public zzdeu(zzfel zzfelVar, zzfll zzfllVar) {
        this.zza = zzfelVar.zzp;
        this.zzb = zzfllVar;
    }

    public final void zza() {
        if (this.zzc) {
            return;
        }
        this.zzb.zzd(this.zza);
        this.zzc = true;
    }
}
