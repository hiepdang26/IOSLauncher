package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class dy {
    public static Boolean d = null;
    public static String e = null;
    public static boolean f = false;
    public static int g = -1;
    public static Boolean h;
    public static qc2 l;
    public static vc2 m;
    public final Context a;
    public static final ThreadLocal i = new ThreadLocal();
    public static final o00 j = new o00(3);
    public static final m21 k = new m21();
    public static final b21 b = new b21(14);
    public static final ta1 c = new ta1(14);

    public dy(Context context) {
        this.a = context;
    }

    public static int a(Context context, String str) {
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (bf1.c(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            String.valueOf(declaredField.get(null));
            return 0;
        } catch (ClassNotFoundException unused) {
            return 0;
        } catch (Exception e2) {
            "Failed to load module descriptor class: ".concat(String.valueOf(e2.getMessage()));
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005b A[Catch: all -> 0x0249, TRY_LEAVE, TryCatch #6 {all -> 0x0249, blocks: (B:7:0x0041, B:18:0x005b), top: B:163:0x0041 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.dy c(android.content.Context r22, defpackage.cy r23, java.lang.String r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 629
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dy.c(android.content.Context, cy, java.lang.String):dy");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0167 A[Catch: all -> 0x00d5, TRY_ENTER, TryCatch #10 {all -> 0x00d5, blocks: (B:3:0x0002, B:63:0x00ca, B:65:0x00d0, B:72:0x00dd, B:104:0x0167, B:113:0x0176, B:128:0x01c9, B:129:0x01cc, B:124:0x01c2, B:70:0x00d9, B:131:0x01ce, B:4:0x0003, B:7:0x000a, B:8:0x0026, B:61:0x00c7, B:21:0x004a, B:44:0x00a1, B:47:0x00a4, B:54:0x00bc, B:62:0x00c9, B:60:0x00c2), top: B:145:0x0002, inners: #7, #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01c9 A[Catch: all -> 0x00d5, TryCatch #10 {all -> 0x00d5, blocks: (B:3:0x0002, B:63:0x00ca, B:65:0x00d0, B:72:0x00dd, B:104:0x0167, B:113:0x0176, B:128:0x01c9, B:129:0x01cc, B:124:0x01c2, B:70:0x00d9, B:131:0x01ce, B:4:0x0003, B:7:0x000a, B:8:0x0026, B:61:0x00c7, B:21:0x004a, B:44:0x00a1, B:47:0x00a4, B:54:0x00bc, B:62:0x00c9, B:60:0x00c2), top: B:145:0x0002, inners: #7, #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b0 A[Catch: all -> 0x0037, TryCatch #13 {, blocks: (B:9:0x0027, B:11:0x0033, B:51:0x00b9, B:16:0x003c, B:18:0x0043, B:20:0x0049, B:25:0x004f, B:27:0x0053, B:30:0x005c, B:32:0x0064, B:35:0x006b, B:42:0x0098, B:43:0x00a0, B:38:0x0072, B:40:0x0078, B:41:0x0089, B:46:0x00a3, B:49:0x00a6, B:50:0x00b0, B:17:0x003f), top: B:146:0x0027, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int d(android.content.Context r12, java.lang.String r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dy.d(android.content.Context, java.lang.String, boolean):int");
    }

    public static int e(String str, Context context, boolean z, boolean z2) throws Throwable {
        Throwable th;
        Exception exc;
        boolean z3;
        Cursor cursorQuery;
        boolean z4;
        try {
            try {
                z3 = true;
                cursorQuery = context.getContentResolver().query(new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(((Long) j.get()).longValue())).build(), null, null, null, null);
            } catch (Exception e2) {
                exc = e2;
            }
            if (cursorQuery != null) {
                try {
                } catch (Exception e3) {
                    exc = e3;
                } catch (Throwable th2) {
                    cursor = cursorQuery;
                    th = th2;
                    if (cursor == null) {
                        throw th;
                    }
                    cursor.close();
                    throw th;
                }
                if (cursorQuery.moveToFirst()) {
                    boolean z5 = false;
                    int i2 = cursorQuery.getInt(0);
                    if (i2 > 0) {
                        synchronized (dy.class) {
                            try {
                                e = cursorQuery.getString(2);
                                int columnIndex = cursorQuery.getColumnIndex("loaderVersion");
                                if (columnIndex >= 0) {
                                    g = cursorQuery.getInt(columnIndex);
                                }
                                int columnIndex2 = cursorQuery.getColumnIndex("disableStandaloneDynamiteLoader2");
                                if (columnIndex2 >= 0) {
                                    z4 = cursorQuery.getInt(columnIndex2) != 0;
                                    f = z4;
                                } else {
                                    z4 = false;
                                }
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                        fc2 fc2Var = (fc2) i.get();
                        if (fc2Var == null || fc2Var.a != null) {
                            z3 = false;
                        } else {
                            fc2Var.a = cursorQuery;
                        }
                        cursor = z3 ? null : cursorQuery;
                        z5 = z4;
                    } else {
                        cursor = cursorQuery;
                    }
                    if (z2 && z5) {
                        throw new yx("forcing fallback to container DynamiteLoader impl");
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return i2;
                    if (exc instanceof yx) {
                        throw exc;
                    }
                    throw new yx("V2 version check failed: " + exc.getMessage(), exc);
                }
            }
            throw new yx("Failed to connect to dynamite module ContentResolver.");
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static void f(ClassLoader classLoader) throws yx {
        try {
            vc2 vc2Var = null;
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder != null) {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (iInterfaceQueryLocalInterface instanceof vc2) {
                    vc2Var = (vc2) iInterfaceQueryLocalInterface;
                } else {
                    try {
                        vc2Var = new vc2(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2", 1);
                    } catch (IllegalAccessException e2) {
                        e = e2;
                        throw new yx("Failed to instantiate dynamite loader", e);
                    } catch (InstantiationException e3) {
                        e = e3;
                        throw new yx("Failed to instantiate dynamite loader", e);
                    } catch (NoSuchMethodException e4) {
                        e = e4;
                        throw new yx("Failed to instantiate dynamite loader", e);
                    } catch (InvocationTargetException e5) {
                        e = e5;
                        throw new yx("Failed to instantiate dynamite loader", e);
                    }
                }
            }
            m = vc2Var;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e6) {
            e = e6;
        }
    }

    public static boolean g(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(h)) {
            return true;
        }
        boolean z = false;
        if (h == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (ea0.b.c(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                z = true;
            }
            h = Boolean.valueOf(z);
            if (z && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                f = true;
            }
        }
        return z;
    }

    public static qc2 h(Context context) {
        qc2 qc2Var;
        synchronized (dy.class) {
            qc2 qc2Var2 = l;
            if (qc2Var2 != null) {
                return qc2Var2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    qc2Var = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    qc2Var = iInterfaceQueryLocalInterface instanceof qc2 ? (qc2) iInterfaceQueryLocalInterface : new qc2(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader", 1);
                }
                if (qc2Var != null) {
                    l = qc2Var;
                    return qc2Var;
                }
            } catch (Exception e2) {
                e2.getMessage();
            }
            return null;
        }
    }

    public final IBinder b(String str) {
        try {
            return (IBinder) this.a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new yx("Failed to instantiate module class: ".concat(str), e2);
        }
    }
}
