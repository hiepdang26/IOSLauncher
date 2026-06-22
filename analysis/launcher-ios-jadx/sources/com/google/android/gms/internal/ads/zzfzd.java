package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfzd extends zzfxr {
    static final zzfxr zza = new zzfzd(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    public zzfzd(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzfuu.zza(i, this.zzc, "index");
        Object obj = this.zzb[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfxr, com.google.android.gms.internal.ads.zzfxm
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzc);
        return i + this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final Object[] zzg() {
        return this.zzb;
    }
}
