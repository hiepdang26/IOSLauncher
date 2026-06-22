package defpackage;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public final class yf1 {
    public final gg1[] a = new gg1[4];
    public final Matrix[] b = new Matrix[4];
    public final Matrix[] c = new Matrix[4];
    public final PointF d = new PointF();
    public final Path e = new Path();
    public final Path f = new Path();
    public final gg1 g = new gg1();
    public final float[] h = new float[2];
    public final float[] i = new float[2];
    public final Path j = new Path();
    public final Path k = new Path();
    public final boolean l = true;

    public yf1() {
        for (int i = 0; i < 4; i++) {
            this.a[i] = new gg1();
            this.b[i] = new Matrix();
            this.c[i] = new Matrix();
        }
    }

    public final void a(wf1 wf1Var, float f, RectF rectF, mc1 mc1Var, Path path) {
        Matrix[] matrixArr;
        Matrix[] matrixArr2;
        gg1[] gg1VarArr;
        int i;
        char c;
        float[] fArr;
        float f2;
        int i2;
        yf1 yf1Var = this;
        path.rewind();
        Path path2 = yf1Var.e;
        path2.rewind();
        Path path3 = yf1Var.f;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i3 = 0;
        while (true) {
            matrixArr = yf1Var.c;
            matrixArr2 = yf1Var.b;
            gg1VarArr = yf1Var.a;
            i = 4;
            c = 0;
            fArr = yf1Var.h;
            if (i3 >= 4) {
                break;
            }
            to toVar = i3 != 1 ? i3 != 2 ? i3 != 3 ? wf1Var.f : wf1Var.e : wf1Var.h : wf1Var.g;
            bf1 bf1Var = i3 != 1 ? i3 != 2 ? i3 != 3 ? wf1Var.b : wf1Var.a : wf1Var.d : wf1Var.c;
            gg1 gg1Var = gg1VarArr[i3];
            bf1Var.getClass();
            bf1Var.g(gg1Var, f, toVar.a(rectF));
            int i4 = i3 + 1;
            float f3 = i4 * 90;
            matrixArr2[i3].reset();
            PointF pointF = yf1Var.d;
            if (i3 == 1) {
                i2 = i3;
                pointF.set(rectF.right, rectF.bottom);
            } else if (i3 == 2) {
                i2 = i3;
                pointF.set(rectF.left, rectF.bottom);
            } else if (i3 != 3) {
                i2 = i3;
                pointF.set(rectF.right, rectF.top);
            } else {
                i2 = i3;
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i2].setTranslate(pointF.x, pointF.y);
            matrixArr2[i2].preRotate(f3);
            gg1 gg1Var2 = gg1VarArr[i2];
            fArr[0] = gg1Var2.b;
            fArr[1] = gg1Var2.c;
            matrixArr2[i2].mapPoints(fArr);
            matrixArr[i2].reset();
            matrixArr[i2].setTranslate(fArr[0], fArr[1]);
            matrixArr[i2].preRotate(f3);
            i3 = i4;
        }
        int i5 = 0;
        while (i5 < i) {
            gg1 gg1Var3 = gg1VarArr[i5];
            gg1Var3.getClass();
            fArr[c] = 0.0f;
            fArr[1] = gg1Var3.a;
            matrixArr2[i5].mapPoints(fArr);
            if (i5 == 0) {
                path.moveTo(fArr[c], fArr[1]);
            } else {
                path.lineTo(fArr[c], fArr[1]);
            }
            gg1VarArr[i5].b(matrixArr2[i5], path);
            if (mc1Var != null) {
                gg1 gg1Var4 = gg1VarArr[i5];
                Matrix matrix = matrixArr2[i5];
                rr0 rr0Var = (rr0) mc1Var.h;
                BitSet bitSet = rr0Var.j;
                gg1Var4.getClass();
                f2 = 0.0f;
                bitSet.set(i5, false);
                gg1Var4.a(gg1Var4.e);
                rr0Var.h[i5] = new zf1(new ArrayList(gg1Var4.g), new Matrix(matrix));
            } else {
                f2 = 0.0f;
            }
            int i6 = i5 + 1;
            int i7 = i6 % 4;
            gg1 gg1Var5 = gg1VarArr[i5];
            fArr[0] = gg1Var5.b;
            fArr[1] = gg1Var5.c;
            matrixArr2[i5].mapPoints(fArr);
            gg1 gg1Var6 = gg1VarArr[i7];
            gg1Var6.getClass();
            float[] fArr2 = yf1Var.i;
            fArr2[0] = f2;
            fArr2[1] = gg1Var6.a;
            matrixArr2[i7].mapPoints(fArr2);
            Matrix[] matrixArr3 = matrixArr2;
            gg1[] gg1VarArr2 = gg1VarArr;
            float fMax = Math.max(((float) Math.hypot(fArr[0] - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
            gg1 gg1Var7 = gg1VarArr2[i5];
            fArr[0] = gg1Var7.b;
            fArr[1] = gg1Var7.c;
            matrixArr3[i5].mapPoints(fArr);
            if (i5 == 1 || i5 == 3) {
                Math.abs(rectF.centerX() - fArr[0]);
            } else {
                Math.abs(rectF.centerY() - fArr[1]);
            }
            gg1 gg1Var8 = yf1Var.g;
            gg1Var8.d(0.0f, 270.0f, 0.0f);
            (i5 != 1 ? i5 != 2 ? i5 != 3 ? wf1Var.j : wf1Var.i : wf1Var.l : wf1Var.k).getClass();
            gg1Var8.c(fMax, 0.0f);
            Path path4 = yf1Var.j;
            path4.reset();
            gg1Var8.b(matrixArr[i5], path4);
            if (yf1Var.l && (yf1Var.b(path4, i5) || yf1Var.b(path4, i7))) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr[0] = 0.0f;
                fArr[1] = gg1Var8.a;
                matrixArr[i5].mapPoints(fArr);
                path2.moveTo(fArr[0], fArr[1]);
                gg1Var8.b(matrixArr[i5], path2);
            } else {
                gg1Var8.b(matrixArr[i5], path);
            }
            if (mc1Var != null) {
                Matrix matrix2 = matrixArr[i5];
                rr0 rr0Var2 = (rr0) mc1Var.h;
                rr0Var2.j.set(i5 + 4, false);
                gg1Var8.a(gg1Var8.e);
                rr0Var2.i[i5] = new zf1(new ArrayList(gg1Var8.g), new Matrix(matrix2));
            }
            yf1Var = this;
            i5 = i6;
            gg1VarArr = gg1VarArr2;
            matrixArr2 = matrixArr3;
            i = 4;
            c = 0;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public final boolean b(Path path, int i) {
        Path path2 = this.k;
        path2.reset();
        this.a[i].b(this.b[i], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }
}
