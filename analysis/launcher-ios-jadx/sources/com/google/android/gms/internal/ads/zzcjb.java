package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcjb {
    private zzcgm zza;
    private zzcko zzb;
    private zzfjp zzc;
    private zzcla zzd;
    private zzfgj zze;

    private zzcjb() {
        throw null;
    }

    public final zzcgj zza() {
        zzhfk.zzc(this.zza, zzcgm.class);
        zzhfk.zzc(this.zzb, zzcko.class);
        if (this.zzc == null) {
            this.zzc = new zzfjp();
        }
        if (this.zzd == null) {
            this.zzd = new zzcla();
        }
        if (this.zze == null) {
            this.zze = new zzfgj();
        }
        return new zzcif(this.zza, this.zzb, this.zzc, this.zzd, this.zze, null);
    }

    public final zzcjb zzb(zzcgm zzcgmVar) {
        this.zza = zzcgmVar;
        return this;
    }

    public final zzcjb zzc(zzcko zzckoVar) {
        this.zzb = zzckoVar;
        return this;
    }

    public /* synthetic */ zzcjb(zzcja zzcjaVar) {
    }
}
