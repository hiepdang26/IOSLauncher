package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class o91 extends e0 {
    public final RecyclerView j;
    public final n91 k;

    public o91(RecyclerView recyclerView) {
        this.j = recyclerView;
        e0 e0VarJ = j();
        if (e0VarJ == null || !(e0VarJ instanceof n91)) {
            this.k = new n91(this);
        } else {
            this.k = (n91) e0VarJ;
        }
    }

    @Override // defpackage.e0
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || this.j.S()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().V(accessibilityEvent);
        }
    }

    @Override // defpackage.e0
    public void d(View view, r0 r0Var) {
        this.g.onInitializeAccessibilityNodeInfo(view, r0Var.a);
        RecyclerView recyclerView = this.j;
        if (recyclerView.S() || recyclerView.getLayoutManager() == null) {
            return;
        }
        u81 layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.b;
        layoutManager.W(recyclerView2.i, recyclerView2.n0, r0Var);
    }

    @Override // defpackage.e0
    public final boolean g(View view, int i, Bundle bundle) {
        if (super.g(view, i, bundle)) {
            return true;
        }
        RecyclerView recyclerView = this.j;
        if (recyclerView.S() || recyclerView.getLayoutManager() == null) {
            return false;
        }
        u81 layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.b;
        return layoutManager.j0(recyclerView2.i, recyclerView2.n0, i, bundle);
    }

    public e0 j() {
        return this.k;
    }
}
