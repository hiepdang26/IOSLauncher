package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* JADX INFO: loaded from: classes.dex */
public final class ag1 extends fg1 {
    public final cg1 b;

    public ag1(cg1 cg1Var) {
        this.b = cg1Var;
    }

    @Override // defpackage.fg1
    public final void a(Matrix matrix, uf1 uf1Var, int i, Canvas canvas) {
        cg1 cg1Var = this.b;
        float f = cg1Var.f;
        float f2 = cg1Var.g;
        RectF rectF = new RectF(cg1Var.b, cg1Var.c, cg1Var.d, cg1Var.e);
        uf1Var.getClass();
        boolean z = f2 < 0.0f;
        Path path = uf1Var.g;
        int[] iArr = uf1.k;
        if (z) {
            iArr[0] = 0;
            iArr[1] = uf1Var.f;
            iArr[2] = uf1Var.e;
            iArr[3] = uf1Var.d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f, f2);
            path.close();
            float f3 = -i;
            rectF.inset(f3, f3);
            iArr[0] = 0;
            iArr[1] = uf1Var.d;
            iArr[2] = uf1Var.e;
            iArr[3] = uf1Var.f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f4 = 1.0f - (i / fWidth);
        float[] fArr = uf1.l;
        fArr[1] = f4;
        fArr[2] = ((1.0f - f4) / 2.0f) + f4;
        RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, iArr, fArr, Shader.TileMode.CLAMP);
        Paint paint = uf1Var.b;
        paint.setShader(radialGradient);
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, uf1Var.h);
        }
        canvas.drawArc(rectF, f, f2, true, paint);
        canvas.restore();
    }
}
