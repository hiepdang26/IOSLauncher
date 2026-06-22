package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;

/* JADX INFO: loaded from: classes.dex */
final class zzbzb extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzbze zza;

    public zzbzb(zzbze zzbzeVar) {
        this.zza = zzbzeVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        this.zza.zzo.set(true);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        this.zza.zzo.set(false);
    }
}
