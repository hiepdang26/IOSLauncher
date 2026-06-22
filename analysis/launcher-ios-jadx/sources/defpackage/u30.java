package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class u30 implements View.OnClickListener {
    public final /* synthetic */ z30 g;

    public u30(z30 z30Var) {
        this.g = z30Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z30 z30Var = this.g;
        z30Var.d();
        y30 y30Var = z30Var.N;
        if (y30Var != null) {
            y30Var.onShakingAllApps();
        }
    }
}
