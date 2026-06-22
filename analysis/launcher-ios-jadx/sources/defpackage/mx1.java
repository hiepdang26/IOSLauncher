package defpackage;

import android.view.View;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import com.luutinhit.launcher6.widget.view.SlidingUpWidgetsCellAppStyle;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class mx1 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ WidgetsContainerView h;

    public /* synthetic */ mx1(WidgetsContainerView widgetsContainerView, int i) {
        this.g = i;
        this.h = widgetsContainerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SlidingUpWidgetsCellAppStyle slidingUpWidgetsCellAppStyle;
        switch (this.g) {
            case 0:
                t tVar = this.h.P;
                tVar.mWidgetsAppStyle.requestFocus();
                tVar.mWidgetsAppStyle.setVisibility(0);
                tVar.mWidgetsAppStyle.setPanelState(rh1.g);
                break;
            case 1:
                t tVar2 = this.h.P;
                tVar2.mWidgetsAppStyle.clearFocus();
                tVar2.mWidgetsAppStyle.setVisibility(8);
                tVar2.mWidgetsAppStyle.Q.setAdapter(null);
                tVar2.mWidgetsAppStyle.setPanelStateInternal(rh1.h);
                tVar2.mWidgetsAppStyle.f();
                break;
            default:
                WidgetsContainerView widgetsContainerView = this.h;
                t tVar3 = widgetsContainerView.P;
                if (tVar3.mWidgetsAppStyle.isShown() && (slidingUpWidgetsCellAppStyle = widgetsContainerView.P.mWidgetsAppStyle) != null) {
                    slidingUpWidgetsCellAppStyle.postOnAnimation(new mx1(widgetsContainerView, 1));
                }
                tVar3.closeWidgetView(true);
                View dragView = widgetsContainerView.getDragView();
                if (dragView != null) {
                    dragView.setScaleX(1.0f);
                    dragView.setScaleY(1.0f);
                }
                break;
        }
    }
}
