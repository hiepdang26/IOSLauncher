package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzeqj implements zzevn {
    private final long zza;

    public zzeqj(long j) {
        this.zza = j;
    }

    @Override // com.google.android.gms.internal.ads.zzevn
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        ((Bundle) obj).putLong("cldut", this.zza);
    }
}
