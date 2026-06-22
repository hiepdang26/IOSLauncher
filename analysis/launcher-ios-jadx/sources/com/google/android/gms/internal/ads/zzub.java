package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzub extends zztw {
    public static final Object zzc = new Object();
    private final Object zzd;
    private final Object zze;

    private zzub(zzcc zzccVar, Object obj, Object obj2) {
        super(zzccVar);
        this.zzd = obj;
        this.zze = obj2;
    }

    public static zzub zzq(zzbc zzbcVar) {
        return new zzub(new zzuc(zzbcVar), zzcb.zza, zzc);
    }

    public static zzub zzr(zzcc zzccVar, Object obj, Object obj2) {
        return new zzub(zzccVar, obj, obj2);
    }

    @Override // com.google.android.gms.internal.ads.zztw, com.google.android.gms.internal.ads.zzcc
    public final int zza(Object obj) {
        Object obj2;
        if (zzc.equals(obj) && (obj2 = this.zze) != null) {
            obj = obj2;
        }
        return this.zzb.zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zztw, com.google.android.gms.internal.ads.zzcc
    public final zzca zzd(int i, zzca zzcaVar, boolean z) {
        this.zzb.zzd(i, zzcaVar, z);
        if (zzet.zzG(zzcaVar.zzb, this.zze) && z) {
            zzcaVar.zzb = zzc;
        }
        return zzcaVar;
    }

    @Override // com.google.android.gms.internal.ads.zztw, com.google.android.gms.internal.ads.zzcc
    public final zzcb zze(int i, zzcb zzcbVar, long j) {
        this.zzb.zze(i, zzcbVar, j);
        if (zzet.zzG(zzcbVar.zzb, this.zzd)) {
            zzcbVar.zzb = zzcb.zza;
        }
        return zzcbVar;
    }

    @Override // com.google.android.gms.internal.ads.zztw, com.google.android.gms.internal.ads.zzcc
    public final Object zzf(int i) {
        Object objZzf = this.zzb.zzf(i);
        return zzet.zzG(objZzf, this.zze) ? zzc : objZzf;
    }

    public final zzub zzp(zzcc zzccVar) {
        return new zzub(zzccVar, this.zzd, this.zze);
    }
}
