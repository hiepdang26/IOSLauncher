package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class mg implements View.OnAttachStateChangeListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ mg(Object obj, int i) {
        this.g = i;
        this.h = obj;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        Object obj = this.h;
        switch (this.g) {
            case 1:
                ((ux) obj).f();
                break;
            case 2:
                View view2 = (View) obj;
                view2.removeOnAttachStateChangeListener(this);
                WeakHashMap weakHashMap = qs1.a;
                fs1.c(view2);
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        switch (this.g) {
            case 0:
                pg pgVar = (pg) this.h;
                ViewTreeObserver viewTreeObserver = pgVar.E;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        pgVar.E = view.getViewTreeObserver();
                    }
                    pgVar.E.removeGlobalOnLayoutListener(pgVar.p);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 1:
                ux uxVar = (ux) this.h;
                AccessibilityManager accessibilityManager = uxVar.q;
                if (accessibilityManager != null) {
                    accessibilityManager.removeTouchExplorationStateChangeListener(new f0(uxVar.k));
                }
                break;
            case 2:
                break;
            default:
                xi1 xi1Var = (xi1) this.h;
                ViewTreeObserver viewTreeObserver2 = xi1Var.v;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        xi1Var.v = view.getViewTreeObserver();
                    }
                    xi1Var.v.removeGlobalOnLayoutListener(xi1Var.p);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
        }
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }

    private final void c(View view) {
    }
}
