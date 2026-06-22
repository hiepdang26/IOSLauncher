package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfse extends zzgax {
    Object zza;

    public zzfse(Object obj, Runnable runnable) {
        this.zza = obj;
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    public final String zza() {
        Object obj = this.zza;
        return obj == null ? "" : obj.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    public final void zzb() {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    public final boolean zzc(Object obj) {
        return super.zzc(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgax
    public final boolean zzd(Throwable th) {
        return super.zzd(th);
    }
}
