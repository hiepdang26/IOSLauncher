package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzem implements zzdj {
    @Override // com.google.android.gms.internal.ads.zzdj
    public final long zza() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.internal.ads.zzdj
    public final zzdt zzb(Looper looper, Handler.Callback callback) {
        return new zzep(new Handler(looper, callback));
    }
}
