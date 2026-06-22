package defpackage;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class lg1 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ ng1 h;
    public final /* synthetic */ Runnable i;

    public /* synthetic */ lg1(ng1 ng1Var, Runnable runnable, int i) {
        this.g = i;
        this.h = ng1Var;
        this.i = runnable;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        switch (this.g) {
            case 0:
                ((kg1) this.i).run();
                this.h.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                break;
            default:
                ((kg1) this.i).run();
                this.h.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                break;
        }
    }
}
