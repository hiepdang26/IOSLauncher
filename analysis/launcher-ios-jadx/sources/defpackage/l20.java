package defpackage;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class l20 extends xo1 {
    public static final String[] D = {"android:visibility:visibility", "android:visibility:parent"};
    public final int C;

    public l20(int i) {
        this();
        this.C = i;
    }

    public static void F(fp1 fp1Var) {
        int visibility = fp1Var.b.getVisibility();
        HashMap map = fp1Var.a;
        map.put("android:visibility:visibility", Integer.valueOf(visibility));
        View view = fp1Var.b;
        map.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        map.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.yu1 H(defpackage.fp1 r8, defpackage.fp1 r9) {
        /*
            yu1 r0 = new yu1
            r0.<init>()
            r1 = 0
            r0.a = r1
            r0.b = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.c = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.e = r6
            goto L33
        L2f:
            r0.c = r3
            r0.e = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.d = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f = r2
            goto L56
        L52:
            r0.d = r3
            r0.f = r2
        L56:
            r2 = 1
            if (r8 == 0) goto L8a
            if (r9 == 0) goto L8a
            int r8 = r0.c
            int r9 = r0.d
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.e
            android.view.ViewGroup r4 = r0.f
            if (r3 != r4) goto L68
            goto L9f
        L68:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L71
            r0.b = r1
            r0.a = r2
            return r0
        L71:
            if (r9 != 0) goto L9f
            r0.b = r2
            r0.a = r2
            return r0
        L78:
            android.view.ViewGroup r8 = r0.f
            if (r8 != 0) goto L81
            r0.b = r1
            r0.a = r2
            return r0
        L81:
            android.view.ViewGroup r8 = r0.e
            if (r8 != 0) goto L9f
            r0.b = r2
            r0.a = r2
            return r0
        L8a:
            if (r8 != 0) goto L95
            int r8 = r0.d
            if (r8 != 0) goto L95
            r0.b = r2
            r0.a = r2
            return r0
        L95:
            if (r9 != 0) goto L9f
            int r8 = r0.c
            if (r8 != 0) goto L9f
            r0.b = r1
            r0.a = r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l20.H(fp1, fp1):yu1");
    }

    public final ObjectAnimator G(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        pu1.a.F(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, pu1.b, f2);
        objectAnimatorOfFloat.addListener(new g20(view));
        a(new k20(view, 0));
        return objectAnimatorOfFloat;
    }

    @Override // defpackage.xo1
    public final void c(fp1 fp1Var) {
        F(fp1Var);
    }

    @Override // defpackage.xo1
    public final void f(fp1 fp1Var) {
        F(fp1Var);
        fp1Var.a.put("android:fade:transitionAlpha", Float.valueOf(pu1.a.E(fp1Var.b)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        if (H(m(r3, false), p(r3, false)).a != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01fe  */
    @Override // defpackage.xo1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator j(android.view.ViewGroup r24, defpackage.fp1 r25, defpackage.fp1 r26) {
        /*
            Method dump skipped, instruction units count: 754
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l20.j(android.view.ViewGroup, fp1, fp1):android.animation.Animator");
    }

    @Override // defpackage.xo1
    public final String[] o() {
        return D;
    }

    @Override // defpackage.xo1
    public final boolean q(fp1 fp1Var, fp1 fp1Var2) {
        if (fp1Var == null && fp1Var2 == null) {
            return false;
        }
        if (fp1Var != null && fp1Var2 != null && fp1Var2.a.containsKey("android:visibility:visibility") != fp1Var.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        yu1 yu1VarH = H(fp1Var, fp1Var2);
        if (yu1VarH.a) {
            return yu1VarH.c == 0 || yu1VarH.d == 0;
        }
        return false;
    }

    public l20() {
        this.C = 3;
    }
}
