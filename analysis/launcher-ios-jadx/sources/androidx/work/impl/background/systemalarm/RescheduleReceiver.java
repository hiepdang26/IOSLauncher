package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import defpackage.cz1;
import defpackage.ka0;
import defpackage.ok;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {
    static {
        ka0.r("RescheduleReceiver");
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        ka0 ka0VarJ = ka0.j();
        Objects.toString(intent);
        ka0VarJ.getClass();
        if (Build.VERSION.SDK_INT < 23) {
            int i = ok.l;
            Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent2.setAction("ACTION_RESCHEDULE");
            context.startService(intent2);
            return;
        }
        try {
            cz1 cz1VarO = cz1.O(context);
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            synchronized (cz1.t) {
                try {
                    BroadcastReceiver.PendingResult pendingResult = cz1VarO.p;
                    if (pendingResult != null) {
                        pendingResult.finish();
                    }
                    cz1VarO.p = pendingResultGoAsync;
                    if (cz1VarO.o) {
                        pendingResultGoAsync.finish();
                        cz1VarO.p = null;
                    }
                } finally {
                }
            }
        } catch (IllegalStateException unused) {
            ka0.j().getClass();
        }
    }
}
