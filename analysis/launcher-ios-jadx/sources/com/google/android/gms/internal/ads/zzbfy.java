package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import defpackage.gy0;
import defpackage.k92;
import defpackage.ms0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbfy {
    private final zzbfx zza;

    public zzbfy(zzbfx zzbfxVar) {
        Context context;
        this.zza = zzbfxVar;
        try {
            context = (Context) gy0.r(zzbfxVar.zzh());
        } catch (RemoteException | NullPointerException unused) {
            k92.f();
            context = null;
        }
        if (context != null) {
            try {
                this.zza.zzs(new gy0(new ms0(context)));
            } catch (RemoteException unused2) {
                k92.f();
            }
        }
    }

    public final zzbfx zza() {
        return this.zza;
    }

    public final String zzb() {
        try {
            return this.zza.zzi();
        } catch (RemoteException unused) {
            k92.f();
            return null;
        }
    }
}
