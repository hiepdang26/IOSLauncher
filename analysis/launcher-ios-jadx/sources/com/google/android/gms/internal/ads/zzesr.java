package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzesr implements zzevn {
    private final Boolean zza;

    public zzesr(Boolean bool) {
        this.zza = bool;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Boolean bool = this.zza;
        Bundle bundle = (Bundle) obj;
        if (bool != null) {
            bundle.putBoolean("hw_accel", bool.booleanValue());
        }
    }
}
