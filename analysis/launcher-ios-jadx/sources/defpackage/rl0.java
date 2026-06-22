package defpackage;

import android.appwidget.AppWidgetProviderInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.Pair;
import com.luutinhit.launcher6.InstallShortcutReceiver;
import com.luutinhit.launcher6.t;
import com.luutinhit.launcher6.u;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class rl0 extends BroadcastReceiver implements sk0 {
    public static final Object A;
    public static final wp0 B;
    public static final ArrayList C;
    public static final ArrayList D;
    public static final wp0 E;
    public static final ArrayList F;
    public static HashSet G;
    public static final HashMap H;
    public static final HandlerThread w;
    public static final Handler x;
    public static final ArrayList y;
    public static final ArrayList z;
    public final boolean g;
    public final jk0 h;
    public final Object i = new Object();
    public final q11 j;
    public u k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public WeakReference q;
    public final ek r;
    public final qx1 s;
    public final oe0 t;
    public final qg0 u;
    public final iy v;

    static {
        HandlerThread handlerThread = new HandlerThread("launcher-loader");
        w = handlerThread;
        handlerThread.start();
        x = new Handler(handlerThread.getLooper());
        y = new ArrayList();
        z = new ArrayList();
        A = new Object();
        B = new wp0();
        C = new ArrayList();
        D = new ArrayList();
        E = new wp0();
        F = new ArrayList();
        H = new HashMap();
    }

    public rl0(jk0 jk0Var, oe0 oe0Var) {
        q11 q11Var = new q11(7, false);
        q11Var.h = new LinkedList();
        Looper.myQueue();
        q11Var.i = new iu(q11Var);
        this.j = q11Var;
        jk0Var.getClass();
        Context context = jk0.i;
        String authority = Uri.parse(context.getString(w61.old_launcher_provider_uri)).getAuthority();
        boolean z2 = false;
        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.android.launcher2.settings", 0);
        ProviderInfo providerInfoResolveContentProvider2 = context.getPackageManager().resolveContentProvider(authority, 0);
        if (providerInfoResolveContentProvider != null && providerInfoResolveContentProvider2 != null) {
            z2 = true;
        }
        this.g = z2;
        this.h = jk0Var;
        ek ekVar = new ek();
        ekVar.g = new ArrayList(42);
        ekVar.h = new ArrayList(42);
        ekVar.i = new ArrayList();
        ekVar.j = new ArrayList();
        ekVar.k = oe0Var;
        this.r = ekVar;
        this.s = new qx1(context, oe0Var);
        this.t = oe0Var;
        this.u = qg0.t(context);
        this.v = iy.n(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0050 A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:4:0x0006, B:8:0x0017, B:10:0x001f, B:13:0x0025, B:15:0x002f, B:19:0x0039, B:30:0x0055, B:26:0x0044, B:28:0x004c, B:29:0x0050), top: B:34:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void D(long r7, defpackage.qh0 r9, java.lang.StackTraceElement[] r10) {
        /*
            java.util.Objects.toString(r9)
            java.lang.Object r0 = defpackage.rl0.A
            monitor-enter(r0)
            d(r7, r9, r10)     // Catch: java.lang.Throwable -> L23
            long r1 = r9.i     // Catch: java.lang.Throwable -> L23
            r3 = -101(0xffffffffffffff9b, double:NaN)
            r5 = -100
            int r10 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r10 == 0) goto L25
            int r10 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r10 == 0) goto L25
            wp0 r10 = defpackage.rl0.E     // Catch: java.lang.Throwable -> L23
            boolean r10 = r10.b(r1)     // Catch: java.lang.Throwable -> L23
            if (r10 != 0) goto L25
            r9.toString()     // Catch: java.lang.Throwable -> L23
            goto L25
        L23:
            r7 = move-exception
            goto L57
        L25:
            wp0 r9 = defpackage.rl0.B     // Catch: java.lang.Throwable -> L23
            java.lang.Object r7 = r9.get(r7)     // Catch: java.lang.Throwable -> L23
            qh0 r7 = (defpackage.qh0) r7     // Catch: java.lang.Throwable -> L23
            if (r7 == 0) goto L50
            long r8 = r7.i     // Catch: java.lang.Throwable -> L23
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 == 0) goto L39
            int r10 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r10 != 0) goto L50
        L39:
            int r8 = r7.h     // Catch: java.lang.Throwable -> L23
            if (r8 == 0) goto L44
            r9 = 1
            if (r8 == r9) goto L44
            r9 = 2
            if (r8 == r9) goto L44
            goto L55
        L44:
            java.util.ArrayList r8 = defpackage.rl0.C     // Catch: java.lang.Throwable -> L23
            boolean r9 = r8.contains(r7)     // Catch: java.lang.Throwable -> L23
            if (r9 != 0) goto L55
            r8.add(r7)     // Catch: java.lang.Throwable -> L23
            goto L55
        L50:
            java.util.ArrayList r8 = defpackage.rl0.C     // Catch: java.lang.Throwable -> L23
            r8.remove(r7)     // Catch: java.lang.Throwable -> L23
        L55:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L23
            return
        L57:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L23
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rl0.D(long, qh0, java.lang.StackTraceElement[]):void");
    }

    public static void E(Context context, qh0 qh0Var) {
        Objects.toString(context);
        Objects.toString(qh0Var);
        ContentValues contentValues = new ContentValues();
        qh0Var.d(context, contentValues);
        F(context, contentValues, qh0Var);
    }

    public static void F(Context context, ContentValues contentValues, qh0 qh0Var) {
        Objects.toString(context);
        Objects.toString(contentValues);
        Objects.toString(qh0Var);
        long j = qh0Var.g;
        y(new ne0(context.getContentResolver(), wl0.a(j), contentValues, qh0Var, j, new Throwable().getStackTrace()));
    }

    public static void G(Context context, ArrayList arrayList) {
        Objects.toString(context);
        Objects.toString(arrayList);
        ArrayList arrayList2 = new ArrayList(arrayList);
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = yl0.a;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            if (((Long) it.next()).longValue() < 0) {
                it.remove();
            }
        }
        y(new xm(uri, arrayList2, contentResolver, 4));
    }

    public static void b(Context context, qh0 qh0Var, long j, long j2, int i, int i2) {
        Objects.toString(context);
        Objects.toString(qh0Var);
        qh0Var.i = j;
        qh0Var.k = i;
        qh0Var.l = i2;
        if ((context instanceof t) && j2 < 0 && j == -101) {
            ((t) context).getHotseat().getClass();
            qh0Var.j = i;
        } else {
            qh0Var.j = j2;
        }
        ContentValues contentValues = new ContentValues();
        ContentResolver contentResolver = context.getContentResolver();
        qh0Var.d(context, contentValues);
        long jGenerateNewItemId = jk0.c().h.generateNewItemId();
        qh0Var.g = jGenerateNewItemId;
        contentValues.put("_id", Long.valueOf(jGenerateNewItemId));
        y(new ng(contentResolver, contentValues, qh0Var, new Throwable().getStackTrace(), 7, false));
    }

    public static void c(Context context, qh0 qh0Var, long j, long j2, int i, int i2) {
        Objects.toString(context);
        Objects.toString(qh0Var);
        if (qh0Var.i == -1) {
            b(context, qh0Var, j, j2, i, i2);
        } else {
            t(context, qh0Var, j, j2, i, i2);
        }
    }

    public static void d(long j, qh0 qh0Var, StackTraceElement[] stackTraceElementArr) {
        Objects.toString(qh0Var);
        qh0 qh0Var2 = (qh0) B.get(j);
        if (qh0Var2 == null || qh0Var == qh0Var2) {
            return;
        }
        if (qh0Var2 instanceof og1) {
            og1 og1Var = (og1) qh0Var2;
            if (qh0Var instanceof og1) {
                og1 og1Var2 = (og1) qh0Var;
                if (og1Var.u.toString().equals(og1Var2.u.toString()) && og1Var.x.filterEquals(og1Var2.x) && og1Var.g == og1Var2.g && og1Var.h == og1Var2.h && og1Var.i == og1Var2.i && og1Var.j == og1Var2.j && og1Var.k == og1Var2.k && og1Var.l == og1Var2.l && og1Var.m == og1Var2.m && og1Var.n == og1Var2.n) {
                    return;
                }
            }
        }
        StringBuilder sb = new StringBuilder("item: ");
        sb.append(qh0Var != null ? qh0Var.toString() : "null");
        sb.append("modelItem: ");
        sb.append(qh0Var2.toString());
        sb.append("Error: ItemInfo passed to checkItemInfo doesn't match original");
        RuntimeException runtimeException = new RuntimeException(sb.toString());
        if (stackTraceElementArr == null) {
            throw runtimeException;
        }
        runtimeException.setStackTrace(stackTraceElementArr);
        throw runtimeException;
    }

    public static void e(t tVar, qh0 qh0Var) {
        Objects.toString(tVar);
        Objects.toString(qh0Var);
        ArrayList arrayList = new ArrayList();
        arrayList.add(qh0Var);
        f(tVar, arrayList);
    }

    public static void f(Context context, ArrayList arrayList) {
        Objects.toString(context);
        Objects.toString(arrayList);
        y(new w1(arrayList, context.getContentResolver(), 27));
    }

    public static void g(ql0 ql0Var) {
        Objects.toString(ql0Var);
        x.post(ql0Var);
    }

    public static ArrayList h(Iterable iterable, jl0 jl0Var) {
        qk0 qk0Var;
        ComponentName componentName;
        Objects.toString(iterable);
        Objects.toString(jl0Var);
        HashSet hashSet = new HashSet();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            qh0 qh0Var = (qh0) it.next();
            if (qh0Var instanceof og1) {
                og1 og1Var = (og1) qh0Var;
                ComponentName componentNameG = og1Var.g();
                if (componentNameG != null && jl0Var.f(null, og1Var, componentNameG)) {
                    hashSet.add(og1Var);
                }
            } else if (qh0Var instanceof w40) {
                w40 w40Var = (w40) qh0Var;
                if (w40Var.x != null) {
                    int i = 0;
                    while (true) {
                        ArrayList arrayList = w40Var.x;
                        if (i < arrayList.size()) {
                            og1 og1Var2 = (og1) arrayList.get(i);
                            ComponentName componentNameG2 = og1Var2.g();
                            if (componentNameG2 != null && jl0Var.f(w40Var, og1Var2, componentNameG2)) {
                                hashSet.add(og1Var2);
                            }
                            i++;
                        }
                    }
                }
            } else if ((qh0Var instanceof qk0) && (componentName = (qk0Var = (qk0) qh0Var).y) != null && jl0Var.f(null, qk0Var, componentName)) {
                hashSet.add(qk0Var);
            }
        }
        return new ArrayList(hashSet);
    }

    public static boolean i(ArrayList arrayList, int[] iArr) {
        Objects.toString(arrayList);
        xg0 xg0Var = jk0.a().e;
        int i = xg0Var.d;
        int i2 = xg0Var.c;
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, i, i2);
        if (arrayList != null) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                qh0 qh0Var = (qh0) obj;
                int i4 = qh0Var.k;
                int i5 = qh0Var.m + i4;
                int i6 = qh0Var.l + qh0Var.n;
                while (i4 >= 0 && i4 < i5 && i4 < i) {
                    for (int i7 = qh0Var.l; i7 >= 0 && i7 < i6 && i7 < i2; i7++) {
                        zArr[i4][i7] = true;
                    }
                    i4++;
                }
            }
        }
        Rect rect = ar1.a;
        int i8 = 0;
        while (true) {
            int i9 = i8 + 1;
            if (i9 > i2) {
                return false;
            }
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                if (i11 <= i) {
                    boolean z2 = !zArr[i10][i8];
                    for (int i12 = i10; i12 < i11; i12++) {
                        for (int i13 = i8; i13 < i9; i13++) {
                            z2 = z2 && !zArr[i12][i13];
                            if (!z2) {
                                break;
                            }
                        }
                    }
                    if (z2) {
                        iArr[0] = i10;
                        iArr[1] = i8;
                        return true;
                    }
                    i10 = i11;
                }
            }
            i8 = i9;
        }
    }

    public static Pair j(Context context, ArrayList arrayList, ArrayList arrayList2) {
        boolean zI;
        long jZ;
        boolean z2 = true;
        Objects.toString(context);
        Objects.toString(arrayList);
        Objects.toString(arrayList2);
        LongSparseArray longSparseArray = new LongSparseArray();
        WeakReference weakReference = jk0.h;
        synchronized (A) {
            try {
                wp0 wp0Var = B;
                wp0Var.getClass();
                zI = false;
                int i = 0;
                while (i < wp0Var.size()) {
                    int i2 = i + 1;
                    qh0 qh0Var = (qh0) wp0Var.valueAt(i);
                    if (qh0Var.i == -100) {
                        ArrayList arrayList3 = (ArrayList) longSparseArray.get(qh0Var.j);
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                            longSparseArray.put(qh0Var.j, arrayList3);
                        }
                        arrayList3.add(qh0Var);
                    }
                    i = i2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int[] iArr = new int[2];
        int size = arrayList.size();
        int i3 = !arrayList.isEmpty();
        if (i3 < size) {
            long jLongValue = ((Long) arrayList.get(i3)).longValue();
            zI = i((ArrayList) longSparseArray.get(jLongValue), iArr);
            jZ = jLongValue;
        } else {
            jZ = 0;
        }
        if (zI) {
            z2 = zI;
        } else {
            for (int i4 = 1; i4 < size; i4++) {
                jZ = ((Long) arrayList.get(i4)).longValue();
                if (i((ArrayList) longSparseArray.get(jZ), iArr)) {
                    break;
                }
            }
            z2 = zI;
        }
        if (!z2) {
            jZ = jk0.c().h.z();
            arrayList.add(Long.valueOf(jZ));
            arrayList2.add(Long.valueOf(jZ));
            if (!i((ArrayList) longSparseArray.get(jZ), iArr)) {
                throw new RuntimeException("Can't find space to add the item");
            }
        }
        return Pair.create(Long.valueOf(jZ), iArr);
    }

    public static Intent m(String str) {
        return new Intent("android.intent.action.VIEW").setData(new Uri.Builder().scheme("market").authority("details").appendQueryParameter("id", str).build());
    }

    public static Intent o(Cursor cursor, Context context, Intent intent) {
        Objects.toString(cursor);
        Objects.toString(context);
        Objects.toString(intent);
        return m(intent.getComponent().getPackageName());
    }

    public static boolean q(AppWidgetProviderInfo appWidgetProviderInfo) {
        ComponentName componentName;
        Objects.toString(appWidgetProviderInfo);
        return (appWidgetProviderInfo == null || (componentName = appWidgetProviderInfo.provider) == null || componentName.getPackageName() == null) ? false : true;
    }

    public static ArrayList r(Context context) {
        Objects.toString(context);
        Cursor cursorQuery = context.getContentResolver().query(yl0.a, null, null, null, "screenRank");
        ArrayList arrayList = new ArrayList();
        try {
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_id");
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(Long.valueOf(cursorQuery.getLong(columnIndexOrThrow)));
                } catch (Exception e) {
                    t.addDumpLog("LauncherModel", "Desktop items loading interrupted - invalid screens: " + e, true);
                }
            }
            cursorQuery.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public static void s(Context context, qh0 qh0Var, long j, long j2, int i, int i2, int i3, int i4) {
        Objects.toString(context);
        Objects.toString(qh0Var);
        qh0Var.i = j;
        qh0Var.k = i;
        qh0Var.l = i2;
        qh0Var.m = i3;
        qh0Var.n = i4;
        if ((context instanceof t) && j2 < 0 && j == -101) {
            ((t) context).getHotseat().getClass();
            qh0Var.j = i;
        } else {
            qh0Var.j = j2;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("container", Long.valueOf(qh0Var.i));
        contentValues.put("cellX", Integer.valueOf(qh0Var.k));
        contentValues.put("cellY", Integer.valueOf(qh0Var.l));
        contentValues.put("rank", Integer.valueOf(qh0Var.q));
        contentValues.put("spanX", Integer.valueOf(qh0Var.m));
        contentValues.put("spanY", Integer.valueOf(qh0Var.n));
        contentValues.put("screen", Long.valueOf(qh0Var.j));
        F(context, contentValues, qh0Var);
    }

    public static void t(Context context, qh0 qh0Var, long j, long j2, int i, int i2) {
        Objects.toString(context);
        Objects.toString(qh0Var);
        qh0Var.i = j;
        qh0Var.k = i;
        qh0Var.l = i2;
        if ((context instanceof t) && j2 < 0 && j == -101) {
            ((t) context).getHotseat().getClass();
            qh0Var.j = i;
        } else {
            qh0Var.j = j2;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("container", Long.valueOf(qh0Var.i));
        contentValues.put("cellX", Integer.valueOf(qh0Var.k));
        contentValues.put("cellY", Integer.valueOf(qh0Var.l));
        contentValues.put("rank", Integer.valueOf(qh0Var.q));
        contentValues.put("screen", Long.valueOf(qh0Var.j));
        F(context, contentValues, qh0Var);
    }

    public static void y(Runnable runnable) {
        Objects.toString(runnable);
        if (w.getThreadId() == Process.myTid()) {
            runnable.run();
        } else {
            x.post(runnable);
        }
    }

    public static boolean z(Intent intent, jq1 jq1Var) {
        String uri;
        String uri2;
        Objects.toString(intent);
        Objects.toString(jq1Var);
        if (intent == null) {
            return false;
        }
        WeakReference weakReference = jk0.h;
        if (intent.getComponent() != null) {
            String packageName = intent.getComponent().getPackageName();
            if (intent.getPackage() != null) {
                uri = intent.toUri(0);
                uri2 = new Intent(intent).setPackage(null).toUri(0);
            } else {
                uri = new Intent(intent).setPackage(packageName).toUri(0);
                uri2 = intent.toUri(0);
            }
        } else {
            uri = intent.toUri(0);
            uri2 = intent.toUri(0);
        }
        synchronized (A) {
            try {
                wp0 wp0Var = B;
                wp0Var.getClass();
                int i = 0;
                while (i < wp0Var.size()) {
                    int i2 = i + 1;
                    qh0 qh0Var = (qh0) wp0Var.valueAt(i);
                    if (qh0Var instanceof og1) {
                        og1 og1Var = (og1) qh0Var;
                        Intent intent2 = og1Var.H;
                        if (intent2 == null) {
                            intent2 = og1Var.x;
                        }
                        if (intent2 != null && og1Var.w.equals(jq1Var)) {
                            if (intent2.filterEquals(intent)) {
                                return true;
                            }
                            intent2.setSourceBounds(intent.getSourceBounds());
                            String uri3 = intent2.toUri(0);
                            if (!uri.equals(uri3) && !uri2.equals(uri3)) {
                                if (Objects.equals(intent.getComponent(), intent2.getComponent()) && Integer.valueOf(intent.getFlags()).equals(Integer.valueOf(intent2.getFlags())) && Objects.equals(intent.getAction(), intent2.getAction()) && Objects.equals(intent.getCategories(), intent2.getCategories())) {
                                    return true;
                                }
                            }
                            return true;
                        }
                    }
                    i = i2;
                }
                return false;
            } finally {
            }
        }
    }

    public final void A(int i, int i2) {
        InstallShortcutReceiver.b = true;
        synchronized (this.i) {
            try {
                ArrayList arrayList = y;
                synchronized (arrayList) {
                    arrayList.clear();
                }
                WeakReference weakReference = this.q;
                if (weakReference != null && weakReference.get() != null) {
                    u uVar = this.k;
                    if (uVar != null) {
                        uVar.k();
                    }
                    this.h.getClass();
                    u uVar2 = new u(this, jk0.i, i2);
                    this.k = uVar2;
                    if (i == -1001 || !this.o || !this.n || this.l) {
                        w.setPriority(5);
                        x.post(this.k);
                    } else {
                        uVar2.j(i);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void B() {
        if (w.getThreadId() == Process.myTid()) {
            throw new RuntimeException("Expected unbindLauncherItemInfos() to be called from the main thread");
        }
        ArrayList arrayList = y;
        synchronized (arrayList) {
            arrayList.clear();
        }
        this.j.b();
        C();
    }

    public final void C() {
        ArrayList arrayList;
        synchronized (A) {
            arrayList = new ArrayList(C);
            arrayList.addAll(D);
        }
        x(new fl0(arrayList, 1));
    }

    public final void a(Context context, ArrayList arrayList) {
        Objects.toString(context);
        Objects.toString(arrayList);
        hl0 hl0VarL = l();
        if (arrayList.isEmpty()) {
            return;
        }
        y(new ng(this, arrayList, context, hl0VarL, 5));
    }

    public final og1 k(Intent intent, jq1 jq1Var, Context context, Cursor cursor, int i, int i2, boolean z2) {
        Objects.toString(intent);
        Objects.toString(jq1Var);
        Objects.toString(context);
        Objects.toString(cursor);
        ComponentName component = intent.getComponent();
        if (component == null) {
            return null;
        }
        Intent intent2 = new Intent(intent.getAction(), (Uri) null);
        intent2.addCategory("android.intent.category.LAUNCHER");
        intent2.setComponent(component);
        ek0 ek0VarF = this.u.F(intent2, jq1Var);
        if (ek0VarF == null && !z2) {
            component.toString();
            return null;
        }
        og1 og1Var = new og1();
        this.t.u(og1Var, component, ek0VarF, jq1Var, false, false);
        oe0 oe0Var = this.t;
        if (og1Var.C == null) {
            og1Var.i(oe0Var);
        }
        if (oe0Var.x(og1Var.C, jq1Var) && cursor != null) {
            Bitmap bitmapE = ar1.e(context, cursor, i);
            if (bitmapE == null) {
                bitmapE = oe0Var.j(jq1Var);
            }
            og1Var.C = bitmapE;
        }
        if (ek0VarF != null && az1.x(ek0VarF.a())) {
            og1Var.D = 4;
        }
        if (TextUtils.isEmpty(og1Var.u) && cursor != null) {
            og1Var.u = ar1.B(cursor.getString(i2));
        }
        if (og1Var.u == null) {
            og1Var.u = component.getClassName();
        }
        og1Var.h = 0;
        og1Var.w = jq1Var;
        og1Var.v = this.v.j(og1Var.u, jq1Var);
        if (ek0VarF != null) {
            og1Var.G = v6.g(ek0VarF);
        }
        return og1Var;
    }

    public final hl0 l() {
        WeakReference weakReference = this.q;
        if (weakReference != null) {
            return (hl0) weakReference.get();
        }
        return null;
    }

    public final og1 n(Cursor cursor, int i, Intent intent, int i2, int i3, nq nqVar, Context context) {
        Objects.toString(cursor);
        Objects.toString(intent);
        Objects.toString(nqVar);
        Objects.toString(context);
        og1 og1Var = new og1();
        og1Var.w = jq1.b();
        Bitmap bitmapA = nqVar.a(cursor, og1Var, context);
        if (bitmapA == null) {
            this.t.v(og1Var, intent, og1Var.w, false);
        } else {
            og1Var.C = bitmapA;
        }
        if ((i2 & 1) != 0) {
            String string = cursor.getString(i);
            if (!TextUtils.isEmpty(string)) {
                og1Var.u = ar1.B(string);
            }
        } else {
            if ((i2 & 2) == 0) {
                throw new InvalidParameterException(k31.k(i2, "Invalid restoreType "));
            }
            if (TextUtils.isEmpty(og1Var.u)) {
                og1Var.u = ar1.B(cursor.getString(i));
            }
        }
        og1Var.v = this.v.j(og1Var.u, og1Var.w);
        og1Var.h = i3;
        og1Var.H = intent;
        og1Var.E = i2;
        return og1Var;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        UserHandle userHandle;
        ComponentName componentNameUnflattenFromString;
        ComponentName componentNameUnflattenFromString2;
        ComponentName componentNameUnflattenFromString3;
        ComponentName componentNameG;
        Objects.toString(context);
        Objects.toString(intent);
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.LOCALE_CHANGED".equals(action)) {
                w(true);
                hl0 hl0VarL = l();
                if (hl0VarL == null || hl0VarL.setLoadOnResume()) {
                    return;
                }
                A(-1001, 0);
                return;
            }
            if ("android.intent.action.MANAGED_PROFILE_ADDED".equals(action) || "android.intent.action.MANAGED_PROFILE_REMOVED".equals(action)) {
                iy.n(context).i();
                w(true);
                hl0 hl0VarL2 = l();
                if (hl0VarL2 == null || hl0VarL2.setLoadOnResume()) {
                    return;
                }
                A(-1001, 0);
                return;
            }
            jq1 jq1VarA = null;
            jq1VarA = null;
            if ("android.intent.action.MANAGED_PROFILE_AVAILABLE".equals(action) || "android.intent.action.MANAGED_PROFILE_UNAVAILABLE".equals(action)) {
                if (ar1.m && (userHandle = (UserHandle) intent.getParcelableExtra("android.intent.extra.USER")) != null) {
                    jq1VarA = jq1.a(userHandle);
                }
                if (jq1VarA != null) {
                    g(new ql0(this, 7, new String[0], jq1VarA));
                    return;
                }
                return;
            }
            if (!"com.luutinhit.launcherios.ACTION_HIDDEN_APPS_IN_WORKSPACE".equals(action)) {
                if ("com.luutinhit.launcherios.ACTION_RELOAD_ICON".equals(action)) {
                    String stringExtra = intent.getStringExtra("EXTRA_COMPONENT_NAME");
                    int intExtra = intent.getIntExtra("EXTRA_ICON_ID", 0);
                    String stringExtra2 = intent.getStringExtra("EXTRA_ICON_PATH");
                    if (TextUtils.isEmpty(stringExtra2)) {
                        if (stringExtra != null && (componentNameUnflattenFromString2 = ComponentName.unflattenFromString(stringExtra)) != null) {
                            g(new ql0(this, new String[]{componentNameUnflattenFromString2.getPackageName()}, stringExtra, jq1.b(), intExtra, null, 1));
                            return;
                        }
                    } else if (stringExtra != null && (componentNameUnflattenFromString3 = ComponentName.unflattenFromString(stringExtra)) != null) {
                        g(new ql0(this, new String[]{componentNameUnflattenFromString3.getPackageName()}, stringExtra, jq1.b(), 0, stringExtra2, 2));
                        return;
                    }
                } else {
                    if (!"com.luutinhit.launcherios.ACTION_UPDATE_LABEL".equals(action)) {
                        if ("com.luutinhit.launcherios.ACTION_UPDATE_CATEGORY".equals(action)) {
                            String stringExtra3 = intent.getStringExtra("EXTRA_COMPONENT_NAME");
                            int intExtra2 = intent.getIntExtra("EXTRA_APP_CATEGORY", 0);
                            if (TextUtils.isEmpty(stringExtra3) || intExtra2 < 0) {
                                return;
                            }
                            g(new ql0(this, stringExtra3, jq1.b(), intExtra2));
                            return;
                        }
                        return;
                    }
                    String stringExtra4 = intent.getStringExtra("EXTRA_COMPONENT_NAME");
                    String stringExtra5 = intent.getStringExtra("EXTRA_APP_LABEL");
                    if (!TextUtils.isEmpty(stringExtra4) && !TextUtils.isEmpty(stringExtra5) && (componentNameUnflattenFromString = ComponentName.unflattenFromString(stringExtra4)) != null) {
                        g(new ql0(this, new String[]{componentNameUnflattenFromString.getPackageName()}, stringExtra4, jq1.b(), stringExtra5));
                        return;
                    }
                }
                return;
            }
            jq1 jq1VarB = jq1.b();
            String[] stringArrayExtra = intent.getStringArrayExtra("HIDDEN_APPS_UPDATED");
            String[] stringArrayExtra2 = intent.getStringArrayExtra("HIDDEN_APPS_REMOVED");
            HashSet hashSet = stringArrayExtra != null ? new HashSet(Arrays.asList(stringArrayExtra)) : null;
            HashSet hashSet2 = stringArrayExtra2 != null ? new HashSet(Arrays.asList(stringArrayExtra2)) : null;
            Objects.toString(hashSet);
            Objects.toString(hashSet2);
            Objects.toString(jq1VarB);
            hl0 hl0VarL3 = l();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            synchronized (A) {
                try {
                    ArrayList arrayList4 = C;
                    arrayList4.size();
                    ((ArrayList) this.r.g).size();
                    int size = arrayList4.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList4.get(i2);
                        i2++;
                        qh0 qh0Var = (qh0) obj;
                        Objects.toString(qh0Var);
                        if (qh0Var instanceof og1) {
                            og1 og1Var = (og1) qh0Var;
                            if (jq1VarB.equals(qh0Var.w) && qh0Var.h == 0 && (componentNameG = og1Var.g()) != null && hashSet2 != null && hashSet2.contains(componentNameG.flattenToString())) {
                                og1Var.i(this.t);
                                arrayList3.add(og1Var);
                            }
                        }
                    }
                    ArrayList arrayList5 = (ArrayList) this.r.g;
                    int size2 = arrayList5.size();
                    while (i < size2) {
                        Object obj2 = arrayList5.get(i);
                        i++;
                        og1 og1VarI = ((v6) obj2).i();
                        ComponentName componentNameG2 = og1VarI.g();
                        if (componentNameG2 != null && hashSet != null && hashSet.contains(componentNameG2.flattenToString())) {
                            og1VarI.i(this.t);
                            arrayList2.add(og1VarI);
                        }
                    }
                    this.r.e(hashSet, jq1VarB, arrayList);
                } catch (Throwable th) {
                    throw th;
                }
            }
            arrayList2.size();
            arrayList3.size();
            if (!arrayList2.isEmpty() || !arrayList3.isEmpty()) {
                this.j.K(new sj0(this, hl0VarL3, arrayList2, arrayList3, jq1VarB));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.j.K(new cl0(this, hl0VarL3, arrayList, 0));
        }
    }

    public final og1 p(Cursor cursor, Context context, int i, nq nqVar) {
        Objects.toString(cursor);
        Objects.toString(context);
        Objects.toString(nqVar);
        og1 og1Var = new og1();
        og1Var.w = jq1.b();
        og1Var.h = 1;
        og1Var.u = ar1.B(cursor.getString(i));
        Bitmap bitmapA = nqVar.a(cursor, og1Var, context);
        if (bitmapA == null) {
            bitmapA = this.t.j(og1Var.w);
            og1Var.z = true;
        }
        og1Var.C = bitmapA;
        return og1Var;
    }

    public final void u(HashSet hashSet, jq1 jq1Var) throws Throwable {
        Throwable th;
        rl0 rl0Var;
        ComponentName componentNameG;
        Objects.toString(hashSet);
        Objects.toString(jq1Var);
        hl0 hl0VarL = l();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        synchronized (A) {
            try {
                wp0 wp0Var = B;
                wp0Var.getClass();
                int i = 0;
                while (i < wp0Var.size()) {
                    int i2 = i + 1;
                    try {
                        qh0 qh0Var = (qh0) wp0Var.valueAt(i);
                        if (qh0Var instanceof og1) {
                            og1 og1Var = (og1) qh0Var;
                            if (jq1Var.equals(qh0Var.w) && qh0Var.h == 0 && (componentNameG = og1Var.g()) != null && hashSet.contains(componentNameG.getPackageName())) {
                                og1Var.i(this.t);
                                arrayList2.add(og1Var);
                            }
                        }
                        i = i2;
                    } catch (Throwable th2) {
                        th = th2;
                        while (true) {
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            th = th3;
                        }
                    }
                }
                this.r.e(hashSet, jq1Var, arrayList);
                if (arrayList2.isEmpty()) {
                    rl0Var = this;
                } else {
                    q11 q11Var = this.j;
                    ng ngVar = new ng(this, hl0VarL, arrayList2, jq1Var, 3);
                    rl0Var = this;
                    q11Var.K(ngVar);
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                rl0Var.j.K(new cl0(this, hl0VarL, arrayList, 1));
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public final void v(int i, String str) {
        g(new ql0(this, str, jq1.b(), i));
    }

    public final void w(boolean z2) {
        synchronized (this.i) {
            try {
                u uVar = this.k;
                if (uVar != null) {
                    uVar.k();
                }
                if (z2) {
                    this.o = false;
                }
                this.n = false;
                this.p = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void x(Runnable runnable) {
        Objects.toString(runnable);
        if (w.getThreadId() == Process.myTid()) {
            this.j.K(runnable);
        } else {
            runnable.run();
        }
    }
}
