package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBinderMapperImpl;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class q91 extends m81 {
    public List j;
    public boolean k;

    @Override // defpackage.m81
    public final int c() {
        List list = this.j;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, int i) {
        p91 p91Var = (p91) m91Var;
        lh0 lh0Var = p91Var.A;
        lh0Var.E = (ac) this.j.get(i);
        synchronized (lh0Var) {
            lh0Var.F |= 1;
        }
        lh0Var.q();
        lh0Var.H();
        p91Var.B.setTextColor(this.k ? -1 : -16777216);
        p91Var.C.setTextColor(this.k ? -1 : -16777216);
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        int i2 = m61.item_battery;
        DataBinderMapperImpl dataBinderMapperImpl = yr.a;
        lh0 lh0VarB = yr.a.b(i2, layoutInflaterFrom.inflate(i2, viewGroup, false));
        p91 p91Var = new p91(lh0VarB.x);
        p91Var.A = lh0VarB;
        int i3 = v51.battery_device_name;
        View view = lh0VarB.x;
        p91Var.B = (TextView) view.findViewById(i3);
        p91Var.C = (TextView) view.findViewById(v51.battery_percent);
        return p91Var;
    }
}
