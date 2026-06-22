package defpackage;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.Choreographer;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.luutinhit.launcher6.util.recyclerviewbouncy.BouncyRecyclerView;
import com.luutinhit.launcherios.searchview.SearchViewLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class mi1 {
    public static final vx l = new vx(1);
    public static final vx m = new vx(2);
    public static final vx n = new vx(3);
    public static final vx o = new vx(4);
    public static final vx p = new vx(5);
    public static final vx q = new vx(6);
    public static final vx r = new vx(7);
    public static final vx s = new vx(0);
    public final ViewGroup c;
    public final e42 d;
    public final float g;
    public ni1 j;
    public float k;
    public float a = 0.0f;
    public float b = Float.MAX_VALUE;
    public boolean e = false;
    public long f = 0;
    public final ArrayList h = new ArrayList();
    public final ArrayList i = new ArrayList();

    public mi1(ViewGroup viewGroup, e42 e42Var) {
        this.c = viewGroup;
        this.d = e42Var;
        if (e42Var == p || e42Var == q || e42Var == r) {
            this.g = 0.1f;
        } else if (e42Var == s || e42Var == n || e42Var == o) {
            this.g = 0.00390625f;
        } else {
            this.g = 1.0f;
        }
        this.j = null;
        this.k = Float.MAX_VALUE;
    }

    public final void a(qd qdVar) {
        if (this.e) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        ArrayList arrayList = this.i;
        if (arrayList.contains(qdVar)) {
            return;
        }
        arrayList.add(qdVar);
    }

    public final void b() {
        ArrayList arrayList;
        EditText editText;
        InputMethodManager inputMethodManager;
        this.e = false;
        ThreadLocal threadLocal = m5.f;
        if (threadLocal.get() == null) {
            threadLocal.set(new m5());
        }
        m5 m5Var = (m5) threadLocal.get();
        m5Var.a.remove(this);
        ArrayList arrayList2 = m5Var.b;
        int iIndexOf = arrayList2.indexOf(this);
        if (iIndexOf >= 0) {
            arrayList2.set(iIndexOf, null);
            m5Var.e = true;
        }
        this.f = 0L;
        int i = 0;
        while (true) {
            arrayList = this.h;
            if (i >= arrayList.size()) {
                break;
            }
            if (arrayList.get(i) != null) {
                SearchViewLayout searchViewLayout = ((dz0) arrayList.get(i)).a.l;
                if (searchViewLayout.y()) {
                    searchViewLayout.setState(true);
                }
                if (searchViewLayout.x() && (editText = searchViewLayout.m) != null) {
                    editText.requestFocus();
                    if (searchViewLayout.h.getResources().getConfiguration().keyboard == 1 && (inputMethodManager = searchViewLayout.z) != null) {
                        inputMethodManager.showSoftInput(editText, 0);
                    }
                }
            }
            i++;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public final void c(float f) {
        this.d.q(this.c, f);
        int i = 0;
        while (true) {
            ArrayList arrayList = this.i;
            if (i >= arrayList.size()) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (arrayList.get(size) == null) {
                        arrayList.remove(size);
                    }
                }
                return;
            }
            if (arrayList.get(i) != null) {
                qd qdVar = (qd) arrayList.get(i);
                switch (qdVar.a) {
                    case 0:
                        BouncyRecyclerView bouncyRecyclerView = qdVar.b;
                        wy0 wy0Var = bouncyRecyclerView.R0;
                        if (wy0Var != null) {
                            ((wq) ((mc1) wy0Var).h).m.invalidate();
                        }
                        if (qdVar.c.e) {
                            bouncyRecyclerView.t0();
                        }
                        break;
                    case 1:
                        BouncyRecyclerView bouncyRecyclerView2 = qdVar.b;
                        wy0 wy0Var2 = bouncyRecyclerView2.R0;
                        if (wy0Var2 != null) {
                            ((wq) ((mc1) wy0Var2).h).m.invalidate();
                        }
                        if (qdVar.c.e) {
                            bouncyRecyclerView2.t0();
                        }
                        break;
                    default:
                        BouncyRecyclerView bouncyRecyclerView3 = qdVar.b;
                        wy0 wy0Var3 = bouncyRecyclerView3.R0;
                        if (wy0Var3 != null) {
                            ((wq) ((mc1) wy0Var3).h).m.invalidate();
                        }
                        Integer num = bouncyRecyclerView3.V0;
                        mi1 mi1Var = qdVar.c;
                        if (num != null && num.intValue() == 1) {
                            if (mi1Var.e) {
                                bouncyRecyclerView3.t0();
                            }
                        } else if (mi1Var.e) {
                            bouncyRecyclerView3.t0();
                        }
                        break;
                }
            }
            i++;
        }
    }

    public final void d() {
        ni1 ni1Var = this.j;
        if (ni1Var == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double d = (float) ni1Var.i;
        if (d > Float.MAX_VALUE) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (d < -3.4028235E38f) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
        double dAbs = Math.abs(this.g * 0.75f);
        ni1Var.d = dAbs;
        ni1Var.e = dAbs * 62.5d;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        boolean z = this.e;
        if (z || z) {
            return;
        }
        this.e = true;
        float fC = this.d.c(this.c);
        this.b = fC;
        if (fC > Float.MAX_VALUE || fC < -3.4028235E38f) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        ThreadLocal threadLocal = m5.f;
        if (threadLocal.get() == null) {
            threadLocal.set(new m5());
        }
        m5 m5Var = (m5) threadLocal.get();
        ArrayList arrayList = m5Var.b;
        if (arrayList.size() == 0) {
            if (m5Var.d == null) {
                m5Var.d = new wb2(m5Var.c);
            }
            wb2 wb2Var = m5Var.d;
            ((Choreographer) wb2Var.i).postFrameCallback((l5) wb2Var.j);
        }
        if (arrayList.contains(this)) {
            return;
        }
        arrayList.add(this);
    }
}
