package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* JADX INFO: loaded from: classes.dex */
final class zzauy implements zzavd {
    final /* synthetic */ Activity zza;

    public zzauy(zzave zzaveVar, Activity activity) {
        this.zza = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzavd
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.zza);
    }
}
