package defpackage;

import android.content.Intent;
import com.bumptech.glide.a;
import com.luutinhit.launcherios.activity.WallpaperActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class nv1 implements b2 {
    public final /* synthetic */ WallpaperActivity g;

    public /* synthetic */ nv1(WallpaperActivity wallpaperActivity) {
        this.g = wallpaperActivity;
    }

    @Override // defpackage.b2
    public void i(Object obj) {
        Intent intent;
        a2 a2Var = (a2) obj;
        int i = WallpaperActivity.W;
        WallpaperActivity wallpaperActivity = this.g;
        if (a2Var.g != -1 || (intent = a2Var.h) == null || intent.getData() == null) {
            return;
        }
        wallpaperActivity.O = intent.getData();
        ((na1) ((na1) a.e(wallpaperActivity.B).l().O(wallpaperActivity.O).c()).p(wallpaperActivity.M, wallpaperActivity.N)).L(wallpaperActivity.I);
        wallpaperActivity.F.setAlpha(0.0f);
        wallpaperActivity.F.setVisibility(0);
        wallpaperActivity.F.animate().withLayer().alpha(1.0f).setDuration(268L).start();
    }
}
