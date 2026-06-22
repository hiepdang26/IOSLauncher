package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfzh extends zzfxr {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    public zzfzh(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzfuu.zza(i, this.zzc, "index");
        Object obj = this.zza[i + i + this.zzb];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final boolean zzf() {
        return true;
    }
}
