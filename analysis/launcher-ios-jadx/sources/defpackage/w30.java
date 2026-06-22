package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class w30 implements View.OnClickListener {
    public final /* synthetic */ w1 g;

    public w30(w1 w1Var) {
        this.g = w1Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w1 w1Var = this.g;
        int appWidgetId = ((pk0) w1Var.h).getAppWidgetId();
        ((pk0) w1Var.h).getLabel();
        ((z30) w1Var.i).x.showPopupToChangeLabel(appWidgetId, ((pk0) w1Var.h).getLabel());
        ((z30) w1Var.i).d();
    }
}
