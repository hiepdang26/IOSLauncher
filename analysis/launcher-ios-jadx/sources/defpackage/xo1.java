package defpackage;

import android.animation.Animator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class xo1 implements Cloneable {
    public ArrayList q;
    public ArrayList r;
    public static final int[] z = {2, 1, 3, 4};
    public static final b21 A = new b21(5);
    public static final ThreadLocal B = new ThreadLocal();
    public final String g = getClass().getName();
    public long h = -1;
    public long i = -1;
    public LinearInterpolator j = null;
    public final ArrayList k = new ArrayList();
    public final ArrayList l = new ArrayList();
    public qm0 m = new qm0(4);
    public qm0 n = new qm0(4);
    public ba o = null;
    public final int[] p = z;
    public final ArrayList s = new ArrayList();
    public int t = 0;
    public boolean u = false;
    public boolean v = false;
    public ArrayList w = null;
    public ArrayList x = new ArrayList();
    public b21 y = A;

    public static void b(qm0 qm0Var, View view, fp1 fp1Var) {
        ((e9) qm0Var.a).put(view, fp1Var);
        int id = view.getId();
        if (id >= 0) {
            SparseArray sparseArray = (SparseArray) qm0Var.b;
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        WeakHashMap weakHashMap = qs1.a;
        String strG = hs1.g(view);
        if (strG != null) {
            e9 e9Var = (e9) qm0Var.d;
            if (e9Var.containsKey(strG)) {
                e9Var.put(strG, null);
            } else {
                e9Var.put(strG, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                xp0 xp0Var = (xp0) qm0Var.c;
                if (xp0Var.g) {
                    int i = xp0Var.j;
                    long[] jArr = xp0Var.h;
                    Object[] objArr = xp0Var.i;
                    int i2 = 0;
                    for (int i3 = 0; i3 < i; i3++) {
                        Object obj = objArr[i3];
                        if (obj != z71.c) {
                            if (i3 != i2) {
                                jArr[i2] = jArr[i3];
                                objArr[i2] = obj;
                                objArr[i3] = null;
                            }
                            i2++;
                        }
                    }
                    xp0Var.g = false;
                    xp0Var.j = i2;
                }
                if (z71.e(xp0Var.h, xp0Var.j, itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    xp0Var.g(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) xp0Var.d(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    xp0Var.g(itemIdAtPosition, null);
                }
            }
        }
    }

    public static e9 n() {
        ThreadLocal threadLocal = B;
        e9 e9Var = (e9) threadLocal.get();
        if (e9Var != null) {
            return e9Var;
        }
        e9 e9Var2 = new e9(0);
        threadLocal.set(e9Var2);
        return e9Var2;
    }

    public static boolean s(fp1 fp1Var, fp1 fp1Var2, String str) {
        Object obj = fp1Var.a.get(str);
        Object obj2 = fp1Var2.a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public void A(b21 b21Var) {
        if (b21Var == null) {
            this.y = A;
        } else {
            this.y = b21Var;
        }
    }

    public void C(long j) {
        this.h = j;
    }

    public final void D() {
        if (this.t == 0) {
            ArrayList arrayList = this.w;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.w.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((vo1) arrayList2.get(i)).a(this);
                }
            }
            this.v = false;
        }
        this.t++;
    }

    public String E(String str) {
        StringBuilder sbM = uo.m(str);
        sbM.append(getClass().getSimpleName());
        sbM.append("@");
        sbM.append(Integer.toHexString(hashCode()));
        sbM.append(": ");
        String string = sbM.toString();
        if (this.i != -1) {
            StringBuilder sbM2 = k31.m(string, "dur(");
            sbM2.append(this.i);
            sbM2.append(") ");
            string = sbM2.toString();
        }
        if (this.h != -1) {
            StringBuilder sbM3 = k31.m(string, "dly(");
            sbM3.append(this.h);
            sbM3.append(") ");
            string = sbM3.toString();
        }
        if (this.j != null) {
            StringBuilder sbM4 = k31.m(string, "interp(");
            sbM4.append(this.j);
            sbM4.append(") ");
            string = sbM4.toString();
        }
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        ArrayList arrayList2 = this.l;
        if (size <= 0 && arrayList2.size() <= 0) {
            return string;
        }
        String strH = uo.h(string, "tgts(");
        if (arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (i > 0) {
                    strH = uo.h(strH, ", ");
                }
                StringBuilder sbM5 = uo.m(strH);
                sbM5.append(arrayList.get(i));
                strH = sbM5.toString();
            }
        }
        if (arrayList2.size() > 0) {
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                if (i2 > 0) {
                    strH = uo.h(strH, ", ");
                }
                StringBuilder sbM6 = uo.m(strH);
                sbM6.append(arrayList2.get(i2));
                strH = sbM6.toString();
            }
        }
        return uo.h(strH, ")");
    }

    public void a(vo1 vo1Var) {
        if (this.w == null) {
            this.w = new ArrayList();
        }
        this.w.add(vo1Var);
    }

    public abstract void c(fp1 fp1Var);

    public void cancel() {
        ArrayList arrayList = this.s;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((Animator) arrayList.get(size)).cancel();
        }
        ArrayList arrayList2 = this.w;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        ArrayList arrayList3 = (ArrayList) this.w.clone();
        int size2 = arrayList3.size();
        for (int i = 0; i < size2; i++) {
            ((vo1) arrayList3.get(i)).e();
        }
    }

    public final void d(View view, boolean z2) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            fp1 fp1Var = new fp1(view);
            if (z2) {
                f(fp1Var);
            } else {
                c(fp1Var);
            }
            fp1Var.c.add(this);
            e(fp1Var);
            if (z2) {
                b(this.m, view, fp1Var);
            } else {
                b(this.n, view, fp1Var);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                d(viewGroup.getChildAt(i), z2);
            }
        }
    }

    public abstract void f(fp1 fp1Var);

    public final void g(ViewGroup viewGroup, boolean z2) {
        h(z2);
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        ArrayList arrayList2 = this.l;
        if (size <= 0 && arrayList2.size() <= 0) {
            d(viewGroup, z2);
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            View viewFindViewById = viewGroup.findViewById(((Integer) arrayList.get(i)).intValue());
            if (viewFindViewById != null) {
                fp1 fp1Var = new fp1(viewFindViewById);
                if (z2) {
                    f(fp1Var);
                } else {
                    c(fp1Var);
                }
                fp1Var.c.add(this);
                e(fp1Var);
                if (z2) {
                    b(this.m, viewFindViewById, fp1Var);
                } else {
                    b(this.n, viewFindViewById, fp1Var);
                }
            }
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            View view = (View) arrayList2.get(i2);
            fp1 fp1Var2 = new fp1(view);
            if (z2) {
                f(fp1Var2);
            } else {
                c(fp1Var2);
            }
            fp1Var2.c.add(this);
            e(fp1Var2);
            if (z2) {
                b(this.m, view, fp1Var2);
            } else {
                b(this.n, view, fp1Var2);
            }
        }
    }

    public final void h(boolean z2) {
        if (z2) {
            ((e9) this.m.a).clear();
            ((SparseArray) this.m.b).clear();
            ((xp0) this.m.c).b();
        } else {
            ((e9) this.n.a).clear();
            ((SparseArray) this.n.b).clear();
            ((xp0) this.n.c).b();
        }
    }

    @Override // 
    /* JADX INFO: renamed from: i */
    public xo1 clone() {
        try {
            xo1 xo1Var = (xo1) super.clone();
            xo1Var.x = new ArrayList();
            xo1Var.m = new qm0(4);
            xo1Var.n = new qm0(4);
            xo1Var.q = null;
            xo1Var.r = null;
            return xo1Var;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator j(ViewGroup viewGroup, fp1 fp1Var, fp1 fp1Var2) {
        return null;
    }

    public void k(ViewGroup viewGroup, qm0 qm0Var, qm0 qm0Var2, ArrayList arrayList, ArrayList arrayList2) {
        Animator animatorJ;
        int i;
        int i2;
        View view;
        fp1 fp1Var;
        Animator animator;
        fp1 fp1Var2;
        e9 e9VarN = n();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            fp1 fp1Var3 = (fp1) arrayList.get(i3);
            fp1 fp1Var4 = (fp1) arrayList2.get(i3);
            if (fp1Var3 != null && !fp1Var3.c.contains(this)) {
                fp1Var3 = null;
            }
            if (fp1Var4 != null && !fp1Var4.c.contains(this)) {
                fp1Var4 = null;
            }
            if (!(fp1Var3 == null && fp1Var4 == null) && ((fp1Var3 == null || fp1Var4 == null || q(fp1Var3, fp1Var4)) && (animatorJ = j(viewGroup, fp1Var3, fp1Var4)) != null)) {
                String str = this.g;
                if (fp1Var4 != null) {
                    String[] strArrO = o();
                    view = fp1Var4.b;
                    if (strArrO != null && strArrO.length > 0) {
                        fp1Var2 = new fp1(view);
                        fp1 fp1Var5 = (fp1) ((e9) qm0Var2.a).get(view);
                        i = size;
                        if (fp1Var5 != null) {
                            int i4 = 0;
                            while (i4 < strArrO.length) {
                                HashMap map = fp1Var2.a;
                                int i5 = i3;
                                String str2 = strArrO[i4];
                                map.put(str2, fp1Var5.a.get(str2));
                                i4++;
                                i3 = i5;
                            }
                        }
                        i2 = i3;
                        int i6 = e9VarN.i;
                        int i7 = 0;
                        while (true) {
                            if (i7 >= i6) {
                                animator = animatorJ;
                                break;
                            }
                            uo1 uo1Var = (uo1) e9VarN.get((Animator) e9VarN.f(i7));
                            if (uo1Var.c != null && uo1Var.a == view && uo1Var.b.equals(str) && uo1Var.c.equals(fp1Var2)) {
                                animator = null;
                                break;
                            }
                            i7++;
                        }
                    } else {
                        i = size;
                        i2 = i3;
                        animator = animatorJ;
                        fp1Var2 = null;
                    }
                    animatorJ = animator;
                    fp1Var = fp1Var2;
                } else {
                    i = size;
                    i2 = i3;
                    view = fp1Var3.b;
                    fp1Var = null;
                }
                if (animatorJ != null) {
                    qu1 qu1Var = pu1.a;
                    vx1 vx1Var = new vx1(viewGroup);
                    uo1 uo1Var2 = new uo1();
                    uo1Var2.a = view;
                    uo1Var2.b = str;
                    uo1Var2.c = fp1Var;
                    uo1Var2.d = vx1Var;
                    uo1Var2.e = this;
                    e9VarN.put(animatorJ, uo1Var2);
                    this.x.add(animatorJ);
                }
            } else {
                i = size;
                i2 = i3;
            }
            i3 = i2 + 1;
            size = i;
        }
        if (sparseIntArray.size() != 0) {
            for (int i8 = 0; i8 < sparseIntArray.size(); i8++) {
                Animator animator2 = (Animator) this.x.get(sparseIntArray.keyAt(i8));
                animator2.setStartDelay(animator2.getStartDelay() + (((long) sparseIntArray.valueAt(i8)) - Long.MAX_VALUE));
            }
        }
    }

    public final void l() {
        int i = this.t - 1;
        this.t = i;
        if (i == 0) {
            ArrayList arrayList = this.w;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.w.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((vo1) arrayList2.get(i2)).d(this);
                }
            }
            for (int i3 = 0; i3 < ((xp0) this.m.c).h(); i3++) {
                View view = (View) ((xp0) this.m.c).i(i3);
                if (view != null) {
                    WeakHashMap weakHashMap = qs1.a;
                    view.setHasTransientState(false);
                }
            }
            for (int i4 = 0; i4 < ((xp0) this.n.c).h(); i4++) {
                View view2 = (View) ((xp0) this.n.c).i(i4);
                if (view2 != null) {
                    WeakHashMap weakHashMap2 = qs1.a;
                    view2.setHasTransientState(false);
                }
            }
            this.v = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        if (r2 < 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        if (r6 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:
    
        r5 = r4.r;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0033, code lost:
    
        r5 = r4.q;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003b, code lost:
    
        return (defpackage.fp1) r5.get(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.fp1 m(android.view.View r5, boolean r6) {
        /*
            r4 = this;
            ba r0 = r4.o
            if (r0 == 0) goto L9
            fp1 r5 = r0.m(r5, r6)
            return r5
        L9:
            if (r6 == 0) goto Le
            java.util.ArrayList r0 = r4.q
            goto L10
        Le:
            java.util.ArrayList r0 = r4.r
        L10:
            if (r0 != 0) goto L13
            goto L3c
        L13:
            int r1 = r0.size()
            r2 = 0
        L18:
            if (r2 >= r1) goto L2b
            java.lang.Object r3 = r0.get(r2)
            fp1 r3 = (defpackage.fp1) r3
            if (r3 != 0) goto L23
            goto L3c
        L23:
            android.view.View r3 = r3.b
            if (r3 != r5) goto L28
            goto L2c
        L28:
            int r2 = r2 + 1
            goto L18
        L2b:
            r2 = -1
        L2c:
            if (r2 < 0) goto L3c
            if (r6 == 0) goto L33
            java.util.ArrayList r5 = r4.r
            goto L35
        L33:
            java.util.ArrayList r5 = r4.q
        L35:
            java.lang.Object r5 = r5.get(r2)
            fp1 r5 = (defpackage.fp1) r5
            return r5
        L3c:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xo1.m(android.view.View, boolean):fp1");
    }

    public String[] o() {
        return null;
    }

    public final fp1 p(View view, boolean z2) {
        ba baVar = this.o;
        if (baVar != null) {
            return baVar.p(view, z2);
        }
        return (fp1) ((e9) (z2 ? this.m : this.n).a).get(view);
    }

    public boolean q(fp1 fp1Var, fp1 fp1Var2) {
        if (fp1Var != null && fp1Var2 != null) {
            String[] strArrO = o();
            if (strArrO != null) {
                for (String str : strArrO) {
                    if (s(fp1Var, fp1Var2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator it = fp1Var.a.keySet().iterator();
                while (it.hasNext()) {
                    if (s(fp1Var, fp1Var2, (String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean r(View view) {
        int id = view.getId();
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        ArrayList arrayList2 = this.l;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id)) || arrayList2.contains(view);
    }

    public void t(ViewGroup viewGroup) {
        if (this.v) {
            return;
        }
        ArrayList arrayList = this.s;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((Animator) arrayList.get(size)).pause();
        }
        ArrayList arrayList2 = this.w;
        if (arrayList2 != null && arrayList2.size() > 0) {
            ArrayList arrayList3 = (ArrayList) this.w.clone();
            int size2 = arrayList3.size();
            for (int i = 0; i < size2; i++) {
                ((vo1) arrayList3.get(i)).b();
            }
        }
        this.u = true;
    }

    public final String toString() {
        return E("");
    }

    public void u(vo1 vo1Var) {
        ArrayList arrayList = this.w;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(vo1Var);
        if (this.w.size() == 0) {
            this.w = null;
        }
    }

    public void v(View view) {
        if (this.u) {
            if (!this.v) {
                ArrayList arrayList = this.s;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((Animator) arrayList.get(size)).resume();
                }
                ArrayList arrayList2 = this.w;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    ArrayList arrayList3 = (ArrayList) this.w.clone();
                    int size2 = arrayList3.size();
                    for (int i = 0; i < size2; i++) {
                        ((vo1) arrayList3.get(i)).c();
                    }
                }
            }
            this.u = false;
        }
    }

    public void w() {
        D();
        e9 e9VarN = n();
        ArrayList arrayList = this.x;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Animator animator = (Animator) obj;
            if (e9VarN.containsKey(animator)) {
                D();
                if (animator != null) {
                    animator.addListener(new um(this, e9VarN, 6));
                    long j = this.i;
                    if (j >= 0) {
                        animator.setDuration(j);
                    }
                    long j2 = this.h;
                    if (j2 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j2);
                    }
                    LinearInterpolator linearInterpolator = this.j;
                    if (linearInterpolator != null) {
                        animator.setInterpolator(linearInterpolator);
                    }
                    animator.addListener(new be(this, 18));
                    animator.start();
                }
            }
        }
        this.x.clear();
        l();
    }

    public void x(long j) {
        this.i = j;
    }

    public void z(LinearInterpolator linearInterpolator) {
        this.j = linearInterpolator;
    }

    public void B() {
    }

    public void e(fp1 fp1Var) {
    }

    public void y(bf1 bf1Var) {
    }
}
