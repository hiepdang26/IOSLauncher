package com.luutinhit.launcher6.allapps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.appcompat.widget.RtlSpacingHelper;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.ExtendedEditText;
import com.luutinhit.launcher6.t;
import defpackage.ar1;
import defpackage.b91;
import defpackage.c4;
import defpackage.d4;
import defpackage.dl;
import defpackage.e51;
import defpackage.iy;
import defpackage.k4;
import defpackage.kb0;
import defpackage.lb0;
import defpackage.m4;
import defpackage.m61;
import defpackage.mb0;
import defpackage.t3;
import defpackage.v3;
import defpackage.v51;
import defpackage.v6;
import defpackage.xu;
import defpackage.xw;
import defpackage.ya;
import defpackage.z3;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AllAppsContainerView extends ya implements xw, View.OnTouchListener, View.OnLongClickListener {
    public final int A;
    public final Point B;
    public final Point C;
    public final t n;
    public final m4 o;
    public final c4 p;
    public final AllAppsGridAdapter$AppsGridLayoutManager q;
    public final z3 r;
    public final Rect s;
    public AllAppsRecyclerView t;
    public View u;
    public ExtendedEditText v;
    public mb0 w;
    public final int x;
    public int y;
    public int z;

    public AllAppsContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = new Rect();
        this.B = new Point(-1, -1);
        this.C = new Point();
        Resources resources = context.getResources();
        t tVar = (t) context;
        this.n = tVar;
        this.x = resources.getDimensionPixelSize(e51.all_apps_grid_view_start_margin);
        m4 m4Var = new m4(context);
        this.o = m4Var;
        c4 c4Var = new c4(tVar, m4Var, this, tVar, this);
        this.p = c4Var;
        m4Var.k = c4Var;
        this.q = c4Var.m;
        this.r = c4Var.n;
        this.A = resources.getDimensionPixelSize(e51.all_apps_list_top_bottom_padding);
        Selection.setSelection(new SpannableStringBuilder(), 0);
    }

    public final boolean b(MotionEvent motionEvent) {
        xu deviceProfile = this.n.getDeviceProfile();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        Point point = this.B;
        if (action != 0) {
            if (action != 1) {
                if (action == 3) {
                }
            } else if (point.x > -1) {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
                if (((float) Math.hypot(motionEvent.getX() - point.x, motionEvent.getY() - point.y)) < viewConfiguration.getScaledTouchSlop()) {
                    ((t) getContext()).showWorkspace(true);
                    return true;
                }
            }
            point.set(-1, -1);
        } else {
            Rect rect = this.s;
            if (!rect.isEmpty()) {
                new Rect(rect).inset((-deviceProfile.X) / 2, 0);
                if (motionEvent.getX() < r7.left || motionEvent.getX() > r7.right) {
                    point.set(x, y);
                    return true;
                }
            } else if (motionEvent.getX() < getPaddingLeft() || motionEvent.getX() > getWidth() - getPaddingRight()) {
                point.set(x, y);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        throw null;
    }

    @Override // defpackage.xw
    public float getIntrinsicIconScaleFactor() {
        xu deviceProfile = this.n.getDeviceProfile();
        return deviceProfile.X / deviceProfile.D;
    }

    @Override // defpackage.xw
    public final boolean i() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    @Override // defpackage.xw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(android.view.View r6, defpackage.nx r7, boolean r8) {
        /*
            r5 = this;
            r0 = 0
            r1 = 1
            com.luutinhit.launcher6.t r2 = r5.n
            if (r8 == 0) goto L14
            com.luutinhit.launcher6.Workspace r3 = r2.getWorkspace()
            if (r6 == r3) goto L19
            boolean r3 = r6 instanceof com.luutinhit.launcher6.DeleteDropTarget
            if (r3 != 0) goto L19
            boolean r3 = r6 instanceof com.luutinhit.launcher6.Folder
            if (r3 != 0) goto L19
        L14:
            r3 = 300(0x12c, float:4.2E-43)
            r2.exitSpringLoadedDragModeDelayed(r1, r3, r0)
        L19:
            r3 = 0
            r2.unlockScreenOrientation(r3)
            if (r8 != 0) goto L47
            boolean r8 = r6 instanceof com.luutinhit.launcher6.Workspace
            if (r8 == 0) goto L3f
            int r8 = r2.getCurrentWorkspaceScreen()
            com.luutinhit.launcher6.Workspace r6 = (com.luutinhit.launcher6.Workspace) r6
            android.view.View r6 = r6.getChildAt(r8)
            com.luutinhit.launcher6.CellLayout r6 = (com.luutinhit.launcher6.CellLayout) r6
            java.lang.Object r8 = r7.g
            qh0 r8 = (defpackage.qh0) r8
            if (r6 == 0) goto L3f
            int r4 = r8.m
            int r8 = r8.n
            boolean r6 = r6.o(r0, r4, r8)
            r6 = r6 ^ r1
            goto L40
        L3f:
            r6 = 0
        L40:
            if (r6 == 0) goto L45
            r2.showOutOfSpaceMessage(r3)
        L45:
            r7.l = r3
        L47:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.allapps.AllAppsContainerView.l(android.view.View, nx, boolean):void");
    }

    @Override // defpackage.xw
    public final boolean m() {
        return false;
    }

    @Override // defpackage.ya, android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        getContentView().setOnFocusChangeListener(new v3(this, 0));
        this.u = findViewById(v51.search_container);
        this.v = (ExtendedEditText) findViewById(v51.search_box_input);
        this.w = ar1.m ? new lb0(this.u) : new kb0(this.u);
        AllAppsRecyclerView allAppsRecyclerView = (AllAppsRecyclerView) findViewById(v51.apps_list_view);
        this.t = allAppsRecyclerView;
        allAppsRecyclerView.setApps(this.o);
        this.t.setLayoutManager(this.q);
        this.t.setAdapter(this.p);
        this.t.setHasFixedSize(true);
        this.t.l(this.w);
        this.t.setElevationController(this.w);
        z3 z3Var = this.r;
        if (z3Var != null) {
            this.t.k(z3Var);
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, RtlSpacingHelper.UNDEFINED);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, RtlSpacingHelper.UNDEFINED);
        BubbleTextView bubbleTextView = (BubbleTextView) layoutInflaterFrom.inflate(m61.all_apps_icon, (ViewGroup) this, false);
        bubbleTextView.getClass();
        bubbleTextView.x(bubbleTextView.g.resizeIconDrawable(new ColorDrawable()), bubbleTextView.n);
        bubbleTextView.setText("");
        bubbleTextView.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        BubbleTextView bubbleTextView2 = (BubbleTextView) layoutInflaterFrom.inflate(m61.all_apps_prediction_bar_icon, (ViewGroup) this, false);
        bubbleTextView2.getClass();
        bubbleTextView2.x(bubbleTextView2.g.resizeIconDrawable(new ColorDrawable()), bubbleTextView2.n);
        bubbleTextView2.setText("");
        bubbleTextView2.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        AllAppsRecyclerView allAppsRecyclerView2 = this.t;
        int measuredHeight = bubbleTextView2.getMeasuredHeight();
        int measuredHeight2 = bubbleTextView.getMeasuredHeight();
        allAppsRecyclerView2.b1 = measuredHeight;
        allAppsRecyclerView2.c1 = measuredHeight2;
        a();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return b(motionEvent);
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (!view.isInTouchMode()) {
            return false;
        }
        t tVar = this.n;
        if (tVar.isAppsViewVisible()) {
            tVar.getWorkspace().getClass();
            if (!tVar.isDraggingEnabled()) {
                return false;
            }
            tVar.getWorkspace().m0(view, this.C, this, false);
            tVar.enterSpringLoadedDragMode();
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        k4 iyVar;
        Rect rect = this.h;
        int i3 = rect.left;
        int i4 = rect.top;
        int size = View.MeasureSpec.getSize(i) - rect.right;
        int size2 = View.MeasureSpec.getSize(i2) - rect.bottom;
        Rect rect2 = this.s;
        rect2.set(i3, i4, size, size2);
        int iWidth = (!rect2.isEmpty() ? rect2.width() : View.MeasureSpec.getSize(i)) - (this.t.getMaxScrollbarWidth() * 2);
        xu deviceProfile = this.n.getDeviceProfile();
        Resources resources = getResources();
        deviceProfile.getClass();
        int dimensionPixelSize = resources.getDimensionPixelSize(e51.all_apps_grid_view_start_margin);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(e51.all_apps_icon_width_gap);
        int i5 = ((iWidth > 0 ? iWidth : deviceProfile.l) + dimensionPixelSize2) - dimensionPixelSize;
        int i6 = deviceProfile.X;
        int i7 = i5 / (dimensionPixelSize2 + i6);
        int iMax = Math.max(deviceProfile.a.n, i7);
        if (this.y != i7 || this.z != iMax) {
            this.y = i7;
            this.z = iMax;
            if (this.x == 0 || !deviceProfile.d) {
                iyVar = new iy();
            } else {
                int iCeil = (int) Math.ceil(i7 / 2.0f);
                t3 t3Var = new t3();
                t3Var.g = iCeil;
                t3Var.h = Charset.forName("US-ASCII").newEncoder();
                iyVar = t3Var;
            }
            AllAppsRecyclerView allAppsRecyclerView = this.t;
            allAppsRecyclerView.a1 = this.y;
            b91 recycledViewPool = allAppsRecyclerView.getRecycledViewPool();
            int iCeil2 = (int) Math.ceil(deviceProfile.m / i6);
            recycledViewPool.b(3, 1);
            recycledViewPool.b(4, 1);
            recycledViewPool.b(5, 1);
            recycledViewPool.b(1, allAppsRecyclerView.a1 * iCeil2);
            recycledViewPool.b(2, allAppsRecyclerView.a1);
            recycledViewPool.b(0, iCeil2);
            int i8 = this.y;
            c4 c4Var = this.p;
            c4Var.y = i8;
            c4Var.m.r1(i8);
            int i9 = this.y;
            int i10 = this.z;
            m4 m4Var = this.o;
            m4Var.o = i9;
            m4Var.p = i10;
            m4Var.n = iyVar;
            m4Var.c();
            int i11 = this.y;
            if (i11 > 0) {
                int i12 = ((iWidth / i11) - i6) / 2;
                this.v.setPaddingRelative(i12, 0, i12, 0);
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && action != 2) {
            return false;
        }
        this.C.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return b(motionEvent);
    }

    public void setApps(List<v6> list) {
        m4 m4Var = this.o;
        HashMap map = m4Var.c;
        map.clear();
        for (v6 v6Var : list) {
            map.put(new dl(v6Var.A, v6Var.w), v6Var);
        }
        m4Var.b();
    }

    public void setPredictedApps(List<dl> list) {
        m4 m4Var = this.o;
        ArrayList arrayList = m4Var.h;
        arrayList.clear();
        arrayList.addAll(list);
        m4Var.b();
    }

    public void setSearchBarController(d4 d4Var) {
        Object obj = null;
        obj.getClass();
        throw new RuntimeException("Expected search bar controller to only be set once");
    }
}
