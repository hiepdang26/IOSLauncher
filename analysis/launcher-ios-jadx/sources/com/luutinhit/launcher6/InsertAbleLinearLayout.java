package com.luutinhit.launcher6;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.luutinhit.launcher6.util.overscroll.OverScrollLayout;
import defpackage.bg0;
import defpackage.fg0;
import defpackage.g71;

/* JADX INFO: loaded from: classes.dex */
public class InsertAbleLinearLayout extends OverScrollLayout implements ViewGroup.OnHierarchyChangeListener, fg0 {
    protected Rect mInsets;

    public InsertAbleLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInsets = new Rect();
        setOnHierarchyChangeListener(this);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof bg0;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        setLinearLayoutChildInsets(view2, this.mInsets, new Rect());
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
    }

    @Override // defpackage.fg0
    public void setInsets(Rect rect) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            setLinearLayoutChildInsets(getChildAt(i), rect, this.mInsets);
        }
        this.mInsets.set(rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setLinearLayoutChildInsets(View view, Rect rect, Rect rect2) {
        bg0 bg0Var = (bg0) view.getLayoutParams();
        if (view instanceof fg0) {
            ((fg0) view).setInsets(rect);
        } else if (!bg0Var.a) {
            ((LinearLayout.LayoutParams) bg0Var).topMargin = (rect.top - rect2.top) + ((LinearLayout.LayoutParams) bg0Var).topMargin;
            ((LinearLayout.LayoutParams) bg0Var).leftMargin = (rect.left - rect2.left) + ((LinearLayout.LayoutParams) bg0Var).leftMargin;
            ((LinearLayout.LayoutParams) bg0Var).rightMargin = (rect.right - rect2.right) + ((LinearLayout.LayoutParams) bg0Var).rightMargin;
            ((LinearLayout.LayoutParams) bg0Var).bottomMargin = (rect.bottom - rect2.bottom) + ((LinearLayout.LayoutParams) bg0Var).bottomMargin;
        }
        view.setLayoutParams(bg0Var);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public bg0 generateDefaultLayoutParams() {
        bg0 bg0Var = new bg0(-2, -2);
        bg0Var.a = false;
        return bg0Var;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public bg0 generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        bg0 bg0Var = new bg0(context, attributeSet);
        bg0Var.a = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.InsertAbleFrameLayout_Layout);
        bg0Var.a = typedArrayObtainStyledAttributes.getBoolean(g71.InsertAbleFrameLayout_Layout_layout_ignoreInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        return bg0Var;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public bg0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        bg0 bg0Var = new bg0(layoutParams);
        bg0Var.a = false;
        return bg0Var;
    }
}
