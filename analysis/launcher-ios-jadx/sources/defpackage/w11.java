package defpackage;

import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.os.Bundle;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class w11 extends u11 {
    public AppWidgetHostView A;
    public Bundle B = null;
    public final int y;
    public final rk0 z;

    public w11(t tVar, rk0 rk0Var) {
        rk0Var.getClass();
        this.h = 4;
        this.z = rk0Var;
        this.w = m7.f(tVar).h(rk0Var);
        this.x = ((AppWidgetProviderInfo) rk0Var).provider;
        this.y = ((AppWidgetProviderInfo) rk0Var).previewImage;
        this.m = rk0Var.g;
        this.n = rk0Var.h;
        this.o = rk0Var.i;
        this.p = rk0Var.j;
    }

    @Override // defpackage.qh0
    public final String toString() {
        return "PendingAddWidgetInfo package=" + this.x.getPackageName() + ", name=" + this.x.getShortClassName();
    }
}
