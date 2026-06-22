package com.luutinhit.launcher6;

import android.appwidget.AppWidgetHostView;
import defpackage.u11;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ AppWidgetHostView h;
    public final /* synthetic */ int i;
    public final /* synthetic */ t j;

    public s(int i, int i2, AppWidgetHostView appWidgetHostView, t tVar) {
        this.j = tVar;
        this.g = i;
        this.h = appWidgetHostView;
        this.i = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t tVar = this.j;
        u11 u11Var = tVar.mPendingAddInfo;
        tVar.completeAddAppWidget(this.g, u11Var.i, u11Var.j, this.h, null);
        this.j.exitSpringLoadedDragModeDelayed(this.i != 0, t.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT, null);
    }
}
