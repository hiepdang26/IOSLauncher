package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzboi;
import com.google.android.gms.internal.ads.zzbsg;
import defpackage.k92;
import defpackage.s32;
import defpackage.t22;
import defpackage.x32;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationHandlerActivity extends Activity {
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            s32 s32Var = x32.f.b;
            zzboi zzboiVar = new zzboi();
            s32Var.getClass();
            zzbsg zzbsgVar = (zzbsg) new t22(this, zzboiVar).d(this, false);
            if (zzbsgVar == null) {
                k92.e("OfflineUtils is null");
            } else {
                zzbsgVar.zze(getIntent());
            }
        } catch (RemoteException e) {
            k92.e("RemoteException calling handleNotificationIntent: ".concat(e.toString()));
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        finish();
    }
}
