package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import defpackage.cz1;
import defpackage.ka0;
import defpackage.qm0;
import defpackage.xm;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int a = 0;

    static {
        ka0.r("ConstrntProxyUpdtRecvr");
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(intent != null ? intent.getAction() : null)) {
            ka0.j().getClass();
            return;
        }
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        ((qm0) cz1.O(context).k).e(new xm(intent, context, pendingResultGoAsync, 0));
    }
}
