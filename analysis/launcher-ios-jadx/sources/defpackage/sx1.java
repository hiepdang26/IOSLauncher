package defpackage;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class sx1 extends hg0 {
    public final /* synthetic */ int l;
    public final /* synthetic */ ux1 m;

    public /* synthetic */ sx1(ux1 ux1Var, int i) {
        this.l = i;
        this.m = ux1Var;
    }

    @Override // defpackage.cu1
    public final void onAnimationEnd(View view) {
        View view2;
        ux1 ux1Var = this.m;
        switch (this.l) {
            case 0:
                if (ux1Var.K && (view2 = ux1Var.B) != null) {
                    view2.setTranslationY(0.0f);
                    ux1Var.y.setTranslationY(0.0f);
                }
                ux1Var.y.setVisibility(8);
                ux1Var.y.setTransitioning(false);
                ux1Var.O = null;
                tu tuVar = ux1Var.F;
                if (tuVar != null) {
                    tuVar.k(ux1Var.E);
                    ux1Var.E = null;
                    ux1Var.F = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = ux1Var.x;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = qs1.a;
                    fs1.c(actionBarOverlayLayout);
                }
                break;
            default:
                ux1Var.O = null;
                ux1Var.y.requestLayout();
                break;
        }
    }
}
