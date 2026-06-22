package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import com.luutinhit.launcher6.BubbleTextView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ue1 extends m81 implements Filterable {
    public final Context j;
    public final ArrayList k;
    public final ArrayList l;
    public o5 m;
    public final m8 n;

    public ue1(Context context, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        this.k = arrayList2;
        this.n = new m8(this, 1);
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        this.j = context;
        this.l = p();
    }

    @Override // defpackage.m81
    public final int c() {
        ArrayList arrayList = this.l;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        return this.n;
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, int i) {
        try {
            View view = ((te1) m91Var).g;
            ArrayList arrayList = this.l;
            view.setTag(arrayList.get(i));
            ((BubbleTextView) view).l((v6) arrayList.get(i));
            view.setOnClickListener(new re1(this));
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        return new te1(LayoutInflater.from(this.j).inflate(m61.search_item, viewGroup, false));
    }

    public final ArrayList p() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.k;
        int iMin = Math.min(8, arrayList2.size());
        for (int i = 0; i < iMin; i++) {
            arrayList.add((v6) arrayList2.get(i));
        }
        return arrayList;
    }
}
