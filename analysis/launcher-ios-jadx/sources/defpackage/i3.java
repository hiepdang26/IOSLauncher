package defpackage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmService;

/* JADX INFO: loaded from: classes.dex */
public abstract class i3 {
    public static final /* synthetic */ int a = 0;

    static {
        ka0.r("Alarms");
    }

    public static void a(Context context, zy1 zy1Var, int i) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        int i2 = ok.l;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        ok.e(intent, zy1Var);
        PendingIntent service = PendingIntent.getService(context, i, intent, Build.VERSION.SDK_INT >= 23 ? 603979776 : 536870912);
        if (service == null || alarmManager == null) {
            return;
        }
        ka0 ka0VarJ = ka0.j();
        zy1Var.toString();
        ka0VarJ.getClass();
        alarmManager.cancel(service);
    }

    public static void b(Context context, WorkDatabase workDatabase, zy1 zy1Var, long j) {
        ol1 ol1VarR = workDatabase.r();
        nl1 nl1VarI = ol1VarR.i(zy1Var);
        if (nl1VarI != null) {
            int i = nl1VarI.c;
            a(context, zy1Var, i);
            c(context, zy1Var, i, j);
        } else {
            Object objM = workDatabase.m(new j7(new mc1(workDatabase), 8));
            qg0.k(objM, "workDatabase.runInTransa…ANAGER_ID_KEY)\n        })");
            int iIntValue = ((Number) objM).intValue();
            ol1VarR.j(new nl1(zy1Var.a, zy1Var.b, iIntValue));
            c(context, zy1Var, iIntValue, j);
        }
    }

    public static void c(Context context, zy1 zy1Var, int i, long j) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        int i2 = Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728;
        int i3 = ok.l;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        ok.e(intent, zy1Var);
        PendingIntent service = PendingIntent.getService(context, i, intent, i2);
        if (alarmManager != null) {
            h3.a(alarmManager, 0, j, service);
        }
    }
}
