package com.luutinhit.launcherios.cropper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ScaleGestureDetector;
import android.view.View;
import defpackage.aq;
import defpackage.bq;
import defpackage.cq;
import defpackage.ow1;
import defpackage.qp;
import defpackage.rp;
import defpackage.sc;
import defpackage.sp;
import defpackage.zp;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class CropOverlayView extends View {
    public boolean A;
    public int B;
    public int C;
    public float D;
    public sp E;
    public rp F;
    public final Rect G;
    public boolean H;
    public float I;
    public ScaleGestureDetector g;
    public boolean h;
    public final bq i;
    public zp j;
    public final RectF k;
    public Paint l;
    public Paint m;
    public Paint n;
    public Paint o;
    public final Path p;
    public final float[] q;
    public final RectF r;
    public int s;
    public int t;
    public float u;
    public float v;
    public float w;
    public float x;
    public float y;
    public cq z;

    public CropOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new bq();
        this.k = new RectF();
        this.p = new Path();
        this.q = new float[8];
        this.r = new RectF();
        this.C = 1;
        this.D = this.B / 1;
        this.G = new Rect();
    }

    public static Paint e(float f, int i) {
        if (f <= 0.0f) {
            return null;
        }
        Paint paint = new Paint();
        paint.setColor(i);
        paint.setStrokeWidth(f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

    public final boolean a(RectF rectF) {
        float f;
        float f2;
        float[] fArr = this.q;
        float fO = sc.o(fArr);
        float fQ = sc.q(fArr);
        float fP = sc.p(fArr);
        float fM = sc.m(fArr);
        boolean z = (fArr[0] == fArr[6] || fArr[1] == fArr[7]) ? false : true;
        RectF rectF2 = this.r;
        if (!z) {
            rectF2.set(fO, fQ, fP, fM);
            return false;
        }
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float f7 = fArr[6];
        float f8 = fArr[7];
        if (f8 < f4) {
            f2 = fArr[3];
            if (f4 < f2) {
                float f9 = fArr[2];
                f = f7;
                f4 = f6;
                f7 = f9;
                f6 = f8;
                f3 = f5;
            } else {
                f2 = f4;
                f4 = f2;
                f7 = f3;
                f3 = fArr[2];
                f = f5;
            }
        } else {
            float f10 = fArr[3];
            if (f4 > f10) {
                f = fArr[2];
                f6 = f10;
                f2 = f8;
            } else {
                f = f3;
                f3 = f7;
                f7 = f5;
                f2 = f6;
                f6 = f4;
                f4 = f8;
            }
        }
        float f11 = (f4 - f6) / (f3 - f);
        float f12 = (-1.0f) / f11;
        float f13 = f6 - (f11 * f);
        float f14 = f6 - (f * f12);
        float f15 = f2 - (f11 * f7);
        float f16 = f2 - (f7 * f12);
        float fCenterY = rectF.centerY() - rectF.top;
        float fCenterX = rectF.centerX();
        float f17 = rectF.left;
        float f18 = fCenterY / (fCenterX - f17);
        float f19 = -f18;
        float f20 = rectF.top;
        float f21 = f20 - (f17 * f18);
        float f22 = rectF.right;
        float f23 = f20 - (f19 * f22);
        float f24 = f11 - f18;
        float f25 = (f21 - f13) / f24;
        float fMax = Math.max(fO, f25 < f22 ? f25 : fO);
        float f26 = (f21 - f14) / (f12 - f18);
        if (f26 >= rectF.right) {
            f26 = fMax;
        }
        float fMax2 = Math.max(fMax, f26);
        float f27 = f12 - f19;
        float f28 = (f23 - f16) / f27;
        if (f28 >= rectF.right) {
            f28 = fMax2;
        }
        float fMax3 = Math.max(fMax2, f28);
        float f29 = (f23 - f14) / f27;
        if (f29 <= rectF.left) {
            f29 = fP;
        }
        float fMin = Math.min(fP, f29);
        float f30 = (f23 - f15) / (f11 - f19);
        float fMin2 = Math.min(fMin, f30 > rectF.left ? f30 : fMin);
        float f31 = (f21 - f15) / f24;
        if (f31 <= rectF.left) {
            f31 = fMin2;
        }
        float fMin3 = Math.min(fMin2, f31);
        float fMax4 = Math.max(fQ, Math.max((f11 * fMax3) + f13, (f12 * fMin3) + f14));
        float fMin4 = Math.min(fM, Math.min((f12 * fMax3) + f16, (f11 * fMin3) + f15));
        rectF2.left = fMax3;
        rectF2.top = fMax4;
        rectF2.right = fMin3;
        rectF2.bottom = fMin4;
        return true;
    }

    public final void b(boolean z) {
        try {
            zp zpVar = this.j;
            if (zpVar != null) {
                int i = CropImageView.P;
                ((CropImageView) ((ow1) zpVar).h).c(z, true);
            }
        } catch (Exception unused) {
        }
    }

    public final void c(Canvas canvas) {
        if (this.n != null) {
            Paint paint = this.l;
            float strokeWidth = paint != null ? paint.getStrokeWidth() : 0.0f;
            RectF rectFA = this.i.a();
            rectFA.inset(strokeWidth, strokeWidth);
            float fWidth = rectFA.width() / 3.0f;
            float fHeight = rectFA.height() / 3.0f;
            if (this.F != rp.h) {
                float f = rectFA.left + fWidth;
                float f2 = rectFA.right - fWidth;
                canvas.drawLine(f, rectFA.top, f, rectFA.bottom, this.n);
                canvas.drawLine(f2, rectFA.top, f2, rectFA.bottom, this.n);
                float f3 = rectFA.top + fHeight;
                float f4 = rectFA.bottom - fHeight;
                canvas.drawLine(rectFA.left, f3, rectFA.right, f3, this.n);
                canvas.drawLine(rectFA.left, f4, rectFA.right, f4, this.n);
                return;
            }
            float fWidth2 = (rectFA.width() / 2.0f) - strokeWidth;
            float fHeight2 = (rectFA.height() / 2.0f) - strokeWidth;
            float f5 = rectFA.left + fWidth;
            float f6 = rectFA.right - fWidth;
            float fSin = (float) (Math.sin(Math.acos((fWidth2 - fWidth) / fWidth2)) * ((double) fHeight2));
            canvas.drawLine(f5, (rectFA.top + fHeight2) - fSin, f5, (rectFA.bottom - fHeight2) + fSin, this.n);
            canvas.drawLine(f6, (rectFA.top + fHeight2) - fSin, f6, (rectFA.bottom - fHeight2) + fSin, this.n);
            float f7 = rectFA.top + fHeight;
            float f8 = rectFA.bottom - fHeight;
            float fCos = (float) (Math.cos(Math.asin((fHeight2 - fHeight) / fHeight2)) * ((double) fWidth2));
            canvas.drawLine((rectFA.left + fWidth2) - fCos, f7, (rectFA.right - fWidth2) + fCos, f7, this.n);
            canvas.drawLine((rectFA.left + fWidth2) - fCos, f8, (rectFA.right - fWidth2) + fCos, f8, this.n);
        }
    }

    public final void d(RectF rectF) {
        float fWidth = rectF.width();
        bq bqVar = this.i;
        if (fWidth < Math.max(bqVar.c, bqVar.g / bqVar.k)) {
            float fMax = (Math.max(bqVar.c, bqVar.g / bqVar.k) - rectF.width()) / 2.0f;
            rectF.left -= fMax;
            rectF.right += fMax;
        }
        if (rectF.height() < Math.max(bqVar.d, bqVar.h / bqVar.l)) {
            float fMax2 = (Math.max(bqVar.d, bqVar.h / bqVar.l) - rectF.height()) / 2.0f;
            rectF.top -= fMax2;
            rectF.bottom += fMax2;
        }
        if (rectF.width() > Math.min(bqVar.e, bqVar.i / bqVar.k)) {
            float fWidth2 = (rectF.width() - Math.min(bqVar.e, bqVar.i / bqVar.k)) / 2.0f;
            rectF.left += fWidth2;
            rectF.right -= fWidth2;
        }
        if (rectF.height() > Math.min(bqVar.f, bqVar.j / bqVar.l)) {
            float fHeight = (rectF.height() - Math.min(bqVar.f, bqVar.j / bqVar.l)) / 2.0f;
            rectF.top += fHeight;
            rectF.bottom -= fHeight;
        }
        a(rectF);
        RectF rectF2 = this.r;
        if (rectF2.width() > 0.0f && rectF2.height() > 0.0f) {
            float fMax3 = Math.max(rectF2.left, 0.0f);
            float fMax4 = Math.max(rectF2.top, 0.0f);
            float fMin = Math.min(rectF2.right, getWidth());
            float fMin2 = Math.min(rectF2.bottom, getHeight());
            if (rectF.left < fMax3) {
                rectF.left = fMax3;
            }
            if (rectF.top < fMax4) {
                rectF.top = fMax4;
            }
            if (rectF.right > fMin) {
                rectF.right = fMin;
            }
            if (rectF.bottom > fMin2) {
                rectF.bottom = fMin2;
            }
        }
        if (!this.A || Math.abs(rectF.width() - (rectF.height() * this.D)) <= 0.1d) {
            return;
        }
        if (rectF.width() > rectF.height() * this.D) {
            float fAbs = Math.abs((rectF.height() * this.D) - rectF.width()) / 2.0f;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        } else {
            float fAbs2 = Math.abs((rectF.width() / this.D) - rectF.height()) / 2.0f;
            rectF.top += fAbs2;
            rectF.bottom -= fAbs2;
        }
    }

    public final void f() {
        float[] fArr = this.q;
        float fMax = Math.max(sc.o(fArr), 0.0f);
        float fMax2 = Math.max(sc.q(fArr), 0.0f);
        float fMin = Math.min(sc.p(fArr), getWidth());
        float fMin2 = Math.min(sc.m(fArr), getHeight());
        if (fMin <= fMax || fMin2 <= fMax2) {
            return;
        }
        RectF rectF = new RectF();
        this.H = true;
        float f = this.w;
        float f2 = fMin - fMax;
        float f3 = f * f2;
        float f4 = fMin2 - fMax2;
        float f5 = f * f4;
        Rect rect = this.G;
        int iWidth = rect.width();
        bq bqVar = this.i;
        if (iWidth > 0 && rect.height() > 0) {
            float f6 = (rect.left / bqVar.k) + fMax;
            rectF.left = f6;
            rectF.top = (rect.top / bqVar.l) + fMax2;
            rectF.right = (rect.width() / bqVar.k) + f6;
            rectF.bottom = (rect.height() / bqVar.l) + rectF.top;
            rectF.left = Math.max(fMax, rectF.left);
            rectF.top = Math.max(fMax2, rectF.top);
            rectF.right = Math.min(fMin, rectF.right);
            rectF.bottom = Math.min(fMin2, rectF.bottom);
        } else if (!this.A || fMin <= fMax || fMin2 <= fMax2) {
            rectF.left = fMax + f3;
            rectF.top = fMax2 + f5;
            rectF.right = fMin - f3;
            rectF.bottom = fMin2 - f5;
        } else if (f2 / f4 > this.D) {
            rectF.top = fMax2 + f5;
            rectF.bottom = fMin2 - f5;
            float width = getWidth() / 2.0f;
            this.D = this.B / this.C;
            float fMax3 = Math.max(Math.max(bqVar.c, bqVar.g / bqVar.k), rectF.height() * this.D) / 2.0f;
            rectF.left = width - fMax3;
            rectF.right = width + fMax3;
        } else {
            rectF.left = fMax + f3;
            rectF.right = fMin - f3;
            float height = getHeight() / 2.0f;
            float fMax4 = Math.max(Math.max(bqVar.d, bqVar.h / bqVar.l), rectF.width() / this.D) / 2.0f;
            rectF.top = height - fMax4;
            rectF.bottom = height + fMax4;
        }
        d(rectF);
        bqVar.a.set(rectF);
    }

    public final void g() {
        if (this.H) {
            setCropWindowRect(sc.b);
            f();
            invalidate();
        }
    }

    public int getAspectRatioX() {
        return this.B;
    }

    public int getAspectRatioY() {
        return this.C;
    }

    public rp getCropShape() {
        return this.F;
    }

    public RectF getCropWindowRect() {
        return this.i.a();
    }

    public sp getGuidelines() {
        return this.E;
    }

    public Rect getInitialCropWindowRect() {
        return this.G;
    }

    public final void h(float[] fArr, int i, int i2) {
        float[] fArr2 = this.q;
        if (fArr == null || !Arrays.equals(fArr2, fArr)) {
            if (fArr == null) {
                Arrays.fill(fArr2, 0.0f);
            } else {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
            }
            this.s = i;
            this.t = i2;
            RectF rectFA = this.i.a();
            if (rectFA.width() == 0.0f || rectFA.height() == 0.0f) {
                f();
            }
        }
    }

    public final boolean i(boolean z) {
        if (this.h == z) {
            return false;
        }
        this.h = z;
        if (!z || this.g != null) {
            return true;
        }
        this.g = new ScaleGestureDetector(getContext(), new aq(this));
        return true;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        bq bqVar = this.i;
        RectF rectFA = bqVar.a();
        float[] fArr = this.q;
        float fMax = Math.max(sc.o(fArr), 0.0f);
        float fMax2 = Math.max(sc.q(fArr), 0.0f);
        float fMin = Math.min(sc.p(fArr), getWidth());
        float fMin2 = Math.min(sc.m(fArr), getHeight());
        rp rpVar = this.F;
        rp rpVar2 = rp.g;
        Path path = this.p;
        if (rpVar != rpVar2) {
            path.reset();
            int i = Build.VERSION.SDK_INT;
            RectF rectF = this.k;
            rectF.set(rectFA.left, rectFA.top, rectFA.right, rectFA.bottom);
            float fAbs = Math.abs(rectFA.right - rectFA.left) * this.I;
            path.addRoundRect(rectF, fAbs, fAbs, Path.Direction.CW);
            canvas2.save();
            if (i >= 26) {
                canvas2.clipOutPath(path);
            } else {
                canvas2.clipPath(path, Region.Op.XOR);
            }
            canvas2.drawRect(fMax, fMax2, fMin, fMin2, this.o);
            canvas2.restore();
        } else if (fArr[0] == fArr[6] || fArr[1] == fArr[7]) {
            canvas2 = canvas;
            canvas2.drawRect(fMax, fMax2, fMin, rectFA.top, this.o);
            canvas2.drawRect(fMax, rectFA.bottom, fMin, fMin2, this.o);
            canvas2.drawRect(fMax, rectFA.top, rectFA.left, rectFA.bottom, this.o);
            canvas2.drawRect(rectFA.right, rectFA.top, fMin, rectFA.bottom, this.o);
        } else {
            int i2 = Build.VERSION.SDK_INT;
            path.reset();
            path.moveTo(fArr[0], fArr[1]);
            path.lineTo(fArr[2], fArr[3]);
            path.lineTo(fArr[4], fArr[5]);
            path.lineTo(fArr[6], fArr[7]);
            path.close();
            canvas2.save();
            if (i2 >= 26) {
                canvas2.clipOutPath(path);
            } else {
                canvas2.clipPath(path, Region.Op.INTERSECT);
            }
            canvas2.clipRect(rectFA, Region.Op.XOR);
            canvas2.drawRect(fMax, fMax2, fMin, fMin2, this.o);
            canvas.restore();
            canvas2 = canvas;
        }
        RectF rectF2 = bqVar.a;
        if (rectF2.width() >= 100.0f && rectF2.height() >= 100.0f) {
            sp spVar = this.E;
            if (spVar == sp.h) {
                c(canvas);
            } else if (spVar == sp.g && this.z != null) {
                c(canvas);
            }
        }
        Paint paint = this.l;
        if (paint != null) {
            float strokeWidth = paint.getStrokeWidth();
            RectF rectFA2 = bqVar.a();
            float f = strokeWidth / 2.0f;
            rectFA2.inset(f, f);
            if (this.F == rpVar2) {
                canvas2.drawRect(rectFA2, this.l);
            } else {
                float fAbs2 = Math.abs(rectFA2.right - rectFA2.left) * this.I;
                canvas2.drawRoundRect(rectFA2, fAbs2, fAbs2, this.l);
            }
        }
        if (this.m != null) {
            Paint paint2 = this.l;
            float strokeWidth2 = paint2 != null ? paint2.getStrokeWidth() : 0.0f;
            float strokeWidth3 = this.m.getStrokeWidth();
            float f2 = strokeWidth3 / 2.0f;
            float f3 = (this.F == rpVar2 ? this.u : 0.0f) + f2;
            RectF rectFA3 = bqVar.a();
            rectFA3.inset(f3, f3);
            float f4 = (strokeWidth3 - strokeWidth2) / 2.0f;
            float f5 = f2 + f4;
            float f6 = rectFA3.left - f4;
            float f7 = rectFA3.top;
            canvas2.drawLine(f6, f7 - f5, f6, this.v + f7, this.m);
            float f8 = rectFA3.left;
            float f9 = rectFA3.top - f4;
            canvas.drawLine(f8 - f5, f9, this.v + f8, f9, this.m);
            float f10 = rectFA3.right + f4;
            float f11 = rectFA3.top;
            canvas.drawLine(f10, f11 - f5, f10, f11 + this.v, this.m);
            float f12 = rectFA3.right;
            float f13 = rectFA3.top - f4;
            canvas.drawLine(f12 + f5, f13, f12 - this.v, f13, this.m);
            float f14 = rectFA3.left - f4;
            float f15 = rectFA3.bottom;
            canvas.drawLine(f14, f15 + f5, f14, f15 - this.v, this.m);
            float f16 = rectFA3.left;
            float f17 = rectFA3.bottom + f4;
            canvas.drawLine(f16 - f5, f17, this.v + f16, f17, this.m);
            float f18 = rectFA3.right + f4;
            float f19 = rectFA3.bottom;
            canvas.drawLine(f18, f19 + f5, f18, f19 - this.v, this.m);
            float f20 = rectFA3.right;
            float f21 = rectFA3.bottom + f4;
            canvas.drawLine(f20 + f5, f21, f20 - this.v, f21, this.m);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r22) {
        /*
            Method dump skipped, instruction units count: 1210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcherios.cropper.CropOverlayView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAspectRatioX(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (this.B != i) {
            this.B = i;
            this.D = i / this.C;
            if (this.H) {
                f();
                invalidate();
            }
        }
    }

    public void setAspectRatioY(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (this.C != i) {
            this.C = i;
            this.D = this.B / i;
            if (this.H) {
                f();
                invalidate();
            }
        }
    }

    public void setCornerPercent(float f) {
        this.I = f;
    }

    public void setCropShape(rp rpVar) {
        if (this.F != rpVar) {
            this.F = rpVar;
            invalidate();
        }
    }

    public void setCropWindowChangeListener(zp zpVar) {
        this.j = zpVar;
    }

    public void setCropWindowRect(RectF rectF) {
        this.i.a.set(rectF);
    }

    public void setFixedAspectRatio(boolean z) {
        if (this.A != z) {
            this.A = z;
            if (this.H) {
                f();
                invalidate();
            }
        }
    }

    public void setGuidelines(sp spVar) {
        if (this.E != spVar) {
            this.E = spVar;
            if (this.H) {
                invalidate();
            }
        }
    }

    public void setInitialAttributeValues(qp qpVar) {
        bq bqVar = this.i;
        bqVar.getClass();
        bqVar.c = qpVar.E;
        bqVar.d = qpVar.F;
        bqVar.g = qpVar.G;
        bqVar.h = qpVar.H;
        bqVar.i = qpVar.I;
        bqVar.j = qpVar.J;
        setCornerPercent(qpVar.h);
        setCropShape(qpVar.g);
        setSnapRadius(qpVar.i);
        setGuidelines(qpVar.k);
        setFixedAspectRatio(qpVar.s);
        setAspectRatioX(qpVar.t);
        setAspectRatioY(qpVar.u);
        i(qpVar.p);
        this.x = qpVar.j;
        this.w = qpVar.r;
        this.l = e(qpVar.v, qpVar.w);
        this.u = qpVar.y;
        this.v = qpVar.z;
        this.m = e(qpVar.x, qpVar.A);
        this.n = e(qpVar.B, qpVar.C);
        int i = qpVar.D;
        Paint paint = new Paint();
        paint.setColor(i);
        this.o = paint;
    }

    public void setInitialCropWindowRect(Rect rect) {
        if (rect == null) {
            rect = sc.a;
        }
        this.G.set(rect);
        if (this.H) {
            f();
            invalidate();
            b(false);
        }
    }

    public void setSnapRadius(float f) {
        this.y = f;
    }
}
