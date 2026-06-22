package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class rp1 extends pp1 {
    public final Class m;
    public final Constructor n;
    public final Method o;
    public final Method p;
    public final Method q;
    public final Method r;
    public final Method s;

    public rp1() throws NoSuchMethodException {
        Method methodV;
        Constructor<?> constructor;
        Method methodU;
        Method method;
        Method method2;
        Method method3;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            methodU = U(cls2);
            Class<?> cls3 = Integer.TYPE;
            method = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method2 = cls2.getMethod("freeze", null);
            method3 = cls2.getMethod("abortCreation", null);
            methodV = V(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            methodV = null;
            constructor = null;
            methodU = null;
            method = null;
            method2 = null;
            method3 = null;
        }
        this.m = cls;
        this.n = constructor;
        this.o = methodU;
        this.p = method;
        this.q = method2;
        this.r = method3;
        this.s = methodV;
    }

    public static Method U(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public final void P(Object obj) {
        try {
            this.r.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean Q(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.o.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface R(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.m, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.s.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean S(Object obj) {
        try {
            return ((Boolean) this.q.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final Object T() {
        try {
            return this.n.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Method V(Class cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @Override // defpackage.pp1, defpackage.az1
    public final Typeface g(Context context, j50 j50Var, Resources resources, int i) {
        if (this.o == null) {
            return super.g(context, j50Var, resources, i);
        }
        Object objT = T();
        if (objT != null) {
            k50[] k50VarArr = j50Var.a;
            int length = k50VarArr.length;
            int i2 = 0;
            while (i2 < length) {
                k50 k50Var = k50VarArr[i2];
                String str = k50Var.a;
                FontVariationAxis[] fontVariationAxisArrFromFontVariationSettings = FontVariationAxis.fromFontVariationSettings(k50Var.d);
                Context context2 = context;
                if (!Q(context2, objT, str, k50Var.e, k50Var.b, k50Var.c ? 1 : 0, fontVariationAxisArrFromFontVariationSettings)) {
                    P(objT);
                    return null;
                }
                i2++;
                context = context2;
            }
            if (S(objT)) {
                return R(objT);
            }
        }
        return null;
    }

    @Override // defpackage.pp1, defpackage.az1
    public final Typeface h(Context context, m50[] m50VarArr, int i) {
        Typeface typefaceR;
        boolean zBooleanValue;
        if (m50VarArr.length >= 1) {
            if (this.o != null) {
                HashMap map = new HashMap();
                for (m50 m50Var : m50VarArr) {
                    if (m50Var.e == 0) {
                        Uri uri = m50Var.a;
                        if (!map.containsKey(uri)) {
                            map.put(uri, p02.p(uri, context));
                        }
                    }
                }
                Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
                Object objT = T();
                if (objT != null) {
                    boolean z = false;
                    for (m50 m50Var2 : m50VarArr) {
                        ByteBuffer byteBuffer = (ByteBuffer) mapUnmodifiableMap.get(m50Var2.a);
                        if (byteBuffer != null) {
                            try {
                                zBooleanValue = ((Boolean) this.p.invoke(objT, byteBuffer, Integer.valueOf(m50Var2.b), null, Integer.valueOf(m50Var2.c), Integer.valueOf(m50Var2.d ? 1 : 0))).booleanValue();
                            } catch (IllegalAccessException | InvocationTargetException unused) {
                                zBooleanValue = false;
                            }
                            if (!zBooleanValue) {
                                P(objT);
                                return null;
                            }
                            z = true;
                        }
                    }
                    if (!z) {
                        P(objT);
                        return null;
                    }
                    if (S(objT) && (typefaceR = R(objT)) != null) {
                        return Typeface.create(typefaceR, i);
                    }
                }
            } else {
                m50 m50VarQ = q(m50VarArr, i);
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(m50VarQ.a, "r", null);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(m50VarQ.c).setItalic(m50VarQ.d).build();
                            parcelFileDescriptorOpenFileDescriptor.close();
                            return typefaceBuild;
                        } finally {
                        }
                    }
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return null;
                    }
                } catch (IOException unused2) {
                }
            }
        }
        return null;
    }

    @Override // defpackage.az1
    public final Typeface k(Context context, Resources resources, int i, String str, int i2) {
        if (this.o == null) {
            return super.k(context, resources, i, str, i2);
        }
        Object objT = T();
        if (objT != null) {
            if (!Q(context, objT, str, 0, -1, -1, null)) {
                P(objT);
                return null;
            }
            if (S(objT)) {
                return R(objT);
            }
        }
        return null;
    }
}
