package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzcjj implements zzdtm {
    private final Long zza;
    private final String zzb;
    private final zzcif zzc;
    private final zzcjn zzd;

    public /* synthetic */ zzcjj(zzcif zzcifVar, zzcjn zzcjnVar, Long l, String str, zzcji zzcjiVar) {
        this.zzc = zzcifVar;
        this.zzd = zzcjnVar;
        this.zza = l;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final zzdtw zza() {
        zzcjn zzcjnVar = this.zzd;
        return zzdtx.zza(this.zza.longValue(), zzcjnVar.zza, zzdtq.zzc(zzcjnVar.zzb), this.zzc, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final zzdua zzb() {
        zzcjn zzcjnVar = this.zzd;
        return zzdub.zza(this.zza.longValue(), zzcjnVar.zza, zzdtq.zzc(zzcjnVar.zzb), this.zzc, this.zzb);
    }
}
