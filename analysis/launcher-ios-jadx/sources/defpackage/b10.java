package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class b10 extends InputStream implements AutoCloseable {
    public static final ArrayDeque i;
    public k81 g;
    public IOException h;

    static {
        char[] cArr = vq1.a;
        i = new ArrayDeque(0);
    }

    public final void a() {
        this.h = null;
        this.g = null;
        ArrayDeque arrayDeque = i;
        synchronized (arrayDeque) {
            arrayDeque.offer(this);
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.g.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.g.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i2) {
        this.g.mark(i2);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        this.g.getClass();
        return true;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        try {
            return this.g.read();
        } catch (IOException e) {
            this.h = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.g.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j) throws IOException {
        try {
            return this.g.skip(j);
        } catch (IOException e) {
            this.h = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        try {
            return this.g.read(bArr);
        } catch (IOException e) {
            this.h = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        try {
            return this.g.read(bArr, i2, i3);
        } catch (IOException e) {
            this.h = e;
            throw e;
        }
    }
}
