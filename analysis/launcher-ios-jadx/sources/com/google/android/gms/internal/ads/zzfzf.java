package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzfzf extends zzfxw {
    private final transient zzfxu zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    public zzfzf(zzfxu zzfxuVar, Object[] objArr, int i, int i2) {
        this.zza = zzfxuVar;
        this.zzb = objArr;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfxw, com.google.android.gms.internal.ads.zzfxm, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final int zza(Object[] objArr, int i) {
        return zzd().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.ads.zzfxw, com.google.android.gms.internal.ads.zzfxm
    /* JADX INFO: renamed from: zze */
    public final zzfzx iterator() {
        return zzd().listIterator(0);
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzfxw
    public final zzfxr zzi() {
        return new zzfze(this);
    }
}
