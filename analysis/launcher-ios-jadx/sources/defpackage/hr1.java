package defpackage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class hr1 {
    public static final Matrix p = new Matrix();
    public final Path a;
    public final Path b;
    public final Matrix c;
    public Paint d;
    public Paint e;
    public PathMeasure f;
    public final er1 g;
    public float h;
    public float i;
    public float j;
    public float k;
    public int l;
    public String m;
    public Boolean n;
    public final e9 o;

    public hr1() {
        this.c = new Matrix();
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 255;
        this.m = null;
        this.n = null;
        this.o = new e9(0);
        this.g = new er1();
        this.a = new Path();
        this.b = new Path();
    }

    public final void a(er1 er1Var, Matrix matrix, Canvas canvas, int i, int i2) {
        float f;
        int i3;
        float f2;
        er1 er1Var2 = er1Var;
        char c = 1;
        er1Var2.a.set(matrix);
        Matrix matrix2 = er1Var2.j;
        Matrix matrix3 = er1Var2.a;
        matrix3.preConcat(matrix2);
        canvas.save();
        char c2 = 0;
        int i4 = 0;
        while (true) {
            ArrayList arrayList = er1Var2.b;
            if (i4 >= arrayList.size()) {
                canvas.restore();
                return;
            }
            fr1 fr1Var = (fr1) arrayList.get(i4);
            if (fr1Var instanceof er1) {
                a((er1) fr1Var, matrix3, canvas, i, i2);
            } else if (fr1Var instanceof gr1) {
                gr1 gr1Var = (gr1) fr1Var;
                float f3 = i / this.j;
                float f4 = i2 / this.k;
                float fMin = Math.min(f3, f4);
                Matrix matrix4 = this.c;
                matrix4.set(matrix3);
                matrix4.postScale(f3, f4);
                float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                matrix3.mapVectors(fArr);
                float fHypot = (float) Math.hypot(fArr[c2], fArr[c]);
                float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                float f5 = (fArr[0] * fArr[3]) - (fArr[1] * fArr[2]);
                float fMax = Math.max(fHypot, fHypot2);
                float fAbs = fMax > 0.0f ? Math.abs(f5) / fMax : 0.0f;
                if (fAbs != 0.0f) {
                    gr1Var.getClass();
                    Path path = this.a;
                    path.reset();
                    t11[] t11VarArr = gr1Var.a;
                    if (t11VarArr != null) {
                        p02.q(t11VarArr, path);
                    }
                    Path path2 = this.b;
                    path2.reset();
                    if (gr1Var instanceof cr1) {
                        path2.setFillType(gr1Var.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                        path2.addPath(path, matrix4);
                        canvas.clipPath(path2);
                    } else {
                        dr1 dr1Var = (dr1) gr1Var;
                        float f6 = dr1Var.i;
                        if (f6 != 0.0f || dr1Var.j != 1.0f) {
                            float f7 = dr1Var.k;
                            float f8 = (f6 + f7) % 1.0f;
                            float f9 = (dr1Var.j + f7) % 1.0f;
                            if (this.f == null) {
                                this.f = new PathMeasure();
                            }
                            this.f.setPath(path, false);
                            float length = this.f.getLength();
                            float f10 = f8 * length;
                            float f11 = f9 * length;
                            path.reset();
                            if (f10 > f11) {
                                this.f.getSegment(f10, length, path, true);
                                f = 0.0f;
                                this.f.getSegment(0.0f, f11, path, true);
                            } else {
                                f = 0.0f;
                                this.f.getSegment(f10, f11, path, true);
                            }
                            path.rLineTo(f, f);
                        }
                        path2.addPath(path, matrix4);
                        xk xkVar = dr1Var.f;
                        if ((((Shader) xkVar.c) == null && xkVar.b == 0) ? false : true) {
                            if (this.e == null) {
                                i3 = 16777215;
                                Paint paint = new Paint(1);
                                this.e = paint;
                                paint.setStyle(Paint.Style.FILL);
                            } else {
                                i3 = 16777215;
                            }
                            Paint paint2 = this.e;
                            Shader shader = (Shader) xkVar.c;
                            if (shader != null) {
                                shader.setLocalMatrix(matrix4);
                                paint2.setShader(shader);
                                paint2.setAlpha(Math.round(dr1Var.h * 255.0f));
                                f2 = 255.0f;
                            } else {
                                paint2.setShader(null);
                                paint2.setAlpha(255);
                                int i5 = xkVar.b;
                                float f12 = dr1Var.h;
                                PorterDuff.Mode mode = kr1.p;
                                f2 = 255.0f;
                                paint2.setColor((i5 & i3) | (((int) (Color.alpha(i5) * f12)) << 24));
                            }
                            paint2.setColorFilter(null);
                            path2.setFillType(dr1Var.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            canvas.drawPath(path2, paint2);
                        } else {
                            i3 = 16777215;
                            f2 = 255.0f;
                        }
                        xk xkVar2 = dr1Var.d;
                        if (((Shader) xkVar2.c) != null || xkVar2.b != 0) {
                            if (this.d == null) {
                                Paint paint3 = new Paint(1);
                                this.d = paint3;
                                paint3.setStyle(Paint.Style.STROKE);
                            }
                            Paint paint4 = this.d;
                            Paint.Join join = dr1Var.m;
                            if (join != null) {
                                paint4.setStrokeJoin(join);
                            }
                            Paint.Cap cap = dr1Var.l;
                            if (cap != null) {
                                paint4.setStrokeCap(cap);
                            }
                            paint4.setStrokeMiter(dr1Var.n);
                            Shader shader2 = (Shader) xkVar2.c;
                            if (shader2 != null) {
                                shader2.setLocalMatrix(matrix4);
                                paint4.setShader(shader2);
                                paint4.setAlpha(Math.round(dr1Var.g * f2));
                            } else {
                                paint4.setShader(null);
                                paint4.setAlpha(255);
                                int i6 = xkVar2.b;
                                float f13 = dr1Var.g;
                                PorterDuff.Mode mode2 = kr1.p;
                                paint4.setColor((i6 & i3) | (((int) (Color.alpha(i6) * f13)) << 24));
                            }
                            paint4.setColorFilter(null);
                            paint4.setStrokeWidth(dr1Var.e * fMin * fAbs);
                            canvas.drawPath(path2, paint4);
                        }
                    }
                }
                i4++;
                er1Var2 = er1Var;
                c = 1;
                c2 = 0;
            }
            i4++;
            er1Var2 = er1Var;
            c = 1;
            c2 = 0;
        }
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.l;
    }

    public void setAlpha(float f) {
        setRootAlpha((int) (f * 255.0f));
    }

    public void setRootAlpha(int i) {
        this.l = i;
    }

    public hr1(hr1 hr1Var) {
        this.c = new Matrix();
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 255;
        this.m = null;
        this.n = null;
        e9 e9Var = new e9(0);
        this.o = e9Var;
        this.g = new er1(hr1Var.g, e9Var);
        this.a = new Path(hr1Var.a);
        this.b = new Path(hr1Var.b);
        this.h = hr1Var.h;
        this.i = hr1Var.i;
        this.j = hr1Var.j;
        this.k = hr1Var.k;
        this.l = hr1Var.l;
        this.m = hr1Var.m;
        String str = hr1Var.m;
        if (str != null) {
            e9Var.put(str, this);
        }
        this.n = hr1Var.n;
    }
}
