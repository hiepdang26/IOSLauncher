package defpackage;

import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zr implements es, bs {
    public final List g;
    public final qs h;
    public final ds i;
    public int j = -1;
    public bj0 k;
    public List l;
    public int m;
    public volatile ku0 n;
    public File o;

    public zr(List list, qs qsVar, ds dsVar) {
        this.g = list;
        this.h = qsVar;
        this.i = dsVar;
    }

    @Override // defpackage.es
    public final boolean b() {
        while (true) {
            List list = this.l;
            boolean z = false;
            if (list != null && this.m < list.size()) {
                this.n = null;
                while (!z && this.m < this.l.size()) {
                    List list2 = this.l;
                    int i = this.m;
                    this.m = i + 1;
                    lu0 lu0Var = (lu0) list2.get(i);
                    File file = this.o;
                    qs qsVar = this.h;
                    this.n = lu0Var.b(file, qsVar.e, qsVar.f, qsVar.i);
                    if (this.n != null && this.h.c(this.n.c.a()) != null) {
                        this.n.c.c(this.h.o, this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.j + 1;
            this.j = i2;
            if (i2 >= this.g.size()) {
                return false;
            }
            bj0 bj0Var = (bj0) this.g.get(this.j);
            qs qsVar2 = this.h;
            File fileE = qsVar2.h.a().e(new as(bj0Var, qsVar2.n));
            this.o = fileE;
            if (fileE != null) {
                this.k = bj0Var;
                this.l = this.h.c.b().g(fileE);
                this.m = 0;
            }
        }
    }

    @Override // defpackage.es
    public final void cancel() {
        ku0 ku0Var = this.n;
        if (ku0Var != null) {
            ku0Var.c.cancel();
        }
    }

    @Override // defpackage.bs
    public final void e(Exception exc) {
        this.i.a(this.k, exc, this.n.c, 3);
    }

    @Override // defpackage.bs
    public final void g(Object obj) {
        this.i.c(this.k, obj, this.n.c, 3, this.k);
    }
}
