package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class cl0 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ hl0 h;
    public final /* synthetic */ ArrayList i;
    public final /* synthetic */ rl0 j;

    public /* synthetic */ cl0(rl0 rl0Var, hl0 hl0Var, ArrayList arrayList, int i) {
        this.g = i;
        this.j = rl0Var;
        this.h = hl0Var;
        this.i = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                hl0 hl0VarL = this.j.l();
                if (hl0VarL != null && this.h == hl0VarL) {
                    hl0VarL.bindAppsUpdated(this.i);
                    break;
                }
                break;
            case 1:
                hl0 hl0VarL2 = this.j.l();
                if (hl0VarL2 != null && this.h == hl0VarL2) {
                    hl0VarL2.bindAppsUpdated(this.i);
                    break;
                }
                break;
            default:
                this.j.x(new fl0(this, 0));
                break;
        }
    }
}
