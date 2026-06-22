package com.google.android.material.datepicker;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.appcompat.widget.RtlSpacingHelper;
import defpackage.cr0;
import defpackage.or0;
import defpackage.q41;
import defpackage.qs1;
import defpackage.qu0;
import defpackage.sq1;
import defpackage.u51;

/* JADX INFO: loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {
    public final boolean g;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        sq1.c(null);
        if (or0.X(getContext(), R.attr.windowFullscreen)) {
            setNextFocusLeftId(u51.cancel_button);
            setNextFocusRightId(u51.confirm_button);
        }
        this.g = or0.X(getContext(), q41.nestedScrollable);
        qs1.p(this, new cr0(1));
    }

    public final qu0 a() {
        return (qu0) super.getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final Adapter getAdapter() {
        return (qu0) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((qu0) super.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        qu0 qu0Var = (qu0) super.getAdapter();
        qu0Var.getClass();
        int iMax = Math.max(qu0Var.g.d(), getFirstVisiblePosition());
        int iMin = Math.min(qu0Var.b(), getLastVisiblePosition());
        qu0Var.getItem(iMax);
        qu0Var.getItem(iMin);
        throw null;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        if (!z) {
            super.onFocusChanged(false, i, rect);
            return;
        }
        if (i == 33) {
            setSelection(((qu0) super.getAdapter()).b());
        } else if (i == 130) {
            setSelection(((qu0) super.getAdapter()).g.d());
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= ((qu0) super.getAdapter()).g.d()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(((qu0) super.getAdapter()).g.d());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int i, int i2) {
        if (!this.g) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(16777215, RtlSpacingHelper.UNDEFINED));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int i) {
        if (i < ((qu0) super.getAdapter()).g.d()) {
            super.setSelection(((qu0) super.getAdapter()).g.d());
        } else {
            super.setSelection(i);
        }
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final ListAdapter getAdapter() {
        return (qu0) super.getAdapter();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof qu0)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), qu0.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }
}
