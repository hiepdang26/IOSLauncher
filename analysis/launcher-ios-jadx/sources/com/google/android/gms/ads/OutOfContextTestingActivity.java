package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.widget.LinearLayout;
import com.google.android.gms.internal.ads.zzboi;
import defpackage.gy0;
import defpackage.j61;
import defpackage.m22;
import defpackage.q82;
import defpackage.s32;
import defpackage.s51;
import defpackage.x32;

/* JADX INFO: loaded from: classes.dex */
public final class OutOfContextTestingActivity extends Activity {
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        s32 s32Var = x32.f.b;
        zzboi zzboiVar = new zzboi();
        s32Var.getClass();
        q82 q82Var = (q82) new m22(this, zzboiVar).d(this, false);
        if (q82Var == null) {
            finish();
            return;
        }
        setContentView(j61.admob_empty_layout);
        LinearLayout linearLayout = (LinearLayout) findViewById(s51.layout);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("adUnit");
        if (stringExtra == null) {
            finish();
            return;
        }
        try {
            q82Var.zze(stringExtra, new gy0(this), new gy0(linearLayout));
        } catch (RemoteException unused) {
            finish();
        }
    }
}
