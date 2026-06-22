package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzgth extends zzgxy implements zzgzk {
    private static final zzgth zza;
    private static volatile zzgzr zzb;
    private int zzc;
    private zzgyk zzd = zzgxy.zzbK();

    static {
        zzgth zzgthVar = new zzgth();
        zza = zzgthVar;
        zzgxy.zzcb(zzgth.class, zzgthVar);
    }

    private zzgth() {
    }

    public static zzgte zzd() {
        return (zzgte) zza.zzaZ();
    }

    public static zzgth zzg(InputStream inputStream, zzgxi zzgxiVar) {
        return (zzgth) zzgxy.zzbu(zza, inputStream, zzgxiVar);
    }

    public static /* synthetic */ void zzj(zzgth zzgthVar, zzgtg zzgtgVar) {
        zzgtgVar.getClass();
        zzgyk zzgykVar = zzgthVar.zzd;
        if (!zzgykVar.zzc()) {
            zzgthVar.zzd = zzgxy.zzbL(zzgykVar);
        }
        zzgthVar.zzd.add(zzgtgVar);
    }

    public final int zza() {
        return this.zzd.size();
    }

    public final int zzc() {
        return this.zzc;
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
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzc", "zzd", zzgtg.class});
            case NEW_MUTABLE_INSTANCE:
                return new zzgth();
            case NEW_BUILDER:
                return new zzgte(zzgtdVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzgzr zzgzrVar = zzb;
                if (zzgzrVar != null) {
                    return zzgzrVar;
                }
                synchronized (zzgth.class) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public final zzgtg zze(int i) {
        return (zzgtg) this.zzd.get(i);
    }

    public final List zzh() {
        return this.zzd;
    }
}
