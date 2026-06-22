package defpackage;

import android.app.job.JobParameters;
import android.app.job.JobWorkItem;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class mi0 implements li0 {
    public final JobWorkItem a;
    public final /* synthetic */ ni0 b;

    public mi0(ni0 ni0Var, JobWorkItem jobWorkItem) {
        this.b = ni0Var;
        this.a = jobWorkItem;
    }

    @Override // defpackage.li0
    public final void a() {
        synchronized (this.b.b) {
            try {
                JobParameters jobParameters = this.b.c;
                if (jobParameters != null) {
                    jobParameters.completeWork(this.a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.li0
    public final Intent getIntent() {
        return this.a.getIntent();
    }
}
