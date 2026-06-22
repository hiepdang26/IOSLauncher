package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.PersistableBundle;
import defpackage.bj1;
import defpackage.cz1;
import defpackage.h10;
import defpackage.ka0;
import defpackage.q11;
import defpackage.qm0;
import defpackage.rl1;
import defpackage.rm1;
import defpackage.s31;
import defpackage.sl1;
import defpackage.tl1;
import defpackage.wb2;
import defpackage.xm;
import defpackage.zy1;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class SystemJobService extends JobService implements h10 {
    public static final /* synthetic */ int k = 0;
    public cz1 g;
    public final HashMap h = new HashMap();
    public final q11 i = new q11(21);
    public q11 j;

    static {
        ka0.r("SystemJobService");
    }

    public static zy1 a(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new zy1(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // defpackage.h10
    public final void d(zy1 zy1Var, boolean z) {
        JobParameters jobParameters;
        ka0.j().getClass();
        synchronized (this.h) {
            jobParameters = (JobParameters) this.h.remove(zy1Var);
        }
        this.i.M(zy1Var);
        if (jobParameters != null) {
            jobFinished(jobParameters, z);
        }
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        try {
            cz1 cz1VarO = cz1.O(getApplicationContext());
            this.g = cz1VarO;
            s31 s31Var = cz1VarO.m;
            this.j = new q11(s31Var, cz1VarO.k);
            s31Var.a(this);
        } catch (IllegalStateException e) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e);
            }
            ka0.j().getClass();
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        cz1 cz1Var = this.g;
        if (cz1Var != null) {
            cz1Var.m.h(this);
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        wb2 wb2Var;
        if (this.g == null) {
            ka0.j().getClass();
            jobFinished(jobParameters, true);
            return false;
        }
        zy1 zy1VarA = a(jobParameters);
        if (zy1VarA == null) {
            ka0.j().getClass();
            return false;
        }
        synchronized (this.h) {
            try {
                if (this.h.containsKey(zy1VarA)) {
                    ka0 ka0VarJ = ka0.j();
                    zy1VarA.toString();
                    ka0VarJ.getClass();
                    return false;
                }
                ka0 ka0VarJ2 = ka0.j();
                zy1VarA.toString();
                ka0VarJ2.getClass();
                this.h.put(zy1VarA, jobParameters);
                int i = Build.VERSION.SDK_INT;
                if (i >= 24) {
                    wb2Var = new wb2(24);
                    if (rl1.b(jobParameters) != null) {
                        wb2Var.i = Arrays.asList(rl1.b(jobParameters));
                    }
                    if (rl1.a(jobParameters) != null) {
                        wb2Var.h = Arrays.asList(rl1.a(jobParameters));
                    }
                    if (i >= 28) {
                        wb2Var.j = sl1.a(jobParameters);
                    }
                } else {
                    wb2Var = null;
                }
                q11 q11Var = this.j;
                ((qm0) ((rm1) q11Var.i)).e(new xm((s31) q11Var.h, this.i.Q(zy1VarA), wb2Var));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        if (this.g == null) {
            ka0.j().getClass();
            return true;
        }
        zy1 zy1VarA = a(jobParameters);
        if (zy1VarA == null) {
            ka0.j().getClass();
            return false;
        }
        ka0 ka0VarJ = ka0.j();
        zy1VarA.toString();
        ka0VarJ.getClass();
        synchronized (this.h) {
            this.h.remove(zy1VarA);
        }
        bj1 bj1VarM = this.i.M(zy1VarA);
        if (bj1VarM != null) {
            int iA = Build.VERSION.SDK_INT >= 31 ? tl1.a(jobParameters) : -512;
            q11 q11Var = this.j;
            q11Var.getClass();
            q11Var.P(bj1VarM, iA);
        }
        return !this.g.m.f(zy1VarA.a);
    }
}
