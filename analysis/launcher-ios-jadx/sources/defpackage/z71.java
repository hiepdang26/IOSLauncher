package defpackage;

import android.app.KeyguardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Trace;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bumptech.glide.a;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbu;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzfel;
import com.google.android.gms.internal.ads.zzfui;
import com.google.android.gms.internal.ads.zzfvh;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class z71 {
    public static final int[] a = new int[0];
    public static final Object[] b = new Object[0];
    public static final Object c = new Object();
    public static final Object d = new Object();
    public static long e;
    public static Method f;

    public static final ExecutorService a(boolean z) {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new tl(z));
        qg0.k(executorServiceNewFixedThreadPool, "newFixedThreadPool(\n    …)),\n        factory\n    )");
        return executorServiceNewFixedThreadPool;
    }

    public static void b(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = az1.L(drawable).mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                drawable.setTintList(colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
                drawable.setTintList(ColorStateList.valueOf(colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static void c(String str) {
        if (str.length() > 127) {
            str = str.substring(0, 127);
        }
        Trace.beginSection(str);
    }

    public static final int d(int[] iArr, int i, int i2) {
        qg0.l(iArr, "array");
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else {
                if (i6 <= i2) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }

    public static final int e(long[] jArr, int i, long j) {
        qg0.l(jArr, "array");
        int i2 = i - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            long j2 = jArr[i4];
            if (j2 < j) {
                i3 = i4 + 1;
            } else {
                if (j2 <= j) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return ~i3;
    }

    public static d50 f(Context context) {
        ProviderInfo providerInfo;
        b50 b50Var;
        ApplicationInfo applicationInfo;
        iy xsVar = Build.VERSION.SDK_INT >= 28 ? new xs() : new iy();
        PackageManager packageManager = context.getPackageManager();
        qg0.j(packageManager, "Package manager required to locate emoji font provider");
        Iterator<ResolveInfo> it = packageManager.queryIntentContentProviders(new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                providerInfo = null;
                break;
            }
            providerInfo = it.next().providerInfo;
            if (providerInfo != null && (applicationInfo = providerInfo.applicationInfo) != null && (applicationInfo.flags & 1) == 1) {
                break;
            }
        }
        if (providerInfo == null) {
            b50Var = null;
        } else {
            try {
                String str = providerInfo.authority;
                String str2 = providerInfo.packageName;
                Signature[] signatureArrP = xsVar.p(packageManager, str2);
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signatureArrP) {
                    arrayList.add(signature.toByteArray());
                }
                b50Var = new b50(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList));
            } catch (PackageManager.NameNotFoundException unused) {
                b50Var = null;
            }
        }
        if (b50Var == null) {
            return null;
        }
        return new d50(new c50(context, b50Var));
    }

    public static x91 g(a aVar, List list, qg0 qg0Var) {
        ib1 teVar;
        ib1 hcVar;
        int i;
        Resources resources;
        String str;
        String str2;
        oc ocVar = aVar.g;
        o90 o90Var = aVar.i;
        Context applicationContext = o90Var.getApplicationContext();
        nx0 nx0Var = o90Var.h;
        x91 x91Var = new x91();
        ct ctVar = new ct();
        b00 b00Var = x91Var.g;
        synchronized (b00Var) {
            b00Var.a.add(ctVar);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 27) {
            x91Var.j(new t10());
        }
        Resources resources2 = applicationContext.getResources();
        ArrayList arrayListF = x91Var.f();
        cq0 cq0Var = aVar.j;
        xe xeVar = new xe(applicationContext, arrayListF, ocVar, cq0Var);
        yr1 yr1Var = new yr1(ocVar, new ta1(7));
        jw jwVar = new jw(x91Var.f(), resources2.getDisplayMetrics(), ocVar, cq0Var);
        if (i2 < 28 || !((Map) nx0Var.h).containsKey(m90.class)) {
            teVar = new te(jwVar, 0);
            hcVar = new hc(jwVar, cq0Var, 2);
        } else {
            hcVar = new ue(1);
            teVar = new ue(0);
        }
        Class<InputStream> cls = InputStream.class;
        if (i2 >= 28) {
            i = i2;
            resources = resources2;
            int i3 = 1;
            x91Var.d("Animation", InputStream.class, Drawable.class, new b5(new oz1(arrayListF, cq0Var, i3), i3));
            x91Var.d("Animation", ByteBuffer.class, Drawable.class, new b5(new oz1(arrayListF, cq0Var, 1), 0));
        } else {
            i = i2;
            resources = resources2;
        }
        kb1 kb1Var = new kb1(applicationContext);
        jc jcVar = new jc(cq0Var);
        t3 t3Var = new t3(1, false);
        ka0 ka0Var = new ka0(23);
        ContentResolver contentResolver = applicationContext.getContentResolver();
        x91Var.a(ByteBuffer.class, new ka0(11));
        x91Var.a(InputStream.class, new nx0(cq0Var, 24));
        x91Var.d("Bitmap", ByteBuffer.class, Bitmap.class, teVar);
        x91Var.d("Bitmap", InputStream.class, Bitmap.class, hcVar);
        String str3 = Build.FINGERPRINT;
        Class<ParcelFileDescriptor> cls2 = ParcelFileDescriptor.class;
        if ("robolectric".equals(str3)) {
            str = "Animation";
            str2 = str3;
        } else {
            str2 = str3;
            str = "Animation";
            x91Var.d("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new te(jwVar, 1));
        }
        x91Var.d("Bitmap", AssetFileDescriptor.class, Bitmap.class, new yr1(ocVar, new ta1(6)));
        x91Var.d("Bitmap", ParcelFileDescriptor.class, Bitmap.class, yr1Var);
        ka0 ka0Var2 = ka0.n;
        x91Var.c(Bitmap.class, Bitmap.class, ka0Var2);
        x91Var.d("Bitmap", Bitmap.class, Bitmap.class, new w20(1));
        x91Var.b(Bitmap.class, jcVar);
        Resources resources3 = resources;
        x91Var.d("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new hc(resources3, teVar));
        x91Var.d("BitmapDrawable", InputStream.class, BitmapDrawable.class, new hc(resources3, hcVar));
        x91Var.d("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new hc(resources3, yr1Var));
        x91Var.b(BitmapDrawable.class, new v21(ocVar, jcVar, 2));
        String str4 = str;
        x91Var.d(str4, InputStream.class, l80.class, new tj1(arrayListF, xeVar, cq0Var));
        x91Var.d(str4, ByteBuffer.class, l80.class, xeVar);
        x91Var.b(l80.class, new jl1(23));
        x91Var.c(wi1.class, wi1.class, ka0Var2);
        x91Var.d("Bitmap", wi1.class, Bitmap.class, new kc(ocVar));
        x91Var.d("legacy_append", Uri.class, Drawable.class, kb1Var);
        x91Var.d("legacy_append", Uri.class, Bitmap.class, new hc(kb1Var, ocVar, 1));
        x91Var.i(new ye(0));
        x91Var.c(File.class, ByteBuffer.class, new jl1(11));
        x91Var.c(File.class, InputStream.class, new y20(new jl1(19)));
        x91Var.d("legacy_append", File.class, File.class, new w20(0));
        x91Var.c(File.class, ParcelFileDescriptor.class, new y20(new ka0(19)));
        x91Var.c(File.class, File.class, ka0Var2);
        x91Var.i(new wf0(cq0Var));
        if (!"robolectric".equals(str2)) {
            x91Var.i(new ye(2));
        }
        f1 f1Var = new f1(applicationContext, 1);
        iv ivVar = new iv(applicationContext, 0);
        jv jvVar = new jv(applicationContext, 0);
        Class cls3 = Integer.TYPE;
        x91Var.c(cls3, InputStream.class, f1Var);
        x91Var.c(Integer.class, InputStream.class, f1Var);
        x91Var.c(cls3, AssetFileDescriptor.class, ivVar);
        x91Var.c(Integer.class, AssetFileDescriptor.class, ivVar);
        x91Var.c(cls3, Drawable.class, jvVar);
        x91Var.c(Integer.class, Drawable.class, jvVar);
        x91Var.c(Uri.class, InputStream.class, new jv(applicationContext, 2));
        x91Var.c(Uri.class, AssetFileDescriptor.class, new iv(applicationContext, 2));
        mc1 mc1Var = new mc1(resources3, 22);
        ic icVar = new ic(resources3);
        fz1 fz1Var = new fz1(resources3, 25);
        x91Var.c(Integer.class, Uri.class, mc1Var);
        x91Var.c(cls3, Uri.class, mc1Var);
        x91Var.c(Integer.class, AssetFileDescriptor.class, icVar);
        x91Var.c(cls3, AssetFileDescriptor.class, icVar);
        x91Var.c(Integer.class, InputStream.class, fz1Var);
        x91Var.c(cls3, InputStream.class, fz1Var);
        x91Var.c(String.class, InputStream.class, new fz1(10));
        x91Var.c(Uri.class, InputStream.class, new fz1(10));
        x91Var.c(String.class, InputStream.class, new m21());
        x91Var.c(String.class, ParcelFileDescriptor.class, new b21(4));
        x91Var.c(String.class, AssetFileDescriptor.class, new ta1(3));
        AssetManager assets = applicationContext.getAssets();
        int i4 = 5;
        x91Var.c(Uri.class, InputStream.class, new ow1(assets, i4));
        x91Var.c(Uri.class, AssetFileDescriptor.class, new nx0(applicationContext.getAssets(), i4));
        x91Var.c(Uri.class, InputStream.class, new jv(applicationContext, 1));
        x91Var.c(Uri.class, InputStream.class, new f1(applicationContext, 2));
        int i5 = i;
        if (i5 >= 29) {
            x91Var.c(Uri.class, InputStream.class, new b41(applicationContext, cls));
            x91Var.c(Uri.class, ParcelFileDescriptor.class, new b41(applicationContext, cls2));
        }
        x91Var.c(Uri.class, InputStream.class, new mc1(contentResolver, 26));
        x91Var.c(Uri.class, ParcelFileDescriptor.class, new sn1(contentResolver));
        x91Var.c(Uri.class, AssetFileDescriptor.class, new rn1(contentResolver));
        x91Var.c(Uri.class, InputStream.class, new b21(6));
        x91Var.c(URL.class, InputStream.class, new ta1(5));
        x91Var.c(Uri.class, File.class, new iv(applicationContext, 1));
        x91Var.c(x90.class, InputStream.class, new ow1(17));
        x91Var.c(byte[].class, ByteBuffer.class, new ka0(10));
        x91Var.c(byte[].class, InputStream.class, new iy());
        x91Var.c(Uri.class, Uri.class, ka0Var2);
        x91Var.c(Drawable.class, Drawable.class, ka0Var2);
        x91Var.d("legacy_append", Drawable.class, Drawable.class, new w20(2));
        x91Var.k(Bitmap.class, BitmapDrawable.class, new ic(resources3));
        x91Var.k(Bitmap.class, byte[].class, t3Var);
        x91Var.k(Drawable.class, byte[].class, new wb2(ocVar, t3Var, ka0Var, 11));
        x91Var.k(l80.class, byte[].class, ka0Var);
        if (i5 >= 23) {
            yr1 yr1Var2 = new yr1(ocVar, new b21(7));
            x91Var.d("legacy_append", ByteBuffer.class, Bitmap.class, yr1Var2);
            x91Var.d("legacy_append", ByteBuffer.class, BitmapDrawable.class, new hc(resources3, yr1Var2));
        }
        Iterator it = list.iterator();
        if (it.hasNext()) {
            throw uo.c(it);
        }
        if (qg0Var != null) {
            qg0Var.E();
        }
        return x91Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0090, code lost:
    
        if (r2.b(r11, r0) == r1) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0076 A[Catch: all -> 0x0036, TryCatch #1 {all -> 0x0036, blocks: (B:13:0x002f, B:24:0x005a, B:28:0x006e, B:30:0x0076, B:32:0x007c, B:34:0x0082, B:37:0x0093, B:39:0x009b, B:40:0x00a2, B:41:0x00a4, B:42:0x00a5, B:43:0x00ac, B:20:0x0049, B:23:0x0050), top: B:60:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0090 -> B:14:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object h(defpackage.c40 r8, defpackage.u31 r9, boolean r10, defpackage.go r11) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z71.h(c40, u31, boolean, go):java.lang.Object");
    }

    public static String i(Context context, byte[] bArr) {
        String packageName = context.getPackageName();
        if (bArr.length == 0 || packageName == null || packageName.isEmpty()) {
            return "";
        }
        byte[] bytes = packageName.getBytes(StandardCharsets.UTF_8);
        byte[] bArr2 = new byte[bArr.length];
        int length = bytes.length;
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = (byte) (bArr[i] ^ bytes[i % length]);
        }
        return new String(bArr2, StandardCharsets.UTF_8);
    }

    public static boolean j() {
        if (Build.VERSION.SDK_INT >= 29) {
            return mo1.a();
        }
        try {
            if (f == null) {
                e = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f.invoke(null, Long.valueOf(e))).booleanValue();
        } catch (Exception e2) {
            if (!(e2 instanceof InvocationTargetException)) {
                return false;
            }
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static ya1 k(Context context) {
        ya1 ya1Var = new ya1(new ov(new oz1(context.getApplicationContext())), new q11(new jl1(24)));
        hf hfVar = ya1Var.i;
        if (hfVar != null) {
            hfVar.k = true;
            hfVar.interrupt();
        }
        for (cx0 cx0Var : ya1Var.h) {
            if (cx0Var != null) {
                cx0Var.k = true;
                cx0Var.interrupt();
            }
        }
        hf hfVar2 = new hf(ya1Var.c, ya1Var.d, ya1Var.e, ya1Var.g);
        ya1Var.i = hfVar2;
        hfVar2.start();
        for (int i = 0; i < ya1Var.h.length; i++) {
            cx0 cx0Var2 = new cx0(ya1Var.d, ya1Var.f, ya1Var.e, ya1Var.g);
            ya1Var.h[i] = cx0Var2;
            cx0Var2.start();
        }
        return ya1Var;
    }

    public static void l(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor());
        Drawable drawableMutate = az1.L(drawable).mutate();
        drawableMutate.setTintList(ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    public static void m(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static TypedValue n(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static int o(Context context, String str, int i) {
        TypedValue typedValueN = n(context, i);
        if (typedValueN != null) {
            return typedValueN.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    public static void p(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        WeakHashMap weakHashMap = qs1.a;
        boolean zHasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z = onLongClickListener != null;
        boolean z2 = zHasOnClickListeners || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        checkableImageButton.setLongClickable(z);
        checkableImageButton.setImportantForAccessibility(z2 ? 1 : 2);
    }

    public static WindowManager.LayoutParams q() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
        layoutParams.flags = ((Integer) n42.d.c.zza(zzbbw.zzhj)).intValue();
        layoutParams.type = 2;
        layoutParams.gravity = 8388659;
        return layoutParams;
    }

    public static JSONObject r(String str, Context context, Point point, Point point2) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (Exception unused) {
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                int i = point2.x;
                x32 x32Var = x32.f;
                ka2 ka2Var = x32Var.a;
                ka2 ka2Var2 = x32Var.a;
                jSONObject3.put("x", ka2Var.e(context, i));
                jSONObject3.put("y", ka2Var2.e(context, point2.y));
                jSONObject3.put("start_x", ka2Var2.e(context, point.x));
                jSONObject3.put("start_y", ka2Var2.e(context, point.y));
                jSONObject2 = jSONObject3;
            } catch (JSONException unused2) {
                k92.f();
            }
            jSONObject.put("click_point", jSONObject2);
            jSONObject.put("asset_id", str);
            return jSONObject;
        } catch (Exception unused3) {
            jSONObject2 = jSONObject;
            k92.f();
            return jSONObject2;
        }
    }

    public static JSONObject s(Context context, Map map, Map map2, View view, ImageView.ScaleType scaleType) {
        String str;
        int[] iArr;
        JSONObject jSONObject;
        String str2 = "ad_view";
        JSONObject jSONObject2 = new JSONObject();
        if (map != null && view != null) {
            int i = 2;
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                View view2 = (View) ((WeakReference) entry.getValue()).get();
                if (view2 != null) {
                    int[] iArr3 = new int[i];
                    view2.getLocationOnScreen(iArr3);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    Iterator it2 = it;
                    try {
                        int measuredWidth = view2.getMeasuredWidth();
                        iArr = iArr2;
                        try {
                            x32 x32Var = x32.f;
                            ka2 ka2Var = x32Var.a;
                            ka2 ka2Var2 = x32Var.a;
                            jSONObject4.put("width", ka2Var.e(context, measuredWidth));
                            jSONObject4.put("height", ka2Var2.e(context, view2.getMeasuredHeight()));
                            jSONObject4.put("x", ka2Var2.e(context, iArr3[0] - iArr[0]));
                            jSONObject4.put("y", ka2Var2.e(context, iArr3[1] - iArr[1]));
                            jSONObject4.put("relative_to", str2);
                            jSONObject3.put("frame", jSONObject4);
                            Rect rect = new Rect();
                            if (view2.getLocalVisibleRect(rect)) {
                                jSONObject = y(context, rect);
                            } else {
                                jSONObject = new JSONObject();
                                jSONObject.put("width", 0);
                                jSONObject.put("height", 0);
                                jSONObject.put("x", ka2Var2.e(context, iArr3[0] - iArr[0]));
                                jSONObject.put("y", ka2Var2.e(context, iArr3[1] - iArr[1]));
                                jSONObject.put("relative_to", str2);
                            }
                            jSONObject3.put("visible_bounds", jSONObject);
                            if (((String) entry.getKey()).equals("3010")) {
                                zzbbn zzbbnVar = zzbbw.zzhe;
                                n42 n42Var = n42.d;
                                zzbbu zzbbuVar = n42Var.c;
                                zzbbu zzbbuVar2 = n42Var.c;
                                if (((Boolean) zzbbuVar.zza(zzbbnVar)).booleanValue()) {
                                    jSONObject3.put("mediaview_graphics_matrix", view2.getMatrix().toShortString());
                                }
                                if (((Boolean) zzbbuVar2.zza(zzbbw.zzhf)).booleanValue()) {
                                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                                    jSONObject3.put("view_width_layout_type", z(layoutParams.width) - 1);
                                    jSONObject3.put("view_height_layout_type", z(layoutParams.height) - 1);
                                }
                                if (((Boolean) zzbbuVar2.zza(zzbbw.zzhg)).booleanValue()) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(Integer.valueOf(view2.getId()));
                                    for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                        arrayList.add(Integer.valueOf(((View) parent).getId()));
                                    }
                                    jSONObject3.put("view_path", TextUtils.join("/", arrayList));
                                }
                                if (scaleType != null) {
                                    jSONObject3.put("mediaview_scale_type", scaleType.ordinal());
                                }
                            }
                            if (view2 instanceof TextView) {
                                TextView textView = (TextView) view2;
                                jSONObject3.put("text_color", textView.getCurrentTextColor());
                                str = str2;
                                try {
                                    jSONObject3.put("font_size", textView.getTextSize());
                                    jSONObject3.put("text", textView.getText());
                                } catch (JSONException unused) {
                                    k92.h("Unable to get asset views information");
                                }
                            } else {
                                str = str2;
                            }
                            jSONObject3.put("is_clickable", map2 != null && map2.containsKey(entry.getKey()) && view2.isClickable());
                            jSONObject2.put((String) entry.getKey(), jSONObject3);
                        } catch (JSONException unused2) {
                            str = str2;
                        }
                    } catch (JSONException unused3) {
                        str = str2;
                        iArr = iArr2;
                    }
                    it = it2;
                    str2 = str;
                    iArr2 = iArr;
                    i = 2;
                }
            }
        }
        return jSONObject2;
    }

    public static JSONObject t(Context context, View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                cd2 cd2Var = hd2.B.c;
                jSONObject.put("can_show_on_lock_screen", cd2.C(view));
                boolean z = false;
                if (context != null) {
                    Object systemService = context.getSystemService("keyguard");
                    KeyguardManager keyguardManager = (systemService == null || !(systemService instanceof KeyguardManager)) ? null : (KeyguardManager) systemService;
                    if (keyguardManager != null && keyguardManager.isKeyguardLocked()) {
                        z = true;
                    }
                }
                jSONObject.put("is_keyguard_locked", z);
                return jSONObject;
            } catch (JSONException unused) {
                k92.h("Unable to get lock screen information");
            }
        }
        return jSONObject;
    }

    public static JSONObject u(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                if (((Boolean) n42.d.c.zza(zzbbw.zzhd)).booleanValue()) {
                    cd2 cd2Var = hd2.B.c;
                    ViewParent parent = view.getParent();
                    while (parent != null && !(parent instanceof ScrollView)) {
                        parent = parent.getParent();
                    }
                    jSONObject.put("contained_in_scroll_view", parent != null);
                    return jSONObject;
                }
                cd2 cd2Var2 = hd2.B.c;
                ViewParent parent2 = view.getParent();
                while (parent2 != null && !(parent2 instanceof AdapterView)) {
                    parent2 = parent2.getParent();
                }
                if ((parent2 == null ? -1 : ((AdapterView) parent2).getPositionForView(view)) == -1) {
                    z = false;
                }
                jSONObject.put("contained_in_scroll_view", z);
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0140 A[Catch: JSONException -> 0x0145, TRY_LEAVE, TryCatch #1 {JSONException -> 0x0145, blocks: (B:29:0x010c, B:46:0x0137, B:47:0x013b, B:48:0x0140), top: B:60:0x010c }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x015a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject v(android.content.Context r17, android.view.View r18) {
        /*
            Method dump skipped, instruction units count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z71.v(android.content.Context, android.view.View):org.json.JSONObject");
    }

    public static boolean w(Context context, zzfel zzfelVar) {
        if (!zzfelVar.zzN) {
            return false;
        }
        zzbbn zzbbnVar = zzbbw.zzhh;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            return ((Boolean) n42Var.c.zza(zzbbw.zzhk)).booleanValue();
        }
        String str = (String) n42Var.c.zza(zzbbw.zzhi);
        if (!str.isEmpty() && context != null) {
            String packageName = context.getPackageName();
            Iterator it = zzfvh.zzb(zzfui.zzc(';')).zzc(str).iterator();
            while (it.hasNext()) {
                if (((String) it.next()).equals(packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean x(int i) {
        zzbbn zzbbnVar = zzbbw.zzdd;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue()) {
            return ((Boolean) n42Var.c.zza(zzbbw.zzde)).booleanValue() || i <= 15299999;
        }
        return true;
    }

    public static JSONObject y(Context context, Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        int i = rect.right - rect.left;
        x32 x32Var = x32.f;
        jSONObject.put("width", x32Var.a.e(context, i));
        int i2 = rect.bottom - rect.top;
        ka2 ka2Var = x32Var.a;
        jSONObject.put("height", ka2Var.e(context, i2));
        jSONObject.put("x", ka2Var.e(context, rect.left));
        jSONObject.put("y", ka2Var.e(context, rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    public static int z(int i) {
        if (i != -2) {
            return i != -1 ? 2 : 3;
        }
        return 4;
    }
}
