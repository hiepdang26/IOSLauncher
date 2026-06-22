package com.luutinhit.launcher6.leftpage.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.widget.view.TimeView;
import defpackage.dm0;
import defpackage.e51;
import defpackage.m61;
import defpackage.nm;
import defpackage.v51;

/* JADX INFO: loaded from: classes.dex */
public class ClockWidget extends dm0 {
    public final Context g;
    public final View h;
    public final TimeView i;

    public ClockWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.g = context;
        int i = (int) (((double) ((t) context).getDeviceProfile().C) * 0.68d);
        View viewInflate = LayoutInflater.from(context).inflate(m61.clock_widget, (ViewGroup) this, true);
        this.h = viewInflate;
        this.i = (TimeView) viewInflate.findViewById(v51.time_view);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(e51.clock_padding);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        ((nm) this.i.getLayoutParams()).setMargins(i, i, i, i);
    }

    @Override // defpackage.dm0
    public final void n() {
        this.i.invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View viewFindViewById = findViewById(v51.icon_delete_widget);
        int i = -((t) this.g).getDeviceProfile().A;
        viewFindViewById.setTranslationX(((t) this.g).isRTL ? -i : i);
        viewFindViewById.setTranslationY(i);
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
    }
}
