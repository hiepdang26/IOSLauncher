package defpackage;

import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;

/* JADX INFO: loaded from: classes.dex */
public interface xs0 {
    void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter);

    void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i);

    void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, h2 h2Var);

    void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter);

    void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter);
}
