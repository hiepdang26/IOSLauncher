package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.luutinhit.launcher6.leftpage.SlidingUpWidgetsList;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class yh1 extends m81 {
    public final ArrayList j;
    public boolean k;
    public SlidingUpWidgetsList l;

    public yh1(ArrayList arrayList, boolean z) {
        this.j = arrayList;
        this.k = z;
    }

    @Override // defpackage.m81
    public final int c() {
        ArrayList arrayList = this.j;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // defpackage.m81
    public final int e(int i) {
        ArrayList arrayList = this.j;
        if (arrayList != null) {
            return ((cx1) arrayList.get(i)).d;
        }
        return 0;
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, int i) {
        xh1 xh1Var = (xh1) m91Var;
        ArrayList arrayList = this.j;
        xh1Var.A.setImageDrawable(((cx1) arrayList.get(i)).a);
        String str = ((cx1) arrayList.get(i)).b;
        TextView textView = xh1Var.B;
        textView.setText(str);
        textView.setTextColor(this.k ? -1 : -16777216);
        int i2 = ((cx1) arrayList.get(i)).d % 10;
        View view = xh1Var.g;
        if (i2 >= 1) {
            ((ri1) view.getLayoutParams()).f = true;
        }
        view.setOnClickListener(new ce0(this, xh1Var, 3));
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        return i == 0 ? new xh1(LayoutInflater.from(viewGroup.getContext()).inflate(m61.left_page_sliding_up_widget_item_square, viewGroup, false)) : new xh1(LayoutInflater.from(viewGroup.getContext()).inflate(m61.left_page_sliding_up_widget_item_full, viewGroup, false));
    }
}
