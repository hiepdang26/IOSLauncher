package defpackage;

import android.view.View;
import com.google.android.material.internal.NavigationMenuItemView;

/* JADX INFO: loaded from: classes.dex */
public final class ew0 implements View.OnClickListener {
    public final /* synthetic */ ow0 g;

    public ew0(ow0 ow0Var) {
        this.g = ow0Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
        ow0 ow0Var = this.g;
        gw0 gw0Var = ow0Var.k;
        boolean z = true;
        if (gw0Var != null) {
            gw0Var.l = true;
        }
        mt0 itemData = navigationMenuItemView.getItemData();
        boolean zQ = ow0Var.i.q(itemData, ow0Var, 0);
        if (itemData != null && itemData.isCheckable() && zQ) {
            ow0Var.k.q(itemData);
        } else {
            z = false;
        }
        gw0 gw0Var2 = ow0Var.k;
        if (gw0Var2 != null) {
            gw0Var2.l = false;
        }
        if (z) {
            ow0Var.updateMenuView(false);
        }
    }
}
