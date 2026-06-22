package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import defpackage.ab;
import defpackage.bb;
import defpackage.k62;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpo extends k62 {
    private final int zze;

    public zzfpo(Context context, Looper looper, ab abVar, bb bbVar, int i) {
        super(context, looper, abVar, bbVar, 116);
        this.zze = i;
    }

    @Override // defpackage.eb
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.IGassService");
        return iInterfaceQueryLocalInterface instanceof zzfpt ? (zzfpt) iInterfaceQueryLocalInterface : new zzfpt(iBinder);
    }

    @Override // defpackage.eb
    public final int getMinApkVersion() {
        return this.zze;
    }

    @Override // defpackage.eb
    public final String getServiceDescriptor() {
        return "com.google.android.gms.gass.internal.IGassService";
    }

    @Override // defpackage.eb
    public final String getStartServiceAction() {
        return "com.google.android.gms.gass.START";
    }

    public final zzfpt zzp() {
        return (zzfpt) getService();
    }
}
