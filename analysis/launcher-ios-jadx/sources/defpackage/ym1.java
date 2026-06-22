package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;

/* JADX INFO: loaded from: classes.dex */
public final class ym1 extends n90 {
    public final /* synthetic */ Context m;
    public final /* synthetic */ TextPaint n;
    public final /* synthetic */ n90 o;
    public final /* synthetic */ zm1 p;

    public ym1(zm1 zm1Var, Context context, TextPaint textPaint, n90 n90Var) {
        this.p = zm1Var;
        this.m = context;
        this.n = textPaint;
        this.o = n90Var;
    }

    @Override // defpackage.n90
    public final void A(int i) {
        this.o.A(i);
    }

    @Override // defpackage.n90
    public final void B(Typeface typeface, boolean z) {
        this.p.g(this.m, this.n, typeface);
        this.o.B(typeface, z);
    }
}
