package com.luutinhit.launcher6.appslibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import defpackage.ef0;
import defpackage.k8;
import defpackage.l8;
import defpackage.mc1;

/* JADX INFO: loaded from: classes.dex */
public class IndexBarView extends View {
    public static final String[] s = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
    public String[] g;
    public final Paint h;
    public final Paint.FontMetrics i;
    public final float j;
    public final float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public final float p;
    public int q;
    public ef0 r;

    public IndexBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = s;
        this.q = -1;
        Paint paint = new Paint(1);
        this.h = paint;
        paint.setColor(-1);
        this.h.setTextSize(TypedValue.applyDimension(2, 11.0f, context.getResources().getDisplayMetrics()));
        this.h.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics = this.h.getFontMetrics();
        this.i = fontMetrics;
        this.j = fontMetrics.descent - fontMetrics.ascent;
        this.k = TypedValue.applyDimension(1, 1.0f, context.getResources().getDisplayMetrics());
        this.p = this.h.measureText("W");
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String[] strArr = this.g;
        if (strArr == null || strArr.length == 0) {
            return;
        }
        for (int i = 0; i < this.g.length; i++) {
            float f = ((i * this.m) + this.l) - this.i.ascent;
            if (i == this.q) {
                this.h.setColor(-8947849);
                this.h.setFakeBoldText(true);
            } else {
                this.h.setColor(-1);
                this.h.setFakeBoldText(false);
            }
            canvas.drawText(this.g[i], this.o, f, this.h);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        String[] strArr = this.g;
        setMeasuredDimension(View.resolveSize((int) (this.p * 2.0f), i), View.resolveSize((int) Math.ceil(((strArr.length - 1) * this.k) + (strArr.length * this.j)), i2));
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float length = this.g.length;
        float f = this.j;
        float f2 = this.k;
        float f3 = i2;
        this.l = (f3 - (((r5.length - 1) * f2) + (length * f))) / 2.0f;
        this.o = i / 2.0f;
        float f4 = f + f2;
        this.m = f4;
        this.n = 1.0f / f4;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        String[] strArr = this.g;
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        int y = (int) ((motionEvent.getY() - this.l) * this.n);
        int length = y >= 0 ? y : 0;
        String[] strArr2 = this.g;
        if (length >= strArr2.length) {
            length = strArr2.length - 1;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return super.onTouchEvent(motionEvent);
                    }
                }
            }
            this.q = -1;
            invalidate();
            return true;
        }
        if (length != this.q) {
            this.q = length;
            ef0 ef0Var = this.r;
            if (ef0Var != null) {
                String str = this.g[length];
                k8 k8Var = (k8) ef0Var;
                mc1 mc1Var = (mc1) k8Var.h;
                mc1Var.getClass();
                ((l8) mc1Var.h).i.o0(((int[]) k8Var.i)[length]);
            }
            invalidate();
        }
        return true;
    }

    public void setLetters(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.g = strArr;
        requestLayout();
        invalidate();
    }

    public void setOnLetterChangeListener(ef0 ef0Var) {
        this.r = ef0Var;
    }
}
