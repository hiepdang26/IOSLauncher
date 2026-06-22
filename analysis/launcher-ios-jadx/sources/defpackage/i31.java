package defpackage;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.luutinhit.launcher6.FastBitmapDrawable;

/* JADX INFO: loaded from: classes.dex */
public final class i31 extends Drawable {
    public static final Rect k = new Rect();
    public boolean b;
    public final Paint c;
    public final Drawable d;
    public Drawable e;
    public int f;
    public ObjectAnimator j;
    public final RectF a = new RectF();
    public int g = 0;
    public int h = 0;
    public float i = -1.0f;

    public i31(Drawable drawable, Resources.Theme theme) {
        this.d = drawable;
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        setBounds(drawable.getBounds());
        a(theme);
        onLevelChange(0);
    }

    public final void a(Resources.Theme theme) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(g71.PreloadIconDrawable);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(g71.PreloadIconDrawable_background);
        this.e = drawable;
        drawable.setFilterBitmap(true);
        this.c.setStrokeWidth(typedArrayObtainStyledAttributes.getDimension(g71.PreloadIconDrawable_indicatorSize, 0.0f));
        this.f = typedArrayObtainStyledAttributes.getDimensionPixelSize(g71.PreloadIconDrawable_ringOutset, 0);
        typedArrayObtainStyledAttributes.recycle();
        onBoundsChange(getBounds());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect rect = new Rect(getBounds());
        Rect rect2 = k;
        if (!canvas.getClipBounds(rect2) || Rect.intersects(rect2, rect)) {
            boolean z = this.b;
            RectF rectF = this.a;
            Paint paint = this.c;
            if (z) {
                Drawable drawable = this.e;
                Rect bounds = drawable.getBounds();
                drawable.getPadding(rect2);
                float fWidth = bounds.width() / drawable.getIntrinsicWidth();
                float fHeight = bounds.height() / drawable.getIntrinsicHeight();
                rectF.set((rect2.left * fWidth) + bounds.left, (rect2.top * fHeight) + bounds.top, bounds.right - (rect2.right * fWidth), bounds.bottom - (rect2.bottom * fHeight));
                float strokeWidth = paint.getStrokeWidth() / 2.0f;
                rectF.inset(strokeWidth, strokeWidth);
                this.b = false;
            }
            float f = this.i;
            float f2 = 0.5f;
            if (f >= 0.0f && f < 1.0f) {
                paint.setAlpha((int) ((1.0f - f) * 255.0f));
                this.e.setAlpha(paint.getAlpha());
                this.e.draw(canvas);
                canvas.drawOval(rectF, paint);
                f2 = 0.5f + (this.i * 0.5f);
            } else if (f == -1.0f) {
                paint.setAlpha(255);
                this.e.setAlpha(255);
                this.e.draw(canvas);
                int i = this.h;
                if (i >= 100) {
                    canvas.drawOval(rectF, paint);
                } else if (i > 0) {
                    canvas.drawArc(rectF, -90.0f, i * 3.6f, false, paint);
                }
            } else {
                f2 = 1.0f;
            }
            canvas.save();
            canvas.scale(f2, f2, rect.exactCenterX(), rect.exactCenterY());
            this.d.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.d.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.d.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.d.setBounds(rect);
        if (this.e != null) {
            Rect rect2 = k;
            rect2.set(rect);
            int i = this.f;
            rect2.inset(-i, -i);
            this.e.setBounds(rect2);
        }
        this.b = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        this.h = i;
        ObjectAnimator objectAnimator = this.j;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.j = null;
        }
        this.i = -1.0f;
        Drawable drawable = this.d;
        if (i > 0) {
            int iHSVToColor = this.g;
            if (iHSVToColor == 0) {
                if (drawable instanceof FastBitmapDrawable) {
                    int iL = ar1.l(((FastBitmapDrawable) drawable).b);
                    this.g = iL;
                    float[] fArr = new float[3];
                    Color.colorToHSV(iL, fArr);
                    if (fArr[1] < 0.2f) {
                        this.g = -16738680;
                    } else {
                        fArr[2] = Math.max(0.6f, fArr[2]);
                        iHSVToColor = Color.HSVToColor(fArr);
                        this.g = iHSVToColor;
                    }
                } else {
                    this.g = -16738680;
                }
                iHSVToColor = -16738680;
            }
            this.c.setColor(iHSVToColor);
        }
        if (drawable instanceof FastBitmapDrawable) {
            ((FastBitmapDrawable) drawable).f(i <= 0 ? o20.DISABLED : o20.NORMAL);
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.d.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
    }
}
