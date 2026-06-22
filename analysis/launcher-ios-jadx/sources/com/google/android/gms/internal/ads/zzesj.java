package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzesj implements zzevn {
    private final Integer zza;

    public zzesj(Integer num) {
        this.zza = num;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Integer num = this.zza;
        Bundle bundle = (Bundle) obj;
        if (num != null) {
            bundle.putInt("dspct", Math.min(num.intValue(), 20));
        }
    }
}
