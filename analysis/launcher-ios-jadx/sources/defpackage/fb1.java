package defpackage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class fb1 implements es, bs {
    public final ss g;
    public final qs h;
    public int i;
    public int j = -1;
    public bj0 k;
    public List l;
    public int m;
    public volatile ku0 n;
    public File o;
    public gb1 p;

    public fb1(qs qsVar, ss ssVar) {
        this.h = qsVar;
        this.g = ssVar;
    }

    @Override // defpackage.es
    public final boolean b() {
        List list;
        boolean z;
        List list2;
        ArrayList arrayListA = this.h.a();
        if (arrayListA.isEmpty()) {
            return false;
        }
        qs qsVar = this.h;
        x91 x91VarB = qsVar.c.b();
        Class<?> cls = qsVar.d.getClass();
        Class cls2 = qsVar.g;
        Class cls3 = qsVar.k;
        oz1 oz1Var = x91VarB.h;
        tu0 tu0Var = (tu0) ((AtomicReference) oz1Var.h).getAndSet(null);
        if (tu0Var == null) {
            tu0Var = new tu0(cls, cls2, cls3);
        } else {
            tu0Var.a = cls;
            tu0Var.b = cls2;
            tu0Var.c = cls3;
        }
        synchronized (((e9) oz1Var.i)) {
            list = (List) ((e9) oz1Var.i).get(tu0Var);
        }
        ((AtomicReference) oz1Var.h).set(tu0Var);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayListF = x91VarB.a.F(cls);
            int size = arrayListF.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayListF.get(i);
                i++;
                ArrayList arrayListH = x91VarB.c.H((Class) obj, cls2);
                int size2 = arrayListH.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayListH.get(i2);
                    i2++;
                    Class cls4 = (Class) obj2;
                    if (!x91VarB.f.b(cls4, cls3).isEmpty() && !arrayList.contains(cls4)) {
                        arrayList.add(cls4);
                    }
                }
            }
            z = false;
            x91VarB.h.i(cls, cls2, cls3, Collections.unmodifiableList(arrayList));
            list2 = arrayList;
        } else {
            z = false;
            list2 = list;
        }
        if (list2.isEmpty()) {
            if (File.class.equals(this.h.k)) {
                return z;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.h.d.getClass() + " to " + this.h.k);
        }
        while (true) {
            List list3 = this.l;
            if (list3 != null && this.m < list3.size()) {
                this.n = null;
                boolean z2 = false;
                while (!z2 && this.m < this.l.size()) {
                    List list4 = this.l;
                    int i3 = this.m;
                    this.m = i3 + 1;
                    lu0 lu0Var = (lu0) list4.get(i3);
                    File file = this.o;
                    qs qsVar2 = this.h;
                    this.n = lu0Var.b(file, qsVar2.e, qsVar2.f, qsVar2.i);
                    if (this.n != null && this.h.c(this.n.c.a()) != null) {
                        this.n.c.c(this.h.o, this);
                        z2 = true;
                    }
                }
                return z2;
            }
            int i4 = this.j + 1;
            this.j = i4;
            if (i4 >= list2.size()) {
                int i5 = this.i + 1;
                this.i = i5;
                if (i5 >= arrayListA.size()) {
                    return z;
                }
                this.j = 0;
            }
            bj0 bj0Var = (bj0) arrayListA.get(this.i);
            Class cls5 = (Class) list2.get(this.j);
            ro1 ro1VarE = this.h.e(cls5);
            qs qsVar3 = this.h;
            this.p = new gb1(qsVar3.c.a, bj0Var, qsVar3.n, qsVar3.e, qsVar3.f, ro1VarE, cls5, qsVar3.i);
            File fileE = qsVar3.h.a().e(this.p);
            this.o = fileE;
            if (fileE != null) {
                this.k = bj0Var;
                this.l = this.h.c.b().g(fileE);
                this.m = 0;
            }
            z = false;
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
        this.g.a(this.p, exc, this.n.c, 4);
    }

    @Override // defpackage.bs
    public final void g(Object obj) {
        this.g.c(this.k, obj, this.n.c, 4, this.p);
    }
}
