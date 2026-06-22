package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class dt0 extends BaseAdapter {
    public final gt0 g;
    public int h = -1;
    public boolean i;
    public final boolean j;
    public final LayoutInflater k;
    public final int l;

    public dt0(gt0 gt0Var, LayoutInflater layoutInflater, boolean z, int i) {
        this.j = z;
        this.k = layoutInflater;
        this.g = gt0Var;
        this.l = i;
        a();
    }

    public final void a() {
        gt0 gt0Var = this.g;
        mt0 mt0Var = gt0Var.B;
        if (mt0Var != null) {
            gt0Var.i();
            ArrayList arrayList = gt0Var.p;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((mt0) arrayList.get(i)) == mt0Var) {
                    this.h = i;
                    return;
                }
            }
        }
        this.h = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final mt0 getItem(int i) {
        ArrayList arrayListL;
        boolean z = this.j;
        gt0 gt0Var = this.g;
        if (z) {
            gt0Var.i();
            arrayListL = gt0Var.p;
        } else {
            arrayListL = gt0Var.l();
        }
        int i2 = this.h;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (mt0) arrayListL.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayListL;
        boolean z = this.j;
        gt0 gt0Var = this.g;
        if (z) {
            gt0Var.i();
            arrayListL = gt0Var.p;
        } else {
            arrayListL = gt0Var.l();
        }
        return this.h < 0 ? arrayListL.size() : arrayListL.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z = false;
        if (view == null) {
            view = this.k.inflate(this.l, viewGroup, false);
        }
        int i2 = getItem(i).h;
        int i3 = i - 1;
        int i4 = i3 >= 0 ? getItem(i3).h : i2;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.g.m() && i2 != i4) {
            z = true;
        }
        listMenuItemView.setGroupDividerEnabled(z);
        xt0 xt0Var = (xt0) view;
        if (this.i) {
            listMenuItemView.setForceShowIcon(true);
        }
        xt0Var.a(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
