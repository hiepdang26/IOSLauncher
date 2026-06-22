package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgsh extends zzgxy implements zzgzk {
    private static final zzgsh zza;
    private static volatile zzgzr zzb;

    static {
        zzgsh zzgshVar = new zzgsh();
        zza = zzgshVar;
        zzgxy.zzcb(zzgsh.class, zzgshVar);
    }

    private zzgsh() {
    }

    public static zzgsh zzc() {
        return zza;
    }

    public static zzgsh zzd(zzgwm zzgwmVar, zzgxi zzgxiVar) {
        return (zzgsh) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzgsf zzgsfVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0000", null);
            case NEW_MUTABLE_INSTANCE:
                return new zzgsh();
            case NEW_BUILDER:
                return new zzgsg(zzgsfVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgsh.class) {
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
