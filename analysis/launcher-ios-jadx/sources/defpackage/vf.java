package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class vf {
    public Object a;
    public xf b;
    public db1 c;
    public boolean d;

    public final void finalize() {
        db1 db1Var;
        xf xfVar = this.b;
        if (xfVar != null) {
            wf wfVar = xfVar.h;
            if (!wfVar.isDone()) {
                wfVar.h(new i("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.a, 2));
            }
        }
        if (this.d || (db1Var = this.c) == null) {
            return;
        }
        db1Var.i(null);
    }
}
