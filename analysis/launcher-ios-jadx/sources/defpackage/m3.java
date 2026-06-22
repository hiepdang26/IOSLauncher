package defpackage;

import android.R;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;

/* JADX INFO: loaded from: classes.dex */
public final class m3 extends ArrayAdapter {
    public final /* synthetic */ AlertController$RecycleListView g;
    public final /* synthetic */ p3 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m3(p3 p3Var, ContextThemeWrapper contextThemeWrapper, int i, CharSequence[] charSequenceArr, AlertController$RecycleListView alertController$RecycleListView) {
        super(contextThemeWrapper, i, R.id.text1, charSequenceArr);
        this.h = p3Var;
        this.g = alertController$RecycleListView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        boolean[] zArr = this.h.u;
        if (zArr != null && zArr[i]) {
            this.g.setItemChecked(i, true);
        }
        return view2;
    }
}
