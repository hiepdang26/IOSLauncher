package com.luutinhit.launcher6;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import defpackage.cg0;
import defpackage.fg0;
import defpackage.g71;

/* JADX INFO: loaded from: classes.dex */
public class InsertAbleMotionLayout extends MotionLayout implements ViewGroup.OnHierarchyChangeListener, fg0 {
    protected Rect mInsets;

    public InsertAbleMotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInsets = new Rect();
        setOnHierarchyChangeListener(this);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof cg0;
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
        cg0 cg0Var = (cg0) view.getLayoutParams();
        if (view instanceof fg0) {
            ((fg0) view).setInsets(rect);
        } else if (!cg0Var.q0) {
            ((ViewGroup.MarginLayoutParams) cg0Var).topMargin = (rect.top - rect2.top) + ((ViewGroup.MarginLayoutParams) cg0Var).topMargin;
            ((ViewGroup.MarginLayoutParams) cg0Var).leftMargin = (rect.left - rect2.left) + ((ViewGroup.MarginLayoutParams) cg0Var).leftMargin;
            ((ViewGroup.MarginLayoutParams) cg0Var).rightMargin = (rect.right - rect2.right) + ((ViewGroup.MarginLayoutParams) cg0Var).rightMargin;
            ((ViewGroup.MarginLayoutParams) cg0Var).bottomMargin = (rect.bottom - rect2.bottom) + ((ViewGroup.MarginLayoutParams) cg0Var).bottomMargin;
        }
        view.setLayoutParams(cg0Var);
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
    public cg0 generateDefaultLayoutParams() {
        cg0 cg0Var = new cg0(-2, -2);
        cg0Var.q0 = false;
        return cg0Var;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public cg0 generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        cg0 cg0Var = new cg0(context, attributeSet);
        cg0Var.q0 = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.InsertAbleFrameLayout_Layout);
        cg0Var.q0 = typedArrayObtainStyledAttributes.getBoolean(g71.InsertAbleFrameLayout_Layout_layout_ignoreInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        return cg0Var;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public cg0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        cg0 cg0Var = new cg0(layoutParams);
        cg0Var.q0 = false;
        return cg0Var;
    }
}
