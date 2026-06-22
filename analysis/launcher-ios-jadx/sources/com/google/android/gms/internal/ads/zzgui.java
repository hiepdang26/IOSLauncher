package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgui extends zzgxy implements zzgzk {
    private static final zzgui zza;
    private static volatile zzgzr zzb;
    private int zzc;

    static {
        zzgui zzguiVar = new zzgui();
        zza = zzguiVar;
        zzgxy.zzcb(zzgui.class, zzguiVar);
    }

    private zzgui() {
    }

    public static zzgui zzd() {
        return zza;
    }

    public static zzgui zze(zzgwm zzgwmVar, zzgxi zzgxiVar) {
        return (zzgui) zzgxy.zzbr(zza, zzgwmVar, zzgxiVar);
    }

    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final Object zzde(zzgxx zzgxxVar, Object obj, Object obj2) {
        zzgzr zzgxtVar;
        zzgug zzgugVar = null;
        switch (zzgxxVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return zzgxy.zzbS(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzc"});
            case NEW_MUTABLE_INSTANCE:
                return new zzgui();
            case NEW_BUILDER:
                return new zzguh(zzgugVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgui.class) {
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
