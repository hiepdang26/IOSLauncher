package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class gt0 implements Menu {
    public static final int[] E = {1, 4, 5, 3, 2, 0};
    public mt0 B;
    public boolean D;
    public final Context g;
    public final Resources h;
    public boolean i;
    public final boolean j;
    public et0 k;
    public final ArrayList l;
    public final ArrayList m;
    public boolean n;
    public final ArrayList o;
    public final ArrayList p;
    public boolean q;
    public CharSequence s;
    public Drawable t;
    public View u;
    public int r = 0;
    public boolean v = false;
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;
    public final ArrayList z = new ArrayList();
    public final CopyOnWriteArrayList A = new CopyOnWriteArrayList();
    public boolean C = false;

    public gt0(Context context) {
        boolean zP;
        boolean z = false;
        this.g = context;
        Resources resources = context.getResources();
        this.h = resources;
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = true;
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.q = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = rs1.a;
            if (Build.VERSION.SDK_INT >= 28) {
                zP = eu.p(viewConfiguration);
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                zP = identifier != 0 && resources2.getBoolean(identifier);
            }
            if (zP) {
                z = true;
            }
        }
        this.j = z;
    }

    public final mt0 a(int i, int i2, int i3, CharSequence charSequence) {
        int i4;
        int i5 = ((-65536) & i3) >> 16;
        if (i5 < 0 || i5 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i6 = (E[i5] << 16) | (65535 & i3);
        mt0 mt0Var = new mt0(this, i, i2, i3, i6, charSequence, this.r);
        ArrayList arrayList = this.l;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i4 = 0;
                break;
            }
            if (((mt0) arrayList.get(size)).j <= i6) {
                i4 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i4, mt0Var);
        p(true);
        return mt0Var;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.g.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            mt0 mt0VarA = a(i, i2, i3, resolveInfo.loadLabel(packageManager));
            mt0VarA.setIcon(resolveInfo.loadIcon(packageManager));
            mt0VarA.m = intent2;
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = mt0VarA;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(vt0 vt0Var, Context context) {
        this.A.add(new WeakReference(vt0Var));
        vt0Var.initForMenu(context, this);
        this.q = true;
    }

    public final void c(boolean z) {
        if (this.y) {
            return;
        }
        this.y = true;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.A;
        for (WeakReference weakReference : copyOnWriteArrayList) {
            vt0 vt0Var = (vt0) weakReference.get();
            if (vt0Var == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                vt0Var.onCloseMenu(this, z);
            }
        }
        this.y = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        mt0 mt0Var = this.B;
        if (mt0Var != null) {
            d(mt0Var);
        }
        this.l.clear();
        p(true);
    }

    public final void clearHeader() {
        this.t = null;
        this.s = null;
        this.u = null;
        p(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(mt0 mt0Var) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.A;
        boolean zCollapseItemActionView = false;
        if (!copyOnWriteArrayList.isEmpty() && this.B == mt0Var) {
            w();
            for (WeakReference weakReference : copyOnWriteArrayList) {
                vt0 vt0Var = (vt0) weakReference.get();
                if (vt0Var != null) {
                    zCollapseItemActionView = vt0Var.collapseItemActionView(this, mt0Var);
                    if (zCollapseItemActionView) {
                        break;
                    }
                } else {
                    copyOnWriteArrayList.remove(weakReference);
                }
            }
            v();
            if (zCollapseItemActionView) {
                this.B = null;
            }
        }
        return zCollapseItemActionView;
    }

    public boolean e(gt0 gt0Var, MenuItem menuItem) {
        et0 et0Var = this.k;
        return et0Var != null && et0Var.onMenuItemSelected(gt0Var, menuItem);
    }

    public boolean f(mt0 mt0Var) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.A;
        boolean zExpandItemActionView = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        w();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            vt0 vt0Var = (vt0) weakReference.get();
            if (vt0Var != null) {
                zExpandItemActionView = vt0Var.expandItemActionView(this, mt0Var);
                if (zExpandItemActionView) {
                    break;
                }
            } else {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
        v();
        if (zExpandItemActionView) {
            this.B = mt0Var;
        }
        return zExpandItemActionView;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        ArrayList arrayList = this.l;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            mt0 mt0Var = (mt0) arrayList.get(i2);
            if (mt0Var.g == i) {
                return mt0Var;
            }
            if (mt0Var.hasSubMenu() && (menuItemFindItem = mt0Var.u.findItem(i)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final mt0 g(int i, KeyEvent keyEvent) {
        ArrayList arrayList = this.z;
        arrayList.clear();
        h(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (mt0) arrayList.get(0);
        }
        boolean zN = n();
        for (int i2 = 0; i2 < size; i2++) {
            mt0 mt0Var = (mt0) arrayList.get(i2);
            char c = zN ? mt0Var.p : mt0Var.n;
            char[] cArr = keyData.meta;
            if ((c == cArr[0] && (metaState & 2) == 0) || ((c == cArr[2] && (metaState & 2) != 0) || (zN && c == '\b' && i == 67))) {
                return mt0Var;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return (MenuItem) this.l.get(i);
    }

    public final void h(ArrayList arrayList, int i, KeyEvent keyEvent) {
        boolean zN = n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            ArrayList arrayList2 = this.l;
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                mt0 mt0Var = (mt0) arrayList2.get(i2);
                if (mt0Var.hasSubMenu()) {
                    mt0Var.u.h(arrayList, i, keyEvent);
                }
                char c = zN ? mt0Var.p : mt0Var.n;
                if ((modifiers & 69647) == ((zN ? mt0Var.q : mt0Var.o) & 69647) && c != 0) {
                    char[] cArr = keyData.meta;
                    if ((c == cArr[0] || c == cArr[2] || (zN && c == '\b' && i == 67)) && mt0Var.isEnabled()) {
                        arrayList.add(mt0Var);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.D) {
            return true;
        }
        ArrayList arrayList = this.l;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((mt0) arrayList.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList arrayListL = l();
        if (this.q) {
            CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.A;
            boolean zFlagActionItems = false;
            for (WeakReference weakReference : copyOnWriteArrayList) {
                vt0 vt0Var = (vt0) weakReference.get();
                if (vt0Var == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zFlagActionItems |= vt0Var.flagActionItems();
                }
            }
            ArrayList arrayList = this.o;
            ArrayList arrayList2 = this.p;
            if (zFlagActionItems) {
                arrayList.clear();
                arrayList2.clear();
                int size = arrayListL.size();
                for (int i = 0; i < size; i++) {
                    mt0 mt0Var = (mt0) arrayListL.get(i);
                    if ((mt0Var.D & 32) == 32) {
                        arrayList.add(mt0Var);
                    } else {
                        arrayList2.add(mt0Var);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(l());
            }
            this.q = false;
        }
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return g(i, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public final ArrayList l() {
        boolean z = this.n;
        ArrayList arrayList = this.m;
        if (!z) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.l;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            mt0 mt0Var = (mt0) arrayList2.get(i);
            if (mt0Var.isVisible()) {
                arrayList.add(mt0Var);
            }
        }
        this.n = false;
        this.q = true;
        return arrayList;
    }

    public boolean m() {
        return this.C;
    }

    public boolean n() {
        return this.i;
    }

    public boolean o() {
        return this.j;
    }

    public void p(boolean z) {
        if (this.v) {
            this.w = true;
            if (z) {
                this.x = true;
                return;
            }
            return;
        }
        if (z) {
            this.n = true;
            this.q = true;
        }
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.A;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        w();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            vt0 vt0Var = (vt0) weakReference.get();
            if (vt0Var == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                vt0Var.updateMenuView(z);
            }
        }
        v();
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i2) {
        return q(findItem(i), null, i2);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        mt0 mt0VarG = g(i, keyEvent);
        boolean zQ = mt0VarG != null ? q(mt0VarG, null, i2) : false;
        if ((i2 & 2) != 0) {
            c(true);
        }
        return zQ;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(android.view.MenuItem r7, defpackage.vt0 r8, int r9) {
        /*
            r6 = this;
            mt0 r7 = (defpackage.mt0) r7
            r0 = 0
            if (r7 == 0) goto Lc5
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Ld
            goto Lc5
        Ld:
            android.view.MenuItem$OnMenuItemClickListener r1 = r7.v
            r2 = 1
            if (r1 == 0) goto L1a
            boolean r1 = r1.onMenuItemClick(r7)
            if (r1 == 0) goto L1a
        L18:
            r1 = 1
            goto L3a
        L1a:
            gt0 r1 = r7.t
            boolean r3 = r1.e(r1, r7)
            if (r3 == 0) goto L23
            goto L18
        L23:
            android.content.Intent r3 = r7.m
            if (r3 == 0) goto L2e
            android.content.Context r1 = r1.g     // Catch: android.content.ActivityNotFoundException -> L2d
            r1.startActivity(r3)     // Catch: android.content.ActivityNotFoundException -> L2d
            goto L18
        L2d:
        L2e:
            m1 r1 = r7.G
            if (r1 == 0) goto L39
            boolean r1 = r1.onPerformDefaultAction()
            if (r1 == 0) goto L39
            goto L18
        L39:
            r1 = 0
        L3a:
            m1 r3 = r7.G
            if (r3 == 0) goto L46
            boolean r4 = r3.hasSubMenu()
            if (r4 == 0) goto L46
            r4 = 1
            goto L47
        L46:
            r4 = 0
        L47:
            boolean r5 = r7.e()
            if (r5 == 0) goto L59
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto Lc4
            r6.c(r2)
            goto Lc4
        L59:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L6a
            if (r4 == 0) goto L62
            goto L6a
        L62:
            r7 = r9 & 1
            if (r7 != 0) goto Lc4
            r6.c(r2)
            goto Lc4
        L6a:
            r9 = r9 & 4
            if (r9 != 0) goto L71
            r6.c(r0)
        L71:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L85
            ik1 r9 = new ik1
            android.content.Context r5 = r6.g
            r9.<init>(r5, r6, r7)
            r7.u = r9
            java.lang.CharSequence r5 = r7.k
            r9.setHeaderTitle(r5)
        L85:
            ik1 r7 = r7.u
            if (r4 == 0) goto L8c
            r3.onPrepareSubMenu(r7)
        L8c:
            java.util.concurrent.CopyOnWriteArrayList r9 = r6.A
            boolean r3 = r9.isEmpty()
            if (r3 == 0) goto L95
            goto Lbe
        L95:
            if (r8 == 0) goto L9b
            boolean r0 = r8.onSubMenuSelected(r7)
        L9b:
            java.util.Iterator r8 = r9.iterator()
        L9f:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto Lbe
            java.lang.Object r3 = r8.next()
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3
            java.lang.Object r4 = r3.get()
            vt0 r4 = (defpackage.vt0) r4
            if (r4 != 0) goto Lb7
            r9.remove(r3)
            goto L9f
        Lb7:
            if (r0 != 0) goto L9f
            boolean r0 = r4.onSubMenuSelected(r7)
            goto L9f
        Lbe:
            r1 = r1 | r0
            if (r1 != 0) goto Lc4
            r6.c(r2)
        Lc4:
            return r1
        Lc5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gt0.q(android.view.MenuItem, vt0, int):boolean");
    }

    public final void r(vt0 vt0Var) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.A;
        for (WeakReference weakReference : copyOnWriteArrayList) {
            vt0 vt0Var2 = (vt0) weakReference.get();
            if (vt0Var2 == null || vt0Var2 == vt0Var) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        ArrayList arrayList = this.l;
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (((mt0) arrayList.get(i3)).h == i) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            int size2 = arrayList.size() - i3;
            while (true) {
                int i4 = i2 + 1;
                if (i2 >= size2 || ((mt0) arrayList.get(i3)).h != i) {
                    break;
                }
                if (i3 >= 0) {
                    ArrayList arrayList2 = this.l;
                    if (i3 < arrayList2.size()) {
                        arrayList2.remove(i3);
                    }
                }
                i2 = i4;
            }
            p(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        ArrayList arrayList = this.l;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (((mt0) arrayList.get(i2)).g == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            ArrayList arrayList2 = this.l;
            if (i2 >= arrayList2.size()) {
                return;
            }
            arrayList2.remove(i2);
            p(true);
        }
    }

    public final void s(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
        int size = this.l.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((ik1) item.getSubMenu()).s(bundle);
            }
        }
        int i2 = bundle.getInt("android:menu:expandedactionview");
        if (i2 <= 0 || (menuItemFindItem = findItem(i2)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z, boolean z2) {
        ArrayList arrayList = this.l;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            mt0 mt0Var = (mt0) arrayList.get(i2);
            if (mt0Var.h == i) {
                mt0Var.f(z2);
                mt0Var.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.C = z;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z) {
        ArrayList arrayList = this.l;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            mt0 mt0Var = (mt0) arrayList.get(i2);
            if (mt0Var.h == i) {
                mt0Var.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z) {
        ArrayList arrayList = this.l;
        int size = arrayList.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            mt0 mt0Var = (mt0) arrayList.get(i2);
            if (mt0Var.h == i) {
                int i3 = mt0Var.D;
                int i4 = (i3 & (-9)) | (z ? 0 : 8);
                mt0Var.D = i4;
                if (i3 != i4) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            p(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.i = z;
        p(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.l.size();
    }

    public final void t(Bundle bundle) {
        int size = this.l.size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((ik1) item.getSubMenu()).t(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    public final void u(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        if (view != null) {
            this.u = view;
            this.s = null;
            this.t = null;
        } else {
            if (i > 0) {
                this.s = this.h.getText(i);
            } else if (charSequence != null) {
                this.s = charSequence;
            }
            if (i2 > 0) {
                this.t = this.g.getDrawable(i2);
            } else if (drawable != null) {
                this.t = drawable;
            }
            this.u = null;
        }
        p(false);
    }

    public final void v() {
        this.v = false;
        if (this.w) {
            this.w = false;
            p(this.x);
        }
    }

    public final void w() {
        if (this.v) {
            return;
        }
        this.v = true;
        this.w = false;
        this.x = false;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return a(0, 0, 0, this.h.getString(i));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.h.getString(i));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        mt0 mt0VarA = a(i, i2, i3, charSequence);
        ik1 ik1Var = new ik1(this.g, this, mt0VarA);
        mt0VarA.u = ik1Var;
        ik1Var.setHeaderTitle(mt0VarA.k);
        return ik1Var;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.h.getString(i4));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.h.getString(i4));
    }

    public gt0 k() {
        return this;
    }
}
