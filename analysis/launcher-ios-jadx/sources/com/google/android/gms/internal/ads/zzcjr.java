package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzcjr implements zzdgo {
    private final zzcif zza;
    private zzfcg zzb;
    private zzfbj zzc;
    private zzdck zzd;
    private zzcwa zze;
    private zzekt zzf;

    public /* synthetic */ zzcjr(zzcif zzcifVar, zzcjq zzcjqVar) {
        this.zza = zzcifVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    public final /* synthetic */ zzcvw zza(zzfbj zzfbjVar) {
        this.zzc = zzfbjVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    public final /* synthetic */ zzcvw zzb(zzfcg zzfcgVar) {
        this.zzb = zzfcgVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdgo
    public final /* synthetic */ zzdgo zzc(zzekt zzektVar) {
        this.zzf = zzektVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdgo
    public final /* synthetic */ zzdgo zzd(zzdck zzdckVar) {
        this.zzd = zzdckVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdgo
    public final /* synthetic */ zzdgo zze(zzcwa zzcwaVar) {
        this.zze = zzcwaVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzdgp zzh() {
        zzhfk.zzc(this.zzd, zzdck.class);
        zzhfk.zzc(this.zze, zzcwa.class);
        zzhfk.zzc(this.zzf, zzekt.class);
        return new zzcjt(this.zza, new zzcte(), new zzfgm(), new zzcvd(), new zzdsy(), this.zzd, this.zze, zzeiy.zza(), this.zzf, null, this.zzb, this.zzc, null);
    }
}
