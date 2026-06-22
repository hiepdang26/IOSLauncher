package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ok implements h10 {
    public static final /* synthetic */ int l = 0;
    public final Context g;
    public final HashMap h = new HashMap();
    public final Object i = new Object();
    public final jl1 j;
    public final q11 k;

    static {
        ka0.r("CommandHandler");
    }

    public ok(Context context, jl1 jl1Var, q11 q11Var) {
        this.g = context;
        this.j = jl1Var;
        this.k = q11Var;
    }

    public static zy1 c(Intent intent) {
        return new zy1(intent.getStringExtra("KEY_WORKSPEC_ID"), intent.getIntExtra("KEY_WORKSPEC_GENERATION", 0));
    }

    public static void e(Intent intent, zy1 zy1Var) {
        intent.putExtra("KEY_WORKSPEC_ID", zy1Var.a);
        intent.putExtra("KEY_WORKSPEC_GENERATION", zy1Var.b);
    }

    public final boolean a() {
        boolean z;
        synchronized (this.i) {
            z = !this.h.isEmpty();
        }
        return z;
    }

    public final void b(Intent intent, int i, hl1 hl1Var) {
        List<bj1> listN;
        int i2 = 8;
        String action = intent.getAction();
        int i3 = 0;
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            ka0 ka0VarJ = ka0.j();
            Objects.toString(intent);
            ka0VarJ.getClass();
            pn pnVar = new pn(this.g, this.j, i, hl1Var);
            ArrayList arrayListE = hl1Var.k.j.u().e();
            int i4 = wm.a;
            int size = arrayListE.size();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayListE.get(i5);
                i5++;
                nn nnVar = ((lz1) obj).j;
                z |= nnVar.d;
                z2 |= nnVar.b;
                z3 |= nnVar.e;
                z4 |= nnVar.a != 1;
                if (z && z2 && z3 && z4) {
                    break;
                }
            }
            int i6 = ConstraintProxyUpdateReceiver.a;
            Intent intent2 = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
            Context context = pnVar.a;
            intent2.setComponent(new ComponentName(context, (Class<?>) ConstraintProxyUpdateReceiver.class));
            intent2.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z2).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z3).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z4);
            context.sendBroadcast(intent2);
            ArrayList arrayList = new ArrayList(arrayListE.size());
            pnVar.b.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            int size2 = arrayListE.size();
            int i7 = 0;
            while (i7 < size2) {
                Object obj2 = arrayListE.get(i7);
                i7++;
                lz1 lz1Var = (lz1) obj2;
                if (jCurrentTimeMillis >= lz1Var.a() && (!lz1Var.b() || pnVar.d.a(lz1Var))) {
                    arrayList.add(lz1Var);
                }
            }
            int size3 = arrayList.size();
            while (i3 < size3) {
                Object obj3 = arrayList.get(i3);
                i3++;
                lz1 lz1Var2 = (lz1) obj3;
                String str = lz1Var2.a;
                zy1 zy1VarI = m90.i(lz1Var2);
                Intent intent3 = new Intent(context, (Class<?>) SystemAlarmService.class);
                intent3.setAction("ACTION_DELAY_MET");
                e(intent3, zy1VarI);
                ka0.j().getClass();
                ((dz1) ((qm0) hl1Var.h).d).execute(new s1(hl1Var, intent3, pnVar.c, i2));
            }
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            ka0 ka0VarJ2 = ka0.j();
            Objects.toString(intent);
            ka0VarJ2.getClass();
            hl1Var.k.R();
            return;
        }
        Bundle extras = intent.getExtras();
        String[] strArr = {"KEY_WORKSPEC_ID"};
        if (extras == null || extras.isEmpty() || extras.get(strArr[0]) == null) {
            ka0.j().getClass();
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            zy1 zy1VarC = c(intent);
            ka0 ka0VarJ3 = ka0.j();
            zy1VarC.toString();
            ka0VarJ3.getClass();
            WorkDatabase workDatabase = hl1Var.k.j;
            workDatabase.c();
            try {
                lz1 lz1VarI = workDatabase.u().i(zy1VarC.a);
                if (lz1VarI == null) {
                    ka0 ka0VarJ4 = ka0.j();
                    zy1VarC.toString();
                    ka0VarJ4.getClass();
                    return;
                }
                if (k31.d(lz1VarI.b)) {
                    ka0 ka0VarJ5 = ka0.j();
                    zy1VarC.toString();
                    ka0VarJ5.getClass();
                    return;
                }
                long jA = lz1VarI.a();
                boolean zB = lz1VarI.b();
                Context context2 = this.g;
                if (zB) {
                    ka0 ka0VarJ6 = ka0.j();
                    zy1VarC.toString();
                    ka0VarJ6.getClass();
                    i3.b(context2, workDatabase, zy1VarC, jA);
                    Intent intent4 = new Intent(context2, (Class<?>) SystemAlarmService.class);
                    intent4.setAction("ACTION_CONSTRAINTS_CHANGED");
                    ((dz1) ((qm0) hl1Var.h).d).execute(new s1(hl1Var, intent4, i, i2));
                } else {
                    ka0 ka0VarJ7 = ka0.j();
                    zy1VarC.toString();
                    ka0VarJ7.getClass();
                    i3.b(context2, workDatabase, zy1VarC, jA);
                }
                workDatabase.n();
                return;
            } finally {
                workDatabase.j();
            }
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            synchronized (this.i) {
                try {
                    zy1 zy1VarC2 = c(intent);
                    ka0 ka0VarJ8 = ka0.j();
                    zy1VarC2.toString();
                    ka0VarJ8.getClass();
                    if (this.h.containsKey(zy1VarC2)) {
                        ka0 ka0VarJ9 = ka0.j();
                        zy1VarC2.toString();
                        ka0VarJ9.getClass();
                    } else {
                        lu luVar = new lu(this.g, i, hl1Var, this.k.Q(zy1VarC2));
                        this.h.put(zy1VarC2, luVar);
                        luVar.e();
                    }
                } finally {
                }
            }
            return;
        }
        if (!"ACTION_STOP_WORK".equals(action)) {
            if (!"ACTION_EXECUTION_COMPLETED".equals(action)) {
                ka0 ka0VarJ10 = ka0.j();
                intent.toString();
                ka0VarJ10.getClass();
                return;
            } else {
                zy1 zy1VarC3 = c(intent);
                boolean z5 = intent.getExtras().getBoolean("KEY_NEEDS_RESCHEDULE");
                ka0 ka0VarJ11 = ka0.j();
                intent.toString();
                ka0VarJ11.getClass();
                d(zy1VarC3, z5);
                return;
            }
        }
        Bundle extras2 = intent.getExtras();
        String string = extras2.getString("KEY_WORKSPEC_ID");
        boolean zContainsKey = extras2.containsKey("KEY_WORKSPEC_GENERATION");
        q11 q11Var = this.k;
        if (zContainsKey) {
            int i8 = extras2.getInt("KEY_WORKSPEC_GENERATION");
            ArrayList arrayList2 = new ArrayList(1);
            bj1 bj1VarM = q11Var.M(new zy1(string, i8));
            listN = arrayList2;
            if (bj1VarM != null) {
                arrayList2.add(bj1VarM);
                listN = arrayList2;
            }
        } else {
            listN = q11Var.N(string);
        }
        for (bj1 bj1Var : listN) {
            ka0.j().getClass();
            q11 q11Var2 = hl1Var.p;
            q11Var2.getClass();
            qg0.l(bj1Var, "workSpecId");
            q11Var2.P(bj1Var, -512);
            WorkDatabase workDatabase2 = hl1Var.k.j;
            int i9 = i3.a;
            ol1 ol1VarR = workDatabase2.r();
            zy1 zy1Var = bj1Var.a;
            nl1 nl1VarI = ol1VarR.i(zy1Var);
            if (nl1VarI != null) {
                i3.a(this.g, zy1Var, nl1VarI.c);
                ka0 ka0VarJ12 = ka0.j();
                zy1Var.toString();
                ka0VarJ12.getClass();
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) ol1VarR.g;
                workDatabase_Impl.b();
                pm0 pm0Var = (pm0) ol1VarR.i;
                z60 z60VarA = pm0Var.a();
                String str2 = zy1Var.a;
                if (str2 == null) {
                    z60VarA.g(1);
                } else {
                    z60VarA.e(1, str2);
                }
                z60VarA.q(2, zy1Var.b);
                workDatabase_Impl.c();
                try {
                    z60VarA.a();
                    workDatabase_Impl.n();
                } finally {
                    workDatabase_Impl.j();
                    pm0Var.d(z60VarA);
                }
            }
            hl1Var.d(zy1Var, false);
        }
    }

    @Override // defpackage.h10
    public final void d(zy1 zy1Var, boolean z) {
        synchronized (this.i) {
            try {
                lu luVar = (lu) this.h.remove(zy1Var);
                this.k.M(zy1Var);
                if (luVar != null) {
                    luVar.f(z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
