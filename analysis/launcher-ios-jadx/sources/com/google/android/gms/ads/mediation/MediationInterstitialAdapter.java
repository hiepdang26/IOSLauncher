package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import defpackage.os0;
import defpackage.ps0;
import defpackage.xs0;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface MediationInterstitialAdapter extends ps0 {
    /* synthetic */ void onDestroy();

    /* synthetic */ void onPause();

    /* synthetic */ void onResume();

    void requestInterstitialAd(Context context, xs0 xs0Var, Bundle bundle, os0 os0Var, Bundle bundle2);

    void showInterstitial();
}
