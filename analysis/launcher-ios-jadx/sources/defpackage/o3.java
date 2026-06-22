package defpackage;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController$RecycleListView;

/* JADX INFO: loaded from: classes.dex */
public final class o3 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ AlertController$RecycleListView g;
    public final /* synthetic */ s3 h;
    public final /* synthetic */ p3 i;

    public o3(p3 p3Var, AlertController$RecycleListView alertController$RecycleListView, s3 s3Var) {
        this.i = p3Var;
        this.g = alertController$RecycleListView;
        this.h = s3Var;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        p3 p3Var = this.i;
        boolean[] zArr = p3Var.u;
        AlertController$RecycleListView alertController$RecycleListView = this.g;
        if (zArr != null) {
            zArr[i] = alertController$RecycleListView.isItemChecked(i);
        }
        p3Var.y.onClick(this.h.b, i, alertController$RecycleListView.isItemChecked(i));
    }
}
