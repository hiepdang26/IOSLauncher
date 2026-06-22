package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class al0 implements View.OnLongClickListener {
    public final /* synthetic */ bl0 g;

    public al0(bl0 bl0Var) {
        this.g = bl0Var;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        bl0 bl0Var = this.g;
        bl0Var.g.showOverviewMode(true);
        bl0Var.g.getWorkspace().post(new zk0(bl0Var, 1));
        return true;
    }
}
