package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbc;

/* JADX INFO: loaded from: classes.dex */
public final class zzarw extends zzgxy implements zzgzk {
    private static final zzarw zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private long zzd = -1;
    private int zze = zzbbc.zzq.zzf;
    private int zzf = zzbbc.zzq.zzf;

    static {
        zzarw zzarwVar = new zzarw();
        zza = zzarwVar;
        zzgxy.zzcb(zzarw.class, zzarwVar);
    }

    private zzarw() {
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzarn zzarnVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                zzgye zzgyeVar = zzasp.zza;
                return zzgxy.zzbS(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzc", "zzd", "zze", zzgyeVar, "zzf", zzgyeVar});
            case NEW_MUTABLE_INSTANCE:
                return new zzarw();
            case NEW_BUILDER:
                return new zzarv(zzarnVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzarw.class) {
                    try {
                        zzgxtVar = zzb;
                        if (zzgxtVar == null) {
                            zzgxtVar = new zzgxt(zza);
                            zzb = zzgxtVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return zzgxtVar;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
