package com.luutinhit.launcherios.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import com.luutinhit.launcherios.customsettings.SwitchView;
import defpackage.ar1;
import defpackage.dl1;
import defpackage.e31;
import defpackage.m61;
import defpackage.ua;
import defpackage.v51;

/* JADX INFO: loaded from: classes.dex */
public class ConfigDockActivity extends ua implements dl1 {
    public SharedPreferences B;
    public SwitchView C;

    @Override // defpackage.dl1
    public final void e(boolean z) {
        try {
            SharedPreferences.Editor editorEdit = this.B.edit();
            editorEdit.putBoolean("marginHotseat", z);
            editorEdit.apply();
        } catch (Throwable th) {
            th.getMessage();
        }
        ar1.z(this);
    }

    public void onClick(View view) {
        this.C.b(!r2.n);
    }

    @Override // defpackage.ua, defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m61.activity_config_dock);
        boolean z = true;
        z(findViewById(v51.root_layout), true);
        this.B = getSharedPreferences(e31.b(this), 0);
        SwitchView switchView = (SwitchView) findViewById(v51.padding_bottom);
        this.C = switchView;
        try {
            z = this.B.getBoolean("marginHotseat", false);
        } catch (Throwable unused) {
        }
        switchView.setOpened(z);
        this.C.setOnSwitchChangeListener(this);
    }
}
