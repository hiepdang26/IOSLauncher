package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.luutinhit.launcherios.activity.WallpaperActivity;

/* JADX INFO: loaded from: classes.dex */
public final class pv1 extends pr {
    public final /* synthetic */ int j;
    public final /* synthetic */ WallpaperActivity k;

    public /* synthetic */ pv1(WallpaperActivity wallpaperActivity, int i) {
        this.j = i;
        this.k = wallpaperActivity;
    }

    @Override // defpackage.lm1
    public final void e(Object obj, wo1 wo1Var) {
        switch (this.j) {
            case 0:
                Bitmap bitmap = (Bitmap) obj;
                bitmap.getWidth();
                bitmap.getHeight();
                WallpaperActivity.B(this.k, bitmap);
                break;
            case 1:
                Bitmap bitmap2 = (Bitmap) obj;
                bitmap2.getWidth();
                bitmap2.getHeight();
                WallpaperActivity.B(this.k, bitmap2);
                break;
            default:
                Bitmap bitmap3 = (Bitmap) obj;
                bitmap3.getWidth();
                bitmap3.getHeight();
                WallpaperActivity.B(this.k, bitmap3);
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
