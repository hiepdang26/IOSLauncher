package defpackage;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Looper;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.FolderIcon;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class t40 {
    public static final RectF h = new RectF();
    public static final Paint i = new Paint(1);
    public static int j = -1;
    public static int k = -1;
    public static int l = -1;
    public int a;
    public int b;
    public CellLayout c;
    public float d;
    public final FolderIcon e;
    public ValueAnimator f;
    public ValueAnimator g;

    public t40(t tVar, FolderIcon folderIcon) {
        this.e = folderIcon;
        Resources resources = tVar.getResources();
        if (FolderIcon.D) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new RuntimeException("FolderRingAnimator loading drawables on non-UI thread " + Thread.currentThread());
            }
            j = tVar.getDeviceProfile().J;
            int i2 = FolderIcon.E;
            k = i2;
            l = j - (i2 * 6);
            i.setColor(tVar.isDarkMode ? 1493172224 : -2132877602);
            resources.getDimensionPixelSize(e51.icon_round_corner);
            FolderIcon.D = false;
        }
    }

    public final void a() {
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorC = ik0.c(0.0f, 1.0f);
        this.f = valueAnimatorC;
        valueAnimatorC.setDuration(100L);
        this.f.addUpdateListener(new q7(this, 9));
        this.f.addListener(new r40(this, 0));
        this.f.start();
    }

    public final void b() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorC = ik0.c(0.0f, 1.0f);
        this.g = valueAnimatorC;
        valueAnimatorC.setDuration(100L);
        this.g.addUpdateListener(new s40(this, j));
        this.g.addListener(new r40(this, 1));
        this.g.start();
    }
}
