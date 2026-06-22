package defpackage;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class ct implements af0 {
    public static final byte[] a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    public static final int[] b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static int e(bt btVar, cq0 cq0Var) {
        int iL;
        try {
            int iL2 = btVar.l();
            if (!((iL2 & 65496) == 65496 || iL2 == 19789 || iL2 == 18761)) {
                Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            while (true) {
                if (btVar.j() == 255) {
                    short sJ = btVar.j();
                    if (sJ == 218) {
                        break;
                    }
                    if (sJ != 217) {
                        iL = btVar.l() - 2;
                        if (sJ == 225) {
                            break;
                        }
                        long j = iL;
                        if (btVar.b(j) != j) {
                            Log.isLoggable("DfltImageHeaderParser", 3);
                            break;
                        }
                    } else {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                        break;
                    }
                } else {
                    Log.isLoggable("DfltImageHeaderParser", 3);
                    break;
                }
            }
            iL = -1;
            if (iL == -1) {
                Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            byte[] bArr = (byte[]) cq0Var.d(iL, byte[].class);
            try {
                return g(btVar, bArr, iL);
            } finally {
                cq0Var.h(bArr);
            }
        } catch (at unused) {
            return -1;
        }
    }

    public static ImageHeaderParser$ImageType f(bt btVar) {
        try {
            int iL = btVar.l();
            if (iL == 65496) {
                return ImageHeaderParser$ImageType.JPEG;
            }
            int iJ = (iL << 8) | btVar.j();
            if (iJ == 4671814) {
                return ImageHeaderParser$ImageType.GIF;
            }
            int iJ2 = (iJ << 8) | btVar.j();
            if (iJ2 == -1991225785) {
                btVar.b(21L);
                try {
                    return btVar.j() >= 3 ? ImageHeaderParser$ImageType.PNG_A : ImageHeaderParser$ImageType.PNG;
                } catch (at unused) {
                    return ImageHeaderParser$ImageType.PNG;
                }
            }
            if (iJ2 == 1380533830) {
                btVar.b(4L);
                if (((btVar.l() << 16) | btVar.l()) != 1464156752) {
                    return ImageHeaderParser$ImageType.UNKNOWN;
                }
                int iL2 = (btVar.l() << 16) | btVar.l();
                if ((iL2 & (-256)) != 1448097792) {
                    return ImageHeaderParser$ImageType.UNKNOWN;
                }
                int i = iL2 & 255;
                if (i == 88) {
                    btVar.b(4L);
                    short sJ = btVar.j();
                    return (sJ & 2) != 0 ? ImageHeaderParser$ImageType.ANIMATED_WEBP : (sJ & 16) != 0 ? ImageHeaderParser$ImageType.WEBP_A : ImageHeaderParser$ImageType.WEBP;
                }
                if (i != 76) {
                    return ImageHeaderParser$ImageType.WEBP;
                }
                btVar.b(4L);
                return (btVar.j() & 8) != 0 ? ImageHeaderParser$ImageType.WEBP_A : ImageHeaderParser$ImageType.WEBP;
            }
            if (((btVar.l() << 16) | btVar.l()) != 1718909296) {
                return ImageHeaderParser$ImageType.UNKNOWN;
            }
            int iL3 = (btVar.l() << 16) | btVar.l();
            if (iL3 == 1635150195) {
                return ImageHeaderParser$ImageType.ANIMATED_AVIF;
            }
            int i2 = 0;
            boolean z = iL3 == 1635150182;
            btVar.b(4L);
            int i3 = iJ2 - 16;
            if (i3 % 4 == 0) {
                while (i2 < 5 && i3 > 0) {
                    int iL4 = (btVar.l() << 16) | btVar.l();
                    if (iL4 == 1635150195) {
                        return ImageHeaderParser$ImageType.ANIMATED_AVIF;
                    }
                    if (iL4 == 1635150182) {
                        z = true;
                    }
                    i2++;
                    i3 -= 4;
                }
            }
            return z ? ImageHeaderParser$ImageType.AVIF : ImageHeaderParser$ImageType.UNKNOWN;
        } catch (at unused2) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    public static int g(bt btVar, byte[] bArr, int i) {
        ByteOrder byteOrder;
        if (btVar.o(i, bArr) != i) {
            Log.isLoggable("DfltImageHeaderParser", 3);
            return -1;
        }
        byte[] bArr2 = a;
        boolean z = bArr != null && i > bArr2.length;
        if (z) {
            int i2 = 0;
            while (true) {
                if (i2 >= bArr2.length) {
                    break;
                }
                if (bArr[i2] != bArr2[i2]) {
                    z = false;
                    break;
                }
                i2++;
            }
        }
        if (!z) {
            Log.isLoggable("DfltImageHeaderParser", 3);
            return -1;
        }
        ByteBuffer byteBuffer = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        short s = byteBuffer.remaining() - 6 >= 2 ? byteBuffer.getShort(6) : (short) -1;
        if (s == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (s != 19789) {
            Log.isLoggable("DfltImageHeaderParser", 3);
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        byteBuffer.order(byteOrder);
        int i3 = byteBuffer.remaining() - 10 >= 4 ? byteBuffer.getInt(10) : -1;
        int i4 = i3 + 6;
        short s2 = byteBuffer.remaining() - i4 >= 2 ? byteBuffer.getShort(i4) : (short) -1;
        for (int i5 = 0; i5 < s2; i5++) {
            int i6 = (i5 * 12) + i3 + 8;
            if ((byteBuffer.remaining() - i6 >= 2 ? byteBuffer.getShort(i6) : (short) -1) == 274) {
                int i7 = i6 + 2;
                short s3 = byteBuffer.remaining() - i7 >= 2 ? byteBuffer.getShort(i7) : (short) -1;
                if (s3 < 1 || s3 > 12) {
                    Log.isLoggable("DfltImageHeaderParser", 3);
                } else {
                    int i8 = i6 + 4;
                    int i9 = byteBuffer.remaining() - i8 >= 4 ? byteBuffer.getInt(i8) : -1;
                    if (i9 < 0) {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                    } else {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                        int i10 = i9 + b[s3];
                        if (i10 > 4) {
                            Log.isLoggable("DfltImageHeaderParser", 3);
                        } else {
                            int i11 = i6 + 8;
                            if (i11 < 0 || i11 > byteBuffer.remaining()) {
                                Log.isLoggable("DfltImageHeaderParser", 3);
                            } else {
                                if (i10 >= 0 && i10 + i11 <= byteBuffer.remaining()) {
                                    if (byteBuffer.remaining() - i11 >= 2) {
                                        return byteBuffer.getShort(i11);
                                    }
                                    return -1;
                                }
                                Log.isLoggable("DfltImageHeaderParser", 3);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    @Override // defpackage.af0
    public final ImageHeaderParser$ImageType a(ByteBuffer byteBuffer) {
        n90.h(byteBuffer, "Argument must not be null");
        return f(new tj(byteBuffer));
    }

    @Override // defpackage.af0
    public final int b(InputStream inputStream, cq0 cq0Var) {
        nx0 nx0Var = new nx0(inputStream, 10);
        n90.h(cq0Var, "Argument must not be null");
        return e(nx0Var, cq0Var);
    }

    @Override // defpackage.af0
    public final int c(ByteBuffer byteBuffer, cq0 cq0Var) {
        tj tjVar = new tj(byteBuffer);
        n90.h(cq0Var, "Argument must not be null");
        return e(tjVar, cq0Var);
    }

    @Override // defpackage.af0
    public final ImageHeaderParser$ImageType d(InputStream inputStream) {
        return f(new nx0(inputStream, 10));
    }
}
