package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.h2;
import defpackage.hg0;
import defpackage.k92;
import defpackage.uo;

/* JADX INFO: loaded from: classes.dex */
public final class zzbpd {
    private final zzbos zza;

    public zzbpd(zzbos zzbosVar) {
        this.zza = zzbosVar;
    }

    public final void onAdClosed() {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdClosed.");
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToShow(h2 h2Var) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdFailedToShow.");
        StringBuilder sbL = uo.l(h2Var.a, "Mediation ad failed to show: Error Code = ", ". Error Message = ");
        sbL.append(h2Var.b);
        sbL.append(" Error Domain = ");
        sbL.append(h2Var.c);
        k92.h(sbL.toString());
        try {
            this.zza.zzk(h2Var.a());
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication() {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdLeftApplication.");
        try {
            this.zza.zzn();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void onAdOpened() {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdOpened.");
        try {
            this.zza.zzp();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoComplete() {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onVideoComplete.");
        try {
            this.zza.zzu();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoMute() {
    }

    public final void onVideoPause() {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onVideoPause.");
        try {
            this.zza.zzw();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoPlay() {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onVideoPlay.");
        try {
            this.zza.zzx();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoUnmute() {
    }

    public final void reportAdClicked() {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called reportAdClicked.");
        try {
            this.zza.zze();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void reportAdImpression() {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called reportAdImpression.");
        try {
            this.zza.zzm();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToShow(String str) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdFailedToShow.");
        k92.h("Mediation ad failed to show: ".concat(String.valueOf(str)));
        try {
            this.zza.zzl(str);
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }
}
