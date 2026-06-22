package com.luutinhit.launcher6;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import defpackage.h40;
import defpackage.ik0;
import defpackage.v3;
import defpackage.x41;

/* JADX INFO: loaded from: classes.dex */
public class FocusIndicatorView extends View implements View.OnFocusChangeListener {
    public static final /* synthetic */ int o = 0;
    public final int[] g;
    public final int[] h;
    public ObjectAnimator i;
    public h40 j;
    public View k;
    public boolean l;
    public final v3 m;
    public Pair n;

    public FocusIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new int[2];
        this.h = new int[2];
        setAlpha(0.0f);
        setBackgroundColor(getResources().getColor(x41.focused_background));
        this.m = new v3(this, 3);
    }

    public static void a(View view, View view2, int[] iArr) {
        iArr[1] = 0;
        iArr[0] = 0;
        b(view, view2, iArr);
        iArr[0] = (int) ((((1.0f - view.getScaleX()) * view.getWidth()) / 2.0f) + iArr[0]);
        iArr[1] = (int) ((((1.0f - view.getScaleY()) * view.getHeight()) / 2.0f) + iArr[1]);
    }

    public static void b(View view, View view2, int[] iArr) {
        View view3 = (View) view.getParent();
        iArr[0] = view.getLeft() + iArr[0];
        iArr[1] = view.getTop() + iArr[1];
        if (view3 instanceof v) {
            v vVar = (v) view3;
            iArr[0] = iArr[0] - vVar.E(vVar.indexOfChild(view));
        }
        if (view3 != view2) {
            b(view3, view2, iArr);
        }
    }

    public final void c() {
        ObjectAnimator objectAnimator = this.i;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.i = null;
        }
        h40 h40Var = this.j;
        if (h40Var != null) {
            setTranslationX(h40Var.a);
            setTranslationY(h40Var.b);
            setScaleX(h40Var.c);
            setScaleY(h40Var.d);
            this.j = null;
        }
    }

    public View.OnFocusChangeListener getHideIndicatorOnFocusListener() {
        return this.m;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Pair pair = this.n;
        if (pair != null) {
            onFocusChange((View) pair.first, ((Boolean) pair.second).booleanValue());
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        this.n = null;
        if (!this.l && getWidth() == 0) {
            this.n = Pair.create(view, Boolean.valueOf(z));
            invalidate();
            return;
        }
        boolean z2 = this.l;
        int[] iArr = this.g;
        if (!z2) {
            a(this, (View) getParent(), iArr);
            this.l = true;
        }
        Property property = View.ALPHA;
        if (z) {
            int width = getWidth();
            int height = getHeight();
            c();
            h40 h40Var = new h40();
            float f = width;
            h40Var.c = (view.getScaleX() * view.getWidth()) / f;
            float f2 = height;
            h40Var.d = (view.getScaleY() * view.getHeight()) / f2;
            a(view, (View) getParent(), this.h);
            h40Var.a = (r7[0] - iArr[0]) - (((1.0f - h40Var.c) * f) / 2.0f);
            h40Var.b = (r7[1] - iArr[1]) - (((1.0f - h40Var.d) * f2) / 2.0f);
            if (getAlpha() > 0.2f) {
                this.j = h40Var;
                this.i = ik0.d(this, PropertyValuesHolder.ofFloat((Property<?, Float>) property, 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, this.j.a), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, this.j.b), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, this.j.c), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, this.j.d));
            } else {
                setTranslationX(h40Var.a);
                setTranslationY(h40Var.b);
                setScaleX(h40Var.c);
                setScaleY(h40Var.d);
                this.i = ik0.d(this, PropertyValuesHolder.ofFloat((Property<?, Float>) property, 1.0f));
            }
            this.k = view;
        } else if (this.k == view) {
            this.k = null;
            c();
            this.i = ik0.d(this, PropertyValuesHolder.ofFloat((Property<?, Float>) property, 0.0f));
        }
        ObjectAnimator objectAnimator = this.i;
        if (objectAnimator != null) {
            objectAnimator.setDuration(150L).start();
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View view = this.k;
        if (view != null) {
            this.n = Pair.create(view, Boolean.TRUE);
            invalidate();
        }
    }
}
