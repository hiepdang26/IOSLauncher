package defpackage;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class zt1 {
    public final WeakReference a;

    public zt1(View view) {
        this.a = new WeakReference(view);
    }

    public final void a(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
    }

    public final void b() {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
    }

    public final void d(cu1 cu1Var) {
        View view = (View) this.a.get();
        if (view != null) {
            if (cu1Var != null) {
                view.animate().setListener(new um(cu1Var, view, 7));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void e() {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public final void f(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
    }
}
