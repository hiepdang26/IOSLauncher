package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class uh0 extends GestureDetector.SimpleOnGestureListener {
    public boolean a = true;
    public final /* synthetic */ vh0 b;

    public uh0(vh0 vh0Var) {
        this.b = vh0Var;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        vh0 vh0Var;
        View viewN;
        m91 m91VarP;
        if (!this.a || (viewN = (vh0Var = this.b).n(motionEvent)) == null || (m91VarP = vh0Var.x.P(viewN)) == null) {
            return;
        }
        th0 th0Var = vh0Var.s;
        RecyclerView recyclerView = vh0Var.x;
        int iH = th0Var.h(recyclerView, m91VarP);
        WeakHashMap weakHashMap = qs1.a;
        if ((th0.b(iH, recyclerView.getLayoutDirection()) & 16711680) != 0) {
            int pointerId = motionEvent.getPointerId(0);
            int i = vh0Var.r;
            if (pointerId == i) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i);
                float x = motionEvent.getX(iFindPointerIndex);
                float y = motionEvent.getY(iFindPointerIndex);
                vh0Var.j = x;
                vh0Var.k = y;
                vh0Var.o = 0.0f;
                vh0Var.n = 0.0f;
                if (vh0Var.s.l()) {
                    vh0Var.s(m91VarP, 2);
                }
            }
        }
    }
}
