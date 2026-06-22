package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class sk {
    public final Object a;
    public final zg0 b;
    public final o70 c;
    public final Object d;
    public final Throwable e;

    public sk(Object obj, zg0 zg0Var, o70 o70Var, Object obj2, Throwable th) {
        this.a = obj;
        this.b = zg0Var;
        this.c = o70Var;
        this.d = obj2;
        this.e = th;
    }

    public static sk a(sk skVar, zg0 zg0Var, CancellationException cancellationException, int i) {
        Object obj = skVar.a;
        if ((i & 2) != 0) {
            zg0Var = skVar.b;
        }
        zg0 zg0Var2 = zg0Var;
        o70 o70Var = skVar.c;
        Object obj2 = skVar.d;
        Throwable th = cancellationException;
        if ((i & 16) != 0) {
            th = skVar.e;
        }
        skVar.getClass();
        return new sk(obj, zg0Var2, o70Var, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof sk)) {
            return false;
        }
        sk skVar = (sk) obj;
        return qg0.d(this.a, skVar.a) && qg0.d(this.b, skVar.b) && qg0.d(this.c, skVar.c) && qg0.d(this.d, skVar.d) && qg0.d(this.e, skVar.e);
    }

    public final int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        zg0 zg0Var = this.b;
        int iHashCode2 = (iHashCode + (zg0Var == null ? 0 : zg0Var.hashCode())) * 31;
        o70 o70Var = this.c;
        int iHashCode3 = (iHashCode2 + (o70Var == null ? 0 : o70Var.hashCode())) * 31;
        Object obj2 = this.d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + ')';
    }

    public /* synthetic */ sk(Object obj, zg0 zg0Var, jz0 jz0Var, CancellationException cancellationException, int i) {
        this(obj, (i & 2) != 0 ? null : zg0Var, (i & 4) != 0 ? null : jz0Var, (Object) null, (i & 16) != 0 ? null : cancellationException);
    }
}
