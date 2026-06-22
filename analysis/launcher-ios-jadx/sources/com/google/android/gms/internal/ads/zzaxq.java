package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzaxq extends zzaxn implements zzaxr {
    public static zzaxr zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.clearcut.IClearcut");
        return iInterfaceQueryLocalInterface instanceof zzaxr ? (zzaxr) iInterfaceQueryLocalInterface : new zzaxp(iBinder);
    }
}
