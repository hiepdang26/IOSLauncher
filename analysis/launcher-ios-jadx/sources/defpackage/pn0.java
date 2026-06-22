package defpackage;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class pn0 {
    public int a = -1;
    public RecyclerView b;
    public u81 c;
    public boolean d;
    public boolean e;
    public View f;
    public final g91 g;
    public final LinearInterpolator h;
    public final DecelerateInterpolator i;
    public PointF j;
    public final DisplayMetrics k;
    public boolean l;
    public float m;
    public int n;
    public int o;

    public pn0(Context context) {
        g91 g91Var = new g91();
        g91Var.d = -1;
        g91Var.f = false;
        g91Var.a = 0;
        g91Var.b = 0;
        g91Var.c = RtlSpacingHelper.UNDEFINED;
        g91Var.e = null;
        this.g = g91Var;
        this.h = new LinearInterpolator();
        this.i = new DecelerateInterpolator();
        this.l = false;
        this.n = 0;
        this.o = 0;
        this.k = context.getResources().getDisplayMetrics();
    }

    public static int a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i;
        }
        if (i5 != 0) {
            if (i5 == 1) {
                return i4 - i2;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i6 = i3 - i;
        if (i6 > 0) {
            return i6;
        }
        int i7 = i4 - i2;
        if (i7 < 0) {
            return i7;
        }
        return 0;
    }

    public float b(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int c(int i) {
        float fAbs = Math.abs(i);
        if (!this.l) {
            this.m = b(this.k);
            this.l = true;
        }
        return (int) Math.ceil(fAbs * this.m);
    }

    public PointF d(int i) {
        Object obj = this.c;
        if (obj instanceof h91) {
            return ((h91) obj).a(i);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(int r9, int r10) {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pn0.e(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(android.view.View r11, defpackage.g91 r12) {
        /*
            r10 = this;
            android.graphics.PointF r0 = r10.j
            r1 = 1
            r2 = -1
            r3 = 0
            r4 = 0
            if (r0 == 0) goto L15
            float r0 = r0.x
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto Lf
            goto L15
        Lf:
            if (r0 <= 0) goto L13
            r0 = 1
            goto L16
        L13:
            r0 = -1
            goto L16
        L15:
            r0 = 0
        L16:
            u81 r5 = r10.c
            if (r5 == 0) goto L45
            boolean r6 = r5.d()
            if (r6 != 0) goto L21
            goto L45
        L21:
            android.view.ViewGroup$LayoutParams r6 = r11.getLayoutParams()
            v81 r6 = (defpackage.v81) r6
            int r7 = defpackage.u81.A(r11)
            int r8 = r6.leftMargin
            int r7 = r7 - r8
            int r8 = defpackage.u81.C(r11)
            int r6 = r6.rightMargin
            int r8 = r8 + r6
            int r6 = r5.G()
            int r9 = r5.n
            int r5 = r5.H()
            int r9 = r9 - r5
            int r0 = a(r7, r8, r6, r9, r0)
            goto L46
        L45:
            r0 = 0
        L46:
            android.graphics.PointF r5 = r10.j
            if (r5 == 0) goto L55
            float r5 = r5.y
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 != 0) goto L51
            goto L55
        L51:
            if (r3 <= 0) goto L56
            r2 = 1
            goto L56
        L55:
            r2 = 0
        L56:
            u81 r3 = r10.c
            if (r3 == 0) goto L84
            boolean r5 = r3.e()
            if (r5 != 0) goto L61
            goto L84
        L61:
            android.view.ViewGroup$LayoutParams r4 = r11.getLayoutParams()
            v81 r4 = (defpackage.v81) r4
            int r5 = defpackage.u81.D(r11)
            int r6 = r4.topMargin
            int r5 = r5 - r6
            int r11 = defpackage.u81.y(r11)
            int r4 = r4.bottomMargin
            int r11 = r11 + r4
            int r4 = r3.I()
            int r6 = r3.o
            int r3 = r3.F()
            int r6 = r6 - r3
            int r4 = a(r5, r11, r4, r6, r2)
        L84:
            int r11 = r0 * r0
            int r2 = r4 * r4
            int r2 = r2 + r11
            double r2 = (double) r2
            double r2 = java.lang.Math.sqrt(r2)
            int r11 = (int) r2
            int r11 = r10.c(r11)
            double r2 = (double) r11
            r5 = 4599717252057688074(0x3fd57a786c22680a, double:0.3356)
            double r2 = r2 / r5
            double r2 = java.lang.Math.ceil(r2)
            int r11 = (int) r2
            if (r11 <= 0) goto Laf
            int r0 = -r0
            int r2 = -r4
            android.view.animation.DecelerateInterpolator r3 = r10.i
            r12.a = r0
            r12.b = r2
            r12.c = r11
            r12.e = r3
            r12.f = r1
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pn0.f(android.view.View, g91):void");
    }

    public final void g() {
        if (this.e) {
            this.e = false;
            this.o = 0;
            this.n = 0;
            this.j = null;
            this.b.n0.a = -1;
            this.f = null;
            this.a = -1;
            this.d = false;
            u81 u81Var = this.c;
            if (u81Var.e == this) {
                u81Var.e = null;
            }
            this.c = null;
            this.b = null;
        }
    }
}
