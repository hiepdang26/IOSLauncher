package defpackage;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import com.luutinhit.launcher6.v;

/* JADX INFO: loaded from: classes.dex */
public final class z01 implements LayoutTransition.TransitionListener {
    public final /* synthetic */ v a;

    public z01(v vVar) {
        this.a = vVar;
    }

    @Override // android.animation.LayoutTransition.TransitionListener
    public final void endTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i) {
        if (layoutTransition.isRunning()) {
            return;
        }
        layoutTransition.removeTransitionListener(this);
        v vVar = this.a;
        int childCount = vVar.getChildCount();
        if (childCount > 0) {
            vVar.s = vVar.E(vVar.o0 ? 0 : childCount - 1);
        } else {
            vVar.s = 0;
        }
    }

    @Override // android.animation.LayoutTransition.TransitionListener
    public final void startTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i) {
    }
}
