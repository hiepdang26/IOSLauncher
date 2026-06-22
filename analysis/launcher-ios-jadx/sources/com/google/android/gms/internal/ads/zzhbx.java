package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhbx extends zzgxy implements zzgzk {
    private static final zzhbx zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private boolean zze;
    private int zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private int zzm;
    private int zzn;
    private int zzo;
    private boolean zzp;
    private boolean zzv;
    private long zzw;
    private boolean zzy;
    private String zzf = "";
    private zzgyk zzg = zzgxy.zzbK();
    private String zzl = "";
    private zzgyk zzu = zzgxy.zzbK();
    private zzgyg zzx = zzgxy.zzbG();
    private zzgyg zzz = zzgxy.zzbG();

    static {
        zzhbx zzhbxVar = new zzhbx();
        zza = zzhbxVar;
        zzgxy.zzcb(zzhbx.class, zzhbxVar);
    }

    private zzhbx() {
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
                return zzgxy.zzbS(zza, "\u0001\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0004\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004\u001a\u0005᠌\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006\tဈ\u0007\nင\b\u000bင\t\fင\n\rဇ\u000b\u000e\u001b\u000fဇ\f\u0010ဂ\r\u0011ࠬ\u0012ဇ\u000e\u0013ࠬ", new Object[]{"zzc", "zzd", zzhbw.zza, "zze", "zzf", "zzg", "zzh", zzhbu.zza, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu", zzhbt.class, "zzv", "zzw", "zzx", zzhbj.zza(), "zzy", "zzz", zzhbv.zza});
            case NEW_MUTABLE_INSTANCE:
                return new zzhbx();
            case NEW_BUILDER:
                return new zzhbq(zzhbpVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzhbx.class) {
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
