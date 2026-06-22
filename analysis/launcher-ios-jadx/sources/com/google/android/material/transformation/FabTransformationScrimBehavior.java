package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import defpackage.g20;
import defpackage.m90;
import defpackage.su0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    public final su0 c;
    public final su0 d;

    public FabTransformationScrimBehavior() {
        this.c = new su0(75L);
        this.d = new su0(0L);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, defpackage.mo
    public final boolean b(View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    @Override // defpackage.mo
    public final boolean r(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public final AnimatorSet t(View view, View view2, boolean z, boolean z2) {
        ObjectAnimator objectAnimatorOfFloat;
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        su0 su0Var = z ? this.c : this.d;
        if (z) {
            if (!z2) {
                view2.setAlpha(0.0f);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.ALPHA, 1.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.ALPHA, 0.0f);
        }
        su0Var.a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        AnimatorSet animatorSet = new AnimatorSet();
        m90.n(animatorSet, arrayList);
        animatorSet.addListener(new g20(view2, z));
        return animatorSet;
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new su0(75L);
        this.d = new su0(0L);
    }
}
