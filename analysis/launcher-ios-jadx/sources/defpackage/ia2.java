package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class ia2 implements View.OnClickListener {
    public final /* synthetic */ yb2 g;

    public ia2(yb2 yb2Var) {
        this.g = yb2Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        yb2 yb2Var = this.g;
        yb2Var.B = 2;
        yb2Var.g.finish();
    }
}
