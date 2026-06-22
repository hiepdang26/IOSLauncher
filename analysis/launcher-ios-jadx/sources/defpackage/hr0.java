package defpackage;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.datepicker.c;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public final class hr0 implements View.OnClickListener {
    public final /* synthetic */ c g;
    public final /* synthetic */ ir0 h;

    public hr0(ir0 ir0Var, c cVar) {
        this.h = ir0Var;
        this.g = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ir0 ir0Var = this.h;
        int iP0 = ((LinearLayoutManager) ir0Var.g0.getLayoutManager()).P0() - 1;
        if (iP0 >= 0) {
            Calendar calendarA = sq1.a(this.g.j.g.g);
            calendarA.add(2, iP0);
            ir0Var.U(new pu0(calendarA));
        }
    }
}
