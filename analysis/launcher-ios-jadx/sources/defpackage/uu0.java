package defpackage;

import androidx.multidex.MultiDexApplication;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes.dex */
public abstract class uu0 {
    public static final HashSet a = new HashSet();
    public static final boolean b;

    static {
        String property = System.getProperty("java.vm.version");
        boolean z = false;
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ".");
            String strNextToken = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            if (strNextToken != null && strNextToken2 != null) {
                try {
                    int i = Integer.parseInt(strNextToken);
                    int i2 = Integer.parseInt(strNextToken2);
                    if (i > 2 || (i == 2 && i2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        b = z;
    }

    public static void a(MultiDexApplication multiDexApplication) {
        File file = new File(multiDexApplication.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            file.getPath();
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                file.getPath();
                return;
            }
            for (File file2 : fileArrListFiles) {
                file2.getPath();
                file2.length();
                if (file2.delete()) {
                    file2.getPath();
                } else {
                    file2.getPath();
                }
            }
            if (file.delete()) {
                file.getPath();
            } else {
                file.getPath();
            }
        }
    }

    public static void b(MultiDexApplication multiDexApplication, File file, File file2) {
        ClassLoader classLoader;
        HashSet hashSet = a;
        synchronized (hashSet) {
            try {
                if (hashSet.contains(file)) {
                    return;
                }
                hashSet.add(file);
                System.getProperty("java.vm.version");
                IOException e = null;
                try {
                    classLoader = multiDexApplication.getClassLoader();
                } catch (RuntimeException unused) {
                }
                if (!(classLoader instanceof BaseDexClassLoader)) {
                    classLoader = null;
                }
                if (classLoader == null) {
                    return;
                }
                try {
                    a(multiDexApplication);
                } catch (Throwable unused2) {
                }
                File file3 = new File(file2, "code_cache");
                try {
                    e(file3);
                } catch (IOException unused3) {
                    file3 = new File(multiDexApplication.getFilesDir(), "code_cache");
                    e(file3);
                }
                File file4 = new File(file3, "secondary-dexes");
                e(file4);
                xu0 xu0Var = new xu0(file, file4);
                try {
                    try {
                        d((BaseDexClassLoader) classLoader, file4, xu0Var.h(multiDexApplication, false));
                    } catch (IOException unused4) {
                        d((BaseDexClassLoader) classLoader, file4, xu0Var.h(multiDexApplication, true));
                    }
                    try {
                    } catch (IOException e2) {
                        e = e2;
                    }
                    if (e != null) {
                        throw e;
                    }
                } finally {
                    try {
                        xu0Var.close();
                    } catch (IOException unused5) {
                    }
                }
            } finally {
            }
        }
    }

    public static Field c(Object obj, String str) throws NoSuchFieldException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        StringBuilder sbO = uo.o("Field ", str, " not found in ");
        sbO.append(obj.getClass());
        throw new NoSuchFieldException(sbO.toString());
    }

    public static void d(BaseDexClassLoader baseDexClassLoader, File file, ArrayList arrayList) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, IOException {
        IOException[] iOExceptionArr;
        if (arrayList.isEmpty()) {
            return;
        }
        Object obj = c(baseDexClassLoader, "pathList").get(baseDexClassLoader);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(arrayList);
        Class<?>[] clsArr = {ArrayList.class, File.class, ArrayList.class};
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod("makeDexElements", clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                Object[] objArr = (Object[]) declaredMethod.invoke(obj, arrayList3, file, arrayList2);
                Field fieldC = c(obj, "dexElements");
                Object[] objArr2 = (Object[]) fieldC.get(obj);
                Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
                System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
                System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
                fieldC.set(obj, objArr3);
                if (arrayList2.size() > 0) {
                    int size = arrayList2.size();
                    int i = 0;
                    while (i < size) {
                        Object obj2 = arrayList2.get(i);
                        i++;
                    }
                    Field fieldC2 = c(obj, "dexElementsSuppressedExceptions");
                    IOException[] iOExceptionArr2 = (IOException[]) fieldC2.get(obj);
                    if (iOExceptionArr2 == null) {
                        iOExceptionArr = (IOException[]) arrayList2.toArray(new IOException[arrayList2.size()]);
                    } else {
                        IOException[] iOExceptionArr3 = new IOException[arrayList2.size() + iOExceptionArr2.length];
                        arrayList2.toArray(iOExceptionArr3);
                        System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList2.size(), iOExceptionArr2.length);
                        iOExceptionArr = iOExceptionArr3;
                    }
                    fieldC2.set(obj, iOExceptionArr);
                    IOException iOException = new IOException("I/O exception during makeDexElement");
                    iOException.initCause((Throwable) arrayList2.get(0));
                    throw iOException;
                }
                return;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new NoSuchMethodException("Method makeDexElements with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    public static void e(File file) throws IOException {
        file.mkdir();
        if (file.isDirectory()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            file.getPath();
        } else {
            file.getPath();
            parentFile.isDirectory();
            parentFile.isFile();
            parentFile.exists();
            parentFile.canRead();
            parentFile.canWrite();
        }
        throw new IOException("Failed to create directory " + file.getPath());
    }
}
