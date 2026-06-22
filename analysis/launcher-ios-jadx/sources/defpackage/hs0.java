package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import android.view.View;
import com.google.android.gms.internal.ads.zzfeq;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class hs0 {
    public static final wg1 a;
    public static final wg1 b;
    public static final byte[] c = {64, 25, 8, 92, 31, 28, 26, 26, 73, 93, 88, 89, 84, 75, 31, 107, 25, 15, 26, 7, 16, 6, 65, 3, 28, 0, 14, 25, 71, 3, 27, 85, 73, 73, 94, 65, 73, 29, 64, 76, 23, 16, 13, 87, 72, 4, 45, 57, 0, 0, 10, 27, 4, 65, 2, 78, 127, 24, 8, 23, 7, 28, 0, 6, 0, 14, 22, 15, 23, 1, 10, 28, 73, 82, 83, 82, 70, 77, 71, 2, 85, 3, 17, 10, 92, 72, 8, 43, 122, 9, 25, 54, 1, 12, 26, 1, 73, 99, 0, 6, 23, 79, 27, 75, 15, 71, 85, 2, 54, 58, 13, 17, 55, 65, 3, 19, 17, 85, 105, 98, 19, 29, 0, 11, 83, 14, 14, 4, 64, 68, 92, 85, 15, 99, 78, 72, 73, 84, 88, 51, 53, 16, 22, 32, 7, 10, 0, 13, 79, 78, 67, 14, 50, 122, 9, 13, 54, 27, 6, 28, 12, 82, 126, 14, 76, 65, 85, 9, 15, 55, 53, 29, 26, 6, 7, 10, 0, 3, 14, 81, 85, 20, 43, 57, 1, 27, 0, 0, 71, 3, 15, 78, 100, 30};
    public static Method d;
    public static boolean e;
    public static Field f;
    public static boolean g;

    static {
        int i = 1;
        a = new wg1("CLOSED", i);
        b = new wg1("CONDITION_FALSE", i);
    }

    public static void A(JsonWriter jsonWriter, JSONObject jSONObject) throws IOException {
        try {
            jsonWriter.beginObject();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    jsonWriter.name(next).value((String) obj);
                } else if (obj instanceof Number) {
                    jsonWriter.name(next).value((Number) obj);
                } else if (obj instanceof Boolean) {
                    jsonWriter.name(next).value(((Boolean) obj).booleanValue());
                } else if (obj instanceof JSONObject) {
                    A(jsonWriter.name(next), (JSONObject) obj);
                } else {
                    if (!(obj instanceof JSONArray)) {
                        throw new JSONException("unable to write field: " + String.valueOf(obj));
                    }
                    z(jsonWriter.name(next), (JSONArray) obj);
                }
            }
            jsonWriter.endObject();
        } catch (JSONException e2) {
            throw new IOException(e2);
        }
    }

    public static String B(zzfeq zzfeqVar) {
        if (zzfeqVar == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        try {
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            D(jsonWriter, zzfeqVar);
            jsonWriter.close();
            return stringWriter.toString();
        } catch (IOException unused) {
            k92.f();
            return null;
        }
    }

    public static JSONObject C(JSONObject jSONObject, String[] strArr) {
        for (int i = 0; i < strArr.length - 1; i = 1) {
            if (jSONObject == null) {
                return null;
            }
            jSONObject = jSONObject.optJSONObject(strArr[0]);
        }
        return jSONObject;
    }

    public static void D(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return;
        }
        if (obj instanceof Boolean) {
            jsonWriter.value(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof String) {
            jsonWriter.value((String) obj);
            return;
        }
        if (obj instanceof zzfeq) {
            A(jsonWriter, ((zzfeq) obj).zzd);
            return;
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof List)) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                D(jsonWriter, it.next());
            }
            jsonWriter.endArray();
            return;
        }
        jsonWriter.beginObject();
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            Object key = entry.getKey();
            if (key instanceof String) {
                D(jsonWriter.name((String) key), entry.getValue());
            }
        }
        jsonWriter.endObject();
    }

    public static final void a(g9 g9Var, int i) {
        qg0.l(g9Var, "<this>");
        g9Var.g = new int[i];
        g9Var.h = new Object[i];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v0, types: [d70, im] */
    /* JADX WARN: Type inference failed for: r5v1, types: [d70] */
    /* JADX WARN: Type inference failed for: r5v3, types: [d70] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(defpackage.v31 r4, defpackage.im r5, defpackage.go r6) {
        /*
            boolean r0 = r6 instanceof defpackage.t31
            if (r0 == 0) goto L13
            r0 = r6
            t31 r0 = (defpackage.t31) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            t31 r0 = new t31
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.h
            hp r1 = defpackage.hp.g
            int r2 = r0.i
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            d70 r5 = r0.g
            defpackage.np1.I(r6)     // Catch: java.lang.Throwable -> L29
            goto L64
        L29:
            r4 = move-exception
            goto L6a
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            defpackage.np1.I(r6)
            yo r6 = r0.getContext()
            iy r2 = defpackage.iy.i
            wo r6 = r6.n(r2)
            if (r6 != r4) goto L6e
            r0.g = r5     // Catch: java.lang.Throwable -> L29
            r0.i = r3     // Catch: java.lang.Throwable -> L29
            gg r6 = new gg     // Catch: java.lang.Throwable -> L29
            eo r0 = defpackage.e42.d(r0)     // Catch: java.lang.Throwable -> L29
            r6.<init>(r3, r0)     // Catch: java.lang.Throwable -> L29
            r6.o()     // Catch: java.lang.Throwable -> L29
            ri0 r0 = new ri0     // Catch: java.lang.Throwable -> L29
            r2 = 1
            r0.<init>(r6, r2)     // Catch: java.lang.Throwable -> L29
            u31 r4 = (defpackage.u31) r4     // Catch: java.lang.Throwable -> L29
            r4.R(r0)     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r6.n()     // Catch: java.lang.Throwable -> L29
            if (r4 != r1) goto L64
            return r1
        L64:
            r5.c()
            zp1 r4 = defpackage.zp1.a
            return r4
        L6a:
            r5.c()
            throw r4
        L6e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hs0.b(v31, im, go):java.lang.Object");
    }

    public static final int c(Bitmap bitmap) {
        qg0.l(bitmap, "bitmap");
        Bitmap.Config config = bitmap.getConfig();
        int i = config == null ? -1 : fo1.a[config.ordinal()];
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return 1;
        }
        throw new IllegalArgumentException("RenderScript Toolkit. Only ARGB_8888 and ALPHA_8 Bitmap are supported.");
    }

    public static lf1 d(lf1 lf1Var) {
        rq0 rq0Var = lf1Var.g;
        rq0Var.b();
        return rq0Var.o > 0 ? lf1Var : lf1.h;
    }

    public static void h(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] i(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            jArr[i] = iArr[i];
        }
        return jArr;
    }

    public static long j(InputStream inputStream, OutputStream outputStream, boolean z) {
        byte[] bArr = new byte[1024];
        long j = 0;
        while (true) {
            try {
                int i = inputStream.read(bArr, 0, 1024);
                if (i == -1) {
                    break;
                }
                j += (long) i;
                outputStream.write(bArr, 0, i);
            } catch (Throwable th) {
                if (z) {
                    h(inputStream);
                    h(outputStream);
                }
                throw th;
            }
        }
        if (z) {
            h(inputStream);
            h(outputStream);
        }
        return j;
    }

    public static final void k(s60 s60Var) throws IOException {
        un0 un0Var = new un0(10);
        Cursor cursorC = s60Var.C("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cursorC.moveToNext()) {
            try {
                un0Var.add(cursorC.getString(0));
            } finally {
            }
        }
        cursorC.close();
        ListIterator listIterator = m90.b(un0Var).listIterator(0);
        while (true) {
            sn0 sn0Var = (sn0) listIterator;
            if (!sn0Var.hasNext()) {
                return;
            }
            String str = (String) sn0Var.next();
            qg0.k(str, "triggerName");
            if (str.startsWith("room_fts_content_sync_")) {
                s60Var.n("DROP TRIGGER IF EXISTS ".concat(str));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [ke] */
    /* JADX WARN: Type inference failed for: r7v0, types: [vh] */
    /* JADX WARN: Type inference failed for: r7v1, types: [af1, java.lang.Object, ol] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final Object l(long j, vh vhVar) {
        ?? r0 = ke.o;
        while (true) {
            long j2 = vhVar.i;
            if (j2 >= j && !vhVar.c()) {
                return vhVar;
            }
            Object obj = ol.g.get(vhVar);
            wg1 wg1Var = a;
            if (obj == wg1Var) {
                return wg1Var;
            }
            af1 af1Var = (af1) ((ol) obj);
            if (af1Var != null) {
                vhVar = af1Var;
            } else {
                af1 af1Var2 = (af1) r0.d(Long.valueOf(j2 + 1), vhVar);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = ol.g;
                    if (atomicReferenceFieldUpdater.compareAndSet(vhVar, null, af1Var2)) {
                        if (vhVar.c()) {
                            vhVar.d();
                        }
                        vhVar = af1Var2;
                    } else if (atomicReferenceFieldUpdater.get(vhVar) != null) {
                        break;
                    }
                }
            }
        }
    }

    public static bp0 m(Configuration configuration) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return new bp0(new fp0(sl.d(configuration)));
        }
        Locale[] localeArr = {configuration.locale};
        if (i < 24) {
            return new bp0(new cp0(localeArr));
        }
        int i2 = bp0.b;
        return new bp0(new fp0(sl.b(localeArr)));
    }

    public static final int n(g9 g9Var, Object obj, int i) {
        qg0.l(g9Var, "<this>");
        int i2 = g9Var.i;
        if (i2 == 0) {
            return -1;
        }
        try {
            int iD = z71.d(g9Var.g, g9Var.i, i);
            if (iD < 0 || qg0.d(obj, g9Var.h[iD])) {
                return iD;
            }
            int i3 = iD + 1;
            while (i3 < i2 && g9Var.g[i3] == i) {
                if (qg0.d(obj, g9Var.h[i3])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = iD - 1; i4 >= 0 && g9Var.g[i4] == i; i4--) {
                if (qg0.d(obj, g9Var.h[i4])) {
                    return i4;
                }
            }
            return ~i3;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static boolean o(Context context) {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Bundle t(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> itKeys = jSONObject.keys();
        Bundle bundle = new Bundle();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (objOpt != null) {
                if (objOpt instanceof Boolean) {
                    bundle.putBoolean(next, ((Boolean) objOpt).booleanValue());
                } else if (objOpt instanceof Double) {
                    bundle.putDouble(next, ((Double) objOpt).doubleValue());
                } else if (objOpt instanceof Integer) {
                    bundle.putInt(next, ((Integer) objOpt).intValue());
                } else if (objOpt instanceof Long) {
                    bundle.putLong(next, ((Long) objOpt).longValue());
                } else if (objOpt instanceof String) {
                    bundle.putString(next, (String) objOpt);
                } else if (objOpt instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) objOpt;
                    if (jSONArray.length() != 0) {
                        int length = jSONArray.length();
                        int i = 0;
                        Object objOpt2 = null;
                        for (int i2 = 0; objOpt2 == null && i2 < length; i2++) {
                            objOpt2 = !jSONArray.isNull(i2) ? jSONArray.opt(i2) : null;
                        }
                        if (objOpt2 == null) {
                            k92.h("Expected JSONArray with at least 1 non-null element for key:".concat(String.valueOf(next)));
                        } else if (objOpt2 instanceof JSONObject) {
                            Bundle[] bundleArr = new Bundle[length];
                            while (i < length) {
                                bundleArr[i] = !jSONArray.isNull(i) ? t(jSONArray.optJSONObject(i)) : null;
                                i++;
                            }
                            bundle.putParcelableArray(next, bundleArr);
                        } else if (objOpt2 instanceof Number) {
                            double[] dArr = new double[jSONArray.length()];
                            while (i < length) {
                                dArr[i] = jSONArray.optDouble(i);
                                i++;
                            }
                            bundle.putDoubleArray(next, dArr);
                        } else if (objOpt2 instanceof CharSequence) {
                            String[] strArr = new String[length];
                            while (i < length) {
                                strArr[i] = !jSONArray.isNull(i) ? jSONArray.optString(i) : null;
                                i++;
                            }
                            bundle.putStringArray(next, strArr);
                        } else if (objOpt2 instanceof Boolean) {
                            boolean[] zArr = new boolean[length];
                            while (i < length) {
                                zArr[i] = jSONArray.optBoolean(i);
                                i++;
                            }
                            bundle.putBooleanArray(next, zArr);
                        } else {
                            k92.h("JSONArray with unsupported type " + objOpt2.getClass().getCanonicalName() + " for key:" + next);
                        }
                    }
                } else if (objOpt instanceof JSONObject) {
                    bundle.putBundle(next, t((JSONObject) objOpt));
                } else {
                    k92.h("Unsupported type for key:".concat(String.valueOf(next)));
                }
            }
        }
        return bundle;
    }

    public static List u(JSONArray jSONArray, ArrayList arrayList) {
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
        }
        return arrayList;
    }

    public static ArrayList v(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(jsonReader.nextString());
        }
        jsonReader.endArray();
        return arrayList;
    }

    public static JSONArray w(JsonReader jsonReader) throws JSONException, IOException {
        JSONArray jSONArray = new JSONArray();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            JsonToken jsonTokenPeek = jsonReader.peek();
            if (JsonToken.BEGIN_ARRAY.equals(jsonTokenPeek)) {
                jSONArray.put(w(jsonReader));
            } else if (JsonToken.BEGIN_OBJECT.equals(jsonTokenPeek)) {
                jSONArray.put(y(jsonReader));
            } else if (JsonToken.BOOLEAN.equals(jsonTokenPeek)) {
                jSONArray.put(jsonReader.nextBoolean());
            } else if (JsonToken.NUMBER.equals(jsonTokenPeek)) {
                jSONArray.put(jsonReader.nextDouble());
            } else {
                if (!JsonToken.STRING.equals(jsonTokenPeek)) {
                    throw new IllegalStateException("unexpected json token: ".concat(String.valueOf(jsonTokenPeek)));
                }
                jSONArray.put(jsonReader.nextString());
            }
        }
        jsonReader.endArray();
        return jSONArray;
    }

    public static JSONObject x(JSONObject jSONObject, String str) throws JSONException {
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException unused) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(str, jSONObject2);
            return jSONObject2;
        }
    }

    public static JSONObject y(JsonReader jsonReader) throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            JsonToken jsonTokenPeek = jsonReader.peek();
            if (JsonToken.BEGIN_ARRAY.equals(jsonTokenPeek)) {
                jSONObject.put(strNextName, w(jsonReader));
            } else if (JsonToken.BEGIN_OBJECT.equals(jsonTokenPeek)) {
                jSONObject.put(strNextName, y(jsonReader));
            } else if (JsonToken.BOOLEAN.equals(jsonTokenPeek)) {
                jSONObject.put(strNextName, jsonReader.nextBoolean());
            } else if (JsonToken.NUMBER.equals(jsonTokenPeek)) {
                jSONObject.put(strNextName, jsonReader.nextDouble());
            } else {
                if (!JsonToken.STRING.equals(jsonTokenPeek)) {
                    throw new IllegalStateException("unexpected json token: ".concat(String.valueOf(jsonTokenPeek)));
                }
                jSONObject.put(strNextName, jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return jSONObject;
    }

    public static void z(JsonWriter jsonWriter, JSONArray jSONArray) throws IOException {
        try {
            jsonWriter.beginArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj = jSONArray.get(i);
                if (obj instanceof String) {
                    jsonWriter.value((String) obj);
                } else if (obj instanceof Number) {
                    jsonWriter.value((Number) obj);
                } else if (obj instanceof Boolean) {
                    jsonWriter.value(((Boolean) obj).booleanValue());
                } else if (obj instanceof JSONObject) {
                    A(jsonWriter, (JSONObject) obj);
                } else {
                    if (!(obj instanceof JSONArray)) {
                        throw new JSONException("unable to write field: " + String.valueOf(obj));
                    }
                    z(jsonWriter, (JSONArray) obj);
                }
            }
            jsonWriter.endArray();
        } catch (JSONException e2) {
            throw new IOException(e2);
        }
    }

    public abstract boolean e(a0 a0Var, w wVar, w wVar2);

    public abstract boolean f(a0 a0Var, Object obj, Object obj2);

    public abstract boolean g(a0 a0Var, z zVar, z zVar2);

    public abstract void p(z zVar, z zVar2);

    public abstract void q(z zVar, Thread thread);

    public void r(View view, int i, int i2, int i3, int i4) {
        if (!e) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
                d = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            e = true;
        }
        Method method = d;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (IllegalAccessException unused2) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    public void s(int i, View view) {
        if (!g) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            g = true;
        }
        Field field = f;
        if (field != null) {
            try {
                f.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }
}
