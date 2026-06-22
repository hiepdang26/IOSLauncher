package defpackage;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.datepicker.c;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public final class gr0 implements View.OnClickListener {
    public final /* synthetic */ c g;
    public final /* synthetic */ ir0 h;

    public gr0(ir0 ir0Var, c cVar) {
        this.h = ir0Var;
        this.g = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ir0 ir0Var = this.h;
        int iO0 = ((LinearLayoutManager) ir0Var.g0.getLayoutManager()).O0() + 1;
        if (iO0 < ir0Var.g0.getAdapter().c()) {
            Calendar calendarA = sq1.a(this.g.j.g.g);
            calendarA.add(2, iO0);
            ir0Var.U(new pu0(calendarA));
        }
    }
}
