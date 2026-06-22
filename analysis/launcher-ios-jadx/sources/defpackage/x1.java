package defpackage;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class x1 implements Application.ActivityLifecycleCallbacks {
    public Object g;
    public Activity h;
    public final int i;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;

    public x1(Activity activity) {
        this.h = activity;
        this.i = activity.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.h == activity) {
            this.h = null;
            this.k = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (!this.k || this.l || this.j) {
            return;
        }
        Object obj = this.g;
        try {
            Object obj2 = y1.c.get(activity);
            if (obj2 == obj && activity.hashCode() == this.i) {
                y1.g.postAtFrontOfQueue(new w1(y1.b.get(activity), obj2, 2, false));
                this.l = true;
                this.g = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (this.h == activity) {
            this.j = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
