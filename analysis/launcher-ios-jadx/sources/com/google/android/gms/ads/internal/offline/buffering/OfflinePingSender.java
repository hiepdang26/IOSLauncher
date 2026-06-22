package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.internal.ads.zzboi;
import com.google.android.gms.internal.ads.zzbsg;
import defpackage.eo0;
import defpackage.go0;
import defpackage.ho0;
import defpackage.s32;
import defpackage.t22;
import defpackage.wr;
import defpackage.x32;

/* JADX INFO: loaded from: classes.dex */
public class OfflinePingSender extends Worker {
    public final zzbsg l;

    public OfflinePingSender(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        s32 s32Var = x32.f.b;
        zzboi zzboiVar = new zzboi();
        s32Var.getClass();
        this.l = (zzbsg) new t22(context, zzboiVar).d(context, false);
    }

    @Override // androidx.work.Worker
    public final ho0 doWork() {
        try {
            this.l.zzh();
            return new go0(wr.b);
        } catch (RemoteException unused) {
            return new eo0();
        }
    }
}
