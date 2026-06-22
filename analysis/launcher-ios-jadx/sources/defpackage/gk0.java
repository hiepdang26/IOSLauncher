package defpackage;

import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.content.pm.LauncherActivityInfo;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class gk0 extends ek0 {
    public final LauncherActivityInfo a;

    public gk0(LauncherActivityInfo launcherActivityInfo) {
        this.a = launcherActivityInfo;
    }

    @Override // defpackage.ek0
    public final ApplicationInfo a() {
        return this.a.getApplicationInfo();
    }

    @Override // defpackage.ek0
    public final ComponentName b() {
        return this.a.getComponentName();
    }

    @Override // defpackage.ek0
    public final long c() {
        return this.a.getFirstInstallTime();
    }

    @Override // defpackage.ek0
    public final Drawable d(int i) {
        return this.a.getIcon(i);
    }

    @Override // defpackage.ek0
    public final CharSequence e() {
        return this.a.getLabel();
    }

    @Override // defpackage.ek0
    public final jq1 f() {
        return jq1.a(this.a.getUser());
    }
}
