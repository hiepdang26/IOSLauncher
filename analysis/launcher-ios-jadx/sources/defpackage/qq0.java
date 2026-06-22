package defpackage;

import android.os.Build;
import android.view.View;
import java.nio.ByteBuffer;
import java.util.ConcurrentModificationException;

/* JADX INFO: loaded from: classes.dex */
public abstract class qq0 {
    public int g;
    public int h;
    public int i;
    public Object j;

    public qq0() {
        if (m21.g == null) {
            m21.g = new m21();
        }
    }

    public int a(int i) {
        if (i < this.i) {
            return ((ByteBuffer) this.j).getShort(this.h + i);
        }
        return 0;
    }

    public void b() {
        if (((rq0) this.j).n != this.i) {
            throw new ConcurrentModificationException();
        }
    }

    public abstract Object c(View view);

    public abstract void d(View view, Object obj);

    public void e() {
        while (true) {
            int i = this.g;
            rq0 rq0Var = (rq0) this.j;
            if (i >= rq0Var.l || rq0Var.i[i] >= 0) {
                return;
            } else {
                this.g = i + 1;
            }
        }
    }

    public void f(View view, Object obj) {
        Object tag;
        if (Build.VERSION.SDK_INT >= this.h) {
            d(view, obj);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.h) {
            tag = c(view);
        } else {
            tag = view.getTag(this.g);
            if (!((Class) this.j).isInstance(tag)) {
                tag = null;
            }
        }
        if (g(tag, obj)) {
            View.AccessibilityDelegate accessibilityDelegateD = qs1.d(view);
            e0 e0Var = accessibilityDelegateD == null ? null : accessibilityDelegateD instanceof d0 ? ((d0) accessibilityDelegateD).a : new e0(accessibilityDelegateD);
            if (e0Var == null) {
                e0Var = new e0();
            }
            qs1.p(view, e0Var);
            view.setTag(this.g, obj);
            qs1.h(this.i, view);
        }
    }

    public abstract boolean g(Object obj, Object obj2);

    public boolean hasNext() {
        return this.g < ((rq0) this.j).l;
    }

    public void remove() {
        b();
        if (this.h == -1) {
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
        rq0 rq0Var = (rq0) this.j;
        rq0Var.c();
        rq0Var.l(this.h);
        this.h = -1;
        this.i = rq0Var.n;
    }
}
