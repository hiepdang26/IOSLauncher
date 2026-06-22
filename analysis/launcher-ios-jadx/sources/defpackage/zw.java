package defpackage;

import android.animation.FloatArrayEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.luutinhit.launcher6.DragLayer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zw extends View {
    public static final /* synthetic */ int v = 0;
    public Bitmap g;
    public Paint h;
    public int i;
    public int j;
    public Point k;
    public Rect l;
    public DragLayer m;
    public boolean n;
    public ValueAnimator o;
    public float p;
    public float q;
    public float r;
    public float s;
    public float[] t;
    public ValueAnimator u;

    public static void b(int i, ColorMatrix colorMatrix) {
        colorMatrix.setScale(Color.red(i) / 255.0f, Color.green(i) / 255.0f, Color.blue(i) / 255.0f, Color.alpha(i) / 255.0f);
    }

    public final void a(float[] fArr) {
        float[] array = this.t;
        if (array == null) {
            array = new ColorMatrix().getArray();
        }
        this.t = Arrays.copyOf(array, array.length);
        ValueAnimator valueAnimator = this.u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new FloatArrayEvaluator(this.t), array, fArr);
        this.u = valueAnimatorOfObject;
        valueAnimatorOfObject.setDuration(120);
        this.u.addUpdateListener(new q7(this, 6));
        this.u.start();
    }

    public Rect getDragRegion() {
        return this.l;
    }

    public int getDragRegionHeight() {
        return this.l.height();
    }

    public int getDragRegionLeft() {
        return this.l.left;
    }

    public int getDragRegionTop() {
        return this.l.top;
    }

    public int getDragRegionWidth() {
        return this.l.width();
    }

    public Point getDragVisualizeOffset() {
        return this.k;
    }

    public float getInitialScale() {
        return this.r;
    }

    public float getIntrinsicIconScaleFactor() {
        return this.s;
    }

    public float getOffsetY() {
        return this.q;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        this.n = true;
        canvas.drawBitmap(this.g, 0.0f, 0.0f, this.h);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        Bitmap bitmap = this.g;
        setMeasuredDimension(bitmap.getWidth(), bitmap.getHeight());
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        super.setAlpha(f);
        this.h.setAlpha((int) (f * 255.0f));
        invalidate();
    }

    public void setColor(int i) {
        if (this.h == null) {
            this.h = new Paint(2);
        }
        if (i == 0) {
            if (ar1.m && this.t != null) {
                a(new ColorMatrix().getArray());
                return;
            } else {
                this.h.setColorFilter(null);
                invalidate();
                return;
            }
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        b(i, colorMatrix2);
        colorMatrix.postConcat(colorMatrix2);
        if (ar1.m) {
            a(colorMatrix.getArray());
        } else {
            this.h.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            invalidate();
        }
    }

    public void setDragRegion(Rect rect) {
        this.l = rect;
    }

    public void setDragVisualizeOffset(Point point) {
        this.k = point;
    }

    public void setIntrinsicIconScaleFactor(float f) {
        this.s = f;
    }

    public void setCrossFadeBitmap(Bitmap bitmap) {
    }
}
