package defpackage;

import android.net.ConnectivityManager;
import android.net.Network;

/* JADX INFO: loaded from: classes.dex */
public abstract class ax0 {
    public static final Network a(ConnectivityManager connectivityManager) {
        qg0.l(connectivityManager, "<this>");
        return connectivityManager.getActiveNetwork();
    }
}
