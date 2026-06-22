package defpackage;

import android.util.Log;
import com.google.android.gms.internal.ads.zzapt;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class gv1 {
    public static final boolean a = Log.isLoggable(zzapt.zza, 2);
    public static final String b = gv1.class.getName();

    public static void a(String str, Object... objArr) {
        String.format(Locale.US, str, objArr);
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                break;
            }
            if (!stackTrace[i].getClassName().equals(b)) {
                String className = stackTrace[i].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                k31.m(strSubstring.substring(strSubstring.lastIndexOf(36) + 1), ".").append(stackTrace[i].getMethodName());
                break;
            }
            i++;
        }
        Locale locale = Locale.US;
        Thread.currentThread().getId();
    }

    public static void b(String str, Object... objArr) {
        if (a) {
            a(str, objArr);
        }
    }
}
