package defpackage;

import android.os.Handler;
import android.os.Looper;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: classes.dex */
public final class jd {
    public boolean a;
    public final Object b;

    public /* synthetic */ jd(Object obj) {
        this.b = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
    
        if (r6 != 3) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(android.view.MotionEvent r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.b
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.content.Context r1 = r0.getContext()
            android.view.ViewConfiguration r1 = android.view.ViewConfiguration.get(r1)
            int r1 = r1.getScaledTouchSlop()
            float r1 = (float) r1
            boolean r2 = r0.isLongClickable()
            r3 = 0
            if (r2 != 0) goto L19
            goto L6f
        L19:
            int r2 = r8.getToolType(r3)
            r4 = 2
            r5 = 1
            if (r2 != r4) goto L2a
            int r2 = r8.getButtonState()
            r2 = r2 & r4
            if (r2 != r4) goto L2a
            r2 = 1
            goto L2b
        L2a:
            r2 = 0
        L2b:
            int r6 = r8.getAction()
            if (r6 == 0) goto L62
            if (r6 == r5) goto L5f
            if (r6 == r4) goto L39
            r8 = 3
            if (r6 == r8) goto L5f
            goto L6f
        L39:
            float r4 = r8.getX()
            float r8 = r8.getY()
            boolean r8 = defpackage.ar1.y(r0, r4, r8, r1)
            if (r8 == 0) goto L6f
            boolean r8 = r7.a
            if (r8 != 0) goto L56
            if (r2 == 0) goto L56
            boolean r8 = r0.performLongClick()
            if (r8 == 0) goto L56
            r7.a = r5
            return r5
        L56:
            boolean r8 = r7.a
            if (r8 == 0) goto L6f
            if (r2 != 0) goto L6f
            r7.a = r3
            return r3
        L5f:
            r7.a = r3
            return r3
        L62:
            r7.a = r3
            if (r2 == 0) goto L6f
            boolean r8 = r0.performLongClick()
            if (r8 == 0) goto L6f
            r7.a = r5
            return r5
        L6f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jd.a(android.view.MotionEvent):boolean");
    }

    public boolean b() {
        return this.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(java.lang.CharSequence r7, int r8) {
        /*
            r6 = this;
            r0 = 1
            if (r7 == 0) goto L44
            if (r8 < 0) goto L44
            int r1 = r7.length()
            int r1 = r1 - r8
            if (r1 < 0) goto L44
            java.lang.Object r1 = r6.b
            jl1 r1 = (defpackage.jl1) r1
            if (r1 != 0) goto L17
            boolean r7 = r6.b()
            return r7
        L17:
            r1 = 0
            r2 = 2
            r3 = 0
            r4 = 2
        L1b:
            if (r3 >= r8) goto L39
            if (r4 != r2) goto L39
            char r4 = r7.charAt(r3)
            byte r4 = java.lang.Character.getDirectionality(r4)
            jd r5 = defpackage.an1.a
            if (r4 == 0) goto L36
            if (r4 == r0) goto L34
            if (r4 == r2) goto L34
            switch(r4) {
                case 14: goto L36;
                case 15: goto L36;
                case 16: goto L34;
                case 17: goto L34;
                default: goto L32;
            }
        L32:
            r4 = 2
            goto L37
        L34:
            r4 = 0
            goto L37
        L36:
            r4 = 1
        L37:
            int r3 = r3 + r0
            goto L1b
        L39:
            if (r4 == 0) goto L43
            if (r4 == r0) goto L42
            boolean r7 = r6.b()
            return r7
        L42:
            return r1
        L43:
            return r0
        L44:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jd.c(java.lang.CharSequence, int):boolean");
    }

    public synchronized void d(eb1 eb1Var, boolean z) {
        try {
            if (this.a || z) {
                ((Handler) this.b).obtainMessage(1, eb1Var).sendToTarget();
            } else {
                this.a = true;
                eb1Var.recycle();
                this.a = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public jd() {
        this.b = new Handler(Looper.getMainLooper(), new by0(1));
    }

    public jd(jl1 jl1Var, boolean z) {
        this(jl1Var);
        this.a = z;
    }

    public jd(String str, boolean z) {
        this.a = z;
        this.b = str;
    }

    public jd(BottomSheetBehavior bottomSheetBehavior, boolean z) {
        this.b = bottomSheetBehavior;
        this.a = z;
    }
}
