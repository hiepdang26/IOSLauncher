package defpackage;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class q1 extends WeakReference {
    public final i00 a;
    public final boolean b;
    public eb1 c;

    public q1(i00 i00Var, j00 j00Var, ReferenceQueue referenceQueue) {
        super(j00Var, referenceQueue);
        n90.h(i00Var, "Argument must not be null");
        this.a = i00Var;
        boolean z = j00Var.g;
        this.c = null;
        this.b = z;
    }
}
