package com.luutinhit.launcher6;

/* JADX INFO: loaded from: classes.dex */
public final class r implements Runnable {
    public final /* synthetic */ long g;
    public final /* synthetic */ t h;

    public r(t tVar, long j) {
        this.h = tVar;
        this.g = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Workspace workspace = this.h.mWorkspace;
        workspace.a0(workspace.E0(this.g), 950);
    }
}
