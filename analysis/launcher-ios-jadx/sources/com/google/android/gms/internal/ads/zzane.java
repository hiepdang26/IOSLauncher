package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzane {
    private final zzamf zza;
    private final zzer zzb;
    private final zzej zzc = new zzej(new byte[64], 64);
    private boolean zzd;
    private boolean zze;
    private boolean zzf;

    public zzane(zzamf zzamfVar, zzer zzerVar) {
        this.zza = zzamfVar;
        this.zzb = zzerVar;
    }

    public final void zza(zzek zzekVar) {
        long jZzb;
        char c;
        zzekVar.zzG(this.zzc.zza, 0, 3);
        this.zzc.zzl(0);
        this.zzc.zzn(8);
        this.zzd = this.zzc.zzp();
        this.zze = this.zzc.zzp();
        this.zzc.zzn(6);
        zzej zzejVar = this.zzc;
        zzekVar.zzG(zzejVar.zza, 0, zzejVar.zzd(8));
        this.zzc.zzl(0);
        if (this.zzd) {
            this.zzc.zzn(4);
            long jZzd = this.zzc.zzd(3);
            this.zzc.zzn(1);
            int iZzd = this.zzc.zzd(15) << 15;
            this.zzc.zzn(1);
            long jZzd2 = this.zzc.zzd(15);
            this.zzc.zzn(1);
            if (this.zzf || !this.zze) {
                c = 30;
            } else {
                this.zzc.zzn(4);
                long jZzd3 = ((long) this.zzc.zzd(3)) << 30;
                this.zzc.zzn(1);
                int iZzd2 = this.zzc.zzd(15) << 15;
                this.zzc.zzn(1);
                long jZzd4 = this.zzc.zzd(15);
                this.zzc.zzn(1);
                c = 30;
                this.zzb.zzb(jZzd3 | ((long) iZzd2) | jZzd4);
                this.zzf = true;
            }
            jZzb = this.zzb.zzb((jZzd << c) | ((long) iZzd) | jZzd2);
        } else {
            jZzb = 0;
        }
        this.zza.zzd(jZzb, 4);
        this.zza.zza(zzekVar);
        this.zza.zzc(false);
    }

    public final void zzb() {
        this.zzf = false;
        this.zza.zze();
    }
}
