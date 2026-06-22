package defpackage;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public final class bo0 implements View.OnTouchListener {
    public static final int x = ViewConfiguration.getTapTimeout();
    public final z9 g;
    public final AccelerateInterpolator h;
    public final ListView i;
    public o1 j;
    public final float[] k;
    public final float[] l;
    public final int m;
    public final int n;
    public final float[] o;
    public final float[] p;
    public final float[] q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public final ListView w;

    public bo0(ListView listView) {
        z9 z9Var = new z9();
        z9Var.e = Long.MIN_VALUE;
        z9Var.g = -1L;
        z9Var.f = 0L;
        this.g = z9Var;
        this.h = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.k = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.l = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.o = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.p = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.q = fArr5;
        this.i = listView;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = ((int) ((1575.0f * f) + 0.5f)) / 1000.0f;
        fArr5[0] = f2;
        fArr5[1] = f2;
        float f3 = ((int) ((f * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f3;
        fArr4[1] = f3;
        this.m = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.n = x;
        z9Var.a = 500;
        z9Var.b = 500;
        this.w = listView;
    }

    public static float b(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(float r4, float r5, float r6, int r7) {
        /*
            r3 = this;
            float[] r0 = r3.k
            r0 = r0[r7]
            float[] r1 = r3.l
            r1 = r1[r7]
            float r0 = r0 * r5
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r4, r0)
            float r5 = r5 - r4
            float r4 = r3.c(r5, r0)
            float r4 = r4 - r1
            android.view.animation.AccelerateInterpolator r5 = r3.h
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 >= 0) goto L26
            float r4 = -r4
            float r4 = r5.getInterpolation(r4)
            float r4 = -r4
            goto L2e
        L26:
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L37
            float r4 = r5.getInterpolation(r4)
        L2e:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r4 = b(r4, r5, r0)
            goto L38
        L37:
            r4 = 0
        L38:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 != 0) goto L3d
            return r2
        L3d:
            float[] r0 = r3.o
            r0 = r0[r7]
            float[] r1 = r3.p
            r1 = r1[r7]
            float[] r2 = r3.q
            r7 = r2[r7]
            float r0 = r0 * r6
            if (r5 <= 0) goto L54
            float r4 = r4 * r0
            float r4 = b(r4, r1, r7)
            return r4
        L54:
            float r4 = -r4
            float r4 = r4 * r0
            float r4 = b(r4, r1, r7)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bo0.a(float, float, float, int):float");
    }

    public final float c(float f, float f2) {
        if (f2 != 0.0f) {
            int i = this.m;
            if (i == 0 || i == 1) {
                if (f < f2) {
                    if (f >= 0.0f) {
                        return 1.0f - (f / f2);
                    }
                    if (this.u && i == 1) {
                        return 1.0f;
                    }
                }
            } else if (i == 2 && f < 0.0f) {
                return f / (-f2);
            }
        }
        return 0.0f;
    }

    public final void d() {
        int i = 0;
        if (this.s) {
            this.u = false;
            return;
        }
        z9 z9Var = this.g;
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i2 = (int) (jCurrentAnimationTimeMillis - z9Var.e);
        int i3 = z9Var.b;
        if (i2 > i3) {
            i = i3;
        } else if (i2 >= 0) {
            i = i2;
        }
        z9Var.i = i;
        z9Var.h = z9Var.a(jCurrentAnimationTimeMillis);
        z9Var.g = jCurrentAnimationTimeMillis;
    }

    public final boolean e() {
        ListView listView;
        int count;
        z9 z9Var = this.g;
        float f = z9Var.d;
        int iAbs = (int) (f / Math.abs(f));
        Math.abs(z9Var.c);
        if (iAbs != 0 && (count = (listView = this.w).getCount()) != 0) {
            int childCount = listView.getChildCount();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int i = firstVisiblePosition + childCount;
            if (iAbs <= 0 ? !(iAbs >= 0 || (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0)) : !(i >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r0 != 3) goto L30;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.v
            r1 = 0
            if (r0 != 0) goto L7
            goto L7d
        L7:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            r3 = 2
            if (r0 == r3) goto L1f
            r8 = 3
            if (r0 == r8) goto L17
            goto L7d
        L17:
            r7.d()
            return r1
        L1b:
            r7.t = r2
            r7.r = r1
        L1f:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            android.widget.ListView r4 = r7.i
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r0, r3, r5, r1)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r9, r8, r3, r2)
            z9 r9 = r7.g
            r9.c = r0
            r9.d = r8
            boolean r8 = r7.u
            if (r8 != 0) goto L7d
            boolean r8 = r7.e()
            if (r8 == 0) goto L7d
            o1 r8 = r7.j
            if (r8 != 0) goto L61
            o1 r8 = new o1
            r9 = 4
            r8.<init>(r7, r9)
            r7.j = r8
        L61:
            r7.u = r2
            r7.s = r2
            boolean r8 = r7.r
            if (r8 != 0) goto L76
            int r8 = r7.n
            if (r8 <= 0) goto L76
            o1 r9 = r7.j
            long r5 = (long) r8
            java.util.WeakHashMap r8 = defpackage.qs1.a
            r4.postOnAnimationDelayed(r9, r5)
            goto L7b
        L76:
            o1 r8 = r7.j
            r8.run()
        L7b:
            r7.r = r2
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bo0.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
