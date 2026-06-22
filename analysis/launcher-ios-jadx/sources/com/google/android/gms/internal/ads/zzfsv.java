package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfsv extends zzfto {
    private String zza;
    private String zzb;

    @Override // com.google.android.gms.internal.ads.zzfto
    public final zzfto zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfto
    public final zzfto zzb(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfto
    public final zzftp zzc() {
        return new zzfsx(this.zza, this.zzb, null);
    }
}
