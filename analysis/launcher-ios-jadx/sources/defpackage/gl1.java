package defpackage;

import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class gl1 implements Runnable {
    public final /* synthetic */ int g;
    public final hl1 h;

    public /* synthetic */ gl1(hl1 hl1Var, int i) {
        this.g = i;
        this.h = hl1Var;
    }

    private final void a() {
        int i = 1;
        synchronized (this.h.m) {
            hl1 hl1Var = this.h;
            hl1Var.n = (Intent) hl1Var.m.get(0);
        }
        Intent intent = this.h.n;
        if (intent != null) {
            String action = intent.getAction();
            int intExtra = this.h.n.getIntExtra("KEY_START_ID", 0);
            ka0 ka0VarJ = ka0.j();
            int i2 = hl1.q;
            Objects.toString(this.h.n);
            ka0VarJ.getClass();
            PowerManager.WakeLock wakeLockA = jv1.a(this.h.g, action + " (" + intExtra + ")");
            try {
                try {
                    ka0 ka0VarJ2 = ka0.j();
                    wakeLockA.toString();
                    ka0VarJ2.getClass();
                    wakeLockA.acquire();
                    hl1 hl1Var2 = this.h;
                    hl1Var2.l.b(hl1Var2.n, intExtra, hl1Var2);
                    ka0 ka0VarJ3 = ka0.j();
                    wakeLockA.toString();
                    ka0VarJ3.getClass();
                    wakeLockA.release();
                    hl1 hl1Var3 = this.h;
                    ((dz1) ((qm0) hl1Var3.h).d).execute(new gl1(hl1Var3, i));
                } catch (Throwable th) {
                    ka0 ka0VarJ4 = ka0.j();
                    int i3 = hl1.q;
                    wakeLockA.toString();
                    ka0VarJ4.getClass();
                    wakeLockA.release();
                    hl1 hl1Var4 = this.h;
                    ((dz1) ((qm0) hl1Var4.h).d).execute(new gl1(hl1Var4, i));
                    throw th;
                }
            } catch (Throwable unused) {
                ka0 ka0VarJ5 = ka0.j();
                int i4 = hl1.q;
                ka0VarJ5.getClass();
                ka0 ka0VarJ6 = ka0.j();
                wakeLockA.toString();
                ka0VarJ6.getClass();
                wakeLockA.release();
                hl1 hl1Var5 = this.h;
                ((dz1) ((qm0) hl1Var5.h).d).execute(new gl1(hl1Var5, i));
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                a();
                return;
            default:
                hl1 hl1Var = this.h;
                hl1Var.getClass();
                ka0.j().getClass();
                hl1.b();
                synchronized (hl1Var.m) {
                    try {
                        if (hl1Var.n != null) {
                            ka0 ka0VarJ = ka0.j();
                            Objects.toString(hl1Var.n);
                            ka0VarJ.getClass();
                            if (!((Intent) hl1Var.m.remove(0)).equals(hl1Var.n)) {
                                throw new IllegalStateException("Dequeue-d command is not the first.");
                            }
                            hl1Var.n = null;
                        }
                        jf1 jf1Var = (jf1) ((qm0) hl1Var.h).a;
                        if (!hl1Var.l.a() && hl1Var.m.isEmpty() && !jf1Var.a()) {
                            ka0.j().getClass();
                            SystemAlarmService systemAlarmService = hl1Var.o;
                            if (systemAlarmService != null) {
                                systemAlarmService.b();
                            }
                        } else if (!hl1Var.m.isEmpty()) {
                            hl1Var.e();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }
}
