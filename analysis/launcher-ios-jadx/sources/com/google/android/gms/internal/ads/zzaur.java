package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: loaded from: classes.dex */
final class zzaur extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzaus zza;

    public zzaur(zzaus zzausVar) {
        this.zza = zzausVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        synchronized (zzaus.class) {
            this.zza.zza = networkCapabilities;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        synchronized (zzaus.class) {
            this.zza.zza = null;
        }
    }
}
