package defpackage;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class ug implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ zg h;
    public final /* synthetic */ int i;
    public final /* synthetic */ int j;
    public final /* synthetic */ int k;
    public final /* synthetic */ int l;
    public final /* synthetic */ View m;

    public /* synthetic */ ug(zg zgVar, int i, int i2, int i3, int i4, View view, int i5) {
        this.g = i5;
        this.h = zgVar;
        this.i = i;
        this.j = i2;
        this.k = i3;
        this.l = i4;
        this.m = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.g) {
            case 0:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f = 1.0f - fFloatValue;
                zg zgVar = this.h;
                zgVar.k = (int) ((this.j * fFloatValue) + (this.i * f));
                zgVar.l = (int) ((fFloatValue * this.l) + (f * this.k));
                this.m.requestLayout();
                break;
            default:
                float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f2 = 1.0f - fFloatValue2;
                zg zgVar2 = this.h;
                zgVar2.k = (int) ((this.j * fFloatValue2) + (this.i * f2));
                zgVar2.l = (int) ((fFloatValue2 * this.l) + (f2 * this.k));
                this.m.requestLayout();
                break;
        }
    }
}
