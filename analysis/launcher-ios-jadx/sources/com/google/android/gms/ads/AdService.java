package com.google.android.gms.ads;

import android.app.IntentService;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzboi;
import com.google.android.gms.internal.ads.zzbsg;
import defpackage.k92;
import defpackage.s32;
import defpackage.t22;
import defpackage.x32;

/* JADX INFO: loaded from: classes.dex */
public class AdService extends IntentService {
    public AdService() {
        super("AdService");
    }

    @Override // android.app.IntentService
    public final void onHandleIntent(Intent intent) {
        try {
            s32 s32Var = x32.f.b;
            zzboi zzboiVar = new zzboi();
            s32Var.getClass();
            ((zzbsg) new t22(this, zzboiVar).d(this, false)).zze(intent);
        } catch (RemoteException e) {
            k92.e("RemoteException calling handleNotificationIntent: ".concat(e.toString()));
        }
    }
}
