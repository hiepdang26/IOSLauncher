package com.luutinhit.launcher6;

/* JADX INFO: loaded from: classes.dex */
public final class p implements Runnable {
    public final /* synthetic */ boolean g;
    public final /* synthetic */ Runnable h;
    public final /* synthetic */ t i;

    public p(t tVar, boolean z, Runnable runnable) {
        this.i = tVar;
        this.g = z;
        this.h = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = this.g;
        t tVar = this.i;
        if (!z) {
            tVar.exitSpringLoadedDragMode();
        } else {
            tVar.mWidgetsView.setVisibility(8);
            tVar.showWorkspace(true, this.h);
        }
    }
}
