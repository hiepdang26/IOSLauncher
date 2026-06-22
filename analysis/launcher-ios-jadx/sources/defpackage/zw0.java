package defpackage;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: loaded from: classes.dex */
public abstract class zw0 {
    public static final NetworkCapabilities a(ConnectivityManager connectivityManager, Network network) {
        qg0.l(connectivityManager, "<this>");
        return connectivityManager.getNetworkCapabilities(network);
    }

    public static final boolean b(NetworkCapabilities networkCapabilities, int i) {
        qg0.l(networkCapabilities, "<this>");
        return networkCapabilities.hasCapability(i);
    }

    public static final void c(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
        qg0.l(connectivityManager, "<this>");
        qg0.l(networkCallback, "networkCallback");
        connectivityManager.unregisterNetworkCallback(networkCallback);
    }
}
