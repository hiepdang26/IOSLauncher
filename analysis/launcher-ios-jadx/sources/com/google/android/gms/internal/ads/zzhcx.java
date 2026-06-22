package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhcx extends zzgxy implements zzgzk {
    private static final zzhcx zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private boolean zze;
    private int zzf;

    static {
        zzhcx zzhcxVar = new zzhcx();
        zza = zzhcxVar;
        zzgxy.zzcb(zzhcx.class, zzhcxVar);
    }

    private zzhcx() {
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
                zzgye zzgyeVar = zzhcv.zza;
                return zzgxy.zzbS(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003᠌\u0002", new Object[]{"zzc", "zzd", zzgyeVar, "zze", "zzf", zzgyeVar});
            case NEW_MUTABLE_INSTANCE:
                return new zzhcx();
            case NEW_BUILDER:
                return new zzhcw(zzhbpVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzhcx.class) {
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
