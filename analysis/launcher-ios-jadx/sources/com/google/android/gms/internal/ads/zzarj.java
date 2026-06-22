package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzarj extends zzgxy implements zzgzk {
    private static final zzarj zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd = 2;

    static {
        zzarj zzarjVar = new zzarj();
        zza = zzarjVar;
        zzgxy.zzcb(zzarj.class, zzarjVar);
    }

    private zzarj() {
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzarf zzarfVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001b᠌\u0000", new Object[]{"zzc", "zzd", zzark.zza});
            case NEW_MUTABLE_INSTANCE:
                return new zzarj();
            case NEW_BUILDER:
                return new zzari(zzarfVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzarj.class) {
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
