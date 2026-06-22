package defpackage;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public abstract class ie1 extends FrameLayout {
    public Drawable g;
    public Rect h;
    public Rect i;
    public boolean j;
    public boolean k;

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.h == null || this.g == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        boolean z = this.j;
        Rect rect = this.i;
        if (z) {
            rect.set(0, 0, width, this.h.top);
            this.g.setBounds(rect);
            this.g.draw(canvas);
        }
        if (this.k) {
            rect.set(0, height - this.h.bottom, width, height);
            this.g.setBounds(rect);
            this.g.draw(canvas);
        }
        Rect rect2 = this.h;
        rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
        this.g.setBounds(rect);
        this.g.draw(canvas);
        Rect rect3 = this.h;
        rect.set(width - rect3.right, rect3.top, width, height - rect3.bottom);
        this.g.setBounds(rect);
        this.g.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z) {
        this.k = z;
    }

    public void setDrawTopInsetForeground(boolean z) {
        this.j = z;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.g = drawable;
    }
}
