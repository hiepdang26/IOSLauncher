package defpackage;

import androidx.appcompat.widget.ActivityChooserView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class dd0 implements fi1, AutoCloseable {
    public final b81 g;
    public int h;
    public byte i;
    public int j;
    public int k;
    public short l;

    public dd0(b81 b81Var) {
        this.g = b81Var;
    }

    @Override // defpackage.fi1
    public final long read(fe feVar, long j) throws IOException {
        int i;
        int iR;
        do {
            int i2 = this.k;
            b81 b81Var = this.g;
            if (i2 == 0) {
                b81Var.D(this.l);
                this.l = (short) 0;
                if ((this.i & 4) == 0) {
                    i = this.j;
                    int iA = ed0.A(b81Var);
                    this.k = iA;
                    this.h = iA;
                    byte bH = (byte) (b81Var.h() & 255);
                    this.i = (byte) (b81Var.h() & 255);
                    Logger logger = ed0.k;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(qc0.a(true, this.j, this.h, bH, this.i));
                    }
                    iR = b81Var.r() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                    this.j = iR;
                    if (bH != 9) {
                        qc0.c("%s != TYPE_CONTINUATION", Byte.valueOf(bH));
                        throw null;
                    }
                }
            } else {
                long j2 = b81Var.read(feVar, Math.min(j, i2));
                if (j2 != -1) {
                    this.k = (int) (((long) this.k) - j2);
                    return j2;
                }
            }
            return -1L;
        } while (iR == i);
        qc0.c("TYPE_CONTINUATION streamId changed", new Object[0]);
        throw null;
    }

    @Override // defpackage.fi1
    public final yn1 timeout() {
        return this.g.h.timeout();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
