package com.google.ads.mediation;

import defpackage.f82;
import defpackage.og0;
import defpackage.pg0;
import defpackage.xo0;
import defpackage.xs0;

/* JADX INFO: loaded from: classes.dex */
public final class a extends pg0 {
    public final AbstractAdViewAdapter a;
    public final xs0 b;

    public a(AbstractAdViewAdapter abstractAdViewAdapter, xs0 xs0Var) {
        this.a = abstractAdViewAdapter;
        this.b = xs0Var;
    }

    @Override // defpackage.k2
    public final void onAdFailedToLoad(xo0 xo0Var) {
        this.b.onAdFailedToLoad(this.a, xo0Var);
    }

    @Override // defpackage.k2
    public final /* bridge */ /* synthetic */ void onAdLoaded(Object obj) {
        og0 og0Var = (og0) obj;
        AbstractAdViewAdapter abstractAdViewAdapter = this.a;
        abstractAdViewAdapter.mInterstitialAd = og0Var;
        xs0 xs0Var = this.b;
        og0Var.setFullScreenContentCallback(new f82(abstractAdViewAdapter, xs0Var));
        xs0Var.onAdLoaded(abstractAdViewAdapter);
    }
}
