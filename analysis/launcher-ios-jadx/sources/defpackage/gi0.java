package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class gi0 extends CancellationException {
    public final transient xi0 g;

    public gi0(String str, Throwable th, xi0 xi0Var) {
        super(str);
        this.g = xi0Var;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gi0)) {
            return false;
        }
        gi0 gi0Var = (gi0) obj;
        return qg0.d(gi0Var.getMessage(), getMessage()) && qg0.d(gi0Var.g, this.g) && qg0.d(gi0Var.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        qg0.h(message);
        int iHashCode = (this.g.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.g;
    }
}
