package defpackage;

import com.luutinhit.launcher6.t;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class vj0 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ ArrayList h;
    public final /* synthetic */ ArrayList i;
    public final /* synthetic */ jq1 j;
    public final /* synthetic */ t k;

    public /* synthetic */ vj0(t tVar, ArrayList arrayList, ArrayList arrayList2, jq1 jq1Var, int i) {
        this.g = i;
        this.k = tVar;
        this.h = arrayList;
        this.i = arrayList2;
        this.j = jq1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                this.k.bindShortcutsChanged(this.h, this.i, this.j);
                break;
            default:
                this.k.bindShortcutsHidden(this.h, this.i, this.j);
                break;
        }
    }
}
