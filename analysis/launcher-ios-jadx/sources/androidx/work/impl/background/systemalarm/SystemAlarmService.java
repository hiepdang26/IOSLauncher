package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import android.os.PowerManager;
import defpackage.hl1;
import defpackage.hn0;
import defpackage.jv1;
import defpackage.ka0;
import defpackage.kv1;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SystemAlarmService extends hn0 {
    public hl1 h;
    public boolean i;

    static {
        ka0.r("SystemAlarmService");
    }

    public final void b() {
        this.i = true;
        ka0.j().getClass();
        int i = jv1.a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (kv1.a) {
            linkedHashMap.putAll(kv1.b);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) entry.getKey();
            if (wakeLock != null && wakeLock.isHeld()) {
                ka0.j().getClass();
            }
        }
        stopSelf();
    }

    @Override // defpackage.hn0, android.app.Service
    public final void onCreate() {
        super.onCreate();
        hl1 hl1Var = new hl1(this);
        this.h = hl1Var;
        if (hl1Var.o != null) {
            ka0.j().getClass();
        } else {
            hl1Var.o = this;
        }
        this.i = false;
    }

    @Override // defpackage.hn0, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.i = true;
        hl1 hl1Var = this.h;
        hl1Var.getClass();
        ka0.j().getClass();
        hl1Var.j.h(hl1Var);
        hl1Var.o = null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.i) {
            ka0.j().getClass();
            hl1 hl1Var = this.h;
            hl1Var.getClass();
            ka0.j().getClass();
            hl1Var.j.h(hl1Var);
            hl1Var.o = null;
            hl1 hl1Var2 = new hl1(this);
            this.h = hl1Var2;
            if (hl1Var2.o != null) {
                ka0.j().getClass();
            } else {
                hl1Var2.o = this;
            }
            this.i = false;
        }
        if (intent == null) {
            return 3;
        }
        this.h.a(i2, intent);
        return 3;
    }
}
