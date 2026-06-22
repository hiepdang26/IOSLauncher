package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class av0 implements cs, bs {
    public final ArrayList g;
    public final wb2 h;
    public int i;
    public j31 j;
    public bs k;
    public List l;
    public boolean m;

    public av0(ArrayList arrayList, wb2 wb2Var) {
        this.h = wb2Var;
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.g = arrayList;
        this.i = 0;
    }

    @Override // defpackage.cs
    public final Class a() {
        return ((cs) this.g.get(0)).a();
    }

    @Override // defpackage.cs
    public final void b() {
        List list = this.l;
        if (list != null) {
            this.h.z(list);
        }
        this.l = null;
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((cs) obj).b();
        }
    }

    @Override // defpackage.cs
    public final void c(j31 j31Var, bs bsVar) {
        this.j = j31Var;
        this.k = bsVar;
        this.l = (List) this.h.h();
        ((cs) this.g.get(this.i)).c(j31Var, this);
        if (this.m) {
            cancel();
        }
    }

    @Override // defpackage.cs
    public final void cancel() {
        this.m = true;
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((cs) obj).cancel();
        }
    }

    @Override // defpackage.cs
    public final int d() {
        return ((cs) this.g.get(0)).d();
    }

    @Override // defpackage.bs
    public final void e(Exception exc) {
        List list = this.l;
        n90.h(list, "Argument must not be null");
        list.add(exc);
        f();
    }

    public final void f() {
        if (this.m) {
            return;
        }
        if (this.i < this.g.size() - 1) {
            this.i++;
            c(this.j, this.k);
        } else {
            n90.g(this.l);
            this.k.e(new q90("Fetch failed", new ArrayList(this.l)));
        }
    }

    @Override // defpackage.bs
    public final void g(Object obj) {
        if (obj != null) {
            this.k.g(obj);
        } else {
            f();
        }
    }
}
