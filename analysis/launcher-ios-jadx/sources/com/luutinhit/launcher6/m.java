package com.luutinhit.launcher6;

import android.view.View;
import defpackage.r1;
import defpackage.rh1;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ t h;

    public /* synthetic */ m(t tVar, int i) {
        this.g = i;
        this.h = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                Workspace workspace = this.h.mWorkspace;
                if (workspace != null) {
                    int i = workspace.x0;
                    if (!workspace.h1()) {
                        workspace.Z(i);
                    }
                    View childAt = workspace.getChildAt(i);
                    if (childAt != null) {
                        childAt.requestFocus();
                    }
                }
                break;
            case 1:
                t tVar = this.h;
                tVar.cancelShakingAnimation();
                tVar.mWidgetsView.requestFocus();
                tVar.mWidgetsView.setVisibility(0);
                tVar.mWidgetsView.setPanelState(rh1.g);
                break;
            case 2:
                t tVar2 = this.h;
                tVar2.bindAllApplications(tVar2.mTmpAppsList);
                tVar2.mTmpAppsList = null;
                break;
            case 3:
                Workspace workspace2 = this.h.mWorkspace;
                if (workspace2 != null) {
                    workspace2.d1(true);
                    if (workspace2.getWindowToken() != null) {
                        int childCount = workspace2.getChildCount();
                        for (int i2 = 0; i2 < childCount; i2++) {
                            CellLayout cellLayout = (CellLayout) workspace2.getChildAt(i2);
                            cellLayout.getClass();
                            cellLayout.post(new r1(cellLayout, 4));
                        }
                    }
                    workspace2.d1(false);
                }
                break;
            case 4:
                t tVar3 = this.h;
                tVar3.bindWidgetsModel(tVar3.mWidgetsModel);
                break;
            default:
                t tVar4 = this.h;
                tVar4.mDragLayer.dismissOverlayView();
                tVar4.showFirstRunClings();
                break;
        }
    }
}
