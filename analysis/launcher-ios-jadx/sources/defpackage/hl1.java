package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class hl1 implements h10 {
    public static final /* synthetic */ int q = 0;
    public final Context g;
    public final rm1 h;
    public final rz1 i;
    public final s31 j;
    public final cz1 k;
    public final ok l;
    public final ArrayList m;
    public Intent n;
    public SystemAlarmService o;
    public final q11 p;

    static {
        ka0.r("SystemAlarmDispatcher");
    }

    public hl1(SystemAlarmService systemAlarmService) {
        Context applicationContext = systemAlarmService.getApplicationContext();
        this.g = applicationContext;
        q11 q11Var = new q11(21);
        cz1 cz1VarO = cz1.O(systemAlarmService);
        this.k = cz1VarO;
        rl rlVar = cz1VarO.i;
        this.l = new ok(applicationContext, rlVar.c, q11Var);
        this.i = new rz1(rlVar.f);
        s31 s31Var = cz1VarO.m;
        this.j = s31Var;
        rm1 rm1Var = cz1VarO.k;
        this.h = rm1Var;
        this.p = new q11(s31Var, rm1Var);
        s31Var.a(this);
        this.m = new ArrayList();
        this.n = null;
    }

    public static void b() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public final void a(int i, Intent intent) {
        ka0 ka0VarJ = ka0.j();
        Objects.toString(intent);
        ka0VarJ.getClass();
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            ka0.j().getClass();
            return;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && c()) {
            return;
        }
        intent.putExtra("KEY_START_ID", i);
        synchronized (this.m) {
            try {
                boolean zIsEmpty = this.m.isEmpty();
                this.m.add(intent);
                if (zIsEmpty) {
                    e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        b();
        synchronized (this.m) {
            try {
                ArrayList arrayList = this.m;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    if ("ACTION_CONSTRAINTS_CHANGED".equals(((Intent) obj).getAction())) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.h10
    public final void d(zy1 zy1Var, boolean z) {
        dz1 dz1Var = (dz1) ((qm0) this.h).d;
        int i = ok.l;
        Intent intent = new Intent(this.g, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        ok.e(intent, zy1Var);
        dz1Var.execute(new s1(this, intent, 0, 8));
    }

    public final void e() {
        b();
        PowerManager.WakeLock wakeLockA = jv1.a(this.g, "ProcessCommand");
        try {
            wakeLockA.acquire();
            ((qm0) this.k.k).e(new gl1(this, 0));
        } finally {
            wakeLockA.release();
        }
    }
}
