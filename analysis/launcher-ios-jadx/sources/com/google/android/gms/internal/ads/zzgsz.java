package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgsz extends zzgxy implements zzgzk {
    private static final zzgsz zza;
    private static volatile zzgzr zzb;
    private String zzc = "";
    private zzgwm zzd = zzgwm.zzb;
    private int zze;

    static {
        zzgsz zzgszVar = new zzgsz();
        zza = zzgszVar;
        zzgxy.zzcb(zzgsz.class, zzgszVar);
    }

    private zzgsz() {
    }

    public static zzgsy zza() {
        return (zzgsy) zza.zzaZ();
    }

    public static zzgsy zzc(zzgsz zzgszVar) {
        return (zzgsy) zza.zzba(zzgszVar);
    }

    public static zzgsz zze() {
        return zza;
    }

    public static zzgsz zzf(byte[] bArr, zzgxi zzgxiVar) {
        return (zzgsz) zzgxy.zzbx(zza, bArr, zzgxiVar);
    }

    public static /* synthetic */ void zzj(zzgsz zzgszVar, String str) {
        str.getClass();
        zzgszVar.zzc = str;
    }

    public static /* synthetic */ void zzk(zzgsz zzgszVar, zzgwm zzgwmVar) {
        zzgwmVar.getClass();
        zzgszVar.zzd = zzgwmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzgsx zzgsxVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzc", "zzd", "zze"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgsz();
            case NEW_BUILDER:
                return new zzgsy(zzgsxVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgsz.class) {
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

    public final zzgtz zzg() {
        zzgtz zzgtzVarZzb = zzgtz.zzb(this.zze);
        return zzgtzVarZzb == null ? zzgtz.UNRECOGNIZED : zzgtzVarZzb;
    }

    public final zzgwm zzh() {
        return this.zzd;
    }

    public final String zzi() {
        return this.zzc;
    }
}
