package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ki1 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ li1 h;
    public final /* synthetic */ cu i;

    public /* synthetic */ ki1(cu cuVar, li1 li1Var, int i) {
        this.g = i;
        this.i = cuVar;
        this.h = li1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                ArrayList arrayList = this.i.b;
                li1 li1Var = this.h;
                if (arrayList.contains(li1Var)) {
                    k31.a(li1Var.a, li1Var.c.L);
                }
                break;
            default:
                cu cuVar = this.i;
                ArrayList arrayList2 = cuVar.b;
                li1 li1Var2 = this.h;
                arrayList2.remove(li1Var2);
                cuVar.c.remove(li1Var2);
                break;
        }
    }
}
