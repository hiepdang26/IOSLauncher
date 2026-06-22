package defpackage;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes.dex */
public final class k30 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ float g;
    public final /* synthetic */ float h;
    public final /* synthetic */ float i;
    public final /* synthetic */ float j;
    public final /* synthetic */ float k;
    public final /* synthetic */ float l;
    public final /* synthetic */ float m;
    public final /* synthetic */ Matrix n;
    public final /* synthetic */ o30 o;

    public k30(o30 o30Var, float f, float f2, float f3, float f4, float f5, float f6, float f7, Matrix matrix) {
        this.o = o30Var;
        this.g = f;
        this.h = f2;
        this.i = f3;
        this.j = f4;
        this.k = f5;
        this.l = f6;
        this.m = f7;
        this.n = matrix;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        o30 o30Var = this.o;
        o30Var.s.setAlpha(n5.b(this.g, this.h, 0.0f, 0.2f, fFloatValue));
        FloatingActionButton floatingActionButton = o30Var.s;
        float f = this.i;
        float f2 = this.j;
        floatingActionButton.setScaleX(n5.a(f, f2, fFloatValue));
        o30Var.s.setScaleY(n5.a(this.k, f2, fFloatValue));
        float f3 = this.l;
        float f4 = this.m;
        o30Var.p = n5.a(f3, f4, fFloatValue);
        float fA = n5.a(f3, f4, fFloatValue);
        Matrix matrix = this.n;
        o30Var.a(fA, matrix);
        o30Var.s.setImageMatrix(matrix);
    }
}
