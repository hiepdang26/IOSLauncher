package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import defpackage.os0;
import defpackage.ps0;
import defpackage.ts0;
import defpackage.u2;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface MediationBannerAdapter extends ps0 {
    View getBannerView();

    @Override // defpackage.ps0, com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.ads.mediation.MediationNativeAdapter
    /* synthetic */ void onDestroy();

    @Override // defpackage.ps0, com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.ads.mediation.MediationNativeAdapter
    /* synthetic */ void onPause();

    @Override // defpackage.ps0, com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.ads.mediation.MediationNativeAdapter
    /* synthetic */ void onResume();

    void requestBannerAd(Context context, ts0 ts0Var, Bundle bundle, u2 u2Var, os0 os0Var, Bundle bundle2);
}
