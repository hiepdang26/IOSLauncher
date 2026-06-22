package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import defpackage.go0;
import defpackage.ho0;
import defpackage.qg0;

/* JADX INFO: loaded from: classes.dex */
public final class CombineContinuationsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineContinuationsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        qg0.l(context, "context");
        qg0.l(workerParameters, "workerParams");
    }

    @Override // androidx.work.Worker
    public final ho0 doWork() {
        return new go0(getInputData());
    }
}
