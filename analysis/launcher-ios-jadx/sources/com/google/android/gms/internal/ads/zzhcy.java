package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzhcy extends zzgxy implements zzgzk {
    private static final zzhcy zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private zzhcx zze;
    private zzhcx zzf;

    static {
        zzhcy zzhcyVar = new zzhcy();
        zza = zzhcyVar;
        zzgxy.zzcb(zzhcy.class, zzhcyVar);
    }

    private zzhcy() {
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
                return zzgxy.zzbS(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", zzhcv.zza, "zze", "zzf"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhcy();
            case NEW_BUILDER:
                return new zzhcu(zzhbpVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzhcy.class) {
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
