package com.google.android.material.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import defpackage.be;
import defpackage.mo;
import defpackage.n5;

/* JADX INFO: loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends mo {
    public int a = 0;
    public int b = 2;
    public ViewPropertyAnimator c;

    public HideBottomViewOnScrollBehavior() {
    }

    @Override // defpackage.mo
    public boolean g(CoordinatorLayout coordinatorLayout, View view, int i) {
        this.a = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        return false;
    }

    @Override // defpackage.mo
    public final void l(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (i2 > 0) {
            if (this.b == 1) {
                return;
            }
            ViewPropertyAnimator viewPropertyAnimator = this.c;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.b = 1;
            this.c = view.animate().translationY(this.a).setInterpolator(n5.c).setDuration(175L).setListener(new be(this, 8));
            return;
        }
        if (i2 >= 0 || this.b == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator2 = this.c;
        if (viewPropertyAnimator2 != null) {
            viewPropertyAnimator2.cancel();
            view.clearAnimation();
        }
        this.b = 2;
        this.c = view.animate().translationY(0).setInterpolator(n5.d).setDuration(225L).setListener(new be(this, 8));
    }

    @Override // defpackage.mo
    public boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        return i == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
