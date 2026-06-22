package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public final class ab1 extends gu0 {
    public final /* synthetic */ int c = 1;
    public final Context d;

    public ab1(Context context, int i, int i2) {
        super(i, i2);
        this.d = context;
    }

    @Override // defpackage.gu0
    public final void a(s60 s60Var) {
        Context context = this.d;
        switch (this.c) {
            case 0:
                if (this.b >= 10) {
                    s60Var.r(new Object[]{"reschedule_needed", 1});
                    return;
                } else {
                    context.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
                    return;
                }
            default:
                s60Var.n("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
                if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
                    long j = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
                    long j2 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
                    s60Var.a();
                    try {
                        s60Var.r(new Object[]{"last_cancel_all_time_ms", Long.valueOf(j)});
                        s60Var.r(new Object[]{"reschedule_needed", Long.valueOf(j2)});
                        sharedPreferences.edit().clear().apply();
                        s60Var.D();
                    } finally {
                    }
                }
                SharedPreferences sharedPreferences2 = context.getSharedPreferences("androidx.work.util.id", 0);
                if (sharedPreferences2.contains("next_job_scheduler_id") || sharedPreferences2.contains("next_job_scheduler_id")) {
                    int i = sharedPreferences2.getInt("next_job_scheduler_id", 0);
                    int i2 = sharedPreferences2.getInt("next_alarm_manager_id", 0);
                    s60Var.a();
                    try {
                        s60Var.r(new Object[]{"next_job_scheduler_id", Integer.valueOf(i)});
                        s60Var.r(new Object[]{"next_alarm_manager_id", Integer.valueOf(i2)});
                        sharedPreferences2.edit().clear().apply();
                        s60Var.D();
                        return;
                    } finally {
                    }
                }
                return;
        }
    }

    public ab1(Context context) {
        super(9, 10);
        this.d = context;
    }
}
