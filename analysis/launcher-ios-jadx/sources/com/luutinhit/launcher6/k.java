package com.luutinhit.launcher6;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class k implements ViewTreeObserver.OnDrawListener {
    public boolean a = false;
    public final /* synthetic */ t b;

    public k(t tVar) {
        this.b = tVar;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        if (this.a) {
            return;
        }
        this.a = true;
        t tVar = this.b;
        tVar.mWorkspace.postDelayed(tVar.mBuildLayersRunnable, 500L);
        tVar.mWorkspace.post(new j(this, this));
    }
}
