package com.luutinhit.launcher6;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Advanceable;
import defpackage.ax;
import defpackage.b21;
import defpackage.ta1;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Handler.Callback {
    public final /* synthetic */ int g;
    public final /* synthetic */ t h;

    public /* synthetic */ l(t tVar, int i) {
        this.g = i;
        this.h = tVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.g) {
            case 0:
                int i = message.what;
                int i2 = 0;
                t tVar = this.h;
                if (i == 1) {
                    for (View view : tVar.mWidgetsToAdvance.keySet()) {
                        View viewFindViewById = view.findViewById(tVar.mWidgetsToAdvance.get(view).autoAdvanceViewId);
                        int i3 = i2 * 250;
                        if (viewFindViewById instanceof Advanceable) {
                            tVar.mHandler.postDelayed(new ax(1, viewFindViewById), i3);
                        }
                        i2++;
                    }
                    tVar.sendAdvanceMessage(20000L);
                } else if (i == 2) {
                    tVar.mUserPresent = false;
                    tVar.mDragLayer.clearAllResizeFrames();
                    tVar.updateAutoAdvanceState();
                    if (tVar.getCurrentWorkspaceScreen() == 0) {
                        tVar.moveWorkspaceToDefaultScreen();
                        tVar.showBlurWallpaperBackground(0.0f);
                    }
                }
                break;
            default:
                if (message != null) {
                    try {
                        int i4 = message.what;
                        if (i4 == 0 || i4 == 1) {
                            Workspace workspace = this.h.mWorkspace;
                            workspace.O0(true, new ta1(9));
                            workspace.O0(false, new b21(10));
                        }
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
                break;
        }
        return true;
    }
}
