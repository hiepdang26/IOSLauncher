package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class wm extends BroadcastReceiver {
    public static final /* synthetic */ int a = 0;

    static {
        ka0.r("ConstraintProxy");
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        ka0 ka0VarJ = ka0.j();
        Objects.toString(intent);
        ka0VarJ.getClass();
        int i = ok.l;
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_CONSTRAINTS_CHANGED");
        context.startService(intent2);
    }
}
