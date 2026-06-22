package com.luutinhit.launcher6;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.HandlerThread;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import defpackage.ar1;
import defpackage.ax;
import defpackage.ck0;
import defpackage.e51;
import defpackage.g3;
import defpackage.g61;
import defpackage.h90;
import defpackage.j40;
import defpackage.jj1;
import defpackage.k40;
import defpackage.l40;
import defpackage.l51;
import defpackage.l90;
import defpackage.lw;
import defpackage.m40;
import defpackage.mc1;
import defpackage.mw;
import defpackage.n40;
import defpackage.ng;
import defpackage.ng1;
import defpackage.np1;
import defpackage.nx;
import defpackage.nx0;
import defpackage.og1;
import defpackage.ow1;
import defpackage.ox;
import defpackage.pw;
import defpackage.q11;
import defpackage.qh0;
import defpackage.rl0;
import defpackage.v40;
import defpackage.v51;
import defpackage.w40;
import defpackage.w61;
import defpackage.xg;
import defpackage.xu;
import defpackage.xw;
import defpackage.y4;
import defpackage.yp1;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class Folder extends LinearLayout implements xw, View.OnClickListener, View.OnLongClickListener, ox, v40, TextView.OnEditorActionListener, View.OnFocusChangeListener, lw, yp1, ck0, jj1 {
    public static String f0;
    public static String g0;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public boolean E;
    public og1 F;
    public View G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public float N;
    public float O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public j40 S;
    public boolean T;
    public boolean U;
    public int V;
    public int W;
    public int a0;
    public n40 b0;
    public final mc1 c0;
    public final nx0 d0;
    public final g3 g;
    public final g3 h;
    public final g3 i;
    public final g3 j;
    public final ArrayList k;
    public final int l;
    public final InputMethodManager m;
    public final t n;
    public mw o;
    public w40 p;
    public FolderIcon q;
    public FolderPagedView r;
    public FrameLayout s;
    public l90 t;
    public h90 u;
    public float v;
    public float w;
    public final int[] x;
    public ExtendedEditText y;
    public int z;
    public static final Rect e0 = new Rect();
    public static final y4 h0 = new y4(4);

    public Folder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new g3();
        this.h = new g3();
        this.i = new g3();
        this.j = new g3();
        this.k = new ArrayList();
        this.v = 1.0f;
        this.w = 1.0f;
        this.x = new int[2];
        this.C = -1;
        this.D = false;
        this.E = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.P = false;
        this.R = false;
        this.W = -1;
        this.a0 = -1;
        this.b0 = null;
        this.c0 = new mc1(this, 11);
        this.d0 = new nx0(this, 13);
        setAlwaysDrawnWithCacheEnabled(false);
        this.m = (InputMethodManager) getContext().getSystemService("input_method");
        Resources resources = getResources();
        this.l = resources.getInteger(g61.config_folderExpandDuration);
        if (f0 == null) {
            f0 = resources.getString(w61.folder_name);
        }
        if (g0 == null) {
            g0 = resources.getString(w61.folder_hint_text);
        }
        this.n = (t) context;
        setFocusableInTouchMode(true);
    }

    private int getContentAreaHeight() {
        xu deviceProfile = this.n.getDeviceProfile();
        boolean z = this.r.t0;
        Rect rectD = deviceProfile.d();
        return Math.max(Math.min(((deviceProfile.m - rectD.top) - rectD.bottom) - this.y.getMeasuredHeight(), this.r.getDesiredWidth()), 5);
    }

    private int getContentAreaWidth() {
        return Math.max(this.r.getDesiredWidth(), 5);
    }

    private int getFolderHeight() {
        return getPaddingBottom() + getPaddingTop() + getContentAreaHeight();
    }

    private int getFolderPaddingStart() {
        try {
            return (this.n.getDeviceProfile().j - this.r.getDesiredWidth()) / 2;
        } catch (Throwable unused) {
            return getResources().getDimensionPixelSize(e51.folder_padding_start);
        }
    }

    private int getFolderPaddingTop() {
        try {
            return (((this.n.getDeviceProfile().k - this.r.getDesiredHeight()) / 2) - this.y.getMeasuredHeight()) - getResources().getDimensionPixelSize(e51.folder_name_margin_bottom);
        } catch (Throwable unused) {
            return getResources().getDimensionPixelSize(e51.folder_padding_top);
        }
    }

    public final void A() {
        if (this.p.y) {
            this.n.closeFolder();
            this.D = true;
        } else {
            if (this.C == 1) {
                this.D = true;
                return;
            }
            H();
            this.F = null;
            this.G = null;
            this.I = false;
            this.H = false;
        }
    }

    public final void B() {
        this.m.hideSoftInputFromWindow(getWindowToken(), 0);
        C();
    }

    public final void C() {
        this.y.setHint(g0);
        String string = this.y.getText().toString();
        w40 w40Var = this.p;
        w40Var.u = string;
        int i = 0;
        while (true) {
            ArrayList arrayList = w40Var.z;
            if (i >= arrayList.size()) {
                rl0.E(this.n, this.p);
                J(String.format(getContext().getString(w61.folder_renamed), string));
                this.y.clearFocus();
                Selection.setSelection(this.y.getText(), 0, 0);
                this.P = false;
                return;
            }
            ((v40) arrayList.get(i)).d(string);
            i++;
        }
    }

    public final int D(nx nxVar, float[] fArr) {
        float[] fArrA = nxVar.a(fArr);
        FolderPagedView folderPagedView = this.r;
        int paddingLeft = ((int) fArrA[0]) - getPaddingLeft();
        int paddingTop = ((int) fArrA[1]) - getPaddingTop();
        int nextPage = folderPagedView.getNextPage();
        CellLayout cellLayout = (CellLayout) folderPagedView.getChildAt(nextPage);
        int[] iArr = FolderPagedView.H0;
        cellLayout.q(paddingLeft, paddingTop, 1, 1, 1, 1, false, iArr, null);
        if (folderPagedView.D0.getLayoutDirection() == 1) {
            iArr[0] = (cellLayout.getCountX() - iArr[0]) - 1;
        }
        return Math.min(folderPagedView.A0 - 1, (iArr[1] * folderPagedView.B0) + (nextPage * folderPagedView.z0) + iArr[0]);
    }

    public final View E(og1 og1Var) {
        FolderPagedView folderPagedView = this.r;
        for (int i = 0; i < folderPagedView.getChildCount(); i++) {
            CellLayout cellLayout = (CellLayout) folderPagedView.getChildAt(i);
            for (int i2 = 0; i2 < cellLayout.getCountY(); i2++) {
                for (int i3 = 0; i3 < cellLayout.getCountX(); i3++) {
                    View viewB = cellLayout.I.b(i3, i2);
                    if (viewB != null) {
                        if (((qh0) viewB.getTag()) == og1Var) {
                            return viewB;
                        }
                    }
                }
            }
        }
        return null;
    }

    public final void F(nx nxVar) {
        if (this.j.k) {
            return;
        }
        float[] fArr = new float[2];
        int iD = D(nxVar, fArr);
        this.z = iD;
        if (iD != this.A) {
            g3 g3Var = this.g;
            g3Var.a();
            g3Var.j = this.c0;
            g3Var.b(250L);
            this.A = this.z;
            ax axVar = nxVar.m;
            if (axVar != null) {
                axVar.a(getContext().getString(w61.move_to_position, String.valueOf(this.z + 1)));
            }
        }
        float f = fArr[0];
        int nextPage = this.r.getNextPage();
        float cellWidth = this.r.getCurrentCellLayout().getCellWidth() * 0.45f;
        boolean z = f < cellWidth;
        boolean z2 = f > ((float) getWidth()) - cellWidth;
        if (nextPage > 0 && (!this.r.t0 ? !z : !z2)) {
            K(0, nxVar);
            return;
        }
        if (nextPage < this.r.getPageCount() - 1 && (!this.r.t0 ? !z2 : !z)) {
            K(1, nxVar);
            return;
        }
        this.i.a();
        if (this.W != -1) {
            FolderPagedView folderPagedView = this.r;
            if (folderPagedView.getScrollX() != folderPagedView.E(folderPagedView.getNextPage())) {
                folderPagedView.Z(folderPagedView.getNextPage());
            }
            this.W = -1;
        }
    }

    public final void G() {
        try {
            this.n.isShaking();
            this.r.getChildCount();
            this.R = true;
            for (int i = 0; i < this.r.getChildCount(); i++) {
                ((CellLayout) this.r.getChildAt(i)).getShortcutsAndWidgets().k();
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void H() {
        ArrayList<View> itemsInReadingOrder = getItemsInReadingOrder();
        this.r.k0(Math.max(-1, itemsInReadingOrder.size()), itemsInReadingOrder, true);
        this.E = true;
    }

    public final void I() {
        k40 k40Var = new k40(this, 0);
        View lastItem = this.r.getLastItem();
        if (lastItem != null) {
            FolderIcon folderIcon = this.q;
            folderIcon.getClass();
            Objects.toString(lastItem);
            Objects.toString(k40Var);
            Drawable drawableL = FolderIcon.l((BubbleTextView) lastItem);
            drawableL.getIntrinsicWidth();
            folderIcon.c(lastItem.getMeasuredWidth());
            folderIcon.b(drawableL, 200, true, k40Var);
        } else {
            k40Var.run();
        }
        this.Q = true;
    }

    public final void J(String str) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(32);
            onInitializeAccessibilityEvent(accessibilityEventObtain);
            accessibilityEventObtain.getText().add(str);
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
        }
    }

    public final void K(int i, nx nxVar) {
        if (this.W != i) {
            FolderPagedView folderPagedView = this.r;
            folderPagedView.getClass();
            int iE = (folderPagedView.E(folderPagedView.getNextPage()) + ((int) (((i == 0) ^ folderPagedView.t0 ? -0.07f : 0.07f) * folderPagedView.getWidth()))) - folderPagedView.getScrollX();
            if (iE != 0) {
                folderPagedView.t.p = new DecelerateInterpolator();
                folderPagedView.t.a(folderPagedView.getScrollX(), iE, 500);
                folderPagedView.invalidate();
            }
            this.W = i;
        }
        g3 g3Var = this.i;
        if (g3Var.k && this.a0 == i) {
            return;
        }
        this.a0 = i;
        g3Var.a();
        g3Var.j = new q11(this, nxVar, 10, false);
        g3Var.b(500L);
        this.g.a();
        this.z = this.B;
    }

    public final void L() {
        ArrayList<View> itemsInReadingOrder = getItemsInReadingOrder();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < itemsInReadingOrder.size(); i++) {
            qh0 qh0Var = (qh0) itemsInReadingOrder.get(i).getTag();
            qh0Var.q = i;
            arrayList.add(qh0Var);
        }
        long j = this.p.g;
        HandlerThread handlerThread = rl0.w;
        t tVar = this.n;
        Objects.toString(tVar);
        Objects.toString(arrayList);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            qh0 qh0Var2 = (qh0) arrayList.get(i2);
            qh0Var2.i = j;
            qh0Var2.j = 0;
            ContentValues contentValues = new ContentValues();
            contentValues.put("container", Long.valueOf(qh0Var2.i));
            contentValues.put("cellX", Integer.valueOf(qh0Var2.k));
            contentValues.put("cellY", Integer.valueOf(qh0Var2.l));
            contentValues.put("rank", Integer.valueOf(qh0Var2.q));
            contentValues.put("screen", Long.valueOf(qh0Var2.j));
            arrayList2.add(contentValues);
        }
        Objects.toString(tVar);
        Objects.toString(arrayList2);
        Objects.toString(arrayList);
        rl0.y(new ng(arrayList, arrayList2, new Throwable().getStackTrace(), tVar.getContentResolver(), 6, false));
    }

    public final void M() {
        View firstItem = this.r.getFirstItem();
        View lastItem = this.r.getLastItem();
        if (firstItem == null || lastItem == null) {
            return;
        }
        this.y.setNextFocusDownId(lastItem.getId());
        this.y.setNextFocusRightId(lastItem.getId());
        this.y.setNextFocusLeftId(lastItem.getId());
        this.y.setNextFocusUpId(lastItem.getId());
        this.y.setNextFocusForwardId(firstItem.getId());
        setNextFocusDownId(firstItem.getId());
        setNextFocusRightId(firstItem.getId());
        setNextFocusLeftId(firstItem.getId());
        setNextFocusUpId(firstItem.getId());
        setOnKeyListener(new l40(this, lastItem));
    }

    @Override // defpackage.ck0
    public final void a(xg xgVar, boolean z) {
        w(xgVar.a, true);
    }

    @Override // defpackage.ox
    public final boolean b() {
        return true;
    }

    @Override // defpackage.ox
    public final void c(Rect rect) {
        getHitRect(rect);
        int i = rect.left;
        int i2 = this.V;
        rect.left = i - i2;
        rect.right += i2;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    @Override // defpackage.v40
    public final void e(og1 og1Var) {
        if (this.I) {
            return;
        }
        FolderPagedView folderPagedView = this.r;
        folderPagedView.i0(folderPagedView.m0(og1Var), og1Var, folderPagedView.j0());
        this.E = true;
        rl0.c(this.n, og1Var, this.p.g, 0L, og1Var.k, og1Var.l);
    }

    @Override // defpackage.ox
    public final void f() {
        g3 g3Var = this.g;
        if (g3Var.k) {
            g3Var.a();
            this.c0.p(g3Var);
        }
    }

    @Override // defpackage.yp1
    public final void g() {
        this.T = true;
    }

    public ViewGroup getContent() {
        return this.r;
    }

    public View getEditTextRegion() {
        return this.y;
    }

    public w40 getInfo() {
        return this.p;
    }

    @Override // defpackage.xw
    public float getIntrinsicIconScaleFactor() {
        return 1.0f;
    }

    public int getItemCount() {
        return this.r.getItemCount();
    }

    public ArrayList<View> getItemsInReadingOrder() {
        boolean z = this.E;
        ArrayList<View> arrayList = this.k;
        if (z) {
            arrayList.clear();
            FolderPagedView folderPagedView = this.r;
            for (int i = 0; i < folderPagedView.getChildCount(); i++) {
                CellLayout cellLayout = (CellLayout) folderPagedView.getChildAt(i);
                for (int i2 = 0; i2 < cellLayout.getCountY(); i2++) {
                    for (int i3 = 0; i3 < cellLayout.getCountX(); i3++) {
                        View viewB = cellLayout.I.b(i3, i2);
                        if (viewB != null) {
                            arrayList.add(viewB);
                        }
                    }
                }
            }
            this.E = false;
        }
        return arrayList;
    }

    public float getPivotXForIconAnimation() {
        return this.N;
    }

    public float getPivotYForIconAnimation() {
        return this.O;
    }

    @Override // defpackage.ck0
    public final void h(boolean z) {
        for (int i = 0; i < this.r.getChildCount(); i++) {
            ((CellLayout) this.r.getChildAt(i)).n(1, z);
        }
        this.n.getWorkspace().setAddNewPageOnDrag(!z);
    }

    @Override // defpackage.xw
    public final boolean i() {
        return false;
    }

    @Override // defpackage.ox
    public final void j(nx nxVar) {
        this.A = -1;
        this.h.a();
        this.V = (nxVar.f.getDragRegionWidth() / 2) - nxVar.c;
    }

    @Override // defpackage.v40
    public final void k(og1 og1Var) {
        this.E = true;
        if (og1Var == this.F) {
            return;
        }
        View viewE = E(og1Var);
        viewE.clearAnimation();
        FolderPagedView folderPagedView = this.r;
        for (int childCount = folderPagedView.getChildCount() - 1; childCount >= 0; childCount--) {
            ((CellLayout) folderPagedView.getChildAt(childCount)).removeView(viewE);
        }
        if (this.C == 1) {
            this.D = true;
        } else {
            H();
        }
        if (getItemCount() <= 1) {
            if (this.p.y) {
                this.n.closeFolder(this, true);
            } else {
                I();
            }
        }
    }

    @Override // defpackage.xw
    public final void l(View view, nx nxVar, boolean z) {
        if (this.T) {
            this.S = new j40(this, view, nxVar, z, 0);
            return;
        }
        boolean z2 = z && (!(this.S != null) || this.U);
        if (!z2) {
            og1 og1Var = (og1) nxVar.g;
            View view2 = this.G;
            View viewM0 = (view2 == null || view2.getTag() != og1Var) ? this.r.m0(og1Var) : this.G;
            ArrayList<View> itemsInReadingOrder = getItemsInReadingOrder();
            itemsInReadingOrder.add(og1Var.q, viewM0);
            this.r.k0(itemsInReadingOrder.size(), itemsInReadingOrder, true);
            this.E = true;
            this.I = true;
            this.q.m(nxVar);
            this.I = false;
        } else if (this.K && !this.M && view != this) {
            I();
        }
        if (view != this) {
            g3 g3Var = this.h;
            if (g3Var.k) {
                g3Var.a();
                if (!z2) {
                    this.L = true;
                }
                this.j.a();
                A();
            }
        }
        this.K = false;
        this.J = false;
        this.M = false;
        this.F = null;
        this.G = null;
        this.I = false;
        L();
        if (getItemCount() <= this.r.z0) {
            this.p.h(this.n, 4, false);
        }
    }

    @Override // defpackage.xw
    public final boolean m() {
        return true;
    }

    @Override // defpackage.v40
    public final void n() {
        M();
    }

    @Override // defpackage.yp1
    public final void o(boolean z) {
        this.T = false;
        this.U = z;
        j40 j40Var = this.S;
        if (j40Var != null) {
            j40Var.run();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.n.isUseLiquidGlass) {
            this.r.getDesiredWidth();
            this.r.getDesiredHeight();
            t tVar = this.n;
            if (tVar.isUseLiquidGlass) {
                if (tVar.isRuntimeRenderSupport) {
                    h90 h90Var = new h90(tVar, true);
                    this.u = h90Var;
                    h90Var.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
                    this.u.setFullBitmap(this.n.getBlurWallpaperProvider().e);
                    this.u.setSdfTexture(l51.scale);
                    this.s.addView(this.u, 0);
                    return;
                }
                l90 l90Var = new l90(this.n);
                this.t = l90Var;
                l90Var.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
                l90 l90Var2 = this.t;
                int i = this.n.screenWidth;
                l90Var2.x = r1.screenHeight;
                this.t.k(this.q.getBlurGlassWallpaper());
                this.t.setSdfTexture(l51.scale);
                this.s.addView(this.t, 0);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof og1) {
            this.n.onClick(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h90 h90Var = this.u;
        if (h90Var != null) {
            h90Var.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
            this.s.removeView(this.t);
            this.t = null;
        }
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        B();
        return true;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.s = (FrameLayout) findViewById(v51.folder_content_wrapper);
        FolderPagedView folderPagedView = (FolderPagedView) findViewById(v51.folder_content);
        this.r = folderPagedView;
        folderPagedView.setFolder(this);
        xu deviceProfile = this.n.getDeviceProfile();
        FolderPagedView folderPagedView2 = this.r;
        int i = deviceProfile.C;
        folderPagedView2.setPadding(i, deviceProfile.M, i, i * 2);
        ExtendedEditText extendedEditText = (ExtendedEditText) findViewById(v51.folder_name);
        this.y = extendedEditText;
        extendedEditText.setOnBackKeyListener(new ow1(this, 14));
        this.y.setOnFocusChangeListener(this);
        if (!ar1.i) {
            this.y.setCustomSelectionActionModeCallback(new m40());
        }
        this.y.setOnEditorActionListener(this);
        this.y.setSelectAllOnFocus(true);
        ExtendedEditText extendedEditText2 = this.y;
        extendedEditText2.setInputType(extendedEditText2.getInputType() | 532480);
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        ExtendedEditText extendedEditText = this.y;
        if (view == extendedEditText) {
            if (!z) {
                B();
            } else {
                extendedEditText.setHint("");
                this.P = true;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        t tVar = this.n;
        if (!tVar.isShaking() && !tVar.showingFloatingMenu && (view instanceof BubbleTextView)) {
            tVar.vibrate();
            tVar.openFloatingMenu(view);
            return true;
        }
        tVar.closeFloatingMenu();
        if (tVar.isShaking()) {
            view.clearAnimation();
            return !tVar.isDraggingEnabled() || w(view, false);
        }
        tVar.onShakingAllApps();
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Objects.toString(motionEvent);
        return true;
    }

    @Override // defpackage.ox
    public final boolean p(nx nxVar) {
        int i = ((qh0) nxVar.g).h;
        if (i != 0 && i != 1) {
            return false;
        }
        this.r.getClass();
        return true;
    }

    @Override // defpackage.ox
    public final void q(nx nxVar) {
        F(nxVar);
    }

    @Override // defpackage.ox
    public final void r(nx nxVar) {
        if (!nxVar.e) {
            nx0 nx0Var = this.d0;
            g3 g3Var = this.h;
            g3Var.j = nx0Var;
            g3Var.b(400L);
        }
        this.g.a();
        this.i.a();
        this.j.a();
        if (this.W != -1) {
            FolderPagedView folderPagedView = this.r;
            if (folderPagedView.getScrollX() != folderPagedView.E(folderPagedView.getNextPage())) {
                folderPagedView.Z(folderPagedView.getNextPage());
            }
            this.W = -1;
        }
    }

    public void setDragController(mw mwVar) {
        this.o = mwVar;
    }

    public void setFolderBackgroundBitmap(Bitmap bitmap) {
    }

    public void setFolderBackgroundResource(int i) {
        this.s.setBackgroundResource(i);
    }

    public void setFolderIcon(FolderIcon folderIcon) {
        this.q = folderIcon;
    }

    @Override // defpackage.lw
    public final void t() {
        if (this.H && this.J) {
            A();
        }
        this.o.m.remove(this);
    }

    @Override // defpackage.jj1
    public final void u(View view, Bundle bundle) {
        np1.D(this.q, bundle);
        bundle.putString("sub_container", "folder");
        bundle.putInt("sub_container_page", this.r.getCurrentPage());
    }

    @Override // defpackage.ox
    public final void v(nx nxVar) {
        View viewM0;
        xw xwVar = nxVar.h;
        t tVar = this.n;
        k40 k40Var = (xwVar == tVar.getWorkspace() || (nxVar.h instanceof Folder)) ? null : new k40(this, 1);
        FolderPagedView folderPagedView = this.r;
        if (this.B / folderPagedView.z0 != folderPagedView.getNextPage()) {
            this.z = D(nxVar, null);
            this.c0.p(this.g);
            this.i.a();
            this.j.a();
        }
        this.r.l0();
        og1 og1Var = this.F;
        if (this.H) {
            FolderPagedView folderPagedView2 = this.r;
            int i = this.B;
            viewM0 = folderPagedView2.m0(og1Var);
            folderPagedView2.i0(viewM0, og1Var, i);
            rl0.c(this.n, og1Var, this.p.g, 0L, og1Var.k, og1Var.l);
            if (nxVar.h != this) {
                L();
            }
            this.H = false;
        } else {
            viewM0 = this.G;
            this.r.i0(viewM0, og1Var, this.B);
        }
        if (nxVar.f.n) {
            float scaleX = getScaleX();
            float scaleY = getScaleY();
            setScaleX(1.0f);
            setScaleY(1.0f);
            tVar.getDragLayer().animateViewIntoPosition(nxVar.f, viewM0, k40Var, null);
            setScaleX(scaleX);
            setScaleY(scaleY);
        } else {
            nxVar.l = false;
            viewM0.setVisibility(0);
        }
        this.E = true;
        H();
        this.I = true;
        this.p.f(og1Var);
        this.I = false;
        this.F = null;
        this.J = false;
        if (this.r.getPageCount() > 1) {
            this.p.h(tVar, 4, true);
        }
    }

    public final boolean w(View view, boolean z) {
        try {
            Object tag = view.getTag();
            if (tag instanceof og1) {
                og1 og1Var = (og1) tag;
                if (!view.isInTouchMode()) {
                    return false;
                }
                this.n.getWorkspace().m0(view, new Point(), this, z);
                this.F = og1Var;
                this.B = og1Var.q;
                this.G = view;
                FolderPagedView folderPagedView = this.r;
                for (int childCount = folderPagedView.getChildCount() - 1; childCount >= 0; childCount--) {
                    ((CellLayout) folderPagedView.getChildAt(childCount)).removeView(view);
                }
                this.p.g(this.F);
                this.J = true;
                this.M = false;
                return true;
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return true;
    }

    public final void x() {
        pw pwVar = (pw) getLayoutParams();
        int desiredWidth = this.r.getDesiredWidth() + getPaddingRight() + getPaddingLeft();
        int dimensionPixelSize = getResources().getDimensionPixelSize(e51.folder_name_margin_bottom) + this.y.getMeasuredHeight() + this.r.getDesiredHeight() + getPaddingBottom() + getPaddingTop();
        int i = v51.drag_layer;
        t tVar = this.n;
        DragLayer dragLayer = (DragLayer) tVar.findViewById(i);
        FolderIcon folderIcon = this.q;
        Rect rect = e0;
        float descendantRectRelativeToSelf = dragLayer.getDescendantRectRelativeToSelf(folderIcon, rect);
        int iWidth = (int) (((rect.width() * descendantRectRelativeToSelf) / 2.0f) + rect.left);
        int i2 = desiredWidth / 2;
        int i3 = iWidth - i2;
        int i4 = dimensionPixelSize / 2;
        int iHeight = ((int) (((rect.height() * descendantRectRelativeToSelf) / 2.0f) + rect.top)) - i4;
        Workspace workspace = tVar.getWorkspace();
        workspace.getClass();
        Objects.toString(rect);
        CellLayout cellLayout = (CellLayout) workspace.getChildAt(workspace.getNextPage());
        if (cellLayout != null) {
            ng1 shortcutsAndWidgets = cellLayout.getShortcutsAndWidgets();
            int left = shortcutsAndWidgets.getLeft() + workspace.getPaddingLeft() + workspace.getViewportOffsetX();
            int[] iArr = workspace.j1;
            iArr[0] = left;
            iArr[1] = shortcutsAndWidgets.getTop() + cellLayout.getTop();
            float descendantCoordRelativeToSelf = workspace.S0.getDragLayer().getDescendantCoordRelativeToSelf(workspace, iArr);
            int i5 = iArr[0];
            rect.set(i5, iArr[1], (int) ((shortcutsAndWidgets.getMeasuredWidth() * descendantCoordRelativeToSelf) + i5), (int) ((descendantCoordRelativeToSelf * shortcutsAndWidgets.getMeasuredHeight()) + iArr[1]));
        }
        int folderPaddingStart = getFolderPaddingStart();
        int folderPaddingTop = getFolderPaddingTop();
        setPivotX((i3 - folderPaddingStart) + i2);
        setPivotY((iHeight - folderPaddingTop) + i4);
        this.N = (int) (((r6 * 1.0f) / desiredWidth) * this.q.getMeasuredWidth());
        this.O = (int) (((r4 * 1.0f) / dimensionPixelSize) * this.q.getMeasuredHeight());
        ((FrameLayout.LayoutParams) pwVar).width = desiredWidth;
        ((FrameLayout.LayoutParams) pwVar).height = dimensionPixelSize;
        pwVar.b = folderPaddingStart;
        pwVar.c = folderPaddingTop;
    }

    public final void y() {
        if (this.n == null || !this.R) {
            return;
        }
        try {
            this.r.getChildCount();
            for (int i = 0; i < this.r.getChildCount(); i++) {
                ((CellLayout) this.r.getChildAt(i)).getShortcutsAndWidgets().a();
            }
            this.R = false;
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void z(boolean z) {
        y();
        DragLayer dragLayer = (DragLayer) getParent();
        if (dragLayer != null) {
            dragLayer.removeView(this);
        }
        this.o.l.remove(this);
        clearFocus();
        if (z) {
            this.q.requestFocus();
        }
        if (this.D) {
            H();
            this.D = false;
        }
        if (getItemCount() <= 1) {
            boolean z2 = this.J;
            if (!z2 && !this.L) {
                I();
            } else if (z2) {
                this.K = true;
            }
        }
        this.L = false;
        this.F = null;
        this.G = null;
        this.I = false;
        this.H = false;
        this.C = 0;
    }

    @Override // defpackage.v40
    public final void d(String str) {
    }

    @Override // defpackage.lw
    public final void s(xw xwVar, Object obj) {
    }
}
