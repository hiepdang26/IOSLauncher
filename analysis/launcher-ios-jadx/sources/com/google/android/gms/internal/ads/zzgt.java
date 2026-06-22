package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgt implements zzfs {
    private final zzfs zza;
    private long zzb;
    private Uri zzc = Uri.EMPTY;
    private Map zzd = Collections.EMPTY_MAP;

    public zzgt(zzfs zzfsVar) {
        this.zza = zzfsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzp
    public final int zza(byte[] bArr, int i, int i2) {
        int iZza = this.zza.zza(bArr, i, i2);
        if (iZza != -1) {
            this.zzb += (long) iZza;
        }
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final long zzb(zzfy zzfyVar) {
        this.zzc = zzfyVar.zza;
        this.zzd = Collections.EMPTY_MAP;
        long jZzb = this.zza.zzb(zzfyVar);
        Uri uriZzc = zzc();
        uriZzc.getClass();
        this.zzc = uriZzc;
        this.zzd = zze();
        return jZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final Uri zzc() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() {
        this.zza.zzd();
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

    public final long zzg() {
        return this.zzb;
    }

    public final Uri zzh() {
        return this.zzc;
    }

    public final Map zzi() {
        return this.zzd;
    }
}
