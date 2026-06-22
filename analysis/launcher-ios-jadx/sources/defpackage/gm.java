package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class gm {
    public int b;
    public boolean c;
    public final jn d;
    public final int e;
    public gm f;
    public di1 i;
    public HashSet a = null;
    public int g = 0;
    public int h = RtlSpacingHelper.UNDEFINED;

    public gm(jn jnVar, int i) {
        this.d = jnVar;
        this.e = i;
    }

    public final void a(gm gmVar) {
        b(gmVar, 0, RtlSpacingHelper.UNDEFINED, false);
    }

    public final boolean b(gm gmVar, int i, int i2, boolean z) {
        if (gmVar == null) {
            j();
            return true;
        }
        if (!z && !i(gmVar)) {
            return false;
        }
        this.f = gmVar;
        if (gmVar.a == null) {
            gmVar.a = new HashSet();
        }
        HashSet hashSet = this.f.a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.g = i;
        this.h = i2;
        return true;
    }

    public final void c(int i, ax1 ax1Var, ArrayList arrayList) {
        HashSet hashSet = this.a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                n90.k(((gm) it.next()).d, i, arrayList, ax1Var);
            }
        }
    }

    public final int d() {
        if (this.c) {
            return this.b;
        }
        return 0;
    }

    public final int e() {
        gm gmVar;
        if (this.d.h0 == 8) {
            return 0;
        }
        int i = this.h;
        return (i == Integer.MIN_VALUE || (gmVar = this.f) == null || gmVar.d.h0 != 8) ? this.g : i;
    }

    public final gm f() {
        int i = this.e;
        int iV = uo.v(i);
        jn jnVar = this.d;
        switch (iV) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return jnVar.K;
            case 2:
                return jnVar.L;
            case 3:
                return jnVar.I;
            case 4:
                return jnVar.J;
            default:
                throw new AssertionError(uo.u(i));
        }
    }

    public final boolean g() {
        HashSet hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((gm) it.next()).f().h()) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        return this.f != null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0063 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(defpackage.gm r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L5
            goto L65
        L5:
            r1 = 6
            int r2 = r10.e
            r3 = 1
            jn r4 = r11.d
            int r11 = r11.e
            if (r11 != r2) goto L1c
            if (r2 != r1) goto L63
            boolean r11 = r4.E
            if (r11 == 0) goto L65
            jn r11 = r10.d
            boolean r11 = r11.E
            if (r11 != 0) goto L63
            goto L65
        L1c:
            int r5 = defpackage.uo.v(r2)
            r6 = 4
            r7 = 2
            r8 = 9
            r9 = 8
            switch(r5) {
                case 0: goto L65;
                case 1: goto L53;
                case 2: goto L3f;
                case 3: goto L53;
                case 4: goto L3f;
                case 5: goto L3a;
                case 6: goto L33;
                case 7: goto L65;
                case 8: goto L65;
                default: goto L29;
            }
        L29:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            java.lang.String r0 = defpackage.uo.u(r2)
            r11.<init>(r0)
            throw r11
        L33:
            if (r11 == r1) goto L65
            if (r11 == r9) goto L65
            if (r11 == r8) goto L65
            goto L63
        L3a:
            if (r11 == r7) goto L65
            if (r11 != r6) goto L63
            goto L65
        L3f:
            r1 = 3
            if (r11 == r1) goto L48
            r1 = 5
            if (r11 != r1) goto L46
            goto L48
        L46:
            r1 = 0
            goto L49
        L48:
            r1 = 1
        L49:
            boolean r2 = r4 instanceof defpackage.va0
            if (r2 == 0) goto L52
            if (r1 != 0) goto L63
            if (r11 != r8) goto L65
            goto L63
        L52:
            return r1
        L53:
            if (r11 == r7) goto L5a
            if (r11 != r6) goto L58
            goto L5a
        L58:
            r1 = 0
            goto L5b
        L5a:
            r1 = 1
        L5b:
            boolean r2 = r4 instanceof defpackage.va0
            if (r2 == 0) goto L64
            if (r1 != 0) goto L63
            if (r11 != r9) goto L65
        L63:
            return r3
        L64:
            return r1
        L65:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gm.i(gm):boolean");
    }

    public final void j() {
        HashSet hashSet;
        gm gmVar = this.f;
        if (gmVar != null && (hashSet = gmVar.a) != null) {
            hashSet.remove(this);
            if (this.f.a.size() == 0) {
                this.f.a = null;
            }
        }
        this.a = null;
        this.f = null;
        this.g = 0;
        this.h = RtlSpacingHelper.UNDEFINED;
        this.c = false;
        this.b = 0;
    }

    public final void k() {
        di1 di1Var = this.i;
        if (di1Var == null) {
            this.i = new di1(1);
        } else {
            di1Var.c();
        }
    }

    public final void l(int i) {
        this.b = i;
        this.c = true;
    }

    public final String toString() {
        return this.d.j0 + ":" + uo.u(this.e);
    }
}
