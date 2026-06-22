package defpackage;

import android.view.SubMenu;

/* JADX INFO: loaded from: classes.dex */
public final class dw0 extends gt0 {
    @Override // defpackage.gt0, android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        mt0 mt0VarA = a(i, i2, i3, charSequence);
        pw0 pw0Var = new pw0(this.g, this, mt0VarA);
        mt0VarA.u = pw0Var;
        pw0Var.setHeaderTitle(mt0VarA.k);
        return pw0Var;
    }
}
