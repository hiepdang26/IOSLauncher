package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import defpackage.dy;
import defpackage.gy0;

/* JADX INFO: loaded from: classes.dex */
public final class zzfqj {
    final zzfqm zza;
    final boolean zzb;

    private zzfqj(zzfqm zzfqmVar) {
        this.zza = zzfqmVar;
        this.zzb = zzfqmVar != null;
    }

    public static zzfqj zzb(Context context, String str, String str2) {
        zzfqm zzfqkVar;
        try {
            try {
                try {
                    IBinder iBinderB = dy.c(context, dy.b, ModuleDescriptor.MODULE_ID).b("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
                    if (iBinderB == null) {
                        zzfqkVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                        zzfqkVar = iInterfaceQueryLocalInterface instanceof zzfqm ? (zzfqm) iInterfaceQueryLocalInterface : new zzfqk(iBinderB);
                    }
                    zzfqkVar.zze(new gy0(context), str, null);
                    return new zzfqj(zzfqkVar);
                } catch (Exception e) {
                    throw new zzfpl(e);
                }
            } catch (RemoteException | zzfpl | NullPointerException | SecurityException unused) {
                return new zzfqj(new zzfqn());
            }
        } catch (Exception e2) {
            throw new zzfpl(e2);
        }
    }

    public static zzfqj zzc() {
        return new zzfqj(new zzfqn());
    }

    public final zzfqi zza(byte[] bArr) {
        return new zzfqi(this, bArr, null);
    }
}
