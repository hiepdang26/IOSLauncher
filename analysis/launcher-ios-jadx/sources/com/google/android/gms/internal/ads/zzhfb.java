package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhfb implements zzhfl, zzhew {
    private static final Object zza = new Object();
    private volatile zzhfl zzb;
    private volatile Object zzc = zza;

    private zzhfb(zzhfl zzhflVar) {
        this.zzb = zzhflVar;
    }

    public static zzhew zza(zzhfl zzhflVar) {
        return zzhflVar instanceof zzhew ? (zzhew) zzhflVar : new zzhfb(zzhflVar);
    }

    public static zzhfl zzc(zzhfl zzhflVar) {
        return zzhflVar instanceof zzhfb ? zzhflVar : new zzhfb(zzhflVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        Object objZzb;
        Object obj = this.zzc;
        Object obj2 = zza;
        if (obj != obj2) {
            return obj;
        }
        synchronized (this) {
            try {
                objZzb = this.zzc;
                if (objZzb == obj2) {
                    objZzb = this.zzb.zzb();
                    Object obj3 = this.zzc;
                    if (obj3 != obj2 && obj3 != objZzb) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + objZzb + ". This is likely due to a circular dependency.");
                    }
                    this.zzc = objZzb;
                    this.zzb = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objZzb;
    }
}
