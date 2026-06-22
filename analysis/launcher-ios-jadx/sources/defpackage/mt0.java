package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class mt0 implements uk1 {
    public int E;
    public View F;
    public m1 G;
    public MenuItem.OnActionExpandListener H;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public CharSequence k;
    public CharSequence l;
    public Intent m;
    public char n;
    public char p;
    public Drawable r;
    public final gt0 t;
    public ik1 u;
    public MenuItem.OnMenuItemClickListener v;
    public CharSequence w;
    public CharSequence x;
    public int o = MotionScene.Transition.TransitionOnClick.JUMP_TO_START;
    public int q = MotionScene.Transition.TransitionOnClick.JUMP_TO_START;
    public int s = 0;
    public ColorStateList y = null;
    public PorterDuff.Mode z = null;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public int D = 16;
    public boolean I = false;

    public mt0(gt0 gt0Var, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.t = gt0Var;
        this.g = i2;
        this.h = i;
        this.i = i3;
        this.j = i4;
        this.k = charSequence;
        this.E = i5;
    }

    public static void c(int i, int i2, String str, StringBuilder sb) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    @Override // defpackage.uk1
    public final m1 a() {
        return this.G;
    }

    @Override // defpackage.uk1
    public final uk1 b(m1 m1Var) {
        m1 m1Var2 = this.G;
        if (m1Var2 != null) {
            m1Var2.reset();
        }
        this.F = null;
        this.G = m1Var;
        this.t.p(true);
        m1 m1Var3 = this.G;
        if (m1Var3 != null) {
            m1Var3.setVisibilityListener(new nx0(this, 19));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.E & 8) == 0) {
            return false;
        }
        if (this.F == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.H;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.t.d(this);
        }
        return false;
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.C && (this.A || this.B)) {
            drawable = az1.L(drawable).mutate();
            if (this.A) {
                drawable.setTintList(this.y);
            }
            if (this.B) {
                drawable.setTintMode(this.z);
            }
            this.C = false;
        }
        return drawable;
    }

    public final boolean e() {
        m1 m1Var;
        if ((this.E & 8) != 0) {
            if (this.F == null && (m1Var = this.G) != null) {
                this.F = m1Var.onCreateActionView(this);
            }
            if (this.F != null) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!e()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.H;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.t.f(this);
        }
        return false;
    }

    public final void f(boolean z) {
        this.D = (z ? 4 : 0) | (this.D & (-5));
    }

    public final void g(boolean z) {
        if (z) {
            this.D |= 32;
        } else {
            this.D &= -33;
        }
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.F;
        if (view != null) {
            return view;
        }
        m1 m1Var = this.G;
        if (m1Var == null) {
            return null;
        }
        View viewOnCreateActionView = m1Var.onCreateActionView(this);
        this.F = viewOnCreateActionView;
        return viewOnCreateActionView;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.q;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.p;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.w;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.h;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.r;
        if (drawable != null) {
            return d(drawable);
        }
        int i = this.s;
        if (i == 0) {
            return null;
        }
        Drawable drawableO = hg0.o(this.t.g, i);
        this.s = 0;
        this.r = drawableO;
        return d(drawableO);
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.y;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.z;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.m;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.g;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.o;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.n;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.u;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.l;
        return charSequence != null ? charSequence : this.k;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.x;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.u != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.I;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.D & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.D & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.D & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        m1 m1Var = this.G;
        return (m1Var == null || !m1Var.overridesItemVisibility()) ? (this.D & 8) == 0 : (this.D & 8) == 0 && this.G.isVisible();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i;
        this.F = view;
        this.G = null;
        if (view != null && view.getId() == -1 && (i = this.g) > 0) {
            view.setId(i);
        }
        gt0 gt0Var = this.t;
        gt0Var.q = true;
        gt0Var.p(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.p == c) {
            return this;
        }
        this.p = Character.toLowerCase(c);
        this.t.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        int i = this.D;
        int i2 = (z ? 1 : 0) | (i & (-2));
        this.D = i2;
        if (i != i2) {
            this.t.p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        int i = this.D;
        if ((i & 4) == 0) {
            int i2 = (i & (-3)) | (z ? 2 : 0);
            this.D = i2;
            if (i != i2) {
                this.t.p(false);
            }
            return this;
        }
        gt0 gt0Var = this.t;
        gt0Var.getClass();
        ArrayList arrayList = gt0Var.l;
        int size = arrayList.size();
        gt0Var.w();
        for (int i3 = 0; i3 < size; i3++) {
            mt0 mt0Var = (mt0) arrayList.get(i3);
            if (mt0Var.h == this.h && (mt0Var.D & 4) != 0 && mt0Var.isCheckable()) {
                boolean z2 = mt0Var == this;
                int i4 = mt0Var.D;
                int i5 = (z2 ? 2 : 0) | (i4 & (-3));
                mt0Var.D = i5;
                if (i4 != i5) {
                    mt0Var.t.p(false);
                }
            }
        }
        gt0Var.v();
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.D |= 16;
        } else {
            this.D &= -17;
        }
        this.t.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.s = 0;
        this.r = drawable;
        this.C = true;
        this.t.p(false);
        return this;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.y = colorStateList;
        this.A = true;
        this.C = true;
        this.t.p(false);
        return this;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.z = mode;
        this.B = true;
        this.C = true;
        this.t.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.m = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c) {
        if (this.n == c) {
            return this;
        }
        this.n = c;
        this.t.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.H = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.v = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2) {
        this.n = c;
        this.p = Character.toLowerCase(c2);
        this.t.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.E = i;
        gt0 gt0Var = this.t;
        gt0Var.q = true;
        gt0Var.p(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.k = charSequence;
        this.t.p(false);
        ik1 ik1Var = this.u;
        if (ik1Var != null) {
            ik1Var.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.l = charSequence;
        this.t.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        int i = this.D;
        int i2 = (z ? 0 : 8) | (i & (-9));
        this.D = i2;
        if (i != i2) {
            gt0 gt0Var = this.t;
            gt0Var.n = true;
            gt0Var.p(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.k;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final uk1 setContentDescription(CharSequence charSequence) {
        this.w = charSequence;
        this.t.p(false);
        return this;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final uk1 setTooltipText(CharSequence charSequence) {
        this.x = charSequence;
        this.t.p(false);
        return this;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.p == c && this.q == i) {
            return this;
        }
        this.p = Character.toLowerCase(c);
        this.q = KeyEvent.normalizeMetaState(i);
        this.t.p(false);
        return this;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c, int i) {
        if (this.n == c && this.o == i) {
            return this;
        }
        this.n = c;
        this.o = KeyEvent.normalizeMetaState(i);
        this.t.p(false);
        return this;
    }

    @Override // defpackage.uk1, android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.n = c;
        this.o = KeyEvent.normalizeMetaState(i);
        this.p = Character.toLowerCase(c2);
        this.q = KeyEvent.normalizeMetaState(i2);
        this.t.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.r = null;
        this.s = i;
        this.C = true;
        this.t.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        setTitle(this.t.g.getString(i));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i) {
        int i2;
        Context context = this.t.g;
        View viewInflate = LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false);
        this.F = viewInflate;
        this.G = null;
        if (viewInflate != null && viewInflate.getId() == -1 && (i2 = this.g) > 0) {
            viewInflate.setId(i2);
        }
        gt0 gt0Var = this.t;
        gt0Var.q = true;
        gt0Var.p(true);
        return this;
    }
}
