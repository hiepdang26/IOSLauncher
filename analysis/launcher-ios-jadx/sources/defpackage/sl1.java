package defpackage;

import android.app.job.JobParameters;
import android.net.Network;

/* JADX INFO: loaded from: classes.dex */
public abstract class sl1 {
    public static Network a(JobParameters jobParameters) {
        return jobParameters.getNetwork();
    }
}
