package defpackage;

import android.content.pm.LauncherApps;
import android.os.UserHandle;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class uk0 extends LauncherApps.Callback {
    public rl0 a;

    @Override // android.content.pm.LauncherApps.Callback
    public final void onPackageAdded(String str, UserHandle userHandle) {
        jq1 jq1VarA = jq1.a(userHandle);
        rl0 rl0Var = this.a;
        rl0Var.getClass();
        Objects.toString(jq1VarA);
        rl0.g(new ql0(rl0Var, 1, new String[]{str}, jq1VarA));
    }

    @Override // android.content.pm.LauncherApps.Callback
    public final void onPackageChanged(String str, UserHandle userHandle) {
        jq1 jq1VarA = jq1.a(userHandle);
        rl0 rl0Var = this.a;
        rl0Var.getClass();
        Objects.toString(jq1VarA);
        rl0.g(new ql0(rl0Var, 2, new String[]{str}, jq1VarA));
    }

    @Override // android.content.pm.LauncherApps.Callback
    public final void onPackageRemoved(String str, UserHandle userHandle) {
        jq1 jq1VarA = jq1.a(userHandle);
        rl0 rl0Var = this.a;
        rl0Var.getClass();
        Objects.toString(jq1VarA);
        rl0.g(new ql0(rl0Var, 3, new String[]{str}, jq1VarA));
    }

    @Override // android.content.pm.LauncherApps.Callback
    public final void onPackagesAvailable(String[] strArr, UserHandle userHandle, boolean z) {
        jq1 jq1VarA = jq1.a(userHandle);
        rl0 rl0Var = this.a;
        rl0Var.getClass();
        Objects.toString(jq1VarA);
        rl0.g(new ql0(rl0Var, 2, strArr, jq1VarA));
    }

    @Override // android.content.pm.LauncherApps.Callback
    public final void onPackagesSuspended(String[] strArr, UserHandle userHandle) {
        jq1 jq1VarA = jq1.a(userHandle);
        rl0 rl0Var = this.a;
        rl0Var.getClass();
        Objects.toString(jq1VarA);
        rl0.g(new ql0(rl0Var, 5, strArr, jq1VarA));
    }

    @Override // android.content.pm.LauncherApps.Callback
    public final void onPackagesUnavailable(String[] strArr, UserHandle userHandle, boolean z) {
        jq1 jq1VarA = jq1.a(userHandle);
        rl0 rl0Var = this.a;
        rl0Var.getClass();
        Objects.toString(jq1VarA);
        if (z) {
            return;
        }
        rl0.g(new ql0(rl0Var, 4, strArr, jq1VarA));
    }

    @Override // android.content.pm.LauncherApps.Callback
    public final void onPackagesUnsuspended(String[] strArr, UserHandle userHandle) {
        jq1 jq1VarA = jq1.a(userHandle);
        rl0 rl0Var = this.a;
        rl0Var.getClass();
        Objects.toString(jq1VarA);
        rl0.g(new ql0(rl0Var, 6, strArr, jq1VarA));
    }
}
