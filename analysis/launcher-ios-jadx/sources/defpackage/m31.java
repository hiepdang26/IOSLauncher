package defpackage;

import android.app.Activity;
import android.app.Application;

/* JADX INFO: loaded from: classes.dex */
public abstract class m31 {
    public static final void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        qg0.l(activity, "activity");
        qg0.l(activityLifecycleCallbacks, "callback");
        activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }
}
