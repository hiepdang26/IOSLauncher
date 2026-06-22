package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;
import androidx.profileinstaller.ProfileVerifier;

/* JADX INFO: loaded from: classes.dex */
public final class wn0 implements vt0, AdapterView.OnItemClickListener {
    public Context g;
    public LayoutInflater h;
    public gt0 i;
    public ExpandedMenuView j;
    public final int k;
    public ut0 l;
    public vn0 m;

    public wn0(ContextWrapper contextWrapper, int i) {
        this.k = i;
        this.g = contextWrapper;
        this.h = LayoutInflater.from(contextWrapper);
    }

    @Override // defpackage.vt0
    public final boolean collapseItemActionView(gt0 gt0Var, mt0 mt0Var) {
        return false;
    }

    @Override // defpackage.vt0
    public final boolean expandItemActionView(gt0 gt0Var, mt0 mt0Var) {
        return false;
    }

    @Override // defpackage.vt0
    public final boolean flagActionItems() {
        return false;
    }

    @Override // defpackage.vt0
    public final int getId() {
        return 0;
    }

    @Override // defpackage.vt0
    public final void initForMenu(Context context, gt0 gt0Var) {
        if (this.g != null) {
            this.g = context;
            if (this.h == null) {
                this.h = LayoutInflater.from(context);
            }
        }
        this.i = gt0Var;
        vn0 vn0Var = this.m;
        if (vn0Var != null) {
            vn0Var.notifyDataSetChanged();
        }
    }

    @Override // defpackage.vt0
    public final void onCloseMenu(gt0 gt0Var, boolean z) {
        ut0 ut0Var = this.l;
        if (ut0Var != null) {
            ut0Var.onCloseMenu(gt0Var, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.i.q(this.m.getItem(i), this, 0);
    }

    @Override // defpackage.vt0
    public final void onRestoreInstanceState(Parcelable parcelable) {
        SparseArray<Parcelable> sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.j.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // defpackage.vt0
    public final Parcelable onSaveInstanceState() {
        if (this.j == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.j;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    @Override // defpackage.vt0
    public final boolean onSubMenuSelected(ik1 ik1Var) {
        if (!ik1Var.hasVisibleItems()) {
            return false;
        }
        ht0 ht0Var = new ht0();
        ht0Var.g = ik1Var;
        Context context = ik1Var.g;
        t3 t3Var = new t3(context);
        p3 p3Var = (p3) t3Var.h;
        wn0 wn0Var = new wn0(p3Var.a, n61.abc_list_menu_item_layout);
        ht0Var.i = wn0Var;
        wn0Var.l = ht0Var;
        ik1Var.b(wn0Var, context);
        wn0 wn0Var2 = ht0Var.i;
        if (wn0Var2.m == null) {
            wn0Var2.m = new vn0(wn0Var2);
        }
        p3Var.r = wn0Var2.m;
        p3Var.s = ht0Var;
        View view = ik1Var.u;
        if (view != null) {
            p3Var.e = view;
        } else {
            p3Var.c = ik1Var.t;
            p3Var.d = ik1Var.s;
        }
        p3Var.p = ht0Var;
        u3 u3VarD = t3Var.d();
        ht0Var.h = u3VarD;
        u3VarD.setOnDismissListener(ht0Var);
        WindowManager.LayoutParams attributes = ht0Var.h.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ;
        ht0Var.h.show();
        ut0 ut0Var = this.l;
        if (ut0Var == null) {
            return true;
        }
        ut0Var.onOpenSubMenu(ik1Var);
        return true;
    }

    @Override // defpackage.vt0
    public final void setCallback(ut0 ut0Var) {
        throw null;
    }

    @Override // defpackage.vt0
    public final void updateMenuView(boolean z) {
        vn0 vn0Var = this.m;
        if (vn0Var != null) {
            vn0Var.notifyDataSetChanged();
        }
    }
}
