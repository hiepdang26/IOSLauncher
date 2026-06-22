package com.luutinhit.launcher6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import defpackage.ar1;
import defpackage.e51;
import defpackage.ed;
import defpackage.fd;
import defpackage.h90;
import defpackage.jj1;
import defpackage.l51;
import defpackage.ng1;
import defpackage.r1;
import defpackage.v51;
import defpackage.vc;
import defpackage.xu;
import defpackage.y80;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class Hotseat extends FrameLayout implements jj1, ed {
    public final RectF g;
    public final xu h;
    public CellLayout i;
    public final t j;
    public final boolean k;
    public boolean l;
    public int m;
    public final vc n;
    public final Rect o;
    public final int p;
    public int q;
    public y80 r;
    public h90 s;

    public Hotseat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.g = new RectF();
        this.l = false;
        this.o = new Rect();
        t tVar = (t) context;
        this.j = tVar;
        xu deviceProfile = tVar.getDeviceProfile();
        this.h = deviceProfile;
        this.p = deviceProfile.a();
        boolean zA = tVar.getTinyDB().a("iphone_8_style");
        this.k = zA;
        if (tVar.isUseLiquidGlass) {
            if (tVar.getBlurWallpaperProvider() != null) {
                tVar.getBlurWallpaperProvider().b(this);
            }
        } else {
            float dimensionPixelSize = zA ? 0.0f : getResources().getDimensionPixelSize(e51.hotseat_background_corner);
            fd blurWallpaperProvider = tVar.getBlurWallpaperProvider();
            blurWallpaperProvider.getClass();
            this.n = new vc(blurWallpaperProvider, dimensionPixelSize, 1);
        }
    }

    @Override // defpackage.ed
    public final void a() {
        post(new r1(this, 18));
    }

    public Bitmap getBlurGlassWallpaper() {
        t tVar = this.j;
        fd blurWallpaperProvider = tVar.getBlurWallpaperProvider();
        Bitmap bitmap = blurWallpaperProvider.f;
        if (bitmap == null) {
            bitmap = blurWallpaperProvider.e;
        }
        if (bitmap == null) {
            return tVar.getBlurWallpaperProvider().g;
        }
        bitmap.toString();
        return bitmap;
    }

    public CellLayout getLayout() {
        this.i.getShortcutsAndWidgets().getChildCount();
        return this.i;
    }

    public ng1 getShortcutsAndWidgets() {
        return this.i.getShortcutsAndWidgets();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        xu xuVar = this.h;
        this.m = xuVar.a.l;
        this.i = (CellLayout) findViewById(v51.layout);
        t tVar = this.j;
        if (tVar.isUseLiquidGlass) {
            if (tVar.isRuntimeRenderSupport) {
                setLayerType(2, null);
                h90 h90Var = new h90(tVar, false);
                this.s = h90Var;
                h90Var.setLayerType(2, null);
                this.s.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 81));
                this.s.setSdfTexture(l51.long_round);
                addView(this.s, 0);
            } else {
                y80 y80Var = new y80(tVar, 0.45f);
                this.r = y80Var;
                y80Var.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 81));
                y80 y80Var2 = this.r;
                int i = tVar.screenWidth;
                int i2 = tVar.screenHeight;
                y80Var2.i = i;
                y80Var2.j = i2;
                y80Var2.s = false;
                this.r.setSdfTexture(l51.long_round);
                addView(this.r, 0);
            }
        }
        this.i.F(xuVar.a.k, 1);
        this.i.setIsHotseat(true);
        CellLayout cellLayout = this.i;
        int i3 = xuVar.C;
        cellLayout.setPadding(i3, 0, i3, 0);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.j.getWorkspace().h1();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Rect rect = this.o;
        super.onLayout(z, i, i2, i3, i4);
        int width = getWidth();
        int height = getHeight();
        if (!z || width <= 0 || height <= 0) {
            return;
        }
        try {
            this.q = i2;
            if (ar1.p) {
                rect.set(0, 0, width, height);
                setClipBounds(rect);
            }
            RectF rectF = this.g;
            xu xuVar = this.h;
            float f = xuVar.C;
            float f2 = xuVar.V;
            rectF.set(f - f2, 0.0f, (width - f) + f2, height);
            if (this.k) {
                rectF.setEmpty();
            } else {
                if (this.r != null) {
                    Objects.toString(rectF);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.r.getLayoutParams();
                    layoutParams.width = (int) rectF.width();
                    layoutParams.height = (int) rectF.height();
                    layoutParams.gravity = 81;
                    this.r.setLayoutParams(layoutParams);
                    this.r.e();
                    return;
                }
                if (this.s != null) {
                    Objects.toString(rectF);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.s.getLayoutParams();
                    layoutParams2.width = (int) rectF.width();
                    layoutParams2.height = (int) rectF.height();
                    layoutParams2.gravity = 81;
                    this.s.setLayoutParams(layoutParams2);
                    this.s.g();
                }
            }
            vc vcVar = this.n;
            if (vcVar != null) {
                vcVar.i = true;
                vcVar.j.set(rectF);
                vcVar.c(rectF.left);
                vcVar.d(i2);
                setBackground(vcVar);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.i.setOnLongClickListener(onLongClickListener);
    }

    public void setOverScroll(float f) {
        vc vcVar = this.n;
        if (vcVar != null) {
            int i = this.h.j;
            float f2 = i;
            int i2 = (int) (f2 - f);
            int i3 = i / 2;
            if (i2 < i3 || i2 > i) {
                if (i2 >= i3 || vcVar.u == 0) {
                    return;
                }
                if (!vcVar.t) {
                    vcVar.t = true;
                }
                vcVar.u = 0;
                vcVar.c(f);
                return;
            }
            int i4 = (int) (((i2 - (f2 / 2.0f)) * 255.0f) / i3);
            if (vcVar.u != i4) {
                if (!vcVar.t) {
                    vcVar.t = true;
                }
                vcVar.u = i4;
                vcVar.c(f);
            }
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        int i;
        super.setTranslationX(f);
        y80 y80Var = this.r;
        if (y80Var == null) {
            h90 h90Var = this.s;
            if (h90Var != null) {
                h90Var.f(f + this.g.left);
                return;
            } else {
                setOverScroll(f);
                return;
            }
        }
        if (y80Var.getVisibility() != 0 || Math.abs(f - y80Var.K) <= 1.0f || y80Var.i <= 0 || (i = y80Var.k) <= 0) {
            return;
        }
        float f2 = y80Var.H[0] + f;
        RectF rectF = y80Var.J;
        rectF.left = f2;
        rectF.right = f2 + i;
        y80Var.K = f;
        y80Var.requestRender();
    }

    public void setUseTransparency(boolean z) {
    }

    @Override // defpackage.jj1
    public final void u(View view, Bundle bundle) {
        bundle.putString("container", "hotseat");
    }

    @Override // defpackage.ed
    public final void g() {
    }
}
