package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import defpackage.gy0;
import defpackage.k92;
import defpackage.yv0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbrt implements yv0 {
    private final zzbfx zza;

    public zzbrt(zzbfx zzbfxVar) {
        this.zza = zzbfxVar;
        try {
            zzbfxVar.zzm();
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public final void setView(View view) {
        try {
            this.zza.zzp(new gy0(view));
        } catch (RemoteException unused) {
            k92.f();
        }
    }

    public final boolean start() {
        try {
            return this.zza.zzt();
        } catch (RemoteException unused) {
            k92.f();
            return false;
        }
    }
}
