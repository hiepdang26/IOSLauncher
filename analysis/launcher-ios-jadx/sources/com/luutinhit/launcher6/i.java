package com.luutinhit.launcher6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import defpackage.ar1;
import defpackage.fd;
import defpackage.hl0;
import defpackage.rl0;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class i extends BroadcastReceiver {
    public final /* synthetic */ t a;

    public i(t tVar) {
        this.a = tVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        boolean zEquals = "android.intent.action.SCREEN_OFF".equals(action);
        t tVar = this.a;
        if (zEquals) {
            tVar.mHandler.sendMessage(tVar.mHandler.obtainMessage(2));
            return;
        }
        if ("android.intent.action.USER_PRESENT".equals(action)) {
            tVar.mUserPresent = true;
            tVar.updateAutoAdvanceState();
            return;
        }
        if ("com.luutinhit.launcherios.ACTION_SET_BACKGROUND".equals(action)) {
            fd fdVar = tVar.mBlurWallpaperProvider;
            fdVar.getClass();
            ar1.q.execute(fdVar.p);
            return;
        }
        if ("com.luutinhit.launcherios.ACTION_HIDDEN_APPS_IN_WORKSPACE".equals(action)) {
            try {
                rl0.G = new HashSet(Arrays.asList(intent.getStringArrayExtra("HIDDEN_APPS_REMOVED")));
                return;
            } catch (Throwable th) {
                th.getMessage();
                return;
            }
        }
        if ("com.luutinhit.launcherios.ACTION_RELOAD_WIDGET".equals(action)) {
            Workspace workspace = tVar.mWorkspace;
            if (workspace != null) {
                workspace.getCustomContentCallbacks().getClass();
                return;
            }
            return;
        }
        if (!"com.luutinhit.launcherios.ACTION_FORCE_RELOAD_LAUNCHER".equals(action)) {
            if ("com.luutinhit.SCREEN_UNLOCK".equals(action)) {
                IOSLauncher iOSLauncher = ((com.luutinhit.launcher6.ioslauncher.a) tVar.mLauncherCallbacks).a;
                if (iOSLauncher.isUnlockAnim) {
                    iOSLauncher.prepareOpenAnimation(true);
                    iOSLauncher.startPlayOpenAnimation();
                    return;
                }
                return;
            }
            return;
        }
        tVar.getHotseat().getLayout().getShortcutsAndWidgets().removeAllViews();
        rl0 rl0Var = tVar.mModel;
        rl0Var.w(true);
        hl0 hl0VarL = rl0Var.l();
        if (hl0VarL == null || hl0VarL.setLoadOnResume()) {
            return;
        }
        rl0Var.A(-1001, 0);
    }
}
