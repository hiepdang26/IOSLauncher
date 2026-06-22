package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class n91 extends e0 {
    public final o91 j;
    public final WeakHashMap k = new WeakHashMap();

    public n91(o91 o91Var) {
        this.j = o91Var;
    }

    @Override // defpackage.e0
    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        e0 e0Var = (e0) this.k.get(view);
        return e0Var != null ? e0Var.a(view, accessibilityEvent) : this.g.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // defpackage.e0
    public final ow1 b(View view) {
        e0 e0Var = (e0) this.k.get(view);
        return e0Var != null ? e0Var.b(view) : super.b(view);
    }

    @Override // defpackage.e0
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        e0 e0Var = (e0) this.k.get(view);
        if (e0Var != null) {
            e0Var.c(view, accessibilityEvent);
        } else {
            super.c(view, accessibilityEvent);
        }
    }

    @Override // defpackage.e0
    public final void d(View view, r0 r0Var) {
        o91 o91Var = this.j;
        boolean zS = o91Var.j.S();
        View.AccessibilityDelegate accessibilityDelegate = this.g;
        AccessibilityNodeInfo accessibilityNodeInfo = r0Var.a;
        if (!zS) {
            RecyclerView recyclerView = o91Var.j;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().Y(view, r0Var);
                e0 e0Var = (e0) this.k.get(view);
                if (e0Var != null) {
                    e0Var.d(view, r0Var);
                    return;
                } else {
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    return;
                }
            }
        }
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
    }

    @Override // defpackage.e0
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        e0 e0Var = (e0) this.k.get(view);
        if (e0Var != null) {
            e0Var.e(view, accessibilityEvent);
        } else {
            super.e(view, accessibilityEvent);
        }
    }

    @Override // defpackage.e0
    public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        e0 e0Var = (e0) this.k.get(viewGroup);
        return e0Var != null ? e0Var.f(viewGroup, view, accessibilityEvent) : this.g.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // defpackage.e0
    public final boolean g(View view, int i, Bundle bundle) {
        o91 o91Var = this.j;
        if (!o91Var.j.S()) {
            RecyclerView recyclerView = o91Var.j;
            if (recyclerView.getLayoutManager() != null) {
                e0 e0Var = (e0) this.k.get(view);
                if (e0Var != null) {
                    if (e0Var.g(view, i, bundle)) {
                        return true;
                    }
                } else if (super.g(view, i, bundle)) {
                    return true;
                }
                c91 c91Var = recyclerView.getLayoutManager().b.i;
                return false;
            }
        }
        return super.g(view, i, bundle);
    }

    @Override // defpackage.e0
    public final void h(View view, int i) {
        e0 e0Var = (e0) this.k.get(view);
        if (e0Var != null) {
            e0Var.h(view, i);
        } else {
            super.h(view, i);
        }
    }

    @Override // defpackage.e0
    public final void i(View view, AccessibilityEvent accessibilityEvent) {
        e0 e0Var = (e0) this.k.get(view);
        if (e0Var != null) {
            e0Var.i(view, accessibilityEvent);
        } else {
            super.i(view, accessibilityEvent);
        }
    }
}
