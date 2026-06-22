package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import java.util.BitSet;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class rr0 extends Drawable implements zn1, hg1 {
    public static final Paint C;
    public final RectF A;
    public final boolean B;
    public qr0 g;
    public final fg1[] h;
    public final fg1[] i;
    public final BitSet j;
    public boolean k;
    public final Matrix l;
    public final Path m;
    public final Path n;
    public final RectF o;
    public final RectF p;
    public final Region q;
    public final Region r;
    public wf1 s;
    public final Paint t;
    public final Paint u;
    public final uf1 v;
    public final mc1 w;
    public final yf1 x;
    public PorterDuffColorFilter y;
    public PorterDuffColorFilter z;

    static {
        Paint paint = new Paint(1);
        C = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public rr0() {
        this(new wf1());
    }

    public final void b(RectF rectF, Path path) {
        qr0 qr0Var = this.g;
        this.x.a(qr0Var.a, qr0Var.i, rectF, this.w, path);
        if (this.g.h != 1.0f) {
            Matrix matrix = this.l;
            matrix.reset();
            float f = this.g.h;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.A, true);
    }

    public final int c(int i) {
        int i2;
        qr0 qr0Var = this.g;
        float f = qr0Var.m + 0.0f + qr0Var.l;
        ty tyVar = qr0Var.b;
        if (tyVar == null || !tyVar.a || ik.h(i, 255) != tyVar.d) {
            return i;
        }
        float fMin = (tyVar.e <= 0.0f || f <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f / r4)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i);
        int iP = bf1.p(fMin, ik.h(i, 255), tyVar.b);
        if (fMin > 0.0f && (i2 = tyVar.c) != 0) {
            iP = ik.f(ik.h(i2, ty.f), iP);
        }
        return ik.h(iP, iAlpha);
    }

    public final void d(Canvas canvas) {
        this.j.cardinality();
        int i = this.g.o;
        Path path = this.m;
        uf1 uf1Var = this.v;
        if (i != 0) {
            canvas.drawPath(path, uf1Var.a);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            fg1 fg1Var = this.h[i2];
            int i3 = this.g.n;
            Matrix matrix = fg1.a;
            fg1Var.a(matrix, uf1Var, i3, canvas);
            this.i[i2].a(matrix, uf1Var, this.g.n, canvas);
        }
        if (this.B) {
            int iSin = (int) (Math.sin(Math.toRadians(r0.p)) * ((double) this.g.o));
            int iCos = (int) (Math.cos(Math.toRadians(r2.p)) * ((double) this.g.o));
            canvas.translate(-iSin, -iCos);
            canvas.drawPath(path, C);
            canvas.translate(iSin, iCos);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint = this.t;
        paint.setColorFilter(this.y);
        int alpha = paint.getAlpha();
        int i = this.g.k;
        paint.setAlpha(((i + (i >>> 7)) * alpha) >>> 8);
        Paint paint2 = this.u;
        paint2.setColorFilter(this.z);
        paint2.setStrokeWidth(this.g.j);
        int alpha2 = paint2.getAlpha();
        int i2 = this.g.k;
        paint2.setAlpha(((i2 + (i2 >>> 7)) * alpha2) >>> 8);
        boolean z = this.k;
        Path path = this.m;
        if (z) {
            float f = -(h() ? paint2.getStrokeWidth() / 2.0f : 0.0f);
            wf1 wf1Var = this.g.a;
            vf1 vf1VarE = wf1Var.e();
            to d3Var = wf1Var.e;
            if (!(d3Var instanceof y91)) {
                d3Var = new d3(f, d3Var);
            }
            vf1VarE.e = d3Var;
            to d3Var2 = wf1Var.f;
            if (!(d3Var2 instanceof y91)) {
                d3Var2 = new d3(f, d3Var2);
            }
            vf1VarE.f = d3Var2;
            to d3Var3 = wf1Var.h;
            if (!(d3Var3 instanceof y91)) {
                d3Var3 = new d3(f, d3Var3);
            }
            vf1VarE.h = d3Var3;
            to d3Var4 = wf1Var.g;
            if (!(d3Var4 instanceof y91)) {
                d3Var4 = new d3(f, d3Var4);
            }
            vf1VarE.g = d3Var4;
            wf1 wf1VarA = vf1VarE.a();
            this.s = wf1VarA;
            float f2 = this.g.i;
            RectF rectF = this.p;
            rectF.set(g());
            float strokeWidth = h() ? paint2.getStrokeWidth() / 2.0f : 0.0f;
            rectF.inset(strokeWidth, strokeWidth);
            this.x.a(wf1VarA, f2, rectF, null, this.n);
            b(g(), path);
            this.k = false;
        }
        qr0 qr0Var = this.g;
        qr0Var.getClass();
        if (qr0Var.n > 0) {
            int i3 = Build.VERSION.SDK_INT;
            if (!this.g.a.d(g()) && !path.isConvex() && i3 < 29) {
                canvas.save();
                int iSin = (int) (Math.sin(Math.toRadians(r4.p)) * ((double) this.g.o));
                qr0 qr0Var2 = this.g;
                canvas.translate(iSin, (int) (Math.cos(Math.toRadians(qr0Var2.p)) * ((double) qr0Var2.o)));
                if (this.B) {
                    RectF rectF2 = this.A;
                    int iWidth = (int) (rectF2.width() - getBounds().width());
                    int iHeight = (int) (rectF2.height() - getBounds().height());
                    if (iWidth < 0 || iHeight < 0) {
                        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap((this.g.n * 2) + ((int) rectF2.width()) + iWidth, (this.g.n * 2) + ((int) rectF2.height()) + iHeight, Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                    float f3 = (getBounds().left - this.g.n) - iWidth;
                    float f4 = (getBounds().top - this.g.n) - iHeight;
                    canvas2.translate(-f3, -f4);
                    d(canvas2);
                    canvas.drawBitmap(bitmapCreateBitmap, f3, f4, (Paint) null);
                    bitmapCreateBitmap.recycle();
                    canvas.restore();
                } else {
                    d(canvas);
                    canvas.restore();
                }
            }
        }
        qr0 qr0Var3 = this.g;
        Paint.Style style = qr0Var3.q;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            e(canvas, paint, path, qr0Var3.a, g());
        }
        if (h()) {
            f(canvas);
        }
        paint.setAlpha(alpha);
        paint2.setAlpha(alpha2);
    }

    public final void e(Canvas canvas, Paint paint, Path path, wf1 wf1Var, RectF rectF) {
        if (!wf1Var.d(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = wf1Var.f.a(rectF) * this.g.i;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    public void f(Canvas canvas) {
        Paint paint = this.u;
        Path path = this.n;
        wf1 wf1Var = this.s;
        RectF rectF = this.p;
        rectF.set(g());
        float strokeWidth = h() ? paint.getStrokeWidth() / 2.0f : 0.0f;
        rectF.inset(strokeWidth, strokeWidth);
        e(canvas, paint, path, wf1Var, rectF);
    }

    public final RectF g() {
        RectF rectF = this.o;
        rectF.set(getBounds());
        return rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.g.k;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.g.getClass();
        if (this.g.a.d(g())) {
            outline.setRoundRect(getBounds(), this.g.a.e.a(g()) * this.g.i);
            return;
        }
        RectF rectFG = g();
        Path path = this.m;
        b(rectFG, path);
        if (path.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(path);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.g.g;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.q;
        region.set(bounds);
        RectF rectFG = g();
        Path path = this.m;
        b(rectFG, path);
        Region region2 = this.r;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final boolean h() {
        Paint.Style style = this.g.q;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.u.getStrokeWidth() > 0.0f;
    }

    public final void i(Context context) {
        this.g.b = new ty(context);
        n();
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.k = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.g.e;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.g.getClass();
        ColorStateList colorStateList2 = this.g.d;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.g.c;
        return colorStateList3 != null && colorStateList3.isStateful();
    }

    public final void j(float f) {
        qr0 qr0Var = this.g;
        if (qr0Var.m != f) {
            qr0Var.m = f;
            n();
        }
    }

    public final void k(ColorStateList colorStateList) {
        qr0 qr0Var = this.g;
        if (qr0Var.c != colorStateList) {
            qr0Var.c = colorStateList;
            onStateChange(getState());
        }
    }

    public final boolean l(int[] iArr) {
        boolean z;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.g.c == null || color2 == (colorForState2 = this.g.c.getColorForState(iArr, (color2 = (paint2 = this.t).getColor())))) {
            z = false;
        } else {
            paint2.setColor(colorForState2);
            z = true;
        }
        if (this.g.d == null || color == (colorForState = this.g.d.getColorForState(iArr, (color = (paint = this.u).getColor())))) {
            return z;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final boolean m() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.y;
        PorterDuffColorFilter porterDuffColorFilter3 = this.z;
        qr0 qr0Var = this.g;
        ColorStateList colorStateList = qr0Var.e;
        PorterDuff.Mode mode = qr0Var.f;
        Paint paint = this.t;
        if (colorStateList == null || mode == null) {
            int color = paint.getColor();
            int iC = c(color);
            porterDuffColorFilter = iC != color ? new PorterDuffColorFilter(iC, PorterDuff.Mode.SRC_IN) : null;
        } else {
            porterDuffColorFilter = new PorterDuffColorFilter(c(colorStateList.getColorForState(getState(), 0)), mode);
        }
        this.y = porterDuffColorFilter;
        this.g.getClass();
        this.z = null;
        this.g.getClass();
        return (Objects.equals(porterDuffColorFilter2, this.y) && Objects.equals(porterDuffColorFilter3, this.z)) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        qr0 qr0Var = this.g;
        qr0 qr0Var2 = new qr0();
        qr0Var2.c = null;
        qr0Var2.d = null;
        qr0Var2.e = null;
        qr0Var2.f = PorterDuff.Mode.SRC_IN;
        qr0Var2.g = null;
        qr0Var2.h = 1.0f;
        qr0Var2.i = 1.0f;
        qr0Var2.k = 255;
        qr0Var2.l = 0.0f;
        qr0Var2.m = 0.0f;
        qr0Var2.n = 0;
        qr0Var2.o = 0;
        qr0Var2.p = 0;
        qr0Var2.q = Paint.Style.FILL_AND_STROKE;
        qr0Var2.a = qr0Var.a;
        qr0Var2.b = qr0Var.b;
        qr0Var2.j = qr0Var.j;
        qr0Var2.c = qr0Var.c;
        qr0Var2.d = qr0Var.d;
        qr0Var2.f = qr0Var.f;
        qr0Var2.e = qr0Var.e;
        qr0Var2.k = qr0Var.k;
        qr0Var2.h = qr0Var.h;
        qr0Var2.o = qr0Var.o;
        qr0Var2.i = qr0Var.i;
        qr0Var2.l = qr0Var.l;
        qr0Var2.m = qr0Var.m;
        qr0Var2.n = qr0Var.n;
        qr0Var2.p = qr0Var.p;
        qr0Var2.q = qr0Var.q;
        if (qr0Var.g != null) {
            qr0Var2.g = new Rect(qr0Var.g);
        }
        this.g = qr0Var2;
        return this;
    }

    public final void n() {
        qr0 qr0Var = this.g;
        float f = qr0Var.m + 0.0f;
        qr0Var.n = (int) Math.ceil(0.75f * f);
        this.g.o = (int) Math.ceil(f * 0.25f);
        m();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.k = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, defpackage.dn1
    public boolean onStateChange(int[] iArr) {
        boolean z = l(iArr) || m();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        qr0 qr0Var = this.g;
        if (qr0Var.k != i) {
            qr0Var.k = i;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.g.getClass();
        super.invalidateSelf();
    }

    @Override // defpackage.hg1
    public final void setShapeAppearanceModel(wf1 wf1Var) {
        this.g.a = wf1Var;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.g.e = colorStateList;
        m();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        qr0 qr0Var = this.g;
        if (qr0Var.f != mode) {
            qr0Var.f = mode;
            m();
            super.invalidateSelf();
        }
    }

    public rr0(Context context, AttributeSet attributeSet, int i, int i2) {
        this(wf1.b(context, attributeSet, i, i2).a());
    }

    public rr0(wf1 wf1Var) {
        qr0 qr0Var = new qr0();
        qr0Var.c = null;
        qr0Var.d = null;
        qr0Var.e = null;
        qr0Var.f = PorterDuff.Mode.SRC_IN;
        qr0Var.g = null;
        qr0Var.h = 1.0f;
        qr0Var.i = 1.0f;
        qr0Var.k = 255;
        qr0Var.l = 0.0f;
        qr0Var.m = 0.0f;
        qr0Var.n = 0;
        qr0Var.o = 0;
        qr0Var.p = 0;
        qr0Var.q = Paint.Style.FILL_AND_STROKE;
        qr0Var.a = wf1Var;
        qr0Var.b = null;
        this(qr0Var);
    }

    public rr0(qr0 qr0Var) {
        yf1 yf1Var;
        this.h = new fg1[4];
        this.i = new fg1[4];
        this.j = new BitSet(8);
        this.l = new Matrix();
        this.m = new Path();
        this.n = new Path();
        this.o = new RectF();
        this.p = new RectF();
        this.q = new Region();
        this.r = new Region();
        Paint paint = new Paint(1);
        this.t = paint;
        Paint paint2 = new Paint(1);
        this.u = paint2;
        this.v = new uf1();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            yf1Var = xf1.a;
        } else {
            yf1Var = new yf1();
        }
        this.x = yf1Var;
        this.A = new RectF();
        this.B = true;
        this.g = qr0Var;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        m();
        l(getState());
        this.w = new mc1(this, 16);
    }
}
