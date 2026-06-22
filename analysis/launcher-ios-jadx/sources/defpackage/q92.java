package defpackage;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class q92 implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ r92 g;

    public q92(r92 r92Var) {
        this.g = r92Var;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.g.b(new n82(this, bundle, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.g.b(new d92(this, activity, 4));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.g.b(new d92(this, activity, 2));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        this.g.b(new d92(this, activity, 1));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        d62 d62Var = new d62();
        this.g.b(new n82(this, activity, d62Var));
        Bundle bundleQ = d62Var.q(50L);
        if (bundleQ != null) {
            bundle.putAll(bundleQ);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        this.g.b(new d92(this, activity, 0));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        this.g.b(new d92(this, activity, 3));
    }
}
