package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import defpackage.cw0;
import defpackage.ps0;
import defpackage.zs0;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface MediationNativeAdapter extends ps0 {
    /* synthetic */ void onDestroy();

    /* synthetic */ void onPause();

    /* synthetic */ void onResume();

    void requestNativeAd(Context context, zs0 zs0Var, Bundle bundle, cw0 cw0Var, Bundle bundle2);
}
