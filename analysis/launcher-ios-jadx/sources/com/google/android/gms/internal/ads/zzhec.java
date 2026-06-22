package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhec extends zzgxy implements zzgzk {
    private static final zzhec zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private int zzg;
    private String zze = "";
    private zzgyg zzf = zzgxy.zzbG();
    private zzgyk zzh = zzgxy.zzbK();
    private zzgwm zzi = zzgwm.zzb;

    static {
        zzhec zzhecVar = new zzhec();
        zza = zzhecVar;
        zzgxy.zzcb(zzhec.class, zzhecVar);
    }

    private zzhec() {
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
                return zzgxy.zzbS(zza, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0002\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u0016\u0005င\u0002\u0006\u001b\u0007ည\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", zzhea.class, "zzi"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhec();
            case NEW_BUILDER:
                return new zzheb(zzhbpVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzhec.class) {
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
