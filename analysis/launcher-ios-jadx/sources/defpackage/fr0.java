package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class fr0 implements View.OnClickListener {
    public final /* synthetic */ ir0 g;

    public fr0(ir0 ir0Var) {
        this.g = ir0Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ir0 ir0Var = this.g;
        int i = ir0Var.d0;
        if (i == 2) {
            ir0Var.V(1);
        } else if (i == 1) {
            ir0Var.V(2);
        }
    }
}
