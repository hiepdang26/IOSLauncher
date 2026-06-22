package defpackage;

import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
public final class st0 implements PopupWindow.OnDismissListener {
    public final /* synthetic */ tt0 g;

    public st0(tt0 tt0Var) {
        this.g = tt0Var;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.g.onDismiss();
    }
}
