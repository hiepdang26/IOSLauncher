package com.luutinhit.launcher6.leftpage.adapter;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import defpackage.c91;
import defpackage.i91;

/* JADX INFO: loaded from: classes.dex */
public class WrapStaggeredGridLayoutManager extends StaggeredGridLayoutManager {
    public WrapStaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, defpackage.u81
    public final void e0(c91 c91Var, i91 i91Var) {
        try {
            V0(c91Var, i91Var, true);
        } catch (Throwable unused) {
        }
    }
}
