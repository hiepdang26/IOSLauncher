package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class pl0 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ hl0 h;
    public final /* synthetic */ ql0 i;

    public /* synthetic */ pl0(ql0 ql0Var, hl0 hl0Var, int i) {
        this.g = i;
        this.i = ql0Var;
        this.h = hl0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                hl0 hl0VarL = this.i.p.l();
                hl0 hl0Var = this.h;
                if (hl0Var == hl0VarL && hl0VarL != null) {
                    hl0Var.notifyWidgetProvidersChanged();
                    break;
                }
                break;
            default:
                ql0 ql0Var = this.i;
                hl0 hl0VarL2 = ql0Var.p.l();
                hl0 hl0Var2 = this.h;
                if (hl0Var2 == hl0VarL2 && hl0VarL2 != null) {
                    hl0Var2.onAllAppsChanged((ArrayList) ql0Var.p.r.g);
                    break;
                }
                break;
        }
    }
}
