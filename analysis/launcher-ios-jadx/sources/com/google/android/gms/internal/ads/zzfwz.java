package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzfwz extends AbstractCollection {
    final /* synthetic */ zzfxa zza;

    public zzfwz(zzfxa zzfxaVar) {
        this.zza = zzfxaVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzfxa zzfxaVar = this.zza;
        Map mapZzl = zzfxaVar.zzl();
        return mapZzl != null ? mapZzl.values().iterator() : new zzfwt(zzfxaVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.zza.size();
    }
}
