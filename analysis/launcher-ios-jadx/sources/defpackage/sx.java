package defpackage;

import android.view.View;
import android.widget.AutoCompleteTextView;

/* JADX INFO: loaded from: classes.dex */
public final class sx implements View.OnClickListener {
    public final /* synthetic */ ux g;

    public sx(ux uxVar) {
        this.g = uxVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ux uxVar = this.g;
        ux.d(uxVar, (AutoCompleteTextView) uxVar.a.getEditText());
    }
}
