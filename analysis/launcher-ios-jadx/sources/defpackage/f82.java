package defpackage;

import com.google.ads.mediation.AbstractAdViewAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class f82 extends a70 {
    public final AbstractAdViewAdapter a;
    public final xs0 b;

    public f82(AbstractAdViewAdapter abstractAdViewAdapter, xs0 xs0Var) {
        this.a = abstractAdViewAdapter;
        this.b = xs0Var;
    }

    @Override // defpackage.a70
    public final void b() {
        this.b.onAdClosed(this.a);
    }

    @Override // defpackage.a70
    public final void e() {
        this.b.onAdOpened(this.a);
    }
}
