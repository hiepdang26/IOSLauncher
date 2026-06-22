package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class mo0 implements View.OnClickListener {
    public final /* synthetic */ no0 g;

    public mo0(no0 no0Var) {
        this.g = no0Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.g.d().onBackPressed();
    }
}
