package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhei extends zzgxy implements zzgzk {
    private static final zzhei zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private boolean zzj;
    private double zzk;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzu;
    private String zzd = "";
    private String zze = "";
    private int zzf = 4;
    private zzgyk zzg = zzgxy.zzbK();
    private String zzh = "";
    private String zzi = "";
    private zzgyk zzl = zzgxy.zzbK();

    static {
        zzhei zzheiVar = new zzhei();
        zza = zzheiVar;
        zzgxy.zzcb(zzhei.class, zzheiVar);
    }

    private zzhei() {
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
                return zzgxy.zzbS(zza, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0002\u0003\u001a\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဇ\u0005\u0007က\u0006\b\u001b\tဈ\u0001\n᠌\u0007\u000bဇ\b\fဇ\t\rဇ\n\u000eဇ\u000b", new Object[]{"zzc", "zzd", "zzf", zzheh.zza, "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzheg.class, "zze", "zzm", zzhee.zza, "zzn", "zzo", "zzp", "zzu"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhei();
            case NEW_BUILDER:
                return new zzhed(zzhbpVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzhei.class) {
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
