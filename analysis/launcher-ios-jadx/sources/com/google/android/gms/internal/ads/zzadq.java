package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzadq {
    private final byte[] zza = new byte[10];
    private boolean zzb;
    private int zzc;
    private long zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public final void zza(zzadp zzadpVar, zzado zzadoVar) {
        if (this.zzc > 0) {
            zzadpVar.zzs(this.zzd, this.zze, this.zzf, this.zzg, zzadoVar);
            this.zzc = 0;
        }
    }

    public final void zzb() {
        this.zzb = false;
        this.zzc = 0;
    }

    public final void zzc(zzadp zzadpVar, long j, int i, int i2, int i3, zzado zzadoVar) {
        zzdi.zzg(this.zzg <= i2 + i3, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.zzb) {
            int i4 = this.zzc;
            int i5 = i4 + 1;
            this.zzc = i5;
            if (i4 == 0) {
                this.zzd = j;
                this.zze = i;
                this.zzf = 0;
            }
            this.zzf += i2;
            this.zzg = i3;
            if (i5 >= 16) {
                zza(zzadpVar, zzadoVar);
            }
        }
    }

    public final void zzd(zzacl zzaclVar) {
        if (this.zzb) {
            return;
        }
        zzaclVar.zzh(this.zza, 0, 10);
        zzaclVar.zzj();
        byte[] bArr = this.zza;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            this.zzb = true;
        }
    }
}
