package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzasn extends zzgxy implements zzgzk {
    private static final zzasn zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgwm zzd;
    private zzgwm zze;
    private zzgwm zzf;
    private zzgwm zzg;

    static {
        zzasn zzasnVar = new zzasn();
        zza = zzasnVar;
        zzgxy.zzcb(zzasn.class, zzasnVar);
    }

    private zzasn() {
        zzgwm zzgwmVar = zzgwm.zzb;
        this.zzd = zzgwmVar;
        this.zze = zzgwmVar;
        this.zzf = zzgwmVar;
        this.zzg = zzgwmVar;
    }

    public static zzasm zza() {
        return (zzasm) zza.zzaZ();
    }

    public static zzasn zzd(byte[] bArr, zzgxi zzgxiVar) {
        return (zzasn) zzgxy.zzbx(zza, bArr, zzgxiVar);
    }

    public static /* synthetic */ void zzi(zzasn zzasnVar, zzgwm zzgwmVar) {
        zzasnVar.zzc |= 1;
        zzasnVar.zzd = zzgwmVar;
    }

    public static /* synthetic */ void zzj(zzasn zzasnVar, zzgwm zzgwmVar) {
        zzasnVar.zzc |= 2;
        zzasnVar.zze = zzgwmVar;
    }

    public static /* synthetic */ void zzk(zzasn zzasnVar, zzgwm zzgwmVar) {
        zzasnVar.zzc |= 4;
        zzasnVar.zzf = zzgwmVar;
    }

    public static /* synthetic */ void zzl(zzasn zzasnVar, zzgwm zzgwmVar) {
        zzasnVar.zzc |= 8;
        zzasnVar.zzg = zzgwmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzarn zzarnVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case NEW_MUTABLE_INSTANCE:
                return new zzasn();
            case NEW_BUILDER:
                return new zzasm(zzarnVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzasn.class) {
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

    public final zzgwm zze() {
        return this.zzd;
    }

    public final zzgwm zzf() {
        return this.zze;
    }

    public final zzgwm zzg() {
        return this.zzg;
    }

    public final zzgwm zzh() {
        return this.zzf;
    }
}
