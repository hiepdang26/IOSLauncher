package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.motion.widget.Key;
import com.luutinhit.launcher6.CellLayout;

/* JADX INFO: loaded from: classes.dex */
public final class ah {
    public final View a;
    public final float b;
    public final float c;
    public float d;
    public float e;
    public final float f;
    public float g;
    public final int h;
    public boolean i = false;
    public Animator j;
    public final /* synthetic */ CellLayout k;

    public ah(CellLayout cellLayout, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.k = cellLayout;
        cellLayout.C(i2, i3, i6, i7, cellLayout.q);
        int[] iArr = cellLayout.q;
        int i8 = iArr[0];
        int i9 = iArr[1];
        cellLayout.C(i4, i5, i6, i7, iArr);
        int i10 = iArr[0] - i8;
        int i11 = iArr[1] - i9;
        this.b = 0.0f;
        this.c = 0.0f;
        int i12 = i == 0 ? -1 : 1;
        if (i10 != i11 || i10 != 0) {
            float f = cellLayout.L;
            if (i11 == 0) {
                this.b = Math.signum(i10) * (-i12) * f;
            } else if (i10 == 0) {
                this.c = Math.signum(i11) * (-i12) * f;
            } else {
                float f2 = i11;
                double dAtan = Math.atan(f2 / r1);
                float f3 = -i12;
                double dSignum = Math.signum(i10) * f3;
                double d = f;
                this.b = (int) (Math.abs(Math.cos(dAtan) * d) * dSignum);
                this.c = (int) (Math.abs(Math.sin(dAtan) * d) * ((double) (Math.signum(f2) * f3)));
            }
        }
        this.h = i;
        this.d = view.getTranslationX();
        this.e = view.getTranslationY();
        this.f = cellLayout.getChildrenScale() - (4.0f / view.getWidth());
        this.g = view.getScaleX();
        this.a = view;
    }

    public final void a() {
        Animator animator = this.j;
        if (animator != null) {
            animator.cancel();
        }
        AnimatorSet animatorSetA = ik0.a();
        this.j = animatorSetA;
        CellLayout cellLayout = this.k;
        float[] fArr = {cellLayout.getChildrenScale()};
        View view = this.a;
        animatorSetA.playTogether(ik0.b(view, Key.SCALE_X, fArr), ik0.b(view, Key.SCALE_Y, cellLayout.getChildrenScale()), ik0.b(view, Key.TRANSLATION_X, 0.0f), ik0.b(view, Key.TRANSLATION_Y, 0.0f));
        animatorSetA.setDuration(150L);
        animatorSetA.setInterpolator(new DecelerateInterpolator(1.5f));
        animatorSetA.start();
    }
}
