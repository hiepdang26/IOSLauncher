package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzoo {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;

    public final zzoo zza(boolean z) {
        this.zza = true;
        return this;
    }

    public final zzoo zzb(boolean z) {
        this.zzb = z;
        return this;
    }

    public final zzoo zzc(boolean z) {
        this.zzc = z;
        return this;
    }

    public final zzoq zzd() {
        if (this.zza || !(this.zzb || this.zzc)) {
            return new zzoq(this, null);
        }
        throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
    }
}
