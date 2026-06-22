package com.google.android.gms.internal.ads;

import defpackage.n42;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes.dex */
final class zzdxo implements zzgcf {
    final /* synthetic */ zzdxp zza;

    public zzdxo(zzdxp zzdxpVar) {
        this.zza = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzfB)).booleanValue()) {
            Matcher matcher = zzdxp.zza.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zza.zzf.zzi(Integer.parseInt(matcher.group(1)));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zzb(Object obj) {
        zzfex zzfexVar = (zzfex) obj;
        if (((Boolean) n42.d.c.zza(zzbbw.zzfB)).booleanValue()) {
            this.zza.zzf.zzi(zzfexVar.zzb.zzb.zzf);
            this.zza.zzf.zzj(zzfexVar.zzb.zzb.zzg);
        }
    }
}
