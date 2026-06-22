package com.google.android.gms.internal.ads;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import defpackage.uo;
import java.util.IllegalFormatException;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzfua {
    private final String zza;

    public zzfua(String str) {
        this.zza = ("UID: [" + Process.myUid() + "]  PID: [" + Process.myPid() + "] ").concat(str);
    }

    private static String zze(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException unused) {
                "Unable to format ".concat(String.valueOf(str2));
                str2 = str2 + " [" + TextUtils.join(", ", objArr) + "]";
            }
        }
        return uo.i(str, " : ", str2);
    }

    public final int zza(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            return Log.e("PlayCore", zze(this.zza, str, objArr));
        }
        return 0;
    }

    public final int zzb(Throwable th, String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            return Log.e("PlayCore", zze(this.zza, str, objArr), th);
        }
        return 0;
    }

    public final int zzc(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 4)) {
            return Log.i("PlayCore", zze(this.zza, str, objArr));
        }
        return 0;
    }

    public final int zzd(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 5)) {
            return Log.w("PlayCore", zze(this.zza, str, objArr));
        }
        return 0;
    }
}
