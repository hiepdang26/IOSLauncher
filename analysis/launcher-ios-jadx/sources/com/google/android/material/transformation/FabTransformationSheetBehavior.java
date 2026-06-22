package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import defpackage.h41;
import defpackage.m21;
import defpackage.po;
import defpackage.q11;
import defpackage.qs1;
import defpackage.ru0;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    public HashMap i;

    public FabTransformationSheetBehavior() {
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public final void s(View view, View view2, boolean z, boolean z2) {
        ViewParent parent = view2.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                this.i = new HashMap(childCount);
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                boolean z3 = (childAt.getLayoutParams() instanceof po) && (((po) childAt.getLayoutParams()).a instanceof FabTransformationScrimBehavior);
                if (childAt != view2 && !z3) {
                    if (z) {
                        this.i.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        WeakHashMap weakHashMap = qs1.a;
                        childAt.setImportantForAccessibility(4);
                    } else {
                        HashMap map = this.i;
                        if (map != null && map.containsKey(childAt)) {
                            int iIntValue = ((Integer) this.i.get(childAt)).intValue();
                            WeakHashMap weakHashMap2 = qs1.a;
                            childAt.setImportantForAccessibility(iIntValue);
                        }
                    }
                }
            }
            if (!z) {
                this.i = null;
            }
        }
        super.s(view, view2, z, z2);
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    public final q11 z(Context context, boolean z) {
        int i = z ? h41.mtrl_fab_transformation_sheet_expand_spec : h41.mtrl_fab_transformation_sheet_collapse_spec;
        q11 q11Var = new q11(9, false);
        q11Var.h = ru0.b(context, i);
        q11Var.i = new m21();
        return q11Var;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
