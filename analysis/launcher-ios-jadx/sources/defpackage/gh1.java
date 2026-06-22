package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class gh1 implements dh1 {
    public static final Executor m = AsyncTask.SERIAL_EXECUTOR;
    public final Context g;
    public final ch1 h;
    public final zn i;
    public volatile boolean j;
    public volatile boolean k;
    public final m6 l = new m6(this, 5);

    public gh1(Context context, zn znVar, ch1 ch1Var) {
        this.g = context.getApplicationContext();
        this.i = znVar;
        this.h = ch1Var;
    }

    @Override // defpackage.dh1
    public final void a() {
        m.execute(new fh1(this, 1));
    }

    @Override // defpackage.dh1
    public final boolean b() {
        m.execute(new fh1(this, 0));
        return true;
    }

    public final boolean c() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.i.get()).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException unused) {
            Log.isLoggable("ConnectivityMonitor", 5);
            return true;
        }
    }
}
