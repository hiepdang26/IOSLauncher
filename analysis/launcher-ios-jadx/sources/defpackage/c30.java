package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class c30 implements ViewTreeObserver.OnDrawListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ d30 b;

    public c30(d30 d30Var, View view) {
        this.b = d30Var;
        this.a = view;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        vq1.f().post(new w1(this, this, 16, false));
    }
}
