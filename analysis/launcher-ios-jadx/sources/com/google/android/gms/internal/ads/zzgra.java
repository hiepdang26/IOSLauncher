package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgra extends zzgxy implements zzgzk {
    private static final zzgra zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private zzgrg zze;
    private zzgwm zzf = zzgwm.zzb;

    static {
        zzgra zzgraVar = new zzgra();
        zza = zzgraVar;
        zzgxy.zzcb(zzgra.class, zzgraVar);
    }

    private zzgra() {
    }

    public static zzgqz zzc() {
        return (zzgqz) zza.zzaZ();
    }

    public static zzgra zze() {
        return zza;
    }

    public static /* synthetic */ void zzh(zzgra zzgraVar, zzgrg zzgrgVar) {
        zzgrgVar.getClass();
        zzgraVar.zze = zzgrgVar;
        zzgraVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzgqy zzgqyVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgra();
            case NEW_BUILDER:
                return new zzgqz(zzgqyVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgra.class) {
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

    public final zzgrg zzf() {
        zzgrg zzgrgVar = this.zze;
        return zzgrgVar == null ? zzgrg.zze() : zzgrgVar;
    }

    public final zzgwm zzg() {
        return this.zzf;
    }
}
