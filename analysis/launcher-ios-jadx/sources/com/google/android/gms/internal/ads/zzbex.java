package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import defpackage.k92;
import defpackage.ov0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbex {
    private final zzbew zza;
    private final List zzb = new ArrayList();
    private String zzc;

    public zzbex(zzbew zzbewVar) {
        IBinder iBinder;
        this.zza = zzbewVar;
        try {
            this.zzc = zzbewVar.zzg();
        } catch (RemoteException unused) {
            k92.f();
            this.zzc = "";
        }
        try {
            for (Object obj : zzbewVar.zzh()) {
                zzbfd zzbfbVar = null;
                if ((obj instanceof IBinder) && (iBinder = (IBinder) obj) != null) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzbfbVar = iInterfaceQueryLocalInterface instanceof zzbfd ? (zzbfd) iInterfaceQueryLocalInterface : new zzbfb(iBinder);
                }
                if (zzbfbVar != null) {
                    this.zzb.add(new zzbfe(zzbfbVar));
                }
            }
        } catch (RemoteException unused2) {
            k92.f();
        }
    }

    public final List<ov0> getImages() {
        return this.zzb;
    }

    public final CharSequence getText() {
        return this.zzc;
    }
}
