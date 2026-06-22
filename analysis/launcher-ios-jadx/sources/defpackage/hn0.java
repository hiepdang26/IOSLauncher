package defpackage;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.lifecycle.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class hn0 extends Service implements en0 {
    public final wb2 g = new wb2(this);

    @Override // defpackage.en0
    public final a l() {
        return (a) this.g.h;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        qg0.l(intent, "intent");
        this.g.y(um0.ON_START);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.g.y(um0.ON_CREATE);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        um0 um0Var = um0.ON_STOP;
        wb2 wb2Var = this.g;
        wb2Var.y(um0Var);
        wb2Var.y(um0.ON_DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i) {
        this.g.y(um0.ON_START);
        super.onStart(intent, i);
    }
}
