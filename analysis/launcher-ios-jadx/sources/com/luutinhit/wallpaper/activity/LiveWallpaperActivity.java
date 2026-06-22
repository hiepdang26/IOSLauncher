package com.luutinhit.wallpaper.activity;

import android.app.WallpaperManager;
import android.os.Bundle;
import defpackage.ca;
import defpackage.e6;
import defpackage.g41;
import defpackage.h60;
import defpackage.m61;
import defpackage.mq0;
import defpackage.sg0;
import defpackage.v51;

/* JADX INFO: loaded from: classes.dex */
public class LiveWallpaperActivity extends e6 {
    public boolean B;
    public WallpaperManager C;

    @Override // defpackage.e6, androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m61.activity_live_wallpaper);
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        this.C = wallpaperManager;
        if (bundle == null) {
            if (wallpaperManager.getWallpaperInfo() == null || !this.C.getWallpaperInfo().getPackageName().equals(getPackageName())) {
                h60 h60VarO = o();
                h60VarO.getClass();
                ca caVar = new ca(h60VarO);
                caVar.g(v51.container, new sg0());
                caVar.d(false);
                this.B = true;
                return;
            }
            h60 h60VarO2 = o();
            h60VarO2.getClass();
            ca caVar2 = new ca(h60VarO2);
            caVar2.g(v51.container, new mq0());
            caVar2.d(false);
            this.B = false;
        }
    }

    @Override // android.app.Activity
    public final void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.B = bundle.getBoolean("intro");
    }

    @Override // androidx.activity.a, defpackage.cl, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("intro", this.B);
    }

    @Override // defpackage.e6, android.app.Activity
    public final void onStart() {
        super.onStart();
        if (!this.B || this.C.getWallpaperInfo() == null || !this.C.getWallpaperInfo().getPackageName().equals(getPackageName())) {
            if (this.B) {
                return;
            }
            if (this.C.getWallpaperInfo() == null || !this.C.getWallpaperInfo().getPackageName().equals(getPackageName())) {
                h60 h60VarO = o();
                h60VarO.getClass();
                ca caVar = new ca(h60VarO);
                caVar.g(v51.container, new sg0());
                caVar.d(false);
                this.B = true;
                return;
            }
            return;
        }
        h60 h60VarO2 = o();
        h60VarO2.getClass();
        ca caVar2 = new ca(h60VarO2);
        int i = g41.fragment_enter;
        int i2 = g41.fragment_exit;
        caVar2.b = i;
        caVar2.c = i2;
        caVar2.d = 0;
        caVar2.e = 0;
        caVar2.g(v51.container, new mq0());
        caVar2.d(false);
        this.B = false;
    }
}
