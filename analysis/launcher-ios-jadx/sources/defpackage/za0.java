package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class za0 extends cp implements ju {
    private volatile za0 _immediate;
    public final Handler i;
    public final boolean j;
    public final za0 k;

    public za0(Handler handler, boolean z) {
        this.i = handler;
        this.j = z;
        this._immediate = z ? this : null;
        za0 za0Var = this._immediate;
        if (za0Var == null) {
            za0Var = new za0(handler, true);
            this._immediate = za0Var;
        }
        this.k = za0Var;
    }

    @Override // defpackage.cp
    public final boolean B() {
        return (this.j && qg0.d(Looper.myLooper(), this.i.getLooper())) ? false : true;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof za0) && ((za0) obj).i == this.i;
    }

    public final int hashCode() {
        return System.identityHashCode(this.i);
    }

    @Override // defpackage.cp
    public final String toString() {
        za0 za0Var;
        String str;
        xt xtVar = aw.a;
        za0 za0Var2 = kq0.a;
        if (this == za0Var2) {
            str = "Dispatchers.Main";
        } else {
            try {
                za0Var = za0Var2.k;
            } catch (UnsupportedOperationException unused) {
                za0Var = null;
            }
            str = this == za0Var ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.i.toString();
        return this.j ? uo.h(string, ".immediate") : string;
    }

    @Override // defpackage.cp
    public final void z(yo yoVar, Runnable runnable) {
        if (this.i.post(runnable)) {
            return;
        }
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        fi0 fi0Var = (fi0) yoVar.n(iy.i);
        if (fi0Var != null) {
            fi0Var.b(cancellationException);
        }
        aw.b.z(yoVar, runnable);
    }
}
