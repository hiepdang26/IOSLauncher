package defpackage;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class dr0 extends LinearLayoutManager {
    public final /* synthetic */ int E;
    public final /* synthetic */ ir0 F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dr0(ir0 ir0Var, int i, int i2) {
        super(i);
        this.F = ir0Var;
        this.E = i2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.u81
    public final void B0(RecyclerView recyclerView, int i) {
        zh1 zh1Var = new zh1(recyclerView.getContext(), 0);
        zh1Var.a = i;
        C0(zh1Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void E0(i91 i91Var, int[] iArr) {
        int i = this.E;
        ir0 ir0Var = this.F;
        if (i == 0) {
            iArr[0] = ir0Var.g0.getWidth();
            iArr[1] = ir0Var.g0.getWidth();
        } else {
            iArr[0] = ir0Var.g0.getHeight();
            iArr[1] = ir0Var.g0.getHeight();
        }
    }
}
