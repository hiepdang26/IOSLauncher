package defpackage;

import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.internal.ads.zzbfy;

/* JADX INFO: loaded from: classes.dex */
public interface zs0 {
    void onAdClicked(MediationNativeAdapter mediationNativeAdapter);

    void onAdClosed(MediationNativeAdapter mediationNativeAdapter);

    void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, h2 h2Var);

    void onAdImpression(MediationNativeAdapter mediationNativeAdapter);

    void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, xp1 xp1Var);

    void onAdOpened(MediationNativeAdapter mediationNativeAdapter);

    void zzd(MediationNativeAdapter mediationNativeAdapter, zzbfy zzbfyVar);

    void zze(MediationNativeAdapter mediationNativeAdapter, zzbfy zzbfyVar, String str);
}
