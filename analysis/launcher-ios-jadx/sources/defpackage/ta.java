package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class ta implements View.OnClickListener {
    public final /* synthetic */ ua g;

    public ta(ua uaVar) {
        this.g = uaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.g.onBackPressed();
    }
}
