package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.Key;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import defpackage.f20;
import defpackage.fi;
import defpackage.hs1;
import defpackage.m21;
import defpackage.m90;
import defpackage.n5;
import defpackage.po;
import defpackage.q11;
import defpackage.qs1;
import defpackage.ru0;
import defpackage.su0;
import defpackage.u51;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public final Rect c;
    public final RectF d;
    public final RectF e;
    public final int[] f;
    public float g;
    public float h;

    public FabTransformationBehavior() {
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }

    public static Pair u(float f, float f2, boolean z, q11 q11Var) {
        su0 su0VarD;
        su0 su0VarD2;
        if (f == 0.0f || f2 == 0.0f) {
            su0VarD = ((ru0) q11Var.h).d("translationXLinear");
            su0VarD2 = ((ru0) q11Var.h).d("translationYLinear");
        } else if ((!z || f2 >= 0.0f) && (z || f2 <= 0.0f)) {
            su0VarD = ((ru0) q11Var.h).d("translationXCurveDownwards");
            su0VarD2 = ((ru0) q11Var.h).d("translationYCurveDownwards");
        } else {
            su0VarD = ((ru0) q11Var.h).d("translationXCurveUpwards");
            su0VarD2 = ((ru0) q11Var.h).d("translationYCurveUpwards");
        }
        return new Pair(su0VarD, su0VarD2);
    }

    public static float x(q11 q11Var, su0 su0Var, float f) {
        long j = su0Var.a;
        su0 su0VarD = ((ru0) q11Var.h).d("expansion");
        return n5.a(f, 0.0f, su0Var.b().getInterpolation((((su0VarD.a + su0VarD.b) + 17) - j) / su0Var.b));
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, defpackage.mo
    public final boolean b(View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override // defpackage.mo
    public final void c(po poVar) {
        if (poVar.h == 0) {
            poVar.h = 80;
        }
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public final AnimatorSet t(View view, View view2, boolean z, boolean z2) {
        ObjectAnimator objectAnimatorOfFloat;
        char c;
        float f;
        ObjectAnimator objectAnimatorOfFloat2;
        ObjectAnimator objectAnimatorOfFloat3;
        ObjectAnimator objectAnimatorOfFloat4;
        q11 q11VarZ = z(view2.getContext(), z);
        if (z) {
            this.g = view.getTranslationX();
            this.h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        WeakHashMap weakHashMap = qs1.a;
        float fE = hs1.e(view2) - hs1.e(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-fE);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -fE);
        }
        ((ru0) q11VarZ.h).d(Key.ELEVATION).a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        RectF rectF = this.d;
        float fV = v(view, view2, (m21) q11VarZ.i);
        float fW = w(view, view2, (m21) q11VarZ.i);
        Pair pairU = u(fV, fW, z, q11VarZ);
        su0 su0Var = (su0) pairU.first;
        su0 su0Var2 = (su0) pairU.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-fV);
                view2.setTranslationY(-fW);
            }
            c = 0;
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            f = 0.0f;
            objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            float fX = x(q11VarZ, su0Var, -fV);
            float fX2 = x(q11VarZ, su0Var2, -fW);
            Rect rect = this.c;
            view2.getWindowVisibleDisplayFrame(rect);
            rectF.set(rect);
            RectF rectF2 = this.e;
            y(view2, rectF2);
            rectF2.offset(fX, fX2);
            rectF2.intersect(rectF);
            rectF.set(rectF2);
        } else {
            c = 0;
            f = 0.0f;
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fV);
            objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fW);
        }
        su0Var.a(objectAnimatorOfFloat2);
        su0Var2.a(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat3);
        rectF.width();
        rectF.height();
        float fV2 = v(view, view2, (m21) q11VarZ.i);
        float fW2 = w(view, view2, (m21) q11VarZ.i);
        Pair pairU2 = u(fV2, fW2, z, q11VarZ);
        su0 su0Var3 = (su0) pairU2.first;
        su0 su0Var4 = (su0) pairU2.second;
        Property property = View.TRANSLATION_X;
        if (!z) {
            fV2 = this.g;
        }
        float[] fArr = new float[1];
        fArr[c] = fV2;
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        if (!z) {
            fW2 = this.h;
        }
        float[] fArr2 = new float[1];
        fArr2[c] = fW2;
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        su0Var3.a(objectAnimatorOfFloat5);
        su0Var4.a(objectAnimatorOfFloat6);
        arrayList.add(objectAnimatorOfFloat5);
        arrayList.add(objectAnimatorOfFloat6);
        if (view2 instanceof ViewGroup) {
            View viewFindViewById = view2.findViewById(u51.mtrl_child_content_container);
            ViewGroup viewGroup = viewFindViewById != null ? viewFindViewById instanceof ViewGroup ? (ViewGroup) viewFindViewById : null : (ViewGroup) view2;
            if (viewGroup != null) {
                if (z) {
                    if (!z2) {
                        fi.a.set(viewGroup, Float.valueOf(f));
                    }
                    fi fiVar = fi.a;
                    float[] fArr3 = new float[1];
                    fArr3[c] = 1.0f;
                    objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewGroup, fiVar, fArr3);
                } else {
                    fi fiVar2 = fi.a;
                    float[] fArr4 = new float[1];
                    fArr4[c] = f;
                    objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewGroup, fiVar2, fArr4);
                }
                ((ru0) q11VarZ.h).d("contentFade").a(objectAnimatorOfFloat4);
                arrayList.add(objectAnimatorOfFloat4);
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        m90.n(animatorSet, arrayList);
        animatorSet.addListener(new f20(z, view2, view));
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i));
        }
        return animatorSet;
    }

    public final float v(View view, View view2, m21 m21Var) {
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        y(view, rectF);
        rectF.offset(this.g, this.h);
        y(view2, rectF2);
        m21Var.getClass();
        return (rectF2.centerX() - rectF.centerX()) + 0.0f;
    }

    public final float w(View view, View view2, m21 m21Var) {
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        y(view, rectF);
        rectF.offset(this.g, this.h);
        y(view2, rectF2);
        m21Var.getClass();
        return (rectF2.centerY() - rectF.centerY()) + 0.0f;
    }

    public final void y(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public abstract q11 z(Context context, boolean z);

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }
}
