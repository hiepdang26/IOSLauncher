package defpackage;

import android.widget.RemoteViews;

/* JADX INFO: loaded from: classes.dex */
public final class ok0 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ pk0 h;

    public /* synthetic */ ok0(pk0 pk0Var, int i) {
        this.g = i;
        this.h = pk0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                this.h.z.start();
                break;
            default:
                pk0 pk0Var = this.h;
                pk0Var.updateAppWidget(new RemoteViews(pk0Var.getAppWidgetInfo().provider.getPackageName(), 0));
                break;
        }
    }
}
