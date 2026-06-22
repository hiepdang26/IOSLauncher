package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class s31 {
    public final Context b;
    public final rl c;
    public final qm0 d;
    public final WorkDatabase e;
    public final HashMap g = new HashMap();
    public final HashMap f = new HashMap();
    public final HashSet i = new HashSet();
    public final ArrayList j = new ArrayList();
    public PowerManager.WakeLock a = null;
    public final Object k = new Object();
    public final HashMap h = new HashMap();

    static {
        ka0.r("Processor");
    }

    public s31(Context context, rl rlVar, qm0 qm0Var, WorkDatabase workDatabase) {
        this.b = context;
        this.c = rlVar;
        this.d = qm0Var;
        this.e = workDatabase;
    }

    public static boolean e(uz1 uz1Var, int i) {
        if (uz1Var == null) {
            ka0.j().getClass();
            return false;
        }
        uz1Var.x = i;
        uz1Var.h();
        uz1Var.w.cancel(true);
        if (uz1Var.k == null || !(uz1Var.w.g instanceof h)) {
            Objects.toString(uz1Var.j);
            ka0.j().getClass();
        } else {
            uz1Var.k.stop(i);
        }
        ka0.j().getClass();
        return true;
    }

    public final void a(h10 h10Var) {
        synchronized (this.k) {
            this.j.add(h10Var);
        }
    }

    public final uz1 b(String str) {
        uz1 uz1Var = (uz1) this.f.remove(str);
        boolean z = uz1Var != null;
        if (!z) {
            uz1Var = (uz1) this.g.remove(str);
        }
        this.h.remove(str);
        if (z) {
            synchronized (this.k) {
                try {
                    if (this.f.isEmpty()) {
                        Context context = this.b;
                        int i = kl1.p;
                        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
                        intent.setAction("ACTION_STOP_FOREGROUND");
                        try {
                            this.b.startService(intent);
                        } catch (Throwable unused) {
                            ka0.j().getClass();
                        }
                        PowerManager.WakeLock wakeLock = this.a;
                        if (wakeLock != null) {
                            wakeLock.release();
                            this.a = null;
                        }
                    }
                } finally {
                }
            }
        }
        return uz1Var;
    }

    public final lz1 c(String str) {
        synchronized (this.k) {
            try {
                uz1 uz1VarD = d(str);
                if (uz1VarD == null) {
                    return null;
                }
                return uz1VarD.j;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final uz1 d(String str) {
        uz1 uz1Var = (uz1) this.f.get(str);
        return uz1Var == null ? (uz1) this.g.get(str) : uz1Var;
    }

    public final boolean f(String str) {
        boolean zContains;
        synchronized (this.k) {
            zContains = this.i.contains(str);
        }
        return zContains;
    }

    public final boolean g(String str) {
        boolean z;
        synchronized (this.k) {
            z = d(str) != null;
        }
        return z;
    }

    public final void h(h10 h10Var) {
        synchronized (this.k) {
            this.j.remove(h10Var);
        }
    }

    public final void i(zy1 zy1Var) {
        qm0 qm0Var = this.d;
        ((dz1) qm0Var.d).execute(new wc(this, zy1Var, 15));
    }

    public final void j(String str, o50 o50Var) {
        synchronized (this.k) {
            try {
                ka0.j().getClass();
                uz1 uz1Var = (uz1) this.g.remove(str);
                if (uz1Var != null) {
                    if (this.a == null) {
                        PowerManager.WakeLock wakeLockA = jv1.a(this.b, "ProcessorForegroundLck");
                        this.a = wakeLockA;
                        wakeLockA.acquire();
                    }
                    this.f.put(str, uz1Var);
                    Intent intentC = kl1.c(this.b, m90.i(uz1Var.j), o50Var);
                    Context context = this.b;
                    if (Build.VERSION.SDK_INT >= 26) {
                        ao.p(context, intentC);
                    } else {
                        context.startService(intentC);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean k(bj1 bj1Var, wb2 wb2Var) {
        zy1 zy1Var = bj1Var.a;
        final String str = zy1Var.a;
        final ArrayList arrayList = new ArrayList();
        lz1 lz1Var = (lz1) this.e.m(new Callable() { // from class: r31
            @Override // java.util.concurrent.Callable
            public final Object call() {
                WorkDatabase workDatabase = this.g.e;
                oz1 oz1VarV = workDatabase.v();
                String str2 = str;
                arrayList.addAll(oz1VarV.e(str2));
                return workDatabase.u().i(str2);
            }
        });
        if (lz1Var == null) {
            ka0 ka0VarJ = ka0.j();
            zy1Var.toString();
            ka0VarJ.getClass();
            i(zy1Var);
            return false;
        }
        synchronized (this.k) {
            try {
                if (g(str)) {
                    Set set = (Set) this.h.get(str);
                    if (((bj1) set.iterator().next()).a.b == zy1Var.b) {
                        set.add(bj1Var);
                        ka0 ka0VarJ2 = ka0.j();
                        zy1Var.toString();
                        ka0VarJ2.getClass();
                    } else {
                        i(zy1Var);
                    }
                    return false;
                }
                if (lz1Var.t != zy1Var.b) {
                    i(zy1Var);
                    return false;
                }
                Context context = this.b;
                rl rlVar = this.c;
                qm0 qm0Var = this.d;
                WorkDatabase workDatabase = this.e;
                ry ryVar = new ry();
                ryVar.h = new wb2(24);
                ryVar.a = context.getApplicationContext();
                ryVar.c = qm0Var;
                ryVar.b = this;
                ryVar.d = rlVar;
                ryVar.e = workDatabase;
                ryVar.f = lz1Var;
                ryVar.g = arrayList;
                if (wb2Var != null) {
                    ryVar.h = wb2Var;
                }
                uz1 uz1Var = new uz1(ryVar);
                nf1 nf1Var = uz1Var.v;
                nf1Var.addListener(new bd(this, nf1Var, uz1Var, 9), (dz1) this.d.d);
                this.g.put(str, uz1Var);
                HashSet hashSet = new HashSet();
                hashSet.add(bj1Var);
                this.h.put(str, hashSet);
                ((jf1) this.d.a).execute(uz1Var);
                ka0 ka0VarJ3 = ka0.j();
                zy1Var.toString();
                ka0VarJ3.getClass();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l(bj1 bj1Var, int i) {
        String str = bj1Var.a.a;
        synchronized (this.k) {
            try {
                if (this.f.get(str) != null) {
                    ka0.j().getClass();
                    return;
                }
                Set set = (Set) this.h.get(str);
                if (set != null && set.contains(bj1Var)) {
                    e(b(str), i);
                }
            } finally {
            }
        }
    }
}
