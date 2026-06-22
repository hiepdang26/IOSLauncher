package defpackage;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class oi0 extends pi0 {
    public final JobInfo d;
    public final JobScheduler e;

    public oi0(Context context, ComponentName componentName, int i) {
        super(componentName);
        b(i);
        this.d = new JobInfo.Builder(i, componentName).setOverrideDeadline(0L).build();
        this.e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
    }

    @Override // defpackage.pi0
    public final void a(Intent intent) {
        this.e.enqueue(this.d, tt.d(intent));
    }
}
