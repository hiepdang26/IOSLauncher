package defpackage;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.luutinhit.launcher6.widget.WidgetsContainerView;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g8 implements View.OnTouchListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ ViewGroup h;

    public /* synthetic */ g8(ViewGroup viewGroup, int i) {
        this.g = i;
        this.h = viewGroup;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        ViewGroup viewGroup = this.h;
        switch (this.g) {
            case 0:
                l8 l8Var = (l8) viewGroup;
                l8Var.getClass();
                if (motionEvent.getAction() == 1) {
                    if (l8Var.r) {
                        l8Var.transitionToStart();
                    } else {
                        l8Var.transitionToEnd();
                    }
                }
                return true;
            default:
                int i = WidgetsContainerView.i0;
                WidgetsContainerView widgetsContainerView = (WidgetsContainerView) viewGroup;
                widgetsContainerView.postOnAnimation(new el0(widgetsContainerView, view, 13));
                return false;
        }
    }
}
