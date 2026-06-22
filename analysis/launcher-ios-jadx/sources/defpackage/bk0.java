package defpackage;

import com.luutinhit.launcher6.Workspace;
import com.luutinhit.launcher6.t;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class bk0 implements Runnable {
    public final /* synthetic */ qh0 g;
    public final /* synthetic */ long h;
    public final /* synthetic */ int[] i;
    public final /* synthetic */ dk0 j;

    public bk0(dk0 dk0Var, qh0 qh0Var, long j, int[] iArr) {
        this.j = dk0Var;
        this.g = qh0Var;
        this.h = j;
        this.i = iArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        qh0 qh0Var = this.g;
        boolean z = qh0Var instanceof v6;
        dk0 dk0Var = this.j;
        int[] iArr = this.i;
        t tVar = dk0Var.h;
        if (z) {
            og1 og1VarI = ((v6) qh0Var).i();
            int i = iArr[0];
            int i2 = iArr[1];
            rl0.b(dk0Var.h, og1VarI, -100L, this.h, i, i2);
            ArrayList<qh0> arrayList = new ArrayList<>();
            arrayList.add(og1VarI);
            tVar.bindItems(arrayList, 0, arrayList.size(), true);
        } else if (qh0Var instanceof u11) {
            u11 u11Var = (u11) qh0Var;
            Workspace workspace = tVar.getWorkspace();
            workspace.Z(workspace.E0(this.h));
            int i3 = u11Var.m;
            int i4 = u11Var.n;
            dk0Var.h.addPendingItem(u11Var, -100L, this.h, iArr, i3, i4);
        }
        tVar.getDragLayer().announceForAccessibility(tVar.getResources().getString(w61.item_added_to_workspace));
    }
}
