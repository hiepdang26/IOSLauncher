package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class oh1 implements View.OnClickListener {
    public final /* synthetic */ sh1 g;

    public oh1(sh1 sh1Var) {
        this.g = sh1Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        rh1 rh1Var;
        sh1 sh1Var = this.g;
        if (sh1Var.isEnabled() && sh1Var.d()) {
            rh1 rh1Var2 = sh1Var.x;
            rh1 rh1Var3 = rh1.g;
            if (rh1Var2 == rh1Var3 || rh1Var2 == (rh1Var = rh1.i)) {
                sh1Var.setPanelState(rh1.h);
            } else if (sh1Var.B < 1.0f) {
                sh1Var.setPanelState(rh1Var);
            } else {
                sh1Var.setPanelState(rh1Var3);
            }
        }
    }
}
