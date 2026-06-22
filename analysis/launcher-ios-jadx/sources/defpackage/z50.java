package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.a;

/* JADX INFO: loaded from: classes.dex */
public final class z50 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ a g;
    public final /* synthetic */ a60 h;

    public z50(a60 a60Var, a aVar) {
        this.h = a60Var;
        this.g = aVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        a aVar = this.g;
        aVar.k();
        cu.f((ViewGroup) aVar.c.L.getParent(), this.h.g.D()).e();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
