package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.transformation.ExpandableBehavior;

/* JADX INFO: loaded from: classes.dex */
public final class y10 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ View g;
    public final /* synthetic */ int h;
    public final /* synthetic */ z10 i;
    public final /* synthetic */ ExpandableBehavior j;

    public y10(ExpandableBehavior expandableBehavior, View view, int i, z10 z10Var) {
        this.j = expandableBehavior;
        this.g = view;
        this.h = i;
        this.i = z10Var;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        View view = this.g;
        view.getViewTreeObserver().removeOnPreDrawListener(this);
        ExpandableBehavior expandableBehavior = this.j;
        if (expandableBehavior.a == this.h) {
            Object obj = this.i;
            expandableBehavior.s((View) obj, view, ((FloatingActionButton) obj).u.b, false);
        }
        return false;
    }
}
