package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import defpackage.ds1;
import defpackage.m91;
import defpackage.qs1;
import defpackage.u51;
import defpackage.y51;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class b extends m91 {
    public final TextView A;
    public final MaterialCalendarGridView B;

    public b(LinearLayout linearLayout, boolean z) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(u51.month_title);
        this.A = textView;
        WeakHashMap weakHashMap = qs1.a;
        new ds1(y51.tag_accessibility_heading, Boolean.class, 0, 28, 3).f(textView, Boolean.TRUE);
        this.B = (MaterialCalendarGridView) linearLayout.findViewById(u51.month_grid);
        if (z) {
            return;
        }
        textView.setVisibility(8);
    }
}
