package defpackage;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class fa1 extends Fragment {
    public static final /* synthetic */ int h = 0;
    public ow1 g;

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public static final ea1 Companion = new ea1();

        public static final void registerIn(Activity activity) {
            Companion.getClass();
            qg0.l(activity, "activity");
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            qg0.l(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            qg0.l(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            qg0.l(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            qg0.l(activity, "activity");
            int i = fa1.h;
            da1.a(activity, um0.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            qg0.l(activity, "activity");
            int i = fa1.h;
            da1.a(activity, um0.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            qg0.l(activity, "activity");
            int i = fa1.h;
            da1.a(activity, um0.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            qg0.l(activity, "activity");
            int i = fa1.h;
            da1.a(activity, um0.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            qg0.l(activity, "activity");
            int i = fa1.h;
            da1.a(activity, um0.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            qg0.l(activity, "activity");
            int i = fa1.h;
            da1.a(activity, um0.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            qg0.l(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            qg0.l(activity, "activity");
            qg0.l(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            qg0.l(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            qg0.l(activity, "activity");
        }
    }

    public final void a(um0 um0Var) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            qg0.k(activity, "activity");
            da1.a(activity, um0Var);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(um0.ON_CREATE);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        a(um0.ON_DESTROY);
        this.g = null;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        a(um0.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        ow1 ow1Var = this.g;
        if (ow1Var != null) {
            ((o31) ow1Var.h).b();
        }
        a(um0.ON_RESUME);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        ow1 ow1Var = this.g;
        if (ow1Var != null) {
            o31 o31Var = (o31) ow1Var.h;
            int i = o31Var.g + 1;
            o31Var.g = i;
            if (i == 1 && o31Var.j) {
                o31Var.l.d(um0.ON_START);
                o31Var.j = false;
            }
        }
        a(um0.ON_START);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        a(um0.ON_STOP);
    }
}
