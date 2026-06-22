package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class g20 extends AnimatorListenerAdapter {
    public final /* synthetic */ int g;
    public final View h;
    public boolean i;

    public g20(View view, boolean z) {
        this.g = 0;
        this.i = z;
        this.h = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.g) {
            case 0:
                if (!this.i) {
                    this.h.setVisibility(4);
                }
                break;
            default:
                qu1 qu1Var = pu1.a;
                View view = this.h;
                qu1Var.F(view, 1.0f);
                if (this.i) {
                    view.setLayerType(0, null);
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        View view = this.h;
        switch (this.g) {
            case 0:
                if (this.i) {
                    view.setVisibility(0);
                }
                break;
            default:
                WeakHashMap weakHashMap = qs1.a;
                if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
                    this.i = true;
                    view.setLayerType(2, null);
                    break;
                }
                break;
        }
    }

    public g20(View view) {
        this.g = 1;
        this.i = false;
        this.h = view;
    }
}
