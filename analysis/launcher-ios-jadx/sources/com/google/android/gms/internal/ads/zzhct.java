package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhct extends zzgxy implements zzgzk {
    private static final zzhct zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzhcs zzd;
    private zzgwm zzf;
    private zzgwm zzg;
    private int zzh;
    private zzgwm zzi;
    private byte zzj = 2;
    private zzgyk zze = zzgxy.zzbK();

    static {
        zzhct zzhctVar = new zzhct();
        zza = zzhctVar;
        zzgxy.zzcb(zzhct.class, zzhctVar);
    }

    private zzhct() {
        zzgwm zzgwmVar = zzgwm.zzb;
        this.zzf = zzgwmVar;
        this.zzg = zzgwmVar;
        this.zzi = zzgwmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzhbp zzhbpVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzj);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzj = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzc", "zzd", "zze", zzhcl.class, "zzf", "zzg", "zzh", "zzi"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhct();
            case NEW_BUILDER:
                return new zzhcq(zzhbpVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzhct.class) {
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
