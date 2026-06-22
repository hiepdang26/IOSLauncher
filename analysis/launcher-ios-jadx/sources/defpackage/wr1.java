package defpackage;

import android.media.MediaDataSource;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class wr1 extends MediaDataSource implements AutoCloseable {
    public final /* synthetic */ ByteBuffer g;

    public wr1(ByteBuffer byteBuffer) {
        this.g = byteBuffer;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return this.g.limit();
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j, byte[] bArr, int i, int i2) {
        if (j >= this.g.limit()) {
            return -1;
        }
        this.g.position((int) j);
        int iMin = Math.min(i2, this.g.remaining());
        this.g.get(bArr, i, iMin);
        return iMin;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
