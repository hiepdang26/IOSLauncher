package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public final class ql extends BroadcastReceiver {
    public final Context a;
    public final float b;
    public final int c;

    public ql(Context context) {
        this.a = context;
        Configuration configuration = context.getResources().getConfiguration();
        this.b = configuration.fontScale;
        this.c = ar1.o ? configuration.densityDpi : 0;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Configuration configuration = context.getResources().getConfiguration();
        if (this.b == configuration.fontScale) {
            if (this.c == (ar1.o ? configuration.densityDpi : 0)) {
                return;
            }
        }
        this.a.unregisterReceiver(this);
        Process.killProcess(Process.myPid());
    }
}
