package com.luutinhit.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ t h;

    public /* synthetic */ c(t tVar, int i) {
        this.g = i;
        this.h = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                this.h.mWidgetsView.requestFocus();
                break;
            default:
                Workspace workspace = this.h.mWorkspace;
                int i = workspace.x0;
                if (!workspace.h1()) {
                    workspace.setCurrentPage(i);
                }
                View childAt = workspace.getChildAt(i);
                if (childAt != null) {
                    childAt.requestFocus();
                }
                break;
        }
    }
}
