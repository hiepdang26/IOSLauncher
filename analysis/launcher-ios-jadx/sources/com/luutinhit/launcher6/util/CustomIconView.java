package com.luutinhit.launcher6.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.luutinhit.launcher6.FastBitmapDrawable;
import defpackage.ar;
import defpackage.ar1;
import defpackage.br;
import defpackage.e51;
import defpackage.g71;
import defpackage.r1;
import defpackage.vc;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class CustomIconView extends AppCompatImageView {
    public final Context g;
    public boolean h;
    public boolean i;
    public final float j;
    public vc k;
    public final Rect l;
    public final int[] m;
    public int n;
    public int o;
    public final Path p;
    public final RectF q;
    public int r;
    public int s;
    public boolean t;
    public final r1 u;

    public CustomIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.h = false;
        this.i = false;
        this.l = new Rect();
        this.m = new int[2];
        this.n = -1;
        this.o = -1;
        this.p = new Path();
        this.q = new RectF();
        this.r = -1;
        this.s = -1;
        this.t = false;
        this.u = new r1(this, 10);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.CustomIconView);
            this.h = typedArrayObtainStyledAttributes.getBoolean(g71.CustomIconView_isClockView, false);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.g = context;
        this.j = getResources().getDimensionPixelSize(e51.icon_round_corner);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        if (!ar1.p && this.k != null) {
            canvas.clipPath(this.p);
        }
        super.draw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.i = true;
        vc vcVar = this.k;
        if (vcVar != null) {
            vcVar.l.b(vcVar);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.t = false;
        this.i = false;
        vc vcVar = this.k;
        if (vcVar != null) {
            vcVar.l.c.remove(vcVar);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.t) {
            hashCode();
            Objects.toString(getParent());
            r1 r1Var = this.u;
            removeCallbacks(r1Var);
            postDelayed(r1Var, 1000L);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Rect rect = this.l;
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            try {
                if (this.k != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (ar1.p) {
                        rect.set(0, 0, width, height);
                        setClipBounds(rect);
                    }
                    int[] iArr = this.m;
                    if (iArr != null && iArr.length != 0) {
                        getLocationOnScreen(iArr);
                        int i5 = iArr[0];
                        if (i5 >= 0 && iArr[1] >= 0) {
                            if (this.n != i5) {
                                this.n = i5;
                                this.k.c(i5 % this.r);
                            }
                            int i6 = this.o;
                            int i7 = iArr[1];
                            if (i6 != i7) {
                                this.o = i7;
                                this.k.d(i7 % this.s);
                            }
                        }
                    }
                    RectF rectF = this.q;
                    rectF.set(0.0f, 0.0f, width, height);
                    Path path = this.p;
                    float f = this.j;
                    path.addRoundRect(rectF, f, f, Path.Direction.CW);
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    public void setClockView(boolean z) {
        this.h = z;
        this.t = z;
    }

    public void setTint(int i) {
        Objects.toString(getBackground());
        if (getBackground() != null) {
            if (getBackground() instanceof FastBitmapDrawable) {
                ((FastBitmapDrawable) getBackground()).g(i);
                return;
            }
            if (getBackground() instanceof br) {
                br brVar = (br) getBackground();
                brVar.getClass();
                if (i == -1) {
                    i = -1;
                } else if (i == 0) {
                    i = -7829368;
                }
                brVar.p.setColor(i);
                return;
            }
            if (getBackground() instanceof ar) {
                ar arVar = (ar) getBackground();
                arVar.getClass();
                arVar.j.setColor(i == -1 ? -1 : i == 0 ? -16777216 : i);
                arVar.l.setColor(i != 0 ? -16777216 : -1);
                arVar.invalidateSelf();
            }
        }
    }
}
