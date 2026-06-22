package defpackage;

import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ForwardingListener;

/* JADX INFO: loaded from: classes.dex */
public final class h1 extends ForwardingListener {
    public final /* synthetic */ ActionMenuItemView g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.g = actionMenuItemView;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public final qg1 getPopup() {
        i1 i1Var = this.g.l;
        if (i1Var != null) {
            return i1Var.getPopup();
        }
        return null;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public final boolean onForwardingStarted() {
        qg1 popup;
        ActionMenuItemView actionMenuItemView = this.g;
        ft0 ft0Var = actionMenuItemView.j;
        return ft0Var != null && ft0Var.invokeItem(actionMenuItemView.g) && (popup = getPopup()) != null && popup.isShowing();
    }
}
