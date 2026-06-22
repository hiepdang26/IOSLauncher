package defpackage;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

/* JADX INFO: loaded from: classes.dex */
public final class bg1 extends fg1 {
    public final dg1 b;
    public final float c;
    public final float d;

    public bg1(dg1 dg1Var, float f, float f2) {
        this.b = dg1Var;
        this.c = f;
        this.d = f2;
    }

    @Override // defpackage.fg1
    public final void a(Matrix matrix, uf1 uf1Var, int i, Canvas canvas) {
        dg1 dg1Var = this.b;
        float f = dg1Var.c;
        float f2 = this.d;
        float f3 = dg1Var.b;
        float f4 = this.c;
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f - f2, f3 - f4), 0.0f);
        Matrix matrix2 = new Matrix(matrix);
        matrix2.preTranslate(f4, f2);
        matrix2.preRotate(b());
        uf1Var.getClass();
        rectF.bottom += i;
        rectF.offset(0.0f, -i);
        int[] iArr = uf1.i;
        iArr[0] = uf1Var.f;
        iArr[1] = uf1Var.e;
        iArr[2] = uf1Var.d;
        Paint paint = uf1Var.c;
        float f5 = rectF.left;
        paint.setShader(new LinearGradient(f5, rectF.top, f5, rectF.bottom, iArr, uf1.j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float b() {
        dg1 dg1Var = this.b;
        return (float) Math.toDegrees(Math.atan((dg1Var.c - this.d) / (dg1Var.b - this.c)));
    }
}
