package defpackage;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class de extends OutputStream implements AutoCloseable {
    public final /* synthetic */ fe g;

    public de(fe feVar) {
        this.g = feVar;
    }

    public final String toString() {
        return this.g + ".outputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.g.K((byte) i);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        this.g.J(bArr, i, i2);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
    }
}
