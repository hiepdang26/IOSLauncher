package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import defpackage.ab;
import defpackage.bb;
import defpackage.k62;

/* JADX INFO: loaded from: classes.dex */
public final class zzbty extends k62 {
    public zzbty(Context context, Looper looper, ab abVar, bb bbVar) {
        super(zzbvl.zza(context), looper, abVar, bbVar, 8);
    }

    @Override // defpackage.eb
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        return iInterfaceQueryLocalInterface instanceof zzbuk ? (zzbuk) iInterfaceQueryLocalInterface : new zzbui(iBinder);
    }

    @Override // defpackage.eb
    public final String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    @Override // defpackage.eb
    public final String getStartServiceAction() {
        return "com.google.android.gms.ads.service.START";
    }

    public final zzbuk zzp() {
        return (zzbuk) getService();
    }
}
