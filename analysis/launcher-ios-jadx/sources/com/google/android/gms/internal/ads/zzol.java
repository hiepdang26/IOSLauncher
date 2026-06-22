package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class zzol extends BroadcastReceiver {
    final /* synthetic */ zzom zza;

    public /* synthetic */ zzol(zzom zzomVar, zzok zzokVar) {
        this.zza = zzomVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (isInitialStickyBroadcast()) {
            return;
        }
        zzom zzomVar = this.zza;
        zzomVar.zzj(zzof.zzd(context, intent, zzomVar.zzh, zzomVar.zzg));
    }
}
