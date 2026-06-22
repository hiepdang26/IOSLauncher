package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import defpackage.f71;
import defpackage.mo;
import defpackage.po;

/* JADX INFO: loaded from: classes.dex */
public class ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior<T> extends mo {
    public ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior() {
    }

    @Override // defpackage.mo
    public final /* synthetic */ boolean a(View view, Rect rect) {
        throw new ClassCastException();
    }

    @Override // defpackage.mo
    public final void c(po poVar) {
        if (poVar.h == 0) {
            poVar.h = 80;
        }
    }

    @Override // defpackage.mo
    public final boolean d(View view, View view2) {
        throw new ClassCastException();
    }

    @Override // defpackage.mo
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i) {
        throw new ClassCastException();
    }

    public ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f71.ExtendedFloatingActionButton_Behavior_Layout);
        typedArrayObtainStyledAttributes.getBoolean(f71.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
        typedArrayObtainStyledAttributes.getBoolean(f71.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
        typedArrayObtainStyledAttributes.recycle();
    }
}
