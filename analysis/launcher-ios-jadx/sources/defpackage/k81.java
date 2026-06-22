package defpackage;

import androidx.profileinstaller.ProfileVerifier;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class k81 extends FilterInputStream implements AutoCloseable {
    public volatile byte[] g;
    public int h;
    public int i;
    public int j;
    public int k;
    public final cq0 l;

    public k81(InputStream inputStream, cq0 cq0Var) {
        super(inputStream);
        this.j = -1;
        this.l = cq0Var;
        this.g = (byte[]) cq0Var.d(ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST, byte[].class);
    }

    public static void h() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public final int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.j;
        if (i != -1) {
            int i2 = this.k - i;
            int i3 = this.i;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.h == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    byte[] bArr2 = (byte[]) this.l.d(i3, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.g = bArr2;
                    this.l.h(bArr);
                    bArr = bArr2;
                } else if (i > 0) {
                    System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i4 = this.k - this.j;
                this.k = i4;
                this.j = 0;
                this.h = 0;
                int i5 = inputStream.read(bArr, i4, bArr.length - i4);
                int i6 = this.k;
                if (i5 > 0) {
                    i6 += i5;
                }
                this.h = i6;
                return i5;
            }
        }
        int i7 = inputStream.read(bArr);
        if (i7 > 0) {
            this.j = -1;
            this.k = 0;
            this.h = i7;
        }
        return i7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.g == null || inputStream == null) {
            h();
            throw null;
        }
        return (this.h - this.k) + inputStream.available();
    }

    public final synchronized void b() {
        if (this.g != null) {
            this.l.h(this.g);
            this.g = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.g != null) {
            this.l.h(this.g);
            this.g = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        this.i = Math.max(this.i, i);
        this.j = this.k;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        byte[] bArr = this.g;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            h();
            throw null;
        }
        if (this.k >= this.h && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.g && (bArr = this.g) == null) {
            h();
            throw null;
        }
        int i = this.h;
        int i2 = this.k;
        if (i - i2 <= 0) {
            return -1;
        }
        this.k = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (this.g == null) {
            throw new IOException("Stream is closed");
        }
        int i = this.j;
        if (-1 == i) {
            throw new sj("Mark has been invalidated, pos: " + this.k + " markLimit: " + this.i);
        }
        this.k = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j) {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.g;
        if (bArr == null) {
            h();
            throw null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            h();
            throw null;
        }
        int i = this.h;
        int i2 = this.k;
        if (i - i2 >= j) {
            this.k = (int) (((long) i2) + j);
            return j;
        }
        long j2 = ((long) i) - ((long) i2);
        this.k = i;
        if (this.j == -1 || j > this.i) {
            long jSkip = inputStream.skip(j - j2);
            if (jSkip > 0) {
                this.j = -1;
            }
            return j2 + jSkip;
        }
        if (a(inputStream, bArr) == -1) {
            return j2;
        }
        int i3 = this.h;
        int i4 = this.k;
        if (i3 - i4 >= j - j2) {
            this.k = (int) ((((long) i4) + j) - j2);
            return j;
        }
        long j3 = (j2 + ((long) i3)) - ((long) i4);
        this.k = i3;
        return j3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        byte[] bArr2 = this.g;
        if (bArr2 == null) {
            h();
            throw null;
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i5 = this.k;
            int i6 = this.h;
            if (i5 < i6) {
                int i7 = i6 - i5;
                if (i7 >= i2) {
                    i7 = i2;
                }
                System.arraycopy(bArr2, i5, bArr, i, i7);
                this.k += i7;
                if (i7 == i2 || inputStream.available() == 0) {
                    return i7;
                }
                i += i7;
                i3 = i2 - i7;
            } else {
                i3 = i2;
            }
            while (true) {
                if (this.j == -1 && i3 >= bArr2.length) {
                    i4 = inputStream.read(bArr, i, i3);
                    if (i4 == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                    if (bArr2 != this.g && (bArr2 = this.g) == null) {
                        h();
                        throw null;
                    }
                    int i8 = this.h;
                    int i9 = this.k;
                    i4 = i8 - i9;
                    if (i4 >= i3) {
                        i4 = i3;
                    }
                    System.arraycopy(bArr2, i9, bArr, i, i4);
                    this.k += i4;
                }
                i3 -= i4;
                if (i3 == 0) {
                    return i2;
                }
                if (inputStream.available() == 0) {
                    return i2 - i3;
                }
                i += i4;
            }
        } else {
            h();
            throw null;
        }
    }
}
