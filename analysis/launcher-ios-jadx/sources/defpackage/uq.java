package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.luutinhit.launcher6.leftpage.SlidingUpWidgetsAppStyle;
import com.luutinhit.launcher6.leftpage.SlidingUpWidgetsList;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import com.luutinhit.launcher6.widget.view.SlidingUpWidgetsCellAppStyle;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class uq implements qh1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ ViewGroup b;

    public /* synthetic */ uq(ViewGroup viewGroup, int i) {
        this.a = i;
        this.b = viewGroup;
    }

    @Override // defpackage.qh1
    public final void a(View view, float f) {
        View dragView;
        View dragView2;
        switch (this.a) {
            case 0:
                Objects.toString(view);
                SlidingUpWidgetsList slidingUpWidgetsList = ((wq) this.b).p;
                if (slidingUpWidgetsList != null && (dragView = slidingUpWidgetsList.getDragView()) != null) {
                    float f2 = 1.0f - (f * 0.05f);
                    dragView.animate().withLayer().scaleX(f2).scaleY(f2).setDuration(0L).setInterpolator(new DecelerateInterpolator()).start();
                    break;
                }
                break;
            default:
                Objects.toString(view);
                WidgetsContainerView widgetsContainerView = (WidgetsContainerView) this.b;
                if (widgetsContainerView != null && (dragView2 = widgetsContainerView.getDragView()) != null) {
                    float f3 = 1.0f - (f * 0.05f);
                    dragView2.animate().withLayer().scaleX(f3).scaleY(f3).setDuration(0L).setInterpolator(new DecelerateInterpolator()).start();
                    break;
                }
                break;
        }
    }

    @Override // defpackage.qh1
    public final void b(rh1 rh1Var) {
        wq wqVar;
        SlidingUpWidgetsAppStyle slidingUpWidgetsAppStyle;
        switch (this.a) {
            case 0:
                if (rh1Var == rh1.h && (slidingUpWidgetsAppStyle = (wqVar = (wq) this.b).q) != null) {
                    slidingUpWidgetsAppStyle.postOnAnimation(new rq(wqVar, 7));
                    break;
                }
                break;
            default:
                if (rh1Var == rh1.h) {
                    WidgetsContainerView widgetsContainerView = (WidgetsContainerView) this.b;
                    SlidingUpWidgetsCellAppStyle slidingUpWidgetsCellAppStyle = widgetsContainerView.P.mWidgetsAppStyle;
                    if (slidingUpWidgetsCellAppStyle != null) {
                        slidingUpWidgetsCellAppStyle.postOnAnimation(new mx1(widgetsContainerView, 1));
                    }
                }
                break;
        }
    }
}
