package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzgxr implements zzgzh {
    private static final zzgxr zza = new zzgxr();

    private zzgxr() {
    }

    public static zzgxr zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final zzgzg zzb(Class cls) {
        if (!zzgxy.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzgzg) zzgxy.zzbh(cls.asSubclass(zzgxy.class)).zzbO();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final boolean zzc(Class cls) {
        return zzgxy.class.isAssignableFrom(cls);
    }
}
