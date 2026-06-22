package com.luutinhit.launcher6;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.luutinhit.launcher6.util.CustomIconView;
import defpackage.ah;
import defpackage.e02;
import defpackage.ik0;
import defpackage.jd;
import defpackage.kw;
import defpackage.l51;
import defpackage.n11;
import defpackage.ng1;
import defpackage.o40;
import defpackage.p40;
import defpackage.pk0;
import defpackage.qh0;
import defpackage.qs1;
import defpackage.r1;
import defpackage.rl0;
import defpackage.t40;
import defpackage.tg;
import defpackage.ug;
import defpackage.v51;
import defpackage.ve0;
import defpackage.vg;
import defpackage.wg;
import defpackage.xg0;
import defpackage.xu;
import defpackage.y01;
import defpackage.yg;
import defpackage.zg;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class CellLayout extends ViewGroup implements y01 {
    public static final Paint V = new Paint();
    public final int A;
    public final int B;
    public boolean C;
    public final HashMap D;
    public final HashMap E;
    public boolean F;
    public final int[] G;
    public boolean H;
    public final ng1 I;
    public boolean J;
    public final float K;
    public final float L;
    public final ArrayList M;
    public final Rect N;
    public final int[] O;
    public final int[] P;
    public final Rect Q;
    public kw R;
    public boolean S;
    public final xu T;
    public final Stack U;
    public final t g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public final int[] q;
    public final int[] r;
    public boolean[][] s;
    public boolean[][] t;
    public View.OnTouchListener u;
    public final jd v;
    public final ArrayList w;
    public final int[] x;
    public float y;
    public final TransitionDrawable z;

    public CellLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.n = false;
        this.o = true;
        this.p = true;
        this.q = new int[2];
        this.r = new int[2];
        this.w = new ArrayList();
        this.x = new int[]{-1, -1};
        this.A = -1;
        this.B = -1;
        this.C = false;
        this.D = new HashMap();
        this.E = new HashMap();
        this.F = false;
        this.G = new int[2];
        this.H = false;
        this.J = false;
        this.K = 1.0f;
        this.M = new ArrayList();
        this.N = new Rect();
        this.O = new int[2];
        this.P = new int[]{-100, -100};
        this.Q = new Rect();
        this.S = false;
        this.U = new Stack();
        setWillNotDraw(false);
        setClipToPadding(false);
        setClipChildren(false);
        t tVar = (t) context;
        this.g = tVar;
        xu deviceProfile = tVar.getDeviceProfile();
        this.T = deviceProfile;
        this.i = -1;
        this.h = -1;
        this.k = -1;
        this.j = -1;
        xg0 xg0Var = deviceProfile.a;
        int i = xg0Var.d;
        this.l = i;
        int i2 = xg0Var.c;
        this.m = i2;
        int[] iArr = {i, i2};
        Class cls = Boolean.TYPE;
        this.s = (boolean[][]) Array.newInstance((Class<?>) cls, iArr);
        this.t = (boolean[][]) Array.newInstance((Class<?>) cls, this.l, this.m);
        setAlwaysDrawnWithCacheEnabled(false);
        Resources resources = getResources();
        this.K = deviceProfile.R / deviceProfile.D;
        TransitionDrawable transitionDrawable = (TransitionDrawable) resources.getDrawable(l51.bg_screenpanel);
        this.z = transitionDrawable;
        transitionDrawable.setCallback(this);
        transitionDrawable.setAlpha((int) (this.y * 255.0f));
        this.L = deviceProfile.D * 0.12f;
        ng1 ng1Var = new ng1(context);
        this.I = ng1Var;
        ng1Var.j(this.h, this.i, this.l, this.m);
        this.v = new jd(this);
        addView(ng1Var);
    }

    public static void j(float f, float f2, int[] iArr) {
        double dAtan = Math.atan(f2 / f);
        iArr[0] = 0;
        iArr[1] = 0;
        if (Math.abs(Math.cos(dAtan)) > 0.5d) {
            iArr[0] = (int) Math.signum(f);
        }
        if (Math.abs(Math.sin(dAtan)) > 0.5d) {
            iArr[1] = (int) Math.signum(f2);
        }
    }

    private void setUseTempCoords(boolean z) {
        ng1 ng1Var = this.I;
        int childCount = ng1Var.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((zg) ng1Var.getChildAt(i).getLayoutParams()).e = z;
        }
    }

    public final int[] A(int i, int i2, int i3, int i4, int i5, int i6, View view, int[] iArr, int[] iArr2, int i7) {
        int i8;
        int i9;
        char c;
        Objects.toString(view);
        CellLayout cellLayout = this;
        int[] iArrQ = cellLayout.q(i, i2, i5, i6, i5, i6, false, iArr, null);
        int[] iArr3 = iArr2 == null ? new int[2] : iArr2;
        int[] iArr4 = cellLayout.P;
        int[] iArr5 = cellLayout.O;
        if ((i7 == 2 || i7 == 3 || i7 == 4) && (i8 = iArr4[0]) != -100) {
            iArr5[0] = i8;
            iArr5[1] = iArr4[1];
            if (i7 == 2 || i7 == 3) {
                iArr4[0] = -100;
                iArr4[1] = -100;
            }
            i9 = i5;
            c = 1;
        } else {
            Objects.toString(view);
            int[] iArr6 = new int[2];
            c = 1;
            cellLayout.q(i, i2, i5, i6, i5, i6, false, iArr6, null);
            Rect rect = new Rect();
            cellLayout = this;
            cellLayout.D(iArr6[0], iArr6[1], i5, i6, rect);
            rect.offset(i - rect.centerX(), i2 - rect.centerY());
            Rect rect2 = new Rect();
            cellLayout.t(iArr6[0], iArr6[1], i5, i6, view, rect2, cellLayout.M);
            i9 = i5;
            int iWidth = rect2.width();
            int iHeight = rect2.height();
            cellLayout.D(rect2.left, rect2.top, rect2.width(), rect2.height(), rect2);
            int iCenterX = (rect2.centerX() - i) / i9;
            int iCenterY = (rect2.centerY() - i2) / i6;
            int i10 = cellLayout.l;
            if (iWidth == i10 || i9 == i10) {
                iCenterX = 0;
            }
            int i11 = cellLayout.m;
            if (iHeight == i11 || i6 == i11) {
                iCenterY = 0;
            }
            if (iCenterX == 0 && iCenterY == 0) {
                iArr5[0] = 1;
                iArr5[1] = 0;
            } else {
                j(iCenterX, iCenterY, iArr5);
            }
            iArr4[0] = iArr5[0];
            iArr4[1] = iArr5[1];
        }
        yg ygVarR = cellLayout.r(i, i2, i3, i4, i9, i6, cellLayout.O, view, true, new yg(cellLayout));
        yg ygVar = new yg(cellLayout);
        Objects.toString(view);
        Objects.toString(ygVar);
        int[] iArr7 = new int[2];
        int[] iArr8 = new int[2];
        cellLayout.q(i, i2, i3, i4, i5, i6, true, iArr7, iArr8);
        if (iArr7[0] < 0 || iArr7[c] < 0) {
            ygVar.e = false;
        } else {
            cellLayout.k(ygVar);
            ygVar.f = iArr7[0];
            ygVar.g = iArr7[c];
            ygVar.h = iArr8[0];
            ygVar.i = iArr8[c];
            ygVar.e = true;
        }
        if (!ygVarR.e || ygVarR.h * ygVarR.i < ygVar.h * ygVar.i) {
            ygVarR = ygVar.e ? ygVar : null;
        }
        if (i7 == 0) {
            if (ygVarR == null) {
                iArr3[1] = -1;
                iArr3[0] = -1;
                iArrQ[1] = -1;
                iArrQ[0] = -1;
                return iArrQ;
            }
            cellLayout.f(ygVarR, view, 0);
            iArrQ[0] = ygVarR.f;
            iArrQ[1] = ygVarR.g;
            iArr3[0] = ygVarR.h;
            iArr3[1] = ygVarR.i;
            return iArrQ;
        }
        boolean z = true;
        boolean z2 = false;
        cellLayout.setUseTempCoords(true);
        if (ygVarR != null) {
            iArrQ[0] = ygVarR.f;
            iArrQ[1] = ygVarR.g;
            iArr3[0] = ygVarR.h;
            iArr3[1] = ygVarR.i;
            if (i7 == 1 || i7 == 2 || i7 == 3) {
                cellLayout.l(ygVarR, view);
                cellLayout.setItemPlacementDirty(true);
                cellLayout.d(ygVarR, view, i7 == 2);
                if (i7 == 2 || i7 == 3) {
                    cellLayout.h();
                    cellLayout.i();
                    z2 = false;
                    cellLayout.setItemPlacementDirty(false);
                } else {
                    cellLayout.f(ygVarR, view, 1);
                    z2 = false;
                }
            } else {
                z2 = false;
            }
        } else {
            iArr3[1] = -1;
            iArr3[0] = -1;
            iArrQ[1] = -1;
            iArrQ[0] = -1;
            z = false;
        }
        if (i7 == 2 || !z) {
            cellLayout.setUseTempCoords(z2);
        }
        cellLayout.I.requestLayout();
        return iArrQ;
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x019d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean B(java.util.ArrayList r20, android.graphics.Rect r21, int[] r22, android.view.View r23, defpackage.yg r24) {
        /*
            Method dump skipped, instruction units count: 694
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.CellLayout.B(java.util.ArrayList, android.graphics.Rect, int[], android.view.View, yg):boolean");
    }

    public final void C(int i, int i2, int i3, int i4, int[] iArr) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i5 = this.h;
        iArr[0] = ((i3 * i5) / 2) + (i * i5) + paddingLeft;
        int i6 = this.i;
        iArr[1] = (((i4 * i6) / 2) + ((i2 * i6) + paddingTop)) - (i6 / 4);
    }

    public final void D(int i, int i2, int i3, int i4, Rect rect) {
        Objects.toString(rect);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i5 = this.h;
        int i6 = (i * i5) + paddingLeft;
        int i7 = this.i;
        int i8 = (i2 * i7) + paddingTop;
        rect.set(i6, i8, (i3 * i5) + i6, (i4 * i7) + i8);
    }

    public final void E() {
        i();
        if (this.F) {
            ng1 ng1Var = this.I;
            int childCount = ng1Var.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ng1Var.getChildAt(i);
                zg zgVar = (zg) childAt.getLayoutParams();
                int i2 = zgVar.c;
                int i3 = zgVar.a;
                if (i2 != i3 || zgVar.d != zgVar.b) {
                    zgVar.c = i3;
                    int i4 = zgVar.b;
                    zgVar.d = i4;
                    c(childAt, i3, i4, 150, 0, false, false);
                }
            }
            setItemPlacementDirty(false);
        }
    }

    public final void F(int i, int i2) {
        this.l = i;
        this.m = i2;
        int[] iArr = {i, i2};
        Class cls = Boolean.TYPE;
        this.s = (boolean[][]) Array.newInstance((Class<?>) cls, iArr);
        this.t = (boolean[][]) Array.newInstance((Class<?>) cls, this.l, this.m);
        this.U.clear();
        this.I.j(this.h, this.i, this.l, this.m);
        requestLayout();
    }

    public final void G(t40 t40Var) {
        Objects.toString(t40Var);
        this.w.add(t40Var);
        t tVar = this.g;
        if (tVar == null || !tVar.isShaking()) {
            return;
        }
        View viewB = this.I.b(t40Var.a, t40Var.b);
        if (viewB != null) {
            viewB.clearAnimation();
        }
    }

    public final boolean a(View view, int i, int i2, zg zgVar, boolean z) {
        int i3;
        Objects.toString(view);
        Objects.toString(zgVar);
        if (view != null) {
            try {
                if (view instanceof BubbleTextView) {
                    ((BubbleTextView) view).setTextVisibility(!this.J);
                }
                view.setScaleX(getChildrenScale());
                view.setScaleY(getChildrenScale());
                int i4 = zgVar.a;
                if (i4 >= 0) {
                    int i5 = this.l;
                    if (i4 <= i5 - 1 && (i3 = zgVar.b) >= 0) {
                        int i6 = this.m;
                        if (i3 <= i6 - 1) {
                            if (zgVar.f < 0) {
                                zgVar.f = i5;
                            }
                            if (zgVar.g < 0) {
                                zgVar.g = i6;
                            }
                            view.setId(i2);
                            if (view instanceof pk0) {
                                float f = (((pk0) view).getLauncherAppWidgetProviderInfo() == null || ((pk0) view).getLauncherAppWidgetProviderInfo().g <= 1 || ((pk0) view).getLauncherAppWidgetProviderInfo().h <= 1) ? 1.0f : 0.66f;
                                xu xuVar = this.T;
                                int i7 = (int) (xuVar.C * f);
                                ((ViewGroup.MarginLayoutParams) zgVar).rightMargin = i7;
                                ((ViewGroup.MarginLayoutParams) zgVar).leftMargin = i7;
                                ((ViewGroup.MarginLayoutParams) zgVar).topMargin = (this.i - xuVar.D) - xuVar.F;
                                ((ViewGroup.MarginLayoutParams) zgVar).bottomMargin = 0;
                            }
                            this.I.addView(view, i, zgVar);
                            if (z) {
                                v(view);
                            }
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
                post(new tg());
            }
        }
        return false;
    }

    public final boolean b(View view, int i, int i2, int i3, int i4) {
        Objects.toString(view);
        ng1 shortcutsAndWidgets = getShortcutsAndWidgets();
        boolean[][] zArr = this.s;
        if (shortcutsAndWidgets.indexOfChild(view) == -1) {
            return false;
        }
        zg zgVar = (zg) view.getLayoutParams();
        qh0 qh0Var = (qh0) view.getTag();
        HashMap map = this.D;
        if (map.containsKey(zgVar)) {
            ((Animator) map.get(zgVar)).cancel();
            map.remove(zgVar);
        }
        int i5 = zgVar.k;
        int i6 = zgVar.l;
        zArr[zgVar.a][zgVar.b] = false;
        zArr[i][i2] = true;
        zgVar.h = true;
        zgVar.e = false;
        qh0Var.k = i;
        zgVar.a = i;
        qh0Var.l = i2;
        zgVar.b = i2;
        shortcutsAndWidgets.setupLp(zgVar);
        zgVar.h = false;
        int i7 = zgVar.k;
        int i8 = zgVar.l;
        zgVar.k = i5;
        zgVar.l = i6;
        if (i5 == i7 && i6 == i8) {
            zgVar.h = true;
            return true;
        }
        ValueAnimator valueAnimatorC = ik0.c(0.0f, 1.0f);
        valueAnimatorC.setDuration(i3);
        map.put(zgVar, valueAnimatorC);
        valueAnimatorC.addUpdateListener(new ug(zgVar, i5, i7, i6, i8, view, 1));
        valueAnimatorC.addListener(new vg(this, zgVar, view, 1));
        valueAnimatorC.setStartDelay(i4);
        valueAnimatorC.start();
        return true;
    }

    public final boolean c(View view, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        Objects.toString(view);
        ng1 shortcutsAndWidgets = getShortcutsAndWidgets();
        boolean[][] zArr = this.s;
        if (!z) {
            zArr = this.t;
        }
        if (shortcutsAndWidgets.indexOfChild(view) == -1) {
            return false;
        }
        zg zgVar = (zg) view.getLayoutParams();
        qh0 qh0Var = (qh0) view.getTag();
        HashMap map = this.D;
        if (map.containsKey(zgVar)) {
            ((Animator) map.get(zgVar)).cancel();
            map.remove(zgVar);
        }
        int i5 = zgVar.k;
        int i6 = zgVar.l;
        if (z2) {
            zArr[zgVar.a][zgVar.b] = false;
            zArr[i][i2] = true;
        }
        zgVar.h = true;
        if (z) {
            qh0Var.k = i;
            zgVar.a = i;
            qh0Var.l = i2;
            zgVar.b = i2;
        } else {
            zgVar.c = i;
            zgVar.d = i2;
        }
        shortcutsAndWidgets.setupLp(zgVar);
        zgVar.h = false;
        int i7 = zgVar.k;
        int i8 = zgVar.l;
        zgVar.k = i5;
        zgVar.l = i6;
        if (i5 == i7 && i6 == i8) {
            zgVar.h = true;
            return true;
        }
        ValueAnimator valueAnimatorC = ik0.c(0.0f, 1.0f);
        valueAnimatorC.setDuration(i3);
        map.put(zgVar, valueAnimatorC);
        valueAnimatorC.addUpdateListener(new ug(zgVar, i5, i7, i6, i8, view, 0));
        valueAnimatorC.addListener(new vg(this, zgVar, view, 0));
        valueAnimatorC.setStartDelay(i4);
        valueAnimatorC.start();
        return true;
    }

    @Override // android.view.View
    public final void cancelLongPress() {
        super.cancelLongPress();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).cancelLongPress();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Objects.toString(layoutParams);
        return layoutParams instanceof zg;
    }

    public final void d(yg ygVar, View view, boolean z) {
        wg wgVar;
        boolean[][] zArr;
        Objects.toString(ygVar);
        Objects.toString(view);
        boolean[][] zArr2 = this.t;
        for (int i = 0; i < this.l; i++) {
            for (int i2 = 0; i2 < this.m; i2++) {
                zArr2[i][i2] = false;
            }
        }
        ng1 ng1Var = this.I;
        int childCount = ng1Var.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = ng1Var.getChildAt(i3);
            if (childAt == view || (wgVar = (wg) ygVar.a.get(childAt)) == null) {
                zArr = zArr2;
            } else {
                c(childAt, wgVar.a, wgVar.b, 150, 0, false, false);
                zArr = zArr2;
                x(wgVar.a, wgVar.b, wgVar.c, wgVar.d, zArr, true);
            }
            i3++;
            zArr2 = zArr;
        }
        boolean[][] zArr3 = zArr2;
        if (z) {
            x(ygVar.f, ygVar.g, ygVar.h, ygVar.i, zArr3, true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        Objects.toString(motionEvent);
        return (this.S && this.R.l(motionEvent)) || super.dispatchHoverEvent(motionEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Objects.toString(sparseArray);
        if (this.p) {
            Objects.toString(sparseArray);
            Parcelable parcelable = (Parcelable) sparseArray.get(v51.cell_layout_jail_id);
            sparseArray = parcelable instanceof n11 ? (n11) parcelable : new n11();
        }
        super.dispatchRestoreInstanceState(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        Objects.toString(sparseArray);
        if (!this.p) {
            super.dispatchSaveInstanceState(sparseArray);
            return;
        }
        Objects.toString(sparseArray);
        Parcelable parcelable = (Parcelable) sparseArray.get(v51.cell_layout_jail_id);
        n11 n11Var = parcelable instanceof n11 ? (n11) parcelable : new n11();
        super.dispatchSaveInstanceState(n11Var);
        sparseArray.put(v51.cell_layout_jail_id, n11Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0176  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(defpackage.xg0 r29, boolean r30) {
        /*
            Method dump skipped, instruction units count: 439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.CellLayout.e(xg0, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(defpackage.yg r18, android.view.View r19, int r20) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.CellLayout.f(yg, android.view.View, int):void");
    }

    public final void g(int i, int i2, int i3, int i4, Rect rect) {
        Objects.toString(rect);
        int i5 = this.h;
        int i6 = this.i;
        int i7 = i3 * i5;
        int i8 = i4 * i6;
        int paddingLeft = (i5 * i) + getPaddingLeft();
        int paddingTop = (i6 * i2) + getPaddingTop();
        rect.set(paddingLeft, paddingTop, i7 + paddingLeft, i8 + paddingTop);
        rect.toString();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Objects.toString(attributeSet);
        zg zgVar = new zg(getContext(), attributeSet);
        zgVar.h = true;
        zgVar.i = false;
        zgVar.j = true;
        zgVar.f = 1;
        zgVar.g = 1;
        return zgVar;
    }

    public float getBackgroundAlpha() {
        return this.y;
    }

    public int getCellHeight() {
        return this.i;
    }

    public int getCellWidth() {
        return this.h;
    }

    public float getChildrenScale() {
        if (this.J) {
            return this.K;
        }
        return 1.0f;
    }

    public int getCountX() {
        return this.l;
    }

    public int getCountY() {
        return this.m;
    }

    public int getDesiredHeight() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int i = this.m;
        int i2 = (this.i * i) + paddingBottom;
        Math.max(i - 1, 0);
        return i2;
    }

    public int getDesiredWidth() {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int i = this.l;
        int i2 = (this.h * i) + paddingRight;
        Math.max(i - 1, 0);
        return i2;
    }

    public int getHeightGap() {
        return 0;
    }

    public boolean getIsDragOverlapping() {
        return this.C;
    }

    public ng1 getShortcutsAndWidgets() {
        return this.I;
    }

    public int getUnusedHorizontalSpace() {
        return ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - (this.l * this.h);
    }

    public int getWidthGap() {
        return 0;
    }

    public final void h() {
        int i;
        for (int i2 = 0; i2 < this.l; i2++) {
            int i3 = this.m;
            if (i3 >= 0) {
                System.arraycopy(this.t[i2], 0, this.s[i2], 0, i3);
            }
        }
        ng1 ng1Var = this.I;
        int childCount = ng1Var.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = ng1Var.getChildAt(i4);
            zg zgVar = (zg) childAt.getLayoutParams();
            qh0 qh0Var = (qh0) childAt.getTag();
            if (qh0Var != null) {
                int i5 = qh0Var.k;
                int i6 = zgVar.c;
                if (i5 != i6 || qh0Var.l != zgVar.d || qh0Var.m != zgVar.f || qh0Var.n != zgVar.g) {
                    qh0Var.t = true;
                }
                zgVar.a = i6;
                qh0Var.k = i6;
                int i7 = zgVar.d;
                zgVar.b = i7;
                qh0Var.l = i7;
                qh0Var.m = zgVar.f;
                qh0Var.n = zgVar.g;
            }
        }
        Workspace workspace = this.g.getWorkspace();
        workspace.getClass();
        Objects.toString(this);
        int childCount2 = getShortcutsAndWidgets().getChildCount();
        long jC0 = workspace.C0(this);
        if (workspace.S0.isHotseatLayout(this)) {
            jC0 = -1;
            i = -101;
        } else {
            i = -100;
        }
        long j = jC0;
        for (int i8 = 0; i8 < childCount2; i8++) {
            qh0 qh0Var2 = (qh0) getShortcutsAndWidgets().getChildAt(i8).getTag();
            if (qh0Var2 != null && qh0Var2.t) {
                qh0Var2.t = false;
                rl0.s(workspace.S0, qh0Var2, i, j, qh0Var2.k, qh0Var2.l, qh0Var2.m, qh0Var2.n);
            }
        }
    }

    public final void i() {
        HashMap map = this.E;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((ah) it.next()).a();
        }
        map.clear();
    }

    public final void k(yg ygVar) {
        Objects.toString(ygVar);
        ng1 ng1Var = this.I;
        int childCount = ng1Var.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = ng1Var.getChildAt(i);
            zg zgVar = (zg) childAt.getLayoutParams();
            int i2 = zgVar.a;
            int i3 = zgVar.b;
            int i4 = zgVar.f;
            int i5 = zgVar.g;
            wg wgVar = new wg();
            wgVar.a = i2;
            wgVar.b = i3;
            wgVar.c = i4;
            wgVar.d = i5;
            Objects.toString(childAt);
            Objects.toString(wgVar);
            ygVar.a.put(childAt, wgVar);
            ygVar.b.put(childAt, new wg());
            ygVar.c.add(childAt);
        }
    }

    public final void l(yg ygVar, View view) {
        Objects.toString(ygVar);
        Objects.toString(view);
        for (int i = 0; i < this.l; i++) {
            for (int i2 = 0; i2 < this.m; i2++) {
                this.t[i][i2] = false;
            }
        }
        ng1 ng1Var = this.I;
        int childCount = ng1Var.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = ng1Var.getChildAt(i3);
            if (childAt != view) {
                zg zgVar = (zg) childAt.getLayoutParams();
                wg wgVar = (wg) ygVar.a.get(childAt);
                if (wgVar != null) {
                    int i4 = wgVar.a;
                    zgVar.c = i4;
                    int i5 = wgVar.b;
                    zgVar.d = i5;
                    int i6 = wgVar.c;
                    zgVar.f = i6;
                    int i7 = wgVar.d;
                    zgVar.g = i7;
                    x(i4, i5, i6, i7, this.t, true);
                }
            }
        }
        x(ygVar.f, ygVar.g, ygVar.h, ygVar.i, this.t, true);
    }

    public final boolean m(int i, int i2, int i3, int i4, View view, int[] iArr, boolean z) {
        Objects.toString(view);
        int[] iArr2 = new int[2];
        C(i, i2, i3, i4, iArr2);
        yg ygVarR = r(iArr2[0], iArr2[1], i3, i4, i3, i4, iArr, view, true, new yg(this));
        setUseTempCoords(true);
        if (ygVarR != null && ygVarR.e) {
            l(ygVarR, view);
            setItemPlacementDirty(true);
            d(ygVarR, view, z);
            if (z) {
                h();
                i();
                setItemPlacementDirty(false);
            } else {
                f(ygVarR, view, 1);
            }
            this.I.requestLayout();
        }
        return ygVarR.e;
    }

    public final void n(int i, boolean z) {
        this.S = z;
        if (z) {
            if (i == 2 && !(this.R instanceof e02)) {
                this.R = new e02(this);
            } else if (i == 1 && !(this.R instanceof o40)) {
                this.R = new o40(this);
            }
            qs1.p(this, this.R);
            setImportantForAccessibility(1);
            getShortcutsAndWidgets().setImportantForAccessibility(1);
            setOnClickListener(this.R);
        } else {
            qs1.p(this, null);
            setImportantForAccessibility(2);
            getShortcutsAndWidgets().setImportantForAccessibility(2);
            setOnClickListener(this.g);
        }
        if (getParent() != null) {
            getParent().notifySubtreeAccessibilityStateChanged(this, this, 1);
        }
    }

    public final boolean o(int[] iArr, int i, int i2) {
        int i3;
        int i4 = this.l - (i - 1);
        int i5 = this.m - (i2 - 1);
        boolean z = false;
        for (int i6 = 0; i6 < i5 && !z; i6++) {
            int i7 = 0;
            while (true) {
                if (i7 < i4) {
                    for (int i8 = 0; i8 < i; i8++) {
                        for (int i9 = 0; i9 < i2; i9++) {
                            i3 = i7 + i8;
                            if (this.s[i3][i6 + i9]) {
                                break;
                            }
                        }
                    }
                    z = true;
                    if (iArr != null) {
                        iArr[0] = i7;
                        iArr[1] = i6;
                    }
                }
                i7 = i3 + 1;
            }
        }
        return z;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Objects.toString(canvas);
        if (!this.o) {
            return;
        }
        if (this.y > 0.0f) {
            this.z.draw(canvas);
        }
        int i = 0;
        while (true) {
            ArrayList arrayList = this.w;
            if (i >= arrayList.size()) {
                return;
            }
            t40 t40Var = (t40) arrayList.get(i);
            float f = t40Var.d;
            int i2 = t40Var.a;
            int i3 = t40Var.b;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i4 = (this.h * i2) + paddingLeft;
            int[] iArr = this.r;
            iArr[0] = i4;
            iArr[1] = (this.i * i3) + paddingTop;
            View viewB = this.I.b(t40Var.a, t40Var.b);
            if (viewB != null) {
                int left = (this.h / 2) + iArr[0];
                int i5 = iArr[1] + this.i;
                xu xuVar = this.T;
                int top = (i5 - (xuVar.D / 2)) - xuVar.F;
                View iconView = viewB instanceof BubbleTextView ? ((BubbleTextView) viewB).getIconView() : viewB instanceof FolderIcon ? ((FolderIcon) viewB).getIconView() : null;
                if (iconView != null) {
                    left = iconView.getLeft() + iArr[0] + (xuVar.D / 2);
                    top = (xuVar.D / 2) + iconView.getTop() + iArr[1];
                }
                int childrenScale = (int) (getChildrenScale() * t40Var.d);
                canvas.save();
                float f2 = childrenScale;
                float f3 = f2 / 2.0f;
                canvas.translate(left - f3, top - f3);
                t40.h.set(0.0f, 0.0f, f2, f2);
                canvas.drawPath(ve0.c(f2, f2), t40.i);
                canvas.restore();
            }
            i++;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Objects.toString(motionEvent);
        if (this.S) {
            return true;
        }
        View.OnTouchListener onTouchListener = this.u;
        return onTouchListener != null && onTouchListener.onTouch(this, motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        ng1 ng1Var = this.I;
        boolean z2 = ng1Var.getChildCount() > 0 && ((zg) ng1Var.getChildAt(0).getLayoutParams()).i;
        int paddingLeft = getPaddingLeft();
        if (z2) {
            ng1Var.layout(0, 0, i3 - i, i4 - i2);
            return;
        }
        int iCeil = paddingLeft + ((int) Math.ceil(getUnusedHorizontalSpace() / 2.0f));
        int paddingTop = getPaddingTop();
        if (getParent() instanceof Workspace) {
            xu xuVar = this.T;
            if (xuVar.f && (i5 = (int) (((double) xuVar.B) - (((double) ((this.i - xuVar.D) - xuVar.F)) - (((double) xuVar.z) * 0.68d)))) > paddingTop) {
                paddingTop = i5;
            }
            setPadding(getPaddingLeft(), paddingTop, getPaddingRight(), getPaddingBottom());
        }
        ng1Var.layout(iCeil, paddingTop, (iCeil + i3) - i, (paddingTop + i4) - i2);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingRight = size - (getPaddingRight() + getPaddingLeft());
        int paddingBottom = size2 - (getPaddingBottom() + getPaddingTop());
        int i3 = this.j;
        ng1 ng1Var = this.I;
        if (i3 < 0 || this.k < 0) {
            int i4 = this.l;
            int i5 = paddingRight / i4;
            int i6 = this.m;
            int i7 = paddingBottom / i6;
            if (i5 != this.h || i7 != this.i) {
                this.h = i5;
                this.i = i7;
                ng1Var.j(i5, i7, i4, i6);
            }
        }
        int i8 = this.B;
        int i9 = this.A;
        if (i9 > 0 && i8 > 0) {
            paddingBottom = i8;
            paddingRight = i9;
        } else if (mode == 0 || mode2 == 0) {
            throw new RuntimeException("CellLayout cannot have UNSPECIFIED dimensions");
        }
        boolean z = false;
        if (ng1Var.getChildCount() > 0 && ((zg) ng1Var.getChildAt(0).getLayoutParams()).i) {
            z = true;
        }
        if (z) {
            paddingRight = size;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingRight, 1073741824);
        if (z) {
            paddingBottom = size2;
        }
        ng1Var.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(paddingBottom, 1073741824));
        int measuredWidth = ng1Var.getMeasuredWidth();
        int measuredHeight = ng1Var.getMeasuredHeight();
        if (i9 <= 0 || i8 <= 0) {
            setMeasuredDimension(size, size2);
        } else {
            setMeasuredDimension(measuredWidth, measuredHeight);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        TransitionDrawable transitionDrawable = this.z;
        Rect rect = this.Q;
        transitionDrawable.getPadding(rect);
        transitionDrawable.setBounds(-rect.left, -rect.top, i + rect.right, i2 + rect.bottom);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Objects.toString(motionEvent);
        return (this.g.mWorkspace.L0() && this.v.a(motionEvent)) || super.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(int r19, int r20, int r21, int r22, int[] r23, boolean[][] r24, boolean[][] r25, int[] r26) {
        /*
            r18 = this;
            r0 = r18
            r1 = r21
            r2 = r22
            if (r26 == 0) goto Lb
            r3 = r26
            goto Le
        Lb:
            r3 = 2
            int[] r3 = new int[r3]
        Le:
            int r4 = r0.l
            int r5 = r0.m
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r9 = 0
            r10 = 2139095039(0x7f7fffff, float:3.4028235E38)
        L18:
            int r11 = r2 + (-1)
            int r11 = r5 - r11
            r12 = 1
            if (r9 >= r11) goto L91
            r11 = 0
        L20:
            int r13 = r1 + (-1)
            int r13 = r4 - r13
            if (r11 >= r13) goto L89
            r13 = 0
        L27:
            if (r13 >= r1) goto L4a
            r14 = 0
        L2a:
            if (r14 >= r2) goto L47
            int r15 = r11 + r13
            r15 = r24[r15]
            int r16 = r9 + r14
            boolean r15 = r15[r16]
            if (r15 == 0) goto L44
            if (r25 == 0) goto L3e
            r15 = r25[r13]
            boolean r15 = r15[r14]
            if (r15 == 0) goto L44
        L3e:
            r26 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r16 = 0
            goto L86
        L44:
            int r14 = r14 + 1
            goto L2a
        L47:
            int r13 = r13 + 1
            goto L27
        L4a:
            int r13 = r11 - r19
            double r14 = (double) r13
            r26 = 2139095039(0x7f7fffff, float:3.4028235E38)
            int r6 = r9 - r20
            r17 = r8
            r16 = 0
            double r7 = (double) r6
            double r7 = java.lang.Math.hypot(r14, r7)
            float r7 = (float) r7
            float r8 = (float) r13
            float r6 = (float) r6
            int[] r13 = r0.q
            j(r8, r6, r13)
            r6 = r23[r16]
            r8 = r13[r16]
            int r14 = r6 * r8
            r15 = r23[r12]
            r13 = r13[r12]
            int r15 = r15 * r13
            int r15 = r15 + r14
            int r6 = java.lang.Float.compare(r7, r10)
            if (r6 < 0) goto L80
            int r6 = java.lang.Float.compare(r7, r10)
            r8 = r17
            if (r6 != 0) goto L86
            if (r15 <= r8) goto L86
        L80:
            r3[r16] = r11
            r3[r12] = r9
            r10 = r7
            r8 = r15
        L86:
            int r11 = r11 + 1
            goto L20
        L89:
            r26 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r16 = 0
            int r9 = r9 + 1
            goto L18
        L91:
            r26 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r16 = 0
            int r1 = (r10 > r26 ? 1 : (r10 == r26 ? 0 : -1))
            if (r1 != 0) goto L9f
            r1 = -1
            r3[r16] = r1
            r3[r12] = r1
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.CellLayout.p(int, int, int, int, int[], boolean[][], boolean[][], int[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int[] q(int r29, int r30, int r31, int r32, int r33, int r34, boolean r35, int[] r36, int[] r37) {
        /*
            Method dump skipped, instruction units count: 518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.CellLayout.q(int, int, int, int, int, int, boolean, int[], int[]):int[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0359  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.yg r(int r24, int r25, int r26, int r27, int r28, int r29, int[] r30, android.view.View r31, boolean r32, defpackage.yg r33) {
        /*
            Method dump skipped, instruction units count: 1077
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.CellLayout.r(int, int, int, int, int, int, int[], android.view.View, boolean, yg):yg");
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        for (int i = 0; i < this.l; i++) {
            for (int i2 = 0; i2 < this.m; i2++) {
                this.s[i][i2] = false;
            }
        }
        this.I.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        ng1 ng1Var = this.I;
        if (ng1Var.getChildCount() > 0) {
            for (int i = 0; i < this.l; i++) {
                for (int i2 = 0; i2 < this.m; i2++) {
                    this.s[i][i2] = false;
                }
            }
            ng1Var.removeAllViewsInLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        Objects.toString(view);
        w(view);
        this.I.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i) {
        ng1 ng1Var = this.I;
        w(ng1Var.getChildAt(i));
        ng1Var.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        Objects.toString(view);
        w(view);
        this.I.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i, int i2) {
        int i3 = i;
        while (true) {
            int i4 = i + i2;
            ng1 ng1Var = this.I;
            if (i3 >= i4) {
                ng1Var.removeViews(i, i2);
                return;
            } else {
                w(ng1Var.getChildAt(i3));
                i3++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i, int i2) {
        int i3 = i;
        while (true) {
            int i4 = i + i2;
            ng1 ng1Var = this.I;
            if (i3 >= i4) {
                ng1Var.removeViewsInLayout(i, i2);
                return;
            } else {
                w(ng1Var.getChildAt(i3));
                i3++;
            }
        }
    }

    public final float s(float f, float f2, int[] iArr) {
        C(iArr[0], iArr[1], 1, 1, this.q);
        return (float) Math.hypot(f - r6[0], f2 - r6[1]);
    }

    public void setBackgroundAlpha(float f) {
        if (this.y != f) {
            this.y = f;
            this.z.setAlpha((int) (f * 255.0f));
        }
    }

    @Override // android.view.ViewGroup
    public void setChildrenDrawingCacheEnabled(boolean z) {
        this.I.setChildrenDrawingCacheEnabled(z);
    }

    @Override // android.view.ViewGroup
    public void setChildrenDrawnWithCacheEnabled(boolean z) {
        this.I.setChildrenDrawnWithCacheEnabled(z);
    }

    public void setDropPending(boolean z) {
        this.n = z;
    }

    public void setInvertIfRtl(boolean z) {
        this.I.setInvertIfRtl(z);
    }

    public void setIsDragOverlapping(boolean z) {
        if (this.C != z) {
            this.C = z;
            TransitionDrawable transitionDrawable = this.z;
            if (z) {
                transitionDrawable.startTransition(120);
            } else if (this.y > 0.0f) {
                transitionDrawable.reverseTransition(120);
            } else {
                transitionDrawable.resetTransition();
            }
            invalidate();
        }
    }

    public void setIsHotseat(boolean z) {
        this.J = z;
        this.I.setIsHotseat(z);
    }

    public void setIsShaking(boolean z) {
        this.I.setIsShaking(z);
    }

    public void setItemPlacementDirty(boolean z) {
        this.F = z;
    }

    public void setOnInterceptTouchListener(View.OnTouchListener onTouchListener) {
        Objects.toString(onTouchListener);
        this.u = onTouchListener;
    }

    public void setShortcutAndWidgetAlpha(float f) {
        this.I.setAlpha(f);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public final void t(int i, int i2, int i3, int i4, View view, Rect rect, ArrayList arrayList) {
        Objects.toString(view);
        Objects.toString(rect);
        Objects.toString(arrayList);
        if (rect != null) {
            rect.set(i, i2, i + i3, i2 + i4);
        }
        arrayList.clear();
        Rect rect2 = new Rect(i, i2, i3 + i, i4 + i2);
        Rect rect3 = new Rect();
        ng1 ng1Var = this.I;
        int childCount = ng1Var.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = ng1Var.getChildAt(i5);
            if (childAt != view) {
                zg zgVar = (zg) childAt.getLayoutParams();
                int i6 = zgVar.a;
                int i7 = zgVar.b;
                rect3.set(i6, i7, zgVar.f + i6, zgVar.g + i7);
                if (Rect.intersects(rect2, rect3)) {
                    this.M.add(childAt);
                    if (rect != null) {
                        rect.union(rect3);
                    }
                }
            }
        }
    }

    public final boolean u(int i, int i2, int i3, int i4) {
        int i5 = (i3 + i) - 1;
        int i6 = (i4 + i2) - 1;
        if (i < 0 || i2 < 0 || i5 >= this.l || i6 >= this.m) {
            return false;
        }
        while (i <= i5) {
            for (int i7 = i2; i7 <= i6; i7++) {
                if (this.s[i][i7]) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    public final void v(View view) {
        Objects.toString(view);
        if (view == null || view.getParent() != this.I) {
            return;
        }
        zg zgVar = (zg) view.getLayoutParams();
        x(zgVar.a, zgVar.b, zgVar.f, zgVar.g, this.s, true);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Objects.toString(drawable);
        if (super.verifyDrawable(drawable)) {
            return true;
        }
        return this.o && drawable == this.z;
    }

    public final void w(View view) {
        Objects.toString(view);
        if (view == null || view.getParent() != this.I) {
            return;
        }
        zg zgVar = (zg) view.getLayoutParams();
        x(zgVar.a, zgVar.b, zgVar.f, zgVar.g, this.s, false);
    }

    public final void x(int i, int i2, int i3, int i4, boolean[][] zArr, boolean z) {
        if (i < 0 || i2 < 0) {
            return;
        }
        for (int i5 = i; i5 < i + i3 && i5 < this.l; i5++) {
            for (int i6 = i2; i6 < i2 + i4 && i6 < this.m; i6++) {
                zArr[i5][i6] = z;
            }
        }
    }

    public final void y(View view) {
        Objects.toString(view);
        if (view != null) {
            ((zg) view.getLayoutParams()).m = true;
            view.requestLayout();
            v(view);
            if (view instanceof FolderIcon) {
                ((FolderIcon) view).setVisibilityGlassBackground(true ^ this.J);
            }
            if (this.g.isShaking()) {
                if (view instanceof BubbleTextView) {
                    ((BubbleTextView) view).y();
                } else if (view instanceof pk0) {
                    ((pk0) view).c();
                }
            }
        }
    }

    public final void z(boolean z) {
        BubbleTextView bubbleTextView;
        CustomIconView customIconView;
        ng1 ng1Var = this.I;
        int childCount = ng1Var.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = ng1Var.getChildAt(i);
            if (childAt instanceof FolderIcon) {
                FolderIcon folderIcon = (FolderIcon) childAt;
                folderIcon.w = z;
                if (folderIcon.isAttachedToWindow()) {
                    folderIcon.setGlassViewVisible(z);
                } else {
                    folderIcon.post(new p40(folderIcon, z, 0));
                }
            } else if ((childAt instanceof BubbleTextView) && (customIconView = (bubbleTextView = (BubbleTextView) childAt).s) != null && customIconView.h) {
                CustomIconView iconView = bubbleTextView.getIconView();
                boolean z2 = z && iconView.h && iconView.i && iconView.isShown();
                iconView.t = z2;
                if (z2) {
                    r1 r1Var = iconView.u;
                    iconView.removeCallbacks(r1Var);
                    iconView.postDelayed(r1Var, 136L);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Objects.toString(layoutParams);
        zg zgVar = new zg(layoutParams);
        zgVar.h = true;
        zgVar.i = false;
        zgVar.j = true;
        zgVar.f = 1;
        zgVar.g = 1;
        return zgVar;
    }
}
