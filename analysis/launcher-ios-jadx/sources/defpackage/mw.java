package defpackage;

import android.animation.ValueAnimator;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.DeleteDropTarget;
import com.luutinhit.launcher6.DragLayer;
import com.luutinhit.launcher6.Workspace;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class mw {
    public VelocityTracker A;
    public final t a;
    public final Handler b;
    public final boolean e;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    public final int j;
    public nx k;
    public IBinder n;
    public View o;
    public View p;
    public ww q;
    public ox t;
    public InputMethodManager u;
    public final Rect c = new Rect();
    public final int[] d = new int[2];
    public final ArrayList l = new ArrayList();
    public final ArrayList m = new ArrayList();
    public int r = 0;
    public final yf s = new yf(this);
    public final int[] v = new int[2];
    public long w = -1;
    public int x = 0;
    public final int[] y = new int[2];
    public final Rect z = new Rect();

    public mw(t tVar) {
        Resources resources = tVar.getResources();
        this.a = tVar;
        this.b = new Handler();
        this.j = resources.getDimensionPixelSize(e51.scroll_zone);
        this.A = VelocityTracker.obtain();
        float f = resources.getDisplayMetrics().density;
        resources.getInteger(g61.config_flingToDeleteMinVelocity);
        this.e = ar1.v(resources);
    }

    public final void a() {
        if (this.f) {
            ox oxVar = this.t;
            if (oxVar != null) {
                oxVar.r(this.k);
            }
            nx nxVar = this.k;
            nxVar.l = false;
            nxVar.k = true;
            nxVar.e = true;
            nxVar.h.l(null, nxVar, false);
        }
        f();
    }

    public final void b(int i, int i2) {
        t tVar = this.a;
        int i3 = this.x < ViewConfiguration.get(tVar).getScaledWindowTouchSlop() ? 900 : 500;
        DragLayer dragLayer = tVar.getDragLayer();
        boolean z = this.e;
        int i4 = !z ? 1 : 0;
        Handler handler = this.b;
        yf yfVar = this.s;
        int i5 = this.j;
        if (i < i5) {
            if (this.r == 0) {
                this.r = 1;
                if (((Workspace) this.q).S0(i, i2, z ? 1 : 0)) {
                    dragLayer.onEnterScrollArea(z ? 1 : 0);
                    yfVar.h = z ? 1 : 0;
                    handler.postDelayed(yfVar, i3);
                    return;
                }
                return;
            }
            return;
        }
        if (i <= this.o.getWidth() - i5) {
            d();
            return;
        }
        if (this.r == 0) {
            this.r = 1;
            if (((Workspace) this.q).S0(i, i2, i4)) {
                dragLayer.onEnterScrollArea(i4);
                yfVar.h = i4;
                handler.postDelayed(yfVar, i3);
            }
        }
    }

    public final void c(ox oxVar) {
        if (oxVar != null) {
            ox oxVar2 = this.t;
            if (oxVar2 != oxVar) {
                if (oxVar2 != null) {
                    oxVar2.r(this.k);
                }
                oxVar.j(this.k);
            }
            oxVar.q(this.k);
        } else {
            ox oxVar3 = this.t;
            if (oxVar3 != null) {
                oxVar3.r(this.k);
            }
        }
        this.t = oxVar;
    }

    public final void d() {
        Handler handler = this.b;
        yf yfVar = this.s;
        handler.removeCallbacks(yfVar);
        if (this.r == 1) {
            this.r = 0;
            yfVar.h = 1;
            Workspace workspace = (Workspace) this.q;
            if (workspace.i1) {
                workspace.invalidate();
                CellLayout currentDropLayout = workspace.getCurrentDropLayout();
                workspace.setCurrentDropLayout(currentDropLayout);
                workspace.setCurrentDragOverlappingLayout(currentDropLayout);
                workspace.i1 = false;
            }
            this.a.getDragLayer().onExitScrollArea();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(float f, float f2) {
        int[] iArr = this.d;
        ox oxVarG = g(iArr, (int) f, (int) f2);
        nx nxVar = this.k;
        boolean z = false;
        nxVar.a = iArr[0];
        nxVar.b = iArr[1];
        if (oxVarG != 0) {
            nxVar.e = true;
            oxVarG.r(nxVar);
            if (oxVarG.p(this.k)) {
                oxVarG.v(this.k);
                z = true;
            }
        }
        nx nxVar2 = this.k;
        nxVar2.h.l((View) oxVarG, nxVar2, z);
    }

    public final void f() {
        boolean z;
        if (this.f) {
            int i = 0;
            this.f = false;
            this.g = false;
            d();
            nx nxVar = this.k;
            zw zwVar = nxVar.f;
            if (zwVar != null) {
                z = nxVar.l;
                if (!z && zwVar.getParent() != null) {
                    zwVar.m.removeView(zwVar);
                }
                this.k.f = null;
            } else {
                z = false;
            }
            if (!z) {
                ArrayList arrayList = new ArrayList(this.m);
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((lw) obj).t();
                }
            }
        }
        VelocityTracker velocityTracker = this.A;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.A = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ox g(int[] iArr, int i, int i2) {
        ArrayList arrayList = this.l;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ox oxVar = (ox) arrayList.get(size);
            if (oxVar.b()) {
                Rect rect = this.c;
                oxVar.c(rect);
                nx nxVar = this.k;
                nxVar.a = i;
                nxVar.b = i2;
                if (rect.contains(i, i2)) {
                    iArr[0] = i;
                    iArr[1] = i2;
                    this.a.getDragLayer().mapCoordInSelfToDescendent((View) oxVar, iArr);
                    return oxVar;
                }
            }
        }
        return null;
    }

    public final int[] h(float f, float f2) {
        this.a.getDragLayer().getLocalVisibleRect(this.z);
        int iMax = (int) Math.max(r1.left, Math.min(f, r1.right - 1));
        int[] iArr = this.y;
        iArr[0] = iMax;
        iArr[1] = (int) Math.max(r1.top, Math.min(f2, r1.bottom - 1));
        return iArr;
    }

    public final void i(int i, int i2) {
        zw zwVar = this.k.f;
        zwVar.setTranslationX((i - zwVar.i) + ((int) zwVar.p));
        zwVar.setTranslationY((i2 - zwVar.j) + ((int) zwVar.q));
        int[] iArr = this.d;
        ox oxVarG = g(iArr, i, i2);
        nx nxVar = this.k;
        nxVar.a = iArr[0];
        nxVar.b = iArr[1];
        c(oxVarG);
        double d = this.x;
        int[] iArr2 = this.v;
        this.x = (int) (Math.hypot(iArr2[0] - i, iArr2[1] - i2) + d);
        iArr2[0] = i;
        iArr2[1] = i2;
        b(i, i2);
    }

    public final void j(HashSet hashSet, HashSet hashSet2) {
        ComponentName component;
        nx nxVar = this.k;
        if (nxVar != null) {
            Object obj = nxVar.g;
            if (obj instanceof og1) {
                og1 og1Var = (og1) obj;
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    ComponentName componentName = (ComponentName) it.next();
                    Intent intent = og1Var.x;
                    if (intent != null && (component = intent.getComponent()) != null && (component.equals(componentName) || hashSet.contains(component.getPackageName()))) {
                        a();
                        return;
                    }
                }
            }
        }
    }

    public final boolean k(MotionEvent motionEvent) {
        if (this.g) {
            return false;
        }
        if (this.A == null) {
            this.A = VelocityTracker.obtain();
        }
        this.A.addMovement(motionEvent);
        int action = motionEvent.getAction();
        int[] iArrH = h(motionEvent.getX(), motionEvent.getY());
        int i = iArrH[0];
        int i2 = iArrH[1];
        if (action == 0) {
            this.h = i;
            this.i = i2;
            this.t = null;
        } else if (action == 1) {
            this.w = System.currentTimeMillis();
            if (this.f) {
                nx nxVar = this.k;
                xw xwVar = nxVar.h;
                DeleteDropTarget.w(nxVar.g);
                e(i, i2);
            }
            f();
        } else if (action == 3) {
            a();
        }
        return this.f;
    }

    public final zw l(Bitmap bitmap, int i, int i2, xw xwVar, Object obj, int i3, Point point, Rect rect, float f, boolean z) {
        InputMethodManager inputMethodManager = this.u;
        t tVar = this.a;
        if (inputMethodManager == null) {
            this.u = (InputMethodManager) tVar.getSystemService("input_method");
        }
        this.u.hideSoftInputFromWindow(this.n, 0);
        ArrayList arrayList = this.m;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj2 = arrayList.get(i4);
            i4++;
            ((lw) obj2).s(xwVar, obj);
        }
        int i5 = this.h - i;
        int i6 = this.i - i2;
        int i7 = rect == null ? 0 : rect.left;
        int i8 = rect == null ? 0 : rect.top;
        this.f = true;
        this.g = z;
        nx nxVar = new nx();
        this.k = nxVar;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        zw zwVar = new zw(tVar);
        zwVar.k = null;
        zwVar.l = null;
        zwVar.m = null;
        zwVar.n = false;
        zwVar.p = 0.0f;
        zwVar.q = 0.0f;
        zwVar.r = 1.0f;
        zwVar.s = 1.0f;
        DragLayer dragLayer = tVar.getDragLayer();
        zwVar.m = dragLayer;
        zwVar.r = f;
        int i9 = i7;
        float f2 = width;
        float dimensionPixelSize = (zwVar.getResources().getDimensionPixelSize(e51.dragViewScale) + f2) / f2;
        zwVar.setScaleX(f);
        zwVar.setScaleY(f);
        int i10 = i8;
        ValueAnimator valueAnimatorC = ik0.c(0.0f, 1.0f);
        zwVar.o = valueAnimatorC;
        valueAnimatorC.setDuration(150L);
        valueAnimatorC.addUpdateListener(new yw(zwVar, f, dimensionPixelSize));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height);
        zwVar.g = bitmapCreateBitmap;
        zwVar.setDragRegion(new Rect(0, 0, width, height));
        zwVar.i = i5;
        zwVar.j = i6;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        zwVar.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        zwVar.h = new Paint(2);
        if (ar1.m) {
            zwVar.setElevation(zwVar.getResources().getDimension(e51.drag_elevation));
        }
        nxVar.f = zwVar;
        nx nxVar2 = this.k;
        nxVar2.e = false;
        if (this.g) {
            nxVar2.c = bitmap.getWidth() / 2;
            this.k.d = bitmap.getHeight() / 2;
            this.k.i = true;
        } else {
            nxVar2.c = this.h - (i + i9);
            nxVar2.d = this.i - (i2 + i10);
            nxVar2.m = ((AccessibilityManager) zwVar.getContext().getSystemService("accessibility")).isEnabled() ? new ax(0, zwVar) : null;
        }
        nx nxVar3 = this.k;
        nxVar3.h = xwVar;
        nxVar3.g = obj;
        if (point != null) {
            zwVar.setDragVisualizeOffset(new Point(point));
        }
        if (rect != null) {
            zwVar.setDragRegion(new Rect(rect));
        }
        tVar.getDragLayer().performHapticFeedback(0);
        int i11 = this.h;
        int i12 = this.i;
        dragLayer.addView(zwVar);
        pw pwVar = new pw(0, 0);
        ((FrameLayout.LayoutParams) pwVar).width = bitmapCreateBitmap.getWidth();
        ((FrameLayout.LayoutParams) pwVar).height = bitmapCreateBitmap.getHeight();
        pwVar.d = true;
        zwVar.setLayoutParams(pwVar);
        zwVar.setTranslationX(i11 - i5);
        zwVar.setTranslationY(i12 - i6);
        zwVar.post(new o1(zwVar, 16));
        i(this.h, this.i);
        return zwVar;
    }

    public final void m(View view, Bitmap bitmap, WidgetsContainerView widgetsContainerView, u11 u11Var, Rect rect, float f) {
        DragLayer dragLayer = this.a.getDragLayer();
        int[] iArr = this.d;
        dragLayer.getLocationInDragLayer(view, iArr);
        l(bitmap, iArr[0] + rect.left + ((int) (((bitmap.getWidth() * f) - bitmap.getWidth()) / 2.0f)), iArr[1] + rect.top + ((int) (((bitmap.getHeight() * f) - bitmap.getHeight()) / 2.0f)), widgetsContainerView, u11Var, 1, null, null, f, false);
    }
}
