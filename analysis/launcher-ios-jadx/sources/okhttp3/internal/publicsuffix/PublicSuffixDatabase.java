package okhttp3.internal.publicsuffix;

import defpackage.b81;
import defpackage.jy0;
import defpackage.n9;
import defpackage.xa0;
import defpackage.yn1;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class PublicSuffixDatabase {
    public static final byte[] e = {42};
    public static final String[] f = new String[0];
    public static final String[] g = {"*"};
    public static final PublicSuffixDatabase h = new PublicSuffixDatabase();
    public final AtomicBoolean a = new AtomicBoolean(false);
    public final CountDownLatch b = new CountDownLatch(1);
    public byte[] c;
    public byte[] d;

    public static String a(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 > -1 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z2 = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z2) {
                    i3 = 46;
                    z = false;
                } else {
                    z = z2;
                    i3 = bArr2[i10][i11] & 255;
                }
                i4 = i3 - (bArr[i7 + i12] & 255);
                if (i4 == 0) {
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    }
                    if (bArr2[i10].length != i11) {
                        z2 = z;
                    } else {
                        if (i10 == bArr2.length - 1) {
                            break;
                        }
                        i10++;
                        z2 = true;
                        i11 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, StandardCharsets.UTF_8);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i6;
        }
        return null;
    }

    public final void b() {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        Logger logger = jy0.a;
        b81 b81Var = new b81(new xa0(new n9(new yn1(), resourceAsStream)));
        try {
            byte[] bArr = new byte[b81Var.r()];
            b81Var.n(bArr);
            byte[] bArr2 = new byte[b81Var.r()];
            b81Var.n(bArr2);
            b81Var.close();
            synchronized (this) {
                this.c = bArr;
                this.d = bArr2;
            }
            this.b.countDown();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    b81Var.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
