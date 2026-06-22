package com.luutinhit.launcher6.util;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.zh1;

/* JADX INFO: loaded from: classes.dex */
public class SpeedLinearLayoutManager extends LinearLayoutManager {
    public SpeedLinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.u81
    public final void B0(RecyclerView recyclerView, int i) {
        zh1 zh1Var = new zh1(recyclerView.getContext(), 1);
        zh1Var.a = i;
        C0(zh1Var);
    }
}
