package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.internal.NavigationMenuView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ow0 implements vt0 {
    public boolean A;
    public int C;
    public int D;
    public int E;
    public NavigationMenuView g;
    public LinearLayout h;
    public gt0 i;
    public int j;
    public gw0 k;
    public LayoutInflater l;
    public ColorStateList n;
    public ColorStateList p;
    public ColorStateList q;
    public Drawable r;
    public RippleDrawable s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;
    public int m = 0;
    public int o = 0;
    public boolean B = true;
    public int F = -1;
    public final ew0 G = new ew0(this);

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
        return this.j;
    }

    @Override // defpackage.vt0
    public final void initForMenu(Context context, gt0 gt0Var) {
        this.l = LayoutInflater.from(context);
        this.i = gt0Var;
        this.E = context.getResources().getDimensionPixelOffset(d51.design_navigation_separator_vertical_padding);
    }

    @Override // defpackage.vt0
    public final void onRestoreInstanceState(Parcelable parcelable) {
        mt0 mt0Var;
        View actionView;
        o11 o11Var;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.g.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                gw0 gw0Var = this.k;
                gw0Var.getClass();
                int i = bundle2.getInt("android:menu:checked", 0);
                ArrayList arrayList = gw0Var.j;
                if (i != 0) {
                    gw0Var.l = true;
                    int size = arrayList.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        }
                        iw0 iw0Var = (iw0) arrayList.get(i2);
                        if (iw0Var instanceof kw0) {
                            mt0 mt0Var2 = ((kw0) iw0Var).a;
                            if (mt0Var2.g == i) {
                                gw0Var.q(mt0Var2);
                                break;
                            }
                        }
                        i2++;
                    }
                    gw0Var.l = false;
                    gw0Var.p();
                }
                SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
                if (sparseParcelableArray2 != null) {
                    int size2 = arrayList.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        iw0 iw0Var2 = (iw0) arrayList.get(i3);
                        if ((iw0Var2 instanceof kw0) && (actionView = (mt0Var = ((kw0) iw0Var2).a).getActionView()) != null && (o11Var = (o11) sparseParcelableArray2.get(mt0Var.g)) != null) {
                            actionView.restoreHierarchyState(o11Var);
                        }
                    }
                }
            }
            SparseArray<Parcelable> sparseParcelableArray3 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray3 != null) {
                this.h.restoreHierarchyState(sparseParcelableArray3);
            }
        }
    }

    @Override // defpackage.vt0
    public final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.g != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.g.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        gw0 gw0Var = this.k;
        if (gw0Var != null) {
            gw0Var.getClass();
            Bundle bundle2 = new Bundle();
            mt0 mt0Var = gw0Var.k;
            if (mt0Var != null) {
                bundle2.putInt("android:menu:checked", mt0Var.g);
            }
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            ArrayList arrayList = gw0Var.j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                iw0 iw0Var = (iw0) arrayList.get(i);
                if (iw0Var instanceof kw0) {
                    mt0 mt0Var2 = ((kw0) iw0Var).a;
                    View actionView = mt0Var2 != null ? mt0Var2.getActionView() : null;
                    if (actionView != null) {
                        o11 o11Var = new o11();
                        actionView.saveHierarchyState(o11Var);
                        sparseArray2.put(mt0Var2.g, o11Var);
                    }
                }
            }
            bundle2.putSparseParcelableArray("android:menu:action_views", sparseArray2);
            bundle.putBundle("android:menu:adapter", bundle2);
        }
        if (this.h != null) {
            SparseArray<Parcelable> sparseArray3 = new SparseArray<>();
            this.h.saveHierarchyState(sparseArray3);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray3);
        }
        return bundle;
    }

    @Override // defpackage.vt0
    public final boolean onSubMenuSelected(ik1 ik1Var) {
        return false;
    }

    @Override // defpackage.vt0
    public final void updateMenuView(boolean z) {
        gw0 gw0Var = this.k;
        if (gw0Var != null) {
            gw0Var.p();
            gw0Var.f();
        }
    }

    @Override // defpackage.vt0
    public final void onCloseMenu(gt0 gt0Var, boolean z) {
    }
}
