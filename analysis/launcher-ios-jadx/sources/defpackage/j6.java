package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class j6 extends hg0 {
    public final /* synthetic */ int l;
    public final /* synthetic */ Object m;

    public /* synthetic */ j6(Object obj, int i) {
        this.l = i;
        this.m = obj;
    }

    @Override // defpackage.cu1
    public final void onAnimationEnd(View view) {
        Object obj = this.m;
        switch (this.l) {
            case 0:
                q6 q6Var = ((h6) obj).h;
                q6Var.u.setAlpha(1.0f);
                q6Var.x.d(null);
                q6Var.x = null;
                break;
            case 1:
                q6 q6Var2 = (q6) obj;
                q6Var2.u.setAlpha(1.0f);
                q6Var2.x.d(null);
                q6Var2.x = null;
                break;
            default:
                tu tuVar = (tu) obj;
                ((q6) tuVar.i).u.setVisibility(8);
                q6 q6Var3 = (q6) tuVar.i;
                PopupWindow popupWindow = q6Var3.v;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (q6Var3.u.getParent() instanceof View) {
                    View view2 = (View) q6Var3.u.getParent();
                    WeakHashMap weakHashMap = qs1.a;
                    fs1.c(view2);
                }
                q6Var3.u.killMode();
                q6Var3.x.d(null);
                q6Var3.x = null;
                ViewGroup viewGroup = q6Var3.z;
                WeakHashMap weakHashMap2 = qs1.a;
                fs1.c(viewGroup);
                break;
        }
    }

    @Override // defpackage.hg0, defpackage.cu1
    public void onAnimationStart(View view) {
        Object obj = this.m;
        switch (this.l) {
            case 0:
                ((h6) obj).h.u.setVisibility(0);
                break;
            case 1:
                q6 q6Var = (q6) obj;
                q6Var.u.setVisibility(0);
                if (q6Var.u.getParent() instanceof View) {
                    View view2 = (View) q6Var.u.getParent();
                    WeakHashMap weakHashMap = qs1.a;
                    fs1.c(view2);
                }
                break;
        }
    }
}
