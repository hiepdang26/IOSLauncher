package defpackage;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class z80 extends Drawable {
    public static Paint c;
    public static Paint d;
    public final int[] a = {0, -1, 0, -1, 0};
    public final float[] b = {0.0f, 0.2f, 0.5f, 0.7f, 1.0f};

    public z80() {
        Paint paint = new Paint(1);
        d = paint;
        paint.setStyle(Paint.Style.FILL);
        d.setColor(-2134061876);
        Paint paint2 = new Paint(1);
        c = paint2;
        paint2.setStyle(Paint.Style.STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        c.setStrokeWidth(1.5f);
        c.setShader(new LinearGradient(0.0f, 0.0f, getBounds().width() / 2.0f, getBounds().height() / 2.0f, this.a, this.b, Shader.TileMode.CLAMP));
        ve0.a(canvas, getBounds().width(), getBounds().height(), d);
        ve0.a(canvas, getBounds().width(), getBounds().height(), c);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
