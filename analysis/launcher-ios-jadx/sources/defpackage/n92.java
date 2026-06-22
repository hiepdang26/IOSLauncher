package defpackage;

import com.google.ads.mediation.AbstractAdViewAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class n92 extends j2 implements hb2, va2, ha2 {
    public final AbstractAdViewAdapter g;
    public final zs0 h;

    public n92(AbstractAdViewAdapter abstractAdViewAdapter, zs0 zs0Var) {
        this.g = abstractAdViewAdapter;
        this.h = zs0Var;
    }

    @Override // defpackage.j2
    public final void onAdClicked() {
        this.h.onAdClicked(this.g);
    }

    @Override // defpackage.j2
    public final void onAdClosed() {
        this.h.onAdClosed(this.g);
    }

    @Override // defpackage.j2
    public final void onAdFailedToLoad(xo0 xo0Var) {
        this.h.onAdFailedToLoad(this.g, xo0Var);
    }

    @Override // defpackage.j2
    public final void onAdImpression() {
        this.h.onAdImpression(this.g);
    }

    @Override // defpackage.j2
    public final void onAdOpened() {
        this.h.onAdOpened(this.g);
    }

    @Override // defpackage.j2
    public final void onAdLoaded() {
    }
}
