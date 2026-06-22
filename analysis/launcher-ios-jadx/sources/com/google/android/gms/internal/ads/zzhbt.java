package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhbt extends zzgxy implements zzgzk {
    private static final zzhbt zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private long zze;
    private zzgwm zzf = zzgwm.zzb;

    static {
        zzhbt zzhbtVar = new zzhbt();
        zza = zzhbtVar;
        zzgxy.zzcb(zzhbt.class, zzhbtVar);
    }

    private zzhbt() {
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzhbp zzhbpVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003ည\u0002", new Object[]{"zzc", "zzd", zzhbs.zza, "zze", "zzf"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhbt();
            case NEW_BUILDER:
                return new zzhbr(zzhbpVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzhbt.class) {
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
