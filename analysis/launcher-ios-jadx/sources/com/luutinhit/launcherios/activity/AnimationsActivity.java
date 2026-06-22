package com.luutinhit.launcherios.activity;

import android.app.WallpaperManager;
import android.content.SharedPreferences;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import com.luutinhit.launcherios.customsettings.SwitchView;
import defpackage.e31;
import defpackage.fz1;
import defpackage.m61;
import defpackage.mc1;
import defpackage.o1;
import defpackage.o5;
import defpackage.ua;
import defpackage.v51;

/* JADX INFO: loaded from: classes.dex */
public class AnimationsActivity extends ua {
    public static final /* synthetic */ int H = 0;
    public SharedPreferences B;
    public SwitchView C;
    public SwitchView D;
    public SwitchView E;
    public WallpaperManager F;
    public final o1 G = new o1(this, 2);

    public final void A(String str, boolean z) {
        try {
            SharedPreferences.Editor editorEdit = this.B.edit();
            editorEdit.putBoolean(str, z);
            editorEdit.apply();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == v51.item_unlock_animations || id == v51.unlock_animation) {
                this.C.b(!r2.n);
            } else if (id == v51.item_parallax_zoom_animation || id == v51.parallax_zoom_wallpaper_animations) {
                this.E.b(!r2.n);
            } else if (id == v51.item_open_close_animations || id == v51.open_close_app_animation) {
                this.D.b(!r2.n);
            }
        }
    }

    @Override // defpackage.ua, defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        setContentView(m61.activity_animations);
        boolean z2 = true;
        z(findViewById(v51.root_layout), true);
        this.B = getSharedPreferences(e31.b(this), 0);
        this.F = WallpaperManager.getInstance(this);
        SwitchView switchView = (SwitchView) findViewById(v51.unlock_animation);
        this.C = switchView;
        try {
            z = this.B.getBoolean("unlock_animation", true);
        } catch (Throwable unused) {
            z = true;
        }
        switchView.setOpened(z);
        this.C.setOnSwitchChangeListener(new fz1(this, 1));
        SwitchView switchView2 = (SwitchView) findViewById(v51.open_close_app_animation);
        this.D = switchView2;
        try {
            z2 = this.B.getBoolean("open_close_animation", true);
        } catch (Throwable unused2) {
        }
        switchView2.setOpened(z2);
        this.D.setOnSwitchChangeListener(new mc1(this, 3));
        if (((SensorManager) getSystemService("sensor")).getDefaultSensor(11) == null && !this.B.contains("parallax_zoom_animations")) {
            findViewById(v51.item_parallax_zoom_animation).setVisibility(8);
        }
        SwitchView switchView3 = (SwitchView) findViewById(v51.parallax_zoom_wallpaper_animations);
        this.E = switchView3;
        switchView3.setOnSwitchChangeListener(new o5(this, 0));
    }

    @Override // defpackage.e6, android.app.Activity
    public final void onResume() {
        super.onResume();
        WallpaperManager wallpaperManager = this.F;
        boolean z = (wallpaperManager == null || wallpaperManager.getWallpaperInfo() == null || !getPackageName().equalsIgnoreCase(this.F.getWallpaperInfo().getPackageName())) ? false : true;
        this.E.setOpened(z);
        A("parallax_zoom_animations", z);
    }
}
