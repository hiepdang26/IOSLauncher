package com.luutinhit.launcher6;

import defpackage.w1;

/* JADX INFO: loaded from: classes.dex */
public final class q implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ w1 h;
    public final /* synthetic */ t i;

    public q(t tVar, int i, w1 w1Var) {
        this.i = tVar;
        this.g = i;
        this.h = w1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t tVar = this.i;
        Workspace workspace = tVar.mWorkspace;
        if (workspace != null) {
            workspace.Z(this.g);
            tVar.mWorkspace.postDelayed(this.h, t.NEW_APPS_ANIMATION_DELAY);
        }
    }
}
