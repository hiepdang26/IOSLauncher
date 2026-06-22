package defpackage;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class rh0 implements y81 {
    public final /* synthetic */ vh0 g;

    public rh0(vh0 vh0Var) {
        this.g = vh0Var;
    }

    @Override // defpackage.y81
    public final void b(MotionEvent motionEvent) {
        vh0 vh0Var = this.g;
        vh0Var.D.a.onTouchEvent(motionEvent);
        VelocityTracker velocityTracker = vh0Var.z;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        if (vh0Var.r == -1) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        int iFindPointerIndex = motionEvent.findPointerIndex(vh0Var.r);
        if (iFindPointerIndex >= 0) {
            vh0Var.k(actionMasked, iFindPointerIndex, motionEvent);
        }
        m91 m91Var = vh0Var.i;
        if (m91Var == null) {
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (iFindPointerIndex >= 0) {
                    vh0Var.u(vh0Var.u, iFindPointerIndex, motionEvent);
                    vh0Var.q(m91Var);
                    RecyclerView recyclerView = vh0Var.x;
                    o1 o1Var = vh0Var.y;
                    recyclerView.removeCallbacks(o1Var);
                    o1Var.run();
                    vh0Var.x.invalidate();
                    return;
                }
                return;
            }
            if (actionMasked != 3) {
                if (actionMasked != 6) {
                    return;
                }
                int actionIndex = motionEvent.getActionIndex();
                if (motionEvent.getPointerId(actionIndex) == vh0Var.r) {
                    vh0Var.r = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                    vh0Var.u(vh0Var.u, actionIndex, motionEvent);
                    return;
                }
                return;
            }
            VelocityTracker velocityTracker2 = vh0Var.z;
            if (velocityTracker2 != null) {
                velocityTracker2.clear();
            }
        }
        vh0Var.s(null, 0);
        vh0Var.r = -1;
    }

    @Override // defpackage.y81
    public final boolean c(MotionEvent motionEvent) {
        int iFindPointerIndex;
        vh0 vh0Var = this.g;
        vh0Var.D.a.onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        sh0 sh0Var = null;
        if (actionMasked == 0) {
            vh0Var.r = motionEvent.getPointerId(0);
            vh0Var.j = motionEvent.getX();
            vh0Var.k = motionEvent.getY();
            VelocityTracker velocityTracker = vh0Var.z;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            vh0Var.z = VelocityTracker.obtain();
            if (vh0Var.i == null) {
                ArrayList arrayList = vh0Var.v;
                if (!arrayList.isEmpty()) {
                    View viewN = vh0Var.n(motionEvent);
                    int size = arrayList.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        }
                        sh0 sh0Var2 = (sh0) arrayList.get(size);
                        if (sh0Var2.k.g == viewN) {
                            sh0Var = sh0Var2;
                            break;
                        }
                        size--;
                    }
                }
                if (sh0Var != null) {
                    vh0Var.j -= sh0Var.o;
                    vh0Var.k -= sh0Var.p;
                    m91 m91Var = sh0Var.k;
                    vh0Var.m(m91Var, true);
                    if (vh0Var.g.remove(m91Var.g)) {
                        vh0Var.s.a(vh0Var.x, m91Var);
                    }
                    vh0Var.s(m91Var, sh0Var.l);
                    vh0Var.u(vh0Var.u, 0, motionEvent);
                }
            }
        } else if (actionMasked == 3 || actionMasked == 1) {
            vh0Var.r = -1;
            vh0Var.s(null, 0);
        } else {
            int i = vh0Var.r;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) >= 0) {
                vh0Var.k(actionMasked, iFindPointerIndex, motionEvent);
            }
        }
        VelocityTracker velocityTracker2 = vh0Var.z;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return vh0Var.i != null;
    }

    @Override // defpackage.y81
    public final void e(boolean z) {
        if (z) {
            this.g.s(null, 0);
        }
    }
}
