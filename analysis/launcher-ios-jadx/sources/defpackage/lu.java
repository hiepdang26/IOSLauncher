package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class lu implements qy0, pz1 {
    public final Context g;
    public final int h;
    public final zy1 i;
    public final hl1 j;
    public final pw1 k;
    public final Object l;
    public int m;
    public final jf1 n;
    public final dz1 o;
    public PowerManager.WakeLock p;
    public boolean q;
    public final bj1 r;
    public final j10 s;
    public volatile ii0 t;

    static {
        ka0.r("DelayMetCommandHandler");
    }

    public lu(Context context, int i, hl1 hl1Var, bj1 bj1Var) {
        this.g = context;
        this.h = i;
        this.j = hl1Var;
        this.i = bj1Var.a;
        this.r = bj1Var;
        hz1 hz1Var = hl1Var.k.q;
        qm0 qm0Var = (qm0) hl1Var.h;
        this.n = (jf1) qm0Var.a;
        this.o = (dz1) qm0Var.d;
        this.s = (j10) qm0Var.b;
        this.k = new pw1(hz1Var);
        this.q = false;
        this.m = 0;
        this.l = new Object();
    }

    public static void a(lu luVar) {
        zy1 zy1Var = luVar.i;
        if (luVar.m >= 2) {
            ka0.j().getClass();
            return;
        }
        luVar.m = 2;
        ka0.j().getClass();
        Context context = luVar.g;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        ok.e(intent, zy1Var);
        hl1 hl1Var = luVar.j;
        int i = luVar.h;
        s1 s1Var = new s1(hl1Var, intent, i, 8);
        dz1 dz1Var = luVar.o;
        dz1Var.execute(s1Var);
        if (!hl1Var.j.g(zy1Var.a)) {
            ka0.j().getClass();
            return;
        }
        ka0.j().getClass();
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_SCHEDULE_WORK");
        ok.e(intent2, zy1Var);
        dz1Var.execute(new s1(hl1Var, intent2, i, 8));
    }

    public static void c(lu luVar) {
        if (luVar.m != 0) {
            ka0 ka0VarJ = ka0.j();
            Objects.toString(luVar.i);
            ka0VarJ.getClass();
            return;
        }
        luVar.m = 1;
        ka0 ka0VarJ2 = ka0.j();
        Objects.toString(luVar.i);
        ka0VarJ2.getClass();
        if (!luVar.j.j.k(luVar.r, null)) {
            luVar.d();
            return;
        }
        rz1 rz1Var = luVar.j.i;
        zy1 zy1Var = luVar.i;
        synchronized (rz1Var.d) {
            ka0 ka0VarJ3 = ka0.j();
            Objects.toString(zy1Var);
            ka0VarJ3.getClass();
            rz1Var.a(zy1Var);
            qz1 qz1Var = new qz1(rz1Var, zy1Var);
            rz1Var.b.put(zy1Var, qz1Var);
            rz1Var.c.put(zy1Var, luVar);
            ((Handler) rz1Var.a.h).postDelayed(qz1Var, 600000L);
        }
    }

    @Override // defpackage.qy0
    public final void b(lz1 lz1Var, sn snVar) {
        boolean z = snVar instanceof qn;
        jf1 jf1Var = this.n;
        if (z) {
            jf1Var.execute(new ku(this, 1));
        } else {
            jf1Var.execute(new ku(this, 0));
        }
    }

    public final void d() {
        synchronized (this.l) {
            try {
                if (this.t != null) {
                    this.t.b(null);
                }
                this.j.i.a(this.i);
                PowerManager.WakeLock wakeLock = this.p;
                if (wakeLock != null && wakeLock.isHeld()) {
                    ka0 ka0VarJ = ka0.j();
                    Objects.toString(this.p);
                    Objects.toString(this.i);
                    ka0VarJ.getClass();
                    this.p.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() throws Throwable {
        String str = this.i.a;
        Context context = this.g;
        StringBuilder sbM = k31.m(str, " (");
        sbM.append(this.h);
        sbM.append(")");
        this.p = jv1.a(context, sbM.toString());
        ka0 ka0VarJ = ka0.j();
        Objects.toString(this.p);
        ka0VarJ.getClass();
        this.p.acquire();
        lz1 lz1VarI = this.j.k.j.u().i(str);
        if (lz1VarI == null) {
            this.n.execute(new ku(this, 0));
            return;
        }
        boolean zB = lz1VarI.b();
        this.q = zB;
        if (zB) {
            this.t = ty1.a(this.k, lz1VarI, this.s, this);
        } else {
            ka0.j().getClass();
            this.n.execute(new ku(this, 1));
        }
    }

    public final void f(boolean z) {
        ka0 ka0VarJ = ka0.j();
        zy1 zy1Var = this.i;
        Objects.toString(zy1Var);
        ka0VarJ.getClass();
        d();
        int i = this.h;
        hl1 hl1Var = this.j;
        dz1 dz1Var = this.o;
        Context context = this.g;
        if (z) {
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_SCHEDULE_WORK");
            ok.e(intent, zy1Var);
            dz1Var.execute(new s1(hl1Var, intent, i, 8));
        }
        if (this.q) {
            Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent2.setAction("ACTION_CONSTRAINTS_CHANGED");
            dz1Var.execute(new s1(hl1Var, intent2, i, 8));
        }
    }
}
