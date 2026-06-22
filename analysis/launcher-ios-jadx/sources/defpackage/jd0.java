package defpackage;

import androidx.appcompat.widget.ActivityChooserView;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class jd0 implements Closeable, AutoCloseable {
    public static final Logger m = Logger.getLogger(qc0.class.getName());
    public final a81 g;
    public final boolean h;
    public final fe i;
    public int j;
    public boolean k;
    public final hc0 l;

    public jd0(a81 a81Var, boolean z) {
        this.g = a81Var;
        this.h = z;
        fe feVar = new fe();
        this.i = feVar;
        this.l = new hc0(feVar);
        this.j = 16384;
    }

    public final synchronized void A(t3 t3Var) {
        try {
            if (this.k) {
                throw new IOException("closed");
            }
            h(0, Integer.bitCount(t3Var.g) * 6, (byte) 4, (byte) 0);
            int i = 0;
            while (i < 10) {
                boolean z = true;
                if (((1 << i) & t3Var.g) == 0) {
                    z = false;
                }
                if (z) {
                    int i2 = i == 4 ? 3 : i == 7 ? 4 : i;
                    a81 a81Var = this.g;
                    if (a81Var.i) {
                        throw new IllegalStateException("closed");
                    }
                    fe feVar = a81Var.g;
                    ze1 ze1VarI = feVar.I(2);
                    int i3 = ze1VarI.c;
                    byte[] bArr = ze1VarI.a;
                    bArr[i3] = (byte) ((i2 >>> 8) & 255);
                    bArr[i3 + 1] = (byte) (i2 & 255);
                    ze1VarI.c = i3 + 2;
                    feVar.h += 2;
                    a81Var.a();
                    this.g.h(((int[]) t3Var.h)[i]);
                }
                i++;
            }
            this.g.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void B(int i, long j) {
        if (this.k) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            qc0.b("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        }
        h(i, 4, (byte) 8, (byte) 0);
        this.g.h((int) j);
        this.g.flush();
    }

    public final synchronized void a(t3 t3Var) {
        try {
            if (this.k) {
                throw new IOException("closed");
            }
            int i = this.j;
            int i2 = t3Var.g;
            if ((i2 & 32) != 0) {
                i = ((int[]) t3Var.h)[5];
            }
            this.j = i;
            if (((i2 & 2) != 0 ? ((int[]) t3Var.h)[1] : -1) != -1) {
                hc0 hc0Var = this.l;
                int iMin = Math.min((i2 & 2) != 0 ? ((int[]) t3Var.h)[1] : -1, 16384);
                int i3 = hc0Var.d;
                if (i3 != iMin) {
                    if (iMin < i3) {
                        hc0Var.b = Math.min(hc0Var.b, iMin);
                    }
                    hc0Var.c = true;
                    hc0Var.d = iMin;
                    int i4 = hc0Var.h;
                    if (iMin < i4) {
                        if (iMin == 0) {
                            Arrays.fill(hc0Var.e, (Object) null);
                            hc0Var.f = hc0Var.e.length - 1;
                            hc0Var.g = 0;
                            hc0Var.h = 0;
                        } else {
                            hc0Var.a(i4 - iMin);
                        }
                    }
                }
            }
            h(0, 0, (byte) 4, (byte) 1);
            this.g.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(boolean z, int i, fe feVar, int i2) {
        if (this.k) {
            throw new IOException("closed");
        }
        h(i, i2, (byte) 0, z ? (byte) 1 : (byte) 0);
        if (i2 > 0) {
            this.g.c(feVar, i2);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.k = true;
        this.g.close();
    }

    public final synchronized void flush() {
        if (this.k) {
            throw new IOException("closed");
        }
        this.g.flush();
    }

    public final void h(int i, int i2, byte b, byte b2) {
        Level level = Level.FINE;
        Logger logger = m;
        if (logger.isLoggable(level)) {
            logger.fine(qc0.a(false, i, i2, b, b2));
        }
        int i3 = this.j;
        if (i2 > i3) {
            qc0.b("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            throw null;
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            qc0.b("reserved bit set: %s", Integer.valueOf(i));
            throw null;
        }
        a81 a81Var = this.g;
        a81Var.b((i2 >>> 16) & 255);
        a81Var.b((i2 >>> 8) & 255);
        a81Var.b(i2 & 255);
        a81Var.b(b & 255);
        a81Var.b(b2 & 255);
        a81Var.h(i & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public final synchronized void k(int i, byte[] bArr, int i2) {
        try {
            if (this.k) {
                throw new IOException("closed");
            }
            if (uo.a(i2) == -1) {
                qc0.b("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
            h(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.g.h(i);
            this.g.h(uo.a(i2));
            if (bArr.length > 0) {
                this.g.m(bArr);
            }
            this.g.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void n(int i, ArrayList arrayList, boolean z) {
        if (this.k) {
            throw new IOException("closed");
        }
        this.l.d(arrayList);
        long j = this.i.h;
        int iMin = (int) Math.min(this.j, j);
        long j2 = iMin;
        byte b = j == j2 ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        h(i, iMin, (byte) 1, b);
        this.g.c(this.i, j2);
        if (j > j2) {
            long j3 = j - j2;
            while (j3 > 0) {
                int iMin2 = (int) Math.min(this.j, j3);
                long j4 = iMin2;
                j3 -= j4;
                h(i, iMin2, (byte) 9, j3 == 0 ? (byte) 4 : (byte) 0);
                this.g.c(this.i, j4);
            }
        }
    }

    public final synchronized void r(int i, int i2, boolean z) {
        if (this.k) {
            throw new IOException("closed");
        }
        h(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.g.h(i);
        this.g.h(i2);
        this.g.flush();
    }

    public final synchronized void z(int i, int i2) {
        if (this.k) {
            throw new IOException("closed");
        }
        if (uo.a(i2) == -1) {
            throw new IllegalArgumentException();
        }
        h(i, 4, (byte) 3, (byte) 0);
        this.g.h(uo.a(i2));
        this.g.flush();
    }
}
