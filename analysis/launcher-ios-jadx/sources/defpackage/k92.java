package defpackage;

import android.util.Log;
import com.google.android.gms.internal.ads.zzbdu;
import com.google.android.gms.internal.ads.zzfvh;

/* JADX INFO: loaded from: classes.dex */
public abstract class k92 {
    public static final zzfvh a = zzfvh.zza(4000);

    public static void a(String str) {
        if (!b() || str == null || str.length() <= 4000) {
            return;
        }
        for (String str2 : a.zzc(str)) {
        }
    }

    public static boolean b() {
        return j(2) && ((Boolean) zzbdu.zza.zze()).booleanValue();
    }

    public static String c(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            return str;
        }
        return str + " @" + stackTrace[3].getLineNumber();
    }

    public static void d(String str) {
        if (!j(3) || str == null || str.length() <= 4000) {
            return;
        }
        for (String str2 : a.zzc(str)) {
        }
    }

    public static void e(String str) {
        if (!j(6) || str == null || str.length() <= 4000) {
            return;
        }
        for (String str2 : a.zzc(str)) {
        }
    }

    public static void f() {
        j(6);
    }

    public static void g(String str) {
        if (!j(4) || str == null || str.length() <= 4000) {
            return;
        }
        for (String str2 : a.zzc(str)) {
        }
    }

    public static void h(String str) {
        if (!j(5) || str == null || str.length() <= 4000) {
            return;
        }
        for (String str2 : a.zzc(str)) {
        }
    }

    public static void i(String str, Exception exc) {
        if (j(5)) {
            if (exc == null) {
                h(c(str));
            } else {
                c(str);
                j(5);
            }
        }
    }

    public static boolean j(int i) {
        return i >= 5 || Log.isLoggable("Ads", i);
    }
}
