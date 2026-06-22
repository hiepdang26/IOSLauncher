package defpackage;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: loaded from: classes.dex */
public interface ih1 extends Closeable, Flushable {
    void c(fe feVar, long j);

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    void close();

    void flush();

    yn1 timeout();
}
