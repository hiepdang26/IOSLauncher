package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class vw0 {
    public ViewParent a;
    public ViewParent b;
    public final ViewGroup c;
    public boolean d;
    public int[] e;

    public vw0(ViewGroup viewGroup) {
        this.c = viewGroup;
    }

    public final boolean a(float f, float f2, boolean z) {
        ViewParent viewParentE;
        if (this.d && (viewParentE = e(0)) != null) {
            try {
                return viewParentE.onNestedFling(this.c, f, f2, z);
            } catch (AbstractMethodError unused) {
                Objects.toString(viewParentE);
            }
        }
        return false;
    }

    public final boolean b(float f, float f2) {
        ViewParent viewParentE;
        if (this.d && (viewParentE = e(0)) != null) {
            try {
                return viewParentE.onNestedPreFling(this.c, f, f2);
            } catch (AbstractMethodError unused) {
                Objects.toString(viewParentE);
            }
        }
        return false;
    }

    public final boolean c(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        ViewParent viewParentE;
        int i4;
        int i5;
        int[] iArr3;
        if (!this.d || (viewParentE = e(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        ViewGroup viewGroup = this.c;
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.e == null) {
                this.e = new int[2];
            }
            iArr3 = this.e;
        } else {
            iArr3 = iArr;
        }
        iArr3[0] = 0;
        iArr3[1] = 0;
        if (viewParentE instanceof ww0) {
            ((ww0) viewParentE).onNestedPreScroll(viewGroup, i, i2, iArr3, i3);
        } else if (i3 == 0) {
            try {
                viewParentE.onNestedPreScroll(viewGroup, i, i2, iArr3);
            } catch (AbstractMethodError unused) {
                Objects.toString(viewParentE);
            }
        }
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(int r14, int r15, int r16, int r17, int[] r18, int r19, int[] r20) {
        /*
            r13 = this;
            r0 = r18
            r7 = r19
            boolean r1 = r13.d
            r9 = 0
            if (r1 == 0) goto L99
            android.view.ViewParent r2 = r13.e(r7)
            if (r2 != 0) goto L11
            goto L99
        L11:
            r10 = 1
            if (r14 != 0) goto L22
            if (r15 != 0) goto L22
            if (r16 != 0) goto L22
            if (r17 == 0) goto L1b
            goto L22
        L1b:
            if (r0 == 0) goto L99
            r0[r9] = r9
            r0[r10] = r9
            return r9
        L22:
            android.view.ViewGroup r3 = r13.c
            if (r0 == 0) goto L30
            r3.getLocationInWindow(r0)
            r1 = r0[r9]
            r4 = r0[r10]
            r11 = r1
            r12 = r4
            goto L32
        L30:
            r11 = 0
            r12 = 0
        L32:
            if (r20 != 0) goto L45
            int[] r1 = r13.e
            if (r1 != 0) goto L3d
            r1 = 2
            int[] r1 = new int[r1]
            r13.e = r1
        L3d:
            int[] r1 = r13.e
            r1[r9] = r9
            r1[r10] = r9
            r8 = r1
            goto L47
        L45:
            r8 = r20
        L47:
            boolean r1 = r2 instanceof defpackage.xw0
            if (r1 == 0) goto L5a
            r1 = r2
            xw0 r1 = (defpackage.xw0) r1
            r4 = r15
            r5 = r16
            r6 = r17
            r2 = r3
            r3 = r14
            r1.onNestedScroll(r2, r3, r4, r5, r6, r7, r8)
        L58:
            r3 = r2
            goto L89
        L5a:
            r1 = r8[r9]
            int r1 = r1 + r16
            r8[r9] = r1
            r1 = r8[r10]
            int r1 = r1 + r17
            r8[r10] = r1
            boolean r1 = r2 instanceof defpackage.ww0
            if (r1 == 0) goto L7a
            r1 = r2
            ww0 r1 = (defpackage.ww0) r1
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r19
            r2 = r3
            r3 = r14
            r1.onNestedScroll(r2, r3, r4, r5, r6, r7)
            goto L58
        L7a:
            if (r19 != 0) goto L89
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r2.onNestedScroll(r3, r4, r5, r6, r7)     // Catch: java.lang.AbstractMethodError -> L86
            goto L89
        L86:
            java.util.Objects.toString(r2)
        L89:
            if (r0 == 0) goto L98
            r3.getLocationInWindow(r0)
            r14 = r0[r9]
            int r14 = r14 - r11
            r0[r9] = r14
            r14 = r0[r10]
            int r14 = r14 - r12
            r0[r10] = r14
        L98:
            return r10
        L99:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vw0.d(int, int, int, int, int[], int, int[]):boolean");
    }

    public final ViewParent e(int i) {
        if (i == 0) {
            return this.a;
        }
        if (i != 1) {
            return null;
        }
        return this.b;
    }

    public final boolean f(int i) {
        return e(i) != null;
    }

    public final boolean g(int i, int i2) {
        boolean zOnStartNestedScroll;
        if (!f(i2)) {
            if (this.d) {
                View view = this.c;
                View view2 = view;
                for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                    boolean z = parent instanceof ww0;
                    if (z) {
                        zOnStartNestedScroll = ((ww0) parent).onStartNestedScroll(view2, view, i, i2);
                    } else if (i2 == 0) {
                        try {
                            zOnStartNestedScroll = parent.onStartNestedScroll(view2, view, i);
                        } catch (AbstractMethodError unused) {
                            Objects.toString(parent);
                            zOnStartNestedScroll = false;
                        }
                    } else {
                        zOnStartNestedScroll = false;
                    }
                    if (zOnStartNestedScroll) {
                        if (i2 == 0) {
                            this.a = parent;
                        } else if (i2 == 1) {
                            this.b = parent;
                        }
                        if (z) {
                            ((ww0) parent).onNestedScrollAccepted(view2, view, i, i2);
                        } else if (i2 == 0) {
                            try {
                                parent.onNestedScrollAccepted(view2, view, i);
                            } catch (AbstractMethodError unused2) {
                                Objects.toString(parent);
                            }
                        }
                    } else {
                        if (parent instanceof View) {
                            view2 = (View) parent;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void h(int i) {
        ViewParent viewParentE = e(i);
        if (viewParentE != null) {
            boolean z = viewParentE instanceof ww0;
            ViewGroup viewGroup = this.c;
            if (z) {
                ((ww0) viewParentE).onStopNestedScroll(viewGroup, i);
            } else if (i == 0) {
                try {
                    viewParentE.onStopNestedScroll(viewGroup);
                } catch (AbstractMethodError unused) {
                    Objects.toString(viewParentE);
                }
            }
            if (i == 0) {
                this.a = null;
            } else {
                if (i != 1) {
                    return;
                }
                this.b = null;
            }
        }
    }
}
