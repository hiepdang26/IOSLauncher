package com.google.android.gms.internal.ads;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class zzfn extends zzfl {
    private Uri zza;
    private byte[] zzb;
    private int zzc;
    private int zzd;
    private boolean zze;
    private final zzfm zzf;

    public zzfn(byte[] bArr) {
        zzfm zzfmVar = new zzfm(bArr);
        super(false);
        this.zzf = zzfmVar;
        zzdi.zzd(bArr.length > 0);
    }

    @Override // com.google.android.gms.internal.ads.zzp
    public final int zza(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzd;
        if (i3 == 0) {
            return -1;
        }
        int iMin = Math.min(i2, i3);
        byte[] bArr2 = this.zzb;
        zzdi.zzb(bArr2);
        System.arraycopy(bArr2, this.zzc, bArr, i, iMin);
        this.zzc += iMin;
        this.zzd -= iMin;
        zzg(iMin);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final long zzb(zzfy zzfyVar) throws zzft {
        zzi(zzfyVar);
        this.zza = zzfyVar.zza;
        byte[] bArr = this.zzf.zza;
        this.zzb = bArr;
        long j = zzfyVar.zze;
        int length = bArr.length;
        if (j > length) {
            throw new zzft(2008);
        }
        int i = (int) j;
        this.zzc = i;
        int i2 = length - i;
        this.zzd = i2;
        long j2 = zzfyVar.zzf;
        if (j2 != -1) {
            this.zzd = (int) Math.min(i2, j2);
        }
        this.zze = true;
        zzj(zzfyVar);
        long j3 = zzfyVar.zzf;
        return j3 != -1 ? j3 : this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final Uri zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() {
        if (this.zze) {
            this.zze = false;
            zzh();
        }
        this.zza = null;
        this.zzb = null;
    }
}
