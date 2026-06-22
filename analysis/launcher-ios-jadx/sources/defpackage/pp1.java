package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class pp1 extends az1 {
    public static Class h = null;
    public static Constructor i = null;
    public static Method j = null;
    public static Method k = null;
    public static boolean l = false;

    public static boolean N(Object obj, String str, int i2, boolean z) throws NoSuchMethodException {
        O();
        try {
            try {
                return ((Boolean) j.invoke(obj, str, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
            } catch (InvocationTargetException e) {
                e = e;
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException | InvocationTargetException e2) {
            e = e2;
        }
    }

    public static void O() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (l) {
            return;
        }
        l = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
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

    @Override // defpackage.az1
    public Typeface g(Context context, j50 j50Var, Resources resources, int i2) throws NoSuchMethodException {
        O();
        try {
            Object objNewInstance = i.newInstance(null);
            for (k50 k50Var : j50Var.a) {
                File fileM = p02.m(context);
                if (fileM == null) {
                    return null;
                }
                try {
                    if (!p02.f(fileM, resources, k50Var.f)) {
                        return null;
                    }
                    if (!N(objNewInstance, fileM.getPath(), k50Var.b, k50Var.c)) {
                        return null;
                    }
                    fileM.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    fileM.delete();
                }
            }
            O();
            try {
                Object objNewInstance2 = Array.newInstance((Class<?>) h, 1);
                Array.set(objNewInstance2, 0, objNewInstance);
                return (Typeface) k.invoke(null, objNewInstance2);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // defpackage.az1
    public Typeface h(Context context, m50[] m50VarArr, int i2) {
        String str;
        if (m50VarArr.length >= 1) {
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(q(m50VarArr, i2).a, "r", null);
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    try {
                        try {
                            str = Os.readlink("/proc/self/fd/" + parcelFileDescriptorOpenFileDescriptor.getFd());
                        } finally {
                        }
                    } catch (ErrnoException unused) {
                    }
                    File file = OsConstants.S_ISREG(Os.stat(str).st_mode) ? new File(str) : null;
                    if (file != null && file.canRead()) {
                        Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return typefaceCreateFromFile;
                    }
                    FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    try {
                        Typeface typefaceJ = j(context, fileInputStream);
                        fileInputStream.close();
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return typefaceJ;
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
        return null;
    }
}
