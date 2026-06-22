package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class jb extends RecyclerView implements y81 {
    public int Q0;
    public float R0;
    public lb S0;
    public int T0;
    public int U0;
    public int V0;
    public Rect W0;

    @Override // defpackage.y81
    public final void b(MotionEvent motionEvent) {
        v0(motionEvent);
    }

    @Override // defpackage.y81
    public final boolean c(MotionEvent motionEvent) {
        return v0(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Canvas canvas2;
        super.dispatchDraw(canvas);
        w0(0);
        lb lbVar = this.S0;
        Point point = lbVar.f;
        if (point.x < 0 || point.y < 0) {
            return;
        }
        Paint paint = lbVar.n;
        if (paint.getAlpha() > 0) {
            canvas2 = canvas;
            canvas2.drawRect(point.x, 0.0f, r1 + lbVar.j, lbVar.a.getHeight(), paint);
        } else {
            canvas2 = canvas;
        }
        canvas2.drawPath(lbVar.m, lbVar.g);
        lbVar.b.getClass();
    }

    public int getAvailableScrollBarHeight() {
        return getVisibleHeight() - this.S0.k;
    }

    public Rect getBackgroundPadding() {
        return this.W0;
    }

    public int getMaxScrollbarWidth() {
        return this.S0.i;
    }

    public lb getScrollBar() {
        return this.S0;
    }

    public int getVisibleHeight() {
        int height = getHeight();
        Rect rect = this.W0;
        return (height - rect.top) - rect.bottom;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.w.add(this);
    }

    public final int t0(int i) {
        return (getPaddingBottom() + (u0(i) + getPaddingTop())) - getVisibleHeight();
    }

    public abstract int u0(int i);

    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean v0(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            float r1 = r5.getX()
            int r1 = (int) r1
            float r2 = r5.getY()
            int r2 = (int) r2
            lb r3 = r4.S0
            if (r0 == 0) goto L56
            r1 = 1
            if (r0 == r1) goto L26
            r1 = 2
            if (r0 == r1) goto L1c
            r1 = 3
            if (r0 == r1) goto L26
            goto L81
        L1c:
            r4.V0 = r2
            int r0 = r4.T0
            int r1 = r4.U0
            r3.a(r0, r1, r2, r5)
            goto L81
        L26:
            r0 = r4
            com.luutinhit.launcher6.allapps.AllAppsRecyclerView r0 = (com.luutinhit.launcher6.allapps.AllAppsRecyclerView) r0
            x3 r0 = r0.Y0
            w3 r1 = r0.k
            com.luutinhit.launcher6.allapps.AllAppsRecyclerView r2 = r0.a
            r2.removeCallbacks(r1)
            w3 r1 = r0.l
            r2.removeCallbacks(r1)
            r1 = 0
            r0.f = r1
            r0.g = r1
            r1 = 0
            r0.d = r1
            r0.e = r1
            r1 = -1
            r0.c = r1
            r0.a()
            java.util.HashSet r0 = r0.h
            r0.clear()
            int r0 = r4.T0
            int r1 = r4.U0
            int r2 = r4.V0
            r3.a(r0, r1, r2, r5)
            goto L81
        L56:
            r4.T0 = r1
            r4.V0 = r2
            r4.U0 = r2
            int r0 = r5.getAction()
            if (r0 != 0) goto L78
            int r0 = r4.Q0
            int r0 = java.lang.Math.abs(r0)
            float r0 = (float) r0
            float r1 = r4.R0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L78
            int r0 = r4.getScrollState()
            if (r0 == 0) goto L78
            r4.s0()
        L78:
            int r0 = r4.T0
            int r1 = r4.U0
            int r2 = r4.V0
            r3.a(r0, r1, r2, r5)
        L81:
            boolean r5 = r3.q
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jb.v0(android.view.MotionEvent):boolean");
    }

    public abstract void w0(int i);

    @Override // defpackage.y81
    public final void e(boolean z) {
    }
}
