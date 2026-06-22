package defpackage;

import android.content.pm.PackageInstaller;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class q01 extends PackageInstaller.SessionCallback {
    public final /* synthetic */ r01 a;

    public q01(r01 r01Var) {
        this.a = r01Var;
    }

    public final void a(int i) {
        r01 r01Var = this.a;
        PackageInstaller.SessionInfo sessionInfo = r01Var.n.getSessionInfo(i);
        if (sessionInfo == null || sessionInfo.getAppPackageName() == null) {
            return;
        }
        r01Var.F(sessionInfo, jq1.b());
        jk0 jk0Var = jk0.j;
        if (jk0Var != null) {
            String appPackageName = sessionInfo.getAppPackageName();
            rl0 rl0Var = jk0Var.a;
            rl0Var.getClass();
            rl0.y(new el0(rl0Var, appPackageName, 0));
        }
    }

    @Override // android.content.pm.PackageInstaller.SessionCallback
    public final void onBadgingChanged(int i) {
        a(i);
    }

    @Override // android.content.pm.PackageInstaller.SessionCallback
    public final void onCreated(int i) {
        a(i);
    }

    @Override // android.content.pm.PackageInstaller.SessionCallback
    public final void onFinished(int i, boolean z) {
        r01 r01Var = this.a;
        String str = (String) r01Var.m.get(i);
        r01Var.m.remove(i);
        if (str != null) {
            le0 le0Var = new le0(str, z ? 0 : 2, 0);
            jk0 jk0Var = jk0.j;
            if (jk0Var != null) {
                rl0 rl0Var = jk0Var.a;
                rl0Var.getClass();
                Objects.toString(le0Var);
                rl0.y(new w1(rl0Var, le0Var, 29, false));
            }
        }
    }

    @Override // android.content.pm.PackageInstaller.SessionCallback
    public final void onProgressChanged(int i, float f) {
        PackageInstaller.SessionInfo sessionInfo = this.a.n.getSessionInfo(i);
        if (sessionInfo == null || sessionInfo.getAppPackageName() == null) {
            return;
        }
        le0 le0Var = new le0(sessionInfo.getAppPackageName(), 1, (int) (sessionInfo.getProgress() * 100.0f));
        jk0 jk0Var = jk0.j;
        if (jk0Var != null) {
            rl0 rl0Var = jk0Var.a;
            rl0Var.getClass();
            Objects.toString(le0Var);
            rl0.y(new w1(rl0Var, le0Var, 29, false));
        }
    }

    @Override // android.content.pm.PackageInstaller.SessionCallback
    public final void onActiveChanged(int i, boolean z) {
    }
}
