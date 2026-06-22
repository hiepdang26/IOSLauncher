package defpackage;

import android.app.Notification;

/* JADX INFO: loaded from: classes.dex */
public final class yx0 extends fb {
    public CharSequence h;

    @Override // defpackage.fb
    public final void a(qm0 qm0Var) {
        new Notification.BigTextStyle((Notification.Builder) qm0Var.b).setBigContentTitle(null).bigText(this.h);
    }

    @Override // defpackage.fb
    public final String b() {
        return "androidx.core.app.NotificationCompat$BigTextStyle";
    }
}
