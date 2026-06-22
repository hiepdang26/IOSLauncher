package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhfd implements zzhfc, zzhew {
    private static final zzhfd zza = new zzhfd(null);
    private final Object zzb;

    private zzhfd(Object obj) {
        this.zzb = obj;
    }

    public static zzhfc zza(Object obj) {
        zzhfk.zza(obj, "instance cannot be null");
        return new zzhfd(obj);
    }

    public static zzhfc zzc(Object obj) {
        return obj == null ? zza : new zzhfd(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final Object zzb() {
        return this.zzb;
    }
}
