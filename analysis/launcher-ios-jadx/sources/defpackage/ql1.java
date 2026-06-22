package defpackage;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class ql1 implements ud1 {
    public static final /* synthetic */ int l = 0;
    public final Context g;
    public final JobScheduler h;
    public final pl1 i;
    public final WorkDatabase j;
    public final rl k;

    static {
        ka0.r("SystemJobScheduler");
    }

    public ql1(Context context, WorkDatabase workDatabase, rl rlVar) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        pl1 pl1Var = new pl1(context, rlVar.c);
        this.g = context;
        this.h = jobScheduler;
        this.i = pl1Var;
        this.j = workDatabase;
        this.k = rlVar;
    }

    public static void b(JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable unused) {
            ka0 ka0VarJ = ka0.j();
            String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i));
            ka0VarJ.getClass();
        }
    }

    public static ArrayList d(Context context, JobScheduler jobScheduler, String str) {
        ArrayList arrayListF = f(context, jobScheduler);
        if (arrayListF == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        int size = arrayListF.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListF.get(i);
            i++;
            JobInfo jobInfo = (JobInfo) obj;
            zy1 zy1VarG = g(jobInfo);
            if (zy1VarG != null && str.equals(zy1VarG.a)) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    public static ArrayList f(Context context, JobScheduler jobScheduler) {
        List<JobInfo> allPendingJobs;
        try {
            allPendingJobs = jobScheduler.getAllPendingJobs();
        } catch (Throwable unused) {
            ka0.j().getClass();
            allPendingJobs = null;
        }
        if (allPendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allPendingJobs.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : allPendingJobs) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    public static zy1 g(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (!extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new zy1(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION", 0));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // defpackage.ud1
    public final void a(String str) {
        Context context = this.g;
        JobScheduler jobScheduler = this.h;
        ArrayList arrayListD = d(context, jobScheduler, str);
        if (arrayListD == null || arrayListD.isEmpty()) {
            return;
        }
        int size = arrayListD.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListD.get(i);
            i++;
            b(jobScheduler, ((Integer) obj).intValue());
        }
        ol1 ol1VarR = this.j.r();
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) ol1VarR.g;
        workDatabase_Impl.b();
        pm0 pm0Var = (pm0) ol1VarR.j;
        z60 z60VarA = pm0Var.a();
        if (str == null) {
            z60VarA.g(1);
        } else {
            z60VarA.e(1, str);
        }
        workDatabase_Impl.c();
        try {
            z60VarA.a();
            workDatabase_Impl.n();
        } finally {
            workDatabase_Impl.j();
            pm0Var.d(z60VarA);
        }
    }

    @Override // defpackage.ud1
    public final void c(lz1... lz1VarArr) {
        int iIntValue;
        ArrayList arrayListD;
        int iIntValue2;
        WorkDatabase workDatabase = this.j;
        final mc1 mc1Var = new mc1(workDatabase);
        for (lz1 lz1Var : lz1VarArr) {
            workDatabase.c();
            try {
                lz1 lz1VarI = workDatabase.u().i(lz1Var.a);
                if (lz1VarI != null && lz1VarI.b == 1) {
                    zy1 zy1VarI = m90.i(lz1Var);
                    nl1 nl1VarI = workDatabase.r().i(zy1VarI);
                    WorkDatabase workDatabase2 = (WorkDatabase) mc1Var.h;
                    rl rlVar = this.k;
                    if (nl1VarI != null) {
                        iIntValue = nl1VarI.c;
                    } else {
                        rlVar.getClass();
                        final int i = rlVar.g;
                        Object objM = workDatabase2.m(new Callable() { // from class: we0
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                mc1 mc1Var2 = mc1Var;
                                qg0.l(mc1Var2, "this$0");
                                WorkDatabase workDatabase3 = (WorkDatabase) mc1Var2.h;
                                Long lM = workDatabase3.q().m("next_job_scheduler_id");
                                int i2 = 0;
                                int iLongValue = lM != null ? (int) lM.longValue() : 0;
                                workDatabase3.q().p(new u21("next_job_scheduler_id", Long.valueOf(iLongValue == Integer.MAX_VALUE ? 0 : iLongValue + 1)));
                                if (iLongValue < 0 || iLongValue > i) {
                                    workDatabase3.q().p(new u21("next_job_scheduler_id", Long.valueOf(1)));
                                } else {
                                    i2 = iLongValue;
                                }
                                return Integer.valueOf(i2);
                            }
                        });
                        qg0.k(objM, "workDatabase.runInTransa…            id\n        })");
                        iIntValue = ((Number) objM).intValue();
                    }
                    if (nl1VarI == null) {
                        workDatabase.r().j(new nl1(zy1VarI.a, zy1VarI.b, iIntValue));
                    }
                    h(lz1Var, iIntValue);
                    if (Build.VERSION.SDK_INT == 23 && (arrayListD = d(this.g, this.h, lz1Var.a)) != null) {
                        int iIndexOf = arrayListD.indexOf(Integer.valueOf(iIntValue));
                        if (iIndexOf >= 0) {
                            arrayListD.remove(iIndexOf);
                        }
                        if (arrayListD.isEmpty()) {
                            rlVar.getClass();
                            final int i2 = rlVar.g;
                            Object objM2 = workDatabase2.m(new Callable() { // from class: we0
                                @Override // java.util.concurrent.Callable
                                public final Object call() {
                                    mc1 mc1Var2 = mc1Var;
                                    qg0.l(mc1Var2, "this$0");
                                    WorkDatabase workDatabase3 = (WorkDatabase) mc1Var2.h;
                                    Long lM = workDatabase3.q().m("next_job_scheduler_id");
                                    int i22 = 0;
                                    int iLongValue = lM != null ? (int) lM.longValue() : 0;
                                    workDatabase3.q().p(new u21("next_job_scheduler_id", Long.valueOf(iLongValue == Integer.MAX_VALUE ? 0 : iLongValue + 1)));
                                    if (iLongValue < 0 || iLongValue > i2) {
                                        workDatabase3.q().p(new u21("next_job_scheduler_id", Long.valueOf(1)));
                                    } else {
                                        i22 = iLongValue;
                                    }
                                    return Integer.valueOf(i22);
                                }
                            });
                            qg0.k(objM2, "workDatabase.runInTransa…            id\n        })");
                            iIntValue2 = ((Number) objM2).intValue();
                        } else {
                            iIntValue2 = ((Integer) arrayListD.get(0)).intValue();
                        }
                        h(lz1Var, iIntValue2);
                    }
                    workDatabase.n();
                } else {
                    ka0.j().getClass();
                    workDatabase.n();
                }
            } finally {
                workDatabase.j();
            }
        }
    }

    @Override // defpackage.ud1
    public final boolean e() {
        return true;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:217)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final void h(defpackage.lz1 r20, int r21) {
        /*
            Method dump skipped, instruction units count: 460
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ql1.h(lz1, int):void");
    }
}
