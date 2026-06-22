package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes.dex */
abstract class zzajo {
    private zzadp zzb;
    private zzacn zzc;
    private zzajj zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private final zzajh zza = new zzajh();
    private zzajl zzj = new zzajl();

    public abstract long zza(zzek zzekVar);

    public void zzb(boolean z) {
        int i;
        if (z) {
            this.zzj = new zzajl();
            this.zzf = 0L;
            i = 0;
        } else {
            i = 1;
        }
        this.zzh = i;
        this.zze = -1L;
        this.zzg = 0L;
    }

    public abstract boolean zzc(zzek zzekVar, long j, zzajl zzajlVar);

    public final int zze(zzacl zzaclVar, zzadf zzadfVar) throws EOFException, InterruptedIOException {
        zzdi.zzb(this.zzb);
        int i = zzet.zza;
        int i2 = this.zzh;
        if (i2 == 0) {
            while (this.zza.zze(zzaclVar)) {
                long jZzf = zzaclVar.zzf();
                long j = this.zzf;
                this.zzk = jZzf - j;
                if (!zzc(this.zza.zza(), j, this.zzj)) {
                    zzaf zzafVar = this.zzj.zza;
                    this.zzi = zzafVar.zzA;
                    if (!this.zzm) {
                        this.zzb.zzl(zzafVar);
                        this.zzm = true;
                    }
                    zzajj zzajjVar = this.zzj.zzb;
                    if (zzajjVar != null) {
                        this.zzd = zzajjVar;
                    } else if (zzaclVar.zzd() == -1) {
                        this.zzd = new zzajn(null);
                    } else {
                        zzaji zzajiVarZzb = this.zza.zzb();
                        this.zzd = new zzajd(this, this.zzf, zzaclVar.zzd(), zzajiVarZzb.zzd + zzajiVarZzb.zze, zzajiVarZzb.zzb, (zzajiVarZzb.zza & 4) != 0);
                    }
                    this.zzh = 2;
                    this.zza.zzd();
                    return 0;
                }
                this.zzf = zzaclVar.zzf();
            }
            this.zzh = 3;
            return -1;
        }
        if (i2 == 1) {
            ((zzaby) zzaclVar).zzo((int) this.zzf, false);
            this.zzh = 2;
            return 0;
        }
        if (i2 != 2) {
            return -1;
        }
        long jZzd = this.zzd.zzd(zzaclVar);
        if (jZzd >= 0) {
            zzadfVar.zza = jZzd;
            return 1;
        }
        if (jZzd < -1) {
            zzi(-(jZzd + 2));
        }
        if (!this.zzl) {
            zzadi zzadiVarZze = this.zzd.zze();
            zzdi.zzb(zzadiVarZze);
            this.zzc.zzO(zzadiVarZze);
            this.zzl = true;
        }
        if (this.zzk <= 0 && !this.zza.zze(zzaclVar)) {
            this.zzh = 3;
            return -1;
        }
        this.zzk = 0L;
        zzek zzekVarZza = this.zza.zza();
        long jZza = zza(zzekVarZza);
        if (jZza >= 0) {
            long j2 = this.zzg;
            if (j2 + jZza >= this.zze) {
                long jZzf2 = zzf(j2);
                this.zzb.zzq(zzekVarZza, zzekVarZza.zze());
                this.zzb.zzs(jZzf2, 1, zzekVarZza.zze(), 0, null);
                this.zze = -1L;
            }
        }
        this.zzg += jZza;
        return 0;
    }

    public final long zzf(long j) {
        return (j * 1000000) / ((long) this.zzi);
    }

    public final long zzg(long j) {
        return (((long) this.zzi) * j) / 1000000;
    }

    public final void zzh(zzacn zzacnVar, zzadp zzadpVar) {
        this.zzc = zzacnVar;
        this.zzb = zzadpVar;
        zzb(true);
    }

    public void zzi(long j) {
        this.zzg = j;
    }

    public final void zzj(long j, long j2) {
        this.zza.zzc();
        if (j == 0) {
            zzb(!this.zzl);
            return;
        }
        if (this.zzh != 0) {
            long jZzg = zzg(j2);
            this.zze = jZzg;
            zzajj zzajjVar = this.zzd;
            int i = zzet.zza;
            zzajjVar.zzg(jZzg);
            this.zzh = 2;
        }
    }
}
