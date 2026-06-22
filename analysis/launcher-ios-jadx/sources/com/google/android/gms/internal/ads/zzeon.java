package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzeon implements zzevn {
    private final Bundle zza;

    public zzeon(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zza.isEmpty()) {
            return;
        }
        bundle.putBundle("installed_adapter_data", this.zza);
    }
}
