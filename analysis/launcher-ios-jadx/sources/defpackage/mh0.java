package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class mh0 implements View.OnClickListener {
    public final /* synthetic */ oh0 g;
    public final /* synthetic */ y00 h;

    public mh0(y00 y00Var, oh0 oh0Var) {
        this.h = y00Var;
        this.g = oh0Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int iE = this.g.e();
        y00 y00Var = this.h;
        Object obj = y00Var.k;
        y00Var.a(iE);
    }
}
