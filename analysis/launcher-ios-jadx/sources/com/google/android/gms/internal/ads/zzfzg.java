package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzfzg extends zzfxw {
    private final transient zzfxu zza;
    private final transient zzfxr zzb;

    public zzfzg(zzfxu zzfxuVar, zzfxr zzfxrVar) {
        this.zza = zzfxuVar;
        this.zzb = zzfxrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.ads.zzfxw, com.google.android.gms.internal.ads.zzfxm, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.ads.zzfxw, com.google.android.gms.internal.ads.zzfxm
    public final zzfxr zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfxw, com.google.android.gms.internal.ads.zzfxm
    /* JADX INFO: renamed from: zze */
    public final zzfzx iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final boolean zzf() {
        return true;
    }
}
