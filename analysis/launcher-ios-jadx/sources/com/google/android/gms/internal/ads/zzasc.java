package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzasc extends zzgxy implements zzgzk {
    private static final zzasc zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private long zze = -1;

    static {
        zzasc zzascVar = new zzasc();
        zza = zzascVar;
        zzgxy.zzcb(zzasc.class, zzascVar);
    }

    private zzasc() {
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzarn zzarnVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", zzars.zza, "zze"});
            case NEW_MUTABLE_INSTANCE:
                return new zzasc();
            case NEW_BUILDER:
                return new zzasb(zzarnVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzasc.class) {
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
