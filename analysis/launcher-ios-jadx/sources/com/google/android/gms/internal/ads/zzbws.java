package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import defpackage.e42;
import defpackage.gy0;
import defpackage.jc2;
import defpackage.k92;
import defpackage.nc2;

/* JADX INFO: loaded from: classes.dex */
public final class zzbws {
    public static final zzbwg zza(Context context, String str, zzbom zzbomVar) {
        try {
            IBinder iBinderZze = ((zzbwk) e42.w(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", new jc2() { // from class: com.google.android.gms.internal.ads.zzbwr
                /* JADX WARN: Multi-variable type inference failed */
                @Override // defpackage.jc2
                public final Object zza(Object obj) {
                    if (obj == 0) {
                        return null;
                    }
                    IInterface iInterfaceQueryLocalInterface = obj.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
                    return iInterfaceQueryLocalInterface instanceof zzbwk ? (zzbwk) iInterfaceQueryLocalInterface : new zzbwk(obj);
                }
            })).zze(new gy0(context), str, zzbomVar, 242402000);
            if (iBinderZze == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZze.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            return iInterfaceQueryLocalInterface instanceof zzbwg ? (zzbwg) iInterfaceQueryLocalInterface : new zzbwe(iBinderZze);
        } catch (RemoteException e) {
            e = e;
            k92.i("#007 Could not call remote method.", e);
            return null;
        } catch (nc2 e2) {
            e = e2;
            k92.i("#007 Could not call remote method.", e);
            return null;
        }
    }
}
