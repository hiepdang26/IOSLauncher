package defpackage;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class n10 extends InputStream implements DataInput {
    public final DataInputStream g;
    public int h;
    public ByteOrder i;
    public byte[] j;
    public final int k;

    public n10(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        this(byteArrayInputStream, 0);
        this.k = bArr.length;
    }

    public final void a(int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            DataInputStream dataInputStream = this.g;
            int i3 = i - i2;
            int iSkip = (int) dataInputStream.skip(i3);
            if (iSkip <= 0) {
                if (this.j == null) {
                    this.j = new byte[8192];
                }
                iSkip = dataInputStream.read(this.j, 0, Math.min(8192, i3));
                if (iSkip == -1) {
                    throw new EOFException(uo.d(i, "Reached EOF while skipping ", " bytes."));
                }
            }
            i2 += iSkip;
        }
        this.h += i2;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.g.available();
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        throw new UnsupportedOperationException("Mark is currently unsupported");
    }

    @Override // java.io.InputStream
    public final int read() {
        this.h++;
        return this.g.read();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        this.h++;
        return this.g.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() throws IOException {
        this.h++;
        int i = this.g.read();
        if (i >= 0) {
            return (byte) i;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        this.h += 2;
        return this.g.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.h += i2;
        this.g.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        this.h += 4;
        DataInputStream dataInputStream = this.g;
        int i = dataInputStream.read();
        int i2 = dataInputStream.read();
        int i3 = dataInputStream.read();
        int i4 = dataInputStream.read();
        if ((i | i2 | i3 | i4) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.i;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (i4 << 24) + (i3 << 16) + (i2 << 8) + i;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (i << 24) + (i2 << 16) + (i3 << 8) + i4;
        }
        throw new IOException("Invalid byte order: " + this.i);
    }

    @Override // java.io.DataInput
    public final String readLine() {
        return null;
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        long j;
        long j2;
        this.h += 8;
        DataInputStream dataInputStream = this.g;
        int i = dataInputStream.read();
        int i2 = dataInputStream.read();
        int i3 = dataInputStream.read();
        int i4 = dataInputStream.read();
        int i5 = dataInputStream.read();
        int i6 = dataInputStream.read();
        int i7 = dataInputStream.read();
        int i8 = dataInputStream.read();
        if ((i | i2 | i3 | i4 | i5 | i6 | i7 | i8) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.i;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            j = (((long) i8) << 56) + (((long) i7) << 48) + (((long) i6) << 40) + (((long) i5) << 32) + (((long) i4) << 24) + (((long) i3) << 16) + (((long) i2) << 8);
            j2 = i;
        } else {
            if (byteOrder != ByteOrder.BIG_ENDIAN) {
                throw new IOException("Invalid byte order: " + this.i);
            }
            j = (((long) i) << 56) + (((long) i2) << 48) + (((long) i3) << 40) + (((long) i4) << 32) + (((long) i5) << 24) + (((long) i6) << 16) + (((long) i7) << 8);
            j2 = i8;
        }
        return j + j2;
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        this.h += 2;
        DataInputStream dataInputStream = this.g;
        int i = dataInputStream.read();
        int i2 = dataInputStream.read();
        if ((i | i2) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.i;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (short) ((i2 << 8) + i);
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (short) ((i << 8) + i2);
        }
        throw new IOException("Invalid byte order: " + this.i);
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        this.h += 2;
        return this.g.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        this.h++;
        return this.g.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        this.h += 2;
        DataInputStream dataInputStream = this.g;
        int i = dataInputStream.read();
        int i2 = dataInputStream.read();
        if ((i | i2) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.i;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (i2 << 8) + i;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (i << 8) + i2;
        }
        throw new IOException("Invalid byte order: " + this.i);
    }

    @Override // java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException("Reset is currently unsupported");
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) {
        throw new UnsupportedOperationException("skipBytes is currently unsupported");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n10(InputStream inputStream) {
        this(inputStream, 0);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.g.read(bArr, i, i2);
        this.h += i3;
        return i3;
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) throws IOException {
        this.h += bArr.length;
        this.g.readFully(bArr);
    }

    public n10(InputStream inputStream, int i) {
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.g = dataInputStream;
        dataInputStream.mark(0);
        this.h = 0;
        this.i = byteOrder;
        this.k = inputStream instanceof n10 ? ((n10) inputStream).k : -1;
    }
}
