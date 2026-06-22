package defpackage;

import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.SystemAlarmService;

/* JADX INFO: loaded from: classes.dex */
public final class il1 implements ud1 {
    public final Context g;

    static {
        ka0.r("SystemAlarmScheduler");
    }

    public il1(Context context) {
        this.g = context.getApplicationContext();
    }

    @Override // defpackage.ud1
    public final void a(String str) {
        int i = ok.l;
        Context context = this.g;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        context.startService(intent);
    }

    @Override // defpackage.ud1
    public final void c(lz1... lz1VarArr) {
        for (lz1 lz1Var : lz1VarArr) {
            ka0 ka0VarJ = ka0.j();
            String str = lz1Var.a;
            ka0VarJ.getClass();
            zy1 zy1VarI = m90.i(lz1Var);
            int i = ok.l;
            Context context = this.g;
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_SCHEDULE_WORK");
            ok.e(intent, zy1VarI);
            context.startService(intent);
        }
    }

    @Override // defpackage.ud1
    public final boolean e() {
        return true;
    }
}
