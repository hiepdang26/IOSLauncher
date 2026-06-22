package defpackage;

import android.net.ConnectivityManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class bx0 {
    public static final void a(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
        qg0.l(connectivityManager, "<this>");
        qg0.l(networkCallback, "networkCallback");
        connectivityManager.registerDefaultNetworkCallback(networkCallback);
    }
}
