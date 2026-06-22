package defpackage;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* JADX INFO: loaded from: classes.dex */
public final class tj implements bt {
    public final ByteBuffer g;

    public tj(byte[] bArr, int i) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, 0, i);
        this.g = byteBufferWrap;
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
    }

    public static int a(int i, int i2) {
        return g(i) + (i2 >= 0 ? e(i2) : 10);
    }

    public static int c(int i, long j) {
        return g(i) + (((-128) & j) == 0 ? 1 : ((-16384) & j) == 0 ? 2 : ((-2097152) & j) == 0 ? 3 : ((-268435456) & j) == 0 ? 4 : ((-34359738368L) & j) == 0 ? 5 : ((-4398046511104L) & j) == 0 ? 6 : ((-562949953421312L) & j) == 0 ? 7 : ((-72057594037927936L) & j) == 0 ? 8 : (j & Long.MIN_VALUE) == 0 ? 9 : 10);
    }

    public static int d(int i, au0 au0Var) {
        int iG = g(i);
        int iA = au0Var.a();
        au0Var.a = iA;
        return e(iA) + iA + iG;
    }

    public static int e(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int f(int i, String str) {
        int iG = g(i);
        int iK = k(str);
        return e(iK) + iK + iG;
    }

    public static int g(int i) {
        return e(i << 3);
    }

    public static int h(String str, byte[] bArr, int i, int i2) {
        int i3;
        char cCharAt;
        int length = str.length();
        int i4 = i2 + i;
        int i5 = 0;
        while (i5 < length && (i3 = i5 + i) < i4 && (cCharAt = str.charAt(i5)) < 128) {
            bArr[i3] = (byte) cCharAt;
            i5++;
        }
        if (i5 == length) {
            return i + length;
        }
        int i6 = i + i5;
        while (i5 < length) {
            char cCharAt2 = str.charAt(i5);
            if (cCharAt2 < 128 && i6 < i4) {
                bArr[i6] = (byte) cCharAt2;
                i6++;
            } else if (cCharAt2 < 2048 && i6 <= i4 - 2) {
                int i7 = i6 + 1;
                bArr[i6] = (byte) ((cCharAt2 >>> 6) | 960);
                i6 += 2;
                bArr[i7] = (byte) ((cCharAt2 & '?') | 128);
            } else {
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i6 > i4 - 3) {
                    if (i6 > i4 - 4) {
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i6);
                    }
                    int i8 = i5 + 1;
                    if (i8 != str.length()) {
                        char cCharAt3 = str.charAt(i8);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i6] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i6 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i9 = i6 + 3;
                            bArr[i6 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i6 += 4;
                            bArr[i9] = (byte) ((codePoint & 63) | 128);
                            i5 = i8;
                        } else {
                            i5 = i8;
                        }
                    }
                    StringBuilder sb = new StringBuilder("Unpaired surrogate at index ");
                    sb.append(i5 - 1);
                    throw new IllegalArgumentException(sb.toString());
                }
                bArr[i6] = (byte) ((cCharAt2 >>> '\f') | 480);
                int i10 = i6 + 2;
                bArr[i6 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                i6 += 3;
                bArr[i10] = (byte) ((cCharAt2 & '?') | 128);
            }
            i5++;
        }
        return i6;
    }

    public static void i(String str, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(h(str, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
                return;
            } catch (ArrayIndexOutOfBoundsException e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        }
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                byteBuffer.put((byte) cCharAt);
            } else if (cCharAt < 2048) {
                byteBuffer.put((byte) ((cCharAt >>> 6) | 960));
                byteBuffer.put((byte) ((cCharAt & '?') | 128));
            } else {
                if (cCharAt >= 55296 && 57343 >= cCharAt) {
                    int i2 = i + 1;
                    if (i2 != str.length()) {
                        char cCharAt2 = str.charAt(i2);
                        if (Character.isSurrogatePair(cCharAt, cCharAt2)) {
                            int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                            byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                            byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                            byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                            byteBuffer.put((byte) ((codePoint & 63) | 128));
                            i = i2;
                        } else {
                            i = i2;
                        }
                    }
                    StringBuilder sb = new StringBuilder("Unpaired surrogate at index ");
                    sb.append(i - 1);
                    throw new IllegalArgumentException(sb.toString());
                }
                byteBuffer.put((byte) ((cCharAt >>> '\f') | 480));
                byteBuffer.put((byte) (((cCharAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((cCharAt & '?') | 128));
            }
            i++;
        }
    }

    public static int k(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && str.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char cCharAt = str.charAt(i2);
            if (cCharAt < 2048) {
                i3 += (127 - cCharAt) >>> 31;
                i2++;
            } else {
                int length2 = str.length();
                while (i2 < length2) {
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 < 2048) {
                        i += (127 - cCharAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i2) < 65536) {
                                throw new IllegalArgumentException(k31.k(i2, "Unpaired surrogate at index "));
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i3) + 4294967296L));
    }

    @Override // defpackage.bt
    public long b(long j) {
        ByteBuffer byteBuffer = this.g;
        int iMin = (int) Math.min(byteBuffer.remaining(), j);
        byteBuffer.position(byteBuffer.position() + iMin);
        return iMin;
    }

    @Override // defpackage.bt
    public short j() throws at {
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer.remaining() >= 1) {
            return (short) (byteBuffer.get() & 255);
        }
        throw new at();
    }

    @Override // defpackage.bt
    public int l() {
        return (j() << 8) | j();
    }

    public void m(int i, byte[] bArr) throws sj {
        w(i, 2);
        t(bArr.length);
        int length = bArr.length;
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer.remaining() < length) {
            throw new sj(byteBuffer.position(), byteBuffer.limit());
        }
        byteBuffer.put(bArr, 0, length);
    }

    public void n(float f, int i) throws sj {
        w(i, 5);
        int iFloatToIntBits = Float.floatToIntBits(f);
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer.remaining() < 4) {
            throw new sj(byteBuffer.position(), byteBuffer.limit());
        }
        byteBuffer.putInt(iFloatToIntBits);
    }

    @Override // defpackage.bt
    public int o(int i, byte[] bArr) {
        ByteBuffer byteBuffer = this.g;
        int iMin = Math.min(i, byteBuffer.remaining());
        if (iMin == 0) {
            return -1;
        }
        byteBuffer.get(bArr, 0, iMin);
        return iMin;
    }

    public void p(int i, int i2) throws sj {
        w(i, 0);
        if (i2 >= 0) {
            t(i2);
        } else {
            u(i2);
        }
    }

    public void q(int i, long j) throws sj {
        w(i, 0);
        u(j);
    }

    public void r(int i, au0 au0Var) throws sj {
        w(i, 2);
        if (au0Var.a < 0) {
            au0Var.a = au0Var.a();
        }
        t(au0Var.a);
        au0Var.e(this);
    }

    public void s(int i) throws sj {
        byte b = (byte) i;
        ByteBuffer byteBuffer = this.g;
        if (!byteBuffer.hasRemaining()) {
            throw new sj(byteBuffer.position(), byteBuffer.limit());
        }
        byteBuffer.put(b);
    }

    public void t(int i) throws sj {
        while ((i & (-128)) != 0) {
            s((i & 127) | 128);
            i >>>= 7;
        }
        s(i);
    }

    public void u(long j) throws sj {
        while (((-128) & j) != 0) {
            s((((int) j) & 127) | 128);
            j >>>= 7;
        }
        s((int) j);
    }

    public void v(int i, String str) throws sj {
        w(i, 2);
        ByteBuffer byteBuffer = this.g;
        try {
            int iE = e(str.length());
            if (iE != e(str.length() * 3)) {
                t(k(str));
                i(str, byteBuffer);
                return;
            }
            int iPosition = byteBuffer.position();
            if (byteBuffer.remaining() < iE) {
                throw new sj(iPosition + iE, byteBuffer.limit());
            }
            byteBuffer.position(iPosition + iE);
            i(str, byteBuffer);
            int iPosition2 = byteBuffer.position();
            byteBuffer.position(iPosition);
            t((iPosition2 - iPosition) - iE);
            byteBuffer.position(iPosition2);
        } catch (BufferOverflowException e) {
            sj sjVar = new sj(byteBuffer.position(), byteBuffer.limit());
            sjVar.initCause(e);
            throw sjVar;
        }
    }

    public void w(int i, int i2) throws sj {
        t((i << 3) | i2);
    }

    public tj(ByteBuffer byteBuffer) {
        this.g = byteBuffer;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }
}
