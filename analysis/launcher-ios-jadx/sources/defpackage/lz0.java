package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class lz0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public final View g;
    public ViewTreeObserver h;
    public final Runnable i;

    public lz0(View view, Runnable runnable) {
        this.g = view;
        this.h = view.getViewTreeObserver();
        this.i = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        lz0 lz0Var = new lz0(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(lz0Var);
        view.addOnAttachStateChangeListener(lz0Var);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean zIsAlive = this.h.isAlive();
        View view = this.g;
        if (zIsAlive) {
            this.h.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
        this.i.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.h = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        boolean zIsAlive = this.h.isAlive();
        View view2 = this.g;
        if (zIsAlive) {
            this.h.removeOnPreDrawListener(this);
        } else {
            view2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view2.removeOnAttachStateChangeListener(this);
    }
}
