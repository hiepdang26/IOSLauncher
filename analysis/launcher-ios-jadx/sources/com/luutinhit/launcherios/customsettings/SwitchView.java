package com.luutinhit.launcherios.customsettings;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import defpackage.dl1;
import defpackage.el1;
import defpackage.g71;

/* JADX INFO: loaded from: classes.dex */
public class SwitchView extends View {
    public float A;
    public float B;
    public float C;
    public float D;
    public float E;
    public float F;
    public float G;
    public float H;
    public float I;
    public float J;
    public dl1 K;
    public final AccelerateInterpolator g;
    public final Paint h;
    public final Path i;
    public final Path j;
    public final RectF k;
    public final float l;
    public final float m;
    public boolean n;
    public boolean o;
    public float p;
    public float q;
    public int r;
    public int s;
    public boolean t;
    public View.OnClickListener u;
    public float v;
    public float w;
    public float x;
    public float y;
    public float z;

    public SwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new AccelerateInterpolator(2.0f);
        this.h = new Paint();
        this.i = new Path();
        this.j = new Path();
        this.k = new RectF();
        this.l = 0.66f;
        this.m = 0.03f;
        this.o = true;
        this.t = false;
        setLayerType(1, null);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.SwitchView);
        this.l = typedArrayObtainStyledAttributes.getFloat(g71.SwitchView_ratioAspect, 0.66f);
        this.n = typedArrayObtainStyledAttributes.getBoolean(g71.SwitchView_isOpened, false);
        this.o = typedArrayObtainStyledAttributes.getBoolean(g71.SwitchView_isEnable, true);
        int i = this.n ? 4 : 1;
        this.r = i;
        this.s = i;
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void a(int i) {
        boolean z = this.n;
        if (!z && i == 4) {
            this.n = true;
        } else if (z && i == 1) {
            this.n = false;
        }
        this.s = this.r;
        this.r = i;
        postInvalidate();
    }

    public final void b(boolean z) {
        dl1 dl1Var = this.K;
        if (dl1Var != null) {
            dl1Var.e(z);
        }
        int i = z ? 4 : 1;
        int i2 = this.r;
        if (i == i2) {
            return;
        }
        if ((i == 4 && (i2 == 1 || i2 == 2)) || (i == 1 && (i2 == 4 || i2 == 3))) {
            this.p = 1.0f;
        }
        this.q = 1.0f;
        a(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x010d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onDraw(android.graphics.Canvas r17) {
        /*
            Method dump skipped, instruction units count: 407
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcherios.customsettings.SwitchView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (mode != 1073741824) {
            int paddingRight = getPaddingRight() + getPaddingLeft() + ((int) ((getResources().getDisplayMetrics().density * 56.0f) + 0.5f));
            size = mode == Integer.MIN_VALUE ? Math.min(paddingRight, size) : paddingRight;
        }
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 != 1073741824) {
            int paddingBottom = getPaddingBottom() + getPaddingTop() + ((int) (size * this.l));
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(paddingBottom, size2) : paddingBottom;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        el1 el1Var = (el1) parcelable;
        super.onRestoreInstanceState(el1Var.getSuperState());
        boolean z = el1Var.g;
        this.n = z;
        this.r = z ? 4 : 1;
        invalidate();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        el1 el1Var = new el1(super.onSaveInstanceState());
        el1Var.g = this.n;
        return el1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onSizeChanged(int r6, int r7, int r8, int r9) {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcherios.customsettings.SwitchView.onSizeChanged(int, int, int, int):void");
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.o) {
            return true;
        }
        int i = this.r;
        if ((i == 4 || i == 1) && this.p * this.q == 0.0f) {
            int action = motionEvent.getAction();
            if (action == 0) {
                return true;
            }
            if (action == 1) {
                int i2 = this.r;
                this.s = i2;
                this.q = 1.0f;
                if (i2 == 1) {
                    a(2);
                    b(true);
                } else if (i2 == 4) {
                    a(3);
                    b(false);
                }
                View.OnClickListener onClickListener = this.u;
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setEnable(boolean z) {
        this.o = z;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.u = onClickListener;
    }

    public void setOnSwitchChangeListener(dl1 dl1Var) {
        this.K = dl1Var;
    }

    public void setOpened(boolean z) {
        int i = z ? 4 : 1;
        if (i == this.r) {
            return;
        }
        a(i);
    }
}
