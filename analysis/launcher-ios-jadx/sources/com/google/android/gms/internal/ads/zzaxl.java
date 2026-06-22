package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxl extends zzgxy implements zzgzk {
    private static final zzaxl zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private String zzd = "";
    private String zze = "";
    private long zzf;
    private long zzg;
    private long zzh;

    static {
        zzaxl zzaxlVar = new zzaxl();
        zza = zzaxlVar;
        zzgxy.zzcb(zzaxl.class, zzaxlVar);
    }

    private zzaxl() {
    }

    public static zzaxk zze() {
        return (zzaxk) zza.zzaZ();
    }

    public static zzaxl zzg() {
        return zza;
    }

    public static zzaxl zzh(zzgwm zzgwmVar) {
        return (zzaxl) zzgxy.zzbm(zza, zzgwmVar);
    }

    public static zzaxl zzi(zzgwm zzgwmVar, zzgxi zzgxiVar) {
        return (zzaxl) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public static /* synthetic */ void zzl(zzaxl zzaxlVar, String str) {
        str.getClass();
        zzaxlVar.zzc |= 1;
        zzaxlVar.zzd = str;
    }

    public static /* synthetic */ void zzm(zzaxl zzaxlVar, long j) {
        zzaxlVar.zzc |= 16;
        zzaxlVar.zzh = j;
    }

    public static /* synthetic */ void zzn(zzaxl zzaxlVar, String str) {
        str.getClass();
        zzaxlVar.zzc |= 2;
        zzaxlVar.zze = str;
    }

    public static /* synthetic */ void zzo(zzaxl zzaxlVar, long j) {
        zzaxlVar.zzc |= 4;
        zzaxlVar.zzf = j;
    }

    public static /* synthetic */ void zzp(zzaxl zzaxlVar, long j) {
        zzaxlVar.zzc |= 8;
        zzaxlVar.zzg = j;
    }

    public final long zza() {
        return this.zzg;
    }

    public final long zzc() {
        return this.zzf;
    }

    public final long zzd() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzaxj zzaxjVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
            case NEW_MUTABLE_INSTANCE:
                return new zzaxl();
            case NEW_BUILDER:
                return new zzaxk(zzaxjVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzaxl.class) {
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

    public final String zzj() {
        return this.zze;
    }

    public final String zzk() {
        return this.zzd;
    }
}
