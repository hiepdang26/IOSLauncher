package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.util.Pair;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* JADX INFO: loaded from: classes.dex */
public abstract class sc {
    public static final Rect a = new Rect();
    public static final RectF b = new RectF();
    public static final RectF c = new RectF();
    public static final float[] d = new float[6];
    public static final float[] e = new float[6];
    public static int f;
    public static Pair g;

    public static int a(int i, int i2) {
        int i3 = 1;
        if (f == 0) {
            int iMax = 2048;
            try {
                EGL10 egl10 = (EGL10) EGLContext.getEGL();
                EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                egl10.eglInitialize(eGLDisplayEglGetDisplay, new int[2]);
                int[] iArr = new int[1];
                egl10.eglGetConfigs(eGLDisplayEglGetDisplay, null, 0, iArr);
                int i4 = iArr[0];
                EGLConfig[] eGLConfigArr = new EGLConfig[i4];
                egl10.eglGetConfigs(eGLDisplayEglGetDisplay, eGLConfigArr, i4, iArr);
                int[] iArr2 = new int[1];
                int i5 = 0;
                for (int i6 = 0; i6 < iArr[0]; i6++) {
                    egl10.eglGetConfigAttrib(eGLDisplayEglGetDisplay, eGLConfigArr[i6], 12332, iArr2);
                    int i7 = iArr2[0];
                    if (i5 < i7) {
                        i5 = i7;
                    }
                }
                egl10.eglTerminate(eGLDisplayEglGetDisplay);
                iMax = Math.max(i5, 2048);
            } catch (Exception unused) {
            }
            f = iMax;
        }
        if (f > 0) {
            while (true) {
                int i8 = i2 / i3;
                int i9 = f;
                if (i8 <= i9 && i / i3 <= i9) {
                    break;
                }
                i3 *= 2;
            }
        }
        return i3;
    }

