package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhdj extends zzgxy implements zzgzk {
    private static final zzhdj zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private String zze = "";
    private zzgwm zzf;
    private zzgwm zzg;

    static {
        zzhdj zzhdjVar = new zzhdj();
        zza = zzhdjVar;
        zzgxy.zzcb(zzhdj.class, zzhdjVar);
    }

    private zzhdj() {
        zzgwm zzgwmVar = zzgwm.zzb;
        this.zzf = zzgwmVar;
        this.zzg = zzgwmVar;
    }

    public static zzhdh zzc() {
        return (zzhdh) zza.zzaZ();
    }

    public static /* synthetic */ void zze(zzhdj zzhdjVar, String str) {
        zzhdjVar.zzc |= 2;
        zzhdjVar.zze = "image/png";
    }

    public static /* synthetic */ void zzf(zzhdj zzhdjVar, zzgwm zzgwmVar) {
        zzgwmVar.getClass();
        zzhdjVar.zzc |= 4;
        zzhdjVar.zzf = zzgwmVar;
    }

    public static /* synthetic */ void zzg(zzhdj zzhdjVar, int i) {
        zzhdjVar.zzd = 1;
        zzhdjVar.zzc = 1 | zzhdjVar.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzhbp zzhbpVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzc", "zzd", zzhdi.zza, "zze", "zzf", "zzg"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhdj();
            case NEW_BUILDER:
                return new zzhdh(zzhbpVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzhdj.class) {
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
