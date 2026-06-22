package com.google.android.gms.internal.ads;

import defpackage.k31;

/* JADX INFO: loaded from: classes.dex */
final class zzaeu extends zzaet {
    private final zzek zzb;
    private final zzek zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzaeu(zzadp zzadpVar) {
        super(zzadpVar);
        this.zzb = new zzek(zzfh.zza);
        this.zzc = new zzek(4);
    }

    @Override // com.google.android.gms.internal.ads.zzaet
    public final boolean zza(zzek zzekVar) throws zzaes {
        int iZzm = zzekVar.zzm();
        int i = iZzm >> 4;
        int i2 = iZzm & 15;
        if (i2 != 7) {
            throw new zzaes(k31.k(i2, "Video format not supported: "));
        }
        this.zzg = i;
        return i != 5;
    }

    @Override // com.google.android.gms.internal.ads.zzaet
    public final boolean zzb(zzek zzekVar, long j) throws zzbo {
        int i;
        int iZzm = zzekVar.zzm();
        long jZzh = zzekVar.zzh();
        if (iZzm == 0) {
            if (!this.zze) {
                zzek zzekVar2 = new zzek(new byte[zzekVar.zzb()]);
                zzekVar.zzG(zzekVar2.zzM(), 0, zzekVar.zzb());
                zzabn zzabnVarZza = zzabn.zza(zzekVar2);
                this.zzd = zzabnVarZza.zzb;
                zzad zzadVar = new zzad();
                zzadVar.zzX("video/avc");
                zzadVar.zzz(zzabnVarZza.zzk);
                zzadVar.zzac(zzabnVarZza.zzc);
                zzadVar.zzI(zzabnVarZza.zzd);
                zzadVar.zzT(zzabnVarZza.zzj);
                zzadVar.zzL(zzabnVarZza.zza);
                this.zza.zzl(zzadVar.zzad());
                this.zze = true;
                return false;
            }
        } else if (iZzm == 1 && this.zze) {
            int i2 = this.zzg == 1 ? 1 : 0;
            if (this.zzf) {
                i = i2;
            } else if (i2 != 0) {
                i = 1;
            }
            byte[] bArrZzM = this.zzc.zzM();
            bArrZzM[0] = 0;
            bArrZzM[1] = 0;
            bArrZzM[2] = 0;
            int i3 = 4 - this.zzd;
            int i4 = 0;
            while (zzekVar.zzb() > 0) {
                zzekVar.zzG(this.zzc.zzM(), i3, this.zzd);
                this.zzc.zzK(0);
                zzek zzekVar3 = this.zzc;
                zzek zzekVar4 = this.zzb;
                int iZzp = zzekVar3.zzp();
                zzekVar4.zzK(0);
                this.zza.zzq(this.zzb, 4);
                this.zza.zzq(zzekVar, iZzp);
                i4 = i4 + 4 + iZzp;
            }
            this.zza.zzs((jZzh * 1000) + j, i, i4, 0, null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}
