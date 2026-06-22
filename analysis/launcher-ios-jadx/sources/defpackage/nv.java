package defpackage;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class nv extends FilterInputStream {
    public final long g;
    public long h;

    public nv(BufferedInputStream bufferedInputStream, long j) {
        super(bufferedInputStream);
        this.g = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i = super.read();
        if (i != -1) {
            this.h++;
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = super.read(bArr, i, i2);
        if (i3 != -1) {
            this.h += (long) i3;
        }
        return i3;
    }
}
