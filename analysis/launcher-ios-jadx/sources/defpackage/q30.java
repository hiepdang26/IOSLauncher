package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class q30 extends o30 {
    @Override // defpackage.o30
    public final float e() {
        return this.s.getElevation();
    }

    @Override // defpackage.o30
    public final void f(Rect rect) {
        if (((FloatingActionButton) this.t.h).q) {
            super.f(rect);
            return;
        }
        if (this.f) {
            FloatingActionButton floatingActionButton = this.s;
            int sizeDimension = floatingActionButton.getSizeDimension();
            int i = this.k;
            if (sizeDimension < i) {
                int sizeDimension2 = (i - floatingActionButton.getSizeDimension()) / 2;
                rect.set(sizeDimension2, sizeDimension2, sizeDimension2, sizeDimension2);
                return;
            }
        }
        rect.set(0, 0, 0, 0);
    }

    @Override // defpackage.o30
    public final void g(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable layerDrawable;
        wf1 wf1Var = this.a;
        wf1Var.getClass();
        p30 p30Var = new p30(wf1Var);
        this.b = p30Var;
        p30Var.setTintList(colorStateList);
        if (mode != null) {
            this.b.setTintMode(mode);
        }
        rr0 rr0Var = this.b;
        FloatingActionButton floatingActionButton = this.s;
        rr0Var.i(floatingActionButton.getContext());
        if (i > 0) {
            Context context = floatingActionButton.getContext();
            wf1 wf1Var2 = this.a;
            wf1Var2.getClass();
            hd hdVar = new hd(wf1Var2);
            int iK = np1.k(context, w41.design_fab_stroke_top_outer_color);
            int iK2 = np1.k(context, w41.design_fab_stroke_top_inner_color);
            int iK3 = np1.k(context, w41.design_fab_stroke_end_inner_color);
            int iK4 = np1.k(context, w41.design_fab_stroke_end_outer_color);
            hdVar.i = iK;
            hdVar.j = iK2;
            hdVar.k = iK3;
            hdVar.l = iK4;
            float f = i;
            if (hdVar.h != f) {
                hdVar.h = f;
                hdVar.b.setStrokeWidth(f * 1.3333f);
                hdVar.n = true;
                hdVar.invalidateSelf();
            }
            if (colorStateList != null) {
                hdVar.m = colorStateList.getColorForState(hdVar.getState(), hdVar.m);
            }
            hdVar.p = colorStateList;
            hdVar.n = true;
            hdVar.invalidateSelf();
            this.d = hdVar;
            hd hdVar2 = this.d;
            hdVar2.getClass();
            rr0 rr0Var2 = this.b;
            rr0Var2.getClass();
            layerDrawable = new LayerDrawable(new Drawable[]{hdVar2, rr0Var2});
        } else {
            this.d = null;
            layerDrawable = this.b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(wd.F(colorStateList2), layerDrawable, null);
        this.c = rippleDrawable;
        this.e = rippleDrawable;
    }

    @Override // defpackage.o30
    public final void i() {
        q();
    }

    @Override // defpackage.o30
    public final void j(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            FloatingActionButton floatingActionButton = this.s;
            if (!floatingActionButton.isEnabled()) {
                floatingActionButton.setElevation(0.0f);
                floatingActionButton.setTranslationZ(0.0f);
                return;
            }
            floatingActionButton.setElevation(this.h);
            if (floatingActionButton.isPressed()) {
                floatingActionButton.setTranslationZ(this.j);
            } else if (floatingActionButton.isFocused() || floatingActionButton.isHovered()) {
                floatingActionButton.setTranslationZ(this.i);
            } else {
                floatingActionButton.setTranslationZ(0.0f);
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.o30
    public final void k(float f, float f2, float f3) {
        int i = Build.VERSION.SDK_INT;
        FloatingActionButton floatingActionButton = this.s;
        if (i == 21) {
            floatingActionButton.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(o30.A, r(f, f3));
            stateListAnimator.addState(o30.B, r(f, f2));
            stateListAnimator.addState(o30.C, r(f, f2));
            stateListAnimator.addState(o30.D, r(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, Key.ELEVATION, f).setDuration(0L));
            if (i >= 22 && i <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(o30.z);
            stateListAnimator.addState(o30.E, animatorSet);
            stateListAnimator.addState(o30.F, r(0.0f, 0.0f));
            floatingActionButton.setStateListAnimator(stateListAnimator);
        }
        if (o()) {
            q();
        }
    }

    @Override // defpackage.o30
    public final void m(ColorStateList colorStateList) {
        Drawable drawable = this.c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(wd.F(colorStateList));
        } else {
            super.m(colorStateList);
        }
    }

    @Override // defpackage.o30
    public final boolean o() {
        if (((FloatingActionButton) this.t.h).q) {
            return true;
        }
        return this.f && this.s.getSizeDimension() < this.k;
    }

    public final AnimatorSet r(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        float[] fArr = {f};
        FloatingActionButton floatingActionButton = this.s;
        animatorSet.play(ObjectAnimator.ofFloat(floatingActionButton, Key.ELEVATION, fArr).setDuration(0L)).with(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(o30.z);
        return animatorSet;
    }

    @Override // defpackage.o30
    public final void h() {
    }

    @Override // defpackage.o30
    public final void p() {
    }
}
