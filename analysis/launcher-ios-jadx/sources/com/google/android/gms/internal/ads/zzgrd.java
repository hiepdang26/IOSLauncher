package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgrd extends zzgxy implements zzgzk {
    private static final zzgrd zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgrg zzd;
    private int zze;

    static {
        zzgrd zzgrdVar = new zzgrd();
        zza = zzgrdVar;
        zzgxy.zzcb(zzgrd.class, zzgrdVar);
    }

    private zzgrd() {
    }

    public static zzgrc zzc() {
        return (zzgrc) zza.zzaZ();
    }

    public static zzgrd zze() {
        return zza;
    }

    public static /* synthetic */ void zzg(zzgrd zzgrdVar, zzgrg zzgrgVar) {
        zzgrgVar.getClass();
        zzgrdVar.zzd = zzgrgVar;
        zzgrdVar.zzc |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzgrb zzgrbVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzc", "zzd", "zze"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgrd();
            case NEW_BUILDER:
                return new zzgrc(zzgrbVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgrd.class) {
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

    public final zzgrg zzf() {
        zzgrg zzgrgVar = this.zzd;
        return zzgrgVar == null ? zzgrg.zze() : zzgrgVar;
    }
}
