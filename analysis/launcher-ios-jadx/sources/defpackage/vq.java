package defpackage;

import android.view.View;
import android.view.ViewGroup;
import com.luutinhit.launcher6.editscreen.SlidingUpCustomizeColorIconStyle;
import com.luutinhit.launcher6.leftpage.SlidingUpWidgetsList;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class vq implements qh1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ ViewGroup b;

    public /* synthetic */ vq(ViewGroup viewGroup, int i) {
        this.a = i;
        this.b = viewGroup;
    }

    @Override // defpackage.qh1
    public final void a(View view, float f) {
        Objects.toString(view);
    }

    @Override // defpackage.qh1
    public final void b(rh1 rh1Var) {
        rh1 rh1Var2 = rh1.k;
        rh1 rh1Var3 = rh1.g;
        int i = 2;
        ViewGroup viewGroup = this.b;
        rh1 rh1Var4 = rh1.h;
        switch (this.a) {
            case 0:
                Objects.toString(rh1Var);
                wq wqVar = (wq) viewGroup;
                if (rh1Var == rh1Var4) {
                    SlidingUpWidgetsList slidingUpWidgetsList = wqVar.p;
                    if (slidingUpWidgetsList != null) {
                        slidingUpWidgetsList.postOnAnimation(new rq(wqVar, 6));
                    }
                } else if (rh1Var == rh1Var3) {
                    wqVar.n();
                    wqVar.o.setVisibility(8);
                    wqVar.n.setVisibility(8);
                } else if (rh1Var == rh1Var2) {
                    wqVar.o();
                    wqVar.o.setVisibility(0);
                    wqVar.n.setVisibility(0);
                }
                break;
            case 1:
                if (rh1Var == rh1Var4) {
                    int i2 = SlidingUpCustomizeColorIconStyle.b0;
                    SlidingUpCustomizeColorIconStyle slidingUpCustomizeColorIconStyle = (SlidingUpCustomizeColorIconStyle) viewGroup;
                    slidingUpCustomizeColorIconStyle.postOnAnimation(new nh1(slidingUpCustomizeColorIconStyle, i));
                }
                break;
            default:
                Objects.toString(rh1Var);
                WidgetsContainerView widgetsContainerView = (WidgetsContainerView) viewGroup;
                if (rh1Var == rh1Var4) {
                    int i3 = WidgetsContainerView.i0;
                    widgetsContainerView.postOnAnimation(new mx1(widgetsContainerView, i));
                } else if (rh1Var == rh1Var3) {
                    widgetsContainerView.P.cancelShakingAnimation();
                } else if (rh1Var == rh1Var2) {
                    widgetsContainerView.P.onShakingAllApps();
                }
                break;
        }
    }
}
