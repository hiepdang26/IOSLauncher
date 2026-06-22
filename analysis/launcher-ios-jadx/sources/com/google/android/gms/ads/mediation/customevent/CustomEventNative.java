package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import defpackage.cw0;
import defpackage.dr;
import defpackage.gr;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface CustomEventNative extends dr {
    /* synthetic */ void onDestroy();

    /* synthetic */ void onPause();

    /* synthetic */ void onResume();

    void requestNativeAd(Context context, gr grVar, String str, cw0 cw0Var, Bundle bundle);
}
