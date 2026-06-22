package defpackage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.utils.ForceStopRunnable$BroadcastReceiver;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class n50 implements Runnable {
    public static final long k;
    public final Context g;
    public final cz1 h;
    public final nx0 i;
    public int j = 0;

    static {
        ka0.r("ForceStopRunnable");
        k = TimeUnit.DAYS.toMillis(3650L);
    }

    public n50(Context context, cz1 cz1Var) {
        this.g = context.getApplicationContext();
        this.h = cz1Var;
        this.i = cz1Var.n;
    }

    public static void b(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        int i = Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) ForceStopRunnable$BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent, i);
        long jCurrentTimeMillis = System.currentTimeMillis() + k;
        if (alarmManager != null) {
            alarmManager.setExact(0, jCurrentTimeMillis, broadcast);
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            Method dump skipped, instruction units count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.n50.a():void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zA;
        cz1 cz1Var = this.h;
        try {
            rl rlVar = cz1Var.i;
            rlVar.getClass();
            boolean zIsEmpty = TextUtils.isEmpty(null);
            Context context = this.g;
            if (zIsEmpty) {
                ka0.j().getClass();
                zA = true;
            } else {
                zA = q31.a(context, rlVar);
                ka0.j().getClass();
            }
            if (!zA) {
                return;
            }
            while (true) {
                try {
                    wd.v(context);
                    ka0.j().getClass();
                    try {
                        a();
                        return;
                    } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteTableLockedException e) {
                        int i = this.j + 1;
                        this.j = i;
                        if (i >= 3) {
                            String str = Build.VERSION.SDK_INT >= 24 ? sl.f(context) : true ? "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store." : "WorkManager can't be accessed from direct boot, because credential encrypted storage isn't accessible.\nDon't access or initialise WorkManager from directAware components. See https://developer.android.com/training/articles/direct-boot";
                            ka0.j().getClass();
                            IllegalStateException illegalStateException = new IllegalStateException(str, e);
                            cz1Var.i.getClass();
                            throw illegalStateException;
                        }
                        ka0.j().getClass();
                        try {
                            Thread.sleep(((long) this.j) * 300);
                        } catch (InterruptedException unused) {
                        }
                    }
                } catch (SQLiteException e2) {
                    ka0.j().getClass();
                    IllegalStateException illegalStateException2 = new IllegalStateException("Unexpected SQLite exception during migrations", e2);
                    cz1Var.i.getClass();
                    throw illegalStateException2;
                }
            }
        } finally {
            cz1Var.Q();
        }
    }
}
