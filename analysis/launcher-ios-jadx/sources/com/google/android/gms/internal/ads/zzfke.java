package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import defpackage.do0;
import defpackage.n42;
import defpackage.wd;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class zzfke {
    public static void zza(do0 do0Var, zzfkf zzfkfVar, zzfju zzfjuVar) {
        zzg(do0Var, zzfkfVar, zzfjuVar, false);
    }

    public static void zzb(do0 do0Var, zzfkf zzfkfVar, zzfju zzfjuVar) {
        zzg(do0Var, zzfkfVar, zzfjuVar, true);
    }

    public static void zzc(do0 do0Var, zzfkf zzfkfVar, zzfju zzfjuVar) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            zzgcj.zzr(zzgca.zzu(do0Var), new zzfkd(zzfkfVar, zzfjuVar), zzbzo.zzf);
        }
    }

    public static void zzd(do0 do0Var, zzfju zzfjuVar) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            zzgcj.zzr(zzgca.zzu(do0Var), new zzfkb(zzfjuVar), zzbzo.zzf);
        }
    }

    public static boolean zze(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches((String) n42.d.c.zza(zzbbw.zzhU), str);
    }

    public static int zzf(zzffg zzffgVar) {
        int iQ = wd.Q(zzffgVar) - 1;
        return (iQ == 0 || iQ == 1) ? 7 : 23;
    }

    private static void zzg(do0 do0Var, zzfkf zzfkfVar, zzfju zzfjuVar, boolean z) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            zzgcj.zzr(zzgca.zzu(do0Var), new zzfkc(zzfkfVar, zzfjuVar, z), zzbzo.zzf);
        }
    }
}
