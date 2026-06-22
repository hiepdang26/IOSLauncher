package defpackage;

import android.content.IntentFilter;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class fh1 implements Runnable {
    public final /* synthetic */ int g;
    public final /* synthetic */ gh1 h;

    public /* synthetic */ fh1(gh1 gh1Var, int i) {
        this.g = i;
        this.h = gh1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.g) {
            case 0:
                gh1 gh1Var = this.h;
                gh1Var.j = gh1Var.c();
                try {
                    gh1 gh1Var2 = this.h;
                    gh1Var2.g.registerReceiver(gh1Var2.l, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    this.h.k = true;
                } catch (SecurityException unused) {
                    Log.isLoggable("ConnectivityMonitor", 5);
                    this.h.k = false;
                    return;
                }
                break;
            case 1:
                if (this.h.k) {
                    this.h.k = false;
                    gh1 gh1Var3 = this.h;
                    gh1Var3.g.unregisterReceiver(gh1Var3.l);
                    break;
                }
                break;
            default:
                boolean z = this.h.j;
                gh1 gh1Var4 = this.h;
                gh1Var4.j = gh1Var4.c();
                if (z != this.h.j) {
                    if (Log.isLoggable("ConnectivityMonitor", 3)) {
                        boolean z2 = this.h.j;
                    }
                    gh1 gh1Var5 = this.h;
                    vq1.f().post(new eh1(gh1Var5, gh1Var5.j, 1));
                }
                break;
        }
    }
}
