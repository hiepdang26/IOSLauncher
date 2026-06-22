package defpackage;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class aa0 {
    public static final Object a = new Object();
    public static ad2 b;
    public static HandlerThread c;

    public static ad2 a(Context context) {
        synchronized (a) {
            try {
                if (b == null) {
                    b = new ad2(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return b;
    }

    public static HandlerThread b() {
        synchronized (a) {
            try {
                HandlerThread handlerThread = c;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                c = handlerThread2;
                handlerThread2.start();
                return c;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(String str, String str2, ServiceConnection serviceConnection, boolean z) {
        kc2 kc2Var = new kc2(str, str2, z);
        ad2 ad2Var = (ad2) this;
        hg0.j(serviceConnection, "ServiceConnection must not be null");
        synchronized (ad2Var.d) {
            try {
                oc2 oc2Var = (oc2) ad2Var.d.get(kc2Var);
                if (oc2Var == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: ".concat(kc2Var.toString()));
                }
                if (!oc2Var.a.containsKey(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=".concat(kc2Var.toString()));
                }
                oc2Var.a.remove(serviceConnection);
                if (oc2Var.a.isEmpty()) {
                    ad2Var.f.sendMessageDelayed(ad2Var.f.obtainMessage(0, kc2Var), ad2Var.h);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract boolean d(kc2 kc2Var, g92 g92Var, String str, Executor executor);
}
