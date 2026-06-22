package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class bp1 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public xo1 g;
    public ViewGroup h;

    /* JADX WARN: Removed duplicated region for block: B:105:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01de A[EDGE_INSN: B:132:0x01de->B:88:0x01de BREAK  A[LOOP:1: B:18:0x0085->B:87:0x01d6], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0206  */
    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onPreDraw() {
        /*
            Method dump skipped, instruction units count: 677
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bp1.onPreDraw():boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        ViewGroup viewGroup = this.h;
        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
        viewGroup.removeOnAttachStateChangeListener(this);
        ArrayList arrayList = cp1.c;
        ViewGroup viewGroup2 = this.h;
        arrayList.remove(viewGroup2);
        ArrayList arrayList2 = (ArrayList) cp1.b().get(viewGroup2);
        if (arrayList2 != null && arrayList2.size() > 0) {
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                ((xo1) obj).v(viewGroup2);
            }
        }
        this.g.h(true);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
