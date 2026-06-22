package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfkq extends zzgxy implements zzgzk {
    private static final zzfkq zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzfkm zzd;

    static {
        zzfkq zzfkqVar = new zzfkq();
        zza = zzfkqVar;
        zzgxy.zzcb(zzfkq.class, zzfkqVar);
    }

    private zzfkq() {
    }

    public static zzfkp zza() {
        return (zzfkp) zza.zzaZ();
    }

    public static /* synthetic */ void zzd(zzfkq zzfkqVar, zzfkm zzfkmVar) {
        zzfkmVar.getClass();
        zzfkqVar.zzd = zzfkmVar;
        zzfkqVar.zzc |= 1;
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
                return zzgxy.zzbS(zza, "\u0000\u0001\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0000\u0006ဉ\u0000", new Object[]{"zzc", "zzd"});
            case NEW_MUTABLE_INSTANCE:
                return new zzfkq();
            case NEW_BUILDER:
                return new zzfkp(zzfknVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzfkq.class) {
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
