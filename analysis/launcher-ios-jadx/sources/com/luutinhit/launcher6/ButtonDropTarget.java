package com.luutinhit.launcher6;

import android.animation.AnimatorSet;
import android.animation.FloatArrayEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import defpackage.ar1;
import defpackage.ax;
import defpackage.e51;
import defpackage.jk0;
import defpackage.lw;
import defpackage.m61;
import defpackage.nx;
import defpackage.ox;
import defpackage.q7;
import defpackage.v51;
import defpackage.w1;
import defpackage.xw;
import defpackage.zw;

/* JADX INFO: loaded from: classes.dex */
public abstract class ButtonDropTarget extends ConstraintLayout implements ox, lw, View.OnClickListener {
    public t g;
    public final int h;
    public SearchDropTargetBar i;
    public final ImageView j;
    public final TextViewCustomFont k;
    public boolean l;
    public int m;
    public ColorStateList n;
    public Drawable o;
    public AnimatorSet p;
    public ColorMatrix q;
    public ColorMatrix r;
    public ColorMatrix s;

    public ButtonDropTarget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.m = 0;
        this.h = getResources().getDimensionPixelSize(e51.drop_target_drag_padding);
        LayoutInflater.from(context).inflate(m61.icon_view_layout, (ViewGroup) this, true);
        this.j = (ImageView) findViewById(v51.icon_app);
        this.k = (TextViewCustomFont) findViewById(v51.icon_name);
    }

    @Override // defpackage.ox
    public final boolean b() {
        return this.l;
    }

    @Override // defpackage.ox
    public final void c(Rect rect) {
        super.getHitRect(rect);
        rect.bottom += this.h;
        int[] iArr = new int[2];
        this.g.getDragLayer().getDescendantCoordRelativeToSelf(this, iArr);
        rect.offsetTo(iArr[0], iArr[1]);
    }

    @Override // defpackage.ox
    public final void f() {
    }

    public int getTextColor() {
        return getTextColors().getDefaultColor();
    }

    public ColorStateList getTextColors() {
        TextViewCustomFont textViewCustomFont = this.k;
        if (textViewCustomFont != null) {
            return textViewCustomFont.getTextColors();
        }
        return null;
    }

    @Override // defpackage.ox
    public final void j(nx nxVar) {
        nxVar.f.setColor(this.m);
        if (ar1.m) {
            l(this.m);
        } else {
            if (this.s == null) {
                this.s = new ColorMatrix();
            }
            zw.b(this.m, this.s);
            this.o.setColorFilter(new ColorMatrixColorFilter(this.s));
            setTextColor(this.m);
        }
        ax axVar = nxVar.m;
        if (axVar != null) {
            axVar.h.removeCallbacks(axVar);
        }
        sendAccessibilityEvent(4);
    }

    public final void l(int i) {
        AnimatorSet animatorSet = this.p;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.p = animatorSet2;
        animatorSet2.setDuration(120);
        if (this.q == null) {
            this.q = new ColorMatrix();
            this.r = new ColorMatrix();
            this.s = new ColorMatrix();
        }
        zw.b(getTextColor(), this.q);
        zw.b(i, this.r);
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new FloatArrayEvaluator(this.s.getArray()), this.q.getArray(), this.r.getArray());
        valueAnimatorOfObject.addUpdateListener(new q7(this, 4));
        this.p.play(valueAnimatorOfObject);
        this.p.play(ObjectAnimator.ofArgb(this, "textColor", i));
        this.p.start();
    }

    public abstract void n(nx nxVar);

    public abstract boolean o(xw xwVar, Object obj);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        jk0.a().f.c(this, null, null);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.n = getTextColors();
        ((t) getContext()).getDeviceProfile().getClass();
    }

    @Override // defpackage.ox
    public final boolean p(nx nxVar) {
        return o(nxVar.h, nxVar.g);
    }

    @Override // defpackage.ox
    public final void r(nx nxVar) {
        if (nxVar.e) {
            nxVar.f.setColor(this.m);
            return;
        }
        nxVar.f.setColor(0);
        if (ar1.m) {
            l(this.n.getDefaultColor());
        } else {
            this.o.setColorFilter(null);
            setTextColor(this.n);
        }
    }

    @Override // defpackage.lw
    public final void s(xw xwVar, Object obj) {
        this.l = o(xwVar, obj);
        this.o.setColorFilter(null);
        AnimatorSet animatorSet = this.p;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.p = null;
        }
        setTextColor(this.n);
        ((ViewGroup) getParent()).setVisibility(this.l ? 0 : 8);
    }

    public void setDrawable(int i) {
        Drawable drawable = getResources().getDrawable(i);
        this.o = drawable;
        this.j.setImageDrawable(drawable);
    }

    public void setLauncher(t tVar) {
        this.g = tVar;
    }

    public void setSearchDropTargetBar(SearchDropTargetBar searchDropTargetBar) {
        this.i = searchDropTargetBar;
    }

    public void setText(CharSequence charSequence) {
        this.k.setText(charSequence);
    }

    public void setTextColor(int i) {
        this.k.setTextColor(i);
    }

    @Override // defpackage.lw
    public final void t() {
        this.l = false;
    }

    @Override // defpackage.ox
    public void v(nx nxVar) {
        int paddingLeft;
        int paddingRight;
        DragLayer dragLayer = this.g.getDragLayer();
        Rect rect = new Rect();
        dragLayer.getViewRectRelativeToSelf(nxVar.f, rect);
        int intrinsicWidth = this.o.getIntrinsicWidth();
        int intrinsicHeight = this.o.getIntrinsicHeight();
        int measuredWidth = nxVar.f.getMeasuredWidth();
        int measuredHeight = nxVar.f.getMeasuredHeight();
        DragLayer dragLayer2 = this.g.getDragLayer();
        Rect rect2 = new Rect();
        dragLayer2.getViewRectRelativeToSelf(this, rect2);
        if (ar1.v(getResources())) {
            paddingRight = rect2.right - getPaddingRight();
            paddingLeft = paddingRight - intrinsicWidth;
        } else {
            paddingLeft = getPaddingLeft() + rect2.left;
            paddingRight = paddingLeft + intrinsicWidth;
        }
        int measuredHeight2 = ((getMeasuredHeight() - intrinsicHeight) / 2) + rect2.top;
        rect2.set(paddingLeft, measuredHeight2, paddingRight, measuredHeight2 + intrinsicHeight);
        rect2.offset((-(measuredWidth - intrinsicWidth)) / 2, (-(measuredHeight - intrinsicHeight)) / 2);
        this.i.k = true;
        dragLayer.animateView(nxVar.f, rect, rect2, rect2.width() / rect.width(), 1.0f, 1.0f, 0.1f, 0.1f, 285, new DecelerateInterpolator(2.0f), new LinearInterpolator(), new w1(this, nxVar, 5, false), 0, null);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.k.setTextColor(colorStateList);
    }

    @Override // defpackage.ox
    public final void q(nx nxVar) {
    }
}
