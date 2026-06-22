package defpackage;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class cu {
    public final ViewGroup a;
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public boolean d = false;
    public boolean e = false;

    public cu(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public static cu f(ViewGroup viewGroup, iy iyVar) {
        Object tag = viewGroup.getTag(b61.special_effects_controller_view_tag);
        if (tag instanceof cu) {
            return (cu) tag;
        }
        iyVar.getClass();
        cu cuVar = new cu(viewGroup);
        viewGroup.setTag(b61.special_effects_controller_view_tag, cuVar);
        return cuVar;
    }

    public final void a(int i, int i2, a aVar) {
        synchronized (this.b) {
            try {
                ig igVar = new ig();
                li1 li1VarD = d(aVar.c);
                if (li1VarD != null) {
                    li1VarD.c(i, i2);
                    return;
                }
                li1 li1Var = new li1(i, i2, aVar, igVar);
                this.b.add(li1Var);
                li1Var.d.add(new ki1(this, li1Var, 0));
                li1Var.d.add(new ki1(this, li1Var, 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(ArrayList arrayList, boolean z) {
        int i;
        int size = arrayList.size();
        boolean z2 = false;
        li1 li1Var = null;
        li1 li1Var2 = null;
        int i2 = 0;
        while (true) {
            i = 2;
            if (i2 >= size) {
                break;
            }
            Object obj = arrayList.get(i2);
            i2++;
            li1 li1Var3 = (li1) obj;
            int iC = k31.c(li1Var3.c.L);
            int iV = uo.v(li1Var3.a);
            if (iV != 0) {
                if (iV != 1) {
                    if (iV == 2 || iV == 3) {
                    }
                } else if (iC != 2) {
                    li1Var2 = li1Var3;
                }
            }
            if (iC == 2 && li1Var == null) {
                li1Var = li1Var3;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList(arrayList);
        int size2 = arrayList.size();
        int i3 = 0;
        while (i3 < size2) {
            int i4 = i3 + 1;
            li1 li1Var4 = (li1) arrayList.get(i3);
            ig igVar = new ig();
            li1Var4.d();
            HashSet hashSet = li1Var4.e;
            hashSet.add(igVar);
            au auVar = new au(li1Var4, igVar);
            auVar.j = z2;
            auVar.i = z;
            arrayList2.add(auVar);
            ig igVar2 = new ig();
            li1Var4.d();
            hashSet.add(igVar2);
            boolean z3 = !z ? li1Var4 != li1Var2 : li1Var4 != li1Var;
            bu buVar = new bu(li1Var4, igVar2);
            int i5 = li1Var4.a;
            w50 w50Var = li1Var4.c;
            if (i5 == 2) {
                if (z) {
                    w50Var.getClass();
                } else {
                    w50Var.getClass();
                }
                if (z) {
                    w50Var.getClass();
                } else {
                    w50Var.getClass();
                }
            } else if (z) {
                w50Var.getClass();
            } else {
                w50Var.getClass();
            }
            if (z3) {
                if (z) {
                    w50Var.getClass();
                } else {
                    w50Var.getClass();
                }
            }
            arrayList3.add(buVar);
            li1Var4.d.add(new xm(this, arrayList4, li1Var4, 1, false));
            size2 = size2;
            i3 = i4;
            z2 = false;
        }
        HashMap map = new HashMap();
        int size3 = arrayList3.size();
        int i6 = 0;
        while (i6 < size3) {
            Object obj2 = arrayList3.get(i6);
            i6++;
            li1 li1Var5 = (li1) ((bu) obj2).g;
            k31.c(li1Var5.c.L);
            int i7 = li1Var5.a;
        }
        int size4 = arrayList3.size();
        int i8 = 0;
        while (i8 < size4) {
            Object obj3 = arrayList3.get(i8);
            i8++;
            bu buVar2 = (bu) obj3;
            map.put((li1) buVar2.g, Boolean.FALSE);
            buVar2.d();
        }
        boolean zContainsValue = map.containsValue(Boolean.TRUE);
        ViewGroup viewGroup = this.a;
        Context context = viewGroup.getContext();
        ArrayList arrayList5 = new ArrayList();
        int size5 = arrayList2.size();
        boolean z4 = false;
        int i9 = 0;
        while (i9 < size5) {
            Object obj4 = arrayList2.get(i9);
            i9++;
            au auVar2 = (au) obj4;
            li1 li1Var6 = (li1) auVar2.g;
            int iC2 = k31.c(li1Var6.c.L);
            int i10 = li1Var6.a;
            if (iC2 == i10 || !(iC2 == i || i10 == i)) {
                auVar2.d();
                i = 2;
            } else {
                tu tuVarJ = auVar2.j(context);
                if (tuVarJ == null) {
                    auVar2.d();
                } else {
                    Animator animator = (Animator) tuVarJ.i;
                    if (animator == null) {
                        arrayList5.add(auVar2);
                    } else {
                        li1 li1Var7 = (li1) auVar2.g;
                        boolean zEquals = Boolean.TRUE.equals(map.get(li1Var7));
                        w50 w50Var2 = li1Var7.c;
                        if (zEquals) {
                            if (h60.E(2)) {
                                Objects.toString(w50Var2);
                            }
                            auVar2.d();
                            i = 2;
                        } else {
                            boolean z5 = li1Var7.a == 3;
                            if (z5) {
                                arrayList4.remove(li1Var7);
                            }
                            View view = w50Var2.L;
                            viewGroup.startViewTransition(view);
                            animator.addListener(new yt(viewGroup, view, z5, li1Var7, auVar2));
                            animator.setTarget(view);
                            animator.start();
                            ((ig) auVar2.h).a(new fz1(animator, 11));
                            i = 2;
                            z4 = true;
                        }
                    }
                }
                i = 2;
            }
        }
        int size6 = arrayList5.size();
        int i11 = 0;
        while (i11 < size6) {
            Object obj5 = arrayList5.get(i11);
            i11++;
            au auVar3 = (au) obj5;
            li1 li1Var8 = (li1) auVar3.g;
            w50 w50Var3 = li1Var8.c;
            if (zContainsValue) {
                if (h60.E(2)) {
                    Objects.toString(w50Var3);
                }
                auVar3.d();
            } else if (z4) {
                if (h60.E(2)) {
                    Objects.toString(w50Var3);
                }
                auVar3.d();
            } else {
                View view2 = w50Var3.L;
                tu tuVarJ2 = auVar3.j(context);
                tuVarJ2.getClass();
                Animation animation = (Animation) tuVarJ2.h;
                animation.getClass();
                if (li1Var8.a != 1) {
                    view2.startAnimation(animation);
                    auVar3.d();
                } else {
                    viewGroup.startViewTransition(view2);
                    y50 y50Var = new y50(animation, viewGroup, view2);
                    y50Var.setAnimationListener(new zt(viewGroup, view2, auVar3));
                    view2.startAnimation(y50Var);
                }
                ((ig) auVar3.h).a(new wb2(view2, viewGroup, auVar3, 9));
            }
        }
        int size7 = arrayList4.size();
        int i12 = 0;
        while (i12 < size7) {
            Object obj6 = arrayList4.get(i12);
            i12++;
            li1 li1Var9 = (li1) obj6;
            k31.a(li1Var9.a, li1Var9.c.L);
        }
        arrayList4.clear();
    }

    public final void c() {
        if (this.e) {
            return;
        }
        ViewGroup viewGroup = this.a;
        WeakHashMap weakHashMap = qs1.a;
        if (!viewGroup.isAttachedToWindow()) {
            e();
            this.d = false;
            return;
        }
        synchronized (this.b) {
            try {
                if (!this.b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.c);
                    this.c.clear();
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        li1 li1Var = (li1) obj;
                        if (h60.E(2)) {
                            Objects.toString(li1Var);
                        }
                        li1Var.a();
                        if (!li1Var.g) {
                            this.c.add(li1Var);
                        }
                    }
                    g();
                    ArrayList arrayList2 = new ArrayList(this.b);
                    this.b.clear();
                    this.c.addAll(arrayList2);
                    int size2 = arrayList2.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        Object obj2 = arrayList2.get(i2);
                        i2++;
                        ((li1) obj2).d();
                    }
                    b(arrayList2, this.d);
                    this.d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final li1 d(w50 w50Var) {
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            li1 li1Var = (li1) obj;
            if (li1Var.c.equals(w50Var) && !li1Var.f) {
                return li1Var;
            }
        }
        return null;
    }

    public final void e() {
        ViewGroup viewGroup = this.a;
        WeakHashMap weakHashMap = qs1.a;
        boolean zIsAttachedToWindow = viewGroup.isAttachedToWindow();
        synchronized (this.b) {
            try {
                g();
                ArrayList arrayList = this.b;
                int size = arrayList.size();
                int i = 0;
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((li1) obj).d();
                }
                ArrayList arrayList2 = new ArrayList(this.c);
                int size2 = arrayList2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList2.get(i3);
                    i3++;
                    li1 li1Var = (li1) obj2;
                    if (h60.E(2)) {
                        if (!zIsAttachedToWindow) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Container ");
                            sb.append(this.a);
                            sb.append(" is not attached to window. ");
                        }
                        Objects.toString(li1Var);
                    }
                    li1Var.a();
                }
                ArrayList arrayList3 = new ArrayList(this.b);
                int size3 = arrayList3.size();
                while (i < size3) {
                    Object obj3 = arrayList3.get(i);
                    i++;
                    li1 li1Var2 = (li1) obj3;
                    if (h60.E(2)) {
                        if (!zIsAttachedToWindow) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Container ");
                            sb2.append(this.a);
                            sb2.append(" is not attached to window. ");
                        }
                        Objects.toString(li1Var2);
                    }
                    li1Var2.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g() {
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            li1 li1Var = (li1) obj;
            if (li1Var.b == 2) {
                li1Var.c(k31.b(li1Var.c.O().getVisibility()), 1);
            }
        }
    }
}
