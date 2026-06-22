package defpackage;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.ListPopupWindow;

/* JADX INFO: loaded from: classes.dex */
public final class wq0 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ xq0 g;

    public wq0(xq0 xq0Var) {
        this.g = xq0Var;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        xq0 xq0Var = this.g;
        xq0.a(xq0Var, i < 0 ? xq0Var.g.getSelectedItem() : xq0Var.getAdapter().getItem(i));
        AdapterView.OnItemClickListener onItemClickListener = xq0Var.getOnItemClickListener();
        ListPopupWindow listPopupWindow = xq0Var.g;
        if (onItemClickListener != null) {
            if (view == null || i < 0) {
                view = listPopupWindow.getSelectedView();
                i = listPopupWindow.getSelectedItemPosition();
                j = listPopupWindow.getSelectedItemId();
            }
            onItemClickListener.onItemClick(listPopupWindow.getListView(), view, i, j);
        }
        listPopupWindow.dismiss();
    }
}
