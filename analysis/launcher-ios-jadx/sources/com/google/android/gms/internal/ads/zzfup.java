package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzfup {
    private final String zza;
    private final zzfun zzb;
    private zzfun zzc;

    public /* synthetic */ zzfup(String str, zzfuo zzfuoVar) {
        zzfun zzfunVar = new zzfun();
        this.zzb = zzfunVar;
        this.zzc = zzfunVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzfun zzfunVar = this.zzb.zzb;
        String str = "";
        while (zzfunVar != null) {
            Object obj = zzfunVar.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r3.length() - 1);
            }
            zzfunVar = zzfunVar.zzb;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzfup zza(Object obj) {
        zzfun zzfunVar = new zzfun();
        this.zzc.zzb = zzfunVar;
        this.zzc = zzfunVar;
        zzfunVar.zza = obj;
        return this;
    }
}
