package defpackage;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.internal.ads.zzbbc;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class vh0 extends s81 implements w81 {
    public ArrayList A;
    public ArrayList B;
    public h80 D;
    public uh0 E;
    public Rect G;
    public long H;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public final th0 s;
    public int u;
    public int w;
    public RecyclerView x;
    public VelocityTracker z;
    public final ArrayList g = new ArrayList();
    public final float[] h = new float[2];
    public m91 i = null;
    public int r = -1;
    public int t = 0;
    public final ArrayList v = new ArrayList();
    public final o1 y = new o1(this, 28);
    public View C = null;
    public final rh0 F = new rh0(this);

    public vh0(th0 th0Var) {
        this.s = th0Var;
    }

    public static boolean p(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= f3 + ((float) view.getWidth()) && f2 >= f4 && f2 <= f4 + ((float) view.getHeight());
    }

    @Override // defpackage.w81
    public final void d(View view) {
        r(view);
        m91 m91VarP = this.x.P(view);
        if (m91VarP == null) {
            return;
        }
        m91 m91Var = this.i;
        if (m91Var != null && m91VarP == m91Var) {
            s(null, 0);
            return;
        }
        m(m91VarP, false);
        if (this.g.remove(m91VarP.g)) {
            this.s.a(this.x, m91VarP);
        }
    }

    @Override // defpackage.s81
    public final void f(Rect rect, View view, RecyclerView recyclerView, i91 i91Var) {
        rect.setEmpty();
    }

    @Override // defpackage.s81
    public final void g(Canvas canvas, RecyclerView recyclerView) {
        float f;
        float f2;
        if (this.i != null) {
            float[] fArr = this.h;
            o(fArr);
            float f3 = fArr[0];
            f = fArr[1];
            f2 = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        m91 m91Var = this.i;
        ArrayList arrayList = this.v;
        int i = this.t;
        th0 th0Var = this.s;
        th0Var.getClass();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            sh0 sh0Var = (sh0) arrayList.get(i2);
            m91 m91Var2 = sh0Var.k;
            float f4 = sh0Var.g;
            float f5 = sh0Var.i;
            if (f4 == f5) {
                sh0Var.o = m91Var2.g.getTranslationX();
            } else {
                sh0Var.o = uo.s(f5, f4, sh0Var.s, f4);
            }
            float f6 = sh0Var.h;
            float f7 = sh0Var.j;
            if (f6 == f7) {
                sh0Var.p = m91Var2.g.getTranslationY();
            } else {
                sh0Var.p = uo.s(f7, f6, sh0Var.s, f6);
            }
            int iSave = canvas.save();
            th0Var.n(canvas, recyclerView, sh0Var.k, sh0Var.o, sh0Var.p, sh0Var.l, false);
            canvas.restoreToCount(iSave);
        }
        if (m91Var != null) {
            int iSave2 = canvas.save();
            th0Var.n(canvas, recyclerView, m91Var, f2, f, i, true);
            canvas.restoreToCount(iSave2);
        }
    }

    @Override // defpackage.s81
    public final void h(Canvas canvas, RecyclerView recyclerView) {
        boolean z = false;
        if (this.i != null) {
            float[] fArr = this.h;
            o(fArr);
            float f = fArr[0];
            float f2 = fArr[1];
        }
        m91 m91Var = this.i;
        ArrayList arrayList = this.v;
        th0 th0Var = this.s;
        th0Var.getClass();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sh0 sh0Var = (sh0) arrayList.get(i);
            int iSave = canvas.save();
            th0Var.o(sh0Var.k);
            canvas.restoreToCount(iSave);
        }
        if (m91Var != null) {
            int iSave2 = canvas.save();
            th0Var.o(m91Var);
            canvas.restoreToCount(iSave2);
        }
        for (int i2 = size - 1; i2 >= 0; i2--) {
            sh0 sh0Var2 = (sh0) arrayList.get(i2);
            boolean z2 = sh0Var2.r;
            if (z2 && !sh0Var2.n) {
                arrayList.remove(i2);
            } else if (!z2) {
                z = true;
            }
        }
        if (z) {
            recyclerView.invalidate();
        }
    }

    public final void i(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.x;
        if (recyclerView2 == recyclerView) {
            return;
        }
        rh0 rh0Var = this.F;
        if (recyclerView2 != null) {
            recyclerView2.g0(this);
            RecyclerView recyclerView3 = this.x;
            recyclerView3.w.remove(rh0Var);
            if (recyclerView3.x == rh0Var) {
                recyclerView3.x = null;
            }
            ArrayList arrayList = this.x.I;
            if (arrayList != null) {
                arrayList.remove(this);
            }
            ArrayList arrayList2 = this.v;
            int size = arrayList2.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                sh0 sh0Var = (sh0) arrayList2.get(0);
                sh0Var.m.cancel();
                this.s.a(this.x, sh0Var.k);
            }
            arrayList2.clear();
            this.C = null;
            VelocityTracker velocityTracker = this.z;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.z = null;
            }
            uh0 uh0Var = this.E;
            if (uh0Var != null) {
                uh0Var.a = false;
                this.E = null;
            }
            if (this.D != null) {
                this.D = null;
            }
        }
        this.x = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.l = resources.getDimension(c51.item_touch_helper_swipe_escape_velocity);
            this.m = resources.getDimension(c51.item_touch_helper_swipe_escape_max_velocity);
            this.w = ViewConfiguration.get(this.x.getContext()).getScaledTouchSlop();
            this.x.k(this);
            this.x.w.add(rh0Var);
            RecyclerView recyclerView4 = this.x;
            if (recyclerView4.I == null) {
                recyclerView4.I = new ArrayList();
            }
            recyclerView4.I.add(this);
            this.E = new uh0(this);
            this.D = new h80(this.x.getContext(), this.E);
        }
    }

    public final int j(m91 m91Var, int i) {
        if ((i & 12) == 0) {
            return 0;
        }
        int i2 = this.n > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.z;
        th0 th0Var = this.s;
        if (velocityTracker != null && this.r > -1) {
            float f = this.m;
            th0Var.getClass();
            velocityTracker.computeCurrentVelocity(zzbbc.zzq.zzf, f);
            float xVelocity = this.z.getXVelocity(this.r);
            float yVelocity = this.z.getYVelocity(this.r);
            int i3 = xVelocity > 0.0f ? 8 : 4;
            float fAbs = Math.abs(xVelocity);
            if ((i3 & i) != 0 && i2 == i3 && fAbs >= this.l && fAbs > Math.abs(yVelocity)) {
                return i3;
            }
        }
        float fI = th0Var.i() * this.x.getWidth();
        if ((i & i2) == 0 || Math.abs(this.n) <= fI) {
            return 0;
        }
        return i2;
    }

    public final void k(int i, int i2, MotionEvent motionEvent) {
        View viewN;
        if (this.i == null && i == 2 && this.t != 2) {
            th0 th0Var = this.s;
            if (th0Var.k() && this.x.getScrollState() != 1) {
                u81 layoutManager = this.x.getLayoutManager();
                int i3 = this.r;
                m91 m91VarP = null;
                if (i3 != -1) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(i3);
                    float x = motionEvent.getX(iFindPointerIndex) - this.j;
                    float y = motionEvent.getY(iFindPointerIndex) - this.k;
                    float fAbs = Math.abs(x);
                    float fAbs2 = Math.abs(y);
                    float f = this.w;
                    if ((fAbs >= f || fAbs2 >= f) && ((fAbs <= fAbs2 || !layoutManager.d()) && ((fAbs2 <= fAbs || !layoutManager.e()) && (viewN = n(motionEvent)) != null))) {
                        m91VarP = this.x.P(viewN);
                    }
                }
                if (m91VarP == null) {
                    return;
                }
                RecyclerView recyclerView = this.x;
                int iH = th0Var.h(recyclerView, m91VarP);
                WeakHashMap weakHashMap = qs1.a;
                int iB = (th0.b(iH, recyclerView.getLayoutDirection()) & 65280) >> 8;
                if (iB == 0) {
                    return;
                }
                float x2 = motionEvent.getX(i2);
                float y2 = motionEvent.getY(i2);
                float f2 = x2 - this.j;
                float f3 = y2 - this.k;
                float fAbs3 = Math.abs(f2);
                float fAbs4 = Math.abs(f3);
                float f4 = this.w;
                if (fAbs3 >= f4 || fAbs4 >= f4) {
                    if (fAbs3 > fAbs4) {
                        if (f2 < 0.0f && (iB & 4) == 0) {
                            return;
                        }
                        if (f2 > 0.0f && (iB & 8) == 0) {
                            return;
                        }
                    } else {
                        if (f3 < 0.0f && (iB & 1) == 0) {
                            return;
                        }
                        if (f3 > 0.0f && (iB & 2) == 0) {
                            return;
                        }
                    }
                    this.o = 0.0f;
                    this.n = 0.0f;
                    this.r = motionEvent.getPointerId(0);
                    s(m91VarP, 1);
                }
            }
        }
    }

    public final int l(m91 m91Var, int i) {
        if ((i & 3) == 0) {
            return 0;
        }
        int i2 = this.o > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.z;
        th0 th0Var = this.s;
        if (velocityTracker != null && this.r > -1) {
            float f = this.m;
            th0Var.getClass();
            velocityTracker.computeCurrentVelocity(zzbbc.zzq.zzf, f);
            float xVelocity = this.z.getXVelocity(this.r);
            float yVelocity = this.z.getYVelocity(this.r);
            int i3 = yVelocity > 0.0f ? 2 : 1;
            float fAbs = Math.abs(yVelocity);
            if ((i3 & i) != 0 && i3 == i2 && fAbs >= this.l && fAbs > Math.abs(xVelocity)) {
                return i3;
            }
        }
        float fI = th0Var.i() * this.x.getHeight();
        if ((i & i2) == 0 || Math.abs(this.o) <= fI) {
            return 0;
        }
        return i2;
    }

    public final void m(m91 m91Var, boolean z) {
        ArrayList arrayList = this.v;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            sh0 sh0Var = (sh0) arrayList.get(size);
            if (sh0Var.k == m91Var) {
                sh0Var.q |= z;
                if (!sh0Var.r) {
                    sh0Var.m.cancel();
                }
                arrayList.remove(size);
                return;
            }
        }
    }

    public final View n(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        m91 m91Var = this.i;
        if (m91Var != null) {
            float f = this.p + this.n;
            float f2 = this.q + this.o;
            View view = m91Var.g;
            if (p(view, x, y, f, f2)) {
                return view;
            }
        }
        ArrayList arrayList = this.v;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            sh0 sh0Var = (sh0) arrayList.get(size);
            View view2 = sh0Var.k.g;
            if (p(view2, x, y, sh0Var.o, sh0Var.p)) {
                return view2;
            }
        }
        RecyclerView recyclerView = this.x;
        for (int iG = recyclerView.l.g() - 1; iG >= 0; iG--) {
            View viewF = recyclerView.l.f(iG);
            float translationX = viewF.getTranslationX();
            float translationY = viewF.getTranslationY();
            if (x >= viewF.getLeft() + translationX && x <= viewF.getRight() + translationX && y >= viewF.getTop() + translationY && y <= viewF.getBottom() + translationY) {
                return viewF;
            }
        }
        return null;
    }

    public final void o(float[] fArr) {
        if ((this.u & 12) != 0) {
            fArr[0] = (this.p + this.n) - this.i.g.getLeft();
        } else {
            fArr[0] = this.i.g.getTranslationX();
        }
        if ((this.u & 3) != 0) {
            fArr[1] = (this.q + this.o) - this.i.g.getTop();
        } else {
            fArr[1] = this.i.g.getTranslationY();
        }
    }

    public final void q(m91 m91Var) {
        ArrayList arrayList;
        int bottom;
        int iAbs;
        int top;
        int iAbs2;
        int left;
        int iAbs3;
        int right;
        int iAbs4;
        int i;
        int i2;
        int i3;
        int i4;
        if (!this.x.isLayoutRequested() && this.t == 2) {
            th0 th0Var = this.s;
            float fG = th0Var.g();
            int i5 = (int) (this.p + this.n);
            int i6 = (int) (this.q + this.o);
            float fAbs = Math.abs(i6 - m91Var.g.getTop());
            View view = m91Var.g;
            if (fAbs >= view.getHeight() * fG || Math.abs(i5 - view.getLeft()) >= view.getWidth() * fG) {
                ArrayList arrayList2 = this.A;
                if (arrayList2 == null) {
                    this.A = new ArrayList();
                    this.B = new ArrayList();
                } else {
                    arrayList2.clear();
                    this.B.clear();
                }
                int iRound = Math.round(this.p + this.n);
                int iRound2 = Math.round(this.q + this.o);
                int width = view.getWidth() + iRound;
                int height = view.getHeight() + iRound2;
                int i7 = (iRound + width) / 2;
                int i8 = (iRound2 + height) / 2;
                u81 layoutManager = this.x.getLayoutManager();
                int iV = layoutManager.v();
                int i9 = 0;
                while (i9 < iV) {
                    View viewU = layoutManager.u(i9);
                    if (viewU == view) {
                        i = i9;
                    } else {
                        i = i9;
                        if (viewU.getBottom() >= iRound2 && viewU.getTop() <= height && viewU.getRight() >= iRound && viewU.getLeft() <= width) {
                            m91 m91VarP = this.x.P(viewU);
                            int iAbs5 = Math.abs(i7 - ((viewU.getRight() + viewU.getLeft()) / 2));
                            int iAbs6 = Math.abs(i8 - ((viewU.getBottom() + viewU.getTop()) / 2));
                            int i10 = (iAbs6 * iAbs6) + (iAbs5 * iAbs5);
                            i2 = iRound;
                            int size = this.A.size();
                            i3 = i5;
                            i4 = i6;
                            int i11 = 0;
                            int i12 = 0;
                            while (i11 < size) {
                                int i13 = size;
                                if (i10 <= ((Integer) this.B.get(i11)).intValue()) {
                                    break;
                                }
                                i12++;
                                i11++;
                                size = i13;
                            }
                            this.A.add(i12, m91VarP);
                            this.B.add(i12, Integer.valueOf(i10));
                        }
                        i9 = i + 1;
                        iRound = i2;
                        i5 = i3;
                        i6 = i4;
                    }
                    i2 = iRound;
                    i3 = i5;
                    i4 = i6;
                    i9 = i + 1;
                    iRound = i2;
                    i5 = i3;
                    i6 = i4;
                }
                int i14 = i5;
                int i15 = i6;
                ArrayList arrayList3 = this.A;
                if (arrayList3.size() == 0) {
                    return;
                }
                int width2 = view.getWidth() + i14;
                int height2 = view.getHeight() + i15;
                int left2 = i14 - view.getLeft();
                int top2 = i15 - view.getTop();
                int size2 = arrayList3.size();
                m91 m91Var2 = null;
                int i16 = -1;
                int i17 = 0;
                while (i17 < size2) {
                    m91 m91Var3 = (m91) arrayList3.get(i17);
                    if (left2 <= 0 || (right = m91Var3.g.getRight() - width2) >= 0) {
                        arrayList = arrayList3;
                    } else {
                        arrayList = arrayList3;
                        if (m91Var3.g.getRight() > view.getRight() && (iAbs4 = Math.abs(right)) > i16) {
                            i16 = iAbs4;
                            m91Var2 = m91Var3;
                        }
                    }
                    if (left2 < 0 && (left = m91Var3.g.getLeft() - i14) > 0 && m91Var3.g.getLeft() < view.getLeft() && (iAbs3 = Math.abs(left)) > i16) {
                        i16 = iAbs3;
                        m91Var2 = m91Var3;
                    }
                    if (top2 < 0 && (top = m91Var3.g.getTop() - i15) > 0 && m91Var3.g.getTop() < view.getTop() && (iAbs2 = Math.abs(top)) > i16) {
                        i16 = iAbs2;
                        m91Var2 = m91Var3;
                    }
                    if (top2 > 0 && (bottom = m91Var3.g.getBottom() - height2) < 0 && m91Var3.g.getBottom() > view.getBottom() && (iAbs = Math.abs(bottom)) > i16) {
                        i16 = iAbs;
                        m91Var2 = m91Var3;
                    }
                    i17++;
                    arrayList3 = arrayList;
                }
                if (m91Var2 == null) {
                    this.A.clear();
                    this.B.clear();
                    return;
                }
                int iD = m91Var2.d();
                m91Var.d();
                if (th0Var.q(this.x, m91Var, m91Var2)) {
                    RecyclerView recyclerView = this.x;
                    u81 layoutManager2 = recyclerView.getLayoutManager();
                    boolean z = layoutManager2 instanceof LinearLayoutManager;
                    View view2 = m91Var2.g;
                    if (!z) {
                        if (layoutManager2.d()) {
                            if (u81.A(view2) <= recyclerView.getPaddingLeft()) {
                                recyclerView.l0(iD);
                            }
                            if (u81.C(view2) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                                recyclerView.l0(iD);
                            }
                        }
                        if (layoutManager2.e()) {
                            if (u81.D(view2) <= recyclerView.getPaddingTop()) {
                                recyclerView.l0(iD);
                            }
                            if (u81.y(view2) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                                recyclerView.l0(iD);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager2;
                    linearLayoutManager.c("Cannot drop a view during a scroll or layout calculation");
                    linearLayoutManager.K0();
                    linearLayoutManager.c1();
                    int iJ = u81.J(view);
                    int iJ2 = u81.J(view2);
                    byte b = iJ < iJ2 ? (byte) 1 : (byte) -1;
                    if (linearLayoutManager.u) {
                        if (b == 1) {
                            linearLayoutManager.e1(iJ2, linearLayoutManager.r.g() - (linearLayoutManager.r.c(view) + linearLayoutManager.r.e(view2)));
                            return;
                        } else {
                            linearLayoutManager.e1(iJ2, linearLayoutManager.r.g() - linearLayoutManager.r.b(view2));
                            return;
                        }
                    }
                    if (b == -1) {
                        linearLayoutManager.e1(iJ2, linearLayoutManager.r.e(view2));
                    } else {
                        linearLayoutManager.e1(iJ2, linearLayoutManager.r.b(view2) - linearLayoutManager.r.c(view));
                    }
                }
            }
        }
    }

    public final void r(View view) {
        if (view == this.C) {
            this.C = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(defpackage.m91 r23, int r24) {
        /*
            Method dump skipped, instruction units count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vh0.s(m91, int):void");
    }

    public final void t(m91 m91Var) {
        th0 th0Var = this.s;
        RecyclerView recyclerView = this.x;
        int iH = th0Var.h(recyclerView, m91Var);
        WeakHashMap weakHashMap = qs1.a;
        if ((th0.b(iH, recyclerView.getLayoutDirection()) & 16711680) == 0 || m91Var.g.getParent() != this.x) {
            return;
        }
        VelocityTracker velocityTracker = this.z;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.z = VelocityTracker.obtain();
        this.o = 0.0f;
        this.n = 0.0f;
        s(m91Var, 2);
    }

    public final void u(int i, int i2, MotionEvent motionEvent) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f = x - this.j;
        this.n = f;
        this.o = y - this.k;
        if ((i & 4) == 0) {
            this.n = Math.max(0.0f, f);
        }
        if ((i & 8) == 0) {
            this.n = Math.min(0.0f, this.n);
        }
        if ((i & 1) == 0) {
            this.o = Math.max(0.0f, this.o);
        }
        if ((i & 2) == 0) {
            this.o = Math.min(0.0f, this.o);
        }
    }

    @Override // defpackage.w81
    public final void a(View view) {
    }
}
