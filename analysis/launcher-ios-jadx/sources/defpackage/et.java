package defpackage;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class et implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ ArrayList h;
    public final /* synthetic */ lt i;

    public /* synthetic */ et(lt ltVar, ArrayList arrayList, int i) {
        this.g = i;
        this.i = ltVar;
        this.h = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                ArrayList arrayList = this.h;
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    lt ltVar = this.i;
                    if (i >= size) {
                        arrayList.clear();
                        ltVar.m.remove(arrayList);
                    } else {
                        Object obj = arrayList.get(i);
                        i++;
                        kt ktVar = (kt) obj;
                        m91 m91Var = ktVar.a;
                        ltVar.getClass();
                        View view = m91Var.g;
                        int i2 = ktVar.d - ktVar.b;
                        int i3 = ktVar.e - ktVar.c;
                        if (i2 != 0) {
                            view.animate().translationX(0.0f);
                        }
                        if (i3 != 0) {
                            view.animate().translationY(0.0f);
                        }
                        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                        ltVar.p.add(m91Var);
                        viewPropertyAnimatorAnimate.setDuration(ltVar.e).setListener(new gt(ltVar, m91Var, i2, view, i3, viewPropertyAnimatorAnimate)).start();
                    }
                    break;
                }
                break;
            case 1:
                ArrayList arrayList2 = this.h;
                int size2 = arrayList2.size();
                int i4 = 0;
                while (true) {
                    lt ltVar2 = this.i;
                    if (i4 >= size2) {
                        arrayList2.clear();
                        ltVar2.n.remove(arrayList2);
                        break;
                    } else {
                        Object obj2 = arrayList2.get(i4);
                        i4++;
                        jt jtVar = (jt) obj2;
                        ltVar2.getClass();
                        m91 m91Var2 = jtVar.a;
                        View view2 = m91Var2 == null ? null : m91Var2.g;
                        m91 m91Var3 = jtVar.b;
                        View view3 = m91Var3 != null ? m91Var3.g : null;
                        ArrayList arrayList3 = ltVar2.r;
                        long j = ltVar2.f;
                        if (view2 != null) {
                            ViewPropertyAnimator duration = view2.animate().setDuration(j);
                            arrayList3.add(jtVar.a);
                            duration.translationX(jtVar.e - jtVar.c);
                            duration.translationY(jtVar.f - jtVar.d);
                            duration.alpha(0.0f).setListener(new ht(ltVar2, jtVar, duration, view2, 0)).start();
                        }
                        if (view3 != null) {
                            ViewPropertyAnimator viewPropertyAnimatorAnimate2 = view3.animate();
                            arrayList3.add(jtVar.b);
                            viewPropertyAnimatorAnimate2.translationX(0.0f).translationY(0.0f).setDuration(j).alpha(1.0f).setListener(new ht(ltVar2, jtVar, viewPropertyAnimatorAnimate2, view3, 1)).start();
                        }
                    }
                }
                break;
            default:
                ArrayList arrayList4 = this.h;
                int size3 = arrayList4.size();
                int i5 = 0;
                while (true) {
                    lt ltVar3 = this.i;
                    if (i5 >= size3) {
                        arrayList4.clear();
                        ltVar3.l.remove(arrayList4);
                    } else {
                        Object obj3 = arrayList4.get(i5);
                        i5++;
                        m91 m91Var4 = (m91) obj3;
                        ltVar3.getClass();
                        View view4 = m91Var4.g;
                        ViewPropertyAnimator viewPropertyAnimatorAnimate3 = view4.animate();
                        ltVar3.o.add(m91Var4);
                        viewPropertyAnimatorAnimate3.alpha(1.0f).setDuration(ltVar3.c).setListener(new ft(ltVar3, m91Var4, view4, viewPropertyAnimatorAnimate3)).start();
                    }
                    break;
                }
                break;
        }
    }
}
