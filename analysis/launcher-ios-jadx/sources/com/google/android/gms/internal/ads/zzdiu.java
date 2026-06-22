package com.google.android.gms.internal.ads;

import defpackage.hd2;
import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
final class zzdiu implements zzgcf {
    final /* synthetic */ String zza = "Google";
    final /* synthetic */ zzdiw zzb;

    public zzdiu(zzdiw zzdiwVar, String str, boolean z) {
        this.zzb = zzdiwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzeI)).booleanValue()) {
            hd2.B.g.zzv(th, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zzd.zzT((zzcej) obj);
        zzdiw zzdiwVar = this.zzb;
        zzbzt zzbztVarZzp = zzdiwVar.zzd.zzp();
        zzeeo zzeeoVarZzf = zzdiwVar.zzf(this.zza, true);
        if (zzeeoVarZzf != null && zzbztVarZzp != null) {
            zzbztVarZzp.zzc(zzeeoVarZzf);
        } else if (zzbztVarZzp != null) {
            zzbztVarZzp.cancel(false);
        }
    }
}
