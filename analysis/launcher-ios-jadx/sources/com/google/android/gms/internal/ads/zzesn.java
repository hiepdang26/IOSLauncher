package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzesn implements zzevn {
    private final boolean zza;

    public zzesn(boolean z) {
        this.zza = z;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        ((Bundle) obj).putBoolean("is_gbid", this.zza);
    }
}
