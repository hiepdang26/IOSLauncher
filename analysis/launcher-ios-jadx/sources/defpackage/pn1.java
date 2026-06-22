package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public class pn1 {
    public static final AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(pn1.class, "_size");
    private volatile int _size;
}
