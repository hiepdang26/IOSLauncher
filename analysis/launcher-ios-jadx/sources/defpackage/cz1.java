package defpackage;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class cz1 extends az1 {
    public static cz1 r;
    public static cz1 s;
    public static final Object t;
    public final Context h;
    public final rl i;
    public final WorkDatabase j;
    public final rm1 k;
    public final List l;
    public final s31 m;
    public final nx0 n;
    public boolean o = false;
    public BroadcastReceiver.PendingResult p;
    public final hz1 q;

    static {
        ka0.r("WorkManagerImpl");
        r = null;
        s = null;
        t = new Object();
    }

    public cz1(Context context, final rl rlVar, rm1 rm1Var, final WorkDatabase workDatabase, final List list, s31 s31Var, hz1 hz1Var) {
        Context applicationContext = context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 24 && bz1.a(applicationContext)) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        ka0 ka0Var = new ka0(3);
        synchronized (ka0.k) {
            ka0.l = ka0Var;
        }
        this.h = applicationContext;
        this.k = rm1Var;
        this.j = workDatabase;
        this.m = s31Var;
        this.q = hz1Var;
        this.i = rlVar;
        this.l = list;
        this.n = new nx0(workDatabase, 21);
        qm0 qm0Var = (qm0) rm1Var;
        final jf1 jf1Var = (jf1) qm0Var.a;
        int i = fe1.a;
        s31Var.a(new h10() { // from class: xd1
            @Override // defpackage.h10
            public final void d(zy1 zy1Var, boolean z) {
                jf1Var.execute(new yd1(list, zy1Var, rlVar, workDatabase, 0));
            }
        });
        qm0Var.e(new n50(applicationContext, this));
    }

    public static cz1 N() {
        synchronized (t) {
            try {
                cz1 cz1Var = r;
                if (cz1Var != null) {
                    return cz1Var;
                }
                return s;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static cz1 O(Context context) {
        cz1 cz1VarN;
        synchronized (t) {
            try {
                cz1VarN = N();
                if (cz1VarN == null) {
                    context.getApplicationContext();
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cz1VarN;
    }

    public static void P(Context context, rl rlVar) {
        synchronized (t) {
            try {
                cz1 cz1Var = r;
                if (cz1Var != null && s != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
                if (cz1Var == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (s == null) {
                        s = os.c(applicationContext, rlVar);
                    }
                    r = s;
                }
            } finally {
            }
        }
    }

    public final void Q() {
        synchronized (t) {
            try {
                this.o = true;
                BroadcastReceiver.PendingResult pendingResult = this.p;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.p = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void R() {
        ArrayList arrayListF;
        if (Build.VERSION.SDK_INT >= 23) {
            int i = ql1.l;
            Context context = this.h;
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (jobScheduler != null && (arrayListF = ql1.f(context, jobScheduler)) != null && !arrayListF.isEmpty()) {
                int size = arrayListF.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayListF.get(i2);
                    i2++;
                    ql1.b(jobScheduler, ((JobInfo) obj).getId());
                }
            }
        }
        WorkDatabase workDatabase = this.j;
        mz1 mz1VarU = workDatabase.u();
        WorkDatabase_Impl workDatabase_Impl = mz1VarU.a;
        workDatabase_Impl.b();
        pm0 pm0Var = mz1VarU.m;
        z60 z60VarA = pm0Var.a();
        workDatabase_Impl.c();
        try {
            z60VarA.a();
            workDatabase_Impl.n();
            workDatabase_Impl.j();
            pm0Var.d(z60VarA);
            fe1.b(this.i, workDatabase, this.l);
        } catch (Throwable th) {
            workDatabase_Impl.j();
            pm0Var.d(z60VarA);
            throw th;
        }
    }
}
