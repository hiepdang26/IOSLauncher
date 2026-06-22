package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
public abstract class rt0 implements qg1, vt0, AdapterView.OnItemClickListener {
    public Rect g;

    public static int b(ListAdapter listAdapter, Context context, int i) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        FrameLayout frameLayout = null;
        View view = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, frameLayout);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    public static boolean j(gt0 gt0Var) {
        int size = gt0Var.l.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = gt0Var.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public abstract void a(gt0 gt0Var);

    public abstract void c(View view);

    @Override // defpackage.vt0
    public final boolean collapseItemActionView(gt0 gt0Var, mt0 mt0Var) {
        return false;
    }

    public abstract void d(boolean z);

    public abstract void e(int i);

    @Override // defpackage.vt0
    public final boolean expandItemActionView(gt0 gt0Var, mt0 mt0Var) {
        return false;
    }

    public abstract void f(int i);

    public abstract void g(PopupWindow.OnDismissListener onDismissListener);

    @Override // defpackage.vt0
    public final int getId() {
        return 0;
    }

    public abstract void h(boolean z);

    public abstract void i(int i);

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        (listAdapter instanceof HeaderViewListAdapter ? (dt0) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (dt0) listAdapter).g.q((MenuItem) listAdapter.getItem(i), this, !(this instanceof pg) ? 0 : 4);
    }

    @Override // defpackage.vt0
    public final void initForMenu(Context context, gt0 gt0Var) {
    }
}
