package defpackage;

import android.view.View;
import com.luutinhit.launcher6.allapps.AllAppsRecyclerView;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class x3 {
    public final AllAppsRecyclerView a;
    public final m4 b;
    public String d;
    public String e;
    public boolean f;
    public boolean g;
    public int i;
    public int c = -1;
    public final HashSet h = new HashSet();
    public final int[] j = new int[10];
    public final w3 k = new w3(this, 0);
    public final w3 l = new w3(this, 1);

    public x3(AllAppsRecyclerView allAppsRecyclerView, m4 m4Var) {
        this.a = allAppsRecyclerView;
        this.b = m4Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        for (kb kbVar : this.h) {
            m91 m91VarP = this.a.P((View) kbVar);
            b(kbVar, m91VarP != null ? m91VarP.g() : -1, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(defpackage.kb r4, int r5, boolean r6) {
        /*
            r3 = this;
            o20 r0 = defpackage.o20.NORMAL
            java.lang.String r1 = r3.d
            if (r1 == 0) goto L29
            r1 = -1
            if (r5 <= r1) goto L29
            m4 r1 = r3.b
            java.util.ArrayList r1 = r1.e
            java.lang.Object r5 = r1.get(r5)
            i4 r5 = (defpackage.i4) r5
            java.lang.String r1 = r5.d
            java.lang.String r2 = r3.d
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L26
            int r5 = r5.a
            int r1 = r3.c
            if (r5 != r1) goto L26
            o20 r5 = defpackage.o20.FAST_SCROLL_HIGHLIGHTED
            goto L2a
        L26:
            o20 r5 = defpackage.o20.FAST_SCROLL_UNHIGHLIGHTED
            goto L2a
        L29:
            r5 = r0
        L2a:
            com.luutinhit.launcher6.BubbleTextView r4 = (com.luutinhit.launcher6.BubbleTextView) r4
            android.graphics.drawable.Drawable r1 = r4.h
            boolean r2 = r1 instanceof com.luutinhit.launcher6.FastBitmapDrawable
            if (r2 != 0) goto L33
            goto L89
        L33:
            com.luutinhit.launcher6.FastBitmapDrawable r1 = (com.luutinhit.launcher6.FastBitmapDrawable) r1
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r6 == 0) goto L73
            o20 r6 = r1.c
            boolean r1 = r1.a(r5)
            if (r1 == 0) goto L89
            android.view.ViewPropertyAnimator r4 = r4.animate()
            android.view.ViewPropertyAnimator r4 = r4.withLayer()
            r5.getClass()
            android.view.ViewPropertyAnimator r4 = r4.scaleX(r2)
            android.view.ViewPropertyAnimator r4 = r4.scaleY(r2)
            if (r5 != r0) goto L60
            java.util.Objects.requireNonNull(r6)
            o20 r0 = defpackage.o20.FAST_SCROLL_HIGHLIGHTED
            if (r6 != r0) goto L60
            r0 = 68
            goto L61
        L60:
            r0 = 0
        L61:
            long r0 = (long) r0
            android.view.ViewPropertyAnimator r4 = r4.setStartDelay(r0)
            int r5 = com.luutinhit.launcher6.FastBitmapDrawable.c(r6, r5)
            long r5 = (long) r5
            android.view.ViewPropertyAnimator r4 = r4.setDuration(r5)
            r4.start()
            return
        L73:
            boolean r6 = r1.f(r5)
            if (r6 == 0) goto L89
            android.view.ViewPropertyAnimator r6 = r4.animate()
            r6.cancel()
            r5.getClass()
            r4.setScaleX(r2)
            r4.setScaleY(r2)
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x3.b(kb, int, boolean):void");
    }
}
