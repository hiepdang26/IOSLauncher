package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzcdk implements zzfs {
    private final zzfs zza;
    private final long zzb;
    private final zzfs zzc;
    private long zzd;
    private Uri zze;

    public zzcdk(zzfs zzfsVar, int i, zzfs zzfsVar2) {
        this.zza = zzfsVar;
        this.zzb = i;
        this.zzc = zzfsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzp
    public final int zza(byte[] bArr, int i, int i2) {
        int i3;
        long j = this.zzd;
        long j2 = this.zzb;
        if (j < j2) {
            int iZza = this.zza.zza(bArr, i, (int) Math.min(i2, j2 - j));
            long j3 = this.zzd + ((long) iZza);
            this.zzd = j3;
            i3 = iZza;
            j = j3;
        } else {
            i3 = 0;
        }
        if (j < this.zzb) {
            return i3;
        }
        int iZza2 = this.zzc.zza(bArr, i + i3, i2 - i3);
        int i4 = i3 + iZza2;
        this.zzd += (long) iZza2;
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final long zzb(zzfy zzfyVar) {
        zzfy zzfyVar2;
        this.zze = zzfyVar.zza;
        long j = zzfyVar.zze;
        long j2 = this.zzb;
        zzfy zzfyVar3 = null;
        if (j >= j2) {
            zzfyVar2 = null;
        } else {
            long j3 = zzfyVar.zzf;
            long jMin = j2 - j;
            if (j3 != -1) {
                jMin = Math.min(j3, jMin);
            }
            zzfyVar2 = new zzfy(zzfyVar.zza, j, jMin, null);
        }
        long j4 = zzfyVar.zzf;
        if (j4 == -1 || zzfyVar.zze + j4 > this.zzb) {
            long jMax = Math.max(this.zzb, zzfyVar.zze);
            long j5 = zzfyVar.zzf;
            zzfyVar3 = new zzfy(zzfyVar.zza, jMax, j5 != -1 ? Math.min(j5, (zzfyVar.zze + j5) - this.zzb) : -1L, null);
        }
        long jZzb = zzfyVar2 != null ? this.zza.zzb(zzfyVar2) : 0L;
        long jZzb2 = zzfyVar3 != null ? this.zzc.zzb(zzfyVar3) : 0L;
        this.zzd = zzfyVar.zze;
        if (jZzb == -1 || jZzb2 == -1) {
            return -1L;
        }
        return jZzb + jZzb2;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final Uri zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() {
        this.zza.zzd();
        this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final Map zze() {
        return zzfxu.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzf(zzgu zzguVar) {
    }
}
