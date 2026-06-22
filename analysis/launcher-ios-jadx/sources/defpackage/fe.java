package defpackage;

import androidx.profileinstaller.ProfileVerifier;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class fe implements oe, ne, Cloneable, ByteChannel, AutoCloseable {
    public static final byte[] i = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    public ze1 g;
    public long h;

    /* JADX WARN: Removed duplicated region for block: B:32:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0092 A[EDGE_INSN: B:43:0x0092->B:37:0x0092 BREAK  A[LOOP:0: B:5:0x000b->B:45:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long A() {
        /*
            r15 = this;
            long r0 = r15.h
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L99
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            ze1 r6 = r15.g
            byte[] r7 = r6.a
            int r8 = r6.b
            int r9 = r6.c
        L13:
            if (r8 >= r9) goto L7e
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L37
        L22:
            r11 = 97
            if (r10 < r11) goto L2d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2d
            int r11 = r10 + (-87)
            goto L37
        L2d:
            r11 = 65
            if (r10 < r11) goto L62
            r11 = 70
            if (r10 > r11) goto L62
            int r11 = r10 + (-55)
        L37:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L47
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L47:
            fe r0 = new fe
            r0.<init>()
            r0.M(r4)
            r0.K(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r0 = r0.E()
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L62:
            if (r0 == 0) goto L66
            r1 = 1
            goto L7e
        L66:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.<init>(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L7e:
            if (r8 != r9) goto L8a
            ze1 r7 = r6.a()
            r15.g = r7
            defpackage.bf1.s(r6)
            goto L8c
        L8a:
            r6.b = r8
        L8c:
            if (r1 != 0) goto L92
            ze1 r6 = r15.g
            if (r6 != 0) goto Lb
        L92:
            long r1 = r15.h
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.h = r1
            return r4
        L99:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fe.A():long");
    }

    public final int B() {
        long j = this.h;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.h);
        }
        ze1 ze1Var = this.g;
        int i2 = ze1Var.b;
        int i3 = ze1Var.c;
        if (i3 - i2 < 4) {
            return ((r() & 255) << 24) | ((r() & 255) << 16) | ((r() & 255) << 8) | (r() & 255);
        }
        byte[] bArr = ze1Var.a;
        int i4 = i2 + 3;
        int i5 = ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 2] & 255) << 8);
        int i6 = i2 + 4;
        int i7 = i5 | (bArr[i4] & 255);
        this.h = j - 4;
        if (i6 != i3) {
            ze1Var.b = i6;
            return i7;
        }
        this.g = ze1Var.a();
        bf1.s(ze1Var);
        return i7;
    }

    public final short C() {
        long j = this.h;
        if (j < 2) {
            throw new IllegalStateException("size < 2: " + this.h);
        }
        ze1 ze1Var = this.g;
        int i2 = ze1Var.b;
        int i3 = ze1Var.c;
        if (i3 - i2 < 2) {
            return (short) (((r() & 255) << 8) | (r() & 255));
        }
        int i4 = i2 + 1;
        byte[] bArr = ze1Var.a;
        int i5 = (bArr[i2] & 255) << 8;
        int i6 = i2 + 2;
        int i7 = (bArr[i4] & 255) | i5;
        this.h = j - 2;
        if (i6 == i3) {
            this.g = ze1Var.a();
            bf1.s(ze1Var);
        } else {
            ze1Var.b = i6;
        }
        return (short) i7;
    }

    public final String D(long j, Charset charset) {
        xq1.a(this.h, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException(uo.f("byteCount > Integer.MAX_VALUE: ", j));
        }
        if (j == 0) {
            return "";
        }
        ze1 ze1Var = this.g;
        int i2 = ze1Var.b;
        if (((long) i2) + j > ze1Var.c) {
            return new String(z(j), charset);
        }
        String str = new String(ze1Var.a, i2, (int) j, charset);
        int i3 = (int) (((long) ze1Var.b) + j);
        ze1Var.b = i3;
        this.h -= j;
        if (i3 == ze1Var.c) {
            this.g = ze1Var.a();
            bf1.s(ze1Var);
        }
        return str;
    }

    public final String E() {
        try {
            return D(this.h, xq1.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final String F(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (k(j2) == 13) {
                String strD = D(j2, xq1.a);
                H(2L);
                return strD;
            }
        }
        String strD2 = D(j, xq1.a);
        H(1L);
        return strD2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
    
        if (r19 == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0082, code lost:
    
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int G(defpackage.f01 r18, boolean r19) {
        /*
            r17 = this;
            r0 = r18
            r1 = r17
            ze1 r2 = r1.g
            if (r2 != 0) goto L12
            if (r19 == 0) goto Lb
            goto L56
        Lb:
            df r2 = defpackage.df.k
            int r0 = r0.indexOf(r2)
            return r0
        L12:
            int r3 = r2.b
            int r4 = r2.c
            int[] r0 = r0.h
            r5 = -1
            r6 = 0
            byte[] r7 = r2.a
            r9 = r2
            r8 = 0
            r10 = -1
        L1f:
            int r11 = r8 + 1
            r12 = r0[r8]
            int r8 = r8 + 2
            r11 = r0[r11]
            if (r11 == r5) goto L2a
            r10 = r11
        L2a:
            if (r9 != 0) goto L2d
            goto L54
        L2d:
            r11 = 0
            if (r12 >= 0) goto L78
            int r12 = r12 * (-1)
            int r13 = r12 + r8
        L34:
            int r12 = r3 + 1
            r3 = r7[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r14 = r8 + 1
            r8 = r0[r8]
            if (r3 == r8) goto L41
            goto L82
        L41:
            if (r14 != r13) goto L45
            r3 = 1
            goto L46
        L45:
            r3 = 0
        L46:
            if (r12 != r4) goto L61
            ze1 r4 = r9.f
            int r7 = r4.b
            int r8 = r4.c
            byte[] r9 = r4.a
            if (r4 != r2) goto L5b
            if (r3 != 0) goto L58
        L54:
            if (r19 == 0) goto L82
        L56:
            r0 = -2
            return r0
        L58:
            r4 = r8
            r8 = r11
            goto L64
        L5b:
            r16 = r8
            r8 = r4
            r4 = r16
            goto L64
        L61:
            r8 = r9
            r9 = r7
            r7 = r12
        L64:
            if (r3 == 0) goto L73
            r3 = r0[r14]
            r16 = r7
            r7 = r4
            r4 = r16
            r16 = r9
            r9 = r8
            r8 = r16
            goto L9b
        L73:
            r3 = r7
            r7 = r9
            r9 = r8
            r8 = r14
            goto L34
        L78:
            int r13 = r3 + 1
            r3 = r7[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r14 = r8 + r12
        L80:
            if (r8 != r14) goto L83
        L82:
            return r10
        L83:
            r15 = r0[r8]
            if (r3 != r15) goto La8
            int r8 = r8 + r12
            r3 = r0[r8]
            if (r13 != r4) goto L98
            ze1 r9 = r9.f
            int r4 = r9.b
            int r7 = r9.c
            byte[] r8 = r9.a
            if (r9 != r2) goto L9b
            r9 = r11
            goto L9b
        L98:
            r8 = r7
            r7 = r4
            r4 = r13
        L9b:
            if (r3 < 0) goto L9e
            return r3
        L9e:
            int r3 = -r3
            r16 = r8
            r8 = r3
            r3 = r4
            r4 = r7
            r7 = r16
            goto L1f
        La8:
            int r8 = r8 + 1
            goto L80
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fe.G(f01, boolean):int");
    }

    public final void H(long j) throws EOFException {
        while (j > 0) {
            if (this.g == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, r0.c - r0.b);
            long j2 = iMin;
            this.h -= j2;
            j -= j2;
            ze1 ze1Var = this.g;
            int i2 = ze1Var.b + iMin;
            ze1Var.b = i2;
            if (i2 == ze1Var.c) {
                this.g = ze1Var.a();
                bf1.s(ze1Var);
            }
        }
    }

    public final ze1 I(int i2) {
        if (i2 < 1 || i2 > 8192) {
            throw new IllegalArgumentException();
        }
        ze1 ze1Var = this.g;
        if (ze1Var == null) {
            ze1 ze1VarZ = bf1.z();
            this.g = ze1VarZ;
            ze1VarZ.g = ze1VarZ;
            ze1VarZ.f = ze1VarZ;
            return ze1VarZ;
        }
        ze1 ze1Var2 = ze1Var.g;
        if (ze1Var2.c + i2 <= 8192 && ze1Var2.e) {
            return ze1Var2;
        }
        ze1 ze1VarZ2 = bf1.z();
        ze1Var2.b(ze1VarZ2);
        return ze1VarZ2;
    }

    public final void J(byte[] bArr, int i2, int i3) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i3;
        xq1.a(bArr.length, i2, j);
        int i4 = i3 + i2;
        while (i2 < i4) {
            ze1 ze1VarI = I(1);
            int iMin = Math.min(i4 - i2, 8192 - ze1VarI.c);
            System.arraycopy(bArr, i2, ze1VarI.a, ze1VarI.c, iMin);
            i2 += iMin;
            ze1VarI.c += iMin;
        }
        this.h += j;
    }

    public final void K(int i2) {
        ze1 ze1VarI = I(1);
        int i3 = ze1VarI.c;
        ze1VarI.c = i3 + 1;
        ze1VarI.a[i3] = (byte) i2;
        this.h++;
    }

    public final void L(long j) {
        byte[] bArr;
        if (j == 0) {
            K(48);
            return;
        }
        int i2 = 1;
        boolean z = false;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                O(0, 20, "-9223372036854775808");
                return;
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        ze1 ze1VarI = I(i2);
        int i3 = ze1VarI.c + i2;
        while (true) {
            bArr = ze1VarI.a;
            if (j == 0) {
                break;
            }
            i3--;
            bArr[i3] = i[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        ze1VarI.c += i2;
        this.h += (long) i2;
    }

    public final void M(long j) {
        if (j == 0) {
            K(48);
            return;
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        ze1 ze1VarI = I(iNumberOfTrailingZeros);
        int i2 = ze1VarI.c;
        for (int i3 = (i2 + iNumberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            ze1VarI.a[i3] = i[(int) (15 & j)];
            j >>>= 4;
        }
        ze1VarI.c += iNumberOfTrailingZeros;
        this.h += (long) iNumberOfTrailingZeros;
    }

    public final void N(int i2) {
        ze1 ze1VarI = I(4);
        int i3 = ze1VarI.c;
        byte[] bArr = ze1VarI.a;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        bArr[i3 + 1] = (byte) ((i2 >>> 16) & 255);
        bArr[i3 + 2] = (byte) ((i2 >>> 8) & 255);
        bArr[i3 + 3] = (byte) (i2 & 255);
        ze1VarI.c = i3 + 4;
        this.h += 4;
    }

    public final void O(int i2, int i3, String str) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(k31.k(i2, "beginIndex < 0: "));
        }
        if (i3 < i2) {
            throw new IllegalArgumentException(k31.j(i3, i2, "endIndex < beginIndex: ", " < "));
        }
        if (i3 > str.length()) {
            StringBuilder sbL = uo.l(i3, "endIndex > string.length: ", " > ");
            sbL.append(str.length());
            throw new IllegalArgumentException(sbL.toString());
        }
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                ze1 ze1VarI = I(1);
                int i4 = ze1VarI.c - i2;
                int iMin = Math.min(i3, 8192 - i4);
                int i5 = i2 + 1;
                byte[] bArr = ze1VarI.a;
                bArr[i2 + i4] = (byte) cCharAt;
                while (i5 < iMin) {
                    char cCharAt2 = str.charAt(i5);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i5 + i4] = (byte) cCharAt2;
                    i5++;
                }
                int i6 = ze1VarI.c;
                int i7 = (i4 + i5) - i6;
                ze1VarI.c = i6 + i7;
                this.h += (long) i7;
                i2 = i5;
            } else {
                if (cCharAt < 2048) {
                    K((cCharAt >> 6) | 192);
                    K((cCharAt & '?') | 128);
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    K((cCharAt >> '\f') | 224);
                    K(((cCharAt >> 6) & 63) | 128);
                    K((cCharAt & '?') | 128);
                } else {
                    int i8 = i2 + 1;
                    char cCharAt3 = i8 < i3 ? str.charAt(i8) : (char) 0;
                    if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        K(63);
                        i2 = i8;
                    } else {
                        int i9 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST;
                        K((i9 >> 18) | 240);
                        K(((i9 >> 12) & 63) | 128);
                        K(((i9 >> 6) & 63) | 128);
                        K((i9 & 63) | 128);
                        i2 += 2;
                    }
                }
                i2++;
            }
        }
    }

    public final void P(int i2) {
        if (i2 < 128) {
            K(i2);
            return;
        }
        if (i2 < 2048) {
            K((i2 >> 6) | 192);
            K((i2 & 63) | 128);
            return;
        }
        if (i2 < 65536) {
            if (i2 >= 55296 && i2 <= 57343) {
                K(63);
                return;
            }
            K((i2 >> 12) | 224);
            K(((i2 >> 6) & 63) | 128);
            K((i2 & 63) | 128);
            return;
        }
        if (i2 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
        }
        K((i2 >> 18) | 240);
        K(((i2 >> 12) & 63) | 128);
        K(((i2 >> 6) & 63) | 128);
        K((i2 & 63) | 128);
    }

    public final void a() {
        try {
            H(this.h);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final long b() {
        long j = this.h;
        if (j == 0) {
            return 0L;
        }
        ze1 ze1Var = this.g.g;
        int i2 = ze1Var.c;
        return (i2 >= 8192 || !ze1Var.e) ? j : j - ((long) (i2 - ze1Var.b));
    }

    @Override // defpackage.ih1
    public final void c(fe feVar, long j) {
        ze1 ze1VarZ;
        if (feVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (feVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        xq1.a(feVar.h, 0L, j);
        while (j > 0) {
            ze1 ze1Var = feVar.g;
            int i2 = ze1Var.c - ze1Var.b;
            if (j < i2) {
                ze1 ze1Var2 = this.g;
                ze1 ze1Var3 = ze1Var2 != null ? ze1Var2.g : null;
                if (ze1Var3 != null && ze1Var3.e) {
                    if ((((long) ze1Var3.c) + j) - ((long) (ze1Var3.d ? 0 : ze1Var3.b)) <= 8192) {
                        ze1Var.d(ze1Var3, (int) j);
                        feVar.h -= j;
                        this.h += j;
                        return;
                    }
                }
                int i3 = (int) j;
                if (i3 <= 0 || i3 > i2) {
                    throw new IllegalArgumentException();
                }
                if (i3 >= 1024) {
                    ze1VarZ = ze1Var.c();
                } else {
                    ze1VarZ = bf1.z();
                    System.arraycopy(ze1Var.a, ze1Var.b, ze1VarZ.a, 0, i3);
                }
                ze1VarZ.c = ze1VarZ.b + i3;
                ze1Var.b += i3;
                ze1Var.g.b(ze1VarZ);
                feVar.g = ze1VarZ;
            }
            ze1 ze1Var4 = feVar.g;
            long j2 = ze1Var4.c - ze1Var4.b;
            feVar.g = ze1Var4.a();
            ze1 ze1Var5 = this.g;
            if (ze1Var5 == null) {
                this.g = ze1Var4;
                ze1Var4.g = ze1Var4;
                ze1Var4.f = ze1Var4;
            } else {
                ze1Var5.g.b(ze1Var4);
                ze1 ze1Var6 = ze1Var4.g;
                if (ze1Var6 == ze1Var4) {
                    throw new IllegalStateException();
                }
                if (ze1Var6.e) {
                    int i4 = ze1Var4.c - ze1Var4.b;
                    if (i4 <= (8192 - ze1Var6.c) + (ze1Var6.d ? 0 : ze1Var6.b)) {
                        ze1Var4.d(ze1Var6, i4);
                        ze1Var4.a();
                        bf1.s(ze1Var4);
                    }
                }
            }
            feVar.h -= j2;
            this.h += j2;
            j -= j2;
        }
    }

    public final Object clone() {
        fe feVar = new fe();
        if (this.h == 0) {
            return feVar;
        }
        ze1 ze1VarC = this.g.c();
        feVar.g = ze1VarC;
        ze1VarC.g = ze1VarC;
        ze1VarC.f = ze1VarC;
        ze1 ze1Var = this.g;
        while (true) {
            ze1Var = ze1Var.f;
            if (ze1Var == this.g) {
                feVar.h = this.h;
                return feVar;
            }
            feVar.g.g.b(ze1Var.c());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fe)) {
            return false;
        }
        fe feVar = (fe) obj;
        long j = this.h;
        if (j != feVar.h) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        ze1 ze1Var = this.g;
        ze1 ze1Var2 = feVar.g;
        int i2 = ze1Var.b;
        int i3 = ze1Var2.b;
        while (j2 < this.h) {
            long jMin = Math.min(ze1Var.c - i2, ze1Var2.c - i3);
            int i4 = 0;
            while (i4 < jMin) {
                int i5 = i2 + 1;
                int i6 = i3 + 1;
                if (ze1Var.a[i2] != ze1Var2.a[i3]) {
                    return false;
                }
                i4++;
                i2 = i5;
                i3 = i6;
            }
            if (i2 == ze1Var.c) {
                ze1Var = ze1Var.f;
                i2 = ze1Var.b;
            }
            if (i3 == ze1Var2.c) {
                ze1Var2 = ze1Var2.f;
                i3 = ze1Var2.b;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // defpackage.oe
    public final long f(fe feVar) {
        long j = this.h;
        if (j > 0) {
            feVar.c(this, j);
        }
        return j;
    }

    public final boolean h() {
        return this.h == 0;
    }

    public final int hashCode() {
        ze1 ze1Var = this.g;
        if (ze1Var == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = ze1Var.c;
            for (int i4 = ze1Var.b; i4 < i3; i4++) {
                i2 = (i2 * 31) + ze1Var.a[i4];
            }
            ze1Var = ze1Var.f;
        } while (ze1Var != this.g);
        return i2;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // defpackage.oe
    public final byte[] j() {
        try {
            return z(this.h);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final byte k(long j) {
        int i2;
        long j2 = j;
        xq1.a(this.h, j2, 1L);
        long j3 = this.h;
        if (j3 - j2 <= j2) {
            long j4 = j2 - j3;
            ze1 ze1Var = this.g;
            do {
                ze1Var = ze1Var.g;
                int i3 = ze1Var.c;
                i2 = ze1Var.b;
                j4 += (long) (i3 - i2);
            } while (j4 < 0);
            return ze1Var.a[i2 + ((int) j4)];
        }
        ze1 ze1Var2 = this.g;
        while (true) {
            int i4 = ze1Var2.c;
            int i5 = ze1Var2.b;
            long j5 = i4 - i5;
            if (j2 < j5) {
                return ze1Var2.a[i5 + ((int) j2)];
            }
            j2 -= j5;
            ze1Var2 = ze1Var2.f;
        }
    }

    @Override // defpackage.oe
    public final int l(f01 f01Var) {
        int iG = G(f01Var, false);
        if (iG == -1) {
            return -1;
        }
        try {
            H(f01Var.g[iG].i());
            return iG;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    @Override // defpackage.ne
    public final ne m(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        J(bArr, 0, bArr.length);
        return this;
    }

    public final int n(byte[] bArr, int i2, int i3) {
        xq1.a(bArr.length, i2, i3);
        ze1 ze1Var = this.g;
        if (ze1Var == null) {
            return -1;
        }
        int iMin = Math.min(i3, ze1Var.c - ze1Var.b);
        System.arraycopy(ze1Var.a, ze1Var.b, bArr, i2, iMin);
        int i4 = ze1Var.b + iMin;
        ze1Var.b = i4;
        this.h -= (long) iMin;
        if (i4 == ze1Var.c) {
            this.g = ze1Var.a();
            bf1.s(ze1Var);
        }
        return iMin;
    }

    @Override // defpackage.ne
    public final long o(fi1 fi1Var) {
        if (fi1Var == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long j2 = fi1Var.read(this, 8192L);
            if (j2 == -1) {
                return j;
            }
            j += j2;
        }
    }

    @Override // defpackage.ne
    public final /* bridge */ /* synthetic */ ne p(int i2, byte[] bArr, int i3) {
        J(bArr, i2, i3);
        return this;
    }

    public final byte r() {
        long j = this.h;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        ze1 ze1Var = this.g;
        int i2 = ze1Var.b;
        int i3 = ze1Var.c;
        int i4 = i2 + 1;
        byte b = ze1Var.a[i2];
        this.h = j - 1;
        if (i4 != i3) {
            ze1Var.b = i4;
            return b;
        }
        this.g = ze1Var.a();
        bf1.s(ze1Var);
        return b;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        ze1 ze1Var = this.g;
        if (ze1Var == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), ze1Var.c - ze1Var.b);
        byteBuffer.put(ze1Var.a, ze1Var.b, iMin);
        int i2 = ze1Var.b + iMin;
        ze1Var.b = i2;
        this.h -= (long) iMin;
        if (i2 == ze1Var.c) {
            this.g = ze1Var.a();
            bf1.s(ze1Var);
        }
        return iMin;
    }

    @Override // defpackage.ne
    public final ne t(String str) {
        O(0, str.length(), str);
        return this;
    }

    @Override // defpackage.fi1
    public final yn1 timeout() {
        return yn1.d;
    }

    public final String toString() {
        long j = this.h;
        if (j <= 2147483647L) {
            int i2 = (int) j;
            return (i2 == 0 ? df.k : new cf1(this, i2)).toString();
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.h);
    }

    @Override // defpackage.ne
    public final /* bridge */ /* synthetic */ ne u(long j) {
        L(j);
        return this;
    }

    @Override // defpackage.ne
    public final ne w(df dfVar) {
        if (dfVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        dfVar.m(this);
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i2 = iRemaining;
        while (i2 > 0) {
            ze1 ze1VarI = I(1);
            int iMin = Math.min(i2, 8192 - ze1VarI.c);
            byteBuffer.get(ze1VarI.a, ze1VarI.c, iMin);
            i2 -= iMin;
            ze1VarI.c += iMin;
        }
        this.h += (long) iRemaining;
        return iRemaining;
    }

    @Override // defpackage.oe
    public final String x(Charset charset) {
        try {
            return D(this.h, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // defpackage.oe
    public final InputStream y() {
        return new ee(this, 0);
    }

    public final byte[] z(long j) throws EOFException {
        xq1.a(this.h, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException(uo.f("byteCount > Integer.MAX_VALUE: ", j));
        }
        int i2 = (int) j;
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int iN = n(bArr, i3, i2 - i3);
            if (iN == -1) {
                throw new EOFException();
            }
            i3 += iN;
        }
        return bArr;
    }

    @Override // defpackage.fi1
    public final long read(fe feVar, long j) {
        if (feVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j >= 0) {
            long j2 = this.h;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            feVar.c(this, j);
            return j;
        }
        throw new IllegalArgumentException(uo.f("byteCount < 0: ", j));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, defpackage.ih1
    public final void close() {
    }

    @Override // defpackage.ne
    public final fe d() {
        return this;
    }

    @Override // defpackage.ih1, java.io.Flushable
    public final void flush() {
    }
}
