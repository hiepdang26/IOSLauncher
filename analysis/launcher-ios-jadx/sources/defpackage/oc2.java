package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class oc2 implements ServiceConnection {
    public final HashMap a = new HashMap();
    public int b = 2;
    public boolean c;
    public IBinder d;
    public final kc2 e;
    public ComponentName f;
    public final /* synthetic */ ad2 g;

    public oc2(ad2 ad2Var, kc2 kc2Var) {
        this.g = ad2Var;
        this.e = kc2Var;
    }

    public final void a(String str, Executor executor) throws Throwable {
        bm bmVar;
        Context context;
        this.b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (Build.VERSION.SDK_INT >= 31) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            ad2 ad2Var = this.g;
            bmVar = ad2Var.g;
            context = ad2Var.e;
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean zC = bmVar.c(context, str, this.e.a(context), this, 4225, executor);
            this.c = zC;
            if (zC) {
                this.g.f.sendMessageDelayed(this.g.f.obtainMessage(1, this.e), this.g.i);
            } else {
                this.b = 2;
                try {
                    ad2 ad2Var2 = this.g;
                    ad2Var2.g.b(ad2Var2.e, this);
                } catch (IllegalArgumentException unused) {
                }
            }
            StrictMode.setVmPolicy(vmPolicy);
        } catch (Throwable th2) {
            th = th2;
            Throwable th3 = th;
            StrictMode.setVmPolicy(vmPolicy);
            throw th3;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.g.d) {
            try {
                this.g.f.removeMessages(1, this.e);
                this.d = iBinder;
                this.f = componentName;
                Iterator it = this.a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.g.d) {
            try {
                this.g.f.removeMessages(1, this.e);
                this.d = null;
                this.f = componentName;
                Iterator it = this.a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
