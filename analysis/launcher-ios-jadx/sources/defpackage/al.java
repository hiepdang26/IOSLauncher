package defpackage;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.result.a;

/* JADX INFO: loaded from: classes.dex */
public final class al extends a {
    public final /* synthetic */ e6 i;

    public al(e6 e6Var) {
        this.i = e6Var;
    }

    @Override // androidx.activity.result.a
    public final void b(int i, az1 az1Var, Intent intent) {
        Bundle bundleExtra;
        int i2;
        e6 e6Var = this.i;
        mc1 mc1VarT = az1Var.t(e6Var, intent);
        if (mc1VarT != null) {
            new Handler(Looper.getMainLooper()).post(new s1(this, i, mc1VarT, 2));
            return;
        }
        Intent intentL = az1Var.l(e6Var, intent);
        if (intentL.getExtras() != null && intentL.getExtras().getClassLoader() == null) {
            intentL.setExtrasClassLoader(e6Var.getClassLoader());
        }
        if (intentL.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundleExtra = intentL.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            intentL.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        } else {
            bundleExtra = null;
        }
        Bundle bundle = bundleExtra;
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentL.getAction())) {
            String[] stringArrayExtra = intentL.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            np1.E(e6Var, stringArrayExtra, i);
            return;
        }
        if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentL.getAction())) {
            e6Var.startActivityForResult(intentL, i, bundle);
            return;
        }
        lg0 lg0Var = (lg0) intentL.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            i2 = i;
            try {
                e6Var.startIntentSenderForResult(lg0Var.g, i2, lg0Var.h, lg0Var.i, lg0Var.j, 0, bundle);
            } catch (IntentSender.SendIntentException e) {
                e = e;
                new Handler(Looper.getMainLooper()).post(new s1(this, i2, e, 3));
            }
        } catch (IntentSender.SendIntentException e2) {
            e = e2;
            i2 = i;
        }
    }
}
