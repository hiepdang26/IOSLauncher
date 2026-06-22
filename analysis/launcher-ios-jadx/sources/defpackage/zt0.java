package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: loaded from: classes.dex */
public class zt0 extends n6 implements Menu {
    public final gt0 i;

    public zt0(Context context, gt0 gt0Var) {
        super(context);
        if (gt0Var == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.i = gt0Var;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return g(this.i.a(0, 0, 0, charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.i.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = g(menuItemArr2[i5]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return this.i.addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        ug1 ug1Var = (ug1) this.h;
        if (ug1Var != null) {
            ug1Var.clear();
        }
        this.i.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        this.i.close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        return g(this.i.findItem(i));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return g(this.i.getItem(i));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.i.hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.i.isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i2) {
        return this.i.performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.i.performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        if (((ug1) this.h) != null) {
            int i2 = 0;
            while (true) {
                ug1 ug1Var = (ug1) this.h;
                if (i2 >= ug1Var.i) {
                    break;
                }
                if (((uk1) ug1Var.f(i2)).getGroupId() == i) {
                    ((ug1) this.h).h(i2);
                    i2--;
                }
                i2++;
            }
        }
        this.i.removeGroup(i);
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        if (((ug1) this.h) != null) {
            int i2 = 0;
            while (true) {
                ug1 ug1Var = (ug1) this.h;
                if (i2 >= ug1Var.i) {
                    break;
                }
                if (((uk1) ug1Var.f(i2)).getItemId() == i) {
                    ((ug1) this.h).h(i2);
                    break;
                }
                i2++;
            }
        }
        this.i.removeItem(i);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z, boolean z2) {
        this.i.setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z) {
        this.i.setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z) {
        this.i.setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.i.setQwertyMode(z);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.i.size();
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return this.i.addSubMenu(i);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return g(this.i.add(i));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return this.i.addSubMenu(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return g(this.i.a(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return this.i.addSubMenu(i, i2, i3, i4);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, int i4) {
        return g(this.i.add(i, i2, i3, i4));
    }
}
