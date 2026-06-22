package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class re1 implements View.OnClickListener {
    public final /* synthetic */ ue1 g;

    public re1(ue1 ue1Var) {
        this.g = ue1Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o5 o5Var = this.g.m;
        if (o5Var != null) {
            o5Var.h(view);
        }
    }
}
