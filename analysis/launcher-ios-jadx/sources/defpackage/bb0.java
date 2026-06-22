package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class bb0 extends Handler {
    public final v21 a;
    public final int b;
    public final r00 c;
    public boolean d;

    public bb0(r00 r00Var, Looper looper) {
        super(looper);
        this.c = r00Var;
        this.b = 10;
        this.a = new v21(6);
    }

    public final void a(nk1 nk1Var, Object obj) {
        y11 y11VarA = y11.a(nk1Var, obj);
        synchronized (this) {
            try {
                this.a.e(y11VarA);
                if (!this.d) {
                    this.d = true;
                    if (!sendMessage(obtainMessage())) {
                        throw new wk("Could not send handler message", 2);
                    }
                }
            } finally {
            }
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            do {
                y11 y11VarT = this.a.t();
                if (y11VarT == null) {
                    synchronized (this) {
                        y11VarT = this.a.t();
                        if (y11VarT == null) {
                            this.d = false;
                            return;
                        }
                    }
                }
                this.c.c(y11VarT);
            } while (SystemClock.uptimeMillis() - jUptimeMillis < this.b);
            if (!sendMessage(obtainMessage())) {
                throw new wk("Could not send handler message", 2);
            }
            this.d = true;
        } catch (Throwable th) {
            this.d = false;
            throw th;
        }
    }
}
