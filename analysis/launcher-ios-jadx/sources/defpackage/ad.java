package defpackage;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.widget.Toast;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ad implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ fd h;

    public /* synthetic */ ad(fd fdVar, int i) {
        this.g = i;
        this.h = fdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bitmap bitmapD;
        switch (this.g) {
            case 0:
                fd fdVar = this.h;
                t tVar = fdVar.a;
                try {
                    t tVar2 = jk0.a().g;
                    fdVar.h = Math.max(3, Math.min(fdVar.h, 20));
                    boolean z = true;
                    WallpaperManager wallpaperManager = fdVar.b;
                    fdVar.i = (wallpaperManager == null || wallpaperManager.getWallpaperInfo() == null) ? false : true;
                    boolean z2 = (wallpaperManager == null || wallpaperManager.getWallpaperInfo() == null || !tVar.getPackageName().equalsIgnoreCase(wallpaperManager.getWallpaperInfo().getPackageName())) ? false : true;
                    fdVar.j = z2;
                    if (z2 || (ar1.j && !e42.h(tVar))) {
                        bitmapD = fdVar.d("wallpaper");
                        z = false;
                    } else {
                        bitmapD = fdVar.f(((BitmapDrawable) wallpaperManager.getDrawable()).getBitmap());
                    }
                    int i = fdVar.n;
                    cd cdVar = fdVar.k;
                    if (bitmapD != null && z) {
                        bitmapD.getWidth();
                        fdVar.e = null;
                        int width = bitmapD.getWidth();
                        int height = bitmapD.getHeight();
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                        Canvas canvas = fdVar.o;
                        canvas.setBitmap(bitmapCreateBitmap);
                        Path path = fdVar.m;
                        path.moveTo(0.0f, 0.0f);
                        float f = height;
                        path.lineTo(0.0f, f);
                        float f2 = width;
                        path.lineTo(f2, f);
                        path.lineTo(f2, 0.0f);
                        Paint paint = fdVar.l;
                        paint.setXfermode(null);
                        paint.setColor(1174405119);
                        canvas.drawPath(path, paint);
                        fdVar.g = bitmapCreateBitmap;
                        fdVar.e("wallpaper", bitmapD);
                        Bitmap bitmapC = fd.c(bitmapD, 2.0f, 2);
                        fdVar.f = bitmapC;
                        fdVar.e("glass", bitmapC);
                        Bitmap bitmapC2 = fd.c(bitmapD, i, fdVar.h);
                        fdVar.e = bitmapC2;
                        fdVar.e("blur", bitmapC2);
                        new jz(fdVar.e).c(new o5(fdVar, 2));
                        tVar2.runOnUiThread(cdVar);
                    } else {
                        if (bitmapD != null) {
                            fdVar.f = fd.c(bitmapD, 2.0f, 2);
                            fdVar.e = fd.c(bitmapD, i, fdVar.h);
                        } else {
                            fdVar.f = fdVar.d("glass");
                            fdVar.e = fdVar.d("blur");
                        }
                        new jz(fdVar.e).c(new o5(fdVar, 2));
                        tVar2.runOnUiThread(cdVar);
                    }
                    break;
                } catch (Throwable th) {
                    th.getMessage();
                    try {
                        if (e42.h(tVar) && e42.g(tVar)) {
                            return;
                        }
                        if (uo.r(tVar)) {
                            tVar.runOnUiThread(new ad(fdVar, 1));
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        th2.getMessage();
                        return;
                    }
                }
                break;
            default:
                Toast.makeText(this.h.a, w61.need_some_permission_to_make_blur_effect, 0).show();
                break;
        }
    }
}
