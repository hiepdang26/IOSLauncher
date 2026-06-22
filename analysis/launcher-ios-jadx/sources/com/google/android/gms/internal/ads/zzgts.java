package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgts extends zzgxy implements zzgzk {
    private static final zzgts zza;
    private static volatile zzgzr zzb;
    private String zzc = "";

    static {
        zzgts zzgtsVar = new zzgts();
        zza = zzgtsVar;
        zzgxy.zzcb(zzgts.class, zzgtsVar);
    }

    private zzgts() {
    }

    public static zzgtr zza() {
        return (zzgtr) zza.zzaZ();
    }

    public static zzgts zzd() {
        return zza;
    }

    public static zzgts zze(zzgwm zzgwmVar, zzgxi zzgxiVar) {
        return (zzgts) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public static /* synthetic */ void zzg(zzgts zzgtsVar, String str) {
        str.getClass();
        zzgtsVar.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzgtq zzgtqVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzc"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgts();
            case NEW_BUILDER:
                return new zzgtr(zzgtqVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgts.class) {
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

    public final String zzf() {
        return this.zzc;
    }
}
