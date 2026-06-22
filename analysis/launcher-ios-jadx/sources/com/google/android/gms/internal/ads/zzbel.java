package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IInterface;
import android.os.RemoteException;
import defpackage.e42;
import defpackage.jc2;
import defpackage.k92;
import defpackage.nc2;

/* JADX INFO: loaded from: classes.dex */
public final class zzbel {
    private final Context zza;

    public zzbel(Context context) {
        this.zza = context;
    }

    public final void zza(zzbtx zzbtxVar) {
        try {
            ((zzbem) e42.w(this.zza, "com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy", new jc2() { // from class: com.google.android.gms.internal.ads.zzbek
                /* JADX WARN: Multi-variable type inference failed */
                @Override // defpackage.jc2
                public final Object zza(Object obj) {
                    if (obj == 0) {
                        return null;
                    }
                    IInterface iInterfaceQueryLocalInterface = obj.queryLocalInterface("com.google.android.gms.ads.internal.flags.IFlagRetrieverSupplierProxy");
                    return iInterfaceQueryLocalInterface instanceof zzbem ? (zzbem) iInterfaceQueryLocalInterface : new zzbem(obj);
                }
            })).zze(zzbtxVar);
        } catch (RemoteException e) {
            k92.h("Error calling setFlagsAccessedBeforeInitializedListener: ".concat(String.valueOf(e.getMessage())));
        } catch (nc2 e2) {
            k92.h("Could not load com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy:".concat(String.valueOf(e2.getMessage())));
        }
    }
}
