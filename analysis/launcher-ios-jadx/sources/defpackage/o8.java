package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class o8 implements View.OnClickListener {
    public final /* synthetic */ p8 g;

    public o8(p8 p8Var) {
        this.g = p8Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p8 p8Var = this.g;
        se1 se1Var = p8Var.C.l;
        if (se1Var != null) {
            se1Var.h(p8Var.B);
        }
    }
}
