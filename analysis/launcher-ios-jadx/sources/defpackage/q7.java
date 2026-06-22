package defpackage;

import android.animation.ValueAnimator;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Point;
import android.graphics.RectF;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.luutinhit.launcher6.ButtonDropTarget;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.DragLayer;
import com.luutinhit.launcher6.allapps.AllAppsRecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class q7 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ q7(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Object obj = this.h;
        switch (this.g) {
            case 0:
                ((r7) obj).requestLayout();
                break;
            case 1:
                lb lbVar = (lb) obj;
                lbVar.g.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                AllAppsRecyclerView allAppsRecyclerView = lbVar.a;
                Point point = lbVar.f;
                int i = point.x;
                int i2 = point.y;
                allAppsRecyclerView.invalidate(i, i2, lbVar.j + i, lbVar.k + i2);
                break;
            case 2:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                rr0 rr0Var = ((BottomSheetBehavior) obj).h;
                if (rr0Var != null) {
                    qr0 qr0Var = rr0Var.g;
                    if (qr0Var.i != fFloatValue) {
                        qr0Var.i = fFloatValue;
                        rr0Var.k = true;
                        rr0Var.invalidateSelf();
                    }
                }
                break;
            case 3:
                pd pdVar = (pd) obj;
                if (pdVar.a0 != null) {
                    float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ((nx0) pdVar.a0).A((int) Math.abs(fFloatValue2), fFloatValue2 <= 0.0f, true);
                }
                break;
            case 4:
                ButtonDropTarget buttonDropTarget = (ButtonDropTarget) obj;
                buttonDropTarget.o.setColorFilter(new ColorMatrixColorFilter(buttonDropTarget.s));
                buttonDropTarget.invalidate();
                break;
            case 5:
                ah ahVar = (ah) obj;
                try {
                    float fFloatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float f = (ahVar.h == 0 && ahVar.i) ? 1.0f : fFloatValue3;
                    float f2 = 1.0f - f;
                    float f3 = (ahVar.b * f) + (ahVar.d * f2);
                    float f4 = (f * ahVar.c) + (f2 * ahVar.e);
                    ahVar.a.setTranslationX(f3);
                    ahVar.a.setTranslationY(f4);
                    float f5 = (ahVar.f * fFloatValue3) + ((1.0f - fFloatValue3) * ahVar.g);
                    ahVar.a.setScaleX(f5);
                    ahVar.a.setScaleY(f5);
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
                break;
            case 6:
                zw zwVar = (zw) obj;
                zwVar.h.setColorFilter(new ColorMatrixColorFilter(zwVar.t));
                zwVar.invalidate();
                break;
            case 7:
                ((ux) obj).c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 8:
                int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                r20 r20Var = (r20) obj;
                r20Var.i.setAlpha(iFloatValue);
                r20Var.j.setAlpha(iFloatValue);
                r20Var.y.invalidate();
                break;
            case 9:
                float fFloatValue4 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RectF rectF = t40.h;
                t40 t40Var = (t40) obj;
                t40Var.d = ((fFloatValue4 * 0.2f) + 1.0f) * t40.j;
                CellLayout cellLayout = t40Var.c;
                if (cellLayout != null) {
                    cellLayout.invalidate();
                }
                break;
            case 10:
                ((sh0) obj).s = valueAnimator.getAnimatedFraction();
                break;
            case 11:
                ((TabLayout) obj).scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                break;
            case 12:
                ((TextInputLayout) obj).I0.l(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            default:
                ((DragLayer) obj).setBackgroundAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }
}
