package defpackage;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class rw extends ts1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ rw(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.ts1
    public final int a(int i, View view) {
        switch (this.a) {
            case 0:
                vw vwVar = (vw) this.b;
                if (view != vwVar.mAppsLibrary) {
                    return i;
                }
                Objects.toString(view);
                if (!vwVar.isLayoutRtlSupport()) {
                    int paddingLeft = vwVar.getPaddingLeft();
                    return Math.min(Math.max(i, paddingLeft), vwVar.mRange + paddingLeft);
                }
                int width = vwVar.getWidth() - (vwVar.mAppsLibrary.getWidth() + vwVar.getPaddingRight());
                return Math.max(Math.min(i, width), width - vwVar.mRange);
            case 1:
                vw vwVar2 = (vw) this.b;
                if (view != vwVar2.mLeftPage) {
                    return i;
                }
                Objects.toString(view);
                if (vwVar2.isLayoutRtlSupport()) {
                    int paddingLeft2 = vwVar2.getPaddingLeft();
                    return Math.min(Math.max(i, paddingLeft2), vwVar2.mRange + paddingLeft2);
                }
                int width2 = vwVar2.getWidth() - (vwVar2.mLeftPage.getWidth() + vwVar2.getPaddingRight());
                return Math.max(Math.min(i, width2), width2 - vwVar2.mRange);
            default:
                return view.getLeft();
        }
    }

    @Override // defpackage.ts1
    public int b(View view, int i) {
        switch (this.a) {
            case 2:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.b;
                int iX = bottomSheetBehavior.x();
                int i2 = bottomSheetBehavior.G ? bottomSheetBehavior.Q : bottomSheetBehavior.E;
                return i < iX ? iX : i > i2 ? i2 : i;
            default:
                return super.b(view, i);
        }
    }

    @Override // defpackage.ts1
    public int c(View view) {
        switch (this.a) {
            case 0:
                return ((vw) this.b).mWidth;
            case 1:
                Objects.toString(view);
                return ((vw) this.b).mWidth;
            default:
                return super.c(view);
        }
    }

    @Override // defpackage.ts1
    public int d() {
        switch (this.a) {
            case 2:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.b;
                return bottomSheetBehavior.G ? bottomSheetBehavior.Q : bottomSheetBehavior.E;
            default:
                return super.d();
        }
    }

    @Override // defpackage.ts1
    public void h(int i) {
        switch (this.a) {
            case 2:
                if (i == 1) {
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.b;
                    if (bottomSheetBehavior.I) {
                        bottomSheetBehavior.B(1);
                    }
                }
                break;
        }
    }

    @Override // defpackage.ts1
    public final void i(View view, int i, int i2) {
        switch (this.a) {
            case 0:
                Objects.toString(view);
                vw vwVar = (vw) this.b;
                if (vwVar.isLayoutRtlSupport()) {
                    if (view == vwVar.mAppsLibrary) {
                        vwVar.mLeftOfAppsLibrary = i;
                    } else {
                        vwVar.mLeftOfAppsLibrary -= i;
                    }
                    if (vwVar.mLeftOfAppsLibrary > 0) {
                        vwVar.mLeftOfAppsLibrary = 0;
                    } else if (vwVar.mLeftOfAppsLibrary < (-vwVar.mRange)) {
                        vwVar.mLeftOfAppsLibrary = -vwVar.mRange;
                    }
                } else {
                    if (view == vwVar.mAppsLibrary) {
                        vwVar.mLeftOfAppsLibrary = i;
                    } else {
                        vwVar.mLeftOfAppsLibrary += i;
                    }
                    if (vwVar.mLeftOfAppsLibrary < 0) {
                        vwVar.mLeftOfAppsLibrary = 0;
                    } else if (vwVar.mLeftOfAppsLibrary > vwVar.mRange) {
                        vwVar.mLeftOfAppsLibrary = vwVar.mRange;
                    }
                }
                int unused = vwVar.mLeftOfAppsLibrary;
                if (view == vwVar.mDragLayer) {
                    vwVar.mDragLayer.layout(0, 0, vwVar.mWidth, vwVar.mHeight);
                    vwVar.mAppsLibrary.layout(vwVar.mLeftOfAppsLibrary, 0, vwVar.mWidth + vwVar.mLeftOfAppsLibrary, vwVar.mHeight);
                }
                int unused2 = vwVar.mLeftOfAppsLibrary;
                break;
            case 1:
                Objects.toString(view);
                vw vwVar2 = (vw) this.b;
                if (vwVar2.isLayoutRtlSupport()) {
                    if (view == vwVar2.mLeftPage) {
                        vwVar2.mLeftOfLeftPage = i;
                    } else {
                        vwVar2.mLeftOfLeftPage += i;
                    }
                    if (vwVar2.mLeftOfLeftPage < 0) {
                        vwVar2.mLeftOfLeftPage = 0;
                    } else if (vwVar2.mLeftOfLeftPage > vwVar2.mRange) {
                        vwVar2.mLeftOfLeftPage = vwVar2.mRange;
                    }
                } else {
                    if (view == vwVar2.mLeftPage) {
                        vwVar2.mLeftOfLeftPage = i;
                    } else {
                        vwVar2.mLeftOfLeftPage -= i;
                    }
                    if (vwVar2.mLeftOfLeftPage > 0) {
                        vwVar2.mLeftOfLeftPage = 0;
                    } else if (vwVar2.mLeftOfLeftPage < (-vwVar2.mRange)) {
                        vwVar2.mLeftOfLeftPage = -vwVar2.mRange;
                    }
                }
                int unused3 = vwVar2.mLeftOfLeftPage;
                if (view == vwVar2.mDragLayer) {
                    vwVar2.mDragLayer.layout(0, 0, vwVar2.mWidth, vwVar2.mHeight);
                    vwVar2.mLeftPage.layout(vwVar2.mLeftOfLeftPage, 0, vwVar2.mWidth + vwVar2.mLeftOfLeftPage, vwVar2.mHeight);
                }
                int unused4 = vwVar2.mLeftOfLeftPage;
                break;
            default:
                ((BottomSheetBehavior) this.b).u(i2);
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // defpackage.ts1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(android.view.View r10, float r11, float r12) {
        /*
            Method dump skipped, instruction units count: 606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rw.j(android.view.View, float, float):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0031  */
    @Override // defpackage.ts1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(int r5, android.view.View r6) {
        /*
            r4 = this;
            int r0 = r4.a
            switch(r0) {
                case 0: goto L6d;
                case 1: goto L41;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = r4.b
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r0
            int r1 = r0.J
            r2 = 1
            if (r1 != r2) goto Lf
            goto L3f
        Lf:
            boolean r3 = r0.X
            if (r3 == 0) goto L14
            goto L3f
        L14:
            r3 = 3
            if (r1 != r3) goto L31
            int r1 = r0.V
            if (r1 != r5) goto L31
            java.lang.ref.WeakReference r5 = r0.S
            if (r5 == 0) goto L26
            java.lang.Object r5 = r5.get()
            android.view.View r5 = (android.view.View) r5
            goto L27
        L26:
            r5 = 0
        L27:
            if (r5 == 0) goto L31
            r1 = -1
            boolean r5 = r5.canScrollVertically(r1)
            if (r5 == 0) goto L31
            goto L3f
        L31:
            java.lang.System.currentTimeMillis()
            java.lang.ref.WeakReference r5 = r0.R
            if (r5 == 0) goto L3f
            java.lang.Object r5 = r5.get()
            if (r5 != r6) goto L3f
            goto L40
        L3f:
            r2 = 0
        L40:
            return r2
        L41:
            java.util.Objects.toString(r6)
            java.lang.Object r5 = r4.b
            vw r5 = (defpackage.vw) r5
            android.view.View r0 = defpackage.vw.f(r5)
            if (r6 != r0) goto L6b
            android.view.View r6 = defpackage.vw.f(r5)
            boolean r6 = r6 instanceof defpackage.wq
            if (r6 == 0) goto L6b
            android.view.View r5 = defpackage.vw.f(r5)
            wq r5 = (defpackage.wq) r5
            com.luutinhit.launcher6.leftpage.SlidingUpWidgetsAppStyle r5 = r5.q
            if (r5 == 0) goto L69
            rh1 r5 = r5.getPanelState()
            rh1 r6 = defpackage.rh1.g
            if (r5 != r6) goto L69
            goto L6b
        L69:
            r5 = 1
            goto L6c
        L6b:
            r5 = 0
        L6c:
            return r5
        L6d:
            java.lang.Object r5 = r4.b
            vw r5 = (defpackage.vw) r5
            android.view.View r5 = defpackage.vw.a(r5)
            if (r6 != r5) goto L79
            r5 = 1
            goto L7a
        L79:
            r5 = 0
        L7a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rw.k(int, android.view.View):boolean");
    }
}
