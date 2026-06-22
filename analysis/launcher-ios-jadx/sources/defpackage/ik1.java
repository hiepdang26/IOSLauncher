package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ik1 extends gt0 implements SubMenu {
    public final gt0 F;
    public final mt0 G;

    public ik1(Context context, gt0 gt0Var, mt0 mt0Var) {
        super(context);
        this.F = gt0Var;
        this.G = mt0Var;
    }

    @Override // defpackage.gt0
    public final boolean d(mt0 mt0Var) {
        return this.F.d(mt0Var);
    }

    @Override // defpackage.gt0
    public final boolean e(gt0 gt0Var, MenuItem menuItem) {
        return super.e(gt0Var, menuItem) || this.F.e(gt0Var, menuItem);
    }

    @Override // defpackage.gt0
    public final boolean f(mt0 mt0Var) {
        return this.F.f(mt0Var);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.G;
    }

    @Override // defpackage.gt0
    public final String j() {
        mt0 mt0Var = this.G;
        int i = mt0Var != null ? mt0Var.g : 0;
        if (i == 0) {
            return null;
        }
        return k31.k(i, "android:menu:actionviewstates:");
    }

    @Override // defpackage.gt0
    public final gt0 k() {
        return this.F.k();
    }

    @Override // defpackage.gt0
    public final boolean m() {
        return this.F.m();
    }

    @Override // defpackage.gt0
    public final boolean n() {
        return this.F.n();
    }

    @Override // defpackage.gt0
    public final boolean o() {
        return this.F.o();
    }

    @Override // defpackage.gt0, android.view.Menu
    public final void setGroupDividerEnabled(boolean z) {
        this.F.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        u(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        u(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        u(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.G.setIcon(drawable);
        return this;
    }

    @Override // defpackage.gt0, android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.F.setQwertyMode(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i) {
        u(0, null, i, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i) {
        u(i, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i) {
        this.G.setIcon(i);
        return this;
    }
}
