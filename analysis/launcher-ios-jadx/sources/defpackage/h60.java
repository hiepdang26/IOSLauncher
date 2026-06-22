package defpackage;

import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.b;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class h60 {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public ArrayList E;
    public ArrayList F;
    public ArrayList G;
    public j60 H;
    public final o1 I;
    public boolean b;
    public ArrayList d;
    public ArrayList e;
    public b g;
    public final q11 m;
    public final CopyOnWriteArrayList n;
    public int o;
    public x50 p;
    public wd q;
    public w50 r;
    public w50 s;
    public final c60 t;
    public final iy u;
    public d2 v;
    public d2 w;
    public d2 x;
    public ArrayDeque y;
    public boolean z;
    public final ArrayList a = new ArrayList();
    public final wb2 c = new wb2(14);
    public final a60 f = new a60(this);
    public final b60 h = new b60(this);
    public final AtomicInteger i = new AtomicInteger();
    public final Map j = Collections.synchronizedMap(new HashMap());
    public final Map k = Collections.synchronizedMap(new HashMap());
    public final Map l = Collections.synchronizedMap(new HashMap());

    public h60() {
        new jl1(this);
        this.m = new q11(this);
        this.n = new CopyOnWriteArrayList();
        this.o = -1;
        this.t = new c60(this);
        this.u = new iy();
        this.y = new ArrayDeque();
        this.I = new o1(this, 24);
    }

    public static boolean E(int i) {
        return Log.isLoggable("FragmentManager", i);
    }

    public static boolean F(w50 w50Var) {
        w50Var.getClass();
        wb2 wb2Var = w50Var.A.c;
        wb2Var.getClass();
        ArrayList arrayList = new ArrayList();
        for (a aVar : ((HashMap) wb2Var.i).values()) {
            if (aVar != null) {
                arrayList.add(aVar.c);
            } else {
                arrayList.add(null);
            }
        }
        int size = arrayList.size();
        boolean zF = false;
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            w50 w50Var2 = (w50) obj;
            if (w50Var2 != null) {
                zF = F(w50Var2);
            }
            if (zF) {
                return true;
            }
        }
        return false;
    }

    public static boolean G(w50 w50Var) {
        if (w50Var == null) {
            return true;
        }
        if (w50Var.I) {
            return w50Var.y == null || G(w50Var.B);
        }
        return false;
    }

    public static boolean H(w50 w50Var) {
        if (w50Var == null) {
            return true;
        }
        h60 h60Var = w50Var.y;
        return w50Var.equals(h60Var.s) && H(h60Var.r);
    }

    public final w50 A(String str) {
        wb2 wb2Var = this.c;
        if (str != null) {
            ArrayList arrayList = (ArrayList) wb2Var.h;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                w50 w50Var = (w50) arrayList.get(size);
                if (w50Var != null && str.equals(w50Var.E)) {
                    return w50Var;
                }
            }
        }
        if (str == null) {
            wb2Var.getClass();
            return null;
        }
        for (a aVar : ((HashMap) wb2Var.i).values()) {
            if (aVar != null) {
                w50 w50Var2 = aVar.c;
                if (str.equals(w50Var2.E)) {
                    return w50Var2;
                }
            }
        }
        return null;
    }

    public final ViewGroup B(w50 w50Var) {
        ViewGroup viewGroup = w50Var.K;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (w50Var.D <= 0 || !this.q.x()) {
            return null;
        }
        View viewW = this.q.w(w50Var.D);
        if (viewW instanceof ViewGroup) {
            return (ViewGroup) viewW;
        }
        return null;
    }

    public final c60 C() {
        w50 w50Var = this.r;
        return w50Var != null ? w50Var.y.C() : this.t;
    }

    public final iy D() {
        w50 w50Var = this.r;
        return w50Var != null ? w50Var.y.D() : this.u;
    }

    public final void I(int i, boolean z) {
        HashMap map;
        x50 x50Var;
        if (this.p == null && i != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.o) {
            this.o = i;
            wb2 wb2Var = this.c;
            ArrayList arrayList = (ArrayList) wb2Var.h;
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                map = (HashMap) wb2Var.i;
                if (i2 >= size) {
                    break;
                }
                Object obj = arrayList.get(i2);
                i2++;
                a aVar = (a) map.get(((w50) obj).l);
                if (aVar != null) {
                    aVar.k();
                }
            }
            for (a aVar2 : map.values()) {
                if (aVar2 != null) {
                    aVar2.k();
                    w50 w50Var = aVar2.c;
                    if (w50Var.s && w50Var.x <= 0) {
                        wb2Var.w(aVar2);
                    }
                }
            }
            V();
            if (this.z && (x50Var = this.p) != null && this.o == 7) {
                x50Var.F.n().a();
                this.z = false;
            }
        }
    }

    public final void J() {
        if (this.p == null) {
            return;
        }
        this.A = false;
        this.B = false;
        this.H.h = false;
        for (w50 w50Var : this.c.t()) {
            if (w50Var != null) {
                w50Var.A.J();
            }
        }
    }

    public final boolean K() {
        x(false);
        w(true);
        w50 w50Var = this.s;
        if (w50Var != null && w50Var.o().K()) {
            return true;
        }
        boolean zL = L(this.E, this.F, -1, 0);
        if (zL) {
            this.b = true;
            try {
                N(this.E, this.F);
            } finally {
                d();
            }
        }
        W();
        t();
        ((HashMap) this.c.i).values().removeAll(Collections.singleton(null));
        return zL;
    }

    public final boolean L(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        int size;
        ca caVar;
        ArrayList arrayList3 = this.d;
        if (arrayList3 == null) {
            return false;
        }
        if (i < 0 && (i2 & 1) == 0) {
            int size2 = arrayList3.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.d.remove(size2));
            arrayList2.add(Boolean.TRUE);
            return true;
        }
        if (i >= 0) {
            size = arrayList3.size() - 1;
            while (size >= 0) {
                ca caVar2 = (ca) this.d.get(size);
                if (i >= 0 && i == caVar2.s) {
                    break;
                }
                size--;
            }
            if (size < 0) {
                return false;
            }
            if ((i2 & 1) != 0) {
                do {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    caVar = (ca) this.d.get(size);
                    if (i < 0) {
                        break;
                    }
                } while (i == caVar.s);
            }
        } else {
            size = -1;
        }
        if (size == this.d.size() - 1) {
            return false;
        }
        for (int size3 = this.d.size() - 1; size3 > size; size3--) {
            arrayList.add(this.d.remove(size3));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void M(w50 w50Var) {
        if (E(2)) {
            Objects.toString(w50Var);
        }
        boolean z = w50Var.x > 0;
        if (w50Var.G && z) {
            return;
        }
        wb2 wb2Var = this.c;
        synchronized (((ArrayList) wb2Var.h)) {
            ((ArrayList) wb2Var.h).remove(w50Var);
        }
        w50Var.r = false;
        if (F(w50Var)) {
            this.z = true;
        }
        w50Var.s = true;
        U(w50Var);
    }

    public final void N(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!((ca) arrayList.get(i)).p) {
                if (i2 != i) {
                    y(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                    while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((ca) arrayList.get(i2)).p) {
                        i2++;
                    }
                }
                y(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            y(arrayList, arrayList2, i2, size);
        }
    }

    public final void O(Parcelable parcelable) {
        int i;
        q11 q11Var;
        a aVar;
        if (parcelable == null) {
            return;
        }
        i60 i60Var = (i60) parcelable;
        if (i60Var.g == null) {
            return;
        }
        wb2 wb2Var = this.c;
        ((HashMap) wb2Var.i).clear();
        ArrayList arrayList = i60Var.g;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            i = 2;
            q11Var = this.m;
            if (i2 >= size) {
                break;
            }
            Object obj = arrayList.get(i2);
            i2++;
            m60 m60Var = (m60) obj;
            if (m60Var != null) {
                w50 w50Var = (w50) this.H.c.get(m60Var.h);
                if (w50Var != null) {
                    if (E(2)) {
                        w50Var.toString();
                    }
                    aVar = new a(q11Var, wb2Var, w50Var, m60Var);
                } else {
                    aVar = new a(this.m, this.c, this.p.C.getClassLoader(), C(), m60Var);
                }
                w50 w50Var2 = aVar.c;
                w50Var2.y = this;
                if (E(2)) {
                    w50Var2.toString();
                }
                aVar.m(this.p.C.getClassLoader());
                wb2Var.v(aVar);
                aVar.e = this.o;
            }
        }
        j60 j60Var = this.H;
        j60Var.getClass();
        ArrayList arrayList2 = new ArrayList(j60Var.c.values());
        int size2 = arrayList2.size();
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayList2.get(i3);
            i3++;
            w50 w50Var3 = (w50) obj2;
            if (!(((HashMap) wb2Var.i).get(w50Var3.l) != null)) {
                if (E(2)) {
                    w50Var3.toString();
                    Objects.toString(i60Var.g);
                }
                this.H.b(w50Var3);
                w50Var3.y = this;
                a aVar2 = new a(q11Var, wb2Var, w50Var3);
                aVar2.e = 1;
                aVar2.k();
                w50Var3.s = true;
                aVar2.k();
            }
        }
        ArrayList arrayList3 = i60Var.h;
        ((ArrayList) wb2Var.h).clear();
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            int i4 = 0;
            while (i4 < size3) {
                Object obj3 = arrayList3.get(i4);
                i4++;
                String str = (String) obj3;
                w50 w50VarQ = wb2Var.q(str);
                if (w50VarQ == null) {
                    throw new IllegalStateException(uo.t("No instantiated fragment for (", str, ")"));
                }
                if (E(2)) {
                    w50VarQ.toString();
                }
                wb2Var.i(w50VarQ);
            }
        }
        if (i60Var.i != null) {
            this.d = new ArrayList(i60Var.i.length);
            int i5 = 0;
            while (true) {
                da[] daVarArr = i60Var.i;
                if (i5 >= daVarArr.length) {
                    break;
                }
                da daVar = daVarArr[i5];
                daVar.getClass();
                ca caVar = new ca(this);
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    int[] iArr = daVar.g;
                    if (i6 >= iArr.length) {
                        break;
                    }
                    n60 n60Var = new n60();
                    int i8 = i6 + 1;
                    n60Var.a = iArr[i6];
                    if (E(i)) {
                        caVar.toString();
                        int i9 = iArr[i8];
                    }
                    String str2 = (String) daVar.h.get(i7);
                    if (str2 != null) {
                        n60Var.b = wb2Var.q(str2);
                    } else {
                        n60Var.b = null;
                    }
                    n60Var.g = vm0.values()[daVar.i[i7]];
                    n60Var.h = vm0.values()[daVar.j[i7]];
                    int i10 = iArr[i8];
                    n60Var.c = i10;
                    int i11 = iArr[i6 + 2];
                    n60Var.d = i11;
                    int i12 = i6 + 4;
                    int i13 = iArr[i6 + 3];
                    n60Var.e = i13;
                    i6 += 5;
                    int i14 = iArr[i12];
                    n60Var.f = i14;
                    caVar.b = i10;
                    caVar.c = i11;
                    caVar.d = i13;
                    caVar.e = i14;
                    caVar.b(n60Var);
                    i7++;
                    i = 2;
                }
                caVar.f = daVar.k;
                caVar.i = daVar.l;
                caVar.s = daVar.m;
                caVar.g = true;
                caVar.j = daVar.n;
                caVar.k = daVar.o;
                caVar.l = daVar.p;
                caVar.m = daVar.q;
                caVar.n = daVar.r;
                caVar.o = daVar.s;
                caVar.p = daVar.t;
                caVar.c(1);
                if (E(2)) {
                    caVar.toString();
                    PrintWriter printWriter = new PrintWriter(new up0());
                    caVar.f("  ", printWriter, false);
                    printWriter.close();
                }
                this.d.add(caVar);
                i5++;
                i = 2;
            }
        } else {
            this.d = null;
        }
        this.i.set(i60Var.j);
        String str3 = i60Var.k;
        if (str3 != null) {
            w50 w50VarQ2 = wb2Var.q(str3);
            this.s = w50VarQ2;
            p(w50VarQ2);
        }
        ArrayList arrayList4 = i60Var.l;
        if (arrayList4 != null) {
            for (int i15 = 0; i15 < arrayList4.size(); i15++) {
                Bundle bundle = (Bundle) i60Var.m.get(i15);
                bundle.setClassLoader(this.p.C.getClassLoader());
                this.j.put(arrayList4.get(i15), bundle);
            }
        }
        this.y = new ArrayDeque(i60Var.n);
    }

    public final i60 P() {
        int i;
        ArrayList arrayList;
        da[] daVarArr;
        int size;
        Iterator it = e().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            cu cuVar = (cu) it.next();
            if (cuVar.e) {
                cuVar.e = false;
                cuVar.c();
            }
        }
        Iterator it2 = e().iterator();
        while (it2.hasNext()) {
            ((cu) it2.next()).e();
        }
        x(true);
        this.A = true;
        this.H.h = true;
        wb2 wb2Var = this.c;
        wb2Var.getClass();
        HashMap map = (HashMap) wb2Var.i;
        ArrayList arrayList2 = new ArrayList(map.size());
        Iterator it3 = map.values().iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            a aVar = (a) it3.next();
            if (aVar != null) {
                w50 w50Var = aVar.c;
                m60 m60Var = new m60(w50Var);
                if (w50Var.g <= -1 || m60Var.s != null) {
                    m60Var.s = w50Var.h;
                } else {
                    Bundle bundle = new Bundle();
                    w50Var.G(bundle);
                    w50Var.W.e(bundle);
                    i60 i60VarP = w50Var.A.P();
                    if (i60VarP != null) {
                        bundle.putParcelable("android:support:fragments", i60VarP);
                    }
                    aVar.a.x(false);
                    Bundle bundle2 = bundle.isEmpty() ? null : bundle;
                    if (w50Var.L != null) {
                        aVar.o();
                    }
                    if (w50Var.i != null) {
                        if (bundle2 == null) {
                            bundle2 = new Bundle();
                        }
                        bundle2.putSparseParcelableArray("android:view_state", w50Var.i);
                    }
                    if (w50Var.j != null) {
                        if (bundle2 == null) {
                            bundle2 = new Bundle();
                        }
                        bundle2.putBundle("android:view_registry_state", w50Var.j);
                    }
                    if (!w50Var.N) {
                        if (bundle2 == null) {
                            bundle2 = new Bundle();
                        }
                        bundle2.putBoolean("android:user_visible_hint", w50Var.N);
                    }
                    m60Var.s = bundle2;
                    if (w50Var.o != null) {
                        if (bundle2 == null) {
                            m60Var.s = new Bundle();
                        }
                        m60Var.s.putString("android:target_state", w50Var.o);
                        int i2 = w50Var.p;
                        if (i2 != 0) {
                            m60Var.s.putInt("android:target_req_state", i2);
                        }
                    }
                }
                arrayList2.add(m60Var);
                if (E(2)) {
                    Objects.toString(w50Var);
                    Objects.toString(m60Var.s);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            E(2);
            return null;
        }
        wb2 wb2Var2 = this.c;
        synchronized (((ArrayList) wb2Var2.h)) {
            try {
                if (((ArrayList) wb2Var2.h).isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(((ArrayList) wb2Var2.h).size());
                    ArrayList arrayList3 = (ArrayList) wb2Var2.h;
                    int size2 = arrayList3.size();
                    int i3 = 0;
                    while (i3 < size2) {
                        Object obj = arrayList3.get(i3);
                        i3++;
                        w50 w50Var2 = (w50) obj;
                        arrayList.add(w50Var2.l);
                        if (E(2)) {
                            w50Var2.toString();
                        }
                    }
                }
            } finally {
            }
        }
        ArrayList arrayList4 = this.d;
        if (arrayList4 == null || (size = arrayList4.size()) <= 0) {
            daVarArr = null;
        } else {
            daVarArr = new da[size];
            for (i = 0; i < size; i++) {
                daVarArr[i] = new da((ca) this.d.get(i));
                if (E(2)) {
                    Objects.toString(this.d.get(i));
                }
            }
        }
        i60 i60Var = new i60();
        i60Var.k = null;
        ArrayList arrayList5 = new ArrayList();
        i60Var.l = arrayList5;
        ArrayList arrayList6 = new ArrayList();
        i60Var.m = arrayList6;
        i60Var.g = arrayList2;
        i60Var.h = arrayList;
        i60Var.i = daVarArr;
        i60Var.j = this.i.get();
        w50 w50Var3 = this.s;
        if (w50Var3 != null) {
            i60Var.k = w50Var3.l;
        }
        arrayList5.addAll(this.j.keySet());
        arrayList6.addAll(this.j.values());
        i60Var.n = new ArrayList(this.y);
        return i60Var;
    }

    public final void Q() {
        synchronized (this.a) {
            try {
                if (this.a.size() == 1) {
                    this.p.D.removeCallbacks(this.I);
                    this.p.D.post(this.I);
                    W();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void R(w50 w50Var, boolean z) {
        ViewGroup viewGroupB = B(w50Var);
        if (viewGroupB == null || !(viewGroupB instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupB).setDrawDisappearingViewsLast(!z);
    }

    public final void S(w50 w50Var, vm0 vm0Var) {
        if (w50Var.equals(this.c.q(w50Var.l)) && (w50Var.z == null || w50Var.y == this)) {
            w50Var.S = vm0Var;
            return;
        }
        throw new IllegalArgumentException("Fragment " + w50Var + " is not an active fragment of FragmentManager " + this);
    }

    public final void T(w50 w50Var) {
        if (w50Var != null) {
            if (!w50Var.equals(this.c.q(w50Var.l)) || (w50Var.z != null && w50Var.y != this)) {
                throw new IllegalArgumentException("Fragment " + w50Var + " is not an active fragment of FragmentManager " + this);
            }
        }
        w50 w50Var2 = this.s;
        this.s = w50Var;
        p(w50Var2);
        p(this.s);
    }

    public final void U(w50 w50Var) {
        ViewGroup viewGroupB = B(w50Var);
        if (viewGroupB != null) {
            v50 v50Var = w50Var.O;
            if ((v50Var == null ? 0 : v50Var.e) + (v50Var == null ? 0 : v50Var.d) + (v50Var == null ? 0 : v50Var.c) + (v50Var == null ? 0 : v50Var.b) > 0) {
                if (viewGroupB.getTag(b61.visible_removing_fragment_view_tag) == null) {
                    viewGroupB.setTag(b61.visible_removing_fragment_view_tag, w50Var);
                }
                w50 w50Var2 = (w50) viewGroupB.getTag(b61.visible_removing_fragment_view_tag);
                v50 v50Var2 = w50Var.O;
                boolean z = v50Var2 != null ? v50Var2.a : false;
                if (w50Var2.O == null) {
                    return;
                }
                w50Var2.g().a = z;
            }
        }
    }

    public final void V() {
        ArrayList arrayListS = this.c.s();
        int size = arrayListS.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListS.get(i);
            i++;
            a aVar = (a) obj;
            w50 w50Var = aVar.c;
            if (w50Var.M) {
                if (this.b) {
                    this.D = true;
                } else {
                    w50Var.M = false;
                    aVar.k();
                }
            }
        }
    }

    public final void W() {
        synchronized (this.a) {
            try {
                if (!this.a.isEmpty()) {
                    this.h.a = true;
                    return;
                }
                b60 b60Var = this.h;
                ArrayList arrayList = this.d;
                b60Var.a = (arrayList != null ? arrayList.size() : 0) > 0 && H(this.r);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final a a(w50 w50Var) {
        if (E(2)) {
            Objects.toString(w50Var);
        }
        a aVarF = f(w50Var);
        w50Var.y = this;
        wb2 wb2Var = this.c;
        wb2Var.v(aVarF);
        if (!w50Var.G) {
            wb2Var.i(w50Var);
            w50Var.s = false;
            if (w50Var.L == null) {
                w50Var.P = false;
            }
            if (F(w50Var)) {
                this.z = true;
            }
        }
        return aVarF;
    }

    public final void b(x50 x50Var, wd wdVar, w50 w50Var) {
        j60 j60Var;
        if (this.p != null) {
            throw new IllegalStateException("Already attached");
        }
        this.p = x50Var;
        this.q = wdVar;
        this.r = w50Var;
        CopyOnWriteArrayList copyOnWriteArrayList = this.n;
        if (w50Var != null) {
            copyOnWriteArrayList.add(new d60(w50Var));
        } else if (x50Var != null) {
            copyOnWriteArrayList.add(x50Var);
        }
        if (this.r != null) {
            W();
        }
        if (x50Var != null) {
            b bVar = x50Var.F.m;
            this.g = bVar;
            bVar.a(w50Var != null ? w50Var : x50Var, this.h);
        }
        if (w50Var != null) {
            j60 j60Var2 = w50Var.y.H;
            HashMap map = j60Var2.d;
            j60 j60Var3 = (j60) map.get(w50Var.l);
            if (j60Var3 == null) {
                j60Var3 = new j60(j60Var2.f);
                map.put(w50Var.l, j60Var3);
            }
            this.H = j60Var3;
        } else if (x50Var != null) {
            ct1 ct1VarJ = x50Var.F.j();
            qg0.l(ct1VarJ, "store");
            mp mpVar = mp.h;
            qg0.l(mpVar, "defaultCreationExtras");
            String canonicalName = j60.class.getCanonicalName();
            if (canonicalName == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            String strConcat = "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName);
            qg0.l(strConcat, "key");
            LinkedHashMap linkedHashMap = ct1VarJ.a;
            at1 at1Var = (at1) linkedHashMap.get(strConcat);
            if (j60.class.isInstance(at1Var)) {
                qg0.i(at1Var, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            } else {
                ((LinkedHashMap) new jv0(mpVar).g).put(jl1.m, strConcat);
                try {
                    j60Var = new j60(true);
                } catch (AbstractMethodError unused) {
                    j60Var = new j60(true);
                }
                at1Var = j60Var;
                at1 at1Var2 = (at1) linkedHashMap.put(strConcat, at1Var);
                if (at1Var2 != null) {
                    at1Var2.a();
                }
            }
            this.H = (j60) at1Var;
        } else {
            this.H = new j60(false);
        }
        j60 j60Var4 = this.H;
        j60Var4.h = this.A || this.B;
        this.c.j = j60Var4;
        x50 x50Var2 = this.p;
        if (x50Var2 != null) {
            e6 e6Var = x50Var2.F;
            String str = "FragmentManager:" + (w50Var != null ? uo.k(new StringBuilder(), w50Var.l, ":") : "");
            String strH = uo.h(str, "StartActivityForResult");
            c2 c2Var = new c2(1);
            nx0 nx0Var = new nx0(this, 15);
            al alVar = e6Var.o;
            this.v = alVar.c(strH, c2Var, nx0Var);
            this.w = alVar.c(uo.h(str, "StartIntentSenderForResult"), new c2(2), new fz1(this, 16));
            this.x = alVar.c(uo.h(str, "RequestPermissions"), new c2(0), new mc1(this, 13));
        }
    }

    public final void c(w50 w50Var) {
        if (E(2)) {
            Objects.toString(w50Var);
        }
        if (w50Var.G) {
            w50Var.G = false;
            if (w50Var.r) {
                return;
            }
            this.c.i(w50Var);
            if (E(2)) {
                w50Var.toString();
            }
            if (F(w50Var)) {
                this.z = true;
            }
        }
    }

    public final void d() {
        this.b = false;
        this.F.clear();
        this.E.clear();
    }

    public final HashSet e() {
        HashSet hashSet = new HashSet();
        ArrayList arrayListS = this.c.s();
        int size = arrayListS.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListS.get(i);
            i++;
            ViewGroup viewGroup = ((a) obj).c.K;
            if (viewGroup != null) {
                hashSet.add(cu.f(viewGroup, D()));
            }
        }
        return hashSet;
    }

    public final a f(w50 w50Var) {
        String str = w50Var.l;
        wb2 wb2Var = this.c;
        a aVar = (a) ((HashMap) wb2Var.i).get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(this.m, wb2Var, w50Var);
        aVar2.m(this.p.C.getClassLoader());
        aVar2.e = this.o;
        return aVar2;
    }

    public final void g(w50 w50Var) {
        if (E(2)) {
            Objects.toString(w50Var);
        }
        if (w50Var.G) {
            return;
        }
        w50Var.G = true;
        if (w50Var.r) {
            if (E(2)) {
                w50Var.toString();
            }
            wb2 wb2Var = this.c;
            synchronized (((ArrayList) wb2Var.h)) {
                ((ArrayList) wb2Var.h).remove(w50Var);
            }
            w50Var.r = false;
            if (F(w50Var)) {
                this.z = true;
            }
            U(w50Var);
        }
    }

    public final void h() {
        for (w50 w50Var : this.c.t()) {
            if (w50Var != null) {
                w50Var.J = true;
                w50Var.A.h();
            }
        }
    }

    public final boolean i() {
        if (this.o >= 1) {
            for (w50 w50Var : this.c.t()) {
                if (w50Var != null) {
                    if (!w50Var.F ? w50Var.A.i() : false) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean j() {
        if (this.o < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (w50 w50Var : this.c.t()) {
            if (w50Var != null && G(w50Var)) {
                if (!w50Var.F ? w50Var.A.j() : false) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(w50Var);
                    z = true;
                }
            }
        }
        if (this.e != null) {
            for (int i = 0; i < this.e.size(); i++) {
                w50 w50Var2 = (w50) this.e.get(i);
                if (arrayList == null || !arrayList.contains(w50Var2)) {
                    w50Var2.getClass();
                }
            }
        }
        this.e = arrayList;
        return z;
    }

    public final void k() {
        this.C = true;
        x(true);
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((cu) it.next()).e();
        }
        s(-1);
        this.p = null;
        this.q = null;
        this.r = null;
        if (this.g != null) {
            Iterator it2 = this.h.b.iterator();
            while (it2.hasNext()) {
                ((eg) it2.next()).cancel();
            }
            this.g = null;
        }
        d2 d2Var = this.v;
        if (d2Var != null) {
            d2Var.o.f(d2Var.n);
            d2 d2Var2 = this.w;
            d2Var2.o.f(d2Var2.n);
            d2 d2Var3 = this.x;
            d2Var3.o.f(d2Var3.n);
        }
    }

    public final void l() {
        for (w50 w50Var : this.c.t()) {
            if (w50Var != null) {
                w50Var.J = true;
                w50Var.A.l();
            }
        }
    }

    public final void m() {
        for (w50 w50Var : this.c.t()) {
            if (w50Var != null) {
                w50Var.A.m();
            }
        }
    }

    public final boolean n() {
        if (this.o >= 1) {
            for (w50 w50Var : this.c.t()) {
                if (w50Var != null) {
                    if (!w50Var.F ? w50Var.A.n() : false) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void o() {
        if (this.o < 1) {
            return;
        }
        for (w50 w50Var : this.c.t()) {
            if (w50Var != null && !w50Var.F) {
                w50Var.A.o();
            }
        }
    }

    public final void p(w50 w50Var) {
        if (w50Var != null) {
            if (w50Var.equals(this.c.q(w50Var.l))) {
                w50Var.y.getClass();
                boolean zH = H(w50Var);
                Boolean bool = w50Var.q;
                if (bool == null || bool.booleanValue() != zH) {
                    w50Var.q = Boolean.valueOf(zH);
                    h60 h60Var = w50Var.A;
                    h60Var.W();
                    h60Var.p(h60Var.s);
                }
            }
        }
    }

    public final void q() {
        for (w50 w50Var : this.c.t()) {
            if (w50Var != null) {
                w50Var.A.q();
            }
        }
    }

    public final boolean r() {
        if (this.o < 1) {
            return false;
        }
        boolean z = false;
        for (w50 w50Var : this.c.t()) {
            if (w50Var != null && G(w50Var)) {
                if (!w50Var.F ? w50Var.A.r() : false) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final void s(int i) {
        try {
            this.b = true;
            for (a aVar : ((HashMap) this.c.i).values()) {
                if (aVar != null) {
                    aVar.e = i;
                }
            }
            I(i, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((cu) it.next()).e();
            }
            this.b = false;
            x(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    public final void t() {
        if (this.D) {
            this.D = false;
            V();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        w50 w50Var = this.r;
        if (w50Var != null) {
            sb.append(w50Var.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.r)));
            sb.append("}");
        } else {
            x50 x50Var = this.p;
            if (x50Var != null) {
                sb.append(x50Var.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.p)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String strH = uo.h(str, "    ");
        wb2 wb2Var = this.c;
        wb2Var.getClass();
        String str2 = str + "    ";
        HashMap map = (HashMap) wb2Var.i;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (a aVar : map.values()) {
                printWriter.print(str);
                if (aVar != null) {
                    w50 w50Var = aVar.c;
                    printWriter.println(w50Var);
                    w50Var.f(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        ArrayList arrayList = (ArrayList) wb2Var.h;
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size3; i++) {
                w50 w50Var2 = (w50) arrayList.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(w50Var2.toString());
            }
        }
        ArrayList arrayList2 = this.e;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                w50 w50Var3 = (w50) this.e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(w50Var3.toString());
            }
        }
        ArrayList arrayList3 = this.d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                ca caVar = (ca) this.d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(caVar.toString());
                caVar.f(strH, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.i.get());
        synchronized (this.a) {
            try {
                int size4 = this.a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size4; i4++) {
                        Object obj = (f60) this.a.get(i4);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.p);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.q);
        if (this.r != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.r);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.o);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.A);
        printWriter.print(" mStopped=");
        printWriter.print(this.B);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.C);
        if (this.z) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.z);
        }
    }

    public final void v(f60 f60Var, boolean z) {
        if (!z) {
            if (this.p == null) {
                if (!this.C) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (this.A || this.B) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.a) {
            try {
                if (this.p == null) {
                    if (!z) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.a.add(f60Var);
                    Q();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void w(boolean z) {
        if (this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.p == null) {
            if (!this.C) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.p.D.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z && (this.A || this.B)) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.E == null) {
            this.E = new ArrayList();
            this.F = new ArrayList();
        }
        this.b = false;
    }

    public final boolean x(boolean z) {
        boolean zA;
        w(z);
        boolean z2 = false;
        while (true) {
            ArrayList arrayList = this.E;
            ArrayList arrayList2 = this.F;
            synchronized (this.a) {
                try {
                    if (this.a.isEmpty()) {
                        zA = false;
                    } else {
                        int size = this.a.size();
                        zA = false;
                        for (int i = 0; i < size; i++) {
                            zA |= ((f60) this.a.get(i)).a(arrayList, arrayList2);
                        }
                        this.a.clear();
                        this.p.D.removeCallbacks(this.I);
                    }
                } finally {
                }
            }
            if (!zA) {
                W();
                t();
                ((HashMap) this.c.i).values().removeAll(Collections.singleton(null));
                return z2;
            }
            z2 = true;
            this.b = true;
            try {
                N(this.E, this.F);
            } finally {
                d();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(java.util.ArrayList r25, java.util.ArrayList r26, int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 1318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h60.y(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    public final w50 z(int i) {
        wb2 wb2Var = this.c;
        ArrayList arrayList = (ArrayList) wb2Var.h;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            w50 w50Var = (w50) arrayList.get(size);
            if (w50Var != null && w50Var.C == i) {
                return w50Var;
            }
        }
        for (a aVar : ((HashMap) wb2Var.i).values()) {
            if (aVar != null) {
                w50 w50Var2 = aVar.c;
                if (w50Var2.C == i) {
                    return w50Var2;
                }
            }
        }
        return null;
    }
}
