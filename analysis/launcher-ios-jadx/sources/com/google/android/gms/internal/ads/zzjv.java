package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzjv {
    public zzkx zza;
    public int zzb;
    public boolean zzc;
    public int zzd;
    public boolean zze;
    public int zzf;
    private boolean zzg;

    public zzjv(zzkx zzkxVar) {
        this.zza = zzkxVar;
    }

    public final void zza(int i) {
        this.zzg = 1 == ((this.zzg ? 1 : 0) | i);
        this.zzb += i;
    }

    public final void zzb(int i) {
        this.zzg = true;
        this.zze = true;
        this.zzf = i;
    }

    public final void zzc(zzkx zzkxVar) {
        this.zzg |= this.zza != zzkxVar;
        this.zza = zzkxVar;
    }

    public final void zzd(int i) {
        if (this.zzc && this.zzd != 5) {
            zzdi.zzd(i == 5);
            return;
        }
        this.zzg = true;
        this.zzc = true;
        this.zzd = i;
    }
}
