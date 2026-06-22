package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import defpackage.ab;
import defpackage.bb;
import defpackage.eb;

/* JADX INFO: loaded from: classes.dex */
public final class zzbub extends eb {
    /* JADX WARN: Illegal instructions before constructor call */
    public zzbub(Context context, Looper looper, ab abVar, bb bbVar) {
        Context applicationContext = context.getApplicationContext();
        super(applicationContext != null ? applicationContext : context, looper, abVar, bbVar, 8);
    }

    @Override // defpackage.eb
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsService");
        return iInterfaceQueryLocalInterface instanceof zzbuo ? (zzbuo) iInterfaceQueryLocalInterface : new zzbum(iBinder);
    }

    @Override // defpackage.eb
    public final String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.request.IAdsService";
    }

    @Override // defpackage.eb
    public final String getStartServiceAction() {
        return "com.google.android.gms.ads.service.ADS";
    }

    public final zzbuo zzp() {
        return (zzbuo) getService();
    }
}
