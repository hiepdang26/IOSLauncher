package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhdq extends zzgxy implements zzgzk {
    private static final zzhdq zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private long zze;
    private boolean zzf;
    private int zzg;
    private boolean zzj;
    private String zzd = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzhdq zzhdqVar = new zzhdq();
        zza = zzhdqVar;
        zzgxy.zzcb(zzhdq.class, zzhdqVar);
    }

    private zzhdq() {
    }

    public static zzhdp zzc() {
        return (zzhdp) zza.zzaZ();
    }

    public static /* synthetic */ void zze(zzhdq zzhdqVar, String str) {
        zzhdqVar.zzc |= 1;
        zzhdqVar.zzd = str;
    }

    public static /* synthetic */ void zzf(zzhdq zzhdqVar, long j) {
        zzhdqVar.zzc |= 2;
        zzhdqVar.zze = j;
    }

    public static /* synthetic */ void zzg(zzhdq zzhdqVar, boolean z) {
        zzhdqVar.zzc |= 4;
        zzhdqVar.zzf = z;
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
                return zzgxy.zzbS(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဇ\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzhdr.zza, "zzh", "zzi", "zzj"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhdq();
            case NEW_BUILDER:
                return new zzhdp(zzhbpVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzhdq.class) {
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
