package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import defpackage.h2;
import defpackage.hg0;
import defpackage.k92;
import defpackage.ts0;
import defpackage.uo;
import defpackage.xp1;
import defpackage.xs0;
import defpackage.zs0;

/* JADX INFO: loaded from: classes.dex */
public final class zzbpp implements ts0, xs0, zs0 {
    private final zzbos zza;
    private xp1 zzb;
    private zzbfy zzc;

    public zzbpp(zzbos zzbosVar) {
        this.zza = zzbosVar;
    }

    @Override // defpackage.ts0
    public final void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdClicked.");
        try {
            this.zza.zze();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.ts0
    public final void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdClosed.");
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdFailedToLoad with error. " + i);
        try {
            this.zza.zzg(i);
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.zs0
    public final void onAdImpression(MediationNativeAdapter mediationNativeAdapter) {
        hg0.g("#008 Must be called on the main UI thread.");
        xp1 xp1Var = this.zzb;
        if (this.zzc == null) {
            if (xp1Var == null) {
                k92.i("#007 Could not call remote method.", null);
                return;
            } else if (!xp1Var.m) {
                k92.d("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            }
        }
        k92.d("Adapter called onAdImpression.");
        try {
            this.zza.zzm();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdLeftApplication.");
        try {
            this.zza.zzn();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.ts0
    public final void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdLoaded.");
        try {
            this.zza.zzo();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.ts0
    public final void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdOpened.");
        try {
            this.zza.zzp();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoEnd(MediationNativeAdapter mediationNativeAdapter) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onVideoEnd.");
        try {
            this.zza.zzv();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final xp1 zza() {
        return this.zzb;
    }

    @Override // defpackage.ts0
    public final void zzb(MediationBannerAdapter mediationBannerAdapter, String str, String str2) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAppEvent.");
        try {
            this.zza.zzq(str, str2);
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final zzbfy zzc() {
        return this.zzc;
    }

    @Override // defpackage.zs0
    public final void zzd(MediationNativeAdapter mediationNativeAdapter, zzbfy zzbfyVar) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdLoaded with template id ".concat(String.valueOf(zzbfyVar.zzb())));
        this.zzc = zzbfyVar;
        try {
            this.zza.zzo();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.zs0
    public final void zze(MediationNativeAdapter mediationNativeAdapter, zzbfy zzbfyVar, String str) {
        try {
            this.zza.zzr(zzbfyVar.zza(), str);
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdClicked.");
        try {
            this.zza.zze();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.xs0
    public final void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdClosed.");
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.ts0
    public final void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, h2 h2Var) {
        hg0.g("#008 Must be called on the main UI thread.");
        StringBuilder sbL = uo.l(h2Var.a, "Adapter called onAdFailedToLoad with error. ErrorCode: ", ". ErrorMessage: ");
        sbL.append(h2Var.b);
        sbL.append(". ErrorDomain: ");
        sbL.append(h2Var.c);
        k92.d(sbL.toString());
        try {
            this.zza.zzh(h2Var.a());
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdLeftApplication.");
        try {
            this.zza.zzn();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.xs0
    public final void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdLoaded.");
        try {
            this.zza.zzo();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.xs0
    public final void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdOpened.");
        try {
            this.zza.zzp();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.zs0
    public final void onAdClicked(MediationNativeAdapter mediationNativeAdapter) {
        hg0.g("#008 Must be called on the main UI thread.");
        xp1 xp1Var = this.zzb;
        if (this.zzc == null) {
            if (xp1Var == null) {
                k92.i("#007 Could not call remote method.", null);
                return;
            } else if (!xp1Var.n) {
                k92.d("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            }
        }
        k92.d("Adapter called onAdClicked.");
        try {
            this.zza.zze();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.zs0
    public final void onAdClosed(MediationNativeAdapter mediationNativeAdapter) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdClosed.");
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdLeftApplication.");
        try {
            this.zza.zzn();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.zs0
    public final void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, xp1 xp1Var) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdLoaded.");
        this.zzb = xp1Var;
        if (!(mediationNativeAdapter instanceof AdMobAdapter)) {
            Object obj = new Object();
            new zzbpc();
            synchronized (obj) {
            }
        }
        try {
            this.zza.zzo();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.zs0
    public final void onAdOpened(MediationNativeAdapter mediationNativeAdapter) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdOpened.");
        try {
            this.zza.zzp();
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.xs0
    public final void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.zza.zzg(i);
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.xs0
    public final void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, h2 h2Var) {
        hg0.g("#008 Must be called on the main UI thread.");
        StringBuilder sbL = uo.l(h2Var.a, "Adapter called onAdFailedToLoad with error. ErrorCode: ", ". ErrorMessage: ");
        sbL.append(h2Var.b);
        sbL.append(". ErrorDomain: ");
        sbL.append(h2Var.c);
        k92.d(sbL.toString());
        try {
            this.zza.zzh(h2Var.a());
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i) {
        hg0.g("#008 Must be called on the main UI thread.");
        k92.d("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.zza.zzg(i);
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }

    @Override // defpackage.zs0
    public final void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, h2 h2Var) {
        hg0.g("#008 Must be called on the main UI thread.");
        StringBuilder sbL = uo.l(h2Var.a, "Adapter called onAdFailedToLoad with error. ErrorCode: ", ". ErrorMessage: ");
        sbL.append(h2Var.b);
        sbL.append(". ErrorDomain: ");
        sbL.append(h2Var.c);
        k92.d(sbL.toString());
        try {
            this.zza.zzh(h2Var.a());
        } catch (RemoteException e) {
            k92.i("#007 Could not call remote method.", e);
        }
    }
}
