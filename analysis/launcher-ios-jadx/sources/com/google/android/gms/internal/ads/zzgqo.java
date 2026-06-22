package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgqo extends zzgxy implements zzgzk {
    private static final zzgqo zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private zzgqr zze;

    static {
        zzgqo zzgqoVar = new zzgqo();
        zza = zzgqoVar;
        zzgxy.zzcb(zzgqo.class, zzgqoVar);
    }

    private zzgqo() {
    }

    public static zzgqn zzc() {
        return (zzgqn) zza.zzaZ();
    }

    public static zzgqo zze(zzgwm zzgwmVar, zzgxi zzgxiVar) {
        return (zzgqo) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public static /* synthetic */ void zzh(zzgqo zzgqoVar, zzgqr zzgqrVar) {
        zzgqrVar.getClass();
        zzgqoVar.zze = zzgqrVar;
        zzgqoVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzgqm zzgqmVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgqo();
            case NEW_BUILDER:
                return new zzgqn(zzgqmVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgqo.class) {
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

    public final zzgqr zzf() {
        zzgqr zzgqrVar = this.zze;
        return zzgqrVar == null ? zzgqr.zze() : zzgqrVar;
    }
}
