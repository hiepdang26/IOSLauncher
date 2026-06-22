package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;
import defpackage.ir0;
import defpackage.qu0;

/* JADX INFO: loaded from: classes.dex */
public final class a implements AdapterView.OnItemClickListener {
    public final /* synthetic */ MaterialCalendarGridView g;
    public final /* synthetic */ c h;

    public a(c cVar, MaterialCalendarGridView materialCalendarGridView) {
        this.h = cVar;
        this.g = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        MaterialCalendarGridView materialCalendarGridView = this.g;
        qu0 qu0VarA = materialCalendarGridView.a();
        if (i < qu0VarA.g.d() || i > qu0VarA.b()) {
            return;
        }
        if (materialCalendarGridView.a().getItem(i).longValue() >= ((ir0) this.h.k.h).b0.i.g) {
            throw null;
        }
    }
}
