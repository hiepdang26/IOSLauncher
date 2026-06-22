package com.luutinhit.launcher6.ioslauncher;

import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import com.luutinhit.wallpaper.livewallpaper.LiveWallpaperService;
import defpackage.e42;
import defpackage.yk0;
import defpackage.za1;

/* JADX INFO: loaded from: classes.dex */
public final class a implements yk0 {
    public final /* synthetic */ IOSLauncher a;

    public a(IOSLauncher iOSLauncher) {
        this.a = iOSLauncher;
    }

    public final void a() {
        IOSLauncher iOSLauncher = this.a;
        iOSLauncher.mTinyDB = iOSLauncher.getTinyDB();
        iOSLauncher.mWallpaperManager = WallpaperManager.getInstance(iOSLauncher);
        iOSLauncher.mRequestSetDefaultLauncher = new za1(iOSLauncher);
        if (iOSLauncher.mTinyDB.a("parallax_zoom_animations")) {
            Intent intent = new Intent("android.service.wallpaper.CHANGE_LIVE_WALLPAPER");
            intent.putExtra("android.service.wallpaper.extra.LIVE_WALLPAPER_COMPONENT", new ComponentName(iOSLauncher, (Class<?>) LiveWallpaperService.class));
            iOSLauncher.startActivity(intent);
        }
    }

    public final void b() {
        IOSLauncher iOSLauncher = this.a;
        if (iOSLauncher.mCountOpenControlView != iOSLauncher.mNumberShowRateDialog || iOSLauncher.mTinyDB.a("not_show_exit_dialog")) {
            iOSLauncher.mCountOpenControlView++;
        } else {
            iOSLauncher.startRatingActivity();
            iOSLauncher.mCountOpenControlView = 0;
            iOSLauncher.mNumberShowRateDialog += 8;
        }
        if (Build.VERSION.SDK_INT >= 33 && !e42.h(iOSLauncher)) {
            int wallpaperId = iOSLauncher.mWallpaperManager.getWallpaperId(1);
            WallpaperManager wallpaperManager = iOSLauncher.mWallpaperManager;
            if ((wallpaperManager == null || wallpaperManager.getWallpaperInfo() == null || !iOSLauncher.getPackageName().equalsIgnoreCase(iOSLauncher.mWallpaperManager.getWallpaperInfo().getPackageName())) && wallpaperId != iOSLauncher.mTinyDB.a.getInt("wallpaper_id", -1)) {
                iOSLauncher.setOrRestoreWallpaper();
                iOSLauncher.showSuggestWallpaperChangeDialog();
            }
        }
        iOSLauncher.checkHideNavigation();
    }
}
