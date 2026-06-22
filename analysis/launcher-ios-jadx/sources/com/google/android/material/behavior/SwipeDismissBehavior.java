package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import defpackage.al1;
import defpackage.mo;
import defpackage.n0;
import defpackage.ow1;
import defpackage.qs1;
import defpackage.vs1;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends mo {
    public vs1 a;
    public boolean b;
    public int c = 2;
    public float d = 0.0f;
    public float e = 0.5f;
    public final al1 f = new al1(this);

    @Override // defpackage.mo
    public boolean f(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean zH = this.b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zH = coordinatorLayout.h(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.b = zH;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.b = false;
        }
        if (!zH) {
            return false;
        }
        if (this.a == null) {
            this.a = new vs1(coordinatorLayout.getContext(), coordinatorLayout, this.f);
        }
        return this.a.r(motionEvent);
    }

    @Override // defpackage.mo
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i) {
        WeakHashMap weakHashMap = qs1.a;
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
            qs1.m(1048576, view);
            qs1.h(0, view);
            if (s(view)) {
                qs1.n(view, n0.l, new ow1(this, 27));
            }
        }
        return false;
    }

    @Override // defpackage.mo
    public final boolean r(View view, MotionEvent motionEvent) {
        vs1 vs1Var = this.a;
        if (vs1Var == null) {
            return false;
        }
        vs1Var.k(motionEvent);
        return true;
    }

    public boolean s(View view) {
        return true;
    }
}
