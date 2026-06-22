package defpackage;

import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.work.WorkerParameters;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class io0 {
    public final Context g;
    public final WorkerParameters h;
    public volatile int i = -256;
    public boolean j;

    public io0(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.g = context;
        this.h = workerParameters;
    }

    public final Context getApplicationContext() {
        return this.g;
    }

    public Executor getBackgroundExecutor() {
        return this.h.f;
    }

    public do0 getForegroundInfoAsync() {
        nf1 nf1Var = new nf1();
        nf1Var.j(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return nf1Var;
    }

    public final UUID getId() {
        return this.h.a;
    }

    public final wr getInputData() {
        return this.h.b;
    }

    public final Network getNetwork() {
        return (Network) this.h.d.j;
    }

    public final int getRunAttemptCount() {
        return this.h.e;
    }

    public final int getStopReason() {
        return this.i;
    }

    public final Set<String> getTags() {
        return this.h.c;
    }

    public rm1 getTaskExecutor() {
        return this.h.g;
    }

    public final List<String> getTriggeredContentAuthorities() {
        return (List) this.h.d.h;
    }

    public final List<Uri> getTriggeredContentUris() {
        return (List) this.h.d.i;
    }

    public tz1 getWorkerFactory() {
        return this.h.h;
    }

    public final boolean isStopped() {
        return this.i != -256;
    }

    public final boolean isUsed() {
        return this.j;
    }

    public final do0 setForegroundAsync(o50 o50Var) {
        yy1 yy1Var = this.h.j;
        Context applicationContext = getApplicationContext();
        UUID id = getId();
        yy1Var.getClass();
        nf1 nf1Var = new nf1();
        yy1Var.a.e(new sj0(yy1Var, nf1Var, id, o50Var, applicationContext, 2));
        return nf1Var;
    }

    public do0 setProgressAsync(wr wrVar) {
        iz1 iz1Var = this.h.i;
        getApplicationContext();
        UUID id = getId();
        iz1Var.getClass();
        nf1 nf1Var = new nf1();
        iz1Var.b.e(new ng(iz1Var, id, wrVar, nf1Var, 11));
        return nf1Var;
    }

    public final void setUsed() {
        this.j = true;
    }

    public abstract do0 startWork();

    public final void stop(int i) {
        this.i = i;
        onStopped();
    }

    public void onStopped() {
    }
}
