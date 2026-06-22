package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;

/* JADX INFO: loaded from: classes.dex */
public final class ji0 extends pi0 {
    public final Context d;
    public final PowerManager.WakeLock e;
    public final PowerManager.WakeLock f;
    public boolean g;
    public boolean h;

    public ji0(Context context, ComponentName componentName) {
        super(componentName);
        this.d = context.getApplicationContext();
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
        this.e = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
        PowerManager.WakeLock wakeLockNewWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
        this.f = wakeLockNewWakeLock2;
        wakeLockNewWakeLock2.setReferenceCounted(false);
    }

    @Override // defpackage.pi0
    public final void a(Intent intent) {
        Intent intent2 = new Intent(intent);
        intent2.setComponent(this.a);
        if (this.d.startService(intent2) != null) {
            synchronized (this) {
                try {
                    if (!this.g) {
                        this.g = true;
                        if (!this.h) {
                            this.e.acquire(60000L);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // defpackage.pi0
    public final void c() {
        synchronized (this) {
            try {
                if (this.h) {
                    if (this.g) {
                        this.e.acquire(60000L);
                    }
                    this.h = false;
                    this.f.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.pi0
    public final void d() {
        synchronized (this) {
            try {
                if (!this.h) {
                    this.h = true;
                    this.f.acquire(600000L);
                    this.e.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.pi0
    public final void e() {
        synchronized (this) {
            this.g = false;
        }
    }
}
