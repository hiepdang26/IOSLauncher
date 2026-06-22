package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzeva implements zzevn {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final Long zze;

    public zzeva(String str, String str2, String str3, String str4, Long l) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = l;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzffu.zzc(bundle, "gmp_app_id", this.zza);
        zzffu.zzc(bundle, "fbs_aiid", this.zzb);
        zzffu.zzc(bundle, "fbs_aeid", this.zzc);
        zzffu.zzc(bundle, "apm_id_origin", this.zzd);
        Long l = this.zze;
        if (l != null) {
            bundle.putLong("sai_timeout", l.longValue());
        }
    }
}
