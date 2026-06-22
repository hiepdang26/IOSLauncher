package defpackage;

import android.view.View;
import android.view.ViewParent;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class al1 extends ts1 {
    public int a;
    public int b = -1;
    public final /* synthetic */ SwipeDismissBehavior c;

    public al1(SwipeDismissBehavior swipeDismissBehavior) {
        this.c = swipeDismissBehavior;
    }

    @Override // defpackage.ts1
    public final int a(int i, View view) {
        int width;
        int width2;
        int width3;
        WeakHashMap weakHashMap = qs1.a;
        boolean z = view.getLayoutDirection() == 1;
        int i2 = this.c.c;
        if (i2 == 0) {
            if (z) {
                width = this.a - view.getWidth();
                width2 = this.a;
            } else {
                width = this.a;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i2 != 1) {
            width = this.a - view.getWidth();
            width2 = view.getWidth() + this.a;
        } else if (z) {
            width = this.a;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.a - view.getWidth();
            width2 = this.a;
        }
        return Math.min(Math.max(width, i), width2);
    }

    @Override // defpackage.ts1
    public final int b(View view, int i) {
        return view.getTop();
    }

    @Override // defpackage.ts1
    public final int c(View view) {
        return view.getWidth();
    }

    @Override // defpackage.ts1
    public final void g(int i, View view) {
        this.b = i;
        this.a = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // defpackage.ts1
    public final void i(View view, int i, int i2) {
        float f = this.a;
        float width = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.c;
        float f2 = (width * swipeDismissBehavior.d) + f;
        float width2 = (view.getWidth() * swipeDismissBehavior.e) + this.a;
        float f3 = i;
        if (f3 <= f2) {
            view.setAlpha(1.0f);
        } else if (f3 >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((f3 - f2) / (width2 - f2))), 1.0f));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    @Override // defpackage.ts1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            r11 = -1
            r8.b = r11
            int r11 = r9.getWidth()
            com.google.android.material.behavior.SwipeDismissBehavior r0 = r8.c
            r1 = 1
            r2 = 0
            r3 = 0
            int r4 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r4 == 0) goto L39
            java.util.WeakHashMap r5 = defpackage.qs1.a
            int r5 = r9.getLayoutDirection()
            if (r5 != r1) goto L1a
            r5 = 1
            goto L1b
        L1a:
            r5 = 0
        L1b:
            int r6 = r0.c
            r7 = 2
            if (r6 != r7) goto L21
            goto L53
        L21:
            if (r6 != 0) goto L2d
            if (r5 == 0) goto L2a
            int r10 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r10 >= 0) goto L5f
            goto L53
        L2a:
            if (r4 <= 0) goto L5f
            goto L53
        L2d:
            if (r6 != r1) goto L5f
            if (r5 == 0) goto L34
            if (r4 <= 0) goto L5f
            goto L53
        L34:
            int r10 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r10 >= 0) goto L5f
            goto L53
        L39:
            int r10 = r9.getLeft()
            int r3 = r8.a
            int r10 = r10 - r3
            int r3 = r9.getWidth()
            float r3 = (float) r3
            r4 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 * r4
            int r3 = java.lang.Math.round(r3)
            int r10 = java.lang.Math.abs(r10)
            if (r10 < r3) goto L5f
        L53:
            int r10 = r9.getLeft()
            int r2 = r8.a
            if (r10 >= r2) goto L5d
            int r2 = r2 - r11
            goto L63
        L5d:
            int r2 = r2 + r11
            goto L63
        L5f:
            int r10 = r8.a
            r2 = r10
            r1 = 0
        L63:
            vs1 r10 = r0.a
            int r11 = r9.getTop()
            boolean r10 = r10.q(r2, r11)
            if (r10 == 0) goto L79
            el0 r10 = new el0
            r10.<init>(r0, r9, r1)
            java.util.WeakHashMap r11 = defpackage.qs1.a
            r9.postOnAnimation(r10)
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.al1.j(android.view.View, float, float):void");
    }

    @Override // defpackage.ts1
    public final boolean k(int i, View view) {
        int i2 = this.b;
        return (i2 == -1 || i2 == i) && this.c.s(view);
    }

    @Override // defpackage.ts1
    public final void h(int i) {
    }
}
