package defpackage;

import android.R;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.c;

/* JADX INFO: loaded from: classes.dex */
public final class ir0<S> extends a21 {
    public int a0;
    public lf b0;
    public pu0 c0;
    public int d0;
    public wb2 e0;
    public RecyclerView f0;
    public RecyclerView g0;
    public View h0;
    public View i0;

    @Override // defpackage.w50
    public final void G(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.a0);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.b0);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.c0);
    }

    public final void U(pu0 pu0Var) {
        c cVar = (c) this.g0.getAdapter();
        int iF = cVar.j.g.f(pu0Var);
        int iF2 = iF - cVar.j.g.f(this.c0);
        boolean z = Math.abs(iF2) > 3;
        boolean z2 = iF2 > 0;
        this.c0 = pu0Var;
        if (z && z2) {
            this.g0.l0(iF - 3);
            this.g0.post(new yf(this, iF, 2));
        } else if (!z) {
            this.g0.post(new yf(this, iF, 2));
        } else {
            this.g0.l0(iF + 3);
            this.g0.post(new yf(this, iF, 2));
        }
    }

    public final void V(int i) {
        this.d0 = i;
        if (i == 2) {
            this.f0.getLayoutManager().r0(this.c0.i - ((l02) this.f0.getAdapter()).j.b0.g.i);
            this.h0.setVisibility(0);
            this.i0.setVisibility(8);
            return;
        }
        if (i == 1) {
            this.h0.setVisibility(8);
            this.i0.setVisibility(0);
            U(this.c0);
        }
    }

    @Override // defpackage.w50
    public final void y(Bundle bundle) {
        super.y(bundle);
        if (bundle == null) {
            bundle = this.m;
        }
        this.a0 = bundle.getInt("THEME_RES_ID_KEY");
        if (bundle.getParcelable("GRID_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.b0 = (lf) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.c0 = (pu0) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // defpackage.w50
    public final View z(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        int i2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(p(), this.a0);
        this.e0 = new wb2(contextThemeWrapper, 5);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        pu0 pu0Var = this.b0.g;
        if (or0.X(contextThemeWrapper, R.attr.windowFullscreen)) {
            i = l61.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i = l61.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i, viewGroup, false);
        Resources resources = N().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(d51.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(d51.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(d51.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(d51.mtrl_calendar_days_of_week_height);
        int i3 = qu0.j;
        viewInflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(d51.mtrl_calendar_month_vertical_padding) * (i3 - 1)) + (resources.getDimensionPixelSize(d51.mtrl_calendar_day_height) * i3) + resources.getDimensionPixelOffset(d51.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) viewInflate.findViewById(u51.mtrl_calendar_days_of_week);
        qs1.p(gridView, new cr0(0));
        gridView.setAdapter((ListAdapter) new ms());
        gridView.setNumColumns(pu0Var.j);
        gridView.setEnabled(false);
        this.g0 = (RecyclerView) viewInflate.findViewById(u51.mtrl_calendar_months);
        this.g0.setLayoutManager(new dr0(this, i2, i2));
        this.g0.setTag("MONTHS_VIEW_GROUP_TAG");
        c cVar = new c(contextThemeWrapper, this.b0, new fz1(this, 21));
        this.g0.setAdapter(cVar);
        int integer = contextThemeWrapper.getResources().getInteger(h61.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(u51.mtrl_calendar_year_selector_frame);
        this.f0 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f0.setLayoutManager(new GridLayoutManager(integer, 0));
            this.f0.setAdapter(new l02(this));
            this.f0.k(new ph0(this));
        }
        if (viewInflate.findViewById(u51.month_navigation_fragment_toggle) != null) {
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(u51.month_navigation_fragment_toggle);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            qs1.p(materialButton, new yh(this, 2));
            MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(u51.month_navigation_previous);
            materialButton2.setTag("NAVIGATION_PREV_TAG");
            MaterialButton materialButton3 = (MaterialButton) viewInflate.findViewById(u51.month_navigation_next);
            materialButton3.setTag("NAVIGATION_NEXT_TAG");
            this.h0 = viewInflate.findViewById(u51.mtrl_calendar_year_selector_frame);
            this.i0 = viewInflate.findViewById(u51.mtrl_calendar_day_selector_frame);
            V(1);
            materialButton.setText(this.c0.e());
            this.g0.l(new er0(this, cVar, materialButton));
            materialButton.setOnClickListener(new fr0(this));
            materialButton3.setOnClickListener(new gr0(this, cVar));
            materialButton2.setOnClickListener(new hr0(this, cVar));
        }
        if (!or0.X(contextThemeWrapper, R.attr.windowFullscreen)) {
            new f11().a(this.g0);
        }
        this.g0.l0(cVar.j.g.f(this.c0));
        return viewInflate;
    }
}
