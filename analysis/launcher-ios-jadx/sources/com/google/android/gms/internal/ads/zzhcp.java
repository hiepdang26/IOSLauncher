package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhcp extends zzgxy implements zzgzk {
    private static final zzhcp zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzhco zzd;
    private zzgwm zzf;
    private zzgwm zzg;
    private int zzh;
    private byte zzi = 2;
    private zzgyk zze = zzgxy.zzbK();

    static {
        zzhcp zzhcpVar = new zzhcp();
        zza = zzhcpVar;
        zzgxy.zzcb(zzhcp.class, zzhcpVar);
    }

    private zzhcp() {
        zzgwm zzgwmVar = zzgwm.zzb;
        this.zzf = zzgwmVar;
        this.zzg = zzgwmVar;
    }

    public static zzhcm zzc() {
        return (zzhcm) zza.zzaZ();
    }

    public static /* synthetic */ void zze(zzhcp zzhcpVar, zzhcl zzhclVar) {
        zzhclVar.getClass();
        zzgyk zzgykVar = zzhcpVar.zze;
        if (!zzgykVar.zzc()) {
            zzhcpVar.zze = zzgxy.zzbL(zzgykVar);
        }
        zzhcpVar.zze.add(zzhclVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzhbp zzhbpVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzi);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzi = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", "zze", zzhcl.class, "zzf", "zzg", "zzh"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhcp();
            case NEW_BUILDER:
                return new zzhcm(zzhbpVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzhcp.class) {
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
