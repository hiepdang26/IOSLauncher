package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgtp extends zzgxy implements zzgzk {
    private static final zzgtp zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private zzgts zze;

    static {
        zzgtp zzgtpVar = new zzgtp();
        zza = zzgtpVar;
        zzgxy.zzcb(zzgtp.class, zzgtpVar);
    }

    private zzgtp() {
    }

    public static zzgto zzc() {
        return (zzgto) zza.zzaZ();
    }

    public static zzgtp zze(zzgwm zzgwmVar, zzgxi zzgxiVar) {
        return (zzgtp) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public static zzgzr zzg() {
        return zza.zzbN();
    }

    public static /* synthetic */ void zzh(zzgtp zzgtpVar, zzgts zzgtsVar) {
        zzgtsVar.getClass();
        zzgtpVar.zze = zzgtsVar;
        zzgtpVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzgtn zzgtnVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgtp();
            case NEW_BUILDER:
                return new zzgto(zzgtnVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgtp.class) {
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

    public final zzgts zzf() {
        zzgts zzgtsVar = this.zze;
        return zzgtsVar == null ? zzgts.zzd() : zzgtsVar;
    }
}
