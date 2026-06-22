package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.LauncherApps;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.motion.widget.Debug;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzfsb;
import com.google.android.gms.internal.ads.zzfsc;
import com.google.android.gms.internal.ads.zzfui;
import com.google.android.gms.internal.ads.zzfvh;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class qg0 {
    public static qg0 b;
    public static Field e;
    public static boolean f;
    public static final Object[] a = new Object[0];
    public static final Object c = new Object();
    public static final byte[] d = {2, 27, 25, 92, 5, 23, 0, 0, 12, 78, 30, 12, 23, 26, 76, 0, 42, 62, 12, 27, 12, 6, 0, 0, 29, 88, 101, 12, 90, 24, 7, 28, 22, 28, 26, 13, 73, 2, 75, 15, 83, 85, 15, 60, 60, 0, 10, 42, 0, 28, 17, 11, 86, 36, 26, 20, 7, 13, 0, 0, 15, 73, 2, 75, 15, 83, 85, 24, 60, 60, 0, 10, 42, 0, 28, 17, 11, 86, 36, 102, 3, 26, 29, 13, 78, 5, 8, 29, 64, 68, 72, 85, 21, 105, 72, 69, 82, 73, 25, 44, 55, 10, 21, 109, 3, 26, 7, 16, 73, 83, 72, 8, 43, 122, 9, 25, 54, 1, 12, 26, 1, 73, 99, 79, 83, 67, 79, 10, 66, 51, 37, 26, 7, 0, 26, 1, 6, 26, 14, 81, 65, 20, 49, 51, 7, 22, 27, 29, 6, 28, 13, 84, 103, 83};

    public static void B(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + cls.getDeclaredConstructor(null).newInstance(null));
            } catch (IllegalAccessException e2) {
                N(cls, e2);
                throw null;
            } catch (InstantiationException e3) {
                N(cls, e3);
                throw null;
            } catch (NoSuchMethodException e4) {
                N(cls, e4);
                throw null;
            } catch (InvocationTargetException e5) {
                N(cls, e5);
                throw null;
            }
        } catch (ClassNotFoundException e6) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e6);
        }
    }

    public static PorterDuff.Mode C(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static boolean D(String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static void G(RuntimeException runtimeException, String str) {
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
    }

    public static void H(TextView textView, int i) {
        f(i);
        if (Build.VERSION.SDK_INT >= 28) {
            eu.n(textView, i);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), i + i2, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void I(hm hmVar, View view, float[] fArr) {
        Class<?> cls = view.getClass();
        String str = "set" + hmVar.b;
        try {
            int iV = uo.v(hmVar.c);
            Class<?> cls2 = Integer.TYPE;
            Class<?> cls3 = Float.TYPE;
            switch (iV) {
                case 0:
                    cls.getMethod(str, cls2).invoke(view, Integer.valueOf((int) fArr[0]));
                    return;
                case 1:
                    cls.getMethod(str, cls3).invoke(view, Float.valueOf(fArr[0]));
                    return;
                case 2:
                    cls.getMethod(str, cls2).invoke(view, Integer.valueOf((o((int) (fArr[3] * 255.0f)) << 24) | (o((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (o((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | o((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f))));
                    return;
                case 3:
                    Method method = cls.getMethod(str, Drawable.class);
                    int iO = (o((int) (fArr[3] * 255.0f)) << 24) | (o((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (o((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | o((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(iO);
                    method.invoke(view, colorDrawable);
                    return;
                case 4:
                    throw new RuntimeException("unable to interpolate strings " + hmVar.b);
                case 5:
                    cls.getMethod(str, Boolean.TYPE).invoke(view, Boolean.valueOf(fArr[0] > 0.5f));
                    return;
                case 6:
                    cls.getMethod(str, cls3).invoke(view, Float.valueOf(fArr[0]));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException unused) {
            Debug.getName(view);
        } catch (NoSuchMethodException unused2) {
            Debug.getName(view);
        } catch (InvocationTargetException unused3) {
            Debug.getName(view);
        }
    }

    public static void J(TextView textView, int i) {
        f(i);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    public static void K(TextView textView, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i);
        } else {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }

    public static void N(Class cls, ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, reflectiveOperationException);
    }

    public static void O(String str) {
        wk wkVar = new wk(uo.t("lateinit property ", str, " has not been initialized"), 6);
        G(wkVar, qg0.class.getName());
        throw wkVar;
    }

    public static final Object[] P(Collection collection) {
        int size = collection.size();
        Object[] objArr = a;
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArrCopyOf = new Object[size];
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    objArrCopyOf[i] = it.next();
                    if (i2 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i3 = ((i2 * 3) + 1) >>> 1;
                        if (i3 <= i2) {
                            i3 = 2147483645;
                            if (i2 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                    } else if (!it.hasNext()) {
                        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i2);
                        k(objArrCopyOf2, "copyOf(...)");
                        return objArrCopyOf2;
                    }
                    i = i2;
                }
            }
        }
        return objArr;
    }

    public static final Object[] Q(Collection collection, Object[] objArr) {
        Object[] objArrCopyOf;
        int size = collection.size();
        int i = 0;
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                if (size <= objArr.length) {
                    objArrCopyOf = objArr;
                } else {
                    Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                    i(objNewInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                    objArrCopyOf = (Object[]) objNewInstance;
                }
                while (true) {
                    int i2 = i + 1;
                    objArrCopyOf[i] = it.next();
                    if (i2 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i3 = ((i2 * 3) + 1) >>> 1;
                        if (i3 <= i2) {
                            i3 = 2147483645;
                            if (i2 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                    } else if (!it.hasNext()) {
                        if (objArrCopyOf == objArr) {
                            objArr[i2] = null;
                            return objArr;
                        }
                        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i2);
                        k(objArrCopyOf2, "copyOf(...)");
                        return objArrCopyOf2;
                    }
                    i = i2;
                }
            } else if (objArr.length > 0) {
                objArr[0] = null;
            }
        } else if (objArr.length > 0) {
            objArr[0] = null;
            return objArr;
        }
        return objArr;
    }

    public static ActionMode.Callback R(ActionMode.Callback callback) {
        return (!(callback instanceof in1) || Build.VERSION.SDK_INT < 26) ? callback : ((in1) callback).a;
    }

    public static ActionMode.Callback S(ActionMode.Callback callback, TextView textView) {
        int i = Build.VERSION.SDK_INT;
        return (i < 26 || i > 27 || (callback instanceof in1) || callback == null) ? callback : new in1(callback, textView);
    }

    public static Bundle T(Context context, String str) {
        JSONArray jSONArray;
        Object obj;
        SharedPreferences sharedPreferences;
        String str2;
        if (TextUtils.isEmpty(str)) {
            jSONArray = null;
        } else {
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException unused) {
                k92.j(3);
                jSONArray = null;
            }
        }
        if (jSONArray == null) {
            return Bundle.EMPTY;
        }
        Bundle bundle = new Bundle();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            String strOptString = jSONObjectOptJSONObject.optString("bk");
            String strOptString2 = jSONObjectOptJSONObject.optString("sk");
            int iOptInt = jSONObjectOptJSONObject.optInt("type", -1);
            int i2 = iOptInt != 0 ? iOptInt != 1 ? iOptInt != 2 ? 0 : 3 : 2 : 1;
            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && i2 != 0) {
                List listZze = zzfvh.zzb(zzfui.zzc('/')).zze(strOptString2);
                if (listZze.size() > 2 || listZze.isEmpty()) {
                    obj = null;
                } else {
                    if (listZze.size() == 1) {
                        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                        str2 = (String) listZze.get(0);
                    } else {
                        sharedPreferences = context.getSharedPreferences((String) listZze.get(0), 0);
                        str2 = (String) listZze.get(1);
                    }
                    obj = sharedPreferences.getAll().get(str2);
                }
                if (obj != null) {
                    int i3 = i2 - 1;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (obj instanceof Boolean) {
                                bundle.putBoolean(strOptString, ((Boolean) obj).booleanValue());
                            }
                        } else if (obj instanceof Integer) {
                            bundle.putInt(strOptString, ((Integer) obj).intValue());
                        } else if (obj instanceof Long) {
                            bundle.putLong(strOptString, ((Long) obj).longValue());
                        } else if (obj instanceof Float) {
                            bundle.putFloat(strOptString, ((Float) obj).floatValue());
                        }
                    } else if (obj instanceof String) {
                        bundle.putString(strOptString, (String) obj);
                    }
                }
            }
        }
        return bundle;
    }

    public static void U(Context context) {
        zzbbn zzbbnVar = zzbbw.zzfB;
        n42 n42Var = n42.d;
        if (((Boolean) n42Var.c.zza(zzbbnVar)).booleanValue() && context != null) {
            context.deleteDatabase("OfflineUpload.db");
        }
        try {
            zzfsb zzfsbVarZzj = zzfsb.zzj(context);
            zzfsc zzfscVarZzi = zzfsc.zzi(context);
            zzfsbVarZzj.zzk();
            zzfsbVarZzj.zzl();
            zzfscVarZzi.zzj();
            if (((Boolean) n42Var.c.zza(zzbbw.zzcJ)).booleanValue()) {
                zzfscVarZzi.zzk();
            }
            if (((Boolean) n42Var.c.zza(zzbbw.zzcK)).booleanValue()) {
                zzfscVarZzi.zzl();
            }
        } catch (IOException e2) {
            hd2.B.g.zzw(e2, "clearStorageOnIdlessMode");
        }
    }

    public static void b(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        l(th, "<this>");
        l(th2, "exception");
        if (th != th2) {
            Integer num = yh0.a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = e21.a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static boolean d(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void e(String str, boolean z) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void f(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void g(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(str.concat(" must not be null"));
        G(illegalStateException, qg0.class.getName());
        throw illegalStateException;
    }

    public static void h(Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        G(nullPointerException, qg0.class.getName());
        throw nullPointerException;
    }

    public static void i(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str);
        G(nullPointerException, qg0.class.getName());
        throw nullPointerException;
    }

    public static void j(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void k(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str.concat(" must not be null"));
        G(nullPointerException, qg0.class.getName());
        throw nullPointerException;
    }

    public static void l(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(p(str));
        G(nullPointerException, qg0.class.getName());
        throw nullPointerException;
    }

    public static void m(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(p(str));
        G(illegalArgumentException, qg0.class.getName());
        throw illegalArgumentException;
    }

    public static void n(int i, int i2, int i3) {
        if (i < 0 || i2 > i3) {
            StringBuilder sbN = uo.n("fromIndex: ", i, ", toIndex: ", i2, ", size: ");
            sbN.append(i3);
            throw new IndexOutOfBoundsException(sbN.toString());
        }
        if (i > i2) {
            throw new IllegalArgumentException(k31.j(i, i2, "fromIndex: ", " > toIndex: "));
        }
    }

    public static int o(int i) {
        int i2 = (i & (~(i >> 31))) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    public static String p(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = qg0.class.getName();
        int i = 0;
        while (!stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        while (stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        StackTraceElement stackTraceElement = stackTrace[i];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static float q(Context context, int i) {
        return TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static Drawable s(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return t1.c(compoundButton);
        }
        if (!f) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f = true;
        }
        Field field = e;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException unused2) {
                e = null;
            }
        }
        return null;
    }

    public static qg0 t(Context context) {
        qg0 qg0Var;
        synchronized (c) {
            try {
                if (b == null) {
                    if (ar1.m) {
                        Context applicationContext = context.getApplicationContext();
                        vk0 vk0Var = new vk0();
                        vk0Var.h = new HashMap();
                        vk0Var.g = (LauncherApps) applicationContext.getSystemService("launcherapps");
                        b = vk0Var;
                    } else {
                        Context applicationContext2 = context.getApplicationContext();
                        tk0 tk0Var = new tk0();
                        tk0Var.i = new ArrayList();
                        tk0Var.g = applicationContext2.getPackageManager();
                        tk0Var.h = applicationContext2;
                        tk0Var.j = new m6(tk0Var, 3);
                        b = tk0Var;
                    }
                }
                qg0Var = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return qg0Var;
    }

    public static uv u(yi0 yi0Var, List list) {
        ef efVar = yi0Var.q;
        if (efVar == null) {
            return new uv((byte[]) null, true, list);
        }
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(((jb0) it.next()).a);
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List list2 = efVar.h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (jb0 jb0Var : efVar.h) {
                    if (!treeSet.contains(jb0Var.a)) {
                        arrayList.add(jb0Var);
                    }
                }
            }
        } else if (!efVar.g.isEmpty()) {
            for (Map.Entry entry : efVar.g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new jb0((String) entry.getKey(), (String) entry.getValue()));
                }
            }
        }
        return new uv(efVar.a, true, (List) arrayList);
    }

    public static n21 v(AppCompatTextView appCompatTextView) {
        int iB;
        int iF;
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return new n21(eu.k(appCompatTextView));
        }
        TextPaint textPaint = new TextPaint(appCompatTextView.getPaint());
        if (i >= 23) {
            iB = 1;
            iF = 1;
        } else {
            iB = 0;
            iF = 0;
        }
        TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        if (i >= 23) {
            iB = t1.b(appCompatTextView);
            iF = t1.f(appCompatTextView);
        }
        if (appCompatTextView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else if (i < 28 || (appCompatTextView.getInputType() & 15) != 3) {
            boolean z = appCompatTextView.getLayoutDirection() == 1;
            switch (appCompatTextView.getTextDirection()) {
                case 2:
                    textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                    break;
                case 3:
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                    break;
                case 4:
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                    break;
                case 5:
                    textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                    break;
                case 6:
                    break;
                case 7:
                    textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    break;
                default:
                    if (z) {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    }
                    break;
            }
        } else {
            byte directionality = Character.getDirectionality(eu.c(sl.c(appCompatTextView.getTextLocale()))[0].codePointAt(0));
            textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        return new n21(textPaint, textDirectionHeuristic, iB, iF);
    }

    public static byte[] w(InputStream inputStream, int i, se seVar) throws Throwable {
        byte[] bArrA;
        h21 h21Var = new h21(seVar, i);
        try {
            bArrA = seVar.a(1024);
            while (true) {
                try {
                    int i2 = inputStream.read(bArrA);
                    if (i2 == -1) {
                        break;
                    }
                    h21Var.write(bArrA, 0, i2);
                } catch (Throwable th) {
                    th = th;
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        gv1.b("Error occurred when closing InputStream", new Object[0]);
                    }
                    seVar.b(bArrA);
                    h21Var.close();
                    throw th;
                }
            }
            byte[] byteArray = h21Var.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
                gv1.b("Error occurred when closing InputStream", new Object[0]);
            }
            seVar.b(bArrA);
            h21Var.close();
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            bArrA = null;
        }
    }

    public static boolean y(View view) {
        WeakHashMap weakHashMap = qs1.a;
        return view.getLayoutDirection() == 1;
    }

    public abstract boolean A(String str, jq1 jq1Var);

    public abstract ek0 F(Intent intent, jq1 jq1Var);

    public abstract void L(ComponentName componentName, jq1 jq1Var);

    public abstract void M(ComponentName componentName, jq1 jq1Var, Rect rect, Bundle bundle);

    public abstract void a(rl0 rl0Var);

    public abstract List r(String str, jq1 jq1Var);

    public abstract boolean x(ComponentName componentName, jq1 jq1Var);

    public void E() {
    }

    public void c() {
    }

    public void z() {
    }
}
