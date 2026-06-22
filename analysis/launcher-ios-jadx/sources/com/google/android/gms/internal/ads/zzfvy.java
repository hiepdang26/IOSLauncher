package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
class zzfvy implements Iterator {
    final Iterator zza;
    Collection zzb = null;
    Iterator zzc = zzfxz.INSTANCE;
    final /* synthetic */ zzfwk zzd;

    public zzfvy(zzfwk zzfwkVar) {
        this.zzd = zzfwkVar;
        this.zza = zzfwkVar.zza.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext() || this.zzc.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.zzc.hasNext()) {
            Map.Entry entry = (Map.Entry) this.zza.next();
            entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.zzb = collection;
            this.zzc = collection.iterator();
        }
        return this.zzc.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zzc.remove();
        Collection collection = this.zzb;
        Objects.requireNonNull(collection);
        if (collection.isEmpty()) {
            this.zza.remove();
        }
        zzfwk zzfwkVar = this.zzd;
        zzfwkVar.zzb--;
    }
}
