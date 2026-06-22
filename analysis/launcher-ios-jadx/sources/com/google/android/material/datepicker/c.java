package com.google.android.material.datepicker;

import android.R;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import defpackage.d51;
import defpackage.fz1;
import defpackage.l61;
import defpackage.lf;
import defpackage.m81;
import defpackage.m91;
import defpackage.or0;
import defpackage.pu0;
import defpackage.qu0;
import defpackage.sq1;
import defpackage.u51;
import defpackage.v81;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public final class c extends m81 {
    public final lf j;
    public final fz1 k;
    public final int l;

    public c(ContextThemeWrapper contextThemeWrapper, lf lfVar, fz1 fz1Var) {
        pu0 pu0Var = lfVar.g;
        pu0 pu0Var2 = lfVar.j;
        if (pu0Var.compareTo(pu0Var2) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (pu0Var2.compareTo(lfVar.h) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.l = (contextThemeWrapper.getResources().getDimensionPixelSize(d51.mtrl_calendar_day_height) * qu0.j) + (or0.X(contextThemeWrapper, R.attr.windowFullscreen) ? contextThemeWrapper.getResources().getDimensionPixelSize(d51.mtrl_calendar_day_height) : 0);
        this.j = lfVar;
        this.k = fz1Var;
        o(true);
    }

    @Override // defpackage.m81
    public final int c() {
        return this.j.l;
    }

    @Override // defpackage.m81
    public final long d(int i) {
        Calendar calendarA = sq1.a(this.j.g.g);
        calendarA.add(2, i);
        calendarA.set(5, 1);
        Calendar calendarA2 = sq1.a(calendarA);
        calendarA2.get(2);
        calendarA2.get(1);
        calendarA2.getMaximum(7);
        calendarA2.getActualMaximum(5);
        calendarA2.getTimeInMillis();
        return calendarA2.getTimeInMillis();
    }

    @Override // defpackage.m81
    public final void i(m91 m91Var, int i) {
        b bVar = (b) m91Var;
        lf lfVar = this.j;
        Calendar calendarA = sq1.a(lfVar.g.g);
        calendarA.add(2, i);
        pu0 pu0Var = new pu0(calendarA);
        bVar.A.setText(pu0Var.e());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.B.findViewById(u51.month_grid);
        if (materialCalendarGridView.a() == null || !pu0Var.equals(materialCalendarGridView.a().g)) {
            new qu0(pu0Var, lfVar);
            throw null;
        }
        materialCalendarGridView.invalidate();
        materialCalendarGridView.a().getClass();
        throw null;
    }

    @Override // defpackage.m81
    public final m91 j(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(l61.mtrl_calendar_month_labeled, viewGroup, false);
        if (!or0.X(viewGroup.getContext(), R.attr.windowFullscreen)) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new v81(-1, this.l));
        return new b(linearLayout, true);
    }
}
