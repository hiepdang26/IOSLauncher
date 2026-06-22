package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import defpackage.aa1;
import defpackage.ba1;
import defpackage.gy0;
import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
public final class zzbsk extends ba1 {
    public zzbsk() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    @Override // defpackage.ba1
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        return iInterfaceQueryLocalInterface instanceof zzbsq ? (zzbsq) iInterfaceQueryLocalInterface : new zzbso(iBinder);
    }

    public final zzbsn zza(Activity activity) {
        try {
            IBinder iBinderZze = ((zzbsq) getRemoteCreatorInstance(activity)).zze(new gy0(activity));
            if (iBinderZze == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZze.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            return iInterfaceQueryLocalInterface instanceof zzbsn ? (zzbsn) iInterfaceQueryLocalInterface : new zzbsl(iBinderZze);
        } catch (aa1 unused) {
            k92.j(5);
            return null;
        } catch (RemoteException unused2) {
            k92.j(5);
            return null;
        }
    }
}
