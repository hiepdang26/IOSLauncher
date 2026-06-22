package defpackage;

import android.view.MenuItem;

/* JADX INFO: loaded from: classes.dex */
public final class pt0 implements MenuItem.OnActionExpandListener {
    public final MenuItem.OnActionExpandListener a;
    public final /* synthetic */ qt0 b;

    public pt0(qt0 qt0Var, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.b = qt0Var;
        this.a = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.a.onMenuItemActionCollapse(this.b.g(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.a.onMenuItemActionExpand(this.b.g(menuItem));
    }
}
