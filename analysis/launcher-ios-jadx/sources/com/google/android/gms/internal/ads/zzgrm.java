package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgrm extends zzgxy implements zzgzk {
    private static final zzgrm zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgrp zzd;
    private int zze;

    static {
        zzgrm zzgrmVar = new zzgrm();
        zza = zzgrmVar;
        zzgxy.zzcb(zzgrm.class, zzgrmVar);
    }

    private zzgrm() {
    }

    public static zzgrl zzc() {
        return (zzgrl) zza.zzaZ();
    }

    public static zzgrm zze(zzgwm zzgwmVar, zzgxi zzgxiVar) {
        return (zzgrm) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public static /* synthetic */ void zzg(zzgrm zzgrmVar, zzgrp zzgrpVar) {
        zzgrpVar.getClass();
        zzgrmVar.zzd = zzgrpVar;
        zzgrmVar.zzc |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzgrk zzgrkVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzc", "zzd", "zze"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgrm();
            case NEW_BUILDER:
                return new zzgrl(zzgrkVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgrm.class) {
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
        zzgrp zzgrpVar = this.zzd;
        return zzgrpVar == null ? zzgrp.zze() : zzgrpVar;
    }
}
