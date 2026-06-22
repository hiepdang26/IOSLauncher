package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgtm extends zzgxy implements zzgzk {
    private static final zzgtm zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgyk zzd = zzgxy.zzbK();

    static {
        zzgtm zzgtmVar = new zzgtm();
        zza = zzgtmVar;
        zzgxy.zzcb(zzgtm.class, zzgtmVar);
    }

    private zzgtm() {
    }

    public static zzgtj zza() {
        return (zzgtj) zza.zzaZ();
    }

    public static /* synthetic */ void zze(zzgtm zzgtmVar, zzgtl zzgtlVar) {
        zzgtlVar.getClass();
        zzgyk zzgykVar = zzgtmVar.zzd;
        if (!zzgykVar.zzc()) {
            zzgtmVar.zzd = zzgxy.zzbL(zzgykVar);
        }
        zzgtmVar.zzd.add(zzgtlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzgti zzgtiVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzc", "zzd", zzgtl.class});
            case NEW_MUTABLE_INSTANCE:
                return new zzgtm();
            case NEW_BUILDER:
                return new zzgtj(zzgtiVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgtm.class) {
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
