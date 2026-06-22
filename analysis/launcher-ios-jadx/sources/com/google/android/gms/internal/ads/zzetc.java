package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzetc implements zzevn {
    public final Bundle zza;

    public zzetc(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle bundleZza = zzffu.zza(bundle, "device");
        bundleZza.putBundle("android_mem_info", this.zza);
        bundle.putBundle("device", bundleZza);
    }
}
