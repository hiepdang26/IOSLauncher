package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdiy {
    private zzbfa zza;

    public zzdiy(zzdik zzdikVar) {
        this.zza = zzdikVar;
    }

    public final synchronized zzbfa zza() {
        return this.zza;
    }

    public final synchronized void zzb(zzbfa zzbfaVar) {
        this.zza = zzbfaVar;
    }
}
