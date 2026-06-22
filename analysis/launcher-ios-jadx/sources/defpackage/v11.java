package defpackage;

import android.content.pm.ActivityInfo;

/* JADX INFO: loaded from: classes.dex */
public final class v11 extends u11 {
    public ActivityInfo y;

    @Override // defpackage.qh0
    public final String toString() {
        ActivityInfo activityInfo = this.y;
        return "PendingAddShortcutInfo package=" + activityInfo.packageName + ", name=" + activityInfo.name;
    }
}
