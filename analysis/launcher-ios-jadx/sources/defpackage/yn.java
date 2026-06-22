package defpackage;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class yn extends FilterInputStream {
    public final long g;
    public int h;

    public yn(InputStream inputStream, long j) {
        super(inputStream);
        this.g = j;
    }

    public final void a(int i) throws IOException {
        if (i >= 0) {
            this.h += i;
            return;
        }
        long j = this.h;
        long j2 = this.g;
        if (j2 - j <= 0) {
            return;
        }
        throw new IOException("Failed to read all expected data, expected: " + j2 + ", but read: " + this.h);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        return (int) Math.max(this.g - ((long) this.h), ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        int i;
        i = super.read();
        a(i >= 0 ? 1 : -1);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i, int i2) {
        int i3;
        i3 = super.read(bArr, i, i2);
        a(i3);
        return i3;
    }
}
