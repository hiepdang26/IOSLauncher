package defpackage;

import android.content.Context;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class w2 {
    public abstract nr1 getSDKVersionInfo();

    public abstract nr1 getVersionInfo();

    public abstract void initialize(Context context, of0 of0Var, List<jl1> list);

    public void loadAppOpenAd(rs0 rs0Var, ns0 ns0Var) {
        ns0Var.onFailure(new h2(7, getClass().getSimpleName().concat(" does not support app open ads."), "com.google.android.gms.ads", null));
    }

    public void loadBannerAd(ss0 ss0Var, ns0 ns0Var) {
        ns0Var.onFailure(new h2(7, getClass().getSimpleName().concat(" does not support banner ads."), "com.google.android.gms.ads", null));
    }

    public void loadInterscrollerAd(ss0 ss0Var, ns0 ns0Var) {
        ns0Var.onFailure(new h2(7, getClass().getSimpleName().concat(" does not support interscroller ads."), "com.google.android.gms.ads", null));
    }

    public void loadInterstitialAd(ws0 ws0Var, ns0 ns0Var) {
        ns0Var.onFailure(new h2(7, getClass().getSimpleName().concat(" does not support interstitial ads."), "com.google.android.gms.ads", null));
    }

    @Deprecated
    public void loadNativeAd(ys0 ys0Var, ns0 ns0Var) {
        ns0Var.onFailure(new h2(7, getClass().getSimpleName().concat(" does not support native ads."), "com.google.android.gms.ads", null));
    }

    public void loadNativeAdMapper(ys0 ys0Var, ns0 ns0Var) throws RemoteException {
        throw new RemoteException("Method is not found");
    }

    public void loadRewardedAd(bt0 bt0Var, ns0 ns0Var) {
        ns0Var.onFailure(new h2(7, getClass().getSimpleName().concat(" does not support rewarded ads."), "com.google.android.gms.ads", null));
    }

    public void loadRewardedInterstitialAd(bt0 bt0Var, ns0 ns0Var) {
        ns0Var.onFailure(new h2(7, getClass().getSimpleName().concat(" does not support rewarded interstitial ads."), "com.google.android.gms.ads", null));
    }
}
