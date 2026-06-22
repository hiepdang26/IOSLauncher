package defpackage;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.animation.LinearInterpolator;
import com.google.android.material.textfield.TextInputLayout;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class vj {
    public CharSequence A;
    public CharSequence B;
    public boolean C;
    public Bitmap D;
    public float E;
    public float F;
    public float G;
    public float H;
    public float I;
    public int[] J;
    public boolean K;
    public final TextPaint L;
    public final TextPaint M;
    public LinearInterpolator N;
    public LinearInterpolator O;
    public float P;
    public float Q;
    public float R;
    public ColorStateList S;
    public float T;
    public float U;
    public float V;
    public StaticLayout W;
    public float X;
    public CharSequence Y;
    public final TextInputLayout a;
    public boolean b;
    public float c;
    public final Rect d;
    public final Rect e;
    public final RectF f;
    public ColorStateList k;
    public ColorStateList l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public Typeface s;
    public Typeface t;
    public Typeface u;
    public Typeface v;
    public Typeface w;
    public Typeface x;
    public Typeface y;
    public dg z;
    public int g = 16;
    public int h = 16;
    public float i = 15.0f;
    public float j = 15.0f;
    public final int Z = ij1.l;

    public vj(TextInputLayout textInputLayout) {
        this.a = textInputLayout;
        TextPaint textPaint = new TextPaint(129);
        this.L = textPaint;
        this.M = new TextPaint(textPaint);
        this.e = new Rect();
        this.d = new Rect();
        this.f = new RectF();
        g(textInputLayout.getContext().getResources().getConfiguration());
    }

    public static int a(float f, int i, int i2) {
        float f2 = 1.0f - f;
        return Color.argb(Math.round((Color.alpha(i2) * f) + (Color.alpha(i) * f2)), Math.round((Color.red(i2) * f) + (Color.red(i) * f2)), Math.round((Color.green(i2) * f) + (Color.green(i) * f2)), Math.round((Color.blue(i2) * f) + (Color.blue(i) * f2)));
    }

    public static float f(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return n5.a(f, f2, f3);
    }

    public final boolean b(CharSequence charSequence) {
        WeakHashMap weakHashMap = qs1.a;
        return (this.a.getLayoutDirection() == 1 ? an1.d : an1.c).c(charSequence, charSequence.length());
    }

    public final void c(float f, boolean z) {
        boolean z2;
        float f2;
        float f3;
        boolean z3;
        StaticLayout staticLayoutA;
        if (this.A == null) {
            return;
        }
        float fWidth = this.e.width();
        float fWidth2 = this.d.width();
        if (Math.abs(f - 1.0f) < 1.0E-5f) {
            f2 = this.j;
            f3 = this.T;
            this.E = 1.0f;
            Typeface typeface = this.y;
            Typeface typeface2 = this.s;
            if (typeface != typeface2) {
                this.y = typeface2;
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            float f4 = this.i;
            float f5 = this.U;
            Typeface typeface3 = this.y;
            Typeface typeface4 = this.v;
            if (typeface3 != typeface4) {
                this.y = typeface4;
                z2 = true;
            } else {
                z2 = false;
            }
            if (Math.abs(f - 0.0f) < 1.0E-5f) {
                this.E = 1.0f;
            } else {
                this.E = f(this.i, this.j, f, this.O) / this.i;
            }
            float f6 = this.j / this.i;
            fWidth = (!z && fWidth2 * f6 > fWidth) ? Math.min(fWidth / f6, fWidth2) : fWidth2;
            f2 = f4;
            f3 = f5;
            z3 = z2;
        }
        if (fWidth > 0.0f) {
            z3 = ((this.F > f2 ? 1 : (this.F == f2 ? 0 : -1)) != 0) || ((this.V > f3 ? 1 : (this.V == f3 ? 0 : -1)) != 0) || this.K || z3;
            this.F = f2;
            this.V = f3;
            this.K = false;
        }
        if (this.B == null || z3) {
            float f7 = this.F;
            TextPaint textPaint = this.L;
            textPaint.setTextSize(f7);
            textPaint.setTypeface(this.y);
            textPaint.setLetterSpacing(this.V);
            textPaint.setLinearText(this.E != 1.0f);
            boolean zB = b(this.A);
            this.C = zB;
            try {
                Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
                ij1 ij1Var = new ij1(this.A, textPaint, (int) fWidth);
                ij1Var.k = TextUtils.TruncateAt.END;
                ij1Var.j = zB;
                ij1Var.e = alignment;
                ij1Var.i = false;
                ij1Var.f = 1;
                ij1Var.g = 1.0f;
                ij1Var.h = this.Z;
                staticLayoutA = ij1Var.a();
            } catch (hj1 e) {
                e.getCause().getMessage();
                staticLayoutA = null;
            }
            staticLayoutA.getClass();
            this.W = staticLayoutA;
            this.B = staticLayoutA.getText();
        }
    }

    public final float d() {
        TextPaint textPaint = this.M;
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
        textPaint.setLetterSpacing(this.T);
        return -textPaint.ascent();
    }

    public final int e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.J;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void g(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.u;
            if (typeface != null) {
                this.t = e42.k(configuration, typeface);
            }
            Typeface typeface2 = this.x;
            if (typeface2 != null) {
                this.w = e42.k(configuration, typeface2);
            }
            Typeface typeface3 = this.t;
            if (typeface3 == null) {
                typeface3 = this.u;
            }
            this.s = typeface3;
            Typeface typeface4 = this.w;
            if (typeface4 == null) {
                typeface4 = this.x;
            }
            this.v = typeface4;
            i(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            r2 = this;
            android.graphics.Rect r0 = r2.e
            int r1 = r0.width()
            if (r1 <= 0) goto L1e
            int r0 = r0.height()
            if (r0 <= 0) goto L1e
            android.graphics.Rect r0 = r2.d
            int r1 = r0.width()
            if (r1 <= 0) goto L1e
            int r0 = r0.height()
            if (r0 <= 0) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            r2.b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vj.h():void");
    }

    public final void i(boolean z) {
        StaticLayout staticLayout;
        TextInputLayout textInputLayout = this.a;
        if ((textInputLayout.getHeight() <= 0 || textInputLayout.getWidth() <= 0) && !z) {
            return;
        }
        c(1.0f, z);
        CharSequence charSequence = this.B;
        TextPaint textPaint = this.L;
        if (charSequence != null && (staticLayout = this.W) != null) {
            this.Y = TextUtils.ellipsize(charSequence, textPaint, staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.Y;
        if (charSequence2 != null) {
            this.X = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.X = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.h, this.C ? 1 : 0);
        int i = absoluteGravity & 112;
        Rect rect = this.e;
        if (i == 48) {
            this.n = rect.top;
        } else if (i != 80) {
            this.n = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.n = textPaint.ascent() + rect.bottom;
        }
        int i2 = absoluteGravity & 8388615;
        if (i2 == 1) {
            this.p = rect.centerX() - (this.X / 2.0f);
        } else if (i2 != 5) {
            this.p = rect.left;
        } else {
            this.p = rect.right - this.X;
        }
        c(0.0f, z);
        float height = this.W != null ? r1.getHeight() : 0.0f;
        CharSequence charSequence3 = this.B;
        float fMeasureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        StaticLayout staticLayout2 = this.W;
        if (staticLayout2 != null) {
            staticLayout2.getLineCount();
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.g, this.C ? 1 : 0);
        int i3 = absoluteGravity2 & 112;
        Rect rect2 = this.d;
        if (i3 == 48) {
            this.m = rect2.top;
        } else if (i3 != 80) {
            this.m = rect2.centerY() - (height / 2.0f);
        } else {
            this.m = textPaint.descent() + (rect2.bottom - height);
        }
        int i4 = absoluteGravity2 & 8388615;
        if (i4 == 1) {
            this.o = rect2.centerX() - (fMeasureText / 2.0f);
        } else if (i4 != 5) {
            this.o = rect2.left;
        } else {
            this.o = rect2.right - fMeasureText;
        }
        Bitmap bitmap = this.D;
        if (bitmap != null) {
            bitmap.recycle();
            this.D = null;
        }
        m(this.c);
        float f = this.c;
        float f2 = f(rect2.left, rect.left, f, this.N);
        RectF rectF = this.f;
        rectF.left = f2;
        rectF.top = f(this.m, this.n, f, this.N);
        rectF.right = f(rect2.right, rect.right, f, this.N);
        rectF.bottom = f(rect2.bottom, rect.bottom, f, this.N);
        this.q = f(this.o, this.p, f, this.N);
        this.r = f(this.m, this.n, f, this.N);
        m(f);
        p20 p20Var = n5.b;
        f(0.0f, 1.0f, 1.0f - f, p20Var);
        WeakHashMap weakHashMap = qs1.a;
        textInputLayout.postInvalidateOnAnimation();
        f(1.0f, 0.0f, f, p20Var);
        textInputLayout.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.l;
        ColorStateList colorStateList2 = this.k;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(a(f, e(colorStateList2), e(this.l)));
        } else {
            textPaint.setColor(e(colorStateList));
        }
        float f3 = this.T;
        float f4 = this.U;
        if (f3 != f4) {
            textPaint.setLetterSpacing(f(f4, f3, f, p20Var));
        } else {
            textPaint.setLetterSpacing(f3);
        }
        this.G = n5.a(0.0f, this.P, f);
        this.H = n5.a(0.0f, this.Q, f);
        this.I = n5.a(0.0f, this.R, f);
        textPaint.setShadowLayer(this.G, this.H, this.I, a(f, 0, e(this.S)));
        textInputLayout.postInvalidateOnAnimation();
    }

    public final void j(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            i(false);
        }
    }

    public final boolean k(Typeface typeface) {
        dg dgVar = this.z;
        if (dgVar != null) {
            dgVar.o = true;
        }
        if (this.u == typeface) {
            return false;
        }
        this.u = typeface;
        Typeface typefaceK = e42.k(this.a.getContext().getResources().getConfiguration(), typeface);
        this.t = typefaceK;
        if (typefaceK == null) {
            typefaceK = this.u;
        }
        this.s = typefaceK;
        return true;
    }

    public final void l(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f != this.c) {
            this.c = f;
            float f2 = this.d.left;
            Rect rect = this.e;
            float f3 = f(f2, rect.left, f, this.N);
            RectF rectF = this.f;
            rectF.left = f3;
            rectF.top = f(this.m, this.n, f, this.N);
            rectF.right = f(r2.right, rect.right, f, this.N);
            rectF.bottom = f(r2.bottom, rect.bottom, f, this.N);
            this.q = f(this.o, this.p, f, this.N);
            this.r = f(this.m, this.n, f, this.N);
            m(f);
            p20 p20Var = n5.b;
            f(0.0f, 1.0f, 1.0f - f, p20Var);
            WeakHashMap weakHashMap = qs1.a;
            TextInputLayout textInputLayout = this.a;
            textInputLayout.postInvalidateOnAnimation();
            f(1.0f, 0.0f, f, p20Var);
            textInputLayout.postInvalidateOnAnimation();
            ColorStateList colorStateList = this.l;
            ColorStateList colorStateList2 = this.k;
            TextPaint textPaint = this.L;
            if (colorStateList != colorStateList2) {
                textPaint.setColor(a(f, e(colorStateList2), e(this.l)));
            } else {
                textPaint.setColor(e(colorStateList));
            }
            float f4 = this.T;
            float f5 = this.U;
            if (f4 != f5) {
                textPaint.setLetterSpacing(f(f5, f4, f, p20Var));
            } else {
                textPaint.setLetterSpacing(f4);
            }
            this.G = n5.a(0.0f, this.P, f);
            this.H = n5.a(0.0f, this.Q, f);
            this.I = n5.a(0.0f, this.R, f);
            textPaint.setShadowLayer(this.G, this.H, this.I, a(f, 0, e(this.S)));
            textInputLayout.postInvalidateOnAnimation();
        }
    }

    public final void m(float f) {
        c(f, false);
        WeakHashMap weakHashMap = qs1.a;
        this.a.postInvalidateOnAnimation();
    }

    public final void n(Typeface typeface) {
        boolean z;
        boolean zK = k(typeface);
        if (this.x != typeface) {
            this.x = typeface;
            Typeface typefaceK = e42.k(this.a.getContext().getResources().getConfiguration(), typeface);
            this.w = typefaceK;
            if (typefaceK == null) {
                typefaceK = this.x;
            }
            this.v = typefaceK;
            z = true;
        } else {
            z = false;
        }
        if (zK || z) {
            i(false);
        }
    }
}
