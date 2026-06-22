package defpackage;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.Service;
import androidx.work.impl.foreground.SystemForegroundService;

/* JADX INFO: loaded from: classes.dex */
public abstract class ml1 {
    public static void a(Service service, int i, Notification notification, int i2) {
        try {
            service.startForeground(i, notification, i2);
        } catch (ForegroundServiceStartNotAllowedException unused) {
            ka0 ka0VarJ = ka0.j();
            int i3 = SystemForegroundService.l;
            ka0VarJ.getClass();
        }
    }
}
