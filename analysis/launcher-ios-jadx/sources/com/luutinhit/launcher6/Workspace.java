package com.luutinhit.launcher6;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.WallpaperManager;
import android.appwidget.AppWidgetHostView;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.constraintlayout.motion.widget.Key;
import com.luutinhit.launcher6.leftpage.SlidingUpWidgetsAppStyle;
import com.luutinhit.launcher6.leftpage.SlidingUpWidgetsList;
import defpackage.a02;
import defpackage.ac0;
import defpackage.ar1;
import defpackage.c02;
import defpackage.c11;
import defpackage.ck0;
import defpackage.d02;
import defpackage.dk0;
import defpackage.dl0;
import defpackage.ek;
import defpackage.el0;
import defpackage.f02;
import defpackage.fg0;
import defpackage.g3;
import defpackage.g61;
import defpackage.g71;
import defpackage.j40;
import defpackage.jj1;
import defpackage.jk0;
import defpackage.jq1;
import defpackage.l51;
import defpackage.lw;
import defpackage.m61;
import defpackage.mw;
import defpackage.ng;
import defpackage.ng1;
import defpackage.nx;
import defpackage.o01;
import defpackage.oe0;
import defpackage.og1;
import defpackage.ox;
import defpackage.pk0;
import defpackage.q11;
import defpackage.qh0;
import defpackage.qk0;
import defpackage.qy;
import defpackage.rl0;
import defpackage.t40;
import defpackage.tv1;
import defpackage.um;
import defpackage.v01;
import defpackage.vz1;
import defpackage.w40;
import defpackage.w61;
import defpackage.wb2;
import defpackage.wp0;
import defpackage.wq;
import defpackage.ww;
import defpackage.xg;
import defpackage.xg0;
import defpackage.xj0;
import defpackage.xu;
import defpackage.xw;
import defpackage.yj0;
import defpackage.yp1;
import defpackage.zw;
import defpackage.zz1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class Workspace extends v implements ox, xw, ww, View.OnTouchListener, lw, ViewGroup.OnHierarchyChangeListener, fg0, yp1, ck0, jj1 {
    public static Rect L1;
    public static Rect M1;
    public final ArrayList A0;
    public int A1;
    public dl0 B0;
    public SparseArray B1;
    public boolean C0;
    public final ArrayList C1;
    public boolean D0;
    public j40 D1;
    public xg E0;
    public boolean E1;
    public final xu F0;
    public boolean F1;
    public int[] G0;
    public float G1;
    public int H0;
    public final f02 H1;
    public int I0;
    public o01 I1;
    public xj0 J0;
    public final vz1 J1;
    public xj0 K0;
    public final DecelerateInterpolator K1;
    public boolean L0;
    public boolean M0;
    public float N0;
    public String O0;
    public CellLayout P0;
    public CellLayout Q0;
    public CellLayout R0;
    public final t S0;
    public final oe0 T0;
    public mw U0;
    public final int[] V0;
    public final int[] W0;
    public float[] X0;
    public final float[] Y0;
    public final Matrix Z0;
    public final Matrix a1;
    public wb2 b1;
    public final float c1;
    public final float d1;
    public d02 e1;
    public boolean f1;
    public boolean g1;
    public boolean h1;
    public boolean i1;
    public final int[] j1;
    public final int[] k1;
    public final boolean l1;
    public final tv1 m1;
    public ng n1;
    public final g3 o1;
    public final g3 p1;
    public t40 q1;
    public FolderIcon r1;
    public boolean s1;
    public final LayoutTransition t0;
    public boolean t1;
    public final WallpaperManager u0;
    public final float u1;
    public IBinder v0;
    public final Canvas v1;
    public final int w0;
    public float w1;
    public int x0;
    public float x1;
    public ng1 y0;
    public int y1;
    public final wp0 z0;
    public int z1;

    static {
        new Rect();
    }

    public Workspace(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.z0 = new wp0();
        this.A0 = new ArrayList();
        this.C0 = false;
        this.D0 = true;
        this.G0 = new int[2];
        this.H0 = -1;
        this.I0 = -1;
        this.N0 = -1.0f;
        this.O0 = "Widgets page";
        this.P0 = null;
        this.Q0 = null;
        this.R0 = null;
        this.V0 = new int[2];
        this.W0 = new int[2];
        this.X0 = new float[2];
        this.Y0 = new float[2];
        this.Z0 = new Matrix();
        this.a1 = new Matrix();
        this.e1 = d02.h;
        this.f1 = false;
        this.g1 = true;
        this.h1 = false;
        this.i1 = false;
        this.j1 = new int[2];
        this.k1 = new int[2];
        Point point = new Point();
        this.o1 = new g3();
        this.p1 = new g3();
        this.q1 = null;
        this.r1 = null;
        this.s1 = false;
        this.t1 = false;
        this.v1 = new Canvas();
        this.y1 = 0;
        this.z1 = -1;
        this.A1 = -1;
        this.C1 = new ArrayList();
        this.J1 = new vz1(this, 1);
        this.K1 = new DecelerateInterpolator(3.0f);
        t tVar = (t) context;
        this.S0 = tVar;
        this.H1 = new f02(tVar, this);
        Resources resources = getResources();
        xu deviceProfile = tVar.getDeviceProfile();
        this.F0 = deviceProfile;
        this.l1 = deviceProfile.c;
        this.u0 = WallpaperManager.getInstance(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.Workspace, 0, 0);
        this.c1 = resources.getInteger(g61.config_workspaceSpringLoadShrinkPercentage) / 100.0f;
        float integer = resources.getInteger(g61.config_workspaceOverviewShrinkPercentage) / 100.0f;
        this.d1 = integer;
        int i = typedArrayObtainStyledAttributes.getInt(g71.Workspace_defaultScreen, 1);
        this.x0 = i;
        this.w0 = i;
        typedArrayObtainStyledAttributes.recycle();
        setOnHierarchyChangeListener(this);
        setHapticFeedbackEnabled(false);
        this.o = this.x0;
        this.T0 = jk0.a().b;
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        setChildrenDrawnWithCacheEnabled(true);
        setMinScale(integer);
        LayoutTransition layoutTransition = new LayoutTransition();
        this.t0 = layoutTransition;
        layoutTransition.enableTransitionType(3);
        this.t0.enableTransitionType(1);
        this.t0.disableTransitionType(2);
        this.t0.disableTransitionType(0);
        setLayoutTransition(this.t0);
        this.m1 = new tv1(this);
        tVar.getWindowManager().getDefaultDisplay().getSize(point);
        this.u1 = deviceProfile.D * 0.55f;
        new qy(this, 3).executeOnExecutor(ar1.q, new Void[0]);
        setMotionEventSplittingEnabled(true);
    }

    public static Rect A0(int i, t tVar) {
        Objects.toString(tVar);
        xg0 xg0Var = jk0.a().e;
        Display defaultDisplay = tVar.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getCurrentSizeRange(point, point2);
        int i2 = xg0Var.d;
        ar1.v(tVar.getResources());
        int i3 = xg0Var.c;
        if (i == 0) {
            if (L1 == null) {
                Rect rectD = xg0Var.q.d();
                int i4 = (point2.x - rectD.left) - rectD.right;
                int i5 = (point.y - rectD.top) - rectD.bottom;
                Rect rect = new Rect();
                L1 = rect;
                rect.set(i4 / i2, i5 / i3, 0, 0);
            }
            return L1;
        }
        if (i != 1) {
            return null;
        }
        if (M1 == null) {
            Rect rectD2 = xg0Var.r.d();
            int i6 = (point.x - rectD2.left) - rectD2.right;
            int i7 = (point2.y - rectD2.top) - rectD2.bottom;
            Rect rect2 = new Rect();
            M1 = rect2;
            rect2.set(i6 / i2, i7 / i3, 0, 0);
        }
        return M1;
    }

    public static void P0(View view, float[] fArr, Matrix matrix) {
        Objects.toString(view);
        Objects.toString(matrix);
        fArr[0] = fArr[0] - view.getLeft();
        fArr[1] = fArr[1] - view.getTop();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean f1(android.view.View r4, java.lang.Object r5) {
        /*
            java.util.Objects.toString(r5)
            java.util.Objects.toString(r4)
            r0 = 0
            if (r4 == 0) goto L20
            android.view.ViewGroup$LayoutParams r1 = r4.getLayoutParams()
            zg r1 = (defpackage.zg) r1
            boolean r2 = r1.e
            if (r2 == 0) goto L20
            int r2 = r1.c
            int r3 = r1.a
            if (r2 != r3) goto L3c
            int r2 = r1.d
            int r1 = r1.b
            if (r2 == r1) goto L20
            goto L3c
        L20:
            boolean r1 = r4 instanceof com.luutinhit.launcher6.FolderIcon
            if (r1 == 0) goto L3c
            com.luutinhit.launcher6.FolderIcon r4 = (com.luutinhit.launcher6.FolderIcon) r4
            r4.getClass()
            java.util.Objects.toString(r5)
            qh0 r5 = (defpackage.qh0) r5
            com.luutinhit.launcher6.Folder r1 = r4.h
            boolean r1 = r1.Q
            if (r1 != 0) goto L3c
            boolean r4 = r4.q(r5)
            if (r4 == 0) goto L3c
            r4 = 1
            return r4
        L3c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.Workspace.f1(android.view.View, java.lang.Object):boolean");
    }

    private int getNumLeftCustomPages() {
        return I0() ? 1 : 0;
    }

    public static void u0(View view, Canvas canvas, int i) {
        Objects.toString(view);
        Objects.toString(canvas);
        canvas.save();
        float f = i / 2.0f;
        canvas.translate((-view.getScrollX()) + f, (-view.getScrollY()) + f);
        view.draw(canvas);
        canvas.restore();
    }

    public static int[] z0(int i, int i2, int i3, int i4, CellLayout cellLayout, int[] iArr) {
        Objects.toString(cellLayout);
        return cellLayout.q(i, i2, i3, i4, i3, i4, false, iArr, null);
    }

    @Override // com.luutinhit.launcher6.v
    public final void A(int[] iArr) {
        int iR0 = R0();
        int childCount = getChildCount() - 1;
        iArr[0] = Math.max(0, Math.min(iR0, getChildCount() - 1));
        iArr[1] = Math.max(0, childCount);
    }

    public final View B0(c02 c02Var) {
        Objects.toString(c02Var);
        View[] viewArr = new View[1];
        O0(false, new q11(c02Var, viewArr, 27));
        return viewArr[0];
    }

    public final long C0(CellLayout cellLayout) {
        Objects.toString(cellLayout);
        wp0 wp0Var = this.z0;
        int iIndexOfValue = wp0Var.indexOfValue(cellLayout);
        if (iIndexOfValue != -1) {
            return wp0Var.keyAt(iIndexOfValue);
        }
        return -1L;
    }

    @Override // com.luutinhit.launcher6.v
    public final v01 D(int i) {
        if (G0(i) == -201 && this.A0.size() - R0() > 1) {
            return new v01(l51.ic_pageindicator_current);
        }
        v01 v01Var = new v01();
        v01Var.a = l51.ic_indicator_current;
        return v01Var;
    }

    public final String D0(int i) {
        int iR0 = R0();
        int childCount = getChildCount() - iR0;
        int iIndexOf = this.A0.indexOf(-201L);
        if (iIndexOf >= 0 && childCount > 1) {
            if (i == iIndexOf) {
                return getContext().getString(w61.workspace_new_page);
            }
            childCount--;
        }
        return childCount == 0 ? getContext().getString(w61.all_apps_home_button_label) : getContext().getString(w61.workspace_scroll_format, Integer.valueOf((i + 1) - iR0), Integer.valueOf(childCount));
    }

    public final int E0(long j) {
        return indexOfChild((View) this.z0.get(j));
    }

    public final CellLayout F0(View view) {
        Objects.toString(view);
        ArrayList<CellLayout> workspaceAndHotseatCellLayouts = getWorkspaceAndHotseatCellLayouts();
        int size = workspaceAndHotseatCellLayouts.size();
        int i = 0;
        while (i < size) {
            CellLayout cellLayout = workspaceAndHotseatCellLayouts.get(i);
            i++;
            CellLayout cellLayout2 = cellLayout;
            if (cellLayout2.getShortcutsAndWidgets().indexOfChild(view) > -1) {
                return cellLayout2;
            }
        }
        return null;
    }

    public final long G0(int i) {
        if (i < 0) {
            return -1L;
        }
        ArrayList arrayList = this.A0;
        if (i < arrayList.size()) {
            return ((Long) arrayList.get(i)).longValue();
        }
        return -1L;
    }

    public final CellLayout H0(long j) {
        return (CellLayout) this.z0.get(j);
    }

    public final boolean I0() {
        ArrayList arrayList = this.A0;
        return arrayList.contains(-301L) || arrayList.contains(-302L);
    }

    public final boolean J0() {
        return this.z0.b(-201L) && getChildCount() - R0() > 1;
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
        if (I0()) {
            int nextPage = getNextPage();
            int childCount = getChildCount() - 1;
            if ((nextPage == 0) != this.L0) {
                boolean z = nextPage == 0;
                this.L0 = z;
                xj0 xj0Var = this.J0;
                if (xj0Var != null) {
                    if (z) {
                        xj0Var.h(false);
                    } else {
                        xj0Var.l();
                    }
                }
            }
            if ((nextPage == childCount) != this.M0) {
                boolean z2 = nextPage == childCount;
                this.M0 = z2;
                xj0 xj0Var2 = this.K0;
                if (xj0Var2 != null) {
                    if (z2) {
                        xj0Var2.h(false);
                    } else {
                        xj0Var2.l();
                    }
                }
            }
        }
    }

    public final void K0(int i, long j) {
        wp0 wp0Var = this.z0;
        if (wp0Var.b(j)) {
            throw new RuntimeException("Screen id " + j + " already exists!");
        }
        t tVar = this.S0;
        CellLayout cellLayout = (CellLayout) tVar.getLayoutInflater().inflate(m61.workspace_screen, (ViewGroup) this, false);
        xu xuVar = this.F0;
        int i2 = xuVar.C;
        cellLayout.setPadding(i2, xuVar.f ? i2 : 0, i2, 0);
        cellLayout.setOnLongClickListener(this.M);
        cellLayout.setOnClickListener(tVar);
        cellLayout.setSoundEffectsEnabled(false);
        wp0Var.put(j, cellLayout);
        this.A0.add(i, Long.valueOf(j));
        addView(cellLayout, i);
        dk0 dk0Var = jk0.a().f;
        if (dk0Var == null || dk0Var.i == null) {
            return;
        }
        cellLayout.n(2, true);
    }

    @Override // com.luutinhit.launcher6.v
    public final void L() {
        this.k0 = false;
        t tVar = this.S0;
        if (tVar.isWorkspaceLoading()) {
            return;
        }
        ArrayList arrayList = this.A0;
        arrayList.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            arrayList.add(Long.valueOf(C0((CellLayout) getChildAt(i))));
        }
        e1();
        tVar.getModel().getClass();
        rl0.G(tVar, arrayList);
        setLayoutTransition(this.t0);
    }

    public final boolean L0() {
        Objects.toString(this.e1);
        return this.e1 == d02.l;
    }

    @Override // com.luutinhit.launcher6.v
    public final void M() {
        if (isHardwareAccelerated()) {
            d1(false);
        } else {
            int i = this.r;
            if (i != -1) {
                v0(this.o, i);
            } else {
                int i2 = this.o;
                v0(i2 - 1, i2 + 1);
            }
        }
        getPageIndicator().b();
    }

    public final boolean M0() {
        int nextPage = getNextPage();
        if (this.p != -1001) {
            return false;
        }
        ArrayList arrayList = this.A0;
        int iIndexOf = arrayList.indexOf(-301L);
        int iIndexOf2 = arrayList.indexOf(-302L);
        if (iIndexOf != nextPage || iIndexOf == -1) {
            return iIndexOf2 == nextPage && iIndexOf2 != -1;
        }
        return true;
    }

    @Override // com.luutinhit.launcher6.v
    public final void N() {
        this.V = false;
        if (isHardwareAccelerated()) {
            d1(false);
        } else {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                CellLayout cellLayout = (CellLayout) getChildAt(i);
                cellLayout.setChildrenDrawnWithCacheEnabled(false);
                if (!isHardwareAccelerated()) {
                    cellLayout.setChildrenDrawingCacheEnabled(false);
                }
            }
        }
        if (this.U0.f && h1()) {
            mw mwVar = this.U0;
            int[] iArr = mwVar.v;
            int i2 = iArr[0];
            int i3 = iArr[1];
            int[] iArr2 = mwVar.d;
            ox oxVarG = mwVar.g(iArr2, i2, i3);
            nx nxVar = mwVar.k;
            nxVar.a = iArr2[0];
            nxVar.b = iArr2[1];
            mwVar.c(oxVarG);
        }
        ng ngVar = this.n1;
        if (ngVar != null) {
            ngVar.run();
            this.n1 = null;
        }
        if (this.h1) {
            b1();
            this.h1 = false;
        }
        if (this.S0.isShaking()) {
            return;
        }
        getPageIndicator().f();
    }

    public final boolean N0(int i, int i2, Rect rect) {
        Objects.toString(rect);
        int[] iArr = this.W0;
        iArr[0] = i;
        iArr[1] = i2;
        this.S0.getDragLayer().getDescendantCoordRelativeToSelf(this, iArr, true);
        xu xuVar = this.F0;
        xuVar.getClass();
        return new Rect(0, xuVar.m - xuVar.U, xuVar.l, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).contains(iArr[0], iArr[1]);
    }

    @Override // com.luutinhit.launcher6.v
    public final void O() {
    }

    public final void O0(boolean z, c02 c02Var) {
        Objects.toString(c02Var);
        ArrayList<ng1> allShortcutAndWidgetContainers = getAllShortcutAndWidgetContainers();
        int size = allShortcutAndWidgetContainers.size();
        for (int i = 0; i < size; i++) {
            ng1 ng1Var = allShortcutAndWidgetContainers.get(i);
            int childCount = ng1Var.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = ng1Var.getChildAt(i2);
                qh0 qh0Var = (qh0) childAt.getTag();
                if (z && (qh0Var instanceof w40) && (childAt instanceof FolderIcon)) {
                    FolderIcon folderIcon = (FolderIcon) childAt;
                    ArrayList<View> itemsInReadingOrder = folderIcon.getFolder().getItemsInReadingOrder();
                    int size2 = itemsInReadingOrder.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        View view = itemsInReadingOrder.get(i3);
                        if (c02Var.h((qh0) view.getTag(), view, folderIcon)) {
                            return;
                        }
                    }
                } else if (c02Var.h(qh0Var, childAt, null)) {
                    return;
                }
            }
        }
    }

    @Override // com.luutinhit.launcher6.v
    public final void P() {
    }

    public final void Q0(Hotseat hotseat, float[] fArr) {
        Objects.toString(hotseat);
        int i = (int) fArr[0];
        int[] iArr = this.W0;
        iArr[0] = i;
        iArr[1] = (int) fArr[1];
        t tVar = this.S0;
        tVar.getDragLayer().getDescendantCoordRelativeToSelf(this, iArr, true);
        tVar.getDragLayer().mapCoordInSelfToDescendent(hotseat.getLayout(), iArr);
        fArr[0] = iArr[0];
        fArr[1] = iArr[1];
    }

    @Override // com.luutinhit.launcher6.v
    public final void R() {
        super.R();
        setLayoutTransition(null);
    }

    public final int R0() {
        ArrayList arrayList = this.A0;
        boolean zContains = arrayList.contains(-301L);
        return arrayList.contains(-302L) ? (zContains ? 1 : 0) + 1 : zContains ? 1 : 0;
    }

    @Override // com.luutinhit.launcher6.v
    public final void S(float f) {
        boolean z = this.o0;
        if ((f <= 0.0f && (I0() || z)) || (f >= 0.0f && (I0() || !z))) {
            k(f);
        }
    }

    public final boolean S0(int i, int i2, int i3) {
        t tVar = this.S0;
        boolean z = tVar.getDeviceProfile().e;
        if (tVar.getHotseat() != null && !z) {
            Rect rect = new Rect();
            tVar.getHotseat().getHitRect(rect);
            if (rect.contains(i, i2)) {
                return false;
            }
        }
        if (h1() || getOpenFolder() != null) {
            return false;
        }
        this.i1 = true;
        int nextPage = getNextPage() + (i3 == 0 ? -1 : 1);
        setCurrentDropLayout(null);
        if (nextPage < 0 || nextPage >= getChildCount() || G0(nextPage) == -301) {
            return false;
        }
        setCurrentDragOverlappingLayout((CellLayout) getChildAt(nextPage));
        invalidate();
        return true;
    }

    public final void T0() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ng1 shortcutsAndWidgets = ((CellLayout) getChildAt(i)).getShortcutsAndWidgets();
            int childCount2 = shortcutsAndWidgets.getChildCount();
            for (int i2 = 0; i2 < childCount2; i2++) {
                View childAt = shortcutsAndWidgets.getChildAt(i2);
                if (childAt != null && (childAt.getTag() instanceof qk0)) {
                    qk0 qk0Var = (qk0) childAt.getTag();
                    pk0 pk0Var = (pk0) qk0Var.C;
                    if (pk0Var != null && pk0Var.b()) {
                        t tVar = this.S0;
                        tVar.removeItem(pk0Var, qk0Var, false);
                        tVar.bindAppWidget(qk0Var);
                    }
                }
            }
        }
    }

    @Override // com.luutinhit.launcher6.v
    public final void U(int i) {
        float fMax;
        float fMax2;
        boolean z = this.l1;
        boolean z2 = this.o0;
        if (z && !h1()) {
            for (int iR0 = R0(); iR0 < getChildCount(); iR0++) {
                CellLayout cellLayout = (CellLayout) getChildAt(iR0);
                if (cellLayout != null) {
                    int iE = i - (E(iR0) + (getViewportWidth() / 2));
                    int childCount = getChildCount();
                    int i2 = iR0 + 1;
                    if ((iE < 0 && !z2) || (iE > 0 && z2)) {
                        i2 = iR0 - 1;
                    }
                    cellLayout.getShortcutsAndWidgets().setAlpha(1.0f - Math.abs(Math.max(Math.min(iE / (((i2 < 0 || i2 > childCount + (-1)) ? cellLayout.getMeasuredWidth() + this.w : Math.abs(E(i2) - E(iR0))) * 1.0f), 1.0f), -1.0f)));
                }
            }
        }
        boolean zI0 = I0();
        t tVar = this.S0;
        if (zI0) {
            ArrayList arrayList = this.A0;
            int iIndexOf = arrayList.indexOf(-301L);
            int iIndexOf2 = arrayList.indexOf(-302L);
            int scrollX = (getScrollX() - E(iIndexOf)) - B(iIndexOf);
            int scrollX2 = (getScrollX() - E(iIndexOf2)) - B(iIndexOf2);
            float fE = E(iIndexOf + 1) - E(iIndexOf);
            float f = fE - scrollX;
            if (f < 0.0f) {
                if (z2) {
                    fMax = Math.max(0.0f, f / fE);
                    fMax2 = Math.min(0.0f, f);
                } else {
                    float f2 = -(scrollX2 + fE);
                    fMax = Math.min(0.0f, f2 / fE);
                    fMax2 = Math.min(0.0f, f2);
                }
            } else if (z2) {
                float f3 = -(scrollX2 + fE);
                fMax = Math.min(0.0f, f3 / fE);
                fMax2 = Math.max(0.0f, f3);
            } else {
                fMax = Math.max(0.0f, f / fE);
                fMax2 = Math.max(0.0f, f);
            }
            if (Float.compare(fMax, this.N0) != 0) {
                wp0 wp0Var = this.z0;
                if (fMax > 0.0f) {
                    CellLayout cellLayout2 = (CellLayout) wp0Var.get(-301L);
                    if (cellLayout2.getVisibility() != 0 && !h1()) {
                        cellLayout2.setVisibility(0);
                    }
                    xj0 xj0Var = this.J0;
                    if (xj0Var != null) {
                        xj0Var.x();
                        this.J0.q(fMax2);
                    }
                } else if (fMax < 0.0f) {
                    CellLayout cellLayout3 = (CellLayout) wp0Var.get(-302L);
                    if (cellLayout3.getVisibility() != 0 && !h1()) {
                        cellLayout3.setVisibility(0);
                    }
                    xj0 xj0Var2 = this.K0;
                    if (xj0Var2 != null) {
                        xj0Var2.x();
                        this.K0.q(fMax2);
                    }
                }
                this.N0 = fMax;
                if (tVar.getHotseat() != null) {
                    tVar.getHotseat().setTranslationX(fMax2);
                }
                if (getPageIndicator() != null) {
                    getPageIndicator().setTranslationX(fMax2);
                }
            }
        }
        w0();
        getViewportWidth();
        E(getCurrentPage());
        ArrayList<ng1> allShortcutAndWidgetContainers = tVar.getWorkspace().getAllShortcutAndWidgetContainers();
        int size = allShortcutAndWidgetContainers.size();
        int i3 = 0;
        while (i3 < size) {
            ng1 ng1Var = allShortcutAndWidgetContainers.get(i3);
            i3++;
            ng1 ng1Var2 = ng1Var;
            int childCount2 = ng1Var2.getChildCount();
            for (int i4 = 0; i4 < childCount2; i4++) {
                View childAt = ng1Var2.getChildAt(i4);
                Objects.toString(childAt);
                if (childAt instanceof FolderIcon) {
                    ((FolderIcon) childAt).p();
                }
            }
        }
    }

    public final void U0() {
        setLayoutTransition(null);
        if (I0()) {
            V0(0);
            V0(1);
        }
        removeAllViews();
        this.A0.clear();
        this.z0.clear();
        setLayoutTransition(this.t0);
    }

    @Override // com.luutinhit.launcher6.v
    public final void V() {
        if (!h1()) {
            super.V();
        }
        Folder openFolder = getOpenFolder();
        if (openFolder != null) {
            openFolder.A();
        }
    }

    public final void V0(int i) {
        xj0 xj0Var;
        xj0 xj0Var2;
        long j = i == 0 ? -301L : -302L;
        CellLayout cellLayoutH0 = H0(j);
        if (cellLayoutH0 == null) {
            throw new RuntimeException("Expected custom content screen to exist");
        }
        this.z0.remove(j);
        this.A0.remove(Long.valueOf(j));
        removeView(cellLayoutH0);
        if (i == 0 && (xj0Var2 = this.J0) != null) {
            xj0Var2.x();
            this.J0.l();
            this.J0 = null;
            this.x0 = this.w0 - 1;
            int i2 = this.p;
            if (i2 != -1001) {
                this.p = i2 - 1;
            } else {
                setCurrentPage(getCurrentPage() - 1);
            }
        }
        if (i != 1 || (xj0Var = this.K0) == null) {
            return;
        }
        xj0Var.x();
        this.K0.l();
        this.K0 = null;
    }

    @Override // com.luutinhit.launcher6.v
    public final void W() {
        if (!h1()) {
            super.W();
        }
        Folder openFolder = getOpenFolder();
        if (openFolder != null) {
            openFolder.A();
        }
    }

    public final void W0(boolean z, Runnable runnable, int i, boolean z2) {
        Objects.toString(runnable);
        t tVar = this.S0;
        if (tVar.isWorkspaceLoading()) {
            t.addDumpLog("Workspace", "    - workspace loading, skip", true);
            return;
        }
        if (i > 0) {
            postDelayed(new zz1(this, z, runnable, z2), i);
            return;
        }
        boolean zIsWorkspaceLoading = tVar.isWorkspaceLoading();
        ArrayList arrayList = this.A0;
        if (zIsWorkspaceLoading) {
            t.addDumpLog("Workspace", "    - workspace loading, skip", true);
        } else if (!J0() && arrayList.size() != 0) {
            Long l = (Long) arrayList.get(arrayList.size() - 1);
            long jLongValue = l.longValue();
            if (jLongValue != -301) {
                wp0 wp0Var = this.z0;
                CellLayout cellLayout = (CellLayout) wp0Var.get(jLongValue);
                if (cellLayout.getShortcutsAndWidgets().getChildCount() == 0 && !cellLayout.n) {
                    wp0Var.remove(jLongValue);
                    arrayList.remove(l);
                    wp0Var.put(-201L, cellLayout);
                    arrayList.add(-201L);
                    e1();
                    tVar.getModel().getClass();
                    rl0.G(tVar, arrayList);
                }
            }
        }
        if (!J0()) {
            if (z2) {
                b1();
            }
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (getNextPage() == arrayList.indexOf(-201L)) {
            a0(getNextPage() - 1, 400);
            y0(400, z2, runnable);
        } else {
            a0(getNextPage(), 0);
            y0(0, z2, runnable);
        }
    }

    @Override // com.luutinhit.launcher6.v
    public final boolean X(View view) {
        Objects.toString(view);
        CellLayout cellLayout = (CellLayout) view;
        if (super.X(view)) {
            return cellLayout.getShortcutsAndWidgets().getAlpha() > 0.0f || cellLayout.getBackgroundAlpha() > 0.0f;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X0(HashSet hashSet, jq1 jq1Var) {
        Objects.toString(hashSet);
        Objects.toString(jq1Var);
        ArrayList<CellLayout> workspaceAndHotseatCellLayouts = getWorkspaceAndHotseatCellLayouts();
        int size = workspaceAndHotseatCellLayouts.size();
        int i = 0;
        while (i < size) {
            CellLayout cellLayout = workspaceAndHotseatCellLayouts.get(i);
            i++;
            CellLayout cellLayout2 = cellLayout;
            ng1 shortcutsAndWidgets = cellLayout2.getShortcutsAndWidgets();
            HashMap map = new HashMap();
            for (int i2 = 0; i2 < shortcutsAndWidgets.getChildCount(); i2++) {
                View childAt = shortcutsAndWidgets.getChildAt(i2);
                map.put((qh0) childAt.getTag(), childAt);
            }
            ArrayList arrayList = new ArrayList();
            HashMap map2 = new HashMap();
            ek ekVar = new ek();
            ekVar.h = hashSet;
            ekVar.i = jq1Var;
            ekVar.j = map2;
            ekVar.g = arrayList;
            ekVar.k = map;
            rl0.h(map.keySet(), ekVar);
            for (w40 w40Var : map2.keySet()) {
                ArrayList arrayList2 = (ArrayList) map2.get(w40Var);
                int size2 = arrayList2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj = arrayList2.get(i3);
                    i3++;
                    w40Var.g((og1) obj);
                }
            }
            int size3 = arrayList.size();
            int i4 = 0;
            while (i4 < size3) {
                Object obj2 = arrayList.get(i4);
                i4++;
                View view = (View) obj2;
                cellLayout2.removeViewInLayout(view);
                if (view instanceof ox) {
                    this.U0.l.remove((ox) view);
                }
            }
            if (arrayList.size() > 0) {
                shortcutsAndWidgets.requestLayout();
                shortcutsAndWidgets.invalidate();
            }
        }
        b1();
    }

    public final void Y0(HashSet hashSet, jq1 jq1Var) {
        Objects.toString(hashSet);
        Objects.toString(jq1Var);
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        ArrayList<CellLayout> workspaceAndHotseatCellLayouts = getWorkspaceAndHotseatCellLayouts();
        int size = workspaceAndHotseatCellLayouts.size();
        int i = 0;
        while (i < size) {
            CellLayout cellLayout = workspaceAndHotseatCellLayouts.get(i);
            i++;
            ng1 shortcutsAndWidgets = cellLayout.getShortcutsAndWidgets();
            int childCount = shortcutsAndWidgets.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                hashSet2.add((qh0) shortcutsAndWidgets.getChildAt(i2).getTag());
            }
        }
        rl0.h(hashSet2, new wb2(hashSet, jq1Var, hashSet3, 25));
        X0(hashSet3, jq1Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z0(View view) {
        Objects.toString(view);
        CellLayout cellLayoutF0 = F0(view);
        if (cellLayoutF0 != null) {
            cellLayoutF0.removeView(view);
        } else {
            WeakReference weakReference = jk0.h;
        }
        if (view instanceof ox) {
            this.U0.l.remove((ox) view);
        }
    }

    @Override // defpackage.ck0
    public final void a(xg xgVar, boolean z) {
        Objects.toString(xgVar);
        View view = xgVar.a;
        if (view.isInTouchMode()) {
            this.E0 = xgVar;
            if (view instanceof FolderIcon) {
                ((FolderIcon) view).setVisibilityGlassBackground(false);
            }
            view.setVisibility(4);
            CellLayout cellLayout = (CellLayout) view.getParent().getParent();
            cellLayout.getClass();
            Objects.toString(view);
            cellLayout.w(view);
            Objects.toString(view);
            Objects.toString(this);
            m0(view, new Point(), this, z);
        }
    }

    public final void a1(int i) {
        if (this.B1 != null) {
            this.C1.add(Integer.valueOf(i));
            CellLayout cellLayout = (CellLayout) getChildAt(i);
            if (cellLayout != null) {
                SparseArray sparseArray = this.B1;
                Objects.toString(sparseArray);
                try {
                    cellLayout.dispatchRestoreInstanceState(sparseArray);
                } catch (IllegalArgumentException unused) {
                    WeakReference weakReference = jk0.h;
                }
            }
        }
    }

    @Override // com.luutinhit.launcher6.v, android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i2) {
        Objects.toString(arrayList);
        if (this.S0.isAppsViewVisible()) {
            return;
        }
        Folder openFolder = getOpenFolder();
        if (openFolder != null) {
            openFolder.addFocusables(arrayList, i);
        } else {
            super.addFocusables(arrayList, i, i2);
        }
    }

    @Override // android.view.View
    public final void announceForAccessibility(CharSequence charSequence) {
        Objects.toString(charSequence);
        if (this.S0.isAppsViewVisible()) {
            return;
        }
        super.announceForAccessibility(charSequence);
    }

    @Override // defpackage.ox
    public final boolean b() {
        return true;
    }

    public final void b1() {
        ArrayList arrayList;
        t tVar = this.S0;
        if (tVar.isWorkspaceLoading()) {
            t.addDumpLog("Workspace", "    - workspace loading, skip", true);
            return;
        }
        if (this.U) {
            this.h1 = true;
            return;
        }
        int nextPage = getNextPage();
        ArrayList arrayList2 = new ArrayList();
        wp0 wp0Var = this.z0;
        int size = wp0Var.size();
        for (int i = 0; i < size; i++) {
            long jKeyAt = wp0Var.keyAt(i);
            CellLayout cellLayout = (CellLayout) wp0Var.valueAt(i);
            if (jKeyAt >= 0 && cellLayout.getShortcutsAndWidgets().getChildCount() == 0) {
                arrayList2.add(Long.valueOf(jKeyAt));
            }
        }
        dk0 dk0Var = jk0.a().f;
        int iR0 = R0() + 1;
        int size2 = arrayList2.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            arrayList = this.A0;
            if (i3 >= size2) {
                break;
            }
            Object obj = arrayList2.get(i3);
            i3++;
            Long l = (Long) obj;
            CellLayout cellLayout2 = (CellLayout) wp0Var.get(l.longValue());
            wp0Var.remove(l.longValue());
            arrayList.remove(l);
            if (getChildCount() > iR0) {
                if (indexOfChild(cellLayout2) < nextPage) {
                    i2++;
                }
                if (dk0Var != null && dk0Var.i != null) {
                    cellLayout2.n(2, false);
                }
                removeView(cellLayout2);
            } else {
                this.B0 = null;
                wp0Var.put(-201L, cellLayout2);
                arrayList.add(-201L);
            }
            e1();
        }
        if (!arrayList2.isEmpty()) {
            tVar.getModel().getClass();
            rl0.G(tVar, arrayList);
        }
        if (i2 >= 0) {
            setCurrentPage(nextPage - i2);
        }
    }

    @Override // defpackage.ox
    public final void c(Rect rect) {
        Objects.toString(rect);
        this.S0.getDragLayer().getDescendantRectRelativeToSelf(this, rect);
    }

    public final void c1() {
        d02 d02Var;
        boolean z = ar1.m;
        d02 d02Var2 = d02.h;
        if (!z) {
            setImportantForAccessibility(this.e1 != d02Var2 ? 4 : 0);
            return;
        }
        int pageCount = getPageCount();
        int iR0 = R0();
        while (true) {
            d02Var = d02.l;
            if (iR0 >= pageCount) {
                break;
            }
            CellLayout cellLayout = (CellLayout) getChildAt(iR0);
            Objects.toString(cellLayout);
            d02 d02Var3 = this.e1;
            if (d02Var3 == d02Var) {
                cellLayout.setImportantForAccessibility(1);
                cellLayout.getShortcutsAndWidgets().setImportantForAccessibility(4);
                cellLayout.setContentDescription(D0(iR0));
                if (this.I1 == null) {
                    this.I1 = new o01(this);
                }
                cellLayout.setAccessibilityDelegate(this.I1);
            } else {
                int i = d02Var3 == d02Var2 ? 0 : 4;
                cellLayout.setImportantForAccessibility(2);
                cellLayout.getShortcutsAndWidgets().setImportantForAccessibility(i);
                cellLayout.setContentDescription(null);
                cellLayout.setAccessibilityDelegate(null);
            }
            iR0++;
        }
        d02 d02Var4 = this.e1;
        if (d02Var4 != d02Var2 && d02Var4 != d02Var) {
            i = 4;
        }
        setImportantForAccessibility(i);
    }

    @Override // com.luutinhit.launcher6.v, android.view.View
    public final void computeScroll() {
        super.computeScroll();
        this.m1.b();
    }

    public final void d1(boolean z) {
        boolean z2 = true;
        boolean z3 = this.e1 == d02.l;
        if (!z && !z3 && !this.f1 && !this.U) {
            z2 = false;
        }
        if (z2 != this.g1) {
            this.g1 = z2;
            if (z2) {
                w0();
                return;
            }
            for (int i = 0; i < getPageCount(); i++) {
                CellLayout cellLayout = (CellLayout) getChildAt(i);
                cellLayout.getClass();
                cellLayout.I.setLayerType(0, CellLayout.V);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Objects.toString(sparseArray);
        this.B1 = sparseArray;
    }

    @Override // com.luutinhit.launcher6.v, android.view.ViewGroup, android.view.View
    public final boolean dispatchUnhandledMove(View view, int i) {
        Objects.toString(view);
        if (h1()) {
            return false;
        }
        return super.dispatchUnhandledMove(view, i);
    }

    public final void e1() {
        ArrayList arrayList = this.A0;
        arrayList.remove((Object) (-302L));
        arrayList.add(-302L);
    }

    @Override // defpackage.ox
    public final void f() {
    }

    @Override // defpackage.yp1
    public final void g() {
        this.E1 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g1(android.view.View r5, defpackage.qh0 r6, boolean r7) {
        /*
            r4 = this;
            java.util.Objects.toString(r6)
            java.util.Objects.toString(r5)
            r0 = 0
            if (r5 == 0) goto L20
            android.view.ViewGroup$LayoutParams r1 = r5.getLayoutParams()
            zg r1 = (defpackage.zg) r1
            boolean r2 = r1.e
            if (r2 == 0) goto L20
            int r2 = r1.c
            int r3 = r1.a
            if (r2 != r3) goto L4c
            int r2 = r1.d
            int r1 = r1.b
            if (r2 == r1) goto L20
            goto L4c
        L20:
            xg r1 = r4.E0
            r2 = 1
            if (r1 == 0) goto L2b
            android.view.View r1 = r1.a
            if (r5 != r1) goto L2b
            r1 = 1
            goto L2c
        L2b:
            r1 = 0
        L2c:
            if (r5 == 0) goto L4c
            if (r1 != 0) goto L4c
            if (r7 == 0) goto L37
            boolean r7 = r4.s1
            if (r7 != 0) goto L37
            goto L4c
        L37:
            java.lang.Object r5 = r5.getTag()
            boolean r5 = r5 instanceof defpackage.og1
            int r6 = r6.h
            if (r6 == 0) goto L46
            if (r6 != r2) goto L44
            goto L46
        L44:
            r6 = 0
            goto L47
        L46:
            r6 = 1
        L47:
            if (r5 == 0) goto L4c
            if (r6 == 0) goto L4c
            return r2
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.Workspace.g1(android.view.View, qh0, boolean):boolean");
    }

    public ArrayList<ng1> getAllShortcutAndWidgetContainers() {
        ArrayList<ng1> arrayList = new ArrayList<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            arrayList.add(((CellLayout) getChildAt(i)).getShortcutsAndWidgets());
        }
        t tVar = this.S0;
        if (tVar.getHotseat() != null) {
            arrayList.add(tVar.getHotseat().getLayout().getShortcutsAndWidgets());
        }
        return arrayList;
    }

    public CellLayout getCurrentCellLayout() {
        return (CellLayout) getChildAt(getNextPage());
    }

    public CellLayout getCurrentDropLayout() {
        return (CellLayout) getChildAt(getNextPage());
    }

    @Override // com.luutinhit.launcher6.v
    public String getCurrentPageDescription() {
        if (I0() && getNextPage() == 0) {
            return this.O0;
        }
        int i = this.r;
        if (i == -1) {
            i = this.o;
        }
        return D0(i);
    }

    public int getCurrentPageOffsetFromCustomContent() {
        getNextPage();
        getNumLeftCustomPages();
        return getNextPage() - getNumLeftCustomPages();
    }

    public xj0 getCustomContentCallbacks() {
        return this.J0;
    }

    @Override // android.view.ViewGroup
    public int getDescendantFocusability() {
        if (h1()) {
            return 393216;
        }
        return super.getDescendantFocusability();
    }

    public xg getDragInfo() {
        return this.E0;
    }

    @Override // defpackage.xw
    public float getIntrinsicIconScaleFactor() {
        return 1.0f;
    }

    public Folder getOpenFolder() {
        DragLayer dragLayer = this.S0.getDragLayer();
        int childCount = dragLayer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = dragLayer.getChildAt(i);
            if (childAt instanceof Folder) {
                Folder folder = (Folder) childAt;
                if (folder.getInfo().y) {
                    return folder;
                }
            }
        }
        return null;
    }

    public int getOverviewModeTranslationY() {
        ar1.v(getResources());
        xu xuVar = this.F0;
        Rect rectD = xuVar.d();
        int iMin = Math.min(xuVar.o, Math.max(xuVar.n, (int) (xuVar.r * xuVar.m)));
        int normalChildHeight = (int) (this.d1 * getNormalChildHeight());
        Rect rect = this.n0;
        int i = rect.top + rectD.top;
        int viewportHeight = (getViewportHeight() - rect.bottom) - rectD.bottom;
        int i2 = rect.top;
        return (-((((viewportHeight - i) - normalChildHeight) / 2) + i)) + (((((getViewportHeight() - rect.bottom) - iMin) - i2) - normalChildHeight) / 2) + i2;
    }

    @Override // com.luutinhit.launcher6.v
    public View.OnClickListener getPageIndicatorClickListener() {
        return new a02(this);
    }

    @Override // com.luutinhit.launcher6.v
    public String getPageIndicatorDescription() {
        return getCurrentPageDescription() + ", " + getResources().getString(w61.settings_button_text);
    }

    @Override // com.luutinhit.launcher6.v
    public Matrix getPageShiftMatrix() {
        if (Float.compare(this.G1, 0.0f) == 0) {
            return super.getPageShiftMatrix();
        }
        Matrix matrix = this.a1;
        matrix.set(getMatrix());
        matrix.postTranslate(-this.G1, 0.0f);
        return matrix;
    }

    public xj0 getRightCustomContentCallbacks() {
        return this.K0;
    }

    public ArrayList<Long> getScreenOrder() {
        return this.A0;
    }

    public d02 getState() {
        return this.e1;
    }

    @Override // com.luutinhit.launcher6.v
    public int getUnboundedScrollX() {
        return super.getUnboundedScrollX();
    }

    public float getWallpaperOffsetForCenterPage() {
        int iE = E(getPageNearestToCenterOfScreen());
        tv1 tv1Var = this.m1;
        Workspace workspace = tv1Var.a;
        int childCount = workspace.getChildCount();
        if (childCount >= 4 && workspace.J0()) {
            childCount--;
        }
        tv1Var.c(tv1.h, iE, childCount);
        return r2[0] / r2[1];
    }

    public ArrayList<CellLayout> getWorkspaceAndHotseatCellLayouts() {
        ArrayList<CellLayout> arrayList = new ArrayList<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            arrayList.add((CellLayout) getChildAt(i));
        }
        t tVar = this.S0;
        if (tVar.getHotseat() != null) {
            arrayList.add(tVar.getHotseat().getLayout());
        }
        return arrayList;
    }

    @Override // defpackage.ck0
    public final void h(boolean z) {
        for (int i = 0; i < getChildCount(); i++) {
            ((CellLayout) getChildAt(i)).n(2, z);
        }
        t tVar = this.S0;
        if (z) {
            setOnClickListener(null);
        } else {
            setOnClickListener(tVar);
        }
        tVar.getHotseat().getLayout().n(2, z);
    }

    public final boolean h1() {
        return this.e1 != d02.h;
    }

    @Override // defpackage.xw
    public final boolean i() {
        return this.S0.getDeviceProfile().a.b;
    }

    public final void i0() {
        if (this.z0.b(-201L)) {
            return;
        }
        K0(this.A0.contains(-302L) ? getChildCount() - 1 : getChildCount(), -201L);
    }

    @Override // defpackage.ox
    public final void j(nx nxVar) {
        Objects.toString(nxVar);
        this.s1 = false;
        this.t1 = false;
        this.R0 = null;
        CellLayout currentDropLayout = getCurrentDropLayout();
        setCurrentDropLayout(currentDropLayout);
        setCurrentDragOverlappingLayout(currentDropLayout);
        if (h1()) {
            return;
        }
        this.S0.getDragLayer().showPageHints();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008d A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:4:0x0010, B:6:0x0016, B:14:0x0033, B:16:0x0048, B:18:0x0050, B:25:0x0085, B:27:0x008d, B:31:0x00a1, B:32:0x00a3, B:37:0x00c2, B:39:0x00ca, B:40:0x00ec, B:42:0x00f0, B:43:0x00f8, B:45:0x00fc, B:28:0x0093, B:19:0x0061, B:21:0x006d, B:23:0x0071, B:24:0x0077, B:47:0x0106, B:48:0x010d), top: B:51:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0093 A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:4:0x0010, B:6:0x0016, B:14:0x0033, B:16:0x0048, B:18:0x0050, B:25:0x0085, B:27:0x008d, B:31:0x00a1, B:32:0x00a3, B:37:0x00c2, B:39:0x00ca, B:40:0x00ec, B:42:0x00f0, B:43:0x00f8, B:45:0x00fc, B:28:0x0093, B:19:0x0061, B:21:0x006d, B:23:0x0071, B:24:0x0077, B:47:0x0106, B:48:0x010d), top: B:51:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ca A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:4:0x0010, B:6:0x0016, B:14:0x0033, B:16:0x0048, B:18:0x0050, B:25:0x0085, B:27:0x008d, B:31:0x00a1, B:32:0x00a3, B:37:0x00c2, B:39:0x00ca, B:40:0x00ec, B:42:0x00f0, B:43:0x00f8, B:45:0x00fc, B:28:0x0093, B:19:0x0061, B:21:0x006d, B:23:0x0071, B:24:0x0077, B:47:0x0106, B:48:0x010d), top: B:51:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f0 A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:4:0x0010, B:6:0x0016, B:14:0x0033, B:16:0x0048, B:18:0x0050, B:25:0x0085, B:27:0x008d, B:31:0x00a1, B:32:0x00a3, B:37:0x00c2, B:39:0x00ca, B:40:0x00ec, B:42:0x00f0, B:43:0x00f8, B:45:0x00fc, B:28:0x0093, B:19:0x0061, B:21:0x006d, B:23:0x0071, B:24:0x0077, B:47:0x0106, B:48:0x010d), top: B:51:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fc A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:4:0x0010, B:6:0x0016, B:14:0x0033, B:16:0x0048, B:18:0x0050, B:25:0x0085, B:27:0x008d, B:31:0x00a1, B:32:0x00a3, B:37:0x00c2, B:39:0x00ca, B:40:0x00ec, B:42:0x00f0, B:43:0x00f8, B:45:0x00fc, B:28:0x0093, B:19:0x0061, B:21:0x006d, B:23:0x0071, B:24:0x0077, B:47:0x0106, B:48:0x010d), top: B:51:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j0(android.view.View r12, long r13, long r15, int r17, int r18, int r19, int r20, boolean r21, boolean r22) {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.Workspace.j0(android.view.View, long, long, int, int, int, int, boolean, boolean):void");
    }

    public final boolean k0(View view, CellLayout cellLayout, int[] iArr, float f, nx nxVar, boolean z) {
        Objects.toString(view);
        Objects.toString(cellLayout);
        Objects.toString(nxVar);
        if (f <= this.u1) {
            View viewB = cellLayout.I.b(iArr[0], iArr[1]);
            if (this.t1) {
                this.t1 = false;
                if (viewB instanceof FolderIcon) {
                    FolderIcon folderIcon = (FolderIcon) viewB;
                    Object obj = nxVar.g;
                    folderIcon.getClass();
                    Objects.toString(obj);
                    qh0 qh0Var = (qh0) obj;
                    if (!folderIcon.h.Q && folderIcon.q(qh0Var)) {
                        folderIcon.m(nxVar);
                        if (!z) {
                            F0(this.E0.a).removeView(this.E0.a);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // defpackage.xw
    public final void l(View view, nx nxVar, boolean z) {
        xg xgVar;
        Objects.toString(view);
        Objects.toString(nxVar);
        if (this.E1) {
            this.D1 = new j40(this, view, nxVar, z, 1);
            return;
        }
        boolean z2 = this.D1 != null;
        if (!z || (z2 && !this.F1)) {
            xg xgVar2 = this.E0;
            if (xgVar2 != null) {
                CellLayout cellLayout = this.S0.getCellLayout(xgVar2.g, xgVar2.f);
                if (cellLayout != null) {
                    cellLayout.y(this.E0.a);
                } else {
                    WeakReference weakReference = jk0.h;
                }
            }
        } else if (view != this && (xgVar = this.E0) != null) {
            Z0(xgVar.a);
        }
        if (nxVar.k || (z2 && !this.F1)) {
            this.E0.a.setVisibility(0);
        }
        this.E0 = null;
    }

    public final void l0(qh0 qh0Var, CellLayout cellLayout, zw zwVar, Runnable runnable, int i, AppWidgetHostView appWidgetHostView) {
        Objects.toString(qh0Var);
        Objects.toString(cellLayout);
        Objects.toString(zwVar);
        Objects.toString(runnable);
        Objects.toString(appWidgetHostView);
        Rect rect = new Rect();
        t tVar = this.S0;
        tVar.getDragLayer().getViewRectRelativeToSelf(zwVar, rect);
        float[] fArr = {1.0f, 1.0f};
        int[] iArr = this.G0;
        Objects.toString(zwVar);
        Objects.toString(cellLayout);
        Objects.toString(qh0Var);
        int i2 = qh0Var.m;
        int i3 = qh0Var.n;
        int i4 = iArr[0];
        int i5 = iArr[1];
        Objects.toString(cellLayout);
        Rect rect2 = new Rect();
        cellLayout.g(i4, i5, i2, i3, rect2);
        int[] iArr2 = {rect2.left, rect2.top};
        setFinalTransitionTransform(cellLayout);
        float descendantCoordRelativeToSelf = tVar.getDragLayer().getDescendantCoordRelativeToSelf(cellLayout, iArr2, true);
        Objects.toString(cellLayout);
        iArr2[0] = iArr2[0] - ((int) (((double) ((zwVar.getMeasuredWidth() - (rect2.width() * descendantCoordRelativeToSelf)) / 2.0f)) - Math.ceil(cellLayout.getUnusedHorizontalSpace() / 2.0f)));
        iArr2[1] = iArr2[1] - ((int) ((zwVar.getMeasuredHeight() - (descendantCoordRelativeToSelf * rect2.height())) / 2.0f));
        int integer = tVar.getResources().getInteger(g61.config_dropAnimMaxDuration) - 200;
        int i6 = qh0Var.h;
        boolean z = i6 == 4 || i6 == 5;
        if (appWidgetHostView == null && z) {
            fArr[1] = 1.0f;
            fArr[0] = 1.0f;
        }
        DragLayer dragLayer = tVar.getDragLayer();
        if (i == 4) {
            tVar.getDragLayer().animateViewIntoPosition(zwVar, iArr2, 0.0f, 0.1f, 0.1f, 0, runnable, integer);
        } else {
            dragLayer.animateViewIntoPosition(zwVar, rect.left, rect.top, iArr2[0], iArr2[1], 1.0f, 1.0f, 1.0f, fArr[0], fArr[1], new el0(appWidgetHostView, runnable, 17, false), i == 1 ? 2 : 0, integer, this);
        }
    }

    @Override // defpackage.xw
    public final boolean m() {
        return true;
    }

    public final void m0(View view, Point point, xw xwVar, boolean z) {
        boolean z2;
        Point point2;
        Rect rect;
        int i;
        Objects.toString(view);
        Objects.toString(point);
        Objects.toString(xwVar);
        view.clearFocus();
        view.setPressed(false);
        t tVar = this.S0;
        tVar.onDragStarted(view);
        AtomicInteger atomicInteger = new AtomicInteger(2);
        Bitmap bitmapS0 = s0(view, atomicInteger);
        int width = bitmapS0.getWidth();
        int height = bitmapS0.getHeight();
        float locationInDragLayer = tVar.getDragLayer().getLocationInDragLayer(view, this.j1);
        float f = width;
        int iRound = Math.round(r10[0] - ((f - (view.getWidth() * locationInDragLayer)) / 2.0f));
        float f2 = height;
        int iRound2 = Math.round((r10[1] - ((f2 - (locationInDragLayer * f2)) / 2.0f)) - (atomicInteger.get() / 2.0f));
        boolean z3 = view instanceof BubbleTextView;
        xu xuVar = this.F0;
        if (z3) {
            BubbleTextView bubbleTextView = (BubbleTextView) view;
            int i2 = xuVar.D;
            int paddingTop = view.getPaddingTop();
            int i3 = (width - i2) / 2;
            int i4 = i3 + i2;
            int i5 = i2 + paddingTop;
            if (bubbleTextView.m) {
                iRound = bubbleTextView.getIcon().getBounds().contains(point.x, point.y) ? Math.round(r10[0]) : Math.round((r10[0] + point.x) - (f / 2.0f));
            }
            Point point3 = new Point((-atomicInteger.get()) / 2, atomicInteger.get() / 2);
            Rect rect2 = new Rect(i3, paddingTop, i4, i5);
            point2 = point3;
            rect = rect2;
            i = iRound2 + paddingTop;
            z2 = false;
        } else {
            if (view instanceof FolderIcon) {
                int i6 = xuVar.J;
                z2 = false;
                point2 = new Point((-atomicInteger.get()) / 2, (atomicInteger.get() / 2) - view.getPaddingTop());
                rect = new Rect(0, view.getPaddingTop(), view.getWidth(), i6);
            } else {
                z2 = false;
                point2 = null;
                rect = null;
            }
            i = iRound2;
        }
        int i7 = iRound;
        if (z3) {
            ((BubbleTextView) view).setStayPressed(z2);
        }
        if (view.getTag() == null || !(view.getTag() instanceof qh0)) {
            throw new IllegalStateException("Drag started with a view that has no tag set. This will cause a crash (issue 11627249) down the line. View: " + view + "  tag: " + view.getTag());
        }
        if (view.getParent() instanceof ng1) {
            this.y0 = (ng1) view.getParent();
        }
        this.U0.l(bitmapS0, i7, i, xwVar, view.getTag(), 0, point2, rect, locationInDragLayer, z).setIntrinsicIconScaleFactor(xwVar.getIntrinsicIconScaleFactor());
        bitmapS0.recycle();
    }

    @Override // com.luutinhit.launcher6.v
    public final void n(MotionEvent motionEvent) {
        View childAt;
        Objects.toString(motionEvent);
        float x = motionEvent.getX() - this.w1;
        float y = motionEvent.getY() - this.x1;
        float fAbs = Math.abs(x);
        float fAbs2 = Math.abs(y);
        if (Float.compare(fAbs, 0.0f) == 0) {
            return;
        }
        float fAtan = (float) Math.atan(fAbs2 / fAbs);
        float f = this.N;
        if ((fAbs > f || fAbs2 > f) && (childAt = getChildAt(this.o)) != null) {
            childAt.cancelLongPress();
        }
        G0(getCurrentPage());
        G0(getCurrentPage());
        if (fAtan > 1.0471976f) {
            return;
        }
        if (fAtan > 0.5235988f) {
            super.w(motionEvent, (((float) Math.sqrt((fAtan - 0.5235988f) / 0.5235988f)) * 4.0f) + 1.0f);
        } else {
            super.n(motionEvent);
        }
    }

    public final void n0() {
        FolderIcon folderIcon = this.r1;
        if (folderIcon != null) {
            folderIcon.getClass();
            folderIcon.p.b();
            folderIcon.A.a();
            this.r1 = null;
        }
    }

    @Override // defpackage.yp1
    public final void o(boolean z) {
        this.E1 = false;
        this.F1 = z;
        j40 j40Var = this.D1;
        if (j40Var != null) {
            j40Var.run();
        }
    }

    public final void o0() {
        t40 t40Var = this.q1;
        if (t40Var != null) {
            t40Var.b();
            this.q1 = null;
        }
        g3 g3Var = this.o1;
        g3Var.j = null;
        g3Var.a();
    }

    @Override // com.luutinhit.launcher6.v, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        IBinder windowToken = getWindowToken();
        this.v0 = windowToken;
        this.m1.a(windowToken);
        computeScroll();
        mw mwVar = this.U0;
        if (mwVar != null) {
            mwVar.n = this.v0;
        }
        t tVar = this.S0;
        IBinder iBinder = this.v0;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                ac0.a("Landroid/app/WallpaperManager;");
                WallpaperManager.class.getDeclaredMethod("setWallpaperZoomOut", IBinder.class, Float.TYPE).invoke(WallpaperManager.getInstance(tVar), iBinder, Float.valueOf(1.0f));
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.luutinhit.launcher6.v, android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewAdded(View view, View view2) {
        Objects.toString(view);
        Objects.toString(view2);
        if (!(view2 instanceof CellLayout)) {
            throw new IllegalArgumentException("A Workspace can only have CellLayout children.");
        }
        CellLayout cellLayout = (CellLayout) view2;
        cellLayout.setOnInterceptTouchListener(this);
        cellLayout.setClickable(true);
        cellLayout.setImportantForAccessibility(2);
        cellLayout.setIsShaking(this.S0.isShaking());
        super.onChildViewAdded(view, view2);
    }

    @Override // com.luutinhit.launcher6.v, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.m1.a(null);
        this.v0 = null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Objects.toString(canvas);
        super.onDraw(canvas);
        post(this.J1);
    }

    @Override // com.luutinhit.launcher6.v, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        Objects.toString(motionEvent);
        G0(getCurrentPage());
        G0(getCurrentPage());
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // com.luutinhit.launcher6.v, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        wq wqVar;
        SlidingUpWidgetsList slidingUpWidgetsList;
        SlidingUpWidgetsAppStyle slidingUpWidgetsAppStyle;
        Objects.toString(motionEvent);
        t tVar = this.S0;
        if (tVar != null && (wqVar = tVar.leftPage) != null && (((slidingUpWidgetsList = wqVar.p) != null && slidingUpWidgetsList.getVisibility() == 0) || ((slidingUpWidgetsAppStyle = wqVar.q) != null && slidingUpWidgetsAppStyle.getVisibility() == 0))) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.w1 = motionEvent.getX();
            this.x1 = motionEvent.getY();
        } else if ((action == 1 || action == 6) && this.K == 0 && ((CellLayout) getChildAt(this.o)) != null) {
            try {
                Objects.toString(motionEvent);
                int[] iArr = this.V0;
                getLocationOnScreen(iArr);
                int actionIndex = motionEvent.getActionIndex();
                iArr[0] = iArr[0] + ((int) motionEvent.getX(actionIndex));
                iArr[1] = iArr[1] + ((int) motionEvent.getY(actionIndex));
                IBinder windowToken = getWindowToken();
                if (windowToken != null) {
                    this.u0.sendWallpaperCommand(windowToken, motionEvent.getAction() == 1 ? "android.wallpaper.tap" : "android.wallpaper.secondaryTap", iArr[0], iArr[1], 0, null);
                }
            } catch (Throwable unused) {
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.luutinhit.launcher6.v, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        getChildCount();
        if (this.m && (i5 = this.o) >= 0 && i5 < getChildCount()) {
            this.m1.b();
            tv1 tv1Var = this.m1;
            Message.obtain(tv1Var.c, 5, tv1Var.e).sendToTarget();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.luutinhit.launcher6.v, android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        Objects.toString(rect);
        if (this.S0.isAppsViewVisible()) {
            return false;
        }
        Folder openFolder = getOpenFolder();
        return openFolder != null ? openFolder.requestFocus(i, rect) : super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Objects.toString(view);
        Objects.toString(motionEvent);
        if (h1()) {
            return true;
        }
        return (h1() || indexOfChild(view) == this.o) ? false : true;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        this.S0.onWindowVisibilityChanged(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cd, code lost:
    
        if ((r2 > r16.u1 ? false : f1(r7.b(r3[0], r3[1]), r1)) != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x010e, code lost:
    
        if ((r4 == r2.m) != false) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ab  */
    @Override // defpackage.ox
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(defpackage.nx r17) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.Workspace.p(nx):boolean");
    }

    public final void p0(boolean z) {
        if (z) {
            this.p1.a();
        }
        this.z1 = -1;
        this.A1 = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x018c  */
    @Override // defpackage.ox
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(defpackage.nx r31) {
        /*
            Method dump skipped, instruction units count: 929
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.Workspace.q(nx):void");
    }

    public final long q0() {
        t tVar = this.S0;
        if (tVar.isWorkspaceLoading()) {
            t.addDumpLog("Workspace", "    - workspace loading, skip", true);
            return -1L;
        }
        int iE0 = E0(-201L);
        wp0 wp0Var = this.z0;
        CellLayout cellLayout = (CellLayout) wp0Var.get(-201L);
        wp0Var.remove(-201L);
        ArrayList arrayList = this.A0;
        arrayList.remove((Object) (-201L));
        long jZ = jk0.c().h.z();
        wp0Var.put(jZ, cellLayout);
        arrayList.add(Long.valueOf(jZ));
        e1();
        if (getPageIndicator() != null) {
            PageIndicator pageIndicator = getPageIndicator();
            v01 v01VarD = D(iE0);
            ArrayList arrayList2 = pageIndicator.m;
            if (iE0 < 0 || iE0 >= arrayList2.size()) {
                arrayList2.size();
            } else {
                ((PageIndicatorMarker) arrayList2.get(iE0)).setMarkerDrawables(v01VarD.a);
            }
        }
        tVar.getModel().getClass();
        rl0.G(tVar, arrayList);
        return jZ;
    }

    @Override // defpackage.ox
    public final void r(nx nxVar) {
        Objects.toString(nxVar);
        if (!this.i1) {
            this.R0 = this.P0;
        } else if (this.U) {
            this.R0 = (CellLayout) getChildAt(getNextPage());
        } else {
            this.R0 = this.Q0;
        }
        int i = this.y1;
        if (i == 1) {
            this.s1 = true;
        } else if (i == 2) {
            this.t1 = true;
        }
        setCurrentDragOverlappingLayout(null);
        this.i1 = false;
        setCurrentDropLayout(null);
        setCurrentDragOverlappingLayout(null);
        ((g3) this.b1.h).a();
        this.S0.getDragLayer().hidePageHints();
    }

    public final void r0(int i) {
        CellLayout cellLayout = (CellLayout) this.S0.getLayoutInflater().inflate(m61.workspace_screen, (ViewGroup) this, false);
        cellLayout.o = false;
        cellLayout.p = false;
        long j = i == 0 ? -301L : -302L;
        this.z0.put(j, cellLayout);
        ArrayList arrayList = this.A0;
        if (i == 0) {
            arrayList.add(0, Long.valueOf(j));
        } else {
            arrayList.add(arrayList.size(), Long.valueOf(j));
        }
        int i2 = this.F0.C;
        cellLayout.setPadding(i2, 0, i2, 0);
        e(cellLayout, i);
        if (i == 0) {
            this.x0 = this.w0 + 1;
            int i3 = this.p;
            if (i3 != -1001) {
                this.p = i3 + 1;
            } else {
                setCurrentPage(getCurrentPage() + 1);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0045 A[PHI: r5
  0x0045: PHI (r5v2 boolean) = (r5v1 boolean), (r5v12 boolean) binds: [B:5:0x0020, B:11:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.lw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(defpackage.xw r5, java.lang.Object r6) {
        /*
            r4 = this;
            java.util.Objects.toString(r5)
            java.util.Objects.toString(r6)
            r5 = 0
            r4.d1(r5)
            com.luutinhit.launcher6.t r6 = r4.S0
            r6.lockScreenOrientation()
            r6.onInteractionBegin()
            r6 = 1
            com.luutinhit.launcher6.InstallShortcutReceiver.b = r6
            boolean r0 = r4.D0
            if (r0 == 0) goto L70
            r4.C0 = r5
            r0 = 0
            r4.B0 = r0
            ng1 r0 = r4.y0
            if (r0 == 0) goto L45
            int r0 = r0.getChildCount()
            if (r0 != r6) goto L2a
            r0 = 1
            goto L2b
        L2a:
            r0 = 0
        L2b:
            ng1 r1 = r4.y0
            android.view.ViewParent r1 = r1.getParent()
            com.luutinhit.launcher6.CellLayout r1 = (com.luutinhit.launcher6.CellLayout) r1
            int r1 = r4.indexOfChild(r1)
            int r2 = r4.getChildCount()
            int r3 = r4.R0()
            int r2 = r2 - r3
            r5 = r0
            if (r1 != r2) goto L45
            r0 = 1
            goto L46
        L45:
            r0 = 0
        L46:
            if (r5 == 0) goto L4b
            if (r0 == 0) goto L4b
            goto L70
        L4b:
            wp0 r5 = r4.z0
            r0 = -201(0xffffffffffffff37, double:NaN)
            boolean r5 = r5.b(r0)
            if (r5 != 0) goto L70
            java.util.ArrayList r5 = r4.A0
            r2 = -302(0xfffffffffffffed2, double:NaN)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            boolean r5 = r5.contains(r2)
            if (r5 == 0) goto L69
            int r5 = r4.getChildCount()
            int r5 = r5 - r6
            goto L6d
        L69:
            int r5 = r4.getChildCount()
        L6d:
            r4.K0(r5, r0)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.Workspace.s(xw, java.lang.Object):void");
    }

    public final Bitmap s0(View view, AtomicInteger atomicInteger) {
        Objects.toString(view);
        Objects.toString(atomicInteger);
        int i = atomicInteger.get();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth() + i, view.getHeight() + i, Bitmap.Config.ARGB_8888);
        Canvas canvas = this.v1;
        canvas.setBitmap(bitmapCreateBitmap);
        u0(view, canvas, i);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public void setAddNewPageOnDrag(boolean z) {
        this.D0 = z;
    }

    public void setCurrentDragOverlappingLayout(CellLayout cellLayout) {
        Objects.toString(cellLayout);
        CellLayout cellLayout2 = this.Q0;
        if (cellLayout2 != null) {
            cellLayout2.setIsDragOverlapping(false);
        }
        this.Q0 = cellLayout;
        if (cellLayout != null) {
            cellLayout.setIsDragOverlapping(true);
        }
        invalidate();
    }

    public void setCurrentDropLayout(CellLayout cellLayout) {
        Objects.toString(cellLayout);
        CellLayout cellLayout2 = this.P0;
        if (cellLayout2 != null) {
            cellLayout2.E();
            CellLayout cellLayout3 = this.P0;
            if (cellLayout3.H) {
                cellLayout3.H = false;
            }
            int[] iArr = cellLayout3.G;
            iArr[1] = -1;
            iArr[0] = -1;
            cellLayout3.E();
            cellLayout3.setIsDragOverlapping(false);
        }
        this.P0 = cellLayout;
        if (cellLayout != null) {
            cellLayout.H = true;
        }
        p0(true);
        o0();
        if (-1 == this.H0 && -1 == this.I0) {
            return;
        }
        this.H0 = -1;
        this.I0 = -1;
        setDragMode(0);
    }

    public void setDragMode(int i) {
        if (i != this.y1) {
            if (i == 0) {
                n0();
                p0(false);
                o0();
            } else if (i == 2) {
                p0(true);
                o0();
            } else if (i == 1) {
                n0();
                p0(true);
            } else if (i == 3) {
                n0();
                o0();
            }
            this.y1 = i;
        }
    }

    public void setFinalTransitionTransform(CellLayout cellLayout) {
        Objects.toString(cellLayout);
    }

    @Override // defpackage.fg0
    public void setInsets(Rect rect) {
        Objects.toString(rect);
        Rect rect2 = this.n0;
        rect2.set(rect);
        CellLayout cellLayoutH0 = H0(-301L);
        if (cellLayoutH0 != null) {
            KeyEvent.Callback childAt = cellLayoutH0.getShortcutsAndWidgets().getChildAt(0);
            if (childAt instanceof fg0) {
                ((fg0) childAt).setInsets(rect2);
            }
        }
    }

    public void setLauncherOverlay(yj0 yj0Var) {
        Objects.toString(yj0Var);
        float fMin = Math.min(1.0f, Math.max(0.0f, 0.0f) / 1.0f);
        float interpolation = 1.0f - this.K1.getInterpolation(fMin);
        t tVar = this.S0;
        float measuredWidth = tVar.getDragLayer().getMeasuredWidth() * fMin * 1.0f;
        if (this.o0) {
            measuredWidth = -measuredWidth;
        }
        this.G1 = measuredWidth;
        PageIndicator pageIndicator = getPageIndicator();
        Objects.toString(pageIndicator);
        if (pageIndicator != null) {
            pageIndicator.setTranslationX(measuredWidth);
            pageIndicator.setAlpha(interpolation);
        }
        View childAt = getChildAt(getCurrentPage());
        Objects.toString(childAt);
        if (childAt != null) {
            childAt.setTranslationX(measuredWidth);
            childAt.setAlpha(interpolation);
        }
        Hotseat hotseat = tVar.getHotseat();
        Objects.toString(hotseat);
        if (hotseat != null) {
            hotseat.setTranslationX(measuredWidth);
            hotseat.setAlpha(interpolation);
        }
        if (measuredWidth == 0.0f) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt2 = getChildAt(childCount);
                Objects.toString(childAt2);
                if (childAt2 != null) {
                    childAt2.setTranslationX(0.0f);
                    childAt2.setAlpha(interpolation);
                }
            }
        }
    }

    public void setState(d02 d02Var) {
        this.e1 = d02Var;
    }

    public void setup(mw mwVar) {
        Objects.toString(mwVar);
        wb2 wb2Var = new wb2(21, false);
        wb2Var.j = this.S0;
        g3 g3Var = new g3();
        wb2Var.h = g3Var;
        g3Var.j = wb2Var;
        this.b1 = wb2Var;
        this.U0 = mwVar;
        d1(false);
    }

    @Override // defpackage.lw
    public final void t() {
        if (!this.C0) {
            W0(true, null, 0, this.y0 != null);
        }
        d1(false);
        t tVar = this.S0;
        tVar.unlockScreenOrientation(false);
        Context context = getContext();
        InstallShortcutReceiver.b = false;
        InstallShortcutReceiver.c(context);
        this.y0 = null;
        tVar.onInteractionEnd();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean t0(android.view.View r21, long r22, com.luutinhit.launcher6.CellLayout r24, int[] r25, float r26, boolean r27, defpackage.zw r28, defpackage.vz1 r29) {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.Workspace.t0(android.view.View, long, com.luutinhit.launcher6.CellLayout, int[], float, boolean, zw, vz1):boolean");
    }

    @Override // defpackage.jj1
    public final void u(View view, Bundle bundle) {
        Objects.toString(view);
        Objects.toString(bundle);
        bundle.putString("container", "homescreen");
        bundle.putInt("container_page", getCurrentPage());
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0187 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x019a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b2  */
    @Override // defpackage.ox
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(defpackage.nx r50) {
        /*
            Method dump skipped, instruction units count: 1292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.Workspace.v(nx):void");
    }

    public final void v0(int i, int i2) {
        if (i > i2) {
            i2 = i;
            i = i2;
        }
        int childCount = getChildCount();
        int iMin = Math.min(i2, childCount - 1);
        for (int iMax = Math.max(i, 0); iMax <= iMin; iMax++) {
            CellLayout cellLayout = (CellLayout) getChildAt(iMax);
            cellLayout.setChildrenDrawnWithCacheEnabled(true);
            cellLayout.setChildrenDrawingCacheEnabled(true);
        }
    }

    @Override // com.luutinhit.launcher6.v
    public final void w(MotionEvent motionEvent, float f) {
        Objects.toString(motionEvent);
        super.w(motionEvent, 1.0f);
    }

    public final void w0() {
        if (this.g1) {
            int childCount = getChildCount();
            int[] iArr = this.k1;
            F(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            if (i == i2) {
                if (i2 < childCount - 1) {
                    i2++;
                } else if (i > 0) {
                    i--;
                }
            }
            CellLayout cellLayout = (CellLayout) this.z0.get(-301L);
            int i3 = 0;
            while (i3 < childCount) {
                CellLayout cellLayout2 = (CellLayout) getChildAt(i3);
                boolean z = cellLayout2 != cellLayout && i <= i3 && i3 <= i2 && X(cellLayout2);
                cellLayout2.getClass();
                cellLayout2.I.setLayerType(z ? 2 : 0, CellLayout.V);
                i3++;
            }
        }
    }

    public final int[] x0(qh0 qh0Var, boolean z) {
        Objects.toString(qh0Var);
        int[] iArr = new int[2];
        if (getChildCount() <= 0) {
            iArr[0] = Integer.MAX_VALUE;
            iArr[1] = Integer.MAX_VALUE;
            return iArr;
        }
        CellLayout cellLayout = (CellLayout) getChildAt(R0());
        int i = qh0Var.m;
        int i2 = qh0Var.n;
        Objects.toString(cellLayout);
        Rect rect = new Rect();
        cellLayout.g(0, 0, i, i2, rect);
        iArr[0] = rect.width();
        int iHeight = rect.height();
        iArr[1] = iHeight;
        if (z) {
            int i3 = iArr[0];
            int i4 = (int) this.c1;
            iArr[0] = i3 * i4;
            iArr[1] = iHeight * i4;
        }
        return iArr;
    }

    public final void y0(int i, boolean z, Runnable runnable) {
        Objects.toString(runnable);
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(Key.ALPHA, 0.0f);
        PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat("backgroundAlpha", 0.0f);
        CellLayout cellLayout = (CellLayout) this.z0.get(-201L);
        this.B0 = new dl0(this, cellLayout, z);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(cellLayout, propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
        objectAnimatorOfPropertyValuesHolder.setDuration(150);
        objectAnimatorOfPropertyValuesHolder.setStartDelay(i);
        objectAnimatorOfPropertyValuesHolder.addListener(new um(this, runnable, 8));
        objectAnimatorOfPropertyValuesHolder.start();
    }
}
