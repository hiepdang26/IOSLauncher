package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public final class zm1 {
    public final ColorStateList a;
    public final String b;
    public final int c;
    public final int d;
    public final float e;
    public final float f;
    public final float g;
    public final boolean h;
    public final float i;
    public ColorStateList j;
    public float k;
    public final int l;
    public boolean m = false;
    public Typeface n;

    public zm1(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, f71.TextAppearance);
        this.k = typedArrayObtainStyledAttributes.getDimension(f71.TextAppearance_android_textSize, 0.0f);
        this.j = np1.l(context, typedArrayObtainStyledAttributes, f71.TextAppearance_android_textColor);
        np1.l(context, typedArrayObtainStyledAttributes, f71.TextAppearance_android_textColorHint);
        np1.l(context, typedArrayObtainStyledAttributes, f71.TextAppearance_android_textColorLink);
        this.c = typedArrayObtainStyledAttributes.getInt(f71.TextAppearance_android_textStyle, 0);
        this.d = typedArrayObtainStyledAttributes.getInt(f71.TextAppearance_android_typeface, 1);
        int i2 = f71.TextAppearance_fontFamily;
        i2 = typedArrayObtainStyledAttributes.hasValue(i2) ? i2 : f71.TextAppearance_android_fontFamily;
        this.l = typedArrayObtainStyledAttributes.getResourceId(i2, 0);
        this.b = typedArrayObtainStyledAttributes.getString(i2);
        typedArrayObtainStyledAttributes.getBoolean(f71.TextAppearance_textAllCaps, false);
        this.a = np1.l(context, typedArrayObtainStyledAttributes, f71.TextAppearance_android_shadowColor);
        this.e = typedArrayObtainStyledAttributes.getFloat(f71.TextAppearance_android_shadowDx, 0.0f);
        this.f = typedArrayObtainStyledAttributes.getFloat(f71.TextAppearance_android_shadowDy, 0.0f);
        this.g = typedArrayObtainStyledAttributes.getFloat(f71.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i, f71.MaterialTextAppearance);
        this.h = typedArrayObtainStyledAttributes2.hasValue(f71.MaterialTextAppearance_android_letterSpacing);
        this.i = typedArrayObtainStyledAttributes2.getFloat(f71.MaterialTextAppearance_android_letterSpacing, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        Typeface typeface = this.n;
        int i = this.c;
        if (typeface == null && (str = this.b) != null) {
            this.n = Typeface.create(str, i);
        }
        if (this.n == null) {
            int i2 = this.d;
            if (i2 == 1) {
                this.n = Typeface.SANS_SERIF;
            } else if (i2 == 2) {
                this.n = Typeface.SERIF;
            } else if (i2 != 3) {
                this.n = Typeface.DEFAULT;
            } else {
                this.n = Typeface.MONOSPACE;
            }
            this.n = Typeface.create(this.n, i);
        }
    }

    public final Typeface b(Context context) {
        if (this.m) {
            return this.n;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceB = rb1.b(context, this.l);
                this.n = typefaceB;
                if (typefaceB != null) {
                    this.n = Typeface.create(typefaceB, this.c);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException | Exception unused) {
            }
        }
        a();
        this.m = true;
        return this.n;
    }

    public final void c(Context context, n90 n90Var) {
        if (d(context)) {
            b(context);
        } else {
            a();
        }
        int i = this.l;
        if (i == 0) {
            this.m = true;
        }
        if (this.m) {
            n90Var.B(this.n, true);
            return;
        }
        try {
            xm1 xm1Var = new xm1(this, n90Var);
            ThreadLocal threadLocal = rb1.a;
            if (context.isRestricted()) {
                xm1Var.callbackFailAsync(-4, null);
            } else {
                rb1.c(context, i, new TypedValue(), 0, xm1Var, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.m = true;
            n90Var.A(1);
        } catch (Exception unused2) {
            this.m = true;
            n90Var.A(-3);
        }
    }

    public final boolean d(Context context) {
        Typeface typefaceC = null;
        int i = this.l;
        if (i != 0) {
            ThreadLocal threadLocal = rb1.a;
            if (!context.isRestricted()) {
                typefaceC = rb1.c(context, i, new TypedValue(), 0, null, false, true);
            }
        }
        return typefaceC != null;
    }

    public final void e(Context context, TextPaint textPaint, n90 n90Var) {
        f(context, textPaint, n90Var);
        ColorStateList colorStateList = this.j;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        ColorStateList colorStateList2 = this.a;
        textPaint.setShadowLayer(this.g, this.e, this.f, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void f(Context context, TextPaint textPaint, n90 n90Var) {
        if (d(context)) {
            g(context, textPaint, b(context));
            return;
        }
        a();
        g(context, textPaint, this.n);
        c(context, new ym1(this, context, textPaint, n90Var));
    }

    public final void g(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceK = e42.k(context.getResources().getConfiguration(), typeface);
        if (typefaceK != null) {
            typeface = typefaceK;
        }
        textPaint.setTypeface(typeface);
        int i = (~typeface.getStyle()) & this.c;
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.k);
        if (this.h) {
            textPaint.setLetterSpacing(this.i);
        }
    }
}
