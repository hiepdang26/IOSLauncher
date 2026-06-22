package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.widget.FrameLayout;
import defpackage.aa1;
import defpackage.ba1;
import defpackage.gy0;
import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
public final class zzbhc extends ba1 {
    public zzbhc() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    @Override // defpackage.ba1
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        return iInterfaceQueryLocalInterface instanceof zzbfk ? (zzbfk) iInterfaceQueryLocalInterface : new zzbfi(iBinder);
    }

    public final zzbfh zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        try {
            IBinder iBinderZze = ((zzbfk) getRemoteCreatorInstance(context)).zze(new gy0(context), new gy0(frameLayout), new gy0(frameLayout2), 242402000);
            if (iBinderZze == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZze.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            return iInterfaceQueryLocalInterface instanceof zzbfh ? (zzbfh) iInterfaceQueryLocalInterface : new zzbff(iBinderZze);
        } catch (aa1 | RemoteException unused) {
            k92.j(5);
            return null;
        }
    }
}
