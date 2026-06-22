package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class ee extends InputStream implements AutoCloseable {
    public final /* synthetic */ int g;
    public final /* synthetic */ oe h;

    public /* synthetic */ ee(oe oeVar, int i) {
        this.g = i;
        this.h = oeVar;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        switch (this.g) {
            case 0:
                return (int) Math.min(((fe) this.h).h, 2147483647L);
            default:
                b81 b81Var = (b81) this.h;
                if (b81Var.i) {
                    throw new IOException("closed");
                }
                return (int) Math.min(b81Var.g.h, 2147483647L);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.g) {
            case 0:
                break;
            default:
                ((b81) this.h).close();
                break;
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        switch (this.g) {
            case 0:
                fe feVar = (fe) this.h;
                if (feVar.h > 0) {
                    return feVar.r() & 255;
                }
                return -1;
            default:
                b81 b81Var = (b81) this.h;
                if (b81Var.i) {
                    throw new IOException("closed");
                }
                fe feVar2 = b81Var.g;
                if (feVar2.h == 0 && b81Var.h.read(feVar2, 8192L) == -1) {
                    return -1;
                }
                return feVar2.r() & 255;
        }
    }

    public final String toString() {
        switch (this.g) {
            case 0:
                return ((fe) this.h) + ".inputStream()";
            default:
                return ((b81) this.h) + ".inputStream()";
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        switch (this.g) {
            case 0:
                return ((fe) this.h).n(bArr, i, i2);
            default:
                b81 b81Var = (b81) this.h;
                if (!b81Var.i) {
                    xq1.a(bArr.length, i, i2);
                    fe feVar = b81Var.g;
                    if (feVar.h == 0 && b81Var.h.read(feVar, 8192L) == -1) {
                        return -1;
                    }
                    return feVar.n(bArr, i, i2);
                }
                throw new IOException("closed");
        }
    }

    private final void a() {
    }
}
