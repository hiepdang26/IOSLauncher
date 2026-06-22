package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class b30 extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
    public static a30 l;
    public static long m;
    public static boolean n;
    public View g;
    public long h;
    public long i = -1;
    public boolean j;
    public boolean k;

    public b30(ObjectAnimator objectAnimator, View view) {
        this.g = view;
        objectAnimator.addUpdateListener(this);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        ValueAnimator valueAnimator = (ValueAnimator) animator;
        valueAnimator.addUpdateListener(this);
        onAnimationUpdate(valueAnimator);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x008d  */
    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onAnimationUpdate(android.animation.ValueAnimator r19) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L17
            long r4 = r1.i     // Catch: java.lang.Throwable -> L17
            r6 = -1
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L1a
            long r4 = defpackage.b30.m     // Catch: java.lang.Throwable -> L17
            r1.h = r4     // Catch: java.lang.Throwable -> L17
            r1.i = r2     // Catch: java.lang.Throwable -> L17
            goto L1a
        L17:
            r0 = move-exception
            goto L9d
        L1a:
            long r4 = r0.getCurrentPlayTime()     // Catch: java.lang.Throwable -> L17
            float r6 = r0.getAnimatedFraction()     // Catch: java.lang.Throwable -> L17
            r7 = 1065353216(0x3f800000, float:1.0)
            int r6 = java.lang.Float.compare(r7, r6)     // Catch: java.lang.Throwable -> L17
            r7 = 0
            r8 = 1
            if (r6 != 0) goto L2e
            r6 = 1
            goto L2f
        L2e:
            r6 = 0
        L2f:
            boolean r9 = r1.j     // Catch: java.lang.Throwable -> L17
            if (r9 != 0) goto La0
            boolean r9 = defpackage.b30.n     // Catch: java.lang.Throwable -> L17
            if (r9 == 0) goto La0
            long r9 = r0.getDuration()     // Catch: java.lang.Throwable -> L17
            int r11 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r11 >= 0) goto La0
            if (r6 != 0) goto La0
            r1.j = r8     // Catch: java.lang.Throwable -> L17
            long r9 = defpackage.b30.m     // Catch: java.lang.Throwable -> L17
            long r11 = r1.h     // Catch: java.lang.Throwable -> L17
            long r9 = r9 - r11
            android.view.View r6 = r1.g
            r13 = 0
            int r15 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r15 != 0) goto L68
            r15 = 1000(0x3e8, double:4.94E-321)
            long r11 = r1.i     // Catch: java.lang.Throwable -> L17
            long r11 = r11 + r15
            int r17 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r17 >= 0) goto L6a
            int r11 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r11 <= 0) goto L6a
            android.view.View r2 = r6.getRootView()     // Catch: java.lang.Throwable -> L17
            r2.invalidate()     // Catch: java.lang.Throwable -> L17
            r0.setCurrentPlayTime(r13)     // Catch: java.lang.Throwable -> L17
            goto L9a
        L68:
            r15 = 1000(0x3e8, double:4.94E-321)
        L6a:
            r11 = 1
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 != 0) goto L8d
            long r9 = r1.i     // Catch: java.lang.Throwable -> L17
            long r11 = r9 + r15
            int r14 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r14 >= 0) goto L8d
            boolean r11 = r1.k     // Catch: java.lang.Throwable -> L17
            if (r11 != 0) goto L8d
            r11 = 16
            long r9 = r9 + r11
            int r14 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r14 <= 0) goto L8d
            int r2 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r2 <= 0) goto L8d
            r0.setCurrentPlayTime(r11)     // Catch: java.lang.Throwable -> L17
            r1.k = r8     // Catch: java.lang.Throwable -> L17
            goto L9a
        L8d:
            if (r13 <= 0) goto L9a
            w1 r2 = new w1     // Catch: java.lang.Throwable -> L17
            r3 = 15
            r4 = 0
            r2.<init>(r1, r0, r3, r4)     // Catch: java.lang.Throwable -> L17
            r6.post(r2)     // Catch: java.lang.Throwable -> L17
        L9a:
            r1.j = r7     // Catch: java.lang.Throwable -> L17
            return
        L9d:
            r0.getMessage()
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b30.onAnimationUpdate(android.animation.ValueAnimator):void");
    }
}
