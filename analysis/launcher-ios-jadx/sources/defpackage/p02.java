package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Xml;
import android.view.inputmethod.EditorInfo;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class p02 {
    public static final String[] g = new String[0];
    public static final Object h = new Object();
    public static p02 i = null;
    public static final v20 j;
    public static final v20[] k;
    public static volatile boolean l = true;

    static {
        v20 v20Var = new v20("CLIENT_TELEMETRY");
        j = v20Var;
        k = new v20[]{v20Var};
    }

    public static final void C(String str) {
        qg0.l(str, "message");
        throw new IllegalArgumentException(str);
    }

    public static boolean E(Bundle bundle, Bundle bundle2) {
        if (bundle != null && bundle2 != null) {
            if (bundle.size() != bundle2.size()) {
                return false;
            }
            for (String str : bundle.keySet()) {
                if (!bundle2.containsKey(str)) {
                    return false;
                }
                Object obj = bundle.get(str);
                Object obj2 = bundle2.get(str);
                if (obj == null || obj2 == null) {
                    bundle2 = obj2;
                    bundle = obj;
                } else if (obj instanceof Bundle) {
                    if (!(obj2 instanceof Bundle) || !E((Bundle) obj, (Bundle) obj2)) {
                        return false;
                    }
                } else if (obj.getClass().isArray()) {
                    int length = Array.getLength(obj);
                    if (!obj2.getClass().isArray() || length != Array.getLength(obj2)) {
                        return false;
                    }
                    for (int i2 = 0; i2 < length; i2++) {
                        if (!bf1.c(Array.get(obj, i2), Array.get(obj2, i2))) {
                            return false;
                        }
                    }
                } else if (!obj.equals(obj2)) {
                    return false;
                }
            }
            return true;
        }
        return bundle == null && bundle2 == null;
    }

    public static void a(StringBuilder sb, Object obj, o70 o70Var) {
        if (o70Var != null) {
            sb.append((CharSequence) o70Var.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) obj.toString());
        }
    }

    public static boolean b(t11[] t11VarArr, t11[] t11VarArr2) {
        if (t11VarArr == null || t11VarArr2 == null || t11VarArr.length != t11VarArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < t11VarArr.length; i2++) {
            t11 t11Var = t11VarArr[i2];
            char c = t11Var.a;
            t11 t11Var2 = t11VarArr2[i2];
            if (c != t11Var2.a || t11Var.b.length != t11Var2.b.length) {
                return false;
            }
        }
        return true;
    }

    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static float[] e(float[] fArr, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int iMin = Math.min(i2, length);
        float[] fArr2 = new float[i2];
        System.arraycopy(fArr, 0, fArr2, 0, iMin);
        return fArr2;
    }

    public static boolean f(File file, Resources resources, int i2) throws Throwable {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i2);
            try {
                boolean zG = g(file, inputStreamOpenRawResource);
                d(inputStreamOpenRawResource);
                return zG;
            } catch (Throwable th) {
                th = th;
                d(inputStreamOpenRawResource);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenRawResource = null;
        }
    }

    public static boolean g(File file, InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    d(fileOutputStream);
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return true;
                }
                fileOutputStream.write(bArr, 0, i2);
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            e.getMessage();
            d(fileOutputStream2);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d(fileOutputStream2);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0098 A[Catch: NumberFormatException -> 0x00ac, LOOP:3: B:25:0x006a->B:44:0x0098, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00ac, blocks: (B:22:0x0056, B:25:0x006a, B:27:0x0070, B:31:0x007c, B:44:0x0098, B:46:0x009e, B:52:0x00b3, B:53:0x00b6), top: B:68:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009e A[Catch: NumberFormatException -> 0x00ac, TryCatch #0 {NumberFormatException -> 0x00ac, blocks: (B:22:0x0056, B:25:0x006a, B:27:0x0070, B:31:0x007c, B:44:0x0098, B:46:0x009e, B:52:0x00b3, B:53:0x00b6), top: B:68:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b3 A[Catch: NumberFormatException -> 0x00ac, TryCatch #0 {NumberFormatException -> 0x00ac, blocks: (B:22:0x0056, B:25:0x006a, B:27:0x0070, B:31:0x007c, B:44:0x0098, B:46:0x009e, B:52:0x00b3, B:53:0x00b6), top: B:68:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0097 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.t11[] h(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p02.h(java.lang.String):t11[]");
    }

    public static Path i(String str) {
        Path path = new Path();
        try {
            q(h(str), path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in parsing ".concat(str), e);
        }
    }

    public static t11[] j(t11[] t11VarArr) {
        t11[] t11VarArr2 = new t11[t11VarArr.length];
        for (int i2 = 0; i2 < t11VarArr.length; i2++) {
            t11VarArr2[i2] = new t11(t11VarArr[i2]);
        }
        return t11VarArr2;
    }

    public static Drawable k(Context context, Context context2, int i2, Resources.Theme theme) {
        try {
            if (l) {
                return n(context2, i2, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e;
            }
            return context2.getDrawable(i2);
        } catch (NoClassDefFoundError unused2) {
            l = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        Resources resources = context2.getResources();
        ThreadLocal threadLocal = rb1.a;
        return resources.getDrawable(i2, theme);
    }

    public static p02 l(Context context) {
        p02 p02Var;
        synchronized (h) {
            try {
                if (i == null) {
                    if (ar1.m) {
                        i = new r01(context);
                    } else {
                        i = new p01();
                    }
                }
                p02Var = i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return p02Var;
    }

    public static File m(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i2 = 0; i2 < 100; i2++) {
            File file = new File(cacheDir, str + i2);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public static Drawable n(Context context, int i2, Resources.Theme theme) {
        if (theme != null) {
            co coVar = new co(context, theme);
            coVar.a(theme.getResources().getConfiguration());
            context = coVar;
        }
        return hg0.o(context, i2);
    }

    public static yo o(wo woVar, xo xoVar) {
        qg0.l(xoVar, "key");
        return qg0.d(woVar.getKey(), xoVar) ? sz.g : woVar;
    }

    public static MappedByteBuffer p(Uri uri, Context context) {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        try {
            parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
        } catch (IOException unused) {
        }
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                parcelFileDescriptorOpenFileDescriptor.close();
                return null;
            }
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                parcelFileDescriptorOpenFileDescriptor.close();
                return map;
            } finally {
            }
        } finally {
        }
    }

    public static void q(t11[] t11VarArr, Path path) {
        int i2;
        int i3;
        t11 t11Var;
        int i4;
        char c;
        float f;
        float f2;
        float f3;
        float f4;
        t11 t11Var2;
        boolean z;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        Path path2 = path;
        float[] fArr = new float[6];
        int length = t11VarArr.length;
        char c2 = 'm';
        char c3 = 0;
        char c4 = 'm';
        int i5 = 0;
        while (i5 < length) {
            t11 t11Var3 = t11VarArr[i5];
            char c5 = t11Var3.a;
            float f13 = fArr[c3];
            float f14 = fArr[1];
            float f15 = fArr[2];
            float f16 = fArr[3];
            float f17 = fArr[4];
            float f18 = fArr[5];
            switch (c5) {
                case 'A':
                case 'a':
                    i2 = 7;
                    break;
                case 'C':
                case 'c':
                    i2 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i2 = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i2 = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    path2.moveTo(f17, f18);
                    f13 = f17;
                    f15 = f13;
                    f14 = f18;
                    f16 = f14;
                default:
                    i2 = 2;
                    break;
            }
            float f19 = f14;
            float f20 = f17;
            float f21 = f18;
            float f22 = f13;
            int i6 = 0;
            while (true) {
                float[] fArr2 = t11Var3.b;
                if (i6 < fArr2.length) {
                    if (c5 == 'A') {
                        i3 = i6;
                        t11Var = t11Var3;
                        float f23 = f22;
                        float f24 = f19;
                        i4 = i5;
                        c = c5;
                        int i7 = i3 + 5;
                        int i8 = i3 + 6;
                        t11.a(path, f23, f24, fArr2[i7], fArr2[i8], fArr2[i3], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                        f15 = fArr2[i7];
                        f = fArr2[i8];
                        f16 = f;
                        f2 = f15;
                    } else if (c5 == 'C') {
                        i3 = i6;
                        i4 = i5;
                        t11Var = t11Var3;
                        c = c5;
                        int i9 = i3 + 2;
                        int i10 = i3 + 3;
                        int i11 = i3 + 4;
                        int i12 = i3 + 5;
                        path2.cubicTo(fArr2[i3], fArr2[i3 + 1], fArr2[i9], fArr2[i10], fArr2[i11], fArr2[i12]);
                        float f25 = fArr2[i11];
                        float f26 = fArr2[i12];
                        f15 = fArr2[i9];
                        f16 = fArr2[i10];
                        f = f26;
                        f2 = f25;
                    } else if (c5 != 'H') {
                        if (c5 == 'Q') {
                            i3 = i6;
                            i4 = i5;
                            t11Var = t11Var3;
                            c = c5;
                            int i13 = i3 + 1;
                            int i14 = i3 + 2;
                            int i15 = i3 + 3;
                            path2.quadTo(fArr2[i3], fArr2[i13], fArr2[i14], fArr2[i15]);
                            f3 = fArr2[i3];
                            float f27 = fArr2[i13];
                            f4 = fArr2[i14];
                            f16 = f27;
                            f = fArr2[i15];
                        } else if (c5 == 'V') {
                            i3 = i6;
                            i4 = i5;
                            t11Var = t11Var3;
                            f2 = f22;
                            c = c5;
                            path2.lineTo(f2, fArr2[i3]);
                            f = fArr2[i3];
                        } else if (c5 != 'a') {
                            if (c5 == 'c') {
                                i3 = i6;
                                int i16 = i3 + 2;
                                int i17 = i3 + 3;
                                int i18 = i3 + 4;
                                int i19 = i3 + 5;
                                path2.rCubicTo(fArr2[i3], fArr2[i3 + 1], fArr2[i16], fArr2[i17], fArr2[i18], fArr2[i19]);
                                float f28 = fArr2[i16] + f22;
                                float f29 = f19 + fArr2[i17];
                                f22 += fArr2[i18];
                                f19 += fArr2[i19];
                                f15 = f28;
                                f16 = f29;
                            } else if (c5 != 'h') {
                                if (c5 != 'q') {
                                    if (c5 != 'v') {
                                        if (c5 == 'L') {
                                            i3 = i6;
                                            int i20 = i3 + 1;
                                            path2.lineTo(fArr2[i3], fArr2[i20]);
                                            f2 = fArr2[i3];
                                            f = fArr2[i20];
                                        } else if (c5 == 'M') {
                                            i3 = i6;
                                            f2 = fArr2[i3];
                                            f = fArr2[i3 + 1];
                                            if (i3 > 0) {
                                                path2.lineTo(f2, f);
                                            } else {
                                                path2.moveTo(f2, f);
                                                f20 = f2;
                                                f21 = f;
                                            }
                                        } else if (c5 == 'S') {
                                            i3 = i6;
                                            if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                                f22 = (f22 * 2.0f) - f15;
                                                f19 = (f19 * 2.0f) - f16;
                                            }
                                            float f30 = f22;
                                            float f31 = f19;
                                            int i21 = i3 + 1;
                                            int i22 = i3 + 2;
                                            int i23 = i3 + 3;
                                            path2.cubicTo(f30, f31, fArr2[i3], fArr2[i21], fArr2[i22], fArr2[i23]);
                                            f3 = fArr2[i3];
                                            float f32 = fArr2[i21];
                                            f4 = fArr2[i22];
                                            f16 = f32;
                                            f = fArr2[i23];
                                            i4 = i5;
                                            t11Var = t11Var3;
                                            c = c5;
                                        } else if (c5 == 'T') {
                                            i3 = i6;
                                            if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                                f22 = (f22 * 2.0f) - f15;
                                                f19 = (f19 * 2.0f) - f16;
                                            }
                                            float f33 = f19;
                                            float f34 = fArr2[i3];
                                            int i24 = i3 + 1;
                                            path2.quadTo(f22, f33, f34, fArr2[i24]);
                                            f16 = f33;
                                            f2 = fArr2[i3];
                                            f = fArr2[i24];
                                            i4 = i5;
                                            t11Var = t11Var3;
                                            f15 = f22;
                                            c = c5;
                                        } else if (c5 == 'l') {
                                            i3 = i6;
                                            int i25 = i3 + 1;
                                            path2.rLineTo(fArr2[i3], fArr2[i25]);
                                            f22 += fArr2[i3];
                                            f8 = fArr2[i25];
                                        } else if (c5 == c2) {
                                            i3 = i6;
                                            float f35 = fArr2[i3];
                                            f22 += f35;
                                            float f36 = fArr2[i3 + 1];
                                            f19 += f36;
                                            if (i3 > 0) {
                                                path2.rLineTo(f35, f36);
                                            } else {
                                                path2.rMoveTo(f35, f36);
                                                t11Var = t11Var3;
                                                f2 = f22;
                                                f20 = f2;
                                                f = f19;
                                                f21 = f;
                                                i4 = i5;
                                                c = c5;
                                            }
                                        } else if (c5 == 's') {
                                            if (c4 == 'c' || c4 == 's' || c4 == 'C' || c4 == 'S') {
                                                f9 = f19 - f16;
                                                f10 = f22 - f15;
                                            } else {
                                                f10 = 0.0f;
                                                f9 = 0.0f;
                                            }
                                            int i26 = i6 + 1;
                                            int i27 = i6 + 2;
                                            int i28 = i6 + 3;
                                            i3 = i6;
                                            path2.rCubicTo(f10, f9, fArr2[i6], fArr2[i26], fArr2[i27], fArr2[i28]);
                                            f5 = fArr2[i3] + f22;
                                            f6 = f19 + fArr2[i26];
                                            f22 += fArr2[i27];
                                            f7 = fArr2[i28];
                                        } else if (c5 != 't') {
                                            i3 = i6;
                                        } else {
                                            if (c4 == 'q' || c4 == 't' || c4 == 'Q' || c4 == 'T') {
                                                f11 = f22 - f15;
                                                f12 = f19 - f16;
                                            } else {
                                                f12 = 0.0f;
                                                f11 = 0.0f;
                                            }
                                            int i29 = i6 + 1;
                                            path2.rQuadTo(f11, f12, fArr2[i6], fArr2[i29]);
                                            float f37 = f11 + f22;
                                            float f38 = f19 + f12;
                                            float f39 = f22 + fArr2[i6];
                                            f19 += fArr2[i29];
                                            f16 = f38;
                                            i3 = i6;
                                            t11Var = t11Var3;
                                            f2 = f39;
                                            f15 = f37;
                                            f = f19;
                                            i4 = i5;
                                            c = c5;
                                        }
                                        i4 = i5;
                                        t11Var = t11Var3;
                                        c = c5;
                                    } else {
                                        i3 = i6;
                                        path2.rLineTo(0.0f, fArr2[i3]);
                                        f8 = fArr2[i3];
                                    }
                                    f19 += f8;
                                } else {
                                    i3 = i6;
                                    int i30 = i3 + 1;
                                    int i31 = i3 + 2;
                                    int i32 = i3 + 3;
                                    path2.rQuadTo(fArr2[i3], fArr2[i30], fArr2[i31], fArr2[i32]);
                                    f5 = fArr2[i3] + f22;
                                    f6 = f19 + fArr2[i30];
                                    f22 += fArr2[i31];
                                    f7 = fArr2[i32];
                                }
                                f19 += f7;
                                f15 = f5;
                                f16 = f6;
                            } else {
                                i3 = i6;
                                path2.rLineTo(fArr2[i3], 0.0f);
                                f22 += fArr2[i3];
                            }
                            t11Var = t11Var3;
                            f2 = f22;
                            f = f19;
                            i4 = i5;
                            c = c5;
                        } else {
                            i3 = i6;
                            int i33 = i3 + 5;
                            float f40 = fArr2[i33] + f22;
                            int i34 = i3 + 6;
                            float f41 = fArr2[i34] + f19;
                            float f42 = fArr2[i3];
                            float f43 = fArr2[i3 + 1];
                            float f44 = fArr2[i3 + 2];
                            if (fArr2[i3 + 3] != 0.0f) {
                                t11Var2 = t11Var3;
                                z = true;
                            } else {
                                t11Var2 = t11Var3;
                                z = false;
                            }
                            t11Var = t11Var2;
                            float f45 = f22;
                            c = c5;
                            float f46 = f19;
                            i4 = i5;
                            t11.a(path, f45, f46, f40, f41, f42, f43, f44, z, fArr2[i3 + 4] != 0.0f);
                            f2 = f45 + fArr2[i33];
                            f = f46 + fArr2[i34];
                            f15 = f2;
                            f16 = f;
                        }
                        f15 = f3;
                        f2 = f4;
                    } else {
                        i3 = i6;
                        t11Var = t11Var3;
                        c = c5;
                        f = f19;
                        i4 = i5;
                        path2.lineTo(fArr2[i3], f);
                        f2 = fArr2[i3];
                    }
                    c5 = c;
                    t11Var3 = t11Var;
                    i5 = i4;
                    c2 = 'm';
                    f22 = f2;
                    f19 = f;
                    c4 = c5;
                    i6 = i3 + i2;
                    path2 = path;
                }
            }
            fArr[0] = f22;
            fArr[1] = f19;
            fArr[2] = f15;
            fArr[3] = f16;
            fArr[4] = f20;
            fArr[5] = f21;
            c4 = t11Var3.a;
            i5++;
            path2 = path;
            c2 = 'm';
            c3 = 0;
        }
    }

    public static i50 r(XmlResourceParser xmlResourceParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        xmlResourceParser.require(2, null, "font-family");
        if (!xmlResourceParser.getName().equals("font-family")) {
            y(xmlResourceParser);
            return null;
        }
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), l71.FontFamily);
        String string = typedArrayObtainAttributes.getString(l71.FontFamily_fontProviderAuthority);
        String string2 = typedArrayObtainAttributes.getString(l71.FontFamily_fontProviderPackage);
        String string3 = typedArrayObtainAttributes.getString(l71.FontFamily_fontProviderQuery);
        String string4 = typedArrayObtainAttributes.getString(l71.FontFamily_fontProviderFallbackQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(l71.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(l71.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(l71.FontFamily_fontProviderFetchTimeout, 500);
        String string5 = typedArrayObtainAttributes.getString(l71.FontFamily_fontProviderSystemFontFamily);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlResourceParser.next() != 3) {
                y(xmlResourceParser);
            }
            List listU = u(resourceId, resources);
            return new l50(new b50(string, string2, string3, listU), string4 != null ? new b50(string, string2, string4, listU) : null, integer, integer2, string5);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlResourceParser.next() != 3) {
            if (xmlResourceParser.getEventType() == 2) {
                if (xmlResourceParser.getName().equals("font")) {
                    TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), l71.FontFamilyFont);
                    int i2 = typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(l71.FontFamilyFont_fontWeight) ? l71.FontFamilyFont_fontWeight : l71.FontFamilyFont_android_fontWeight, 400);
                    boolean z = 1 == typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(l71.FontFamilyFont_fontStyle) ? l71.FontFamilyFont_fontStyle : l71.FontFamilyFont_android_fontStyle, 0);
                    int i3 = typedArrayObtainAttributes2.hasValue(l71.FontFamilyFont_ttcIndex) ? l71.FontFamilyFont_ttcIndex : l71.FontFamilyFont_android_ttcIndex;
                    String string6 = typedArrayObtainAttributes2.getString(typedArrayObtainAttributes2.hasValue(l71.FontFamilyFont_fontVariationSettings) ? l71.FontFamilyFont_fontVariationSettings : l71.FontFamilyFont_android_fontVariationSettings);
                    int i4 = typedArrayObtainAttributes2.getInt(i3, 0);
                    int i5 = typedArrayObtainAttributes2.hasValue(l71.FontFamilyFont_font) ? l71.FontFamilyFont_font : l71.FontFamilyFont_android_font;
                    int resourceId2 = typedArrayObtainAttributes2.getResourceId(i5, 0);
                    String string7 = typedArrayObtainAttributes2.getString(i5);
                    typedArrayObtainAttributes2.recycle();
                    while (xmlResourceParser.next() != 3) {
                        y(xmlResourceParser);
                    }
                    arrayList.add(new k50(string7, i2, z, string6, i4, resourceId2));
                } else {
                    y(xmlResourceParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new j50((k50[]) arrayList.toArray(new k50[0]));
    }

    public static yo s(wo woVar, yo yoVar) {
        qg0.l(yoVar, "context");
        return az1.E(woVar, yoVar);
    }

    public static final Object t(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static List u(int i2, Resources resources) {
        if (i2 == 0) {
            return Collections.EMPTY_LIST;
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (typedArrayObtainTypedArray.getType(0) == 1) {
                for (int i3 = 0; i3 < typedArrayObtainTypedArray.length(); i3++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i2);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    public static void x(EditorInfo editorInfo, CharSequence charSequence, int i2, int i3) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i2);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i3);
    }

    public static void y(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlResourceParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    public abstract void A(wr0 wr0Var);

    public yr0 B(td1 td1Var) {
        z71.m(td1Var, "scheduler is null");
        return new yr0(this, td1Var, 1);
    }

    public abstract HashMap D();

    public abstract List c(String str, List list);

    public void z(wr0 wr0Var) {
        try {
            A(wr0Var);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            hg0.C(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public void v(boolean z) {
    }

    public void w(boolean z) {
    }
}
