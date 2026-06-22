package defpackage;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes.dex */
public final class rd0 extends FilterInputStream implements AutoCloseable {
    public final HttpURLConnection g;

    /* JADX WARN: Illegal instructions before constructor call */
    public rd0(HttpURLConnection httpURLConnection) {
        InputStream errorStream;
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            errorStream = httpURLConnection.getErrorStream();
        }
        super(errorStream);
        this.g = httpURLConnection;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        this.g.disconnect();
    }
}
