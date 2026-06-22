package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzasi extends zzgxy implements zzgzk {
    private static final zzasi zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;

    static {
        zzasi zzasiVar = new zzasi();
        zza = zzasiVar;
        zzgxy.zzcb(zzasi.class, zzasiVar);
    }

    private zzasi() {
    }

    public static zzash zza() {
        return (zzash) zza.zzaZ();
    }

    public static /* synthetic */ void zzd(zzasi zzasiVar, long j) {
        zzasiVar.zzc |= 1;
        zzasiVar.zzd = j;
    }

    public static /* synthetic */ void zze(zzasi zzasiVar, long j) {
        zzasiVar.zzc |= 4;
        zzasiVar.zzf = j;
    }

    public static /* synthetic */ void zzf(zzasi zzasiVar, long j) {
        zzasiVar.zzc |= 8;
        zzasiVar.zzg = j;
    }

    public static /* synthetic */ void zzg(zzasi zzasiVar, long j) {
        zzasiVar.zzc |= 16;
        zzasiVar.zzh = j;
    }

    public static /* synthetic */ void zzh(zzasi zzasiVar, long j) {
        zzasiVar.zzc |= 32;
        zzasiVar.zzi = j;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzarn zzarnVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            case NEW_MUTABLE_INSTANCE:
                return new zzasi();
            case NEW_BUILDER:
                return new zzash(zzarnVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzasi.class) {
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
