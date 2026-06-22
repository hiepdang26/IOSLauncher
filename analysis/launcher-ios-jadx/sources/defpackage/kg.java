package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class kg extends uk {
    public static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(kg.class, "_resumed");
    private volatile int _resumed;

    public kg(gg ggVar, Throwable th, boolean z) {
        super(z, th);
        this._resumed = 0;
    }
}
