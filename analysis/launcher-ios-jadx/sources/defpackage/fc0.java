package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class fc0 extends m81 {
    public final LayoutInflater j;
    public ArrayList k = new ArrayList();
    public boolean l = false;
    public final boolean m = true;

    public fc0(Context context) {
        this.j = LayoutInflater.from(context);
    }

    @Override // defpackage.m81
    public final int c() {
        ArrayList arrayList = this.k;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, int i) {
        ec0 ec0Var = (ec0) m91Var;
        mw1 mw1Var = (mw1) this.k.get(i);
        String str = mw1Var.a;
        TextView textView = ec0Var.A;
        textView.setText(str);
        String str2 = mw1Var.b;
        TextView textView2 = ec0Var.B;
        textView2.setText(str2);
        ec0Var.C.setImageResource(mw1Var.c);
        boolean z = this.m;
        textView.setTextColor(z ? -1 : -16777216);
        textView2.setTextColor(z ? -1 : -16777216);
        if (i == 0) {
            textView.setTypeface(null, 1);
            textView2.setTypeface(null, 1);
        }
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        return new ec0(this, this.j.inflate(m61.recycler_hour_forecast, viewGroup, false));
    }

    public final void p(ArrayList arrayList, boolean z) {
        this.l = z;
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.clear();
        this.k.addAll(arrayList);
        Objects.toString(arrayList);
        f();
    }
}
