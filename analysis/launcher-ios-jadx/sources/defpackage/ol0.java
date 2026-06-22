package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ol0 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ hl0 h;
    public final /* synthetic */ ArrayList i;
    public final /* synthetic */ ql0 j;

    public /* synthetic */ ol0(ql0 ql0Var, hl0 hl0Var, ArrayList arrayList, int i) {
        this.g = i;
        this.j = ql0Var;
        this.h = hl0Var;
        this.i = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                hl0 hl0VarL = this.j.p.l();
                hl0 hl0Var = this.h;
                if (hl0Var == hl0VarL && hl0VarL != null) {
                    hl0Var.bindAppsUpdated(this.i);
                    break;
                }
                break;
            case 1:
                hl0 hl0VarL2 = this.j.p.l();
                hl0 hl0Var2 = this.h;
                if (hl0Var2 == hl0VarL2 && hl0VarL2 != null) {
                    hl0Var2.bindWidgetsRestored(this.i);
                    break;
                }
                break;
            default:
                hl0 hl0VarL3 = this.j.p.l();
                hl0 hl0Var3 = this.h;
                if (hl0Var3 == hl0VarL3 && hl0VarL3 != null) {
                    hl0Var3.bindAppInfosRemoved(this.i);
                    break;
                }
                break;
        }
    }
}
