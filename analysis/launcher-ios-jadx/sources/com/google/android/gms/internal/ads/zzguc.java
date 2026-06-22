package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzguc extends zzgxy implements zzgzk {
    public static final /* synthetic */ int zza = 0;
    private static final zzguc zzb;
    private static volatile zzgzr zzc;
    private String zzd = "";
    private zzgyk zze = zzgxy.zzbK();

    static {
        zzguc zzgucVar = new zzguc();
        zzb = zzgucVar;
        zzgxy.zzcb(zzguc.class, zzgucVar);
    }

    private zzguc() {
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzgua zzguaVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzd", "zze", zzgtc.class});
            case NEW_MUTABLE_INSTANCE:
                return new zzguc();
            case NEW_BUILDER:
                return new zzgub(zzguaVar);
            case GET_DEFAULT_INSTANCE:
                return zzb;
            case GET_PARSER:
                zzgzr zzgzrVar = zzc;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzguc.class) {
                    try {
                        zzgxtVar = zzc;
                        if (zzgxtVar == null) {
                            zzgxtVar = new zzgxt(zzb);
                            zzc = zzgxtVar;
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
