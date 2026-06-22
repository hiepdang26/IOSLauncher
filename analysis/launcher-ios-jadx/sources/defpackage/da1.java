package defpackage;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import androidx.lifecycle.a;
import defpackage.fa1;

/* JADX INFO: loaded from: classes.dex */
public abstract class da1 {
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Activity activity, um0 um0Var) {
        qg0.l(um0Var, "event");
        if (activity instanceof en0) {
            a aVarL = ((en0) activity).l();
            if (uo.r(aVarL)) {
                aVarL.d(um0Var);
            }
        }
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            fa1.a.Companion.getClass();
            activity.registerActivityLifecycleCallbacks(new fa1.a());
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new fa1(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }
}
