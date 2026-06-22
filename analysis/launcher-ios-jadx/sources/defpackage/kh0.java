package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class kh0 extends m81 implements wh0 {
    public final String j = "ItemAddAdapter";
    public final ArrayList k;
    public int l;
    public ih0 m;

    public kh0(ArrayList arrayList) {
        new ArrayList();
        this.l = -1;
        this.k = arrayList;
    }

    @Override // defpackage.wh0
    public final void a(int i) {
        ArrayList arrayList = this.k;
        try {
            gh0 gh0Var = (gh0) arrayList.get(i);
            this.m.i(gh0Var.a, gh0Var.b, gh0Var.c, gh0Var.d);
            arrayList.remove(i);
            this.g.f(i, 1);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // defpackage.wh0
    public final void b(int i, int i2) {
        ArrayList arrayList = this.k;
        if (i < i2) {
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                Collections.swap(arrayList, i3, i4);
                i3 = i4;
            }
        } else {
            for (int i5 = i; i5 > i2; i5--) {
                Collections.swap(arrayList, i5, i5 - 1);
            }
        }
        this.g.c(i, i2);
    }

    @Override // defpackage.m81
    public final int c() {
        try {
            return this.k.size();
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, int i) {
        jh0 jh0Var = (jh0) m91Var;
        gh0 gh0Var = (gh0) this.k.get(i);
        jh0Var.B.setText(gh0Var.b);
        jh0Var.C.setOnClickListener(new hh0(this, jh0Var));
        jh0Var.D.setImageBitmap(gh0Var.d);
        if (i > this.l) {
            View view = jh0Var.g;
            view.setAlpha(0.0f);
            view.animate().withLayer().alpha(1.0f).setDuration(200L).start();
            this.l = i;
        }
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(m61.item_add_adapter, viewGroup, false);
        jh0 jh0Var = new jh0(viewInflate);
        jh0Var.A = (RelativeLayout) viewInflate.findViewById(v51.container);
        jh0Var.B = (TextView) viewInflate.findViewById(v51.tvItemName);
        jh0Var.C = (AppCompatImageView) viewInflate.findViewById(v51.remove_icon);
        jh0Var.D = (AppCompatImageView) viewInflate.findViewById(v51.icon_app);
        return jh0Var;
    }

    public final int p(int i) {
        ArrayList arrayList = this.k;
        if (arrayList != null) {
            if (i >= c()) {
                return c();
            }
            for (int i2 = 0; i2 < c(); i2++) {
                gh0 gh0Var = (gh0) arrayList.get(i2);
                if (gh0Var != null) {
                    for (int i3 = 1; i3 < c(); i3++) {
                        if (gh0Var.a == i + i3) {
                            return i2;
                        }
                    }
                }
            }
        }
        return i;
    }
}
