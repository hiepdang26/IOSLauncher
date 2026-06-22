package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
final class zzerw implements zzevn {
    private final String zza;
    private final String zzb;
    private final Bundle zzc;

    public /* synthetic */ zzerw(String str, String str2, Bundle bundle, zzerv zzervVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("consent_string", this.zza);
        bundle.putString("fc_consent", this.zzb);
        bundle.putBundle("iab_consent_info", this.zzc);
    }
}
