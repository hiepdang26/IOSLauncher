package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class fn0 {
    public vm0 a;
    public an0 b;

    public final void a(en0 en0Var, um0 um0Var) {
        vm0 vm0VarA = um0Var.a();
        vm0 vm0Var = this.a;
        qg0.l(vm0Var, "state1");
        if (vm0VarA.compareTo(vm0Var) < 0) {
            vm0Var = vm0VarA;
        }
        this.a = vm0Var;
        this.b.a(en0Var, um0Var);
        this.a = vm0VarA;
    }
}
