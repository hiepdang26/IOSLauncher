package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class bx extends Drawable implements Drawable.Callback {
    public static final /* synthetic */ int s = 0;
    public d5 g;
    public Rect h;
    public Drawable i;
    public Drawable j;
    public int k;
    public boolean l;
    public int m;
    public boolean n;
    public o1 o;
    public long p;
    public long q;
    public h5 r;

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.l = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.i
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L38
            long r9 = r13.p
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.k
            r3.setAlpha(r9)
            r13.p = r6
            goto L3a
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            d5 r9 = r13.g
            int r9 = r9.y
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.k
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L3b
        L38:
            r13.p = r6
        L3a:
            r3 = 0
        L3b:
            android.graphics.drawable.Drawable r9 = r13.j
            if (r9 == 0) goto L65
            long r10 = r13.q
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L67
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L52
            r9.setVisible(r8, r8)
            r0 = 0
            r13.j = r0
            r13.q = r6
            goto L67
        L52:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            d5 r4 = r13.g
            int r4 = r4.z
            int r3 = r3 / r4
            int r4 = r13.k
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L68
        L65:
            r13.q = r6
        L67:
            r0 = r3
        L68:
            if (r14 == 0) goto L74
            if (r0 == 0) goto L74
            o1 r14 = r13.o
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bx.a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        d5 d5Var = this.g;
        if (theme == null) {
            d5Var.getClass();
            return;
        }
        d5Var.c();
        int i = d5Var.h;
        Drawable[] drawableArr = d5Var.g;
        for (int i2 = 0; i2 < i; i2++) {
            Drawable drawable = drawableArr[i2];
            if (drawable != null && drawable.canApplyTheme()) {
                drawableArr[i2].applyTheme(theme);
                d5Var.e |= drawableArr[i2].getChangingConfigurations();
            }
        }
        Resources resources = theme.getResources();
        if (resources != null) {
            d5Var.b = resources;
            int i3 = resources.getDisplayMetrics().densityDpi;
            if (i3 == 0) {
                i3 = 160;
            }
            int i4 = d5Var.c;
            d5Var.c = i3;
            if (i4 != i3) {
                d5Var.m = false;
                d5Var.j = false;
            }
        }
    }

    public final void b(Drawable drawable) {
        if (this.r == null) {
            this.r = new h5();
        }
        h5 h5Var = this.r;
        h5Var.h = drawable.getCallback();
        drawable.setCallback(h5Var);
        try {
            if (this.g.y <= 0 && this.l) {
                drawable.setAlpha(this.k);
            }
            d5 d5Var = this.g;
            if (d5Var.C) {
                drawable.setColorFilter(d5Var.B);
            } else {
                if (d5Var.F) {
                    drawable.setTintList(d5Var.D);
                }
                d5 d5Var2 = this.g;
                if (d5Var2.G) {
                    drawable.setTintMode(d5Var2.E);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.g.w);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                az1.G(drawable, az1.r(this));
            }
            drawable.setAutoMirrored(this.g.A);
            Rect rect = this.h;
            if (rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
            h5 h5Var2 = this.r;
            Drawable.Callback callback = (Drawable.Callback) h5Var2.h;
            h5Var2.h = null;
            drawable.setCallback(callback);
        } catch (Throwable th) {
            h5 h5Var3 = this.r;
            Drawable.Callback callback2 = (Drawable.Callback) h5Var3.h;
            h5Var3.h = null;
            drawable.setCallback(callback2);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(int r10) {
        /*
            r9 = this;
            int r0 = r9.m
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            d5 r0 = r9.g
            int r0 = r0.z
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.j
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.i
            if (r0 == 0) goto L29
            r9.j = r0
            d5 r0 = r9.g
            int r0 = r0.z
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.q = r0
            goto L35
        L29:
            r9.j = r4
            r9.q = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.i
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            d5 r0 = r9.g
            int r1 = r0.h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.d(r10)
            r9.i = r0
            r9.m = r10
            if (r0 == 0) goto L5a
            d5 r10 = r9.g
            int r10 = r10.y
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.p = r2
        L51:
            r9.b(r0)
            goto L5a
        L55:
            r9.i = r4
            r10 = -1
            r9.m = r10
        L5a:
            long r0 = r9.p
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L67
            long r0 = r9.q
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L7e
        L67:
            o1 r0 = r9.o
            if (r0 != 0) goto L78
            o1 r0 = new o1
            r1 = r9
            g5 r1 = (defpackage.g5) r1
            r2 = 17
            r0.<init>(r1, r2)
            r9.o = r0
            goto L7b
        L78:
            r9.unscheduleSelf(r0)
        L7b:
            r9.a(r10)
        L7e:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bx.c(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        return this.g.canApplyTheme();
    }

    public abstract void d(d5 d5Var);

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.i;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.j;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.k;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.g.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        boolean z;
        d5 d5Var = this.g;
        if (!d5Var.u) {
            d5Var.c();
            d5Var.u = true;
            int i = d5Var.h;
            Drawable[] drawableArr = d5Var.g;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    d5Var.v = true;
                    z = true;
                    break;
                }
                if (drawableArr[i2].getConstantState() == null) {
                    d5Var.v = false;
                    z = false;
                    break;
                }
                i2++;
            }
        } else {
            z = d5Var.v;
        }
        if (!z) {
            return null;
        }
        this.g.d = getChangingConfigurations();
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getHotspotBounds(Rect rect) {
        Rect rect2 = this.h;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        d5 d5Var = this.g;
        if (d5Var.l) {
            if (!d5Var.m) {
                d5Var.b();
            }
            return d5Var.o;
        }
        Drawable drawable = this.i;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        d5 d5Var = this.g;
        if (d5Var.l) {
            if (!d5Var.m) {
                d5Var.b();
            }
            return d5Var.n;
        }
        Drawable drawable = this.i;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        d5 d5Var = this.g;
        if (d5Var.l) {
            if (!d5Var.m) {
                d5Var.b();
            }
            return d5Var.q;
        }
        Drawable drawable = this.i;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        d5 d5Var = this.g;
        if (d5Var.l) {
            if (!d5Var.m) {
                d5Var.b();
            }
            return d5Var.p;
        }
        Drawable drawable = this.i;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.i;
        if (drawable != null && drawable.isVisible()) {
            d5 d5Var = this.g;
            if (d5Var.r) {
                return d5Var.s;
            }
            d5Var.c();
            int i = d5Var.h;
            Drawable[] drawableArr = d5Var.g;
            opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            d5Var.s = opacity;
            d5Var.r = true;
        }
        return opacity;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Drawable drawable = this.i;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        d5 d5Var = this.g;
        boolean padding = false;
        Rect rect2 = null;
        if (!d5Var.i) {
            Rect rect3 = d5Var.k;
            if (rect3 != null || d5Var.j) {
                rect2 = rect3;
            } else {
                d5Var.c();
                Rect rect4 = new Rect();
                int i = d5Var.h;
                Drawable[] drawableArr = d5Var.g;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2].getPadding(rect4)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i3 = rect4.left;
                        if (i3 > rect2.left) {
                            rect2.left = i3;
                        }
                        int i4 = rect4.top;
                        if (i4 > rect2.top) {
                            rect2.top = i4;
                        }
                        int i5 = rect4.right;
                        if (i5 > rect2.right) {
                            rect2.right = i5;
                        }
                        int i6 = rect4.bottom;
                        if (i6 > rect2.bottom) {
                            rect2.bottom = i6;
                        }
                    }
                }
                d5Var.j = true;
                d5Var.k = rect2;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            if ((rect2.left | rect2.top | rect2.bottom | rect2.right) != 0) {
                padding = true;
            }
        } else {
            Drawable drawable = this.i;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (this.g.A && az1.r(this) == 1) {
            int i7 = rect.left;
            rect.left = rect.right;
            rect.right = i7;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        d5 d5Var = this.g;
        if (d5Var != null) {
            d5Var.r = false;
            d5Var.t = false;
        }
        if (drawable != this.i || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return this.g.A;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.j;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.j = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.i;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.l) {
                this.i.setAlpha(this.k);
            }
        }
        if (this.q != 0) {
            this.q = 0L;
            z = true;
        }
        if (this.p != 0) {
            this.p = 0L;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.n && super.mutate() == this) {
            g5 g5Var = (g5) this;
            d5 d5Var = new d5(g5Var.v, g5Var, null);
            d5Var.I = d5Var.I.clone();
            d5Var.J = d5Var.J.clone();
            d(d5Var);
            this.n = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.i;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        d5 d5Var = this.g;
        int i2 = this.m;
        int i3 = d5Var.h;
        Drawable[] drawableArr = d5Var.g;
        boolean z = false;
        for (int i4 = 0; i4 < i3; i4++) {
            Drawable drawable = drawableArr[i4];
            if (drawable != null) {
                boolean zG = Build.VERSION.SDK_INT >= 23 ? az1.G(drawable, i) : false;
                if (i4 == i2) {
                    z = zG;
                }
            }
        }
        d5Var.x = i;
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        Drawable drawable = this.j;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.i;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.i || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.l && this.k == i) {
            return;
        }
        this.l = true;
        this.k = i;
        Drawable drawable = this.i;
        if (drawable != null) {
            if (this.p == 0) {
                drawable.setAlpha(i);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        d5 d5Var = this.g;
        if (d5Var.A != z) {
            d5Var.A = z;
            Drawable drawable = this.i;
            if (drawable != null) {
                drawable.setAutoMirrored(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        d5 d5Var = this.g;
        d5Var.C = true;
        if (d5Var.B != colorFilter) {
            d5Var.B = colorFilter;
            Drawable drawable = this.i;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z) {
        d5 d5Var = this.g;
        if (d5Var.w != z) {
            d5Var.w = z;
            Drawable drawable = this.i;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f, float f2) {
        Drawable drawable = this.i;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.h;
        if (rect == null) {
            this.h = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.i;
        if (drawable != null) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        d5 d5Var = this.g;
        d5Var.F = true;
        if (d5Var.D != colorStateList) {
            d5Var.D = colorStateList;
            this.i.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        d5 d5Var = this.g;
        d5Var.G = true;
        if (d5Var.E != mode) {
            d5Var.E = mode;
            this.i.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.j;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.i;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.i || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
