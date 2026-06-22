package com.luutinhit.launcherios.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.a;
import defpackage.e31;
import defpackage.l51;
import defpackage.lj1;
import defpackage.m61;
import defpackage.na1;
import defpackage.qv;
import defpackage.ua;
import defpackage.v51;

/* JADX INFO: loaded from: classes.dex */
public class StatusBarAndNotificationActivity extends ua implements CompoundButton.OnCheckedChangeListener {
    public AppCompatImageView B;
    public AppCompatImageView C;
    public AppCompatCheckBox D;
    public SharedPreferences E;

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.B.setVisibility(z ? 0 : 4);
        this.C.setVisibility(z ? 4 : 0);
    }

    @Override // defpackage.ua, defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m61.activity_status_bar_and_notification);
        z(findViewById(v51.root_layout), true);
        this.E = getSharedPreferences(e31.b(this), 0);
        this.B = (AppCompatImageView) findViewById(v51.hide_navigation_image);
        this.C = (AppCompatImageView) findViewById(v51.show_navigation_image);
        this.D = (AppCompatCheckBox) findViewById(v51.hide_navigation_checkbox);
        findViewById(v51.confirm_button).setOnClickListener(new lj1(this));
        this.D.setOnCheckedChangeListener(this);
    }

    @Override // defpackage.ua, defpackage.e6, android.app.Activity
    public final void onStart() {
        super.onStart();
        na1 na1VarR = a.b(this).c(this).r(Integer.valueOf(l51.hide_navigation));
        qv qvVar = qv.b;
        ((na1) na1VarR.f(qvVar)).L(this.B);
        ((na1) a.b(this).c(this).r(Integer.valueOf(l51.show_navigation)).f(qvVar)).L(this.C);
        boolean z = true;
        try {
            z = this.E.getBoolean("hide_navigation", true);
        } catch (Throwable unused) {
        }
        this.D.setChecked(z);
        this.B.setVisibility(z ? 0 : 4);
        this.C.setVisibility(z ? 4 : 0);
    }
}
