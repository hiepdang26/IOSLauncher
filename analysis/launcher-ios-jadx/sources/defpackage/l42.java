package defpackage;

import com.google.ads.mediation.AbstractAdViewAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class l42 extends j2 implements u6, b22 {
    public final AbstractAdViewAdapter g;
    public final ts0 h;

    public l42(AbstractAdViewAdapter abstractAdViewAdapter, ts0 ts0Var) {
        this.g = abstractAdViewAdapter;
        this.h = ts0Var;
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
    public final void onAdLoaded() {
        this.h.onAdLoaded(this.g);
    }

    @Override // defpackage.j2
    public final void onAdOpened() {
        this.h.onAdOpened(this.g);
    }

    @Override // defpackage.u6
    public final void onAppEvent(String str, String str2) {
        this.h.zzb(this.g, str, str2);
    }
}
