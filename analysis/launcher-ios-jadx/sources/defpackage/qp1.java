package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class qp1 extends az1 {
    public static final Class h;
    public static final Constructor i;
    public static final Method j;
    public static final Method k;

    static {
        Method method;
        Class<?> cls;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            method = null;
            cls = null;
            method2 = null;
        }
        i = constructor;
        h = cls;
        j = method2;
        k = method;
    }

    public static boolean N(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z) {
        try {
            return ((Boolean) j.invoke(obj, byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface O(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) h, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) k.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0068 A[SYNTHETIC] */
    @Override // defpackage.az1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Typeface g(android.content.Context r17, defpackage.j50 r18, android.content.res.Resources r19, int r20) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
        /*
            r16 = this;
            r1 = 0
            java.lang.reflect.Constructor r0 = defpackage.qp1.i     // Catch: java.lang.Throwable -> L9
            java.lang.Object r0 = r0.newInstance(r1)     // Catch: java.lang.Throwable -> L9
            r2 = r0
            goto Lb
        L9:
            r2 = r1
        Lb:
            if (r2 != 0) goto Le
            goto L68
        Le:
            r0 = r18
            k50[] r3 = r0.a
            int r4 = r3.length
            r0 = 0
            r5 = 0
        L15:
            if (r5 >= r4) goto L71
            r6 = r3[r5]
            int r0 = r6.f
            java.io.File r7 = defpackage.p02.m(r17)
            if (r7 != 0) goto L25
            r8 = r19
        L23:
            r0 = r1
            goto L59
        L25:
            r8 = r19
            boolean r0 = defpackage.p02.f(r7, r8, r0)     // Catch: java.lang.Throwable -> L6c
            if (r0 != 0) goto L31
            r7.delete()
            goto L23
        L31:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch: java.io.IOException -> L55 java.lang.Throwable -> L6c
            r9.<init>(r7)     // Catch: java.io.IOException -> L55 java.lang.Throwable -> L6c
            java.nio.channels.FileChannel r10 = r9.getChannel()     // Catch: java.lang.Throwable -> L4a
            long r14 = r10.size()     // Catch: java.lang.Throwable -> L4a
            java.nio.channels.FileChannel$MapMode r11 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L4a
            r12 = 0
            java.nio.MappedByteBuffer r0 = r10.map(r11, r12, r14)     // Catch: java.lang.Throwable -> L4a
            r9.close()     // Catch: java.io.IOException -> L55 java.lang.Throwable -> L6c
            goto L56
        L4a:
            r0 = move-exception
            r10 = r0
            r9.close()     // Catch: java.lang.Throwable -> L50
            goto L54
        L50:
            r0 = move-exception
            r10.addSuppressed(r0)     // Catch: java.io.IOException -> L55 java.lang.Throwable -> L6c
        L54:
            throw r10     // Catch: java.io.IOException -> L55 java.lang.Throwable -> L6c
        L55:
            r0 = r1
        L56:
            r7.delete()
        L59:
            if (r0 != 0) goto L5c
            goto L68
        L5c:
            int r7 = r6.b
            boolean r9 = r6.c
            int r6 = r6.e
            boolean r0 = N(r2, r0, r6, r7, r9)
            if (r0 != 0) goto L69
        L68:
            return r1
        L69:
            int r5 = r5 + 1
            goto L15
        L6c:
            r0 = move-exception
            r7.delete()
            throw r0
        L71:
            android.graphics.Typeface r0 = O(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qp1.g(android.content.Context, j50, android.content.res.Resources, int):android.graphics.Typeface");
    }

    @Override // defpackage.az1
    public final Typeface h(Context context, m50[] m50VarArr, int i2) {
        Object objNewInstance;
        try {
            objNewInstance = i.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            int i3 = 0;
            ug1 ug1Var = new ug1(0);
            int length = m50VarArr.length;
            while (true) {
                if (i3 >= length) {
                    Typeface typefaceO = O(objNewInstance);
                    if (typefaceO != null) {
                        return Typeface.create(typefaceO, i2);
                    }
                } else {
                    m50 m50Var = m50VarArr[i3];
                    Uri uri = m50Var.a;
                    ByteBuffer byteBufferP = (ByteBuffer) ug1Var.get(uri);
                    if (byteBufferP == null) {
                        byteBufferP = p02.p(uri, context);
                        ug1Var.put(uri, byteBufferP);
                    }
                    if (byteBufferP == null) {
                        break;
                    }
                    if (!N(objNewInstance, byteBufferP, m50Var.b, m50Var.c, m50Var.d)) {
                        break;
                    }
                    i3++;
                }
            }
        }
        return null;
    }
}
