package defpackage;

import android.widget.AutoCompleteTextView;

/* JADX INFO: loaded from: classes.dex */
public final class px implements AutoCompleteTextView.OnDismissListener {
    public final /* synthetic */ ux a;

    public px(ux uxVar) {
        this.a = uxVar;
    }

    @Override // android.widget.AutoCompleteTextView.OnDismissListener
    public final void onDismiss() {
        ux uxVar = this.a;
        uxVar.l = true;
        uxVar.n = System.currentTimeMillis();
        uxVar.i(false);
    }
}
