package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzty implements zzfs {
    private final zzfs zza;
    private final int zzb;
    private final zztx zzc;
    private final byte[] zzd;
    private int zze;

    public zzty(zzfs zzfsVar, int i, zztx zztxVar) {
        zzdi.zzd(i > 0);
        this.zza = zzfsVar;
        this.zzb = i;
        this.zzc = zztxVar;
        this.zzd = new byte[1];
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.ads.zzp
    public final int zza(byte[] bArr, int i, int i2) {
        int i3 = this.zze;
        if (i3 == 0) {
            int i4 = 0;
            if (this.zza.zza(this.zzd, 0, 1) != -1) {
                int i5 = (this.zzd[0] & 255) << 4;
                if (i5 != 0) {
                    byte[] bArr2 = new byte[i5];
                    int i6 = i5;
                    while (i6 > 0) {
                        int iZza = this.zza.zza(bArr2, i4, i6);
                        if (iZza != -1) {
                            i4 += iZza;
                            i6 -= iZza;
                        }
                    }
                    while (i5 > 0) {
                        int i7 = i5 - 1;
                        if (bArr2[i7] != 0) {
                            break;
                        }
                        i5 = i7;
                    }
                    if (i5 > 0) {
                        this.zzc.zza(new zzek(bArr2, i5));
                    }
                }
                i3 = this.zzb;
                this.zze = i3;
            }
            return -1;
        }
        int iZza2 = this.zza.zza(bArr, i, Math.min(i3, i2));
        if (iZza2 != -1) {
            this.zze -= iZza2;
        }
        return iZza2;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final long zzb(zzfy zzfyVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final Uri zzc() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final Map zze() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzf(zzgu zzguVar) {
        zzguVar.getClass();
        this.zza.zzf(zzguVar);
    }
}
