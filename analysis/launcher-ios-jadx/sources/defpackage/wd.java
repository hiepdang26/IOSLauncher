package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import android.view.View;
import android.widget.EdgeEffect;
import androidx.appcompat.widget.ActivityChooserView;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzdsp;
import com.google.android.gms.internal.ads.zzffg;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class wd {
    public static HandlerThread A;
    public static final int[] g = {R.attr.name, R.attr.tint, R.attr.height, R.attr.width, R.attr.alpha, R.attr.autoMirrored, R.attr.tintMode, R.attr.viewportWidth, R.attr.viewportHeight};
    public static final int[] h = {R.attr.name, R.attr.pivotX, R.attr.pivotY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.translateX, R.attr.translateY};
    public static final int[] i = {R.attr.name, R.attr.fillColor, R.attr.pathData, R.attr.strokeColor, R.attr.strokeWidth, R.attr.trimPathStart, R.attr.trimPathEnd, R.attr.trimPathOffset, R.attr.strokeLineCap, R.attr.strokeLineJoin, R.attr.strokeMiterLimit, R.attr.strokeAlpha, R.attr.fillAlpha, R.attr.fillType};
    public static final int[] j = {R.attr.name, R.attr.pathData, R.attr.fillType};
    public static final int[] k = {R.attr.drawable};
    public static final int[] l = {R.attr.name, R.attr.animation};
    public static final int[] m = {R.attr.interpolator, R.attr.duration, R.attr.startOffset, R.attr.repeatCount, R.attr.repeatMode, R.attr.valueFrom, R.attr.valueTo, R.attr.valueType};
    public static final int[] n = {R.attr.ordering};
    public static final int[] o = {R.attr.valueFrom, R.attr.valueTo, R.attr.valueType, R.attr.propertyName};
    public static final int[] p = {R.attr.value, R.attr.interpolator, R.attr.valueType, R.attr.fraction};
    public static final int[] q = {R.attr.propertyName, R.attr.pathData, R.attr.propertyXName, R.attr.propertyYName};
    public static final l10 r = new l10(0);
    public static final l10 s = new l10(1);
    public static final int[] t = {R.attr.state_pressed};
    public static final int[] u = {R.attr.state_selected, R.attr.state_pressed};
    public static final int[] v = {R.attr.state_selected};
    public static final int[] w = {R.attr.state_enabled, R.attr.state_pressed};
    public static final Object x = new Object();
    public static boolean y;
    public static int z;

    public static IBinder A(int i2, Parcel parcel) {
        int iD = D(i2, parcel);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iD);
        return strongBinder;
    }

    public static int B(int i2, Parcel parcel) {
        N(parcel, i2, 4);
        return parcel.readInt();
    }

    public static long C(int i2, Parcel parcel) {
        N(parcel, i2, 8);
        return parcel.readLong();
    }

    public static int D(int i2, Parcel parcel) {
        return (i2 & (-65536)) != -65536 ? (char) (i2 >> 16) : parcel.readInt();
    }

    public static ColorStateList F(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22 && i2 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0) {
            Color.alpha(colorStateList.getColorForState(w, 0));
        }
        return colorStateList;
    }

    public static boolean G(int[] iArr) {
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 : iArr) {
            if (i2 == 16842910) {
                z2 = true;
            } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                z3 = true;
            }
        }
        return z2 && z3;
    }

    public static void H(int i2, Parcel parcel) {
        parcel.setDataPosition(parcel.dataPosition() + D(i2, parcel));
    }

    public static int K(Parcel parcel) {
        int i2 = parcel.readInt();
        int iD = D(i2, parcel);
        char c = (char) i2;
        int iDataPosition = parcel.dataPosition();
        if (c != 20293) {
            throw new wk("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(i2))), parcel);
        }
        int i3 = iD + iDataPosition;
        if (i3 < iDataPosition || i3 > parcel.dataSize()) {
            throw new wk(k31.j(iDataPosition, i3, "Size read is invalid start=", " end="), parcel);
        }
        return i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzfkl L(android.os.Bundle r1) {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wd.L(android.os.Bundle):com.google.android.gms.internal.ads.zzfkl");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String M(java.lang.String r1) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 == 0) goto L9
            java.lang.String r1 = "unspecified"
            return r1
        L9:
            int r0 = r1.hashCode()
            switch(r0) {
                case 1743582862: goto L62;
                case 1743582863: goto L58;
                case 1743582864: goto L4e;
                case 1743582865: goto L44;
                case 1743582866: goto L3a;
                case 1743582867: goto L30;
                case 1743582868: goto L26;
                case 1743582869: goto L1c;
                case 1743582870: goto L11;
                default: goto L10;
            }
        L10:
            goto L6c
        L11:
            java.lang.String r0 = "requester_type_8"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 8
            goto L6d
        L1c:
            java.lang.String r0 = "requester_type_7"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 7
            goto L6d
        L26:
            java.lang.String r0 = "requester_type_6"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 6
            goto L6d
        L30:
            java.lang.String r0 = "requester_type_5"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 5
            goto L6d
        L3a:
            java.lang.String r0 = "requester_type_4"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 4
            goto L6d
        L44:
            java.lang.String r0 = "requester_type_3"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 3
            goto L6d
        L4e:
            java.lang.String r0 = "requester_type_2"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 2
            goto L6d
        L58:
            java.lang.String r0 = "requester_type_1"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 1
            goto L6d
        L62:
            java.lang.String r0 = "requester_type_0"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 0
            goto L6d
        L6c:
            r0 = -1
        L6d:
            switch(r0) {
                case 0: goto L89;
                case 1: goto L86;
                case 2: goto L83;
                case 3: goto L80;
                case 4: goto L7d;
                case 5: goto L7a;
                case 6: goto L77;
                case 7: goto L74;
                case 8: goto L71;
                default: goto L70;
            }
        L70:
            return r1
        L71:
            java.lang.String r1 = "8"
            return r1
        L74:
            java.lang.String r1 = "7"
            return r1
        L77:
            java.lang.String r1 = "6"
            return r1
        L7a:
            java.lang.String r1 = "5"
            return r1
        L7d:
            java.lang.String r1 = "4"
            return r1
        L80:
            java.lang.String r1 = "3"
            return r1
        L83:
            java.lang.String r1 = "2"
            return r1
        L86:
            java.lang.String r1 = "1"
            return r1
        L89:
            java.lang.String r1 = "0"
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wd.M(java.lang.String):java.lang.String");
    }

    public static void N(Parcel parcel, int i2, int i3) {
        int iD = D(i2, parcel);
        if (iD == i3) {
            return;
        }
        throw new wk(uo.k(uo.n("Expected size ", i3, " got ", iD, " (0x"), Integer.toHexString(iD), ")"), parcel);
    }

    public static String O(tb2 tb2Var) {
        Bundle bundle;
        return (tb2Var == null || (bundle = tb2Var.i) == null) ? "unspecified" : bundle.getString("query_info_type");
    }

    public static void P(zzdsp zzdspVar, String str, Pair... pairArr) {
        if (((Boolean) n42.d.c.zza(zzbbw.zzgo)).booleanValue()) {
            zzbzo.zza.execute(new xm(zzdspVar, str, pairArr, 17));
        }
    }

    public static int Q(zzffg zzffgVar) {
        if (zzffgVar.zzr) {
            return 2;
        }
        tb2 tb2Var = zzffgVar.zzd;
        l62 l62Var = tb2Var.y;
        String str = tb2Var.D;
        if (l62Var == null && str == null) {
            return 1;
        }
        if (l62Var == null || str == null) {
            return l62Var != null ? 3 : 4;
        }
        return 5;
    }

    public static je c(int i2, int i3, int i4) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if (i2 == -2) {
            if (i3 != 1) {
                return new ul(1, i3);
            }
            ph.b.getClass();
            return new je(oh.b);
        }
        if (i2 != -1) {
            return i2 != 0 ? i2 != Integer.MAX_VALUE ? i3 == 1 ? new je(i2) : new ul(i2, i3) : new je(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) : i3 == 1 ? new je(0) : new ul(1, i3);
        }
        if (i3 == 1) {
            return new ul(1, 2);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    }

    public static Object e(Class cls, InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(wd.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x008a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int f(android.content.Context r8, java.lang.String r9) {
        /*
            int r0 = android.os.Process.myPid()
            int r1 = android.os.Process.myUid()
            java.lang.String r2 = r8.getPackageName()
            int r0 = r8.checkPermission(r9, r0, r1)
            r3 = -1
            if (r0 != r3) goto L14
            goto L38
        L14:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 23
            if (r0 < r4) goto L1f
            java.lang.String r9 = defpackage.t1.k(r9)
            goto L20
        L1f:
            r9 = 0
        L20:
            r5 = 0
            if (r9 != 0) goto L25
            goto L89
        L25:
            if (r2 != 0) goto L39
            android.content.pm.PackageManager r2 = r8.getPackageManager()
            java.lang.String[] r2 = r2.getPackagesForUid(r1)
            if (r2 == 0) goto L38
            int r6 = r2.length
            if (r6 > 0) goto L35
            goto L38
        L35:
            r2 = r2[r5]
            goto L39
        L38:
            return r3
        L39:
            int r3 = android.os.Process.myUid()
            java.lang.String r6 = r8.getPackageName()
            r7 = 1
            if (r3 != r1) goto L7a
            boolean r3 = java.util.Objects.equals(r6, r2)
            if (r3 == 0) goto L7a
            r3 = 29
            if (r0 < r3) goto L6d
            android.app.AppOpsManager r0 = defpackage.d7.b(r8)
            int r3 = android.os.Binder.getCallingUid()
            if (r0 != 0) goto L5a
            r2 = 1
            goto L5e
        L5a:
            int r2 = r0.checkOpNoThrow(r9, r3, r2)
        L5e:
            if (r2 == 0) goto L61
            goto L87
        L61:
            java.lang.String r8 = defpackage.d7.a(r8)
            if (r0 != 0) goto L68
            goto L86
        L68:
            int r7 = r0.checkOpNoThrow(r9, r1, r8)
            goto L86
        L6d:
            if (r0 < r4) goto L86
            java.lang.Object r8 = defpackage.t1.h(r8)
            android.app.AppOpsManager r8 = (android.app.AppOpsManager) r8
            int r7 = defpackage.t1.j(r8, r9, r2)
            goto L86
        L7a:
            if (r0 < r4) goto L86
            java.lang.Object r8 = defpackage.t1.h(r8)
            android.app.AppOpsManager r8 = (android.app.AppOpsManager) r8
            int r7 = defpackage.t1.j(r8, r9, r2)
        L86:
            r2 = r7
        L87:
            if (r2 != 0) goto L8a
        L89:
            return r5
        L8a:
            r8 = -2
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wd.f(android.content.Context, java.lang.String):int");
    }

    public static Bundle g(int i2, Parcel parcel) {
        int iD = D(i2, parcel);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iD);
        return bundle;
    }

    public static byte[] h(int i2, Parcel parcel) {
        int iD = D(i2, parcel);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iD);
        return bArrCreateByteArray;
    }

    public static Parcelable i(Parcel parcel, int i2, Parcelable.Creator creator) {
        int iD = D(i2, parcel);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iD);
        return parcelable;
    }

    public static String k(int i2, Parcel parcel) {
        int iD = D(i2, parcel);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iD);
        return string;
    }

    public static String[] m(int i2, Parcel parcel) {
        int iD = D(i2, parcel);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + iD);
        return strArrCreateStringArray;
    }

    public static ArrayList n(int i2, Parcel parcel) {
        int iD = D(i2, parcel);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iD);
        return arrayListCreateStringArrayList;
    }

    public static Object[] o(Parcel parcel, int i2, Parcelable.Creator creator) {
        int iD = D(i2, parcel);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iD);
        return objArrCreateTypedArray;
    }

    public static ArrayList p(Parcel parcel, int i2, Parcelable.Creator creator) {
        int iD = D(i2, parcel);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iD);
        return arrayListCreateTypedArrayList;
    }

    public static boolean q(String str, String str2) {
        qg0.l(str, "current");
        if (str.equals(str2)) {
            return true;
        }
        if (str.length() != 0) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i2 < str.length()) {
                    char cCharAt = str.charAt(i2);
                    int i5 = i4 + 1;
                    if (i4 == 0 && cCharAt != '(') {
                        break;
                    }
                    if (cCharAt != '(') {
                        if (cCharAt == ')' && i3 - 1 == 0 && i4 != str.length() - 1) {
                            break;
                        }
                    } else {
                        i3++;
                    }
                    i2++;
                    i4 = i5;
                } else if (i3 == 0) {
                    String strSubstring = str.substring(1, str.length() - 1);
                    qg0.k(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    return qg0.d(hk1.L(strSubstring).toString(), str2);
                }
            }
        }
        return false;
    }

    public static void r(int i2, Parcel parcel) {
        if (parcel.dataPosition() != i2) {
            throw new wk(k31.k(i2, "Overread allowed size end="), parcel);
        }
    }

    public static float s(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return hy.b(edgeEffect);
        }
        return 0.0f;
    }

    public static String t(String str, String str2) {
        qg0.l(str, "tableName");
        qg0.l(str2, "triggerType");
        return "`room_table_modification_trigger_" + str + '_' + str2 + '`';
    }

    public static final void u(yo yoVar, Throwable th) {
        Throwable runtimeException;
        Iterator it = dp.a.iterator();
        while (it.hasNext()) {
            try {
                ((q4) it.next()).z(th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    qg0.b(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            qg0.b(th, new zu(yoVar));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static final void v(Context context) {
        Map mapSingletonMap;
        File file;
        qg0.l(context, "context");
        File databasePath = context.getDatabasePath("androidx.work.workdb");
        qg0.k(databasePath, "context.getDatabasePath(WORK_DATABASE_NAME)");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23 || !databasePath.exists()) {
            return;
        }
        ka0 ka0VarJ = ka0.j();
        String[] strArr = wy1.a;
        ka0VarJ.getClass();
        if (i2 >= 23) {
            File databasePath2 = context.getDatabasePath("androidx.work.workdb");
            qg0.k(databasePath2, "context.getDatabasePath(WORK_DATABASE_NAME)");
            if (i2 < 23) {
                file = context.getDatabasePath("androidx.work.workdb");
                qg0.k(file, "context.getDatabasePath(WORK_DATABASE_NAME)");
            } else {
                file = new File(t5.a.a(context), "androidx.work.workdb");
            }
            String[] strArr2 = wy1.a;
            int iE = uq0.E(strArr2.length);
            if (iE < 16) {
                iE = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iE);
            for (String str : strArr2) {
                linkedHashMap.put(new File(databasePath2.getPath() + str), new File(file.getPath() + str));
            }
            if (linkedHashMap.isEmpty()) {
                mapSingletonMap = Collections.singletonMap(databasePath2, file);
                qg0.k(mapSingletonMap, "singletonMap(...)");
            } else {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
                linkedHashMap2.put(databasePath2, file);
                mapSingletonMap = linkedHashMap2;
            }
        } else {
            mapSingletonMap = wz.g;
        }
        for (Map.Entry entry : mapSingletonMap.entrySet()) {
            File file2 = (File) entry.getKey();
            File file3 = (File) entry.getValue();
            if (file2.exists()) {
                if (file3.exists()) {
                    ka0 ka0VarJ2 = ka0.j();
                    String[] strArr3 = wy1.a;
                    file3.toString();
                    ka0VarJ2.getClass();
                }
                if (file2.renameTo(file3)) {
                    file2.toString();
                    file3.toString();
                } else {
                    file2.toString();
                    file3.toString();
                }
                ka0 ka0VarJ3 = ka0.j();
                String[] strArr4 = wy1.a;
                ka0VarJ3.getClass();
            }
        }
    }

    public static float y(EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 31) {
            return hy.c(edgeEffect, f, f2);
        }
        gy.a(edgeEffect, f, f2);
        return f;
    }

    public static boolean z(int i2, Parcel parcel) {
        N(parcel, i2, 4);
        return parcel.readInt() != 0;
    }

    public abstract void I();

    public abstract void J();

    public boolean d() {
        return false;
    }

    public abstract View w(int i2);

    public abstract boolean x();

    public void E() {
    }
}
