package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgrj extends zzgxy implements zzgzk {
    private static final zzgrj zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private int zzd;
    private zzgrp zze;
    private zzgwm zzf = zzgwm.zzb;

    static {
        zzgrj zzgrjVar = new zzgrj();
        zza = zzgrjVar;
        zzgxy.zzcb(zzgrj.class, zzgrjVar);
    }

    private zzgrj() {
    }

    public static zzgri zzc() {
        return (zzgri) zza.zzaZ();
    }

    public static zzgrj zze(zzgwm zzgwmVar, zzgxi zzgxiVar) {
        return (zzgrj) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public static zzgzr zzh() {
        return zza.zzbN();
    }

    public static /* synthetic */ void zzi(zzgrj zzgrjVar, zzgrp zzgrpVar) {
        zzgrpVar.getClass();
        zzgrjVar.zze = zzgrpVar;
        zzgrjVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzgrh zzgrhVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgrj();
            case NEW_BUILDER:
                return new zzgri(zzgrhVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgrj.class) {
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

    public final zzgrp zzf() {
        zzgrp zzgrpVar = this.zze;
        return zzgrpVar == null ? zzgrp.zze() : zzgrpVar;
    }

    public final zzgwm zzg() {
        return this.zzf;
    }
}
