package defpackage;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class q8 extends m81 implements Filterable {
    public final ArrayList j;
    public final ArrayList k;
    public se1 l;
    public final m8 m;

    public q8(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        this.j = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.k = arrayList3;
        this.m = new m8(this, 0);
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        arrayList3.clear();
        arrayList3.addAll(arrayList);
    }

    @Override // defpackage.m81
    public final int c() {
        return this.k.size();
    }

    @Override // defpackage.m81
    public final int e(int i) {
        return ((w6) this.k.get(i)).b();
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        return this.m;
    }

    @Override // defpackage.m81
    public final void h(RecyclerView recyclerView) {
        recyclerView.k(new ta0(this));
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, int i) {
        v6 v6Var;
        if (!(m91Var instanceof p8)) {
            if (m91Var instanceof n8) {
                n8 n8Var = (n8) m91Var;
                ((TextViewCustomFont) n8Var.g).setText(((w6) n8Var.A.k.get(i)).a());
                return;
            }
            return;
        }
        p8 p8Var = (p8) m91Var;
        q8 q8Var = p8Var.C;
        p8Var.A.setText(((w6) q8Var.k.get(i)).a());
        w6 w6Var = (w6) q8Var.k.get(i);
        switch (w6Var.a) {
            case 0:
                v6Var = (v6) w6Var.b;
                break;
            default:
                v6Var = null;
                break;
        }
        p8Var.B.l(v6Var);
        p8Var.g.setOnClickListener(new o8(p8Var));
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        return i == 0 ? new n8(this, LayoutInflater.from(viewGroup.getContext()).inflate(m61.item_header_apps_library_search_view, viewGroup, false)) : new p8(this, LayoutInflater.from(viewGroup.getContext()).inflate(m61.item_apps_library_search_view, viewGroup, false));
    }
}
