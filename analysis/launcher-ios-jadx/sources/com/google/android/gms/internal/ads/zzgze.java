package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzgze {
    public static final boolean zza(Object obj) {
        return !((zzgzd) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzgzd zzgzdVarZzb = (zzgzd) obj;
        zzgzd zzgzdVar = (zzgzd) obj2;
        if (!zzgzdVar.isEmpty()) {
            if (!zzgzdVarZzb.zze()) {
                zzgzdVarZzb = zzgzdVarZzb.zzb();
            }
            zzgzdVarZzb.zzd(zzgzdVar);
        }
        return zzgzdVarZzb;
    }
}
