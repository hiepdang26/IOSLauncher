package com.google.android.gms.internal.ads;

import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
final class zzdit implements zzaxw {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdiw zzb;

    public zzdit(zzdiw zzdiwVar, String str) {
        this.zza = str;
        this.zzb = zzdiwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaxw
    public final void zzdp(zzaxv zzaxvVar) {
        if (!((Boolean) n42.d.c.zza(zzbbw.zzbz)).booleanValue()) {
            if (zzaxvVar.zzj) {
                zzdiw zzdiwVar = this.zzb;
                zzdiwVar.zzx.put(this.zza, Boolean.TRUE);
                zzdiw zzdiwVar2 = this.zzb;
                zzdiwVar2.zzB(zzdiwVar2.zzn.zzf(), this.zzb.zzn.zzl(), this.zzb.zzn.zzm(), true);
                return;
            }
            return;
        }
        synchronized (this) {
            try {
                if (zzaxvVar.zzj) {
                    zzdiw zzdiwVar3 = this.zzb;
                    if (zzdiwVar3.zzn == null) {
                        return;
                    }
                    zzdiwVar3.zzx.put(this.zza, Boolean.TRUE);
                    zzdiw zzdiwVar4 = this.zzb;
                    zzdiwVar4.zzB(zzdiwVar4.zzn.zzf(), this.zzb.zzn.zzl(), this.zzb.zzn.zzm(), true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
