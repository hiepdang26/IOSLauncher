package androidx.work.impl.foreground;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import defpackage.ag;
import defpackage.cz1;
import defpackage.el0;
import defpackage.hn0;
import defpackage.ka0;
import defpackage.kl1;
import defpackage.qm0;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class SystemForegroundService extends hn0 {
    public static final /* synthetic */ int l = 0;
    public Handler h;
    public boolean i;
    public kl1 j;
    public NotificationManager k;

    static {
        ka0.r("SystemFgService");
    }

    public final void b() {
        this.h = new Handler(Looper.getMainLooper());
        this.k = (NotificationManager) getApplicationContext().getSystemService("notification");
        kl1 kl1Var = new kl1(getApplicationContext());
        this.j = kl1Var;
        if (kl1Var.o != null) {
            ka0.j().getClass();
        } else {
            kl1Var.o = this;
        }
    }

    @Override // defpackage.hn0, android.app.Service
    public final void onCreate() {
        super.onCreate();
        b();
    }

    @Override // defpackage.hn0, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.j.f();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.i) {
            ka0.j().getClass();
            this.j.f();
            b();
            this.i = false;
        }
        if (intent == null) {
            return 3;
        }
        kl1 kl1Var = this.j;
        kl1Var.getClass();
        String action = intent.getAction();
        if ("ACTION_START_FOREGROUND".equals(action)) {
            ka0 ka0VarJ = ka0.j();
            Objects.toString(intent);
            ka0VarJ.getClass();
            ((qm0) kl1Var.h).e(new el0(kl1Var, intent.getStringExtra("KEY_WORKSPEC_ID"), 11));
            kl1Var.e(intent);
            return 3;
        }
        if ("ACTION_NOTIFY".equals(action)) {
            kl1Var.e(intent);
            return 3;
        }
        if (!"ACTION_CANCEL_WORK".equals(action)) {
            if (!"ACTION_STOP_FOREGROUND".equals(action)) {
                return 3;
            }
            ka0.j().getClass();
            SystemForegroundService systemForegroundService = kl1Var.o;
            if (systemForegroundService == null) {
                return 3;
            }
            systemForegroundService.i = true;
            ka0.j().getClass();
            if (Build.VERSION.SDK_INT >= 26) {
                systemForegroundService.stopForeground(true);
            }
            systemForegroundService.stopSelf();
            return 3;
        }
        ka0 ka0VarJ2 = ka0.j();
        Objects.toString(intent);
        ka0VarJ2.getClass();
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
            return 3;
        }
        UUID uuidFromString = UUID.fromString(stringExtra);
        cz1 cz1Var = kl1Var.g;
        cz1Var.getClass();
        ((qm0) cz1Var.k).e(new ag(cz1Var, uuidFromString));
        return 3;
    }
}
