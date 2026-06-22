package defpackage;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class eb0 extends td1 {
    public final Handler a;

    public eb0(Handler handler) {
        this.a = handler;
    }

    @Override // defpackage.td1
    public final sd1 a() {
        return new cb0(this.a);
    }

    @Override // defpackage.td1
    public final cw c(Runnable runnable) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        Handler handler = this.a;
        db0 db0Var = new db0(handler, runnable);
        handler.sendMessageDelayed(Message.obtain(handler, db0Var), timeUnit.toMillis(0L));
        return db0Var;
    }
}
