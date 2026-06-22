package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgqx extends zzgxy implements zzgzk {
    private static final zzgqx zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgrd zzd;
    private zzgso zze;

    static {
        zzgqx zzgqxVar = new zzgqx();
        zza = zzgqxVar;
        zzgxy.zzcb(zzgqx.class, zzgqxVar);
    }

    private zzgqx() {
    }

    public static zzgqw zza() {
        return (zzgqw) zza.zzaZ();
    }

    public static zzgqx zzd(zzgwm zzgwmVar, zzgxi zzgxiVar) {
        return (zzgqx) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public static /* synthetic */ void zzg(zzgqx zzgqxVar, zzgrd zzgrdVar) {
        zzgrdVar.getClass();
        zzgqxVar.zzd = zzgrdVar;
        zzgqxVar.zzc |= 1;
    }

    public static /* synthetic */ void zzh(zzgqx zzgqxVar, zzgso zzgsoVar) {
        zzgsoVar.getClass();
        zzgqxVar.zze = zzgsoVar;
        zzgqxVar.zzc |= 2;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzgqv zzgqvVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgqx();
            case NEW_BUILDER:
                return new zzgqw(zzgqvVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgqx.class) {
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

    public final zzgrd zze() {
        zzgrd zzgrdVar = this.zzd;
        return zzgrdVar == null ? zzgrd.zze() : zzgrdVar;
    }

    public final zzgso zzf() {
        zzgso zzgsoVar = this.zze;
        return zzgsoVar == null ? zzgso.zzf() : zzgsoVar;
    }
}
