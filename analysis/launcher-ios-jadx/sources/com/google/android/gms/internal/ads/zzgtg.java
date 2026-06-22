package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgtg extends zzgxy implements zzgzk {
    private static final zzgtg zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgsv zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzgtg zzgtgVar = new zzgtg();
        zza = zzgtgVar;
        zzgxy.zzcb(zzgtg.class, zzgtgVar);
    }

    private zzgtg() {
    }

    public static zzgtf zzd() {
        return (zzgtf) zza.zzaZ();
    }

    public static /* synthetic */ void zzg(zzgtg zzgtgVar, zzgsv zzgsvVar) {
        zzgsvVar.getClass();
        zzgtgVar.zzd = zzgsvVar;
        zzgtgVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzgsv zzc() {
        zzgsv zzgsvVar = this.zzd;
        return zzgsvVar == null ? zzgsv.zze() : zzgsvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzgtd zzgtdVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgtg();
            case NEW_BUILDER:
                return new zzgtf(zzgtdVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgtg.class) {
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

    public final zzgtz zzf() {
        zzgtz zzgtzVarZzb = zzgtz.zzb(this.zzg);
        return zzgtzVarZzb == null ? zzgtz.UNRECOGNIZED : zzgtzVarZzb;
    }

    public final boolean zzj() {
        return (this.zzc & 1) != 0;
    }

    public final int zzk() {
        int i = this.zze;
        int i2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? 0 : 5 : 4 : 3 : 2;
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }
}
