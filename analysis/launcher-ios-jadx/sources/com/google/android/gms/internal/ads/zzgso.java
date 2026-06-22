package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgso extends zzgxy implements zzgzk {
    private static final zzgso zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgsr zzd;
    private int zze;
    private int zzf;

    static {
        zzgso zzgsoVar = new zzgso();
        zza = zzgsoVar;
        zzgxy.zzcb(zzgso.class, zzgsoVar);
    }

    private zzgso() {
    }

    public static zzgsn zzd() {
        return (zzgsn) zza.zzaZ();
    }

    public static zzgso zzf() {
        return zza;
    }

    public static zzgso zzg(zzgwm zzgwmVar, zzgxi zzgxiVar) {
        return (zzgso) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public static /* synthetic */ void zzi(zzgso zzgsoVar, zzgsr zzgsrVar) {
        zzgsrVar.getClass();
        zzgsoVar.zzd = zzgsrVar;
        zzgsoVar.zzc |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzc() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzgsm zzgsmVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgso();
            case NEW_BUILDER:
                return new zzgsn(zzgsmVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgso.class) {
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

    public final zzgsr zzh() {
        zzgsr zzgsrVar = this.zzd;
        return zzgsrVar == null ? zzgsr.zzf() : zzgsrVar;
    }
}
