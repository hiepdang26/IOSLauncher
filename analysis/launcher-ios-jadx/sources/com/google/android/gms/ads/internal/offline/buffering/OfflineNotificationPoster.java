package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.internal.ads.zzboi;
import com.google.android.gms.internal.ads.zzbsg;
import defpackage.c22;
import defpackage.eo0;
import defpackage.go0;
import defpackage.gy0;
import defpackage.ho0;
import defpackage.s32;
import defpackage.t22;
import defpackage.wr;
import defpackage.x32;

/* JADX INFO: loaded from: classes.dex */
public class OfflineNotificationPoster extends Worker {
    public final zzbsg l;

    public OfflineNotificationPoster(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        s32 s32Var = x32.f.b;
        zzboi zzboiVar = new zzboi();
        s32Var.getClass();
        this.l = (zzbsg) new t22(context, zzboiVar).d(context, false);
    }

    @Override // androidx.work.Worker
    public final ho0 doWork() {
        try {
            this.l.zzj(new gy0(getApplicationContext()), new c22(getInputData().b("uri"), getInputData().b("gws_query_id"), getInputData().b("image_url")));
            return new go0(wr.b);
        } catch (RemoteException unused) {
            return new eo0();
        }
    }
}
