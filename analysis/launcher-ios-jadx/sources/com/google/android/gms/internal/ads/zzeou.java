package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzeou implements zzevn {
    private final String zza;
    private final boolean zzb;

    public zzeou(String str, boolean z) {
        this.zza = str;
        this.zzb = z;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zza != null) {
            Bundle bundleZza = zzffu.zza(bundle, "pii");
            bundleZza.putString("afai", this.zza);
            bundleZza.putBoolean("is_afai_lat", this.zzb);
        }
    }
}
