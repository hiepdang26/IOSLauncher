package defpackage;

import android.content.Context;
import android.content.pm.PackageInstaller;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class r01 extends p02 {
    public final SparseArray m = new SparseArray();
    public final PackageInstaller n;
    public final oe0 o;

    public r01(Context context) {
        q01 q01Var = new q01(this);
        PackageInstaller packageInstaller = context.getPackageManager().getPackageInstaller();
        this.n = packageInstaller;
        this.o = jk0.a().b;
        packageInstaller.registerSessionCallback(q01Var, new Handler(rl0.w.getLooper()));
    }

    @Override // defpackage.p02
    public final HashMap D() {
        HashMap map = new HashMap();
        jq1 jq1VarB = jq1.b();
        for (PackageInstaller.SessionInfo sessionInfo : this.n.getAllSessions()) {
            F(sessionInfo, jq1VarB);
            if (sessionInfo.getAppPackageName() != null) {
                map.put(sessionInfo.getAppPackageName(), Integer.valueOf((int) (sessionInfo.getProgress() * 100.0f)));
                this.m.put(sessionInfo.getSessionId(), sessionInfo.getAppPackageName());
            }
        }
        return map;
    }

    public final void F(PackageInstaller.SessionInfo sessionInfo, jq1 jq1Var) {
        String appPackageName = sessionInfo.getAppPackageName();
        if (appPackageName != null) {
            oe0 oe0Var = this.o;
            Bitmap appIcon = sessionInfo.getAppIcon();
            CharSequence appLabel = sessionInfo.getAppLabel();
            synchronized (oe0Var) {
                try {
                    Objects.toString(jq1Var);
                    Objects.toString(appIcon);
                    Objects.toString(appLabel);
                    oe0Var.E(appPackageName, jq1Var);
                    dl dlVarS = oe0.s(appPackageName, jq1Var);
                    ke0 ke0Var = (ke0) oe0Var.k.get(dlVarS);
                    if (ke0Var == null) {
                        ke0Var = new ke0();
                        oe0Var.k.put(dlVarS, ke0Var);
                    }
                    if (!TextUtils.isEmpty(appLabel)) {
                        ke0Var.b = appLabel;
                    }
                    String strI = oe0Var.i(dlVarS.a);
                    if (strI != null) {
                        ke0Var.b = strI;
                    }
                    if (appIcon != null) {
                        ke0Var.a = ar1.f(oe0Var.g, appIcon);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
