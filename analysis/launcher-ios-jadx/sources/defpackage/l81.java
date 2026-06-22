package defpackage;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class l81 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ RecyclerView h;

    public /* synthetic */ l81(RecyclerView recyclerView, int i) {
        this.g = i;
        this.h = recyclerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3 = this.h;
        int i = 1;
        switch (this.g) {
            case 0:
                if (recyclerView3.A && !recyclerView3.isLayoutRequested()) {
                    if (!recyclerView3.y) {
                        recyclerView3.requestLayout();
                    } else if (!recyclerView3.D) {
                        recyclerView3.r();
                    } else {
                        recyclerView3.C = true;
                    }
                    break;
                }
                break;
            default:
                r81 r81Var = recyclerView3.S;
                if (r81Var != null) {
                    lt ltVar = (lt) r81Var;
                    ArrayList arrayList = ltVar.h;
                    boolean zIsEmpty = arrayList.isEmpty();
                    ArrayList arrayList2 = ltVar.j;
                    boolean zIsEmpty2 = arrayList2.isEmpty();
                    ArrayList arrayList3 = ltVar.k;
                    boolean zIsEmpty3 = arrayList3.isEmpty();
                    ArrayList arrayList4 = ltVar.i;
                    boolean zIsEmpty4 = arrayList4.isEmpty();
                    if (zIsEmpty && zIsEmpty2 && zIsEmpty4 && zIsEmpty3) {
                        recyclerView2 = recyclerView3;
                    } else {
                        int size = arrayList.size();
                        recyclerView2 = recyclerView3;
                        int i2 = 0;
                        while (true) {
                            long j = ltVar.d;
                            if (i2 < size) {
                                Object obj = arrayList.get(i2);
                                i2 += i;
                                m91 m91Var = (m91) obj;
                                View view = m91Var.g;
                                ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                                ltVar.q.add(m91Var);
                                viewPropertyAnimatorAnimate.setDuration(j).alpha(0.0f).setListener(new ft(ltVar, m91Var, viewPropertyAnimatorAnimate, view)).start();
                                arrayList = arrayList;
                                i = 1;
                            } else {
                                arrayList.clear();
                                if (!zIsEmpty2) {
                                    ArrayList arrayList5 = new ArrayList();
                                    arrayList5.addAll(arrayList2);
                                    ltVar.m.add(arrayList5);
                                    arrayList2.clear();
                                    et etVar = new et(ltVar, arrayList5, 0);
                                    if (zIsEmpty) {
                                        etVar.run();
                                    } else {
                                        View view2 = ((kt) arrayList5.get(0)).a.g;
                                        WeakHashMap weakHashMap = qs1.a;
                                        view2.postOnAnimationDelayed(etVar, j);
                                    }
                                }
                                if (!zIsEmpty3) {
                                    ArrayList arrayList6 = new ArrayList();
                                    arrayList6.addAll(arrayList3);
                                    ltVar.n.add(arrayList6);
                                    arrayList3.clear();
                                    et etVar2 = new et(ltVar, arrayList6, 1);
                                    if (zIsEmpty) {
                                        etVar2.run();
                                    } else {
                                        View view3 = ((jt) arrayList6.get(0)).a.g;
                                        WeakHashMap weakHashMap2 = qs1.a;
                                        view3.postOnAnimationDelayed(etVar2, j);
                                    }
                                }
                                if (!zIsEmpty4) {
                                    ArrayList arrayList7 = new ArrayList();
                                    arrayList7.addAll(arrayList4);
                                    ltVar.l.add(arrayList7);
                                    arrayList4.clear();
                                    et etVar3 = new et(ltVar, arrayList7, 2);
                                    if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
                                        etVar3.run();
                                    } else {
                                        if (zIsEmpty) {
                                            j = 0;
                                        }
                                        long jMax = Math.max(!zIsEmpty2 ? ltVar.e : 0L, zIsEmpty3 ? 0L : ltVar.f) + j;
                                        View view4 = ((m91) arrayList7.get(0)).g;
                                        WeakHashMap weakHashMap3 = qs1.a;
                                        view4.postOnAnimationDelayed(etVar3, jMax);
                                    }
                                }
                            }
                        }
                    }
                    recyclerView = recyclerView2;
                } else {
                    recyclerView = recyclerView3;
                }
                recyclerView.t0 = false;
                break;
        }
    }
}
