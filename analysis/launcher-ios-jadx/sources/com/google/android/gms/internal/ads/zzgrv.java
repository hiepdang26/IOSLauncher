package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgrv extends zzgxy implements zzgzk {
    private static final zzgrv zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;

    static {
        zzgrv zzgrvVar = new zzgrv();
        zza = zzgrvVar;
        zzgxy.zzcb(zzgrv.class, zzgrvVar);
    }

    private zzgrv() {
    }

    public static zzgru zzd() {
        return (zzgru) zza.zzaZ();
    }

    public static zzgrv zzf(zzgwm zzgwmVar, zzgxi zzgxiVar) {
        return (zzgrv) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public final int zza() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzgrt zzgrtVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzc", "zzd"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgrv();
            case NEW_BUILDER:
                return new zzgru(zzgrtVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgrv.class) {
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
