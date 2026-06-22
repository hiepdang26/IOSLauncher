package defpackage;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class m81 {
    public final n81 g = new n81();
    public boolean h = false;
    public final int i = 1;

    public abstract int c();

    public long d(int i) {
        return -1L;
    }

    public int e(int i) {
        return 0;
    }

    public final void f() {
        this.g.b();
    }

    public final void g(int i) {
        this.g.d(i, 1, null);
    }

    public abstract void i(m91 m91Var, int i);

    public abstract m91 j(ViewGroup viewGroup, int i);

    public boolean k(m91 m91Var) {
        return this instanceof px1;
    }

    public final void o(boolean z) {
        if (this.g.a()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.h = z;
    }

    public void h(RecyclerView recyclerView) {
    }

    public void l(m91 m91Var) {
    }

    public void m(m91 m91Var) {
    }

    public void n(m91 m91Var) {
    }
}
