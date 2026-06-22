package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.View;
import defpackage.aa1;
import defpackage.ba1;
import defpackage.gy0;
import defpackage.k92;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzbhd extends ba1 {
    public zzbhd() {
        super("com.google.android.gms.ads.NativeAdViewHolderDelegateCreatorImpl");
    }

    @Override // defpackage.ba1
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        return iInterfaceQueryLocalInterface instanceof zzbfq ? (zzbfq) iInterfaceQueryLocalInterface : new zzbfo(iBinder);
    }

    public final zzbfn zza(View view, HashMap map, HashMap map2) {
        try {
            IBinder iBinderZze = ((zzbfq) getRemoteCreatorInstance(view.getContext())).zze(new gy0(view), new gy0(map), new gy0(map2));
            if (iBinderZze == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZze.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
            return iInterfaceQueryLocalInterface instanceof zzbfn ? (zzbfn) iInterfaceQueryLocalInterface : new zzbfl(iBinderZze);
        } catch (aa1 | RemoteException unused) {
            k92.j(5);
            return null;
        }
    }
}
