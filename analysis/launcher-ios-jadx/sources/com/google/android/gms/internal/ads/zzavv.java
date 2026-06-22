package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class zzavv extends BroadcastReceiver {
    final /* synthetic */ zzavw zza;

    public zzavv(zzavw zzavwVar) {
        this.zza = zzavwVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zza.zzf();
    }
}
