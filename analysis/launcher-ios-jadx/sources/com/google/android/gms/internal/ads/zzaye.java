package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

/* JADX INFO: loaded from: classes.dex */
final class zzaye implements zzayi {
    final /* synthetic */ Activity zza;

    public zzaye(zzayj zzayjVar, Activity activity) {
        this.zza = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzayi
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.zza);
    }
}
