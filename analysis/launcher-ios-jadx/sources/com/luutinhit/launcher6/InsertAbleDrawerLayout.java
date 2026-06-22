package com.luutinhit.launcher6;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.drawerlayout.widget.DrawerLayout;
import defpackage.fg0;
import defpackage.g71;
import defpackage.zf0;

/* JADX INFO: loaded from: classes.dex */
public class InsertAbleDrawerLayout extends DrawerLayout implements ViewGroup.OnHierarchyChangeListener, fg0 {
    protected Rect mInsets;

    public InsertAbleDrawerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInsets = new Rect();
        setOnHierarchyChangeListener(this);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof zf0;
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
        zf0 zf0Var = (zf0) view.getLayoutParams();
        if (view instanceof fg0) {
            ((fg0) view).setInsets(rect);
        } else if (!zf0Var.e) {
            ((ViewGroup.MarginLayoutParams) zf0Var).topMargin = (rect.top - rect2.top) + ((ViewGroup.MarginLayoutParams) zf0Var).topMargin;
            ((ViewGroup.MarginLayoutParams) zf0Var).leftMargin = (rect.left - rect2.left) + ((ViewGroup.MarginLayoutParams) zf0Var).leftMargin;
            ((ViewGroup.MarginLayoutParams) zf0Var).rightMargin = (rect.right - rect2.right) + ((ViewGroup.MarginLayoutParams) zf0Var).rightMargin;
            ((ViewGroup.MarginLayoutParams) zf0Var).bottomMargin = (rect.bottom - rect2.bottom) + ((ViewGroup.MarginLayoutParams) zf0Var).bottomMargin;
        }
        view.setLayoutParams(zf0Var);
    }

    @Override // defpackage.fg0
    public void setInsets(Rect rect) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            setFrameLayoutChildInsets(getChildAt(i), rect, this.mInsets);
        }
        this.mInsets.set(rect);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup
    public zf0 generateDefaultLayoutParams() {
        zf0 zf0Var = new zf0(-2, -2);
        zf0Var.e = false;
        return zf0Var;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup
    public zf0 generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        zf0 zf0Var = new zf0(context, attributeSet);
        zf0Var.e = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.InsertAbleFrameLayout_Layout);
        zf0Var.e = typedArrayObtainStyledAttributes.getBoolean(g71.InsertAbleFrameLayout_Layout_layout_ignoreInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        return zf0Var;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup
    public zf0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        zf0 zf0Var = new zf0(layoutParams);
        zf0Var.e = false;
        return zf0Var;
    }
}
