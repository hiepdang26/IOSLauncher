package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgtl extends zzgxy implements zzgzk {
    private static final zzgtl zza;
    private static volatile zzgzr zzb;
    private String zzc = "";
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzgtl zzgtlVar = new zzgtl();
        zza = zzgtlVar;
        zzgxy.zzcb(zzgtl.class, zzgtlVar);
    }

    private zzgtl() {
    }

    public static zzgtk zza() {
        return (zzgtk) zza.zzaZ();
    }

    public static /* synthetic */ void zzd(zzgtl zzgtlVar, String str) {
        str.getClass();
        zzgtlVar.zzc = str;
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
                return zzgxy.zzbS(zza, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgtl();
            case NEW_BUILDER:
                return new zzgtk(zzgtiVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgtl.class) {
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
