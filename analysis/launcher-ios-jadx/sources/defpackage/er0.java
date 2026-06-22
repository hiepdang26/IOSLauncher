package defpackage;

import android.text.format.DateUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.c;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public final class er0 extends z81 {
    public final /* synthetic */ c a;
    public final /* synthetic */ MaterialButton b;
    public final /* synthetic */ ir0 c;

    public er0(ir0 ir0Var, c cVar, MaterialButton materialButton) {
        this.c = ir0Var;
        this.a = cVar;
        this.b = materialButton;
    }

    @Override // defpackage.z81
    public final void a(RecyclerView recyclerView, int i) {
        if (i == 0) {
            recyclerView.announceForAccessibility(this.b.getText());
        }
    }

    @Override // defpackage.z81
    public final void b(RecyclerView recyclerView, int i, int i2) {
        ir0 ir0Var = this.c;
        int iO0 = i < 0 ? ((LinearLayoutManager) ir0Var.g0.getLayoutManager()).O0() : ((LinearLayoutManager) ir0Var.g0.getLayoutManager()).P0();
        lf lfVar = this.a.j;
        Calendar calendarA = sq1.a(lfVar.g.g);
        calendarA.add(2, iO0);
        ir0Var.c0 = new pu0(calendarA);
        Calendar calendarA2 = sq1.a(lfVar.g.g);
        calendarA2.add(2, iO0);
        calendarA2.set(5, 1);
        Calendar calendarA3 = sq1.a(calendarA2);
        calendarA3.get(2);
        calendarA3.get(1);
        calendarA3.getMaximum(7);
        calendarA3.getActualMaximum(5);
        calendarA3.getTimeInMillis();
        this.b.setText(DateUtils.formatDateTime(null, calendarA3.getTimeInMillis(), 8228));
    }
}
