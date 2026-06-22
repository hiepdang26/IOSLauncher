package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import defpackage.dr;
import defpackage.k92;
import defpackage.ps0;
import defpackage.w2;

/* JADX INFO: loaded from: classes.dex */
public final class zzboi extends zzbol {
    @Override // com.google.android.gms.internal.ads.zzbom
    public final zzbop zzb(String str) throws RemoteException {
        try {
            try {
                Class<?> cls = Class.forName(str, false, zzboi.class.getClassLoader());
                if (ps0.class.isAssignableFrom(cls)) {
                    return new zzbpn((ps0) cls.getDeclaredConstructor(null).newInstance(null));
                }
                if (w2.class.isAssignableFrom(cls)) {
                    return new zzbpn((w2) cls.getDeclaredConstructor(null).newInstance(null));
                }
                k92.h("Could not instantiate mediation adapter: " + str + " (not a valid adapter).");
                throw new RemoteException();
            } catch (Throwable unused) {
                k92.j(5);
                throw new RemoteException();
            }
        } catch (Throwable unused2) {
            k92.d("Reflection failed, retrying using direct instantiation");
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                return new zzbpn(new AdMobAdapter());
            }
            if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                return new zzbpn(new CustomEventAdapter());
            }
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbom
    public final zzbql zzc(String str) {
        return new zzbqy((RtbAdapter) Class.forName(str, false, zzbqp.class.getClassLoader()).getDeclaredConstructor(null).newInstance(null));
    }

    @Override // com.google.android.gms.internal.ads.zzbom
    public final boolean zzd(String str) {
        try {
            return w2.class.isAssignableFrom(Class.forName(str, false, zzboi.class.getClassLoader()));
        } catch (Throwable unused) {
            k92.h("Could not load custom event implementation class as Adapter: " + str + ", assuming old custom event implementation.");
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbom
    public final boolean zze(String str) {
        try {
            return dr.class.isAssignableFrom(Class.forName(str, false, zzboi.class.getClassLoader()));
        } catch (Throwable unused) {
            k92.h("Could not load custom event implementation class: " + str + ", trying Adapter implementation class.");
            return false;
        }
    }
}
