package defpackage;

import android.app.Notification;
import android.content.ContextWrapper;
import android.os.Build;
import androidx.work.impl.foreground.SystemForegroundService;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class wj0 implements Runnable {
    public final /* synthetic */ int g = 1;
    public final /* synthetic */ int h;
    public final /* synthetic */ int i;
    public final /* synthetic */ Object j;
    public final /* synthetic */ ContextWrapper k;

    public wj0(SystemForegroundService systemForegroundService, int i, Notification notification, int i2) {
        this.k = systemForegroundService;
        this.h = i;
        this.j = notification;
        this.i = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                ((t) this.k).completeTwoStageWidgetDrop(this.h, this.i);
                ((CellLayout) this.j).setDropPending(false);
                break;
            default:
                int i = Build.VERSION.SDK_INT;
                int i2 = this.i;
                Notification notification = (Notification) this.j;
                int i3 = this.h;
                SystemForegroundService systemForegroundService = (SystemForegroundService) this.k;
                if (i >= 31) {
                    ml1.a(systemForegroundService, i3, notification, i2);
                } else if (i < 29) {
                    systemForegroundService.startForeground(i3, notification);
                } else {
                    ll1.a(systemForegroundService, i3, notification, i2);
                }
                break;
        }
    }

    public wj0(t tVar, int i, int i2, CellLayout cellLayout) {
        this.k = tVar;
        this.h = i;
        this.i = i2;
        this.j = cellLayout;
    }
}
