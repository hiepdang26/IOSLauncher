package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes.dex */
public final class zzfq extends zzfl {
    private zzfy zza;
    private byte[] zzb;
    private int zzc;
    private int zzd;

    public zzfq() {
        super(false);
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
        int i4 = zzet.zza;
        System.arraycopy(bArr2, this.zzc, bArr, i, iMin);
        this.zzc += iMin;
        this.zzd -= iMin;
        zzg(iMin);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final long zzb(zzfy zzfyVar) throws zzbo, zzft {
        zzi(zzfyVar);
        this.zza = zzfyVar;
        Uri uriNormalizeScheme = zzfyVar.zza.normalizeScheme();
        String scheme = uriNormalizeScheme.getScheme();
        zzdi.zze("data".equals(scheme), "Unsupported scheme: ".concat(String.valueOf(scheme)));
        String schemeSpecificPart = uriNormalizeScheme.getSchemeSpecificPart();
        int i = zzet.zza;
        String[] strArrSplit = schemeSpecificPart.split(",", -1);
        if (strArrSplit.length != 2) {
            throw zzbo.zzb("Unexpected URI format: ".concat(String.valueOf(uriNormalizeScheme)), null);
        }
        String str = strArrSplit[1];
        if (strArrSplit[0].contains(";base64")) {
            try {
                this.zzb = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                throw zzbo.zzb("Error while parsing Base64 encoded string: ".concat(String.valueOf(str)), e);
            }
        } else {
            this.zzb = URLDecoder.decode(str, zzfuj.zza.name()).getBytes(zzfuj.zzc);
        }
        long j = zzfyVar.zze;
        int length = this.zzb.length;
        if (j > length) {
            this.zzb = null;
            throw new zzft(2008);
        }
        int i2 = (int) j;
        this.zzc = i2;
        int i3 = length - i2;
        this.zzd = i3;
        long j2 = zzfyVar.zzf;
        if (j2 != -1) {
            this.zzd = (int) Math.min(i3, j2);
        }
        zzj(zzfyVar);
        long j3 = zzfyVar.zzf;
        return j3 != -1 ? j3 : this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final Uri zzc() {
        zzfy zzfyVar = this.zza;
        if (zzfyVar != null) {
            return zzfyVar.zza;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() {
        if (this.zzb != null) {
            this.zzb = null;
            zzh();
        }
        this.zza = null;
    }
}
