package defpackage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcherios.activity.IconChangeActivity;

/* JADX INFO: loaded from: classes.dex */
public final class ge0 extends pr {
    public final /* synthetic */ int j;
    public final /* synthetic */ Activity k;

    public /* synthetic */ ge0(Activity activity, int i) {
        this.j = i;
        this.k = activity;
    }

    @Override // defpackage.lm1
    public final void e(Object obj, wo1 wo1Var) {
        switch (this.j) {
            case 0:
                Bitmap bitmap = (Bitmap) obj;
                bitmap.getWidth();
                bitmap.getHeight();
                ((IOSLauncher) this.k).setWallpaperFromBitmap(bitmap);
                break;
            case 1:
                Bitmap bitmap2 = (Bitmap) obj;
                bitmap2.getWidth();
                bitmap2.getHeight();
                IOSLauncher iOSLauncher = (IOSLauncher) this.k;
                iOSLauncher.setWallpaperFromBitmap(bitmap2);
                iOSLauncher.saveToInternalStorage("wallpaper", bitmap2);
                break;
            default:
                Bitmap bitmap3 = (Bitmap) obj;
                try {
                    bitmap3.getWidth();
                    bitmap3.getHeight();
                    IconChangeActivity iconChangeActivity = (IconChangeActivity) this.k;
                    iconChangeActivity.H.setImageBitmap(ar1.p(iconChangeActivity.B, bitmap3));
                } catch (Throwable th) {
                    th.getMessage();
                }
                break;
        }
    }

    @Override // defpackage.lm1
    public final void i(Drawable drawable) {
        int i = this.j;
    }

    private final void k(Drawable drawable) {
    }

    private final void l(Drawable drawable) {
    }

    private final void m(Drawable drawable) {
    }
}
