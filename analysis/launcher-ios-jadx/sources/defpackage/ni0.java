package defpackage;

import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;

/* JADX INFO: loaded from: classes.dex */
public final class ni0 extends JobServiceEngine {
    public final qi0 a;
    public final Object b;
    public JobParameters c;

    public ni0(qi0 qi0Var) {
        super(qi0Var);
        this.b = new Object();
        this.a = qi0Var;
    }

    public final mi0 a() {
        synchronized (this.b) {
            JobParameters jobParameters = this.c;
            if (jobParameters == null) {
                return null;
            }
            JobWorkItem jobWorkItemDequeueWork = jobParameters.dequeueWork();
            if (jobWorkItemDequeueWork == null) {
                return null;
            }
            jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.a.getClassLoader());
            return new mi0(this, jobWorkItemDequeueWork);
        }
    }

    @Override // android.app.job.JobServiceEngine
    public final boolean onStartJob(JobParameters jobParameters) {
        this.c = jobParameters;
        this.a.a(false);
        return true;
    }

    @Override // android.app.job.JobServiceEngine
    public final boolean onStopJob(JobParameters jobParameters) {
        qy qyVar = this.a.i;
        if (qyVar != null) {
            qyVar.cancel(false);
        }
        synchronized (this.b) {
            this.c = null;
        }
        return true;
    }
}
