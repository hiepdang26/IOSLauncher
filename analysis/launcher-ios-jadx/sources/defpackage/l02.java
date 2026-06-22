package defpackage;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class l02 extends m81 {
    public final ir0 j;

    public l02(ir0 ir0Var) {
        this.j = ir0Var;
    }

    @Override // defpackage.m81
    public final int c() {
        return this.j.b0.k;
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, int i) {
        ir0 ir0Var = this.j;
        int i2 = ir0Var.b0.g.i + i;
        TextView textView = ((k02) m91Var).A;
        String string = textView.getContext().getString(v61.mtrl_picker_navigate_to_year_description);
        textView.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i2)));
        textView.setContentDescription(String.format(string, Integer.valueOf(i2)));
        wb2 wb2Var = ir0Var.e0;
        if (sq1.b().get(1) == i2) {
            Object obj = wb2Var.i;
        } else {
            Object obj2 = wb2Var.h;
        }
        throw null;
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        return new k02((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(l61.mtrl_calendar_year, viewGroup, false));
    }
}
