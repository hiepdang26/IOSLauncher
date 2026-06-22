package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import defpackage.b71;
import defpackage.f40;
import defpackage.f71;
import defpackage.fz1;
import defpackage.li;
import defpackage.lr0;
import defpackage.mc1;
import defpackage.mi;
import defpackage.mn1;
import defpackage.ni;
import defpackage.oi;
import defpackage.ow1;
import defpackage.q41;
import defpackage.qs1;
import defpackage.tr0;
import defpackage.xh;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ChipGroup extends f40 {
    public static final int q = b71.Widget_MaterialComponents_ChipGroup;
    public int k;
    public int l;
    public ni m;
    public final xh n;
    public final int o;
    public final oi p;

    /* JADX WARN: Illegal instructions before constructor call */
    public ChipGroup(Context context, AttributeSet attributeSet) {
        int i = q41.chipGroupStyle;
        int i2 = q;
        Context contextA = tr0.a(context, attributeSet, i, i2);
        super(contextA, attributeSet, i);
        this.i = false;
        TypedArray typedArrayObtainStyledAttributes = contextA.getTheme().obtainStyledAttributes(attributeSet, f71.FlowLayout, 0, 0);
        this.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(f71.FlowLayout_lineSpacing, 0);
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(f71.FlowLayout_itemSpacing, 0);
        typedArrayObtainStyledAttributes.recycle();
        xh xhVar = new xh(0);
        this.n = xhVar;
        oi oiVar = new oi(this);
        this.p = oiVar;
        TypedArray typedArrayD = mn1.d(getContext(), attributeSet, f71.ChipGroup, i, i2, new int[0]);
        int dimensionPixelOffset = typedArrayD.getDimensionPixelOffset(f71.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(typedArrayD.getDimensionPixelOffset(f71.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(typedArrayD.getDimensionPixelOffset(f71.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(typedArrayD.getBoolean(f71.ChipGroup_singleLine, false));
        setSingleSelection(typedArrayD.getBoolean(f71.ChipGroup_singleSelection, false));
        setSelectionRequired(typedArrayD.getBoolean(f71.ChipGroup_selectionRequired, false));
        this.o = typedArrayD.getResourceId(f71.ChipGroup_checkedChip, -1);
        typedArrayD.recycle();
        xhVar.e = new ow1(this, 7);
        super.setOnHierarchyChangeListener(oiVar);
        WeakHashMap weakHashMap = qs1.a;
        setImportantForAccessibility(1);
    }

    private int getChipCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof Chip) {
                i++;
            }
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof li);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new li(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new li(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        return this.n.c();
    }

    public List<Integer> getCheckedChipIds() {
        return this.n.b(this);
    }

    public int getChipSpacingHorizontal() {
        return this.k;
    }

    public int getChipSpacingVertical() {
        return this.l;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i = this.o;
        if (i != -1) {
            xh xhVar = this.n;
            lr0 lr0Var = (lr0) ((HashMap) xhVar.c).get(Integer.valueOf(i));
            if (lr0Var != null && xhVar.a(lr0Var)) {
                xhVar.d();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) mc1.v(getRowCount(), this.i ? getChipCount() : -1, this.n.a ? 1 : 2).h);
    }

    public void setChipSpacing(int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    public void setChipSpacingHorizontal(int i) {
        if (this.k != i) {
            this.k = i;
            setItemSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingResource(int i) {
        setChipSpacing(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingVertical(int i) {
        if (this.l != i) {
            this.l = i;
            setLineSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(mi miVar) {
        if (miVar == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new fz1(this, 7));
        }
    }

    public void setOnCheckedStateChangeListener(ni niVar) {
        this.m = niVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.p.g = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z) {
        this.n.b = z;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // defpackage.f40
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleSelection(boolean z) {
        xh xhVar = this.n;
        if (xhVar.a != z) {
            xhVar.a = z;
            boolean zIsEmpty = ((HashSet) xhVar.d).isEmpty();
            Iterator it = ((HashMap) xhVar.c).values().iterator();
            while (it.hasNext()) {
                xhVar.e((lr0) it.next(), false);
            }
            if (zIsEmpty) {
                return;
            }
            xhVar.d();
        }
    }

    public void setSingleLine(int i) {
        setSingleLine(getResources().getBoolean(i));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new li(layoutParams);
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }
}
