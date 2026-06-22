package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.renderscript.Toolkit;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class ar1 {
    public static final Rect a = new Rect();
    public static final Canvas b;
    public static final Pattern c;
    public static final boolean d;
    public static final boolean e;
    public static final boolean f;
    public static final boolean g;
    public static final boolean h;
    public static final boolean i;
    public static final boolean j;
    public static final boolean k;
    public static final boolean l;
    public static final boolean m;
    public static final boolean n;
    public static final boolean o;
    public static final boolean p;
    public static final ThreadPoolExecutor q;

    static {
        Canvas canvas = new Canvas();
        b = canvas;
        c = Pattern.compile("^[\\s|\\p{javaSpaceChar}]*(.*)[\\s|\\p{javaSpaceChar}]*$");
        canvas.setDrawFilter(new PaintFlagsDrawFilter(4, 2));
        int i2 = Build.VERSION.SDK_INT;
        d = i2 >= 26;
        e = i2 >= 25;
        f = i2 >= 24;
        g = i2 >= 30;
        h = i2 >= 31;
        i = i2 >= 23;
        j = i2 >= 33;
        k = i2 >= 34;
        l = i2 >= 22;
        m = true;
        n = true;
        o = true;
        p = true;
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        q = new ThreadPoolExecutor(iAvailableProcessors + 1, (iAvailableProcessors * 2) + 1, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static void A(ViewGroup viewGroup, int i2) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt instanceof ViewGroup) {
                A((ViewGroup) childAt, i2);
            } else if ((childAt instanceof TextViewCustomFont) && childAt.getId() != v51.action_back) {
                ((TextViewCustomFont) childAt).setTextColor(i2);
            }
        }
    }

    public static String B(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return c.matcher(charSequence).replaceAll("$1");
    }

    public static Bitmap a(Bitmap bitmap, float f2) {
        Objects.toString(bitmap);
        if (bitmap == null) {
            return null;
        }
        try {
            try {
                return Toolkit.a.a((int) 6.0f, Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * f2), Math.round(bitmap.getHeight() * f2), false));
            } catch (Throwable unused) {
                return bf1.y((int) 6.0f, Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * f2), Math.round(f2 * bitmap.getHeight()), true));
            }
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public static Bitmap b(Drawable drawable, jq1 jq1Var, Context context) {
        Bitmap bitmapH = h(drawable, context);
        if (!m || jq1Var == null || jq1.b().equals(jq1Var)) {
            return bitmapH;
        }
        Drawable userBadgedIcon = context.getPackageManager().getUserBadgedIcon(new zq1(null, bitmapH), jq1Var.a);
        return userBadgedIcon instanceof BitmapDrawable ? ((BitmapDrawable) userBadgedIcon).getBitmap() : h(userBadgedIcon, context);
    }

    public static Bitmap c(ViewGroup viewGroup) {
        try {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                Bitmap[] bitmapArr = {null};
                new Handler(Looper.getMainLooper()).post(new bd(bitmapArr, viewGroup, countDownLatch, 10));
                try {
                    countDownLatch.await();
                    Objects.toString(bitmapArr[0]);
                    return bitmapArr[0];
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            } else if (viewGroup.getWindowToken() != null && viewGroup.getVisibility() == 0) {
                int width = viewGroup.getWidth();
                int height = viewGroup.getHeight();
                if (width > 0 && height > 0) {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    Drawable background = viewGroup.getBackground();
                    if (background != null) {
                        background.setBounds(0, 0, width, height);
                        background.draw(canvas);
                    }
                    viewGroup.draw(canvas);
                    return bitmapCreateBitmap;
                }
            }
            return null;
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public static String d(String str, AbstractCollection abstractCollection) {
        Locale locale = Locale.ENGLISH;
        return str + " IN (" + TextUtils.join(", ", abstractCollection) + ")";
    }

    public static Bitmap e(Context context, Cursor cursor, int i2) {
        byte[] blob = cursor.getBlob(i2);
        try {
            return f(context, BitmapFactory.decodeByteArray(blob, 0, blob.length));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Bitmap f(Context context, Bitmap bitmap) {
        int i2 = jk0.a().e.h;
        return (i2 == bitmap.getWidth() && i2 == bitmap.getHeight()) ? bitmap : h(new BitmapDrawable(context.getResources(), bitmap), context);
    }

    public static Bitmap g(Context context, String str, String str2) {
        try {
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(str);
            if (resourcesForApplication != null) {
                return h(resourcesForApplication.getDrawableForDensity(resourcesForApplication.getIdentifier(str2, null, null), jk0.a().e.i), context);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap h(android.graphics.drawable.Drawable r8, android.content.Context r9) {
        /*
            android.graphics.Canvas r0 = defpackage.ar1.b
            monitor-enter(r0)
            jk0 r1 = defpackage.jk0.a()     // Catch: java.lang.Throwable -> L19
            xg0 r1 = r1.e     // Catch: java.lang.Throwable -> L19
            int r1 = r1.h     // Catch: java.lang.Throwable -> L19
            boolean r2 = r8 instanceof android.graphics.drawable.PaintDrawable     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L1c
            r9 = r8
            android.graphics.drawable.PaintDrawable r9 = (android.graphics.drawable.PaintDrawable) r9     // Catch: java.lang.Throwable -> L19
            r9.setIntrinsicWidth(r1)     // Catch: java.lang.Throwable -> L19
            r9.setIntrinsicHeight(r1)     // Catch: java.lang.Throwable -> L19
            goto L3a
        L19:
            r8 = move-exception
            goto L95
        L1c:
            boolean r2 = r8 instanceof android.graphics.drawable.BitmapDrawable     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L3a
            r2 = r8
            android.graphics.drawable.BitmapDrawable r2 = (android.graphics.drawable.BitmapDrawable) r2     // Catch: java.lang.Throwable -> L19
            android.graphics.Bitmap r3 = r2.getBitmap()     // Catch: java.lang.Throwable -> L19
            if (r3 == 0) goto L3a
            int r3 = r3.getDensity()     // Catch: java.lang.Throwable -> L19
            if (r3 != 0) goto L3a
            android.content.res.Resources r9 = r9.getResources()     // Catch: java.lang.Throwable -> L19
            android.util.DisplayMetrics r9 = r9.getDisplayMetrics()     // Catch: java.lang.Throwable -> L19
            r2.setTargetDensity(r9)     // Catch: java.lang.Throwable -> L19
        L3a:
            int r9 = r8.getIntrinsicWidth()     // Catch: java.lang.Throwable -> L19
            int r2 = r8.getIntrinsicHeight()     // Catch: java.lang.Throwable -> L19
            if (r9 <= 0) goto L59
            if (r2 <= 0) goto L59
            float r3 = (float) r9     // Catch: java.lang.Throwable -> L19
            float r4 = (float) r2     // Catch: java.lang.Throwable -> L19
            float r3 = r3 / r4
            if (r9 <= r2) goto L51
            float r9 = (float) r1     // Catch: java.lang.Throwable -> L19
            float r9 = r9 / r3
            int r9 = (int) r9     // Catch: java.lang.Throwable -> L19
            r2 = r9
            r9 = r1
            goto L5b
        L51:
            if (r2 <= r9) goto L59
            float r9 = (float) r1     // Catch: java.lang.Throwable -> L19
            float r9 = r9 * r3
            int r9 = (int) r9     // Catch: java.lang.Throwable -> L19
            r2 = r1
            goto L5b
        L59:
            r9 = r1
            r2 = r9
        L5b:
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888     // Catch: java.lang.Throwable -> L19
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r1, r1, r3)     // Catch: java.lang.Throwable -> L19
            r0.setBitmap(r3)     // Catch: java.lang.Throwable -> L19
            int r4 = r1 - r9
            int r4 = r4 / 2
            int r5 = r1 - r2
            int r5 = r5 / 2
            android.graphics.Rect r6 = defpackage.ar1.a     // Catch: java.lang.Throwable -> L19
            android.graphics.Rect r7 = r8.getBounds()     // Catch: java.lang.Throwable -> L19
            r6.set(r7)     // Catch: java.lang.Throwable -> L19
            int r9 = r9 + r4
            int r2 = r2 + r5
            r8.setBounds(r4, r5, r9, r2)     // Catch: java.lang.Throwable -> L19
            r0.save()     // Catch: java.lang.Throwable -> L19
            float r9 = (float) r1     // Catch: java.lang.Throwable -> L19
            r1 = 1073741824(0x40000000, float:2.0)
            float r9 = r9 / r1
            r1 = 1065353216(0x3f800000, float:1.0)
            r0.scale(r1, r1, r9, r9)     // Catch: java.lang.Throwable -> L19
            r8.draw(r0)     // Catch: java.lang.Throwable -> L19
            r0.restore()     // Catch: java.lang.Throwable -> L19
            r8.setBounds(r6)     // Catch: java.lang.Throwable -> L19
            r8 = 0
            r0.setBitmap(r8)     // Catch: java.lang.Throwable -> L19
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
            return r3
        L95:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ar1.h(android.graphics.drawable.Drawable, android.content.Context):android.graphics.Bitmap");
    }

    public static Bitmap i(Context context, int i2, int i3, int i4, float f2) {
        Bitmap bitmapDecodeResource;
        try {
            bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), i2);
        } catch (Throwable unused) {
            bitmapDecodeResource = null;
        }
        try {
            try {
                return j(bitmapDecodeResource, i3, i4, f2);
            } catch (Throwable unused2) {
                return BitmapFactory.decodeResource(context.getResources(), i2);
            }
        } catch (Throwable unused3) {
            return null;
        }
    }

    public static Bitmap j(Bitmap bitmap, int i2, int i3, float f2) {
        try {
            if (i2 < bitmap.getWidth() || i3 < bitmap.getHeight()) {
                bitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, true);
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Rect rect = new Rect(0, 0, i2, i3);
            RectF rectF = new RectF(rect);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(-1);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawARGB(0, 0, 0, 0);
            canvas.drawRoundRect(rectF, f2, f2, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return bitmap;
        }
    }

    public static Bitmap k(Drawable drawable) {
        Objects.toString(drawable);
        try {
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                if (bitmapDrawable.getBitmap() != null) {
                    return bitmapDrawable.getBitmap();
                }
            }
            Bitmap bitmapCreateBitmap = (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) ? Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public static int l(Bitmap bitmap) {
        char c2;
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int iSqrt = (int) Math.sqrt((height * width) / 20);
        if (iSqrt < 1) {
            iSqrt = 1;
        }
        float[] fArr = new float[3];
        float[] fArr2 = new float[360];
        char c3 = 0;
        int i2 = -1;
        int i3 = 0;
        float f2 = -1.0f;
        while (true) {
            c2 = 2;
            if (i3 >= height) {
                break;
            }
            for (int i4 = 0; i4 < width; i4 += iSqrt) {
                int pixel = bitmap.getPixel(i4, i3);
                if (((pixel >> 24) & 255) >= 128) {
                    Color.colorToHSV(pixel | (-16777216), fArr);
                    int i5 = (int) fArr[0];
                    if (i5 >= 0 && i5 < 360) {
                        float f3 = fArr2[i5] + (fArr[1] * fArr[2]);
                        fArr2[i5] = f3;
                        if (f3 > f2) {
                            i2 = i5;
                            f2 = f3;
                        }
                    }
                }
            }
            i3 += iSqrt;
        }
        SparseArray sparseArray = new SparseArray();
        int i6 = 0;
        int i7 = -16777216;
        float f4 = -1.0f;
        while (i6 < height) {
            int i8 = 0;
            while (i8 < width) {
                int pixel2 = bitmap.getPixel(i8, i6) | (-16777216);
                Color.colorToHSV(pixel2, fArr);
                if (((int) fArr[c3]) == i2) {
                    float f5 = fArr[1];
                    float f6 = fArr[c2];
                    int i9 = ((int) (f5 * 100.0f)) + ((int) (f6 * 10000.0f));
                    float fFloatValue = f5 * f6;
                    Float f7 = (Float) sparseArray.get(i9);
                    if (f7 != null) {
                        fFloatValue += f7.floatValue();
                    }
                    sparseArray.put(i9, Float.valueOf(fFloatValue));
                    if (fFloatValue > f4) {
                        i7 = pixel2;
                        f4 = fFloatValue;
                    }
                }
                i8 += iSqrt;
                c3 = 0;
                c2 = 2;
            }
            i6 += iSqrt;
            c3 = 0;
            c2 = 2;
        }
        return i7;
    }

    public static Pair m(PackageManager packageManager, String str) {
        Iterator<ResolveInfo> it = packageManager.queryBroadcastReceivers(new Intent(str), 0).iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && (activityInfo.applicationInfo.flags & 1) != 0) {
                String str2 = activityInfo.packageName;
                try {
                    return Pair.create(str2, packageManager.getResourcesForApplication(str2));
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
        }
        return null;
    }

    public static byte[] n(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmap.getHeight() * bitmap.getWidth() * 4);
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            return null;
        }
    }

    public static String o(String str) {
        if (TextUtils.isEmpty(str) || !str.equals("com.luutinhit.launcherios")) {
            return null;
        }
        return "c2b4356399bad096b3c343b9b5f99a42";
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap p(android.content.Context r18, android.graphics.Bitmap r19) {
        /*
            Method dump skipped, instruction units count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ar1.p(android.content.Context, android.graphics.Bitmap):android.graphics.Bitmap");
    }

    public static SharedPreferences q(Context context) {
        return context.getSharedPreferences("com.luutinhit.launcher6.prefs", 0);
    }

    public static boolean r(Context context) {
        boolean z = false;
        if (f) {
            int i2 = DisplayMetrics.DENSITY_DEVICE_STABLE;
            Resources resources = context.getResources();
            if ((resources.getConfiguration().smallestScreenWidthDp * resources.getDisplayMetrics().densityDpi) / i2 >= 600) {
                z = true;
            }
        }
        return q(context).getBoolean("pref_allowRotation", z);
    }

    public static boolean s(int i2) {
        Color.alpha(i2);
        return ((-16777216) & i2) != 0 && Color.alpha(i2) > 200;
    }

    public static boolean t() {
        try {
            return Build.MANUFACTURER.toLowerCase().contains("huawei");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean u(Intent intent) {
        if (intent != null && "android.intent.action.MAIN".equals(intent.getAction()) && intent.getComponent() != null && intent.getCategories() != null && intent.getCategories().size() == 1 && intent.hasCategory("android.intent.category.LAUNCHER") && TextUtils.isEmpty(intent.getDataString())) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                return true;
            }
            Set<String> setKeySet = extras.keySet();
            if (setKeySet.size() == 1 && setKeySet.contains("profile")) {
                return true;
            }
        }
        return false;
    }

    public static boolean v(Resources resources) {
        return o && resources.getConfiguration().getLayoutDirection() == 1;
    }

    public static boolean w(Context context, Intent intent) {
        String packageName;
        ApplicationInfo applicationInfo;
        ActivityInfo activityInfo;
        PackageManager packageManager = context.getPackageManager();
        ComponentName component = intent.getComponent();
        if (component == null) {
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST);
            packageName = (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) ? null : activityInfo.packageName;
        } else {
            packageName = component.getPackageName();
        }
        if (packageName != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                    if ((applicationInfo.flags & 1) != 0) {
                        return true;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static boolean x() {
        try {
            return Build.MANUFACTURER.toLowerCase().contains("vivo");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean y(ViewGroup viewGroup, float f2, float f3, float f4) {
        float f5 = -f4;
        return f2 >= f5 && f3 >= f5 && f2 < ((float) viewGroup.getWidth()) + f4 && f3 < ((float) viewGroup.getHeight()) + f4;
    }

    public static void z(Context context) {
        new zp0(rl0.w.getLooper()).execute(new fl0(context, 15));
    }
}
