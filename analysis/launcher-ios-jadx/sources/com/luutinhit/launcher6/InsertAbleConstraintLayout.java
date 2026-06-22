package com.luutinhit.launcher6;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import defpackage.fg0;
import defpackage.g71;
import defpackage.xf0;

/* JADX INFO: loaded from: classes.dex */
public class InsertAbleConstraintLayout extends ConstraintLayout implements ViewGroup.OnHierarchyChangeListener, fg0 {
    protected Rect mInsets;

    public InsertAbleConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInsets = new Rect();
        setOnHierarchyChangeListener(this);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof xf0;
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
        xf0 xf0Var = (xf0) view.getLayoutParams();
        if (view instanceof fg0) {
            ((fg0) view).setInsets(rect);
        } else if (!xf0Var.q0) {
            ((ViewGroup.MarginLayoutParams) xf0Var).topMargin = (rect.top - rect2.top) + ((ViewGroup.MarginLayoutParams) xf0Var).topMargin;
            ((ViewGroup.MarginLayoutParams) xf0Var).leftMargin = (rect.left - rect2.left) + ((ViewGroup.MarginLayoutParams) xf0Var).leftMargin;
            ((ViewGroup.MarginLayoutParams) xf0Var).rightMargin = (rect.right - rect2.right) + ((ViewGroup.MarginLayoutParams) xf0Var).rightMargin;
            ((ViewGroup.MarginLayoutParams) xf0Var).bottomMargin = (rect.bottom - rect2.bottom) + ((ViewGroup.MarginLayoutParams) xf0Var).bottomMargin;
        }
        view.setLayoutParams(xf0Var);
    }

    @Override // defpackage.fg0
    public void setInsets(Rect rect) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            setFrameLayoutChildInsets(getChildAt(i), rect, this.mInsets);
        }
        this.mInsets.set(rect);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public xf0 generateDefaultLayoutParams() {
        xf0 xf0Var = new xf0(-2, -2);
        xf0Var.q0 = false;
        return xf0Var;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public xf0 generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        xf0 xf0Var = new xf0(context, attributeSet);
        xf0Var.q0 = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.InsertAbleFrameLayout_Layout);
        xf0Var.q0 = typedArrayObtainStyledAttributes.getBoolean(g71.InsertAbleFrameLayout_Layout_layout_ignoreInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        return xf0Var;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public xf0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        xf0 xf0Var = new xf0(layoutParams);
        xf0Var.q0 = false;
        return xf0Var;
    }
}
