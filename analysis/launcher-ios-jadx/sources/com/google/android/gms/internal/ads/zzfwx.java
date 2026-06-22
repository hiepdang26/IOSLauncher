package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzfwx extends AbstractSet {
    final /* synthetic */ zzfxa zza;

    public zzfwx(zzfxa zzfxaVar) {
        this.zza = zzfxaVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.zza.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzfxa zzfxaVar = this.zza;
        Map mapZzl = zzfxaVar.zzl();
        return mapZzl != null ? mapZzl.keySet().iterator() : new zzfwr(zzfxaVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Map mapZzl = this.zza.zzl();
        return mapZzl != null ? mapZzl.keySet().remove(obj) : this.zza.zzy(obj) != zzfxa.zzd;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }
}
