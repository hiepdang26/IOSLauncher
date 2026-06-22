package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.k92;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzfbq {
    public static void zza(AtomicReference atomicReference, zzfbp zzfbpVar) {
        Object obj = atomicReference.get();
        if (obj == null) {
            return;
        }
        try {
            zzfbpVar.zza(obj);
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        } catch (NullPointerException unused) {
            k92.j(5);
        }
    }
}
