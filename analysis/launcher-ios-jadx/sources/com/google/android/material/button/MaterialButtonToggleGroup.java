package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.google.android.material.timepicker.e;
import defpackage.a7;
import defpackage.b71;
import defpackage.br0;
import defpackage.d;
import defpackage.f71;
import defpackage.mc1;
import defpackage.mn1;
import defpackage.ow1;
import defpackage.q41;
import defpackage.qg0;
import defpackage.qs1;
import defpackage.tr0;
import defpackage.vf1;
import defpackage.wf1;
import defpackage.yh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {
    public static final int q = b71.Widget_MaterialComponents_MaterialButtonToggleGroup;
    public final ArrayList g;
    public final ow1 h;
    public final LinkedHashSet i;
    public final a7 j;
    public Integer[] k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final int o;
    public HashSet p;

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        int i = q41.materialButtonToggleGroupStyle;
        int i2 = q;
        super(tr0.a(context, attributeSet, i, i2), attributeSet, i);
        this.g = new ArrayList();
        this.h = new ow1(this, 20);
        this.i = new LinkedHashSet();
        this.j = new a7(this, 3);
        this.l = false;
        this.p = new HashSet();
        TypedArray typedArrayD = mn1.d(getContext(), attributeSet, f71.MaterialButtonToggleGroup, i, i2, new int[0]);
        setSingleSelection(typedArrayD.getBoolean(f71.MaterialButtonToggleGroup_singleSelection, false));
        this.o = typedArrayD.getResourceId(f71.MaterialButtonToggleGroup_checkedButton, -1);
        this.n = typedArrayD.getBoolean(f71.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        typedArrayD.recycle();
        WeakHashMap weakHashMap = qs1.a;
        setImportantForAccessibility(1);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (c(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (c(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if ((getChildAt(i2) instanceof MaterialButton) && c(i2)) {
                i++;
            }
        }
        return i;
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            WeakHashMap weakHashMap = qs1.a;
            materialButton.setId(View.generateViewId());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.h);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public final void a() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i);
            int iMin = Math.min(materialButton.getStrokeWidth(), ((MaterialButton) getChildAt(i - 1)).getStrokeWidth());
            ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                layoutParams2.setMarginEnd(0);
                layoutParams2.setMarginStart(-iMin);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = -iMin;
                layoutParams2.setMarginStart(0);
            }
            materialButton.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
        } else {
            layoutParams3.setMarginEnd(0);
            layoutParams3.setMarginStart(0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof MaterialButton) {
            super.addView(view, i, layoutParams);
            MaterialButton materialButton = (MaterialButton) view;
            setGeneratedIdIfNeeded(materialButton);
            setupButtonChild(materialButton);
            b(materialButton.getId(), materialButton.q);
            wf1 shapeAppearanceModel = materialButton.getShapeAppearanceModel();
            this.g.add(new br0(shapeAppearanceModel.e, shapeAppearanceModel.h, shapeAppearanceModel.f, shapeAppearanceModel.g));
            qs1.p(materialButton, new yh(this, 1));
        }
    }

    public final void b(int i, boolean z) {
        if (i == -1) {
            return;
        }
        HashSet hashSet = new HashSet(this.p);
        if (z && !hashSet.contains(Integer.valueOf(i))) {
            if (this.m && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i));
        } else {
            if (z || !hashSet.contains(Integer.valueOf(i))) {
                return;
            }
            if (!this.n || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i));
            }
        }
        d(hashSet);
    }

    public final boolean c(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    public final void d(Set set) {
        HashSet hashSet = this.p;
        this.p = new HashSet(set);
        for (int i = 0; i < getChildCount(); i++) {
            int id = ((MaterialButton) getChildAt(i)).getId();
            boolean zContains = set.contains(Integer.valueOf(id));
            View viewFindViewById = findViewById(id);
            if (viewFindViewById instanceof MaterialButton) {
                this.l = true;
                ((MaterialButton) viewFindViewById).setChecked(zContains);
                this.l = false;
            }
            if (hashSet.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                set.contains(Integer.valueOf(id));
                Iterator it = this.i.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).a();
                }
            }
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.j);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put((MaterialButton) getChildAt(i), Integer.valueOf(i));
        }
        this.k = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e() {
        br0 br0Var;
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i = 0; i < childCount; i++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i);
            if (materialButton.getVisibility() != 8) {
                vf1 vf1VarE = materialButton.getShapeAppearanceModel().e();
                br0 br0Var2 = (br0) this.g.get(i);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    boolean z = getOrientation() == 0;
                    d dVar = br0.e;
                    if (i == firstVisibleChildIndex) {
                        br0Var = z ? qg0.y(this) ? new br0(dVar, dVar, br0Var2.b, br0Var2.c) : new br0(br0Var2.a, br0Var2.d, dVar, dVar) : new br0(br0Var2.a, dVar, br0Var2.b, dVar);
                    } else if (i == lastVisibleChildIndex) {
                        br0Var = z ? qg0.y(this) ? new br0(br0Var2.a, br0Var2.d, dVar, dVar) : new br0(dVar, dVar, br0Var2.b, br0Var2.c) : new br0(dVar, br0Var2.d, dVar, br0Var2.c);
                    } else {
                        br0Var2 = null;
                    }
                    br0Var2 = br0Var;
                }
                if (br0Var2 == null) {
                    vf1VarE.e = new d(0.0f);
                    vf1VarE.f = new d(0.0f);
                    vf1VarE.g = new d(0.0f);
                    vf1VarE.h = new d(0.0f);
                } else {
                    vf1VarE.e = br0Var2.a;
                    vf1VarE.h = br0Var2.d;
                    vf1VarE.f = br0Var2.b;
                    vf1VarE.g = br0Var2.c;
                }
                materialButton.setShapeAppearanceModel(vf1VarE.a());
            }
        }
    }

    public int getCheckedButtonId() {
        if (!this.m || this.p.isEmpty()) {
            return -1;
        }
        return ((Integer) this.p.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            int id = ((MaterialButton) getChildAt(i)).getId();
            if (this.p.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i2) {
        Integer[] numArr = this.k;
        return (numArr == null || i2 >= numArr.length) ? i2 : numArr[i2].intValue();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i = this.o;
        if (i != -1) {
            d(Collections.singleton(Integer.valueOf(i)));
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) mc1.v(1, getVisibleButtonCount(), this.m ? 1 : 2).h);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        e();
        a();
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.g.remove(iIndexOfChild);
        }
        e();
        a();
    }

    public void setSelectionRequired(boolean z) {
        this.n = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.m != z) {
            this.m = z;
            d(new HashSet());
        }
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }
}
