package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import defpackage.mo;
import defpackage.qs1;
import defpackage.y10;
import defpackage.z10;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExpandableBehavior extends mo {
    public int a = 0;

    public ExpandableBehavior() {
    }

    @Override // defpackage.mo
    public abstract boolean b(View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.mo
    public final boolean d(View view, View view2) {
        Object obj = (z10) view2;
        boolean z = ((FloatingActionButton) obj).u.b;
        if (z) {
            int i = this.a;
            if (i != 0 && i != 2) {
                return false;
            }
        } else if (this.a != 1) {
            return false;
        }
        this.a = z ? 1 : 2;
        s((View) obj, view, z, true);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.mo
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i) {
        z10 z10Var;
        boolean z;
        int i2;
        WeakHashMap weakHashMap = qs1.a;
        if (!view.isLaidOut()) {
            ArrayList arrayListD = coordinatorLayout.d(view);
            int size = arrayListD.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z10Var = null;
                    break;
                }
                View view2 = (View) arrayListD.get(i3);
                if (b(view, view2)) {
                    z10Var = (z10) view2;
                    break;
                }
                i3++;
            }
            if (z10Var != null && (!(z = ((FloatingActionButton) z10Var).u.b) ? this.a == 1 : !((i2 = this.a) != 0 && i2 != 2))) {
                int i4 = z ? 1 : 2;
                this.a = i4;
                view.getViewTreeObserver().addOnPreDrawListener(new y10(this, view, i4, z10Var));
            }
        }
        return false;
    }

    public abstract void s(View view, View view2, boolean z, boolean z2);

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
    }
}
