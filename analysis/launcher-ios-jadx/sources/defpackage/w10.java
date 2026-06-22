package defpackage;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class w10 extends FilterInputStream {
    public static final byte[] i = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
    public static final int j = 31;
    public final byte g;
    public int h;

    public w10(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 < -1 || i2 > 8) {
            throw new IllegalArgumentException(k31.k(i2, "Cannot add invalid orientation: "));
        }
        this.g = (byte) i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        int i2;
        int i3 = this.h;
        int i4 = (i3 < 2 || i3 > (i2 = j)) ? super.read() : i3 == i2 ? this.g : i[i3 - 2] & 255;
        if (i4 != -1) {
            this.h++;
        }
        return i4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j2) throws IOException {
        long jSkip = super.skip(j2);
        if (jSkip > 0) {
            this.h = (int) (((long) this.h) + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = this.h;
        int i6 = j;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.g;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int iMin = Math.min(i6 - i5, i3);
            System.arraycopy(i, this.h - 2, bArr, i2, iMin);
            i4 = iMin;
        }
        if (i4 > 0) {
            this.h += i4;
        }
        return i4;
    }
}
