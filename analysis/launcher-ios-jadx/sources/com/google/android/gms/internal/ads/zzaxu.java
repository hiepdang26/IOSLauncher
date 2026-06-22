package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class zzaxu extends BroadcastReceiver {
    final /* synthetic */ zzaxx zza;

    public zzaxu(zzaxx zzaxxVar) {
        this.zza = zzaxxVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zza.zzj(3);
    }
}
