package defpackage;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d30 implements p60 {
    public final Set g = Collections.newSetFromMap(new WeakHashMap());
    public volatile boolean h;

    @Override // defpackage.p60
    public final void q(e6 e6Var) {
        if (!this.h && this.g.add(e6Var)) {
            View decorView = e6Var.getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnDrawListener(new c30(this, decorView));
        }
    }
}
