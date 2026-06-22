package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class af extends InputStream {
    public final ByteBuffer g;
    public int h = -1;

    public af(ByteBuffer byteBuffer) {
        this.g = byteBuffer;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.g.remaining();
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i) {
        this.h = this.g.position();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer.hasRemaining()) {
            return byteBuffer.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        int i = this.h;
        if (i == -1) {
            throw new IOException("Cannot reset to unset mark position");
        }
        this.g.position(i);
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        ByteBuffer byteBuffer = this.g;
        if (!byteBuffer.hasRemaining()) {
            return -1L;
        }
        long jMin = Math.min(j, byteBuffer.remaining());
        byteBuffer.position((int) (((long) byteBuffer.position()) + jMin));
        return jMin;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        ByteBuffer byteBuffer = this.g;
        if (!byteBuffer.hasRemaining()) {
            return -1;
        }
        int iMin = Math.min(i2, byteBuffer.remaining());
        byteBuffer.get(bArr, i, iMin);
        return iMin;
    }
}
