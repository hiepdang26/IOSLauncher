package defpackage;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class nt0 extends m1 implements ActionProvider.VisibilityListener {
    public final ActionProvider a;
    public final /* synthetic */ qt0 b;
    public l1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nt0(qt0 qt0Var, Context context, ActionProvider actionProvider) {
        super(context);
        this.b = qt0Var;
        this.a = actionProvider;
    }

    @Override // defpackage.m1
    public final boolean hasSubMenu() {
        return this.a.hasSubMenu();
    }

    @Override // defpackage.m1
    public final boolean isVisible() {
        return this.a.isVisible();
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z) {
        l1 l1Var = this.c;
        if (l1Var != null) {
            gt0 gt0Var = ((mt0) ((nx0) l1Var).h).t;
            gt0Var.n = true;
            gt0Var.p(true);
        }
    }

    @Override // defpackage.m1
    public final View onCreateActionView() {
        return this.a.onCreateActionView();
    }

    @Override // defpackage.m1
    public final boolean onPerformDefaultAction() {
        return this.a.onPerformDefaultAction();
    }

    @Override // defpackage.m1
    public final void onPrepareSubMenu(SubMenu subMenu) {
        this.b.getClass();
        this.a.onPrepareSubMenu(subMenu);
    }

    @Override // defpackage.m1
    public final boolean overridesItemVisibility() {
        return this.a.overridesItemVisibility();
    }

    @Override // defpackage.m1
    public final void refreshVisibility() {
        this.a.refreshVisibility();
    }

    @Override // defpackage.m1
    public final void setVisibilityListener(l1 l1Var) {
        this.c = l1Var;
        this.a.setVisibilityListener(l1Var != null ? this : null);
    }

    @Override // defpackage.m1
    public final View onCreateActionView(MenuItem menuItem) {
        return this.a.onCreateActionView(menuItem);
    }
}
