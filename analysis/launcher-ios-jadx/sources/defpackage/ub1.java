package defpackage;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class ub1 extends Reader implements AutoCloseable {
    public final oe g;
    public final Charset h;
    public boolean i;
    public InputStreamReader j;

    public ub1(oe oeVar, Charset charset) {
        this.g = oeVar;
        this.h = charset;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.i = true;
        InputStreamReader inputStreamReader = this.j;
        if (inputStreamReader != null) {
            inputStreamReader.close();
        } else {
            this.g.close();
        }
    }

    @Override // java.io.Reader
    public final int read(char[] cArr, int i, int i2) throws IOException {
        if (this.i) {
            throw new IOException("Stream closed");
        }
        InputStreamReader inputStreamReader = this.j;
        if (inputStreamReader == null) {
            oe oeVar = this.g;
            InputStreamReader inputStreamReader2 = new InputStreamReader(oeVar.y(), wq1.a(oeVar, this.h));
            this.j = inputStreamReader2;
            inputStreamReader = inputStreamReader2;
        }
        return inputStreamReader.read(cArr, i, i2);
    }
}
