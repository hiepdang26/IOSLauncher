package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzajf extends zzajo {
    private zzacv zza;
    private zzaje zzb;

    private static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final long zza(zzek zzekVar) {
        if (!zzd(zzekVar.zzM())) {
            return -1L;
        }
        int i = (zzekVar.zzM()[2] & 255) >> 4;
        if (i == 6) {
            zzekVar.zzL(4);
            zzekVar.zzw();
        } else if (i == 7) {
            i = 7;
            zzekVar.zzL(4);
            zzekVar.zzw();
        }
        int iZza = zzacr.zza(zzekVar, i);
        zzekVar.zzK(0);
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzb = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final boolean zzc(zzek zzekVar, long j, zzajl zzajlVar) {
        byte[] bArrZzM = zzekVar.zzM();
        zzacv zzacvVar = this.zza;
        if (zzacvVar == null) {
            zzacv zzacvVar2 = new zzacv(bArrZzM, 17);
            this.zza = zzacvVar2;
            zzajlVar.zza = zzacvVar2.zzc(Arrays.copyOfRange(bArrZzM, 9, zzekVar.zze()), null);
            return true;
        }
        if ((bArrZzM[0] & 127) == 3) {
            zzacu zzacuVarZzb = zzacs.zzb(zzekVar);
            zzacv zzacvVarZzf = zzacvVar.zzf(zzacuVarZzb);
            this.zza = zzacvVarZzf;
            this.zzb = new zzaje(zzacvVarZzf, zzacuVarZzb);
            return true;
        }
        if (!zzd(bArrZzM)) {
            return true;
        }
        zzaje zzajeVar = this.zzb;
        if (zzajeVar != null) {
            zzajeVar.zza(j);
            zzajlVar.zzb = this.zzb;
        }
        zzajlVar.zza.getClass();
        return false;
    }
}
