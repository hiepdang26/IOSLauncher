package defpackage;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ux extends c00 {
    public final qx e;
    public final v3 f;
    public final rx g;
    public final ej h;
    public final fj i;
    public final mg j;
    public final fz1 k;
    public boolean l;
    public boolean m;
    public long n;
    public StateListDrawable o;
    public rr0 p;
    public AccessibilityManager q;
    public ValueAnimator r;
    public ValueAnimator s;

    public ux(TextInputLayout textInputLayout, int i) {
        super(textInputLayout, i);
        this.e = new qx(this, 0);
        this.f = new v3(this, 2);
        this.g = new rx(this, textInputLayout);
        int i2 = 1;
        this.h = new ej(this, i2);
        this.i = new fj(this, 1);
        this.j = new mg(this, i2);
        this.k = new fz1(this, 12);
        this.l = false;
        this.m = false;
        this.n = Long.MAX_VALUE;
    }

    public static void d(ux uxVar, AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            uxVar.getClass();
            return;
        }
        uxVar.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis() - uxVar.n;
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
            uxVar.l = false;
        }
        if (uxVar.l) {
            uxVar.l = false;
            return;
        }
        uxVar.i(!uxVar.m);
        if (!uxVar.m) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    public static boolean h(EditText editText) {
        return editText.getKeyListener() != null;
    }

    @Override // defpackage.c00
    public final void a() {
        int i = 7;
        Context context = this.b;
        float dimensionPixelOffset = context.getResources().getDimensionPixelOffset(d51.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(d51.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(d51.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        rr0 rr0VarG = g(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        rr0 rr0VarG2 = g(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.p = rr0VarG;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.o = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, rr0VarG);
        this.o.addState(new int[0], rr0VarG2);
        int i2 = this.d;
        if (i2 == 0) {
            i2 = k51.mtrl_dropdown_arrow;
        }
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconDrawable(i2);
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(v61.exposed_dropdown_menu_content_description));
        textInputLayout.setEndIconOnClickListener(new sx(this));
        LinkedHashSet linkedHashSet = textInputLayout.h0;
        ej ejVar = this.h;
        linkedHashSet.add(ejVar);
        if (textInputLayout.k != null) {
            ejVar.a(textInputLayout);
        }
        textInputLayout.l0.add(this.i);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        LinearInterpolator linearInterpolator = n5.a;
        valueAnimatorOfFloat.setInterpolator(linearInterpolator);
        valueAnimatorOfFloat.setDuration(67);
        valueAnimatorOfFloat.addUpdateListener(new q7(this, i));
        this.s = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(linearInterpolator);
        valueAnimatorOfFloat2.setDuration(50);
        valueAnimatorOfFloat2.addUpdateListener(new q7(this, i));
        this.r = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new be(this, 2));
        this.q = (AccessibilityManager) context.getSystemService("accessibility");
        textInputLayout.addOnAttachStateChangeListener(this.j);
        f();
    }

    @Override // defpackage.c00
    public final boolean b(int i) {
        return i != 0;
    }

    public final void e(AutoCompleteTextView autoCompleteTextView) {
        if (h(autoCompleteTextView)) {
            return;
        }
        TextInputLayout textInputLayout = this.a;
        int boxBackgroundMode = textInputLayout.getBoxBackgroundMode();
        rr0 boxBackground = textInputLayout.getBoxBackground();
        int iE = bf1.e(q41.colorControlHighlight, autoCompleteTextView);
        int[][] iArr = {new int[]{R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode != 2) {
            if (boxBackgroundMode == 1) {
                int boxBackgroundColor = textInputLayout.getBoxBackgroundColor();
                RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(iArr, new int[]{bf1.p(0.1f, iE, boxBackgroundColor), boxBackgroundColor}), boxBackground, boxBackground);
                WeakHashMap weakHashMap = qs1.a;
                autoCompleteTextView.setBackground(rippleDrawable);
                return;
            }
            return;
        }
        int iE2 = bf1.e(q41.colorSurface, autoCompleteTextView);
        rr0 rr0Var = new rr0(boxBackground.g.a);
        int iP = bf1.p(0.1f, iE, iE2);
        rr0Var.k(new ColorStateList(iArr, new int[]{iP, 0}));
        rr0Var.setTint(iE2);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iP, iE2});
        rr0 rr0Var2 = new rr0(boxBackground.g.a);
        rr0Var2.setTint(-1);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, rr0Var, rr0Var2), boxBackground});
        WeakHashMap weakHashMap2 = qs1.a;
        autoCompleteTextView.setBackground(layerDrawable);
    }

    public final void f() {
        TextInputLayout textInputLayout;
        if (this.q == null || (textInputLayout = this.a) == null) {
            return;
        }
        WeakHashMap weakHashMap = qs1.a;
        if (textInputLayout.isAttachedToWindow()) {
            this.q.addTouchExplorationStateChangeListener(new f0(this.k));
        }
    }

    public final rr0 g(float f, float f2, float f3, int i) {
        rc1 rc1Var = new rc1();
        rc1 rc1Var2 = new rc1();
        rc1 rc1Var3 = new rc1();
        rc1 rc1Var4 = new rc1();
        iy iyVar = new iy();
        iy iyVar2 = new iy();
        iy iyVar3 = new iy();
        iy iyVar4 = new iy();
        d dVar = new d(f);
        d dVar2 = new d(f);
        d dVar3 = new d(f2);
        d dVar4 = new d(f2);
        wf1 wf1Var = new wf1();
        wf1Var.a = rc1Var;
        wf1Var.b = rc1Var2;
        wf1Var.c = rc1Var3;
        wf1Var.d = rc1Var4;
        wf1Var.e = dVar;
        wf1Var.f = dVar2;
        wf1Var.g = dVar4;
        wf1Var.h = dVar3;
        wf1Var.i = iyVar;
        wf1Var.j = iyVar2;
        wf1Var.k = iyVar3;
        wf1Var.l = iyVar4;
        Paint paint = rr0.C;
        int i2 = q41.colorSurface;
        String simpleName = rr0.class.getSimpleName();
        Context context = this.b;
        int iO = z71.o(context, simpleName, i2);
        rr0 rr0Var = new rr0();
        rr0Var.i(context);
        rr0Var.k(ColorStateList.valueOf(iO));
        rr0Var.j(f3);
        rr0Var.setShapeAppearanceModel(wf1Var);
        qr0 qr0Var = rr0Var.g;
        if (qr0Var.g == null) {
            qr0Var.g = new Rect();
        }
        rr0Var.g.g.set(0, i, 0, i);
        rr0Var.invalidateSelf();
        return rr0Var;
    }

    public final void i(boolean z) {
        if (this.m != z) {
            this.m = z;
            this.s.cancel();
            this.r.start();
        }
    }
}
