package com.luutinhit.launcherios.searchview.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class ExpandableHeightRecyclerView extends RecyclerView {
    public ExpandableHeightRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int i, int i2) {
        try {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(536870911, RtlSpacingHelper.UNDEFINED);
            setMeasuredDimension(i, iMakeMeasureSpec);
            super.onMeasure(i, iMakeMeasureSpec);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
