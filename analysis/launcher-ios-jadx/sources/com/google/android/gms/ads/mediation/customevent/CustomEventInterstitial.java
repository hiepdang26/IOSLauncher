package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import defpackage.dr;
import defpackage.fr;
import defpackage.os0;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface CustomEventInterstitial extends dr {
    /* synthetic */ void onDestroy();

    /* synthetic */ void onPause();

    /* synthetic */ void onResume();

    void requestInterstitialAd(Context context, fr frVar, String str, os0 os0Var, Bundle bundle);

    void showInterstitial();
}
