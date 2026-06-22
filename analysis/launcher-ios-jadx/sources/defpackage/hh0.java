package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class hh0 implements View.OnClickListener {
    public final /* synthetic */ jh0 g;
    public final /* synthetic */ kh0 h;

    public hh0(kh0 kh0Var, jh0 jh0Var) {
        this.h = kh0Var;
        this.g = jh0Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iE = this.g.e();
        kh0 kh0Var = this.h;
        String str = kh0Var.j;
        kh0Var.a(iE);
    }
}
