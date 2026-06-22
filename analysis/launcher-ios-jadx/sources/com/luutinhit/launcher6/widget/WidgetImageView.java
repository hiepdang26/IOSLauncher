package com.luutinhit.launcher6.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class WidgetImageView extends View {
    public final Paint g;
    public final RectF h;
    public Bitmap i;

    public WidgetImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new Paint(3);
        this.h = new RectF();
    }

    public final void a() {
        this.i.getWidth();
        this.i.getHeight();
        getWidth();
        getHeight();
        int width = this.i.getWidth();
        int width2 = getWidth();
        RectF rectF = this.h;
        if (width > width2) {
            rectF.set(0.0f, 0.0f, getWidth(), (getWidth() / this.i.getWidth()) * this.i.getHeight());
        } else {
            if (this.i.getHeight() > getHeight()) {
                rectF.set(0.0f, 0.0f, (getHeight() / this.i.getHeight()) * this.i.getWidth(), getHeight());
                return;
            }
            float width3 = getWidth() / this.i.getWidth();
            float height = getHeight() / this.i.getHeight();
            rectF.set(0.0f, 0.0f, Math.min(width3, height) * this.i.getWidth(), Math.min(width3, height) * this.i.getHeight());
        }
    }

    public Bitmap getBitmap() {
        return this.i;
    }

    public Rect getBitmapBounds() {
        a();
        Rect rect = new Rect(0, 0, this.i.getWidth(), this.i.getHeight());
        this.h.round(rect);
        return rect;
    }

    @Override // android.view.View
    public final boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.i != null) {
            a();
            canvas.drawBitmap(this.i, (Rect) null, this.h, this.g);
        }
    }

    public void setBitmap(Bitmap bitmap) {
        this.i = bitmap;
        invalidate();
    }
}
