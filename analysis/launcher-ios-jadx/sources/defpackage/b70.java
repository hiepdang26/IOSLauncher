package defpackage;

import android.animation.ObjectAnimator;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.motion.widget.Key;
import com.luutinhit.launcher6.InsertAbleFrameLayout;

/* JADX INFO: loaded from: classes.dex */
public abstract class b70 extends InsertAbleFrameLayout {
    public final Paint g;
    public boolean h;
    public int i;
    public View j;

    public b70(Context context) {
        super(context, null);
        Paint paint = new Paint(1);
        this.g = paint;
        paint.setColor(-16777216);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            new Handler(Looper.getMainLooper()).post(new wc(this, canvas, 6));
            return;
        }
        if (!this.h) {
            return;
        }
        int width = getWidth();
        synchronized (canvas) {
            try {
                try {
                    canvas.drawRect(width - this.i, 0.0f, width, getHeight(), this.g);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        boolean z = rect.right > 0 && (!ar1.i || ((ActivityManager) getContext().getSystemService(ActivityManager.class)).isLowRamDevice());
        this.h = z;
        this.i = rect.right;
        setInsets(z ? new Rect(0, rect.top, 0, rect.bottom) : rect);
        View view = this.j;
        if (view != null && this.h) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int i = marginLayoutParams.leftMargin;
            int i2 = rect.left;
            if (i != i2 || marginLayoutParams.rightMargin != rect.right) {
                marginLayoutParams.leftMargin = i2;
                marginLayoutParams.rightMargin = rect.right;
                this.j.setLayoutParams(marginLayoutParams);
            }
        }
        return true;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        if (getChildCount() > 0) {
            this.j = getChildAt(0);
        }
        super.onFinishInflate();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
        if (drawable != null) {
            ObjectAnimator duration = ObjectAnimator.ofInt(drawable, Key.ALPHA, 0, 255).setDuration(268L);
            duration.setInterpolator(new DecelerateInterpolator());
            duration.start();
        }
    }
}
