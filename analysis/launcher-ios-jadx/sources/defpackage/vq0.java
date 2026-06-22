package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;
import java.io.FilterInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class vq0 extends FilterInputStream {
    public int g;

    public vq0(b10 b10Var) {
        super(b10Var);
        this.g = RtlSpacingHelper.UNDEFINED;
    }

    public final long a(long j) {
        int i = this.g;
        if (i == 0) {
            return -1L;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        int i = this.g;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    public final void b(long j) {
        int i = this.g;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.g = (int) (((long) i) - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        super.mark(i);
        this.g = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (a(1L) == -1) {
            return -1;
        }
        int i = super.read();
        b(1L);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        super.reset();
        this.g = RtlSpacingHelper.UNDEFINED;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) throws IOException {
        long jA = a(j);
        if (jA == -1) {
            return 0L;
        }
        long jSkip = super.skip(jA);
        b(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int iA = (int) a(i2);
        if (iA == -1) {
            return -1;
        }
        int i3 = super.read(bArr, i, iA);
        b(i3);
        return i3;
    }
}
