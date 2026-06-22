package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class bp implements xo {
    public final jj0 g;
    public final xo h;

    /* JADX WARN: Multi-variable type inference failed */
    public bp(xo xoVar, o70 o70Var) {
        qg0.l(xoVar, "baseKey");
        this.g = (jj0) o70Var;
        this.h = xoVar instanceof bp ? ((bp) xoVar).h : xoVar;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [jj0, o70] */
    public final wo a(cp cpVar) {
        return (wo) this.g.invoke(cpVar);
    }
}
