package defpackage;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class n31 extends rz {
    final /* synthetic */ o31 this$0;

    public static final class a extends rz {
        final /* synthetic */ o31 this$0;

        public a(o31 o31Var) {
            this.this$0 = o31Var;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            qg0.l(activity, "activity");
            this.this$0.b();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            qg0.l(activity, "activity");
            o31 o31Var = this.this$0;
            int i = o31Var.g + 1;
            o31Var.g = i;
            if (i == 1 && o31Var.j) {
                o31Var.l.d(um0.ON_START);
                o31Var.j = false;
            }
        }
    }

    public n31(o31 o31Var) {
        this.this$0 = o31Var;
    }

    @Override // defpackage.rz, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        qg0.l(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            int i = fa1.h;
            Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            qg0.i(fragmentFindFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            ((fa1) fragmentFindFragmentByTag).g = this.this$0.n;
        }
    }

    @Override // defpackage.rz, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        qg0.l(activity, "activity");
        o31 o31Var = this.this$0;
        int i = o31Var.h - 1;
        o31Var.h = i;
        if (i == 0) {
            Handler handler = o31Var.k;
            qg0.h(handler);
            handler.postDelayed(o31Var.m, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        qg0.l(activity, "activity");
        m31.a(activity, new a(this.this$0));
    }

    @Override // defpackage.rz, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        qg0.l(activity, "activity");
        o31 o31Var = this.this$0;
        int i = o31Var.g - 1;
        o31Var.g = i;
        if (i == 0 && o31Var.i) {
            o31Var.l.d(um0.ON_STOP);
            o31Var.j = true;
        }
    }
}
