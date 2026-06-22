package defpackage;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes.dex */
public final class xm1 extends qb1 {
    public final /* synthetic */ n90 a;
    public final /* synthetic */ zm1 b;

    public xm1(zm1 zm1Var, n90 n90Var) {
        this.b = zm1Var;
        this.a = n90Var;
    }

    @Override // defpackage.qb1
    public final void onFontRetrievalFailed(int i) {
        this.b.m = true;
        this.a.A(i);
    }

    @Override // defpackage.qb1
    public final void onFontRetrieved(Typeface typeface) {
        zm1 zm1Var = this.b;
        zm1Var.n = Typeface.create(typeface, zm1Var.c);
        zm1Var.m = true;
        this.a.B(zm1Var.n, false);
    }
}
