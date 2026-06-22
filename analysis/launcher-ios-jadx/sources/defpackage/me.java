package defpackage;

import androidx.profileinstaller.ProfileVerifier;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class me extends OutputStream implements AutoCloseable {
    public final FileOutputStream g;
    public byte[] h;
    public final cq0 i;
    public int j;

    public me(FileOutputStream fileOutputStream, cq0 cq0Var) {
        this.g = fileOutputStream;
        this.i = cq0Var;
        this.h = (byte[]) cq0Var.d(ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST, byte[].class);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        FileOutputStream fileOutputStream = this.g;
        try {
            flush();
            fileOutputStream.close();
            byte[] bArr = this.h;
            if (bArr != null) {
                this.i.h(bArr);
                this.h = null;
            }
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        int i = this.j;
        FileOutputStream fileOutputStream = this.g;
        if (i > 0) {
            fileOutputStream.write(this.h, 0, i);
            this.j = 0;
        }
        fileOutputStream.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        byte[] bArr = this.h;
        int i2 = this.j;
        int i3 = i2 + 1;
        this.j = i3;
        bArr[i2] = (byte) i;
        if (i3 != bArr.length || i3 <= 0) {
            return;
        }
        this.g.write(bArr, 0, i3);
        this.j = 0;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            int i6 = this.j;
            FileOutputStream fileOutputStream = this.g;
            if (i6 == 0 && i4 >= this.h.length) {
                fileOutputStream.write(bArr, i5, i4);
                return;
            }
            int iMin = Math.min(i4, this.h.length - i6);
            System.arraycopy(bArr, i5, this.h, this.j, iMin);
            int i7 = this.j + iMin;
            this.j = i7;
            i3 += iMin;
            byte[] bArr2 = this.h;
            if (i7 == bArr2.length && i7 > 0) {
                fileOutputStream.write(bArr2, 0, i7);
                this.j = 0;
            }
        } while (i3 < i2);
    }
}
