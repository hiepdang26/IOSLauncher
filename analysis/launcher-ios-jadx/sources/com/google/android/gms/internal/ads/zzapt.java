package com.google.android.gms.internal.ads;

import android.util.Log;
import defpackage.uo;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzapt {
    public static final String zza = "Volley";
    public static final boolean zzb = Log.isLoggable(zza, 2);
    private static final String zzc = zzapt.class.getName();

    public static void zza(String str, Object... objArr) {
        zze(str, objArr);
    }

    public static void zzb(String str, Object... objArr) {
        zze(str, objArr);
    }

    public static void zzc(Throwable th, String str, Object... objArr) {
        zze(str, objArr);
    }

    public static void zzd(String str, Object... objArr) {
        if (zzb) {
            zze(str, objArr);
        }
    }

    private static String zze(String str, Object... objArr) {
        String strI;
        String str2 = String.format(Locale.US, str, objArr);
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                strI = "<unknown>";
                break;
            }
            if (!stackTrace[i].getClassName().equals(zzc)) {
                String className = stackTrace[i].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                strI = uo.i(strSubstring.substring(strSubstring.lastIndexOf(36) + 1), ".", stackTrace[i].getMethodName());
                break;
            }
            i++;
        }
        Locale locale = Locale.US;
        long id = Thread.currentThread().getId();
        StringBuilder sb = new StringBuilder("[");
        sb.append(id);
        sb.append("] ");
        sb.append(strI);
        return uo.k(sb, ": ", str2);
    }
}
