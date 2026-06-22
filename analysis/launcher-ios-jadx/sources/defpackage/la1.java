package defpackage;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public abstract class la1 {
    public static la1 create(ks0 ks0Var, String str) {
        String str2;
        Charset charset = StandardCharsets.UTF_8;
        if (ks0Var != null) {
            try {
                str2 = ks0Var.c;
            } catch (IllegalArgumentException unused) {
            }
            Charset charsetForName = str2 != null ? Charset.forName(str2) : null;
            if (charsetForName == null) {
                try {
                    ks0Var = ks0.a(ks0Var + "; charset=utf-8");
                } catch (IllegalArgumentException unused2) {
                    ks0Var = null;
                }
            } else {
                charset = charsetForName;
            }
        }
        return create(ks0Var, str.getBytes(charset));
    }

    public abstract long contentLength();

    public abstract ks0 contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(ne neVar);

    public static la1 create(ks0 ks0Var, df dfVar) {
        return new ja1(ks0Var, dfVar, 0);
    }

    public static la1 create(ks0 ks0Var, byte[] bArr) {
        return create(ks0Var, bArr, 0, bArr.length);
    }

    public static la1 create(ks0 ks0Var, byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long length = bArr.length;
            long j = i;
            long j2 = i2;
            byte[] bArr2 = wq1.a;
            if ((j | j2) >= 0 && j <= length && length - j >= j2) {
                return new ka1(ks0Var, bArr, i2, i);
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new NullPointerException("content == null");
    }

    public static la1 create(ks0 ks0Var, File file) {
        if (file != null) {
            return new ja1(ks0Var, file, 1);
        }
        throw new NullPointerException("file == null");
    }
}
