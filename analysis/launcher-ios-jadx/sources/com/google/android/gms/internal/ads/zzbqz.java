package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import defpackage.cc1;
import defpackage.h2;
import defpackage.k92;

/* JADX INFO: loaded from: classes.dex */
final class zzbqz {
    final zzbos zza;

    public zzbqz(zzbos zzbosVar) {
        this.zza = zzbosVar;
    }

    public final void onAdClosed() {
        try {
            this.zza.zzf();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdFailedToShow(h2 h2Var) {
        try {
            k92.h("Mediated ad failed to show: Error Code = " + h2Var.a + ". Error Message = " + h2Var.b + " Error Domain = " + h2Var.c);
            this.zza.zzk(h2Var.a());
        } catch (RemoteException unused) {
        }
    }

    public final void onAdLeftApplication() {
        try {
            this.zza.zzn();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdOpened() {
        try {
            this.zza.zzp();
        } catch (RemoteException unused) {
        }
    }

    public final void onUserEarnedReward(cc1 cc1Var) {
        try {
            this.zza.zzt(new zzbwx(cc1Var));
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoComplete() {
        try {
            this.zza.zzv();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoMute() {
    }

    public final void onVideoPause() {
        try {
            this.zza.zzw();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoPlay() {
        try {
            this.zza.zzx();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoStart() {
        try {
            this.zza.zzy();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoUnmute() {
    }

    public final void reportAdClicked() {
        try {
            this.zza.zze();
        } catch (RemoteException unused) {
        }
    }

    public final void reportAdImpression() {
        try {
            this.zza.zzm();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdFailedToShow(String str) {
        try {
            k92.h("Mediated ad failed to show: " + str);
            this.zza.zzl(str);
        } catch (RemoteException unused) {
        }
    }
}
