package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzqb {
    private final Context zza;
    private final zzof zzb;
    private boolean zzc;
    private final zzqa zzd;
    private zzqd zze;
    private zzpt zzf;

    @Deprecated
    public zzqb() {
        this.zza = null;
        this.zzb = zzof.zza;
        this.zzd = zzqa.zza;
    }

    public final zzqp zzc() {
        zzdi.zzf(!this.zzc);
        this.zzc = true;
        if (this.zze == null) {
            this.zze = new zzqd(new zzct[0]);
        }
        if (this.zzf == null) {
            this.zzf = new zzpt(this.zza);
        }
        return new zzqp(this, null);
    }

    public zzqb(Context context) {
        this.zza = context;
        this.zzb = zzof.zza;
        this.zzd = zzqa.zza;
    }
}
