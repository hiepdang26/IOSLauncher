package com.luutinhit.launcher6;

/* JADX INFO: loaded from: classes.dex */
public final class j implements Runnable {
    public final /* synthetic */ k g;
    public final /* synthetic */ k h;

    public j(k kVar, k kVar2) {
        this.h = kVar;
        this.g = kVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t tVar = this.h.b;
        Workspace workspace = tVar.mWorkspace;
        if (workspace == null || workspace.getViewTreeObserver() == null) {
            return;
        }
        tVar.mWorkspace.getViewTreeObserver().removeOnDrawListener(this.g);
    }
}
