package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgsl extends zzgxy implements zzgzk {
    private static final zzgsl zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private zzgsr zze;
    private zzgwm zzf = zzgwm.zzb;

    static {
        zzgsl zzgslVar = new zzgsl();
        zza = zzgslVar;
        zzgxy.zzcb(zzgsl.class, zzgslVar);
    }

    private zzgsl() {
    }

    public static zzgsk zzc() {
        return (zzgsk) zza.zzaZ();
    }

    public static zzgsl zze() {
        return zza;
    }

    public static zzgsl zzf(zzgwm zzgwmVar, zzgxi zzgxiVar) {
        return (zzgsl) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public static zzgzr zzi() {
        return zza.zzbN();
    }

    public static /* synthetic */ void zzj(zzgsl zzgslVar, zzgsr zzgsrVar) {
        zzgsrVar.getClass();
        zzgslVar.zze = zzgsrVar;
        zzgslVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzgsj zzgsjVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgsl();
            case NEW_BUILDER:
                return new zzgsk(zzgsjVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgsl.class) {
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

    public final zzgsr zzg() {
        zzgsr zzgsrVar = this.zze;
        return zzgsrVar == null ? zzgsr.zzf() : zzgsrVar;
    }

    public final zzgwm zzh() {
        return this.zzf;
    }
}
