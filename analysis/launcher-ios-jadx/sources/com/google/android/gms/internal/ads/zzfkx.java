package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfkx extends zzgxy implements zzgzk {
    private static final zzfkx zza;
    private static volatile zzgzr zzb;
    private String zzc = "";

    static {
        zzfkx zzfkxVar = new zzfkx();
        zza = zzfkxVar;
        zzgxy.zzcb(zzfkx.class, zzfkxVar);
    }

    private zzfkx() {
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzfkv zzfkvVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzc"});
            case NEW_MUTABLE_INSTANCE:
                return new zzfkx();
            case NEW_BUILDER:
                return new zzfkw(zzfkvVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzfkx.class) {
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
