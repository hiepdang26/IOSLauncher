package defpackage;

import android.view.View;
import androidx.fragment.app.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class li1 {
    public int a;
    public int b;
    public final w50 c;
    public final ArrayList d = new ArrayList();
    public final HashSet e = new HashSet();
    public boolean f = false;
    public boolean g = false;
    public final a h;

    public li1(int i, int i2, a aVar, ig igVar) {
        this.a = i;
        this.b = i2;
        this.c = aVar.c;
        igVar.a(new mc1(this, 25));
        this.h = aVar;
    }

    public final void a() {
        if (this.f) {
            return;
        }
        this.f = true;
        HashSet hashSet = this.e;
        if (hashSet.isEmpty()) {
            b();
            return;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ig igVar = (ig) obj;
            synchronized (igVar) {
                try {
                    if (!igVar.a) {
                        igVar.a = true;
                        igVar.c = true;
                        hg hgVar = igVar.b;
                        if (hgVar != null) {
                            try {
                                hgVar.n();
                            } catch (Throwable th) {
                                synchronized (igVar) {
                                    igVar.c = false;
                                    igVar.notifyAll();
                                    throw th;
                                }
                            }
                        }
                        synchronized (igVar) {
                            igVar.c = false;
                            igVar.notifyAll();
                        }
                    }
                } finally {
                }
            }
        }
    }

    public final void b() {
        if (!this.g) {
            if (h60.E(2)) {
                toString();
            }
            this.g = true;
            ArrayList arrayList = this.d;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((Runnable) obj).run();
            }
        }
        this.h.k();
    }

    public final void c(int i, int i2) {
        int iV = uo.v(i2);
        w50 w50Var = this.c;
        if (iV == 0) {
            if (this.a != 1) {
                if (h60.E(2)) {
                    Objects.toString(w50Var);
                }
                this.a = i;
                return;
            }
            return;
        }
        if (iV != 1) {
            if (iV != 2) {
                return;
            }
            if (h60.E(2)) {
                Objects.toString(w50Var);
            }
            this.a = 1;
            this.b = 3;
            return;
        }
        if (this.a == 1) {
            if (h60.E(2)) {
                Objects.toString(w50Var);
            }
            this.a = 2;
            this.b = 2;
        }
    }

    public final void d() {
        if (this.b == 2) {
            a aVar = this.h;
            w50 w50Var = aVar.c;
            View viewFindFocus = w50Var.L.findFocus();
            if (viewFindFocus != null) {
                w50Var.g().k = viewFindFocus;
                if (h60.E(2)) {
                    viewFindFocus.toString();
                    w50Var.toString();
                }
            }
            View viewO = this.c.O();
            if (viewO.getParent() == null) {
                aVar.b();
                viewO.setAlpha(0.0f);
            }
            if (viewO.getAlpha() == 0.0f && viewO.getVisibility() == 0) {
                viewO.setVisibility(4);
            }
            v50 v50Var = w50Var.O;
            viewO.setAlpha(v50Var == null ? 1.0f : v50Var.j);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Operation {");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} {mFinalState = ");
        int i = this.a;
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "INVISIBLE" : "GONE" : "VISIBLE" : "REMOVED");
        sb.append("} {mLifecycleImpact = ");
        int i2 = this.b;
        sb.append(i2 != 1 ? i2 != 2 ? i2 != 3 ? "null" : "REMOVING" : "ADDING" : "NONE");
        sb.append("} {mFragment = ");
        sb.append(this.c);
        sb.append("}");
        return sb.toString();
    }
}
