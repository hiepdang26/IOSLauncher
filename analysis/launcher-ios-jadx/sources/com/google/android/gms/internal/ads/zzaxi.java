package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxi extends zzgxy implements zzgzk {
    private static final zzaxi zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzaxl zzd;
    private zzgwm zze;
    private zzgwm zzf;

    static {
        zzaxi zzaxiVar = new zzaxi();
        zza = zzaxiVar;
        zzgxy.zzcb(zzaxi.class, zzaxiVar);
    }

    private zzaxi() {
        zzgwm zzgwmVar = zzgwm.zzb;
        this.zze = zzgwmVar;
        this.zzf = zzgwmVar;
    }

    public static zzaxi zzc(zzgwm zzgwmVar, zzgxi zzgxiVar) {
        return (zzaxi) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public final zzaxl zzd() {
        zzaxl zzaxlVar = this.zzd;
        return zzaxlVar == null ? zzaxl.zzg() : zzaxlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzaxg zzaxgVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case NEW_MUTABLE_INSTANCE:
                return new zzaxi();
            case NEW_BUILDER:
                return new zzaxh(zzaxgVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzaxi.class) {
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

    public final zzgwm zze() {
        return this.zzf;
    }

    public final zzgwm zzf() {
        return this.zze;
    }
}
