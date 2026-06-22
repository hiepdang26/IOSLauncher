package com.luutinhit.launcher6.appslibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import defpackage.fg0;
import defpackage.g71;
import defpackage.vw;
import defpackage.yf0;

/* JADX INFO: loaded from: classes.dex */
public class InsertAbleDragLayout extends vw implements ViewGroup.OnHierarchyChangeListener, fg0 {
    protected Rect mInsets;

    public InsertAbleDragLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInsets = new Rect();
        setOnHierarchyChangeListener(this);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof yf0;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        setFrameLayoutChildInsets(view2, this.mInsets, new Rect());
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setFrameLayoutChildInsets(View view, Rect rect, Rect rect2) {
        yf0 yf0Var = (yf0) view.getLayoutParams();
        if (view instanceof fg0) {
            ((fg0) view).setInsets(rect);
        } else if (!yf0Var.a) {
            ((FrameLayout.LayoutParams) yf0Var).topMargin = (rect.top - rect2.top) + ((FrameLayout.LayoutParams) yf0Var).topMargin;
            ((FrameLayout.LayoutParams) yf0Var).leftMargin = (rect.left - rect2.left) + ((FrameLayout.LayoutParams) yf0Var).leftMargin;
            ((FrameLayout.LayoutParams) yf0Var).rightMargin = (rect.right - rect2.right) + ((FrameLayout.LayoutParams) yf0Var).rightMargin;
            ((FrameLayout.LayoutParams) yf0Var).bottomMargin = (rect.bottom - rect2.bottom) + ((FrameLayout.LayoutParams) yf0Var).bottomMargin;
        }
        view.setLayoutParams(yf0Var);
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
    public yf0 generateDefaultLayoutParams() {
        yf0 yf0Var = new yf0(-2, -2);
        yf0Var.a = false;
        return yf0Var;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public yf0 generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        yf0 yf0Var = new yf0(context, attributeSet);
        yf0Var.a = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.InsertAbleFrameLayout_Layout);
        yf0Var.a = typedArrayObtainStyledAttributes.getBoolean(g71.InsertAbleFrameLayout_Layout_layout_ignoreInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        return yf0Var;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public yf0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        yf0 yf0Var = new yf0(layoutParams);
        yf0Var.a = false;
        return yf0Var;
    }
}
