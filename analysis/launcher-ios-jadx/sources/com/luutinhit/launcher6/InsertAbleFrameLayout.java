package com.luutinhit.launcher6;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import defpackage.ag0;
import defpackage.fg0;

/* JADX INFO: loaded from: classes.dex */
public class InsertAbleFrameLayout extends FrameLayout implements ViewGroup.OnHierarchyChangeListener, fg0 {
    protected Rect mInsets;

    public InsertAbleFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInsets = new Rect();
        setOnHierarchyChangeListener(this);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ag0;
    }

    public void onChildViewAdded(View view, View view2) {
        setFrameLayoutChildInsets(view2, this.mInsets, new Rect());
    }

    public void onChildViewRemoved(View view, View view2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setFrameLayoutChildInsets(View view, Rect rect, Rect rect2) {
        ag0 ag0Var = (ag0) view.getLayoutParams();
        if (view instanceof fg0) {
            ((fg0) view).setInsets(rect);
        } else if (!ag0Var.a) {
            ((FrameLayout.LayoutParams) ag0Var).topMargin = (rect.top - rect2.top) + ((FrameLayout.LayoutParams) ag0Var).topMargin;
            ((FrameLayout.LayoutParams) ag0Var).leftMargin = (rect.left - rect2.left) + ((FrameLayout.LayoutParams) ag0Var).leftMargin;
            ((FrameLayout.LayoutParams) ag0Var).rightMargin = (rect.right - rect2.right) + ((FrameLayout.LayoutParams) ag0Var).rightMargin;
            ((FrameLayout.LayoutParams) ag0Var).bottomMargin = (rect.bottom - rect2.bottom) + ((FrameLayout.LayoutParams) ag0Var).bottomMargin;
        }
        view.setLayoutParams(ag0Var);
    }

    @Override // defpackage.fg0
    public void setInsets(Rect rect) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            setFrameLayoutChildInsets(getChildAt(i), rect, this.mInsets);
        }
        this.mInsets.set(rect);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public ag0 generateDefaultLayoutParams() {
        return new ag0(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public ag0 generateLayoutParams(AttributeSet attributeSet) {
        return new ag0(getContext(), attributeSet);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public ag0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ag0(layoutParams);
    }
}
