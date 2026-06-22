package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzkh {
    public final zzug zza;
    public final Object zzb;
    public final zzvx[] zzc;
    public boolean zzd;
    public boolean zze;
    public zzki zzf;
    public boolean zzg;
    private final boolean[] zzh;
    private final zzlh[] zzi;
    private final zzyb zzj;
    private final zzkw zzk;
    private zzkh zzl;
    private zzwi zzm;
    private zzyc zzn;
    private long zzo;

    public zzkh(zzlh[] zzlhVarArr, long j, zzyb zzybVar, zzyk zzykVar, zzkw zzkwVar, zzki zzkiVar, zzyc zzycVar) {
        this.zzi = zzlhVarArr;
        this.zzo = j;
        this.zzj = zzybVar;
        this.zzk = zzkwVar;
        zzui zzuiVar = zzkiVar.zza;
        this.zzb = zzuiVar.zza;
        this.zzf = zzkiVar;
        this.zzm = zzwi.zza;
        this.zzn = zzycVar;
        this.zzc = new zzvx[2];
        this.zzh = new boolean[2];
        long j2 = zzkiVar.zzb;
        long j3 = zzkiVar.zzd;
        zzug zzugVarZzp = zzkwVar.zzp(zzuiVar, zzykVar, j2);
        this.zza = j3 != -9223372036854775807L ? new zztm(zzugVarZzp, true, 0L, j3) : zzugVarZzp;
    }

    private final void zzs() {
        if (!zzu()) {
            return;
        }
        int i = 0;
        while (true) {
            zzyc zzycVar = this.zzn;
            if (i >= zzycVar.zza) {
                return;
            }
            zzycVar.zzb(i);
            zzxv zzxvVar = this.zzn.zzc[i];
            i++;
        }
    }

    private final void zzt() {
        if (!zzu()) {
            return;
        }
        int i = 0;
        while (true) {
            zzyc zzycVar = this.zzn;
            if (i >= zzycVar.zza) {
                return;
            }
            zzycVar.zzb(i);
            zzxv zzxvVar = this.zzn.zzc[i];
            i++;
        }
    }

    private final boolean zzu() {
        return this.zzl == null;
    }

    public final long zza(zzyc zzycVar, long j, boolean z) {
        return zzb(zzycVar, j, false, new boolean[2]);
    }

    public final long zzb(zzyc zzycVar, long j, boolean z, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzycVar.zza) {
                break;
            }
            boolean[] zArr2 = this.zzh;
            if (z || !zzycVar.zza(this.zzn, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        int i2 = 0;
        while (true) {
            zzlh[] zzlhVarArr = this.zzi;
            if (i2 >= 2) {
                break;
            }
            zzlhVarArr[i2].zzb();
            i2++;
        }
        zzs();
        this.zzn = zzycVar;
        zzt();
        long jZzg = this.zza.zzg(zzycVar.zzc, this.zzh, this.zzc, zArr, j);
        int i3 = 0;
        while (true) {
            zzlh[] zzlhVarArr2 = this.zzi;
            if (i3 >= 2) {
                break;
            }
            zzlhVarArr2[i3].zzb();
            i3++;
        }
        this.zze = false;
        int i4 = 0;
        while (true) {
            zzvx[] zzvxVarArr = this.zzc;
            if (i4 >= 2) {
                return jZzg;
            }
            if (zzvxVarArr[i4] != null) {
                zzdi.zzf(zzycVar.zzb(i4));
                this.zzi[i4].zzb();
                this.zze = true;
            } else {
                zzdi.zzf(zzycVar.zzc[i4] == null);
            }
            i4++;
        }
    }

    public final long zzc() {
        if (!this.zzd) {
            return this.zzf.zzb;
        }
        long jZzb = this.zze ? this.zza.zzb() : Long.MIN_VALUE;
        return jZzb == Long.MIN_VALUE ? this.zzf.zze : jZzb;
    }

    public final long zzd() {
        if (this.zzd) {
            return this.zza.zzc();
        }
        return 0L;
    }

    public final long zze() {
        return this.zzo;
    }

    public final long zzf() {
        return this.zzf.zzb + this.zzo;
    }

    public final zzkh zzg() {
        return this.zzl;
    }

    public final zzwi zzh() {
        return this.zzm;
    }

    public final zzyc zzi() {
        return this.zzn;
    }

    public final zzyc zzj(float f, zzcc zzccVar) {
        zzyc zzycVarZzo = this.zzj.zzo(this.zzi, this.zzm, this.zzf.zza, zzccVar);
        for (zzxv zzxvVar : zzycVarZzo.zzc) {
        }
        return zzycVarZzo;
    }

    public final void zzk(long j, float f, long j2) {
        zzdi.zzf(zzu());
        long j3 = j - this.zzo;
        zzkd zzkdVar = new zzkd();
        zzkdVar.zze(j3);
        zzkdVar.zzf(f);
        zzkdVar.zzd(j2);
        this.zza.zzo(new zzkf(zzkdVar, null));
    }

    public final void zzl(float f, zzcc zzccVar) {
        this.zzd = true;
        this.zzm = this.zza.zzi();
        zzyc zzycVarZzj = zzj(f, zzccVar);
        zzki zzkiVar = this.zzf;
        long jMax = zzkiVar.zzb;
        long j = zzkiVar.zze;
        if (j != -9223372036854775807L && jMax >= j) {
            jMax = Math.max(0L, j - 1);
        }
        long jZza = zza(zzycVarZzj, jMax, false);
        long j2 = this.zzo;
        zzki zzkiVar2 = this.zzf;
        this.zzo = (zzkiVar2.zzb - jZza) + j2;
        this.zzf = zzkiVar2.zzb(jZza);
    }

    public final void zzm(long j) {
        zzdi.zzf(zzu());
        if (this.zzd) {
            this.zza.zzm(j - this.zzo);
        }
    }

    public final void zzn() {
        zzs();
        zzug zzugVar = this.zza;
        try {
            boolean z = zzugVar instanceof zztm;
            zzkw zzkwVar = this.zzk;
            if (z) {
                zzkwVar.zzi(((zztm) zzugVar).zza);
            } else {
                zzkwVar.zzi(zzugVar);
            }
        } catch (RuntimeException e) {
            zzea.zzd("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public final void zzo(zzkh zzkhVar) {
        if (zzkhVar == this.zzl) {
            return;
        }
        zzs();
        this.zzl = zzkhVar;
        zzt();
    }

    public final void zzp(long j) {
        this.zzo = j;
    }

    public final void zzq() {
        zzug zzugVar = this.zza;
        if (zzugVar instanceof zztm) {
            long j = this.zzf.zzd;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ((zztm) zzugVar).zzn(0L, j);
        }
    }

    public final boolean zzr() {
        if (this.zzd) {
            return !this.zze || this.zza.zzb() == Long.MIN_VALUE;
        }
        return false;
    }
}
