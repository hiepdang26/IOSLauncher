package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzeqa implements zzevn {
    private final double zza;
    private final boolean zzb;

    public zzeqa(double d, boolean z) {
        this.zza = d;
        this.zzb = z;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle bundleZza = zzffu.zza(bundle, "device");
        bundle.putBundle("device", bundleZza);
        Bundle bundleZza2 = zzffu.zza(bundleZza, "battery");
        bundleZza.putBundle("battery", bundleZza2);
        bundleZza2.putBoolean("is_charging", this.zzb);
        bundleZza2.putDouble("battery_level", this.zza);
    }
}
