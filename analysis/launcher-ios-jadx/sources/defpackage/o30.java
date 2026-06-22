package defpackage;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class o30 {
    public wf1 a;
    public rr0 b;
    public Drawable c;
    public hd d;
    public LayerDrawable e;
    public boolean f;
    public float h;
    public float i;
    public float j;
    public int k;
    public Animator l;
    public ru0 m;
    public ru0 n;
    public float o;
    public int q;
    public final FloatingActionButton s;
    public final fz1 t;
    public qo y;
    public static final p20 z = n5.c;
    public static final int[] A = {R.attr.state_pressed, R.attr.state_enabled};
    public static final int[] B = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    public static final int[] C = {R.attr.state_focused, R.attr.state_enabled};
    public static final int[] D = {R.attr.state_hovered, R.attr.state_enabled};
    public static final int[] E = {R.attr.state_enabled};
    public static final int[] F = new int[0];
    public boolean g = true;
    public float p = 1.0f;
    public int r = 0;
    public final Rect u = new Rect();
    public final RectF v = new RectF();
    public final RectF w = new RectF();
    public final Matrix x = new Matrix();

    public o30(FloatingActionButton floatingActionButton, fz1 fz1Var) {
        this.s = floatingActionButton;
        this.t = fz1Var;
        wb2 wb2Var = new wb2(22);
        q30 q30Var = (q30) this;
        wb2Var.j(A, d(new m30(q30Var, 1)));
        wb2Var.j(B, d(new m30(q30Var, 0)));
        wb2Var.j(C, d(new m30(q30Var, 0)));
        wb2Var.j(D, d(new m30(q30Var, 0)));
        wb2Var.j(E, d(new m30(q30Var, 2)));
        wb2Var.j(F, d(new l30(q30Var)));
        this.o = floatingActionButton.getRotation();
    }

    public static ValueAnimator d(n30 n30Var) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(z);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(n30Var);
        valueAnimator.addUpdateListener(n30Var);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public final void a(float f, Matrix matrix) {
        matrix.reset();
        if (this.s.getDrawable() == null || this.q == 0) {
            return;
        }
        RectF rectF = this.v;
        RectF rectF2 = this.w;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        float f2 = this.q;
        rectF2.set(0.0f, 0.0f, f2, f2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        float f3 = this.q / 2.0f;
        matrix.postScale(f, f, f3, f3);
    }

    public final AnimatorSet b(ru0 ru0Var, float f, float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        Property property = View.ALPHA;
        int i = 1;
        float[] fArr = {f};
        FloatingActionButton floatingActionButton = this.s;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) property, fArr);
        ru0Var.d("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_X, f2);
        ru0Var.d("scale").a(objectAnimatorOfFloat2);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 26) {
            p5 p5Var = new p5(i);
            p5Var.b = new FloatEvaluator();
            objectAnimatorOfFloat2.setEvaluator(p5Var);
        }
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_Y, f2);
        ru0Var.d("scale").a(objectAnimatorOfFloat3);
        if (i2 == 26) {
            p5 p5Var2 = new p5(i);
            p5Var2.b = new FloatEvaluator();
            objectAnimatorOfFloat3.setEvaluator(p5Var2);
        }
        arrayList.add(objectAnimatorOfFloat3);
        Matrix matrix = this.x;
        a(f3, matrix);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(floatingActionButton, new ih(), new j30(this), new Matrix(matrix));
        ru0Var.d("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        m90.n(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet c(float f, float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        FloatingActionButton floatingActionButton = this.s;
        valueAnimatorOfFloat.addUpdateListener(new k30(this, floatingActionButton.getAlpha(), f, floatingActionButton.getScaleX(), f2, floatingActionButton.getScaleY(), this.p, f3, new Matrix(this.x)));
        arrayList.add(valueAnimatorOfFloat);
        m90.n(animatorSet, arrayList);
        Context context = floatingActionButton.getContext();
        int i = q41.motionDurationLong1;
        int integer = floatingActionButton.getContext().getResources().getInteger(h61.material_motion_duration_long_1);
        TypedValue typedValueN = z71.n(context, i);
        if (typedValueN != null && typedValueN.type == 16) {
            integer = typedValueN.data;
        }
        animatorSet.setDuration(integer);
        Context context2 = floatingActionButton.getContext();
        int i2 = q41.motionEasingStandard;
        TimeInterpolator pathInterpolator = n5.b;
        TypedValue typedValue = new TypedValue();
        if (context2.getTheme().resolveAttribute(i2, typedValue, true)) {
            if (typedValue.type != 3) {
                throw new IllegalArgumentException("Motion easing theme attribute must be a string");
            }
            String strValueOf = String.valueOf(typedValue.string);
            if (n90.w(strValueOf, "cubic-bezier")) {
                String[] strArrSplit = strValueOf.substring(13, strValueOf.length() - 1).split(",");
                if (strArrSplit.length != 4) {
                    throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
                }
                pathInterpolator = new PathInterpolator(n90.l(0, strArrSplit), n90.l(1, strArrSplit), n90.l(2, strArrSplit), n90.l(3, strArrSplit));
            } else {
                if (!n90.w(strValueOf, "path")) {
                    throw new IllegalArgumentException("Invalid motion easing type: ".concat(strValueOf));
                }
                pathInterpolator = new PathInterpolator(p02.i(strValueOf.substring(5, strValueOf.length() - 1)));
            }
        }
        animatorSet.setInterpolator(pathInterpolator);
        return animatorSet;
    }

    public abstract float e();

    public void f(Rect rect) {
        int sizeDimension = this.f ? (this.k - this.s.getSizeDimension()) / 2 : 0;
        int iMax = Math.max(sizeDimension, (int) Math.ceil(this.g ? e() + this.j : 0.0f));
        int iMax2 = Math.max(sizeDimension, (int) Math.ceil(r1 * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    public abstract void g(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i);

    public abstract void h();

    public abstract void i();

    public abstract void j(int[] iArr);

    public abstract void k(float f, float f2, float f3);

    public void m(ColorStateList colorStateList) {
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.setTintList(wd.F(colorStateList));
        }
    }

    public final void n(wf1 wf1Var) {
        this.a = wf1Var;
        rr0 rr0Var = this.b;
        if (rr0Var != null) {
            rr0Var.setShapeAppearanceModel(wf1Var);
        }
        Object obj = this.c;
        if (obj instanceof hg1) {
            ((hg1) obj).setShapeAppearanceModel(wf1Var);
        }
        hd hdVar = this.d;
        if (hdVar != null) {
            hdVar.o = wf1Var;
            hdVar.invalidateSelf();
        }
    }

    public abstract boolean o();

    public abstract void p();

    public final void q() {
        Rect rect = this.u;
        f(rect);
        qg0.j(this.e, "Didn't initialize content background");
        boolean zO = o();
        fz1 fz1Var = this.t;
        if (zO) {
            super/*android.widget.ImageButton*/.setBackgroundDrawable(new InsetDrawable((Drawable) this.e, rect.left, rect.top, rect.right, rect.bottom));
        } else {
            LayerDrawable layerDrawable = this.e;
            if (layerDrawable != null) {
                super/*android.widget.ImageButton*/.setBackgroundDrawable(layerDrawable);
            } else {
                fz1Var.getClass();
            }
        }
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        FloatingActionButton floatingActionButton = (FloatingActionButton) fz1Var.h;
        floatingActionButton.r.set(i, i2, i3, i4);
        int i5 = floatingActionButton.o;
        floatingActionButton.setPadding(i + i5, i2 + i5, i3 + i5, i4 + i5);
    }

    public final void l() {
    }
}
