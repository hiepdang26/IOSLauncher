package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzeuq implements zzevn {
    private final String zza;
    private final Bundle zzb;

    public zzeuq(String str, Bundle bundle) {
        this.zza = str;
        this.zzb = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("rtb", this.zza);
        if (this.zzb.isEmpty()) {
            return;
        }
        bundle.putBundle("adapter_initialization_status", this.zzb);
    }
}
