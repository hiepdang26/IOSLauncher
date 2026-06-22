package defpackage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

/* JADX INFO: loaded from: classes.dex */
public final class cn1 extends ShapeDrawable {
    public static final /* synthetic */ int f = 0;
    public final Paint a;
    public final String b;
    public final int c;
    public final int d;
    public final int e;

    public cn1(bn1 bn1Var) {
        super((RectShape) bn1Var.d);
        this.c = -1;
        this.d = -1;
        this.b = (String) bn1Var.b;
        this.e = bn1Var.a;
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setFakeBoldText(false);
        paint.setStyle(Paint.Style.FILL);
        paint.setTypeface((Typeface) bn1Var.c);
        paint.setTextAlign(Paint.Align.CENTER);
        float f2 = 0;
        paint.setStrokeWidth(f2);
        Paint paint2 = new Paint();
        paint2.setColor(Color.rgb((int) (Color.red(-7829368) * 0.9f), (int) (Color.green(-7829368) * 0.9f), (int) (Color.blue(-7829368) * 0.9f)));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(f2);
        getPaint().setColor(-7829368);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Rect bounds = getBounds();
        int iSave = canvas.save();
        canvas.translate(bounds.left, bounds.top);
        int iWidth = this.d;
        if (iWidth < 0) {
            iWidth = bounds.width();
        }
        int iHeight = this.c;
        if (iHeight < 0) {
            iHeight = bounds.height();
        }
        int iMin = this.e;
        if (iMin < 0) {
            iMin = Math.min(iWidth, iHeight) / 2;
        }
        Paint paint = this.a;
        paint.setTextSize(iMin);
        canvas.drawText(this.b, iWidth / 2, (iHeight / 2) - ((paint.ascent() + paint.descent()) / 2.0f), paint);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.c;
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.d;
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
