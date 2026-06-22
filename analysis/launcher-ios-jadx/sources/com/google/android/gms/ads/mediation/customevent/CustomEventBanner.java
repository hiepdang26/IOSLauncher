package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import defpackage.dr;
import defpackage.er;
import defpackage.os0;
import defpackage.u2;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface CustomEventBanner extends dr {
    /* synthetic */ void onDestroy();

    /* synthetic */ void onPause();

    /* synthetic */ void onResume();

    void requestBannerAd(Context context, er erVar, String str, u2 u2Var, os0 os0Var, Bundle bundle);
}
