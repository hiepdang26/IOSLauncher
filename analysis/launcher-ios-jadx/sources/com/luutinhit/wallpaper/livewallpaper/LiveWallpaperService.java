package com.luutinhit.wallpaper.livewallpaper;

import android.service.wallpaper.WallpaperService;
import defpackage.so0;

/* JADX INFO: loaded from: classes.dex */
public class LiveWallpaperService extends WallpaperService {
    public int g = 0;

    @Override // android.service.wallpaper.WallpaperService
    public final WallpaperService.Engine onCreateEngine() {
        return new so0(this);
    }
}
