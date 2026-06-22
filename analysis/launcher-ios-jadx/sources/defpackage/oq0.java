package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class oq0 extends qq0 implements Iterator {
    public final /* synthetic */ int k;

    public oq0(rq0 rq0Var, int i) {
        this.k = i;
        qg0.l(rq0Var, "map");
        this.j = rq0Var;
        this.h = -1;
        this.i = rq0Var.n;
        e();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.k) {
            case 0:
                b();
                int i = this.g;
                rq0 rq0Var = (rq0) this.j;
                if (i >= rq0Var.l) {
                    throw new NoSuchElementException();
                }
                this.g = i + 1;
                this.h = i;
                pq0 pq0Var = new pq0(rq0Var, i);
                e();
                return pq0Var;
            case 1:
                b();
                int i2 = this.g;
                rq0 rq0Var2 = (rq0) this.j;
                if (i2 >= rq0Var2.l) {
                    throw new NoSuchElementException();
                }
                this.g = i2 + 1;
                this.h = i2;
                Object obj = rq0Var2.g[i2];
                e();
                return obj;
            default:
                b();
                int i3 = this.g;
                rq0 rq0Var3 = (rq0) this.j;
                if (i3 >= rq0Var3.l) {
                    throw new NoSuchElementException();
                }
                this.g = i3 + 1;
                this.h = i3;
                Object[] objArr = rq0Var3.h;
                qg0.h(objArr);
                Object obj2 = objArr[this.h];
                e();
                return obj2;
        }
    }
}
