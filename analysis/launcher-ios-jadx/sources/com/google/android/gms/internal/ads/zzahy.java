package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzahy {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    private final boolean zze;
    private final zzek zzf;
    private final zzek zzg;
    private int zzh;
    private int zzi;

    public zzahy(zzek zzekVar, zzek zzekVar2, boolean z) throws zzbo {
        this.zzg = zzekVar;
        this.zzf = zzekVar2;
        this.zze = z;
        zzekVar2.zzK(12);
        this.zza = zzekVar2.zzp();
        zzekVar.zzK(12);
        this.zzi = zzekVar.zzp();
        zzaco.zzb(zzekVar.zzg() == 1, "first_chunk must be 1");
        this.zzb = -1;
    }

    public final boolean zza() {
        int i = this.zzb + 1;
        this.zzb = i;
        if (i == this.zza) {
            return false;
        }
        this.zzd = this.zze ? this.zzf.zzv() : this.zzf.zzu();
        if (this.zzb == this.zzh) {
            this.zzc = this.zzg.zzp();
            this.zzg.zzL(4);
            int i2 = this.zzi - 1;
            this.zzi = i2;
            this.zzh = i2 > 0 ? (-1) + this.zzg.zzp() : -1;
        }
        return true;
    }
}
