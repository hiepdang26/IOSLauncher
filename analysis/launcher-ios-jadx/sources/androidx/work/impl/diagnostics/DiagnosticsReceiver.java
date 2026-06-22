package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;
import defpackage.cz1;
import defpackage.ka0;
import defpackage.wb2;

/* JADX INFO: loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {
    static {
        ka0.r("DiagnosticsRcvr");
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        ka0.j().getClass();
        try {
            cz1.O(context).o(new wb2(DiagnosticsWorker.class).k());
        } catch (IllegalStateException unused) {
            ka0.j().getClass();
        }
    }
}