    public static int b(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 <= i4 && i <= i3) {
            return 1;
        }
        while ((i2 / 2) / i5 > i4 && (i / 2) / i5 > i3) {
            i5 *= 2;
        }
        return i5;
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static rc d(Context context, Uri uri, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, boolean z2, boolean z3) {
        int i8 = 1;
        Context context2 = context;
        Uri uri2 = uri;
        float[] fArr2 = fArr;
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        boolean z4 = z;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        boolean z5 = z2;
        boolean z6 = z3;
        while (true) {
            try {
                return e(context2, uri2, fArr2, i9, i10, i11, z4, i12, i13, i14, i15, z5, z6, i8);
            } catch (OutOfMemoryError e2) {
                int i16 = i8 * 2;
                if (i16 > 16) {
                    throw new RuntimeException("Failed to handle OOM by sampling (" + i16 + "): " + uri + "\r\n" + e2.getMessage(), e2);
                }
                i8 = i16;
                uri2 = uri;
                fArr2 = fArr;
                i9 = i;
                i10 = i2;
                i11 = i3;
                z4 = z;
                i12 = i4;
                i13 = i5;
                i14 = i6;
                i15 = i7;
                z5 = z2;
                z6 = z3;
                context2 = context;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0085 A[Catch: OutOfMemoryError -> 0x0094, TRY_LEAVE, TryCatch #0 {OutOfMemoryError -> 0x0094, blocks: (B:36:0x0081, B:38:0x0085), top: B:79:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.rc e(android.content.Context r19, android.net.Uri r20, float[] r21, int r22, int r23, int r24, boolean r25, int r26, int r27, int r28, int r29, boolean r30, boolean r31, int r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sc.e(android.content.Context, android.net.Uri, float[], int, int, int, boolean, int, int, int, int, boolean, boolean, int):rc");
    }

    public static rc f(Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, boolean z2, boolean z3) {
        int i4 = 1;
        do {
            try {
                return new rc(i4, g(bitmap, fArr, i, z, i2, i3, 1.0f / i4, z2, z3));
            } catch (OutOfMemoryError e2) {
                i4 *= 2;
            }
        } while (i4 <= 8);
        throw e2;
    }

    public static Bitmap g(Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, float f2, boolean z2, boolean z3) {
        Rect rectN = n(fArr, bitmap.getWidth(), bitmap.getHeight(), z, i2, i3);
        Matrix matrix = new Matrix();
        matrix.setRotate(i, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        matrix.postScale(z2 ? -f2 : f2, z3 ? -f2 : f2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, rectN.left, rectN.top, rectN.width(), rectN.height(), matrix, true);
        if (bitmapCreateBitmap == bitmap) {
            bitmapCreateBitmap = bitmap.copy(bitmap.getConfig(), false);
        }
        Bitmap bitmap2 = bitmapCreateBitmap;
        return i % 90 != 0 ? h(bitmap2, fArr, rectN, i, z, i2, i3) : bitmap2;
    }

    public static Bitmap h(Bitmap bitmap, float[] fArr, Rect rect, int i, boolean z, int i2, int i3) {
        int iAbs;
        int iAbs2;
        int iAbs3;
        if (i % 90 == 0) {
            return bitmap;
        }
        double radians = Math.toRadians(i);
        int i4 = (i < 90 || (i > 180 && i < 270)) ? rect.left : rect.right;
        int iAbs4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 >= fArr.length) {
                iAbs = 0;
                iAbs2 = 0;
                iAbs3 = 0;
                break;
            }
            float f2 = fArr[i5];
            if (f2 >= i4 - 1 && f2 <= i4 + 1) {
                int i6 = i5 + 1;
                iAbs4 = (int) Math.abs(Math.sin(radians) * ((double) (rect.bottom - fArr[i6])));
                iAbs2 = (int) Math.abs(Math.cos(radians) * ((double) (fArr[i6] - rect.top)));
                iAbs3 = (int) Math.abs(((double) (fArr[i6] - rect.top)) / Math.sin(radians));
                iAbs = (int) Math.abs(((double) (rect.bottom - fArr[i6])) / Math.cos(radians));
                break;
            }
            i5 += 2;
        }
        rect.set(iAbs4, iAbs2, iAbs3 + iAbs4, iAbs + iAbs2);
        if (z) {
            l(i2, i3, rect);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height());
        if (bitmap != bitmapCreateBitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap i(ContentResolver contentResolver, Uri uri, BitmapFactory.Options options) {
        do {
            InputStream inputStreamOpenInputStream = null;
            try {
                try {
                    inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                    return BitmapFactory.decodeStream(inputStreamOpenInputStream, a, options);
                } catch (OutOfMemoryError unused) {
                    options.inSampleSize *= 2;
                    c(inputStreamOpenInputStream);
                }
            } finally {
                c(inputStreamOpenInputStream);
            }
        } while (options.inSampleSize <= 512);
        throw new RuntimeException(k31.l(uri, "Failed to decode image: "));
    }

    public static rc j(Context context, Uri uri, int i, int i2) throws Throwable {
        InputStream inputStreamOpenInputStream;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            try {
                inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            } catch (Throwable th) {
                th = th;
                inputStreamOpenInputStream = null;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStreamOpenInputStream, a, options);
                options.inJustDecodeBounds = false;
                c(inputStreamOpenInputStream);
                int i3 = options.outWidth;
                if (i3 == -1 && options.outHeight == -1) {
                    throw new RuntimeException("File is not a picture");
                }
                options.inSampleSize = Math.max(b(i3, options.outHeight, i, i2), a(options.outWidth, options.outHeight));
                return new rc(options.inSampleSize, i(contentResolver, uri, options));
            } catch (Throwable th2) {
                th = th2;
                c(inputStreamOpenInputStream);
                throw th;
            }
        } catch (Exception e2) {
            throw new RuntimeException("Failed to load sampled bitmap: " + uri + "\r\n" + e2.getMessage(), e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.rc k(android.content.Context r4, android.net.Uri r5, android.graphics.Rect r6, int r7, int r8, int r9) throws java.lang.Throwable {
        /*
            r0 = 0
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            r1.<init>()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            int r2 = r6.width()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            int r3 = r6.height()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            int r7 = b(r2, r3, r7, r8)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            int r9 = r9 * r7
            r1.inSampleSize = r9     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            java.io.InputStream r4 = r4.openInputStream(r5)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5d
            r7 = 0
            android.graphics.BitmapRegionDecoder r7 = android.graphics.BitmapRegionDecoder.newInstance(r4, r7)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
        L23:
            rc r8 = new rc     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38 java.lang.OutOfMemoryError -> L3b
            android.graphics.Bitmap r9 = r7.decodeRegion(r6, r1)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38 java.lang.OutOfMemoryError -> L3b
            int r2 = r1.inSampleSize     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38 java.lang.OutOfMemoryError -> L3b
            r8.<init>(r2, r9)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38 java.lang.OutOfMemoryError -> L3b
            c(r4)
            r7.recycle()
            return r8
        L35:
            r5 = move-exception
        L36:
            r0 = r4
            goto L83
        L38:
            r6 = move-exception
        L39:
            r0 = r4
            goto L5f
        L3b:
            int r8 = r1.inSampleSize     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            int r8 = r8 * 2
            r1.inSampleSize = r8     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            r9 = 512(0x200, float:7.17E-43)
            if (r8 <= r9) goto L23
            c(r4)
            if (r7 == 0) goto L4d
            r7.recycle()
        L4d:
            rc r4 = new rc
            r5 = 1
            r4.<init>(r5, r0)
            return r4
        L54:
            r5 = move-exception
            r7 = r0
            goto L36
        L57:
            r6 = move-exception
            r7 = r0
            goto L39
        L5a:
            r5 = move-exception
            r7 = r0
            goto L83
        L5d:
            r6 = move-exception
            r7 = r0
        L5f:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L82
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82
            r8.<init>()     // Catch: java.lang.Throwable -> L82
            java.lang.String r9 = "Failed to load sampled bitmap: "
            r8.append(r9)     // Catch: java.lang.Throwable -> L82
            r8.append(r5)     // Catch: java.lang.Throwable -> L82
            java.lang.String r5 = "\r\n"
            r8.append(r5)     // Catch: java.lang.Throwable -> L82
            java.lang.String r5 = r6.getMessage()     // Catch: java.lang.Throwable -> L82
            r8.append(r5)     // Catch: java.lang.Throwable -> L82
            java.lang.String r5 = r8.toString()     // Catch: java.lang.Throwable -> L82
            r4.<init>(r5, r6)     // Catch: java.lang.Throwable -> L82
            throw r4     // Catch: java.lang.Throwable -> L82
        L82:
            r5 = move-exception
        L83:
            c(r0)
            if (r7 == 0) goto L8b
            r7.recycle()
        L8b:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sc.k(android.content.Context, android.net.Uri, android.graphics.Rect, int, int, int):rc");
    }

    public static void l(int i, int i2, Rect rect) {
        if (i != i2 || rect.width() == rect.height()) {
            return;
        }
        if (rect.height() > rect.width()) {
            rect.bottom -= rect.height() - rect.width();
        } else {
            rect.right -= rect.width() - rect.height();
        }
    }

    public static float m(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    public static Rect n(float[] fArr, int i, int i2, boolean z, int i3, int i4) {
        Rect rect = new Rect(Math.round(Math.max(0.0f, o(fArr))), Math.round(Math.max(0.0f, q(fArr))), Math.round(Math.min(i, p(fArr))), Math.round(Math.min(i2, m(fArr))));
        if (z) {
            l(i3, i4, rect);
        }
        return rect;
    }

    public static float o(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    public static float p(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    public static float q(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    public static Bitmap r(Bitmap bitmap, int i, int i2, int i3) {
        Bitmap bitmapCreateScaledBitmap;
        if (i > 0 && i2 > 0 && (i3 == 4 || i3 == 3 || i3 == 5)) {
            try {
                if (i3 == 5) {
                    bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                } else {
                    float width = bitmap.getWidth();
                    float height = bitmap.getHeight();
                    float fMax = Math.max(width / i, height / i2);
                    bitmapCreateScaledBitmap = (fMax > 1.0f || i3 == 4) ? Bitmap.createScaledBitmap(bitmap, (int) (width / fMax), (int) (height / fMax), false) : null;
                }
                if (bitmapCreateScaledBitmap != null) {
                    if (bitmapCreateScaledBitmap != bitmap) {
                        bitmap.recycle();
                    }
                    return bitmapCreateScaledBitmap;
                }
            } catch (Exception unused) {
            }
        }
        return bitmap;
    }
}
