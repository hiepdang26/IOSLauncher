package defpackage;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class b81 implements oe, AutoCloseable {
    public final fe g = new fe();
    public final fi1 h;
    public boolean i;

    public b81(fi1 fi1Var) {
        if (fi1Var == null) {
            throw new NullPointerException("source == null");
        }
        this.h = fi1Var;
    }

    public final String A(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException(uo.f("limit < 0: ", j));
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jB = b((byte) 10, 0L, j2);
        fe feVar = this.g;
        if (jB != -1) {
            return feVar.F(jB);
        }
        if (j2 < Long.MAX_VALUE && B(j2) && feVar.k(j2 - 1) == 13 && B(j2 + 1) && feVar.k(j2) == 10) {
            return feVar.F(j2);
        }
        fe feVar2 = new fe();
        long jMin = Math.min(32L, feVar.h);
        long j3 = 0;
        xq1.a(feVar.h, 0L, jMin);
        if (jMin != 0) {
            feVar2.h += jMin;
            ze1 ze1Var = feVar.g;
            while (true) {
                long j4 = ze1Var.c - ze1Var.b;
                if (j3 < j4) {
                    break;
                }
                j3 -= j4;
                ze1Var = ze1Var.f;
            }
            while (jMin > 0) {
                ze1 ze1VarC = ze1Var.c();
                int i = (int) (((long) ze1VarC.b) + j3);
                ze1VarC.b = i;
                ze1VarC.c = Math.min(i + ((int) jMin), ze1VarC.c);
                ze1 ze1Var2 = feVar2.g;
                if (ze1Var2 == null) {
                    ze1VarC.g = ze1VarC;
                    ze1VarC.f = ze1VarC;
                    feVar2.g = ze1VarC;
                } else {
                    ze1Var2.g.b(ze1VarC);
                }
                jMin -= (long) (ze1VarC.c - ze1VarC.b);
                ze1Var = ze1Var.f;
                j3 = 0;
            }
        }
        throw new EOFException("\\n not found: limit=" + Math.min(feVar.h, j) + " content=" + new df(feVar2.j()).e() + (char) 8230);
    }

    public final boolean B(long j) {
        fe feVar;
        if (j < 0) {
            throw new IllegalArgumentException(uo.f("byteCount < 0: ", j));
        }
        if (this.i) {
            throw new IllegalStateException("closed");
        }
        do {
            feVar = this.g;
            if (feVar.h >= j) {
                return true;
            }
        } while (this.h.read(feVar, 8192L) != -1);
        return false;
    }

    public final void C(long j) throws EOFException {
        if (!B(j)) {
            throw new EOFException();
        }
    }

    public final void D(long j) throws EOFException {
        if (this.i) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            fe feVar = this.g;
            if (feVar.h == 0 && this.h.read(feVar, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, feVar.h);
            feVar.H(jMin);
            j -= jMin;
        }
    }

    public final boolean a() {
        if (this.i) {
            throw new IllegalStateException("closed");
        }
        fe feVar = this.g;
        return feVar.h() && this.h.read(feVar, 8192L) == -1;
    }

    public final long b(byte b, long j, long j2) {
        ze1 ze1Var;
        long j3;
        long j4;
        if (this.i) {
            throw new IllegalStateException("closed");
        }
        long jMax = 0;
        if (j2 < 0) {
            throw new IllegalArgumentException(uo.f("fromIndex=0 toIndex=", j2));
        }
        while (jMax < j2) {
            fe feVar = this.g;
            feVar.getClass();
            long j5 = 0;
            if (jMax < 0 || j2 < jMax) {
                throw new IllegalArgumentException("size=" + feVar.h + " fromIndex=" + jMax + " toIndex=" + j2);
            }
            long j6 = feVar.h;
            long j7 = j2 > j6 ? j6 : j2;
            if (jMax == j7 || (ze1Var = feVar.g) == null) {
                j3 = -1;
                j4 = -1;
            } else {
                if (j6 - jMax < jMax) {
                    while (j6 > jMax) {
                        ze1Var = ze1Var.g;
                        j6 -= (long) (ze1Var.c - ze1Var.b);
                    }
                } else {
                    while (true) {
                        long j8 = ((long) (ze1Var.c - ze1Var.b)) + j5;
                        if (j8 >= jMax) {
                            break;
                        }
                        ze1Var = ze1Var.f;
                        j5 = j8;
                    }
                    j6 = j5;
                }
                long j9 = jMax;
                while (j6 < j7) {
                    byte[] bArr = ze1Var.a;
                    j3 = -1;
                    int iMin = (int) Math.min(ze1Var.c, (((long) ze1Var.b) + j7) - j6);
                    for (int i = (int) ((((long) ze1Var.b) + j9) - j6); i < iMin; i++) {
                        if (bArr[i] == b) {
                            j4 = ((long) (i - ze1Var.b)) + j6;
                            break;
                        }
                    }
                    long j10 = ((long) (ze1Var.c - ze1Var.b)) + j6;
                    ze1Var = ze1Var.f;
                    j9 = j10;
                    j6 = j9;
                }
                j3 = -1;
                j4 = -1;
            }
            if (j4 != j3) {
                return j4;
            }
            long j11 = feVar.h;
            if (j11 >= j2 || this.h.read(feVar, 8192L) == j3) {
                return j3;
            }
            jMax = Math.max(jMax, j11);
        }
        return -1L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (this.i) {
            return;
        }
        this.i = true;
        this.h.close();
        this.g.a();
    }

    @Override // defpackage.oe
    public final long f(fe feVar) {
        fe feVar2;
        long j = 0;
        while (true) {
            feVar2 = this.g;
            if (this.h.read(feVar2, 8192L) == -1) {
                break;
            }
            long jB = feVar2.b();
            if (jB > 0) {
                j += jB;
                feVar.c(feVar2, jB);
            }
        }
        long j2 = feVar2.h;
        if (j2 <= 0) {
            return j;
        }
        long j3 = j + j2;
        feVar.c(feVar2, j2);
        return j3;
    }

    public final byte h() throws EOFException {
        C(1L);
        return this.g.r();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.i;
    }

    @Override // defpackage.oe
    public final byte[] j() {
        fi1 fi1Var = this.h;
        fe feVar = this.g;
        feVar.o(fi1Var);
        return feVar.j();
    }

    public final df k(long j) throws EOFException {
        C(j);
        fe feVar = this.g;
        feVar.getClass();
        return new df(feVar.z(j));
    }

    @Override // defpackage.oe
    public final int l(f01 f01Var) throws EOFException {
        fe feVar;
        if (this.i) {
            throw new IllegalStateException("closed");
        }
        do {
            feVar = this.g;
            int iG = feVar.G(f01Var, true);
            if (iG == -1) {
                break;
            }
            if (iG != -2) {
                feVar.H(f01Var.g[iG].i());
                return iG;
            }
        } while (this.h.read(feVar, 8192L) != -1);
        return -1;
    }

    public final void n(byte[] bArr) throws EOFException {
        fe feVar = this.g;
        int i = 0;
        try {
            C(bArr.length);
            while (i < bArr.length) {
                int iN = feVar.n(bArr, i, bArr.length - i);
                if (iN == -1) {
                    throw new EOFException();
                }
                i += iN;
            }
        } catch (EOFException e) {
            while (true) {
                long j = feVar.h;
                if (j <= 0) {
                    throw e;
                }
                int iN2 = feVar.n(bArr, i, (int) j);
                if (iN2 == -1) {
                    throw new AssertionError();
                }
                i += iN2;
            }
        }
    }

    public final int r() throws EOFException {
        C(4L);
        return this.g.B();
    }

    @Override // defpackage.fi1
    public final long read(fe feVar, long j) {
        if (feVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException(uo.f("byteCount < 0: ", j));
        }
        if (this.i) {
            throw new IllegalStateException("closed");
        }
        fe feVar2 = this.g;
        if (feVar2.h == 0 && this.h.read(feVar2, 8192L) == -1) {
            return -1L;
        }
        return feVar2.read(feVar, Math.min(j, feVar2.h));
    }

    @Override // defpackage.fi1
    public final yn1 timeout() {
        return this.h.timeout();
    }

    public final String toString() {
        return "buffer(" + this.h + ")";
    }

    @Override // defpackage.oe
    public final String x(Charset charset) {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        fi1 fi1Var = this.h;
        fe feVar = this.g;
        feVar.o(fi1Var);
        return feVar.x(charset);
    }

    @Override // defpackage.oe
    public final InputStream y() {
        return new ee(this, 1);
    }

    public final short z() throws EOFException {
        C(2L);
        return this.g.C();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        fe feVar = this.g;
        if (feVar.h == 0 && this.h.read(feVar, 8192L) == -1) {
            return -1;
        }
        return feVar.read(byteBuffer);
    }
}
