package defpackage;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class g1 implements uk1 {
    public CharSequence g;
    public CharSequence h;
    public Intent i;
    public char j;
    public int k;
    public char l;
    public int m;
    public Drawable n;
    public Context o;
    public CharSequence p;
    public CharSequence q;
    public ColorStateList r;
    public PorterDuff.Mode s;
    public boolean t;
    public boolean u;
    public int v;

    @Override // defpackage.uk1
    public final m1 a() {
        return null;
    }

    @Override // defpackage.uk1
    public final uk1 b(m1 m1Var) {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        Drawable drawable = this.n;
        if (drawable != null) {
            if (this.t || this.u) {
                Drawable drawableL = az1.L(drawable);
                this.n = drawableL;
                Drawable drawableMutate = drawableL.mutate();
                this.n = drawableMutate;
                if (this.t) {
                    drawableMutate.setTintList(this.r);
                }
                if (this.u) {
                    this.n.setTintMode(this.s);
                }
            }
        }
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.m;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.l;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.p;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.n;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.r;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.s;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return R.id.home;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.j;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.g;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.h;
        return charSequence != null ? charSequence : this.g;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.q;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.v & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.v & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.v & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.v & 8) == 0;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c) {
        this.l = Character.toLowerCase(c);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        this.v = (z ? 1 : 0) | (this.v & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        this.v = (z ? 2 : 0) | (this.v & (-3));
        return this;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final uk1 setContentDescription(CharSequence charSequence) {
        this.p = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        this.v = (z ? 16 : 0) | (this.v & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.n = drawable;
        c();
        return this;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.r = colorStateList;
        this.t = true;
        c();
        return this;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.s = mode;
        this.u = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.i = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c) {
        this.j = c;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2) {
        this.j = c;
        this.l = Character.toLowerCase(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.g = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.h = charSequence;
        return this;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final uk1 setTooltipText(CharSequence charSequence) {
        this.q = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        this.v = (this.v & 8) | (z ? 0 : 8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c, int i) {
        this.l = Character.toLowerCase(c);
        this.m = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.p = charSequence;
        return this;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c, int i) {
        this.j = c;
        this.k = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        this.g = this.o.getResources().getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.q = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.n = this.o.getDrawable(i);
        c();
        return this;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.j = c;
        this.k = KeyEvent.normalizeMetaState(i);
        this.l = Character.toLowerCase(c2);
        this.m = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i) {
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i) {
        return this;
    }
}
