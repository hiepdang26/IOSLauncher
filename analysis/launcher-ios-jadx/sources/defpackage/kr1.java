package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.constraintlayout.motion.widget.Key;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class kr1 extends br1 {
    public static final PorterDuff.Mode p = PorterDuff.Mode.SRC_IN;
    public ir1 h;
    public PorterDuffColorFilter i;
    public ColorFilter j;
    public boolean k;
    public boolean l;
    public final float[] m;
    public final Matrix n;
    public final Rect o;

    public kr1() {
        this.l = true;
        this.m = new float[9];
        this.n = new Matrix();
        this.o = new Rect();
        ir1 ir1Var = new ir1();
        ir1Var.c = null;
        ir1Var.d = p;
        ir1Var.b = new hr1();
        this.h = ir1Var;
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.g;
        if (drawable == null) {
            return false;
        }
        drawable.canApplyTheme();
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.o;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.j;
        if (colorFilter == null) {
            colorFilter = this.i;
        }
        Matrix matrix = this.n;
        canvas.getMatrix(matrix);
        float[] fArr = this.m;
        matrix.getValues(fArr);
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[4]);
        float fAbs3 = Math.abs(fArr[1]);
        float fAbs4 = Math.abs(fArr[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (rect.width() * fAbs);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, (int) (rect.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && az1.r(this) == 1) {
            canvas.translate(rect.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        ir1 ir1Var = this.h;
        Bitmap bitmap = ir1Var.f;
        if (bitmap == null || iMin != bitmap.getWidth() || iMin2 != ir1Var.f.getHeight()) {
            ir1Var.f = Bitmap.createBitmap(iMin, iMin2, Bitmap.Config.ARGB_8888);
            ir1Var.k = true;
        }
        if (this.l) {
            ir1 ir1Var2 = this.h;
            if (ir1Var2.k || ir1Var2.g != ir1Var2.c || ir1Var2.h != ir1Var2.d || ir1Var2.j != ir1Var2.e || ir1Var2.i != ir1Var2.b.getRootAlpha()) {
                ir1 ir1Var3 = this.h;
                ir1Var3.f.eraseColor(0);
                Canvas canvas2 = new Canvas(ir1Var3.f);
                hr1 hr1Var = ir1Var3.b;
                hr1Var.a(hr1Var.g, hr1.p, canvas2, iMin, iMin2);
                ir1 ir1Var4 = this.h;
                ir1Var4.g = ir1Var4.c;
                ir1Var4.h = ir1Var4.d;
                ir1Var4.i = ir1Var4.b.getRootAlpha();
                ir1Var4.j = ir1Var4.e;
                ir1Var4.k = false;
            }
        } else {
            ir1 ir1Var5 = this.h;
            ir1Var5.f.eraseColor(0);
            Canvas canvas3 = new Canvas(ir1Var5.f);
            hr1 hr1Var2 = ir1Var5.b;
            hr1Var2.a(hr1Var2.g, hr1.p, canvas3, iMin, iMin2);
        }
        ir1 ir1Var6 = this.h;
        if (ir1Var6.b.getRootAlpha() >= 255 && colorFilter == null) {
            paint = null;
        } else {
            if (ir1Var6.l == null) {
                Paint paint2 = new Paint();
                ir1Var6.l = paint2;
                paint2.setFilterBitmap(true);
            }
            ir1Var6.l.setAlpha(ir1Var6.b.getRootAlpha());
            ir1Var6.l.setColorFilter(colorFilter);
            paint = ir1Var6.l;
        }
        canvas.drawBitmap(ir1Var6.f, (Rect) null, rect, paint);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.g;
        return drawable != null ? drawable.getAlpha() : this.h.b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.g;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.h.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.g;
        return drawable != null ? drawable.getColorFilter() : this.j;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.g != null && Build.VERSION.SDK_INT >= 24) {
            return new jr1(this.g.getConstantState());
        }
        this.h.a = getChangingConfigurations();
        return this.h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.g;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.h.b.i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.g;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.h.b.h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.g;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.g;
        return drawable != null ? drawable.isAutoMirrored() : this.h.e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.g;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        ir1 ir1Var = this.h;
        if (ir1Var == null) {
            return false;
        }
        hr1 hr1Var = ir1Var.b;
        if (hr1Var.n == null) {
            hr1Var.n = Boolean.valueOf(hr1Var.g.a());
        }
        if (hr1Var.n.booleanValue()) {
            return true;
        }
        ColorStateList colorStateList = this.h.c;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.k && super.mutate() == this) {
            ir1 ir1Var = this.h;
            ir1 ir1Var2 = new ir1();
            ir1Var2.c = null;
            ir1Var2.d = p;
            if (ir1Var != null) {
                ir1Var2.a = ir1Var.a;
                hr1 hr1Var = new hr1(ir1Var.b);
                ir1Var2.b = hr1Var;
                if (ir1Var.b.e != null) {
                    hr1Var.e = new Paint(ir1Var.b.e);
                }
                if (ir1Var.b.d != null) {
                    ir1Var2.b.d = new Paint(ir1Var.b.d);
                }
                ir1Var2.c = ir1Var.c;
                ir1Var2.d = ir1Var.d;
                ir1Var2.e = ir1Var.e;
            }
            this.h = ir1Var2;
            this.k = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z;
        PorterDuff.Mode mode;
        Drawable drawable = this.g;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        ir1 ir1Var = this.h;
        ColorStateList colorStateList = ir1Var.c;
        if (colorStateList == null || (mode = ir1Var.d) == null) {
            z = false;
        } else {
            this.i = a(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        hr1 hr1Var = ir1Var.b;
        if (hr1Var.n == null) {
            hr1Var.n = Boolean.valueOf(hr1Var.g.a());
        }
        if (hr1Var.n.booleanValue()) {
            boolean zB = ir1Var.b.g.b(iArr);
            ir1Var.k |= zB;
            if (zB) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.h.b.getRootAlpha() != i) {
            this.h.b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.h.e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.j = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.g;
        if (drawable != null) {
            az1.I(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
            return;
        }
        ir1 ir1Var = this.h;
        if (ir1Var.c != colorStateList) {
            ir1Var.c = colorStateList;
            this.i = a(colorStateList, ir1Var.d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setTintMode(mode);
            return;
        }
        ir1 ir1Var = this.h;
        if (ir1Var.d != mode) {
            ir1Var.d = mode;
            this.i = a(ir1Var.c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.g;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        hr1 hr1Var;
        int i;
        Paint.Cap cap;
        Paint.Join join;
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        ir1 ir1Var = this.h;
        ir1Var.b = new hr1();
        TypedArray typedArrayC = np1.C(resources, theme, attributeSet, wd.g);
        ir1 ir1Var2 = this.h;
        hr1 hr1Var2 = ir1Var2.b;
        int i2 = !np1.x(xmlPullParser, "tintMode") ? -1 : typedArrayC.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (i2 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i2 != 5) {
            if (i2 != 9) {
                switch (i2) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        ir1Var2.d = mode;
        ColorStateList colorStateListA = null;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "tint") != null) {
            TypedValue typedValue = new TypedValue();
            typedArrayC.getValue(1, typedValue);
            int i3 = typedValue.type;
            if (i3 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
            if (i3 >= 28 && i3 <= 31) {
                colorStateListA = ColorStateList.valueOf(typedValue.data);
            } else {
                Resources resources2 = typedArrayC.getResources();
                int resourceId = typedArrayC.getResourceId(1, 0);
                ThreadLocal threadLocal = hk.a;
                try {
                    colorStateListA = hk.a(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception unused) {
                }
            }
        }
        ColorStateList colorStateList = colorStateListA;
        if (colorStateList != null) {
            ir1Var2.c = colorStateList;
        }
        boolean z = ir1Var2.e;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "autoMirrored") != null) {
            z = typedArrayC.getBoolean(5, z);
        }
        ir1Var2.e = z;
        float f = hr1Var2.j;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportWidth") != null) {
            f = typedArrayC.getFloat(7, f);
        }
        hr1Var2.j = f;
        float f2 = hr1Var2.k;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportHeight") != null) {
            f2 = typedArrayC.getFloat(8, f2);
        }
        hr1Var2.k = f2;
        if (hr1Var2.j <= 0.0f) {
            throw new XmlPullParserException(typedArrayC.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f2 > 0.0f) {
            hr1Var2.h = typedArrayC.getDimension(3, hr1Var2.h);
            float dimension = typedArrayC.getDimension(2, hr1Var2.i);
            hr1Var2.i = dimension;
            if (hr1Var2.h <= 0.0f) {
                throw new XmlPullParserException(typedArrayC.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (dimension > 0.0f) {
                float alpha = hr1Var2.getAlpha();
                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", Key.ALPHA) != null) {
                    alpha = typedArrayC.getFloat(4, alpha);
                }
                hr1Var2.setAlpha(alpha);
                String string = typedArrayC.getString(0);
                if (string != null) {
                    hr1Var2.m = string;
                    hr1Var2.o.put(string, hr1Var2);
                }
                typedArrayC.recycle();
                ir1Var.a = getChangingConfigurations();
                ir1Var.k = true;
                ir1 ir1Var3 = this.h;
                hr1 hr1Var3 = ir1Var3.b;
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.push(hr1Var3.g);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z2 = true;
                for (int i4 = 1; eventType != i4 && (xmlPullParser.getDepth() >= depth || eventType != 3); i4 = 1) {
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        er1 er1Var = (er1) arrayDeque.peek();
                        if (er1Var != null) {
                            boolean zEquals = "path".equals(name);
                            e9 e9Var = hr1Var3.o;
                            ArrayList arrayList = er1Var.b;
                            hr1Var = hr1Var3;
                            if (zEquals) {
                                dr1 dr1Var = new dr1();
                                dr1Var.e = 0.0f;
                                dr1Var.g = 1.0f;
                                dr1Var.h = 1.0f;
                                i = depth;
                                dr1Var.i = 0.0f;
                                dr1Var.j = 1.0f;
                                dr1Var.k = 0.0f;
                                Paint.Cap cap2 = Paint.Cap.BUTT;
                                dr1Var.l = cap2;
                                Paint.Join join2 = Paint.Join.MITER;
                                dr1Var.m = join2;
                                dr1Var.n = 4.0f;
                                TypedArray typedArrayC2 = np1.C(resources, theme, attributeSet, wd.i);
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                                    String string2 = typedArrayC2.getString(0);
                                    if (string2 != null) {
                                        dr1Var.b = string2;
                                    }
                                    String string3 = typedArrayC2.getString(2);
                                    if (string3 != null) {
                                        dr1Var.a = p02.h(string3);
                                    }
                                    dr1Var.f = np1.o(typedArrayC2, xmlPullParser, theme, "fillColor", 1);
                                    float f3 = dr1Var.h;
                                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillAlpha") != null) {
                                        f3 = typedArrayC2.getFloat(12, f3);
                                    }
                                    dr1Var.h = f3;
                                    int i5 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineCap") != null ? typedArrayC2.getInt(8, -1) : -1;
                                    Paint.Cap cap3 = dr1Var.l;
                                    if (i5 == 0) {
                                        cap = cap2;
                                    } else if (i5 != 1) {
                                        cap = i5 != 2 ? cap3 : Paint.Cap.SQUARE;
                                    } else {
                                        cap = Paint.Cap.ROUND;
                                    }
                                    dr1Var.l = cap;
                                    int i6 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineJoin") != null ? typedArrayC2.getInt(9, -1) : -1;
                                    Paint.Join join3 = dr1Var.m;
                                    if (i6 == 0) {
                                        join = join2;
                                    } else if (i6 != 1) {
                                        join = i6 != 2 ? join3 : Paint.Join.BEVEL;
                                    } else {
                                        join = Paint.Join.ROUND;
                                    }
                                    dr1Var.m = join;
                                    float f4 = dr1Var.n;
                                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeMiterLimit") != null) {
                                        f4 = typedArrayC2.getFloat(10, f4);
                                    }
                                    dr1Var.n = f4;
                                    dr1Var.d = np1.o(typedArrayC2, xmlPullParser, theme, "strokeColor", 3);
                                    float f5 = dr1Var.g;
                                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeAlpha") != null) {
                                        f5 = typedArrayC2.getFloat(11, f5);
                                    }
                                    dr1Var.g = f5;
                                    float f6 = dr1Var.e;
                                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeWidth") != null) {
                                        f6 = typedArrayC2.getFloat(4, f6);
                                    }
                                    dr1Var.e = f6;
                                    float f7 = dr1Var.j;
                                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathEnd") != null) {
                                        f7 = typedArrayC2.getFloat(6, f7);
                                    }
                                    dr1Var.j = f7;
                                    float f8 = dr1Var.k;
                                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathOffset") != null) {
                                        f8 = typedArrayC2.getFloat(7, f8);
                                    }
                                    dr1Var.k = f8;
                                    float f9 = dr1Var.i;
                                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathStart") != null) {
                                        f9 = typedArrayC2.getFloat(5, f9);
                                    }
                                    dr1Var.i = f9;
                                    int i7 = dr1Var.c;
                                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillType") != null) {
                                        i7 = typedArrayC2.getInt(13, i7);
                                    }
                                    dr1Var.c = i7;
                                }
                                typedArrayC2.recycle();
                                arrayList.add(dr1Var);
                                if (dr1Var.getPathName() != null) {
                                    e9Var.put(dr1Var.getPathName(), dr1Var);
                                }
                                ir1Var3.a = ir1Var3.a;
                                z2 = false;
                            } else {
                                i = depth;
                                if ("clip-path".equals(name)) {
                                    cr1 cr1Var = new cr1();
                                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                                        TypedArray typedArrayC3 = np1.C(resources, theme, attributeSet, wd.j);
                                        String string4 = typedArrayC3.getString(0);
                                        if (string4 != null) {
                                            cr1Var.b = string4;
                                        }
                                        String string5 = typedArrayC3.getString(1);
                                        if (string5 != null) {
                                            cr1Var.a = p02.h(string5);
                                        }
                                        cr1Var.c = !np1.x(xmlPullParser, "fillType") ? 0 : typedArrayC3.getInt(2, 0);
                                        typedArrayC3.recycle();
                                    }
                                    arrayList.add(cr1Var);
                                    if (cr1Var.getPathName() != null) {
                                        e9Var.put(cr1Var.getPathName(), cr1Var);
                                    }
                                    ir1Var3.a = ir1Var3.a;
                                } else if ("group".equals(name)) {
                                    er1 er1Var2 = new er1();
                                    TypedArray typedArrayC4 = np1.C(resources, theme, attributeSet, wd.h);
                                    float f10 = er1Var2.c;
                                    if (np1.x(xmlPullParser, Key.ROTATION)) {
                                        f10 = typedArrayC4.getFloat(5, f10);
                                    }
                                    er1Var2.c = f10;
                                    er1Var2.d = typedArrayC4.getFloat(1, er1Var2.d);
                                    er1Var2.e = typedArrayC4.getFloat(2, er1Var2.e);
                                    float f11 = er1Var2.f;
                                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", Key.SCALE_X) != null) {
                                        f11 = typedArrayC4.getFloat(3, f11);
                                    }
                                    er1Var2.f = f11;
                                    float f12 = er1Var2.g;
                                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", Key.SCALE_Y) != null) {
                                        f12 = typedArrayC4.getFloat(4, f12);
                                    }
                                    er1Var2.g = f12;
                                    float f13 = er1Var2.h;
                                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateX") != null) {
                                        f13 = typedArrayC4.getFloat(6, f13);
                                    }
                                    er1Var2.h = f13;
                                    float f14 = er1Var2.i;
                                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateY") != null) {
                                        f14 = typedArrayC4.getFloat(7, f14);
                                    }
                                    er1Var2.i = f14;
                                    String string6 = typedArrayC4.getString(0);
                                    if (string6 != null) {
                                        er1Var2.k = string6;
                                    }
                                    er1Var2.c();
                                    typedArrayC4.recycle();
                                    arrayList.add(er1Var2);
                                    arrayDeque.push(er1Var2);
                                    if (er1Var2.getGroupName() != null) {
                                        e9Var.put(er1Var2.getGroupName(), er1Var2);
                                    }
                                    ir1Var3.a = ir1Var3.a;
                                }
                            }
                        } else {
                            hr1Var = hr1Var3;
                            i = depth;
                        }
                    } else {
                        hr1Var = hr1Var3;
                        i = depth;
                        if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                            arrayDeque.pop();
                        }
                    }
                    eventType = xmlPullParser.next();
                    hr1Var3 = hr1Var;
                    depth = i;
                }
                if (!z2) {
                    this.i = a(ir1Var.c, ir1Var.d);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            }
            throw new XmlPullParserException(typedArrayC.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(typedArrayC.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    public kr1(ir1 ir1Var) {
        this.l = true;
        this.m = new float[9];
        this.n = new Matrix();
        this.o = new Rect();
        this.h = ir1Var;
        this.i = a(ir1Var.c, ir1Var.d);
    }
}
