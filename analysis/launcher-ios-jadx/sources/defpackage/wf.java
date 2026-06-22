package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class wf extends a0 {
    public final /* synthetic */ xf n;

    public wf(xf xfVar) {
        this.n = xfVar;
    }

    @Override // defpackage.a0
    public final String f() {
        vf vfVar = (vf) this.n.g.get();
        if (vfVar == null) {
            return "Completer object has been garbage collected, future will fail soon";
        }
        return "tag=[" + vfVar.a + "]";
    }
}
