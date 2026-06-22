package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpe extends zzgxy implements zzgzk {
    private static final zzfpe zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgyg zzd = zzgxy.zzbG();
    private String zze = "";
    private String zzf = "";
    private String zzg = "";

    static {
        zzfpe zzfpeVar = new zzfpe();
        zza = zzfpeVar;
        zzgxy.zzcb(zzfpe.class, zzfpeVar);
    }

    private zzfpe() {
    }

    public static zzfpd zza() {
        return (zzfpd) zza.zzaZ();
    }

    public static /* synthetic */ void zzd(zzfpe zzfpeVar, String str) {
        str.getClass();
        zzfpeVar.zzc |= 1;
        zzfpeVar.zze = str;
    }

    public static /* synthetic */ void zze(zzfpe zzfpeVar, int i) {
        zzgyg zzgygVar = zzfpeVar.zzd;
        if (!zzgygVar.zzc()) {
            zzfpeVar.zzd = zzgxy.zzbH(zzgygVar);
        }
        zzfpeVar.zzd.zzi(2);
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzfpb zzfpbVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ࠞ\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zzc", "zzd", zzfpc.zza, "zze", "zzf", "zzg"});
            case NEW_MUTABLE_INSTANCE:
                return new zzfpe();
            case NEW_BUILDER:
                return new zzfpd(zzfpbVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzfpe.class) {
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
