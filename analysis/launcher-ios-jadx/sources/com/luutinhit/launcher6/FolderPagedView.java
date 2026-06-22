package com.luutinhit.launcher6;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import defpackage.ar1;
import defpackage.c11;
import defpackage.g40;
import defpackage.jk0;
import defpackage.l51;
import defpackage.m61;
import defpackage.ng1;
import defpackage.oe0;
import defpackage.og1;
import defpackage.v01;
import defpackage.v51;
import defpackage.w61;
import defpackage.xg0;
import defpackage.xu;
import defpackage.zg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class FolderPagedView extends v {
    public static final int[] H0 = new int[2];
    public int A0;
    public int B0;
    public int C0;
    public Folder D0;
    public FocusIndicatorView E0;
    public g40 F0;
    public PageIndicator G0;
    public final boolean t0;
    public final LayoutInflater u0;
    public final oe0 v0;
    public final HashMap w0;
    public final int x0;
    public final int y0;
    public final int z0;

    public FolderPagedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w0 = new HashMap();
        jk0 jk0VarA = jk0.a();
        xg0 xg0Var = jk0VarA.e;
        int i = xg0Var.f;
        this.x0 = i;
        int i2 = xg0Var.e;
        this.y0 = i2;
        this.z0 = i * i2;
        this.u0 = LayoutInflater.from(context);
        this.v0 = jk0VarA.b;
        this.t0 = ar1.v(getResources());
        setImportantForAccessibility(1);
    }

    private void setupContentDimensions(int i) {
        this.A0 = i;
        this.B0 = this.x0;
        this.C0 = this.y0;
        for (int pageCount = getPageCount() - 1; pageCount >= 0; pageCount--) {
            ((CellLayout) getChildAt(pageCount)).F(this.B0, this.C0);
        }
    }

    @Override // com.luutinhit.launcher6.v
    public final View C(int i) {
        return (CellLayout) getChildAt(i);
    }

    @Override // com.luutinhit.launcher6.v
    public final v01 D(int i) {
        return new v01(l51.ic_indicator_current);
    }

    @Override // com.luutinhit.launcher6.v
    public final void K() {
        c11 c11Var = this.T;
        if (c11Var != null) {
            c11Var.onPageSwitch(C(getNextPage()), getNextPage());
        }
        PageIndicator pageIndicator = this.c0;
        if (pageIndicator != null) {
            pageIndicator.setContentDescription(getPageIndicatorDescription());
            if (!this.k0) {
                this.c0.setActiveMarker(getNextPage());
            }
        }
        Folder folder = this.D0;
        if (folder != null) {
            folder.M();
        }
    }

    @Override // com.luutinhit.launcher6.v
    public final void M() {
        int[] iArr = H0;
        F(iArr);
        for (int i = iArr[0]; i <= iArr[1]; i++) {
            n0(i);
        }
    }

    public String getAccessibilityDescription() {
        return String.format(getContext().getString(w61.folder_opened), Integer.valueOf(this.B0), Integer.valueOf(this.C0));
    }

    public int getAllocatedContentSize() {
        return this.A0;
    }

    @Override // com.luutinhit.launcher6.v
    public int getChildGap() {
        return getPaddingRight() + getPaddingLeft();
    }

    public CellLayout getCurrentCellLayout() {
        return (CellLayout) getChildAt(getNextPage());
    }

    public int getDesiredHeight() {
        if (getPageCount() <= 0) {
            return 0;
        }
        return getPaddingBottom() + getPaddingTop() + ((CellLayout) getChildAt(0)).getDesiredHeight();
    }

    public int getDesiredWidth() {
        if (getPageCount() <= 0) {
            return 0;
        }
        return getPaddingRight() + getPaddingLeft() + ((CellLayout) getChildAt(0)).getDesiredWidth();
    }

    public View getFirstItem() {
        if (getChildCount() < 1) {
            return null;
        }
        ng1 shortcutsAndWidgets = getCurrentCellLayout().getShortcutsAndWidgets();
        return this.B0 > 0 ? shortcutsAndWidgets.b(0, 0) : shortcutsAndWidgets.getChildAt(0);
    }

    public int getItemCount() {
        int childCount = getChildCount() - 1;
        if (childCount < 0) {
            return 0;
        }
        return (childCount * this.z0) + ((CellLayout) getChildAt(childCount)).getShortcutsAndWidgets().getChildCount();
    }

    public View getLastItem() {
        if (getChildCount() < 1) {
            return null;
        }
        ng1 shortcutsAndWidgets = getCurrentCellLayout().getShortcutsAndWidgets();
        int childCount = shortcutsAndWidgets.getChildCount() - 1;
        int i = this.B0;
        return i > 0 ? shortcutsAndWidgets.b(childCount % i, childCount / i) : shortcutsAndWidgets.getChildAt(childCount);
    }

    public final void i0(View view, og1 og1Var, int i) {
        int i2 = this.z0;
        int i3 = i % i2;
        int i4 = i / i2;
        og1Var.q = i;
        int i5 = this.B0;
        og1Var.k = i3 % i5;
        og1Var.l = i3 / i5;
        zg zgVar = (zg) view.getLayoutParams();
        zgVar.a = og1Var.k;
        zgVar.b = og1Var.l;
        ((CellLayout) getChildAt(i4)).a(view, -1, this.D0.n.getViewIdForItem(og1Var), zgVar, true);
    }

    public final int j0() {
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList(this.D0.getItemsInReadingOrder());
        arrayList.add(itemCount, null);
        k0(arrayList.size(), arrayList, false);
        setCurrentPage(itemCount / this.z0);
        return itemCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c5  */
    /* JADX WARN: Type inference failed for: r12v1, types: [com.luutinhit.launcher6.CellLayout] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r24v0, types: [android.view.View, android.view.ViewGroup, com.luutinhit.launcher6.FolderPagedView, com.luutinhit.launcher6.v] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k0(int r25, java.util.ArrayList r26, boolean r27) {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.FolderPagedView.k0(int, java.util.ArrayList, boolean):void");
    }

    public final void l0() {
        HashMap map = this.w0;
        if (map.isEmpty()) {
            return;
        }
        for (Map.Entry entry : new HashMap(map).entrySet()) {
            ((View) entry.getKey()).animate().cancel();
            ((Runnable) entry.getValue()).run();
        }
    }

    public final BubbleTextView m0(og1 og1Var) {
        BubbleTextView bubbleTextView = (BubbleTextView) this.u0.inflate(m61.folder_application, (ViewGroup) null, false);
        Bitmap bitmap = og1Var.C;
        oe0 oe0Var = this.v0;
        if (bitmap == null) {
            og1Var.i(oe0Var);
        }
        og1Var.C.getWidth();
        bubbleTextView.o(og1Var, oe0Var, false);
        bubbleTextView.setOnClickListener(this.D0);
        bubbleTextView.setOnLongClickListener(this.D0);
        bubbleTextView.setOnFocusChangeListener(this.E0);
        bubbleTextView.setLongPressTimeout(1369);
        bubbleTextView.setOnKeyListener(this.F0);
        bubbleTextView.setTextColor(this.D0.n.mIconTextColor);
        bubbleTextView.setLayoutParams(new zg(og1Var.k, og1Var.l, og1Var.m, og1Var.n));
        return bubbleTextView;
    }

    public final void n0(int i) {
        try {
            CellLayout cellLayout = (CellLayout) getChildAt(i);
            if (cellLayout != null) {
                ng1 shortcutsAndWidgets = cellLayout.getShortcutsAndWidgets();
                for (int childCount = shortcutsAndWidgets.getChildCount() - 1; childCount >= 0; childCount--) {
                    ((BubbleTextView) shortcutsAndWidgets.getChildAt(childCount)).A();
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void setFolder(Folder folder) {
        this.D0 = folder;
        this.E0 = (FocusIndicatorView) folder.findViewById(v51.focus_indicator);
        this.F0 = new g40(folder, 0);
        this.G0 = (PageIndicator) folder.findViewById(v51.folder_page_indicator);
        xu deviceProfile = jk0.a().g.getDeviceProfile();
        this.G0.getLayoutParams().height = (int) (((double) deviceProfile.C) * 1.6d);
    }

    public void setMarkerScale(float f) {
        int childCount = this.G0.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.G0.getChildAt(i);
            childAt.animate().cancel();
            childAt.setScaleX(f);
            childAt.setScaleY(f);
        }
    }
}
