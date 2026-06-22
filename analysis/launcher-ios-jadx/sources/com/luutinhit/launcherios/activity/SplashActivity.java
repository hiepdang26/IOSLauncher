package com.luutinhit.launcherios.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import defpackage.r1;
import defpackage.ua;

/* JADX INFO: loaded from: classes.dex */
public class SplashActivity extends ua {
    public static final /* synthetic */ int B = 0;

    @Override // defpackage.ua, defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new Handler(Looper.getMainLooper()).postDelayed(new r1(this, 26), 3000L);
    }
}
