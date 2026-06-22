package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import defpackage.et1;
import defpackage.f71;
import defpackage.mo;
import defpackage.po;
import defpackage.qs1;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AppBarLayout$ScrollingViewBehavior extends et1 {
    public final int b;

    public AppBarLayout$ScrollingViewBehavior() {
        new Rect();
        new Rect();
    }

    public static void t(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
        }
    }

    @Override // defpackage.mo
    public final boolean d(View view, View view2) {
        int i;
        mo moVar = ((po) view2.getLayoutParams()).a;
        if (moVar instanceof AppBarLayout$BaseBehavior) {
            int bottom = view2.getBottom() - view.getTop();
            ((AppBarLayout$BaseBehavior) moVar).getClass();
            int i2 = this.b;
            if (i2 == 0 || (i = (int) (0.0f * i2)) < 0) {
                i2 = 0;
            } else if (i <= i2) {
                i2 = i;
            }
            qs1.j(bottom - i2, view);
        }
        return false;
    }

    @Override // defpackage.mo
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        int i4 = view.getLayoutParams().height;
        if (i4 != -1 && i4 != -2) {
            return false;
        }
        t(coordinatorLayout.d(view));
        return false;
    }

    @Override // defpackage.mo
    public final void m(CoordinatorLayout coordinatorLayout, View view) {
        t(coordinatorLayout.d(view));
    }

    @Override // defpackage.et1
    public final void s(CoordinatorLayout coordinatorLayout, View view, int i) {
        t(coordinatorLayout.d(view));
        coordinatorLayout.j(i, view);
    }

    public AppBarLayout$ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        new Rect();
        new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f71.ScrollingViewBehavior_Layout);
        this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(f71.ScrollingViewBehavior_Layout_behavior_overlapTop, 0);
        typedArrayObtainStyledAttributes.recycle();
    }
}
