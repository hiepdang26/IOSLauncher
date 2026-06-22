package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class gd extends Drawable {
    public final Drawable a;
    public final Rect b;
    public final Rect c;

    public gd(Drawable drawable) {
        this.a = drawable;
        Rect rect = new Rect();
        this.b = rect;
        Rect rect2 = new Rect();
        this.c = rect2;
        drawable.getPadding(rect2);
        rect.left = -rect2.left;
        rect2.left = 0;
        rect.top = -rect2.top;
        rect2.top = 0;
        rect.right = rect2.right;
        rect2.right = 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        this.a.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        rect.set(this.c);
        return (rect.bottom | ((rect.left | rect.top) | rect.right)) != 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        int i = rect.left;
        Rect rect2 = this.b;
        this.a.setBounds(i + rect2.left, rect.top + rect2.top, rect.right + rect2.right, rect.bottom + rect2.bottom);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
