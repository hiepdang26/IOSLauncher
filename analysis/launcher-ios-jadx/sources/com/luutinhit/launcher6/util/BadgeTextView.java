package com.luutinhit.launcher6.util;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.PathInterpolator;
import androidx.constraintlayout.motion.widget.Key;
import defpackage.ar1;
import defpackage.g71;
import defpackage.ik0;
import defpackage.ra;
import defpackage.wc;

/* JADX INFO: loaded from: classes.dex */
public class BadgeTextView extends TextViewCustomFont {
    public final Paint h;
    public final int i;
    public final int j;
    public float k;
    public float l;
    public RectF m;

    public BadgeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        post(new wc(this, attributeSet, 18));
        setGravity(17);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.BadgeTextView);
        this.i = typedArrayObtainStyledAttributes.getColor(g71.BadgeTextView_android_background, -65536);
        this.j = typedArrayObtainStyledAttributes.getColor(g71.BadgeTextView_android_textColor, -1);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.h = paint;
        paint.setAntiAlias(true);
        this.h.setStyle(Paint.Style.FILL);
        this.h.setTextAlign(Paint.Align.CENTER);
        this.h.setTypeface(getTypeface());
    }

    public final void d(int i, boolean z) {
        if (i > 0 && i <= 99) {
            setText(String.valueOf(i));
            setVisibility(0);
        } else if (i > 99) {
            setText("99+");
            setVisibility(0);
        } else {
            setText("0");
            if (z) {
                setVisibility(8);
            } else {
                setVisibility(0);
            }
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        CharSequence text = getText();
        if (text == null) {
            return;
        }
        if (text.length() == 1) {
            this.h.setColor(this.i);
            float f = this.k / 2.0f;
            float f2 = this.l;
            canvas.drawCircle(f, f2 / 2.0f, f2 / 2.0f, this.h);
            this.h.setColor(this.j);
            this.h.setTextSize((this.l * 2.0f) / 3.0f);
            canvas.drawText(text.toString(), this.k / 2.0f, (float) (((double) this.l) * 0.73d), this.h);
            return;
        }
        this.h.setColor(this.i);
        RectF rectF = this.m;
        if (rectF == null) {
            this.m = new RectF(0.0f, 0.0f, this.k, this.l);
        } else {
            rectF.set(0.0f, 0.0f, this.k, this.l);
        }
        RectF rectF2 = this.m;
        float f3 = this.l;
        canvas.drawRoundRect(rectF2, f3, f3, this.h);
        this.h.setColor(this.j);
        this.h.setTextSize((this.l * 2.0f) / 3.0f);
        canvas.drawText(text.toString(), this.k / 2.0f, (float) (((double) this.l) * 0.73d), this.h);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.k = i;
        this.l = i2;
    }

    public void setBadgeCount(String str) {
        int i;
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            e.getMessage();
            i = -1;
        }
        if (i != -1) {
            d(i, false);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        int i2 = 0;
        int i3 = 1;
        if (getVisibility() != i) {
            if (i == 0) {
                setEnabled(true);
                ObjectAnimator objectAnimatorD = ik0.d(this, PropertyValuesHolder.ofFloat(Key.SCALE_X, 1.0f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 1.0f));
                objectAnimatorD.setDuration(300L);
                objectAnimatorD.addListener(new ra(this, i2));
                if (ar1.m) {
                    objectAnimatorD.setInterpolator(new PathInterpolator(0.02f, 0.11f, 0.13f, 1.0f));
                }
                objectAnimatorD.start();
                return;
            }
            if (i == 4 || i == 8) {
                ObjectAnimator objectAnimatorD2 = ik0.d(this, PropertyValuesHolder.ofFloat(Key.SCALE_X, 0.0f), PropertyValuesHolder.ofFloat(Key.SCALE_Y, 0.0f));
                objectAnimatorD2.setDuration(300L);
                objectAnimatorD2.addListener(new ra(this, i3));
                if (ar1.m) {
                    objectAnimatorD2.setInterpolator(new PathInterpolator(0.02f, 0.11f, 0.13f, 1.0f));
                }
                objectAnimatorD2.start();
            }
        }
    }

    public void setBadgeCount(int i) {
        d(i, true);
    }
}
