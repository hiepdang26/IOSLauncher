package defpackage;

import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public abstract class hr {
    public static final int NAVIGATION_ABORTED = 4;
    public static final int NAVIGATION_FAILED = 3;
    public static final int NAVIGATION_FINISHED = 2;
    public static final int NAVIGATION_STARTED = 1;
    public static final String ONLINE_EXTRAS_KEY = "online";
    public static final int TAB_HIDDEN = 6;
    public static final int TAB_SHOWN = 5;

    public abstract void extraCallback(String str, Bundle bundle);

    public abstract Bundle extraCallbackWithResult(String str, Bundle bundle);

    public abstract void onMessageChannelReady(Bundle bundle);

    public abstract void onNavigationEvent(int i, Bundle bundle);

    public abstract void onPostMessage(String str, Bundle bundle);

    public abstract void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle);
}
