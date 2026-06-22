package com.luutinhit.launcherios.activity;

import android.os.Bundle;
import defpackage.m61;
import defpackage.ua;
import defpackage.v51;

/* JADX INFO: loaded from: classes.dex */
public class BlurConfigActivity extends ua {
    @Override // defpackage.ua, defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m61.activity_blur_config);
        z(findViewById(v51.root_layout), true);
    }
}
