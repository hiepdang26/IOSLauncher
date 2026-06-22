package defpackage;

import android.net.Uri;
import android.view.InputEvent;

/* JADX INFO: loaded from: classes.dex */
public final class es0 extends fs0 {
    public final as0 a;

    public es0(as0 as0Var) {
        this.a = as0Var;
    }

    @Override // defpackage.fs0
    public do0 a(Uri uri, InputEvent inputEvent) {
        qg0.l(uri, "attributionSource");
        return np1.a(np1.b(m90.a(aw.a), new cs0(this, uri, inputEvent, null)));
    }

    public do0 b(pu puVar) {
        qg0.l(puVar, "deletionRequest");
        throw null;
    }

    public do0 c() {
        return np1.a(np1.b(m90.a(aw.a), new bs0(this, null)));
    }

    public do0 d(Uri uri) {
        qg0.l(uri, "trigger");
        return np1.a(np1.b(m90.a(aw.a), new ds0(this, uri, null)));
    }

    public do0 e(qw1 qw1Var) {
        qg0.l(qw1Var, "request");
        throw null;
    }

    public do0 f(rw1 rw1Var) {
        qg0.l(rw1Var, "request");
        throw null;
    }
}
