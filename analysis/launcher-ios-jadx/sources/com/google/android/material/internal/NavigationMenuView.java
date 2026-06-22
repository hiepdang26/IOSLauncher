package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.gt0;
import defpackage.yt0;

/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuView extends RecyclerView implements yt0 {
    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setLayoutManager(new LinearLayoutManager(1));
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // defpackage.yt0
    public final void initialize(gt0 gt0Var) {
    }
}
