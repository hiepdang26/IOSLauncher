package defpackage;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class lt extends r81 {
    public static TimeInterpolator s;
    public final boolean g;
    public final ArrayList h;
    public final ArrayList i;
    public final ArrayList j;
    public final ArrayList k;
    public final ArrayList l;
    public final ArrayList m;
    public final ArrayList n;
    public final ArrayList o;
    public final ArrayList p;
    public final ArrayList q;
    public final ArrayList r;

    public lt() {
        this.a = null;
        this.b = new ArrayList();
        this.c = 120L;
        this.d = 120L;
        this.e = 250L;
        this.f = 250L;
        this.g = true;
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.r = new ArrayList();
    }

    public static void h(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((m91) arrayList.get(size)).g.animate().cancel();
        }
    }

    @Override // defpackage.r81
    public final boolean a(m91 m91Var, m91 m91Var2, ib ibVar, ib ibVar2) {
        int i;
        int i2;
        int i3 = ibVar.a;
        int i4 = ibVar.b;
        if (m91Var2.t()) {
            int i5 = ibVar.a;
            i2 = ibVar.b;
            i = i5;
        } else {
            i = ibVar2.a;
            i2 = ibVar2.b;
        }
        if (m91Var == m91Var2) {
            return g(m91Var, i3, i4, i, i2);
        }
        View view = m91Var.g;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        float alpha = view.getAlpha();
        l(m91Var);
        view.setTranslationX(translationX);
        view.setTranslationY(translationY);
        view.setAlpha(alpha);
        l(m91Var2);
        float f = -((int) ((i - i3) - translationX));
        View view2 = m91Var2.g;
        view2.setTranslationX(f);
        view2.setTranslationY(-((int) ((i2 - i4) - translationY)));
        view2.setAlpha(0.0f);
        ArrayList arrayList = this.k;
        jt jtVar = new jt();
        jtVar.a = m91Var;
        jtVar.b = m91Var2;
        jtVar.c = i3;
        jtVar.d = i4;
        jtVar.e = i;
        jtVar.f = i2;
        arrayList.add(jtVar);
        return true;
    }

    @Override // defpackage.r81
    public final void d(m91 m91Var) {
        View view = m91Var.g;
        view.animate().cancel();
        ArrayList arrayList = this.j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((kt) arrayList.get(size)).a == m91Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                c(m91Var);
                arrayList.remove(size);
            }
        }
        j(this.k, m91Var);
        if (this.h.remove(m91Var)) {
            view.setAlpha(1.0f);
            c(m91Var);
        }
        if (this.i.remove(m91Var)) {
            view.setAlpha(1.0f);
            c(m91Var);
        }
        ArrayList arrayList2 = this.n;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList3 = (ArrayList) arrayList2.get(size2);
            j(arrayList3, m91Var);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList arrayList4 = this.m;
        for (int size3 = arrayList4.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList5 = (ArrayList) arrayList4.get(size3);
            int size4 = arrayList5.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((kt) arrayList5.get(size4)).a == m91Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    c(m91Var);
                    arrayList5.remove(size4);
                    if (arrayList5.isEmpty()) {
                        arrayList4.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        ArrayList arrayList6 = this.l;
        for (int size5 = arrayList6.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList7 = (ArrayList) arrayList6.get(size5);
            if (arrayList7.remove(m91Var)) {
                view.setAlpha(1.0f);
                c(m91Var);
                if (arrayList7.isEmpty()) {
                    arrayList6.remove(size5);
                }
            }
        }
        this.q.remove(m91Var);
        this.o.remove(m91Var);
        this.r.remove(m91Var);
        this.p.remove(m91Var);
        i();
    }

    @Override // defpackage.r81
    public final void e() {
        ArrayList arrayList = this.j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            kt ktVar = (kt) arrayList.get(size);
            View view = ktVar.a.g;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            c(ktVar.a);
            arrayList.remove(size);
        }
        ArrayList arrayList2 = this.h;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            c((m91) arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList arrayList3 = this.i;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            m91 m91Var = (m91) arrayList3.get(size3);
            m91Var.g.setAlpha(1.0f);
            c(m91Var);
            arrayList3.remove(size3);
        }
        ArrayList arrayList4 = this.k;
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            jt jtVar = (jt) arrayList4.get(size4);
            m91 m91Var2 = jtVar.a;
            if (m91Var2 != null) {
                k(jtVar, m91Var2);
            }
            m91 m91Var3 = jtVar.b;
            if (m91Var3 != null) {
                k(jtVar, m91Var3);
            }
        }
        arrayList4.clear();
        if (f()) {
            ArrayList arrayList5 = this.m;
            for (int size5 = arrayList5.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList6 = (ArrayList) arrayList5.get(size5);
                for (int size6 = arrayList6.size() - 1; size6 >= 0; size6--) {
                    kt ktVar2 = (kt) arrayList6.get(size6);
                    View view2 = ktVar2.a.g;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    c(ktVar2.a);
                    arrayList6.remove(size6);
                    if (arrayList6.isEmpty()) {
                        arrayList5.remove(arrayList6);
                    }
                }
            }
            ArrayList arrayList7 = this.l;
            for (int size7 = arrayList7.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList8 = (ArrayList) arrayList7.get(size7);
                for (int size8 = arrayList8.size() - 1; size8 >= 0; size8--) {
                    m91 m91Var4 = (m91) arrayList8.get(size8);
                    m91Var4.g.setAlpha(1.0f);
                    c(m91Var4);
                    arrayList8.remove(size8);
                    if (arrayList8.isEmpty()) {
                        arrayList7.remove(arrayList8);
                    }
                }
            }
            ArrayList arrayList9 = this.n;
            for (int size9 = arrayList9.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList10 = (ArrayList) arrayList9.get(size9);
                for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                    jt jtVar2 = (jt) arrayList10.get(size10);
                    m91 m91Var5 = jtVar2.a;
                    if (m91Var5 != null) {
                        k(jtVar2, m91Var5);
                    }
                    m91 m91Var6 = jtVar2.b;
                    if (m91Var6 != null) {
                        k(jtVar2, m91Var6);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList9.remove(arrayList10);
                    }
                }
            }
            h(this.q);
            h(this.p);
            h(this.o);
            h(this.r);
            ArrayList arrayList11 = this.b;
            if (arrayList11.size() > 0) {
                arrayList11.get(0).getClass();
                throw new ClassCastException();
            }
            arrayList11.clear();
        }
    }

    @Override // defpackage.r81
    public final boolean f() {
        return (this.i.isEmpty() && this.k.isEmpty() && this.j.isEmpty() && this.h.isEmpty() && this.p.isEmpty() && this.q.isEmpty() && this.o.isEmpty() && this.r.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.n.isEmpty()) ? false : true;
    }

    public final boolean g(m91 m91Var, int i, int i2, int i3, int i4) {
        View view = m91Var.g;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) m91Var.g.getTranslationY());
        l(m91Var);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            c(m91Var);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        ArrayList arrayList = this.j;
        kt ktVar = new kt();
        ktVar.a = m91Var;
        ktVar.b = translationX;
        ktVar.c = translationY;
        ktVar.d = i3;
        ktVar.e = i4;
        arrayList.add(ktVar);
        return true;
    }

    public final void i() {
        if (f()) {
            return;
        }
        ArrayList arrayList = this.b;
        if (arrayList.size() <= 0) {
            arrayList.clear();
        } else {
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final void j(ArrayList arrayList, m91 m91Var) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            jt jtVar = (jt) arrayList.get(size);
            if (k(jtVar, m91Var) && jtVar.a == null && jtVar.b == null) {
                arrayList.remove(jtVar);
            }
        }
    }

    public final boolean k(jt jtVar, m91 m91Var) {
        if (jtVar.b == m91Var) {
            jtVar.b = null;
        } else {
            if (jtVar.a != m91Var) {
                return false;
            }
            jtVar.a = null;
        }
        m91Var.g.setAlpha(1.0f);
        View view = m91Var.g;
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        c(m91Var);
        return true;
    }

    public final void l(m91 m91Var) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        m91Var.g.animate().setInterpolator(s);
        d(m91Var);
    }
}
