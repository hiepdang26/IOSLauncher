package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpi extends zzgxy implements zzgzk {
    private static final zzfpi zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private zzfpe zzg;

    static {
        zzfpi zzfpiVar = new zzfpi();
        zza = zzfpiVar;
        zzgxy.zzcb(zzfpi.class, zzfpiVar);
    }

    private zzfpi() {
    }

    public static zzfpg zza() {
        return (zzfpg) zza.zzaZ();
    }

    public static /* synthetic */ void zzd(zzfpi zzfpiVar, String str) {
        str.getClass();
        zzfpiVar.zzc |= 2;
        zzfpiVar.zze = str;
    }

    public static /* synthetic */ void zze(zzfpi zzfpiVar, zzfpe zzfpeVar) {
        zzfpeVar.getClass();
        zzfpiVar.zzg = zzfpeVar;
        zzfpiVar.zzc |= 8;
    }

    public static /* synthetic */ void zzf(zzfpi zzfpiVar, int i) {
        zzfpiVar.zzd = 1;
        zzfpiVar.zzc = 1 | zzfpiVar.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzfpf zzfpfVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", zzfph.zza, "zze", "zzf", "zzg"});
            case NEW_MUTABLE_INSTANCE:
                return new zzfpi();
            case NEW_BUILDER:
                return new zzfpg(zzfpfVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzfpi.class) {
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
