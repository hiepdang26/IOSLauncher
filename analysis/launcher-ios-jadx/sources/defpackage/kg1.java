package defpackage;

import android.animation.ValueAnimator;
import android.view.View;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.t;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class kg1 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ ng1 h;

    public /* synthetic */ kg1(ng1 ng1Var, int i) {
        this.g = i;
        this.h = ng1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map;
        switch (this.g) {
            case 0:
                t tVar = this.h.o;
                if (tVar.autoRearrange) {
                    tVar.rearrangeApps(false);
                }
                break;
            case 1:
                ng1 ng1Var = this.h;
                HashMap map2 = ng1Var.s;
                if (map2 != null) {
                    for (View view : map2.keySet()) {
                        if (view instanceof BubbleTextView) {
                            ((BubbleTextView) view).y();
                        } else if (view instanceof pk0) {
                            ((pk0) view).c();
                        }
                        ((ValueAnimator) ng1Var.s.get(view)).start();
                    }
                }
                break;
            default:
                ng1 ng1Var2 = this.h;
                if (ng1Var2.s != null && (map = ng1Var2.t) != null) {
                    for (View view2 : map.keySet()) {
                        view2.post(new wc(this, view2, 17));
                    }
                    break;
                }
                break;
        }
    }
}
