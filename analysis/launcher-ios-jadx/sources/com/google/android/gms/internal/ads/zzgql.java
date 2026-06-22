package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgql extends zzgxy implements zzgzk {
    private static final zzgql zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private zzgwm zze = zzgwm.zzb;
    private zzgqr zzf;

    static {
        zzgql zzgqlVar = new zzgql();
        zza = zzgqlVar;
        zzgxy.zzcb(zzgql.class, zzgqlVar);
    }

    private zzgql() {
    }

    public static zzgqk zzc() {
        return (zzgqk) zza.zzaZ();
    }

    public static zzgql zze(zzgwm zzgwmVar, zzgxi zzgxiVar) {
        return (zzgql) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public static zzgzr zzh() {
        return zza.zzbN();
    }

    public static /* synthetic */ void zzj(zzgql zzgqlVar, zzgqr zzgqrVar) {
        zzgqrVar.getClass();
        zzgqlVar.zzf = zzgqrVar;
        zzgqlVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzgqj zzgqjVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgql();
            case NEW_BUILDER:
                return new zzgqk(zzgqjVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgql.class) {
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
        zzgqr zzgqrVar = this.zzf;
        return zzgqrVar == null ? zzgqr.zze() : zzgqrVar;
    }

    public final zzgwm zzg() {
        return this.zze;
    }
}
