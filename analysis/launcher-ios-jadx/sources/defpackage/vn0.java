package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class vn0 extends BaseAdapter {
    public int g = -1;
    public final /* synthetic */ wn0 h;

    public vn0(wn0 wn0Var) {
        this.h = wn0Var;
        a();
    }

    public final void a() {
        gt0 gt0Var = this.h.i;
        mt0 mt0Var = gt0Var.B;
        if (mt0Var != null) {
            gt0Var.i();
            ArrayList arrayList = gt0Var.p;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((mt0) arrayList.get(i)) == mt0Var) {
                    this.g = i;
                    return;
                }
            }
        }
        this.g = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final mt0 getItem(int i) {
        wn0 wn0Var = this.h;
        gt0 gt0Var = wn0Var.i;
        gt0Var.i();
        ArrayList arrayList = gt0Var.p;
        wn0Var.getClass();
        int i2 = this.g;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (mt0) arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        wn0 wn0Var = this.h;
        gt0 gt0Var = wn0Var.i;
        gt0Var.i();
        int size = gt0Var.p.size();
        wn0Var.getClass();
        return this.g < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            wn0 wn0Var = this.h;
            view = wn0Var.h.inflate(wn0Var.k, viewGroup, false);
        }
        ((xt0) view).a(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
