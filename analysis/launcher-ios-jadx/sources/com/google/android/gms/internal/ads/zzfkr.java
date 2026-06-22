package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfkr extends zzgxy implements zzgzk {
    private static final zzfkr zza;
    private static volatile zzgzr zzb;
    private zzgyk zzc = zzgxy.zzbK();

    static {
        zzfkr zzfkrVar = new zzfkr();
        zza = zzfkrVar;
        zzgxy.zzcb(zzfkr.class, zzfkrVar);
    }

    private zzfkr() {
    }

    public static zzfko zzc() {
        return (zzfko) zza.zzaZ();
    }

    public static /* synthetic */ void zzf(zzfkr zzfkrVar, zzfkq zzfkqVar) {
        zzfkqVar.getClass();
        zzgyk zzgykVar = zzfkrVar.zzc;
        if (!zzgykVar.zzc()) {
            zzfkrVar.zzc = zzgxy.zzbL(zzgykVar);
        }
        zzfkrVar.zzc.add(zzfkqVar);
    }

    public final int zza() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzfkn zzfknVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzfkq.class});
            case NEW_MUTABLE_INSTANCE:
                return new zzfkr();
            case NEW_BUILDER:
                return new zzfko(zzfknVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzfkr.class) {
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
