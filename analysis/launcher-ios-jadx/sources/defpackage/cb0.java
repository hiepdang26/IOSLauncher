package defpackage;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class cb0 extends sd1 {
    public final Handler g;
    public volatile boolean h;

    public cb0(Handler handler) {
        this.g = handler;
    }

    @Override // defpackage.sd1
    public final cw a(rd1 rd1Var) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        boolean z = this.h;
        tz tzVar = tz.g;
        if (z) {
            return tzVar;
        }
        Handler handler = this.g;
        db0 db0Var = new db0(handler, rd1Var);
        Message messageObtain = Message.obtain(handler, db0Var);
        messageObtain.obj = this;
        this.g.sendMessageDelayed(messageObtain, timeUnit.toMillis(0L));
        if (!this.h) {
            return db0Var;
        }
        this.g.removeCallbacks(db0Var);
        return tzVar;
    }

    @Override // defpackage.cw
    public final void b() {
        this.h = true;
        this.g.removeCallbacksAndMessages(this);
    }
}
