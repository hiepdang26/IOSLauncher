package defpackage;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public interface s5 {
    Set a();

    void connect(cb cbVar);

    void disconnect();

    void disconnect(String str);

    v20[] getAvailableFeatures();

    String getEndpointPackageName();

    String getLastDisconnectMessage();

    int getMinApkVersion();

    void getRemoteService(sd0 sd0Var, Set set);

    boolean isConnected();

    boolean isConnecting();

    void onUserSignOut(db dbVar);

    boolean requiresGooglePlayServices();

    boolean requiresSignIn();
}
