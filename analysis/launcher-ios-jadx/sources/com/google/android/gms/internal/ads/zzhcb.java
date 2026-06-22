package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhcb extends zzgxy implements zzgzk {
    private static final zzhcb zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private String zzd = "";

    static {
        zzhcb zzhcbVar = new zzhcb();
        zza = zzhcbVar;
        zzgxy.zzcb(zzhcb.class, zzhcbVar);
    }

    private zzhcb() {
    }

    public static zzhca zzc() {
        return (zzhca) zza.zzaZ();
    }

    public static /* synthetic */ void zze(zzhcb zzhcbVar, String str) {
        zzhcbVar.zzc |= 1;
        zzhcbVar.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzhbp zzhbpVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzc", "zzd"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhcb();
            case NEW_BUILDER:
                return new zzhca(zzhbpVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzhcb.class) {
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
