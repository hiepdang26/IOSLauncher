package defpackage;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class qi0 extends Service {
    public static final Object l = new Object();
    public static final HashMap m = new HashMap();
    public ni0 g;
    public pi0 h;
    public qy i;
    public boolean j = false;
    public final ArrayList k;

    public qi0() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.k = null;
        } else {
            this.k = new ArrayList();
        }
    }

    public static pi0 b(Context context, ComponentName componentName, boolean z, int i) {
        pi0 ji0Var;
        HashMap map = m;
        pi0 pi0Var = (pi0) map.get(componentName);
        if (pi0Var != null) {
            return pi0Var;
        }
        if (Build.VERSION.SDK_INT < 26) {
            ji0Var = new ji0(context, componentName);
        } else {
            if (!z) {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
            ji0Var = new oi0(context, componentName, i);
        }
        map.put(componentName, ji0Var);
        return ji0Var;
    }

    public final void a(boolean z) {
        if (this.i == null) {
            this.i = new qy(this, 2);
            pi0 pi0Var = this.h;
            if (pi0Var != null && z) {
                pi0Var.d();
            }
            this.i.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public final void c() {
        ArrayList arrayList = this.k;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.i = null;
                    ArrayList arrayList2 = this.k;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        a(false);
                    } else if (!this.j) {
                        this.h.c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        ni0 ni0Var = this.g;
        if (ni0Var != null) {
            return ni0Var.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.g = new ni0(this);
            this.h = null;
        } else {
            this.g = null;
            this.h = b(this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.k;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.j = true;
                this.h.c();
            }
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        if (this.k == null) {
            return 2;
        }
        this.h.e();
        synchronized (this.k) {
            ArrayList arrayList = this.k;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new ki0(this, intent, i2));
            a(true);
        }
        return 3;
    }
}
