package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class si implements View.OnClickListener {
    public final /* synthetic */ wi g;

    public si(wi wiVar, ui uiVar) {
        this.g = wiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.g.m.finish();
    }
}
