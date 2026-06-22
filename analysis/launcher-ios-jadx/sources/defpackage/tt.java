package defpackage;

import android.app.NotificationChannel;
import android.app.job.JobWorkItem;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class tt {
    public static /* synthetic */ NotificationChannel b(String str) {
        return new NotificationChannel("com.google.android.gms.availability", str, 4);
    }

    public static /* synthetic */ JobWorkItem d(Intent intent) {
        return new JobWorkItem(intent);
    }
}
