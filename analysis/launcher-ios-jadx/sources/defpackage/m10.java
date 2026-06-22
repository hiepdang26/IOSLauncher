package defpackage;

import android.media.MediaDataSource;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class m10 extends MediaDataSource implements AutoCloseable {
    public long g;
    public final /* synthetic */ r10 h;

    public m10(r10 r10Var) {
        this.h = r10Var;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j, byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (j < 0) {
            return -1;
        }
        try {
            long j2 = this.g;
            if (j2 != j) {
                if (j2 >= 0 && j >= j2 + ((long) this.h.g.available())) {
                    return -1;
                }
                this.h.b(j);
                this.g = j;
            }
            if (i2 > this.h.g.available()) {
                i2 = this.h.g.available();
            }
            int i3 = this.h.read(bArr, i, i2);
            if (i3 >= 0) {
                this.g += (long) i3;
                return i3;
            }
        } catch (IOException unused) {
        }
        this.g = -1L;
        return -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
