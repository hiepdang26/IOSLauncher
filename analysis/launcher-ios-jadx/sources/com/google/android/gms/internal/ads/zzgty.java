package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgty extends zzgxy implements zzgzk {
    private static final zzgty zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private String zzd = "";
    private zzgsz zze;

    static {
        zzgty zzgtyVar = new zzgty();
        zza = zzgtyVar;
        zzgxy.zzcb(zzgty.class, zzgtyVar);
    }

    private zzgty() {
    }

    public static zzgtx zzc() {
        return (zzgtx) zza.zzaZ();
    }

    public static zzgty zze() {
        return zza;
    }

    public static zzgty zzf(zzgwm zzgwmVar, zzgxi zzgxiVar) {
        return (zzgty) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public static /* synthetic */ void zzh(zzgty zzgtyVar, String str) {
        str.getClass();
        zzgtyVar.zzd = str;
    }

    public static /* synthetic */ void zzi(zzgty zzgtyVar, zzgsz zzgszVar) {
        zzgszVar.getClass();
        zzgtyVar.zze = zzgszVar;
        zzgtyVar.zzc |= 1;
    }

    public final zzgsz zza() {
        zzgsz zzgszVar = this.zze;
        return zzgszVar == null ? zzgsz.zze() : zzgszVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzgtw zzgtwVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgty();
            case NEW_BUILDER:
                return new zzgtx(zzgtwVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgty.class) {
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

    public final String zzg() {
        return this.zzd;
    }
}
