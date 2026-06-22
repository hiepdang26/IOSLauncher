package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import defpackage.fz1;
import defpackage.ka0;
import defpackage.qb;

/* JADX INFO: loaded from: classes.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {
    public final ka0 g;

    public BaseTransientBottomBar$Behavior() {
        ka0 ka0Var = new ka0(9);
        this.d = Math.min(Math.max(0.0f, 0.1f), 1.0f);
        this.e = Math.min(Math.max(0.0f, 0.6f), 1.0f);
        this.c = 0;
        this.g = ka0Var;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, defpackage.mo
    public final boolean f(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.g.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                if (fz1.i == null) {
                    fz1.i = new fz1(27);
                }
                synchronized (fz1.i.h) {
                }
            }
        } else if (coordinatorLayout.h(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (fz1.i == null) {
                fz1.i = new fz1(27);
            }
            fz1.i.E();
        }
        return super.f(coordinatorLayout, view, motionEvent);
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public final boolean s(View view) {
        this.g.getClass();
        return view instanceof qb;
    }
}
