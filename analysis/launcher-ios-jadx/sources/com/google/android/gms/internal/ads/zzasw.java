package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzasw extends zzgxy implements zzgzk {
    private static final zzasw zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgyk zzd = zzgxy.zzbK();
    private zzgwm zze = zzgwm.zzb;
    private int zzf = 1;
    private int zzg = 1;

    static {
        zzasw zzaswVar = new zzasw();
        zza = zzaswVar;
        zzgxy.zzcb(zzasw.class, zzaswVar);
    }

    private zzasw() {
    }

    public static zzasv zza() {
        return (zzasv) zza.zzaZ();
    }

    public static /* synthetic */ void zzd(zzasw zzaswVar, zzgwm zzgwmVar) {
        zzgyk zzgykVar = zzaswVar.zzd;
        if (!zzgykVar.zzc()) {
            zzaswVar.zzd = zzgxy.zzbL(zzgykVar);
        }
        zzaswVar.zzd.add(zzgwmVar);
    }

    public static /* synthetic */ void zze(zzasw zzaswVar, zzgwm zzgwmVar) {
        zzaswVar.zzc |= 1;
        zzaswVar.zze = zzgwmVar;
    }

    public static /* synthetic */ void zzf(zzasw zzaswVar, int i) {
        zzaswVar.zzg = 4;
        zzaswVar.zzc = 4 | zzaswVar.zzc;
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
                return zzgxy.zzbS(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003᠌\u0001\u0004᠌\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zzasq.zza, "zzg", zzaso.zza});
            case NEW_MUTABLE_INSTANCE:
                return new zzasw();
            case NEW_BUILDER:
                return new zzasv(zzarnVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzasw.class) {
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
