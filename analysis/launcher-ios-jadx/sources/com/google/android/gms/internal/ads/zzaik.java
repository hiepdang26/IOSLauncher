package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaik {
    public final zzadp zza;
    public zzaiz zzd;
    public zzaih zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private boolean zzl;
    public final zzaiy zzb = new zzaiy();
    public final zzek zzc = new zzek();
    private final zzek zzj = new zzek(1);
    private final zzek zzk = new zzek();

    public zzaik(zzadp zzadpVar, zzaiz zzaizVar, zzaih zzaihVar) {
        this.zza = zzadpVar;
        this.zzd = zzaizVar;
        this.zze = zzaihVar;
        zzh(zzaizVar, zzaihVar);
    }

    public final int zza() {
        int i = !this.zzl ? this.zzd.zzg[this.zzf] : this.zzb.zzj[this.zzf] ? 1 : 0;
        return zzf() != null ? i | 1073741824 : i;
    }

    public final int zzb() {
        return !this.zzl ? this.zzd.zzd[this.zzf] : this.zzb.zzh[this.zzf];
    }

    public final int zzc(int i, int i2) {
        zzek zzekVar;
        zzaix zzaixVarZzf = zzf();
        if (zzaixVarZzf == null) {
            return 0;
        }
        int i3 = zzaixVarZzf.zzd;
        if (i3 != 0) {
            zzekVar = this.zzb.zzn;
        } else {
            byte[] bArr = zzaixVarZzf.zze;
            int i4 = zzet.zza;
            zzek zzekVar2 = this.zzk;
            int length = bArr.length;
            zzekVar2.zzI(bArr, length);
            zzekVar = this.zzk;
            i3 = length;
        }
        boolean zZzb = this.zzb.zzb(this.zzf);
        boolean z = zZzb || i2 != 0;
        zzek zzekVar3 = this.zzj;
        zzekVar3.zzM()[0] = (byte) ((true != z ? 0 : 128) | i3);
        zzekVar3.zzK(0);
        this.zza.zzr(this.zzj, 1, 1);
        this.zza.zzr(zzekVar, i3, 1);
        if (!z) {
            return i3 + 1;
        }
        if (!zZzb) {
            this.zzc.zzH(8);
            zzek zzekVar4 = this.zzc;
            byte[] bArrZzM = zzekVar4.zzM();
            bArrZzM[0] = 0;
            bArrZzM[1] = 1;
            bArrZzM[2] = 0;
            bArrZzM[3] = (byte) i2;
            bArrZzM[4] = (byte) ((i >> 24) & 255);
            bArrZzM[5] = (byte) ((i >> 16) & 255);
            bArrZzM[6] = (byte) ((i >> 8) & 255);
            bArrZzM[7] = (byte) (i & 255);
            this.zza.zzr(zzekVar4, 8, 1);
            return i3 + 9;
        }
        int i5 = i3 + 1;
        zzek zzekVar5 = this.zzb.zzn;
        int iZzq = zzekVar5.zzq();
        zzekVar5.zzL(-2);
        int i6 = (iZzq * 6) + 2;
        if (i2 != 0) {
            this.zzc.zzH(i6);
            byte[] bArrZzM2 = this.zzc.zzM();
            zzekVar5.zzG(bArrZzM2, 0, i6);
            int i7 = (((bArrZzM2[2] & 255) << 8) | (bArrZzM2[3] & 255)) + i2;
            bArrZzM2[2] = (byte) ((i7 >> 8) & 255);
            bArrZzM2[3] = (byte) (i7 & 255);
            zzekVar5 = this.zzc;
        }
        this.zza.zzr(zzekVar5, i6, 1);
        return i5 + i6;
    }

    public final long zzd() {
        return !this.zzl ? this.zzd.zzc[this.zzf] : this.zzb.zzf[this.zzh];
    }

    public final long zze() {
        if (!this.zzl) {
            return this.zzd.zzf[this.zzf];
        }
        zzaiy zzaiyVar = this.zzb;
        return zzaiyVar.zzi[this.zzf];
    }

    public final zzaix zzf() {
        if (!this.zzl) {
            return null;
        }
        zzaiy zzaiyVar = this.zzb;
        zzaih zzaihVar = zzaiyVar.zza;
        int i = zzet.zza;
        int i2 = zzaihVar.zza;
        zzaix zzaixVarZza = zzaiyVar.zzm;
        if (zzaixVarZza == null) {
            zzaixVarZza = this.zzd.zza.zza(i2);
        }
        if (zzaixVarZza == null || !zzaixVarZza.zza) {
            return null;
        }
        return zzaixVarZza;
    }

    public final void zzh(zzaiz zzaizVar, zzaih zzaihVar) {
        this.zzd = zzaizVar;
        this.zze = zzaihVar;
        this.zza.zzl(zzaizVar.zza.zzf);
        zzi();
    }

    public final void zzi() {
        zzaiy zzaiyVar = this.zzb;
        zzaiyVar.zzd = 0;
        zzaiyVar.zzp = 0L;
        zzaiyVar.zzq = false;
        zzaiyVar.zzk = false;
        zzaiyVar.zzo = false;
        zzaiyVar.zzm = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzl = false;
    }

    public final boolean zzk() {
        this.zzf++;
        if (!this.zzl) {
            return false;
        }
        int i = this.zzg + 1;
        this.zzg = i;
        int[] iArr = this.zzb.zzg;
        int i2 = this.zzh;
        if (i != iArr[i2]) {
            return true;
        }
        this.zzh = i2 + 1;
        this.zzg = 0;
        return false;
    }
}
