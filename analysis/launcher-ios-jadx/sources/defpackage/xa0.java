package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Logger;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
public final class xa0 implements fi1, AutoCloseable {
    public final b81 h;
    public final Inflater i;
    public final kf0 j;
    public int g = 0;
    public final CRC32 k = new CRC32();

    public xa0(fi1 fi1Var) {
        if (fi1Var == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.i = inflater;
        Logger logger = jy0.a;
        b81 b81Var = new b81(fi1Var);
        this.h = b81Var;
        this.j = new kf0(b81Var, inflater);
    }

    public static void a(int i, int i2, String str) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    public final void b(fe feVar, long j, long j2) {
        ze1 ze1Var = feVar.g;
        while (true) {
            int i = ze1Var.c;
            int i2 = ze1Var.b;
            if (j < i - i2) {
                break;
            }
            j -= (long) (i - i2);
            ze1Var = ze1Var.f;
        }
        while (j2 > 0) {
            int i3 = (int) (((long) ze1Var.b) + j);
            int iMin = (int) Math.min(ze1Var.c - i3, j2);
            this.k.update(ze1Var.a, i3, iMin);
            j2 -= (long) iMin;
            ze1Var = ze1Var.f;
            j = 0;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.j.close();
    }

    @Override // defpackage.fi1
    public final long read(fe feVar, long j) throws IOException {
        b81 b81Var;
        short s;
        long j2;
        b81 b81Var2;
        long j3;
        xa0 xa0Var = this;
        if (j < 0) {
            throw new IllegalArgumentException(uo.f("byteCount < 0: ", j));
        }
        if (j == 0) {
            return 0L;
        }
        int i = xa0Var.g;
        CRC32 crc32 = xa0Var.k;
        b81 b81Var3 = xa0Var.h;
        if (i == 0) {
            b81Var3.C(10L);
            fe feVar2 = b81Var3.g;
            byte bK = feVar2.k(3L);
            boolean z = ((bK >> 1) & 1) == 1;
            if (z) {
                b81Var2 = b81Var3;
                xa0Var.b(feVar2, 0L, 10L);
            } else {
                b81Var2 = b81Var3;
            }
            a(8075, b81Var2.z(), "ID1ID2");
            b81 b81Var4 = b81Var2;
            b81Var4.D(8L);
            if (((bK >> 2) & 1) == 1) {
                b81Var4.C(2L);
                if (z) {
                    s = 65280;
                    j2 = -1;
                    b81Var = b81Var4;
                    j3 = 2;
                    b(feVar2, 0L, 2L);
                } else {
                    b81Var = b81Var4;
                    j3 = 2;
                    s = 65280;
                    j2 = -1;
                }
                short sC = feVar2.C();
                Charset charset = xq1.a;
                long j4 = (short) (((sC & 255) << 8) | ((sC & s) >>> 8));
                b81Var.C(j4);
                if (z) {
                    b(feVar2, 0L, j4);
                }
                b81Var.D(j4);
            } else {
                b81Var = b81Var4;
                j3 = 2;
                s = 65280;
                j2 = -1;
            }
            if (((bK >> 3) & 1) == 1) {
                long jB = b81Var.b((byte) 0, 0L, Long.MAX_VALUE);
                if (jB == j2) {
                    throw new EOFException();
                }
                if (z) {
                    b(feVar2, 0L, jB + 1);
                }
                b81Var.D(jB + 1);
            }
            if (((bK >> 4) & 1) == 1) {
                long jB2 = b81Var.b((byte) 0, 0L, Long.MAX_VALUE);
                if (jB2 == j2) {
                    throw new EOFException();
                }
                if (z) {
                    xa0Var = this;
                    xa0Var.b(feVar2, 0L, jB2 + 1);
                } else {
                    xa0Var = this;
                }
                b81Var.D(jB2 + 1);
            } else {
                xa0Var = this;
            }
            if (z) {
                b81Var.C(j3);
                short sC2 = feVar2.C();
                Charset charset2 = xq1.a;
                a((short) (((sC2 & 255) << 8) | ((sC2 & s) >>> 8)), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            xa0Var.g = 1;
        } else {
            b81Var = b81Var3;
            s = 65280;
            j2 = -1;
        }
        if (xa0Var.g == 1) {
            long j5 = feVar.h;
            long j6 = xa0Var.j.read(feVar, j);
            if (j6 != j2) {
                xa0Var.b(feVar, j5, j6);
                return j6;
            }
            xa0Var.g = 2;
        }
        if (xa0Var.g == 2) {
            b81Var.C(4L);
            fe feVar3 = b81Var.g;
            int iB = feVar3.B();
            Charset charset3 = xq1.a;
            a(((iB & 255) << 24) | ((iB & (-16777216)) >>> 24) | ((iB & 16711680) >>> 8) | ((iB & s) << 8), (int) crc32.getValue(), "CRC");
            b81Var.C(4L);
            int iB2 = feVar3.B();
            a(((iB2 & 255) << 24) | ((iB2 & (-16777216)) >>> 24) | ((iB2 & 16711680) >>> 8) | ((iB2 & s) << 8), (int) xa0Var.i.getBytesWritten(), "ISIZE");
            xa0Var.g = 3;
            if (!b81Var.a()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return j2;
    }

    @Override // defpackage.fi1
    public final yn1 timeout() {
        return this.h.h.timeout();
    }
}
