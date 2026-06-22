package androidx.fragment.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import defpackage.an0;
import defpackage.ap0;
import defpackage.b61;
import defpackage.c60;
import defpackage.ct1;
import defpackage.cu;
import defpackage.e6;
import defpackage.en0;
import defpackage.fs1;
import defpackage.h60;
import defpackage.hh1;
import defpackage.j60;
import defpackage.ji1;
import defpackage.k31;
import defpackage.k60;
import defpackage.li1;
import defpackage.m60;
import defpackage.mg;
import defpackage.o60;
import defpackage.ok1;
import defpackage.q11;
import defpackage.qs1;
import defpackage.um0;
import defpackage.uo;
import defpackage.v21;
import defpackage.vm0;
import defpackage.w50;
import defpackage.wb2;
import defpackage.x50;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final q11 a;
    public final wb2 b;
    public final w50 c;
    public boolean d = false;
    public int e = -1;

    public a(q11 q11Var, wb2 wb2Var, w50 w50Var) {
        this.a = q11Var;
        this.b = wb2Var;
        this.c = w50Var;
    }

    public final void a() {
        boolean zE = h60.E(3);
        w50 w50Var = this.c;
        if (zE) {
            Objects.toString(w50Var);
        }
        Bundle bundle = w50Var.h;
        w50Var.A.J();
        w50Var.g = 3;
        w50Var.J = false;
        w50Var.v();
        if (!w50Var.J) {
            throw new ok1(uo.g("Fragment ", w50Var, " did not call through to super.onActivityCreated()"));
        }
        if (h60.E(3)) {
            w50Var.toString();
        }
        View view = w50Var.L;
        if (view != null) {
            Bundle bundle2 = w50Var.h;
            SparseArray<Parcelable> sparseArray = w50Var.i;
            if (sparseArray != null) {
                view.restoreHierarchyState(sparseArray);
                w50Var.i = null;
            }
            if (w50Var.L != null) {
                o60 o60Var = w50Var.U;
                o60Var.i.d(w50Var.j);
                w50Var.j = null;
            }
            w50Var.J = false;
            w50Var.K(bundle2);
            if (!w50Var.J) {
                throw new ok1(uo.g("Fragment ", w50Var, " did not call through to super.onViewStateRestored()"));
            }
            if (w50Var.L != null) {
                w50Var.U.b(um0.ON_CREATE);
            }
        }
        w50Var.h = null;
        h60 h60Var = w50Var.A;
        h60Var.A = false;
        h60Var.B = false;
        h60Var.H.h = false;
        h60Var.s(4);
        this.a.l(false);
    }

    public final void b() {
        View view;
        View view2;
        wb2 wb2Var = this.b;
        wb2Var.getClass();
        w50 w50Var = this.c;
        ViewGroup viewGroup = w50Var.K;
        int iIndexOfChild = -1;
        if (viewGroup != null) {
            ArrayList arrayList = (ArrayList) wb2Var.h;
            int iIndexOf = arrayList.indexOf(w50Var);
            int i = iIndexOf - 1;
            while (true) {
                if (i < 0) {
                    while (true) {
                        iIndexOf++;
                        if (iIndexOf >= arrayList.size()) {
                            break;
                        }
                        w50 w50Var2 = (w50) arrayList.get(iIndexOf);
                        if (w50Var2.K == viewGroup && (view = w50Var2.L) != null) {
                            iIndexOfChild = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    w50 w50Var3 = (w50) arrayList.get(i);
                    if (w50Var3.K == viewGroup && (view2 = w50Var3.L) != null) {
                        iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i--;
                }
            }
        }
        w50Var.K.addView(w50Var.L, iIndexOfChild);
    }

    public final void c() {
        boolean zE = h60.E(3);
        w50 w50Var = this.c;
        if (zE) {
            Objects.toString(w50Var);
        }
        w50 w50Var2 = w50Var.n;
        wb2 wb2Var = this.b;
        a aVar = null;
        if (w50Var2 != null) {
            a aVar2 = (a) ((HashMap) wb2Var.i).get(w50Var2.l);
            if (aVar2 == null) {
                throw new IllegalStateException("Fragment " + w50Var + " declared target fragment " + w50Var.n + " that does not belong to this FragmentManager!");
            }
            w50Var.o = w50Var.n.l;
            w50Var.n = null;
            aVar = aVar2;
        } else {
            String str = w50Var.o;
            if (str != null && (aVar = (a) ((HashMap) wb2Var.i).get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(w50Var);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(uo.k(sb, w50Var.o, " that does not belong to this FragmentManager!"));
            }
        }
        if (aVar != null) {
            aVar.k();
        }
        h60 h60Var = w50Var.y;
        w50Var.z = h60Var.p;
        w50Var.B = h60Var.r;
        q11 q11Var = this.a;
        q11Var.u(false);
        ArrayList arrayList = w50Var.X;
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            throw uo.c(it);
        }
        arrayList.clear();
        w50Var.A.b(w50Var.z, w50Var.e(), w50Var);
        w50Var.g = 0;
        w50Var.J = false;
        w50Var.x(w50Var.z.C);
        if (!w50Var.J) {
            throw new ok1(uo.g("Fragment ", w50Var, " did not call through to super.onAttach()"));
        }
        Iterator it2 = w50Var.y.n.iterator();
        while (it2.hasNext()) {
            ((k60) it2.next()).b();
        }
        h60 h60Var2 = w50Var.A;
        h60Var2.A = false;
        h60Var2.B = false;
        h60Var2.H.h = false;
        h60Var2.s(0);
        q11Var.o(false);
    }

    public final int d() {
        li1 li1Var;
        w50 w50Var = this.c;
        if (w50Var.y == null) {
            return w50Var.g;
        }
        int iMin = this.e;
        int iOrdinal = w50Var.S.ordinal();
        int i = 0;
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        if (w50Var.t) {
            if (w50Var.u) {
                iMin = Math.max(this.e, 2);
                View view = w50Var.L;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.e < 4 ? Math.min(iMin, w50Var.g) : Math.min(iMin, 1);
            }
        }
        if (!w50Var.r) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = w50Var.K;
        if (viewGroup != null) {
            cu cuVarF = cu.f(viewGroup, w50Var.r().D());
            cuVarF.getClass();
            li1 li1VarD = cuVarF.d(w50Var);
            int i2 = li1VarD != null ? li1VarD.b : 0;
            ArrayList arrayList = cuVarF.c;
            int size = arrayList.size();
            while (true) {
                if (i >= size) {
                    li1Var = null;
                    break;
                }
                Object obj = arrayList.get(i);
                i++;
                li1Var = (li1) obj;
                if (li1Var.c.equals(w50Var) && !li1Var.f) {
                    break;
                }
            }
            i = (li1Var == null || !(i2 == 0 || i2 == 1)) ? i2 : li1Var.b;
        }
        if (i == 2) {
            iMin = Math.min(iMin, 6);
        } else if (i == 3) {
            iMin = Math.max(iMin, 3);
        } else if (w50Var.s) {
            iMin = w50Var.x > 0 ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (w50Var.M && w50Var.g < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (h60.E(2)) {
            Objects.toString(w50Var);
        }
        return iMin;
    }

    public final void e() {
        Parcelable parcelable;
        boolean zE = h60.E(3);
        final w50 w50Var = this.c;
        if (zE) {
            Objects.toString(w50Var);
        }
        if (w50Var.R) {
            Bundle bundle = w50Var.h;
            if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
                w50Var.A.O(parcelable);
                h60 h60Var = w50Var.A;
                h60Var.A = false;
                h60Var.B = false;
                h60Var.H.h = false;
                h60Var.s(1);
            }
            w50Var.g = 1;
            return;
        }
        q11 q11Var = this.a;
        q11Var.v(false);
        Bundle bundle2 = w50Var.h;
        w50Var.A.J();
        w50Var.g = 1;
        w50Var.J = false;
        w50Var.T.a(new an0() { // from class: androidx.fragment.app.Fragment$5
            @Override // defpackage.an0
            public final void a(en0 en0Var, um0 um0Var) {
                View view;
                if (um0Var != um0.ON_STOP || (view = w50Var.L) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        w50Var.W.d(bundle2);
        w50Var.y(bundle2);
        w50Var.R = true;
        if (!w50Var.J) {
            throw new ok1(uo.g("Fragment ", w50Var, " did not call through to super.onCreate()"));
        }
        w50Var.T.d(um0.ON_CREATE);
        q11Var.q(false);
    }

    public final void f() {
        String resourceName;
        int i = 2;
        w50 w50Var = this.c;
        if (w50Var.t) {
            return;
        }
        if (h60.E(3)) {
            Objects.toString(w50Var);
        }
        LayoutInflater layoutInflaterD = w50Var.D(w50Var.h);
        w50Var.Q = layoutInflaterD;
        ViewGroup viewGroup = w50Var.K;
        if (viewGroup == null) {
            int i2 = w50Var.D;
            if (i2 == 0) {
                viewGroup = null;
            } else {
                if (i2 == -1) {
                    throw new IllegalArgumentException(uo.g("Cannot create fragment ", w50Var, " for a container view with no id"));
                }
                viewGroup = (ViewGroup) w50Var.y.q.w(i2);
                if (viewGroup == null && !w50Var.v) {
                    try {
                        resourceName = w50Var.s().getResourceName(w50Var.D);
                    } catch (Resources.NotFoundException unused) {
                        resourceName = "unknown";
                    }
                    throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(w50Var.D) + " (" + resourceName + ") for fragment " + w50Var);
                }
            }
        }
        w50Var.K = viewGroup;
        w50Var.L(layoutInflaterD, viewGroup, w50Var.h);
        View view = w50Var.L;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            w50Var.L.setTag(b61.fragment_container_view_tag, w50Var);
            if (viewGroup != null) {
                b();
            }
            if (w50Var.F) {
                w50Var.L.setVisibility(8);
            }
            View view2 = w50Var.L;
            WeakHashMap weakHashMap = qs1.a;
            if (view2.isAttachedToWindow()) {
                fs1.c(w50Var.L);
            } else {
                View view3 = w50Var.L;
                view3.addOnAttachStateChangeListener(new mg(view3, i));
            }
            w50Var.J(w50Var.L, w50Var.h);
            w50Var.A.s(2);
            this.a.A(false);
            int visibility = w50Var.L.getVisibility();
            w50Var.g().j = w50Var.L.getAlpha();
            if (w50Var.K != null && visibility == 0) {
                View viewFindFocus = w50Var.L.findFocus();
                if (viewFindFocus != null) {
                    w50Var.g().k = viewFindFocus;
                    if (h60.E(2)) {
                        viewFindFocus.toString();
                        Objects.toString(w50Var);
                    }
                }
                w50Var.L.setAlpha(0.0f);
            }
        }
        w50Var.g = 2;
    }

    public final void g() {
        w50 w50VarQ;
        boolean zE = h60.E(3);
        w50 w50Var = this.c;
        if (zE) {
            Objects.toString(w50Var);
        }
        int i = 0;
        boolean zIsChangingConfigurations = true;
        boolean z = w50Var.s && w50Var.x <= 0;
        wb2 wb2Var = this.b;
        if (!z) {
            j60 j60Var = (j60) wb2Var.j;
            if (!((j60Var.c.containsKey(w50Var.l) && j60Var.f) ? j60Var.g : true)) {
                String str = w50Var.o;
                if (str != null && (w50VarQ = wb2Var.q(str)) != null && w50VarQ.H) {
                    w50Var.n = w50VarQ;
                }
                w50Var.g = 0;
                return;
            }
        }
        x50 x50Var = w50Var.z;
        if (x50Var != null) {
            zIsChangingConfigurations = ((j60) wb2Var.j).g;
        } else {
            e6 e6Var = x50Var.C;
            if (uo.r(e6Var)) {
                zIsChangingConfigurations = true ^ e6Var.isChangingConfigurations();
            }
        }
        if (z || zIsChangingConfigurations) {
            j60 j60Var2 = (j60) wb2Var.j;
            j60Var2.getClass();
            if (h60.E(3)) {
                Objects.toString(w50Var);
            }
            HashMap map = j60Var2.d;
            j60 j60Var3 = (j60) map.get(w50Var.l);
            if (j60Var3 != null) {
                j60Var3.a();
                map.remove(w50Var.l);
            }
            HashMap map2 = j60Var2.e;
            ct1 ct1Var = (ct1) map2.get(w50Var.l);
            if (ct1Var != null) {
                ct1Var.a();
                map2.remove(w50Var.l);
            }
        }
        w50Var.A.k();
        w50Var.T.d(um0.ON_DESTROY);
        w50Var.g = 0;
        w50Var.J = false;
        w50Var.R = false;
        w50Var.A();
        if (!w50Var.J) {
            throw new ok1(uo.g("Fragment ", w50Var, " did not call through to super.onDestroy()"));
        }
        this.a.r(false);
        ArrayList arrayListS = wb2Var.s();
        int size = arrayListS.size();
        while (i < size) {
            Object obj = arrayListS.get(i);
            i++;
            a aVar = (a) obj;
            if (aVar != null) {
                String str2 = w50Var.l;
                w50 w50Var2 = aVar.c;
                if (str2.equals(w50Var2.o)) {
                    w50Var2.n = w50Var;
                    w50Var2.o = null;
                }
            }
        }
        String str3 = w50Var.o;
        if (str3 != null) {
            w50Var.n = wb2Var.q(str3);
        }
        wb2Var.w(this);
    }

    public final void h() {
        View view;
        boolean zE = h60.E(3);
        w50 w50Var = this.c;
        if (zE) {
            Objects.toString(w50Var);
        }
        ViewGroup viewGroup = w50Var.K;
        if (viewGroup != null && (view = w50Var.L) != null) {
            viewGroup.removeView(view);
        }
        w50Var.A.s(1);
        if (w50Var.L != null) {
            o60 o60Var = w50Var.U;
            o60Var.c();
            if (o60Var.h.c.compareTo(vm0.i) >= 0) {
                w50Var.U.b(um0.ON_DESTROY);
            }
        }
        w50Var.g = 1;
        w50Var.J = false;
        w50Var.B();
        if (!w50Var.J) {
            throw new ok1(uo.g("Fragment ", w50Var, " did not call through to super.onDestroyView()"));
        }
        ji1 ji1Var = ((ap0) new v21(w50Var, w50Var.j()).i).c;
        if (ji1Var.i > 0) {
            ji1Var.h[0].getClass();
            throw new ClassCastException();
        }
        w50Var.w = false;
        this.a.B(false);
        w50Var.K = null;
        w50Var.L = null;
        w50Var.U = null;
        w50Var.V.e(null);
        w50Var.u = false;
    }

    public final void i() {
        boolean zE = h60.E(3);
        w50 w50Var = this.c;
        if (zE) {
            Objects.toString(w50Var);
        }
        w50Var.g = -1;
        w50Var.J = false;
        w50Var.C();
        w50Var.Q = null;
        if (!w50Var.J) {
            throw new ok1(uo.g("Fragment ", w50Var, " did not call through to super.onDetach()"));
        }
        h60 h60Var = w50Var.A;
        if (!h60Var.C) {
            h60Var.k();
            w50Var.A = new h60();
        }
        this.a.s(false);
        w50Var.g = -1;
        w50Var.z = null;
        w50Var.B = null;
        w50Var.y = null;
        if (!w50Var.s || w50Var.x > 0) {
            j60 j60Var = (j60) this.b.j;
            if (!((j60Var.c.containsKey(w50Var.l) && j60Var.f) ? j60Var.g : true)) {
                return;
            }
        }
        if (h60.E(3)) {
            Objects.toString(w50Var);
        }
        w50Var.T = new androidx.lifecycle.a(w50Var);
        w50Var.W = new hh1(w50Var);
        w50Var.l = UUID.randomUUID().toString();
        w50Var.r = false;
        w50Var.s = false;
        w50Var.t = false;
        w50Var.u = false;
        w50Var.v = false;
        w50Var.x = 0;
        w50Var.y = null;
        w50Var.A = new h60();
        w50Var.z = null;
        w50Var.C = 0;
        w50Var.D = 0;
        w50Var.E = null;
        w50Var.F = false;
        w50Var.G = false;
    }

    public final void j() {
        w50 w50Var = this.c;
        if (w50Var.t && w50Var.u && !w50Var.w) {
            if (h60.E(3)) {
                Objects.toString(w50Var);
            }
            LayoutInflater layoutInflaterD = w50Var.D(w50Var.h);
            w50Var.Q = layoutInflaterD;
            w50Var.L(layoutInflaterD, null, w50Var.h);
            View view = w50Var.L;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                w50Var.L.setTag(b61.fragment_container_view_tag, w50Var);
                if (w50Var.F) {
                    w50Var.L.setVisibility(8);
                }
                w50Var.J(w50Var.L, w50Var.h);
                w50Var.A.s(2);
                this.a.A(false);
                w50Var.g = 2;
            }
        }
    }

    public final void k() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z = this.d;
        w50 w50Var = this.c;
        if (z) {
            if (h60.E(2)) {
                Objects.toString(w50Var);
                return;
            }
            return;
        }
        try {
            this.d = true;
            while (true) {
                int iD = d();
                int i = w50Var.g;
                if (iD == i) {
                    if (w50Var.P) {
                        if (w50Var.L != null && (viewGroup = w50Var.K) != null) {
                            cu cuVarF = cu.f(viewGroup, w50Var.r().D());
                            if (w50Var.F) {
                                cuVarF.getClass();
                                if (h60.E(2)) {
                                    Objects.toString(w50Var);
                                }
                                cuVarF.a(3, 1, this);
                            } else {
                                cuVarF.getClass();
                                if (h60.E(2)) {
                                    Objects.toString(w50Var);
                                }
                                cuVarF.a(2, 1, this);
                            }
                        }
                        h60 h60Var = w50Var.y;
                        if (h60Var != null && w50Var.r && h60.F(w50Var)) {
                            h60Var.z = true;
                        }
                        w50Var.P = false;
                    }
                    this.d = false;
                    return;
                }
                if (iD <= i) {
                    switch (i - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            g();
                            break;
                        case 1:
                            h();
                            w50Var.g = 1;
                            break;
                        case 2:
                            w50Var.u = false;
                            w50Var.g = 2;
                            break;
                        case 3:
                            if (h60.E(3)) {
                                Objects.toString(w50Var);
                            }
                            if (w50Var.L != null && w50Var.i == null) {
                                o();
                            }
                            if (w50Var.L != null && (viewGroup3 = w50Var.K) != null) {
                                cu cuVarF2 = cu.f(viewGroup3, w50Var.r().D());
                                cuVarF2.getClass();
                                if (h60.E(2)) {
                                    Objects.toString(w50Var);
                                }
                                cuVarF2.a(1, 3, this);
                            }
                            w50Var.g = 3;
                            break;
                        case 4:
                            q();
                            break;
                        case 5:
                            w50Var.g = 5;
                            break;
                        case 6:
                            l();
                            break;
                    }
                } else {
                    switch (i + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (w50Var.L != null && (viewGroup2 = w50Var.K) != null) {
                                cu cuVarF3 = cu.f(viewGroup2, w50Var.r().D());
                                int iB = k31.b(w50Var.L.getVisibility());
                                cuVarF3.getClass();
                                if (h60.E(2)) {
                                    Objects.toString(w50Var);
                                }
                                cuVarF3.a(iB, 2, this);
                            }
                            w50Var.g = 4;
                            break;
                        case 5:
                            p();
                            break;
                        case 6:
                            w50Var.g = 6;
                            break;
                        case 7:
                            n();
                            break;
                    }
                }
            }
        } catch (Throwable th) {
            this.d = false;
            throw th;
        }
    }

    public final void l() {
        boolean zE = h60.E(3);
        w50 w50Var = this.c;
        if (zE) {
            Objects.toString(w50Var);
        }
        w50Var.A.s(5);
        if (w50Var.L != null) {
            w50Var.U.b(um0.ON_PAUSE);
        }
        w50Var.T.d(um0.ON_PAUSE);
        w50Var.g = 6;
        w50Var.J = false;
        w50Var.E();
        if (!w50Var.J) {
            throw new ok1(uo.g("Fragment ", w50Var, " did not call through to super.onPause()"));
        }
        this.a.t(false);
    }

    public final void m(ClassLoader classLoader) {
        w50 w50Var = this.c;
        Bundle bundle = w50Var.h;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        w50Var.i = w50Var.h.getSparseParcelableArray("android:view_state");
        w50Var.j = w50Var.h.getBundle("android:view_registry_state");
        w50Var.o = w50Var.h.getString("android:target_state");
        if (w50Var.o != null) {
            w50Var.p = w50Var.h.getInt("android:target_req_state", 0);
        }
        Boolean bool = w50Var.k;
        if (bool != null) {
            w50Var.N = bool.booleanValue();
            w50Var.k = null;
        } else {
            w50Var.N = w50Var.h.getBoolean("android:user_visible_hint", true);
        }
        if (w50Var.N) {
            return;
        }
        w50Var.M = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n() {
        /*
            r6 = this;
            r0 = 3
            boolean r0 = defpackage.h60.E(r0)
            w50 r1 = r6.c
            if (r0 == 0) goto Lc
            java.util.Objects.toString(r1)
        Lc:
            v50 r0 = r1.O
            r2 = 0
            if (r0 != 0) goto L13
            r0 = r2
            goto L15
        L13:
            android.view.View r0 = r0.k
        L15:
            if (r0 == 0) goto L45
            android.view.View r3 = r1.L
            if (r0 != r3) goto L1c
            goto L26
        L1c:
            android.view.ViewParent r3 = r0.getParent()
        L20:
            if (r3 == 0) goto L45
            android.view.View r4 = r1.L
            if (r3 != r4) goto L40
        L26:
            r0.requestFocus()
            r3 = 2
            boolean r3 = defpackage.h60.E(r3)
            if (r3 == 0) goto L45
            r0.toString()
            java.util.Objects.toString(r1)
            android.view.View r0 = r1.L
            android.view.View r0 = r0.findFocus()
            java.util.Objects.toString(r0)
            goto L45
        L40:
            android.view.ViewParent r3 = r3.getParent()
            goto L20
        L45:
            v50 r0 = r1.g()
            r0.k = r2
            h60 r0 = r1.A
            r0.J()
            h60 r0 = r1.A
            r3 = 1
            r0.x(r3)
            r0 = 7
            r1.g = r0
            r3 = 0
            r1.J = r3
            r1.F()
            boolean r4 = r1.J
            if (r4 == 0) goto L8e
            androidx.lifecycle.a r4 = r1.T
            um0 r5 = defpackage.um0.ON_RESUME
            r4.d(r5)
            android.view.View r4 = r1.L
            if (r4 == 0) goto L75
            o60 r4 = r1.U
            androidx.lifecycle.a r4 = r4.h
            r4.d(r5)
        L75:
            h60 r4 = r1.A
            r4.A = r3
            r4.B = r3
            j60 r5 = r4.H
            r5.h = r3
            r4.s(r0)
            q11 r0 = r6.a
            r0.w(r3)
            r1.h = r2
            r1.i = r2
            r1.j = r2
            return
        L8e:
            ok1 r0 = new ok1
            java.lang.String r2 = "Fragment "
            java.lang.String r3 = " did not call through to super.onResume()"
            java.lang.String r1 = defpackage.uo.g(r2, r1, r3)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.a.n():void");
    }

    public final void o() {
        w50 w50Var = this.c;
        if (w50Var.L == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        w50Var.L.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            w50Var.i = sparseArray;
        }
        Bundle bundle = new Bundle();
        w50Var.U.i.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        w50Var.j = bundle;
    }

    public final void p() {
        boolean zE = h60.E(3);
        w50 w50Var = this.c;
        if (zE) {
            Objects.toString(w50Var);
        }
        w50Var.A.J();
        w50Var.A.x(true);
        w50Var.g = 5;
        w50Var.J = false;
        w50Var.H();
        if (!w50Var.J) {
            throw new ok1(uo.g("Fragment ", w50Var, " did not call through to super.onStart()"));
        }
        androidx.lifecycle.a aVar = w50Var.T;
        um0 um0Var = um0.ON_START;
        aVar.d(um0Var);
        if (w50Var.L != null) {
            w50Var.U.h.d(um0Var);
        }
        h60 h60Var = w50Var.A;
        h60Var.A = false;
        h60Var.B = false;
        h60Var.H.h = false;
        h60Var.s(5);
        this.a.y(false);
    }

    public final void q() {
        boolean zE = h60.E(3);
        w50 w50Var = this.c;
        if (zE) {
            Objects.toString(w50Var);
        }
        h60 h60Var = w50Var.A;
        h60Var.B = true;
        h60Var.H.h = true;
        h60Var.s(4);
        if (w50Var.L != null) {
            w50Var.U.b(um0.ON_STOP);
        }
        w50Var.T.d(um0.ON_STOP);
        w50Var.g = 4;
        w50Var.J = false;
        w50Var.I();
        if (!w50Var.J) {
            throw new ok1(uo.g("Fragment ", w50Var, " did not call through to super.onStop()"));
        }
        this.a.z(false);
    }

    public a(q11 q11Var, wb2 wb2Var, ClassLoader classLoader, c60 c60Var, m60 m60Var) {
        this.a = q11Var;
        this.b = wb2Var;
        w50 w50VarA = c60Var.a(m60Var.g);
        this.c = w50VarA;
        Bundle bundle = m60Var.p;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        w50VarA.Q(bundle);
        w50VarA.l = m60Var.h;
        w50VarA.t = m60Var.i;
        w50VarA.v = true;
        w50VarA.C = m60Var.j;
        w50VarA.D = m60Var.k;
        w50VarA.E = m60Var.l;
        w50VarA.H = m60Var.m;
        w50VarA.s = m60Var.n;
        w50VarA.G = m60Var.o;
        w50VarA.F = m60Var.q;
        w50VarA.S = vm0.values()[m60Var.r];
        Bundle bundle2 = m60Var.s;
        if (bundle2 != null) {
            w50VarA.h = bundle2;
        } else {
            w50VarA.h = new Bundle();
        }
        if (h60.E(2)) {
            Objects.toString(w50VarA);
        }
    }

    public a(q11 q11Var, wb2 wb2Var, w50 w50Var, m60 m60Var) {
        this.a = q11Var;
        this.b = wb2Var;
        this.c = w50Var;
        w50Var.i = null;
        w50Var.j = null;
        w50Var.x = 0;
        w50Var.u = false;
        w50Var.r = false;
        w50 w50Var2 = w50Var.n;
        w50Var.o = w50Var2 != null ? w50Var2.l : null;
        w50Var.n = null;
        Bundle bundle = m60Var.s;
        if (bundle != null) {
            w50Var.h = bundle;
        } else {
            w50Var.h = new Bundle();
        }
    }
}
