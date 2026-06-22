package defpackage;

import android.content.Context;
import android.os.PowerManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class jv1 {
    public static final /* synthetic */ int a = 0;

    static {
        qg0.k(ka0.r("WakeLocks"), "tagWithPrefix(\"WakeLocks\")");
    }

    public static final PowerManager.WakeLock a(Context context, String str) {
        qg0.l(context, "context");
        qg0.l(str, "tag");
        Object systemService = context.getApplicationContext().getSystemService("power");
        qg0.i(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        String strConcat = "WorkManager: ".concat(str);
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService).newWakeLock(1, strConcat);
        synchronized (kv1.a) {
        }
        qg0.k(wakeLockNewWakeLock, "wakeLock");
        return wakeLockNewWakeLock;
    }
}
