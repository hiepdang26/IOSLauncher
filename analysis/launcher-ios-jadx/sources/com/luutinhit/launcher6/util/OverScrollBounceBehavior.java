package com.luutinhit.launcher6.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import defpackage.mo;
import defpackage.qs1;
import defpackage.zt1;

/* JADX INFO: loaded from: classes.dex */
public class OverScrollBounceBehavior extends mo {
    public int a;

    public OverScrollBounceBehavior() {
    }

    @Override // defpackage.mo
    public final void k(int i, View view) {
        if (i == 0) {
            return;
        }
        this.a -= i;
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setTranslationY(this.a);
        }
    }

    @Override // defpackage.mo
    public final boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        this.a = 0;
        return true;
    }

    @Override // defpackage.mo
    public final void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
        ViewGroup viewGroup = (ViewGroup) view2;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            zt1 zt1VarA = qs1.a(viewGroup.getChildAt(i2));
            zt1VarA.f(0.0f);
            zt1VarA.e();
        }
    }

    public OverScrollBounceBehavior(Context context, AttributeSet attributeSet) {
    }
}
