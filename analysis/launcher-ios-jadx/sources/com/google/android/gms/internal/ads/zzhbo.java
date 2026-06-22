package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhbo extends zzgxy implements zzgzk {
    private static final zzhbo zza;
    private static volatile zzgzr zzb;
    private zzgyk zzc = zzgxy.zzbK();

    static {
        zzhbo zzhboVar = new zzhbo();
        zza = zzhboVar;
        zzgxy.zzcb(zzhbo.class, zzhboVar);
    }

    private zzhbo() {
    }

    public static zzhbn zzc() {
        return (zzhbn) zza.zzaZ();
    }

    public static /* synthetic */ void zze(zzhbo zzhboVar, zzhbm zzhbmVar) {
        zzhbmVar.getClass();
        zzgyk zzgykVar = zzhboVar.zzc;
        if (!zzgykVar.zzc()) {
            zzhboVar.zzc = zzgxy.zzbL(zzgykVar);
        }
        zzhboVar.zzc.add(zzhbmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzhbk zzhbkVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzhbm.class});
            case NEW_MUTABLE_INSTANCE:
                return new zzhbo();
            case NEW_BUILDER:
                return new zzhbn(zzhbkVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzhbo.class) {
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
