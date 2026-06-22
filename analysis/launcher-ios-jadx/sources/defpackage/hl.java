package defpackage;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class hl extends sd1 {
    public final el g;
    public final el h;
    public final jl i;
    public volatile boolean j;

    public hl(jl jlVar) {
        this.i = jlVar;
        el elVar = new el(1);
        el elVar2 = new el(0);
        this.g = elVar2;
        el elVar3 = new el(1);
        this.h = elVar3;
        elVar3.a(elVar);
        elVar3.a(elVar2);
    }

    @Override // defpackage.sd1
    public final cw a(rd1 rd1Var) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return this.j ? tz.g : this.i.c(rd1Var, this.g);
    }

    @Override // defpackage.cw
    public final void b() {
        if (this.j) {
            return;
        }
        this.j = true;
        this.h.b();
    }
}
