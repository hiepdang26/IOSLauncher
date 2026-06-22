package com.google.android.gms.ads.mediation.rtb;

import android.os.RemoteException;
import defpackage.bt0;
import defpackage.h2;
import defpackage.ns0;
import defpackage.rs0;
import defpackage.ss0;
import defpackage.tg1;
import defpackage.w2;
import defpackage.wc1;
import defpackage.ws0;
import defpackage.ys0;

/* JADX INFO: loaded from: classes.dex */
public abstract class RtbAdapter extends w2 {
    public abstract void collectSignals(wc1 wc1Var, tg1 tg1Var);

    public void loadRtbAppOpenAd(rs0 rs0Var, ns0 ns0Var) {
        loadAppOpenAd(rs0Var, ns0Var);
    }

    public void loadRtbBannerAd(ss0 ss0Var, ns0 ns0Var) {
        loadBannerAd(ss0Var, ns0Var);
    }

    public void loadRtbInterscrollerAd(ss0 ss0Var, ns0 ns0Var) {
        ns0Var.onFailure(new h2(7, getClass().getSimpleName().concat(" does not support interscroller ads."), "com.google.android.gms.ads", null));
    }

    public void loadRtbInterstitialAd(ws0 ws0Var, ns0 ns0Var) {
        loadInterstitialAd(ws0Var, ns0Var);
    }

    @Deprecated
    public void loadRtbNativeAd(ys0 ys0Var, ns0 ns0Var) {
        loadNativeAd(ys0Var, ns0Var);
    }

    public void loadRtbNativeAdMapper(ys0 ys0Var, ns0 ns0Var) throws RemoteException {
        loadNativeAdMapper(ys0Var, ns0Var);
    }

    public void loadRtbRewardedAd(bt0 bt0Var, ns0 ns0Var) {
        loadRewardedAd(bt0Var, ns0Var);
    }

    public void loadRtbRewardedInterstitialAd(bt0 bt0Var, ns0 ns0Var) {
        loadRewardedInterstitialAd(bt0Var, ns0Var);
    }
}
