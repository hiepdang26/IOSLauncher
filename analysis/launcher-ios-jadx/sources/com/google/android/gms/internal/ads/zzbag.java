package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import defpackage.ab;
import defpackage.bb;
import defpackage.bf1;
import defpackage.k62;
import defpackage.m90;
import defpackage.n42;
import defpackage.v20;

/* JADX INFO: loaded from: classes.dex */
public final class zzbag extends k62 {
    public zzbag(Context context, Looper looper, ab abVar, bb bbVar) {
        super(zzbvl.zza(context), looper, abVar, bbVar, 123);
    }

    @Override // defpackage.eb
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.cache.ICacheService");
        return iInterfaceQueryLocalInterface instanceof zzbaj ? (zzbaj) iInterfaceQueryLocalInterface : new zzbaj(iBinder);
    }

    @Override // defpackage.eb
    public final v20[] getApiFeatures() {
        return m90.g;
    }

    @Override // defpackage.eb
    public final String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.cache.ICacheService";
    }

    @Override // defpackage.eb
    public final String getStartServiceAction() {
        return "com.google.android.gms.ads.service.CACHE";
    }

    public final boolean zzp() {
        v20[] availableFeatures = getAvailableFeatures();
        if (((Boolean) n42.d.c.zza(zzbbw.zzbG)).booleanValue()) {
            v20 v20Var = m90.f;
            int length = availableFeatures != null ? availableFeatures.length : 0;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (!bf1.c(availableFeatures[i], v20Var)) {
                    i++;
                } else if (i >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public final zzbaj zzq() {
        return (zzbaj) getService();
    }
}
