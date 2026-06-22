package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class zzfwh extends AbstractCollection {
    final Object zza;
    Collection zzb;
    final zzfwh zzc;
    final Collection zzd;
    final /* synthetic */ zzfwk zze;

    public zzfwh(zzfwk zzfwkVar, Object obj, Collection collection, zzfwh zzfwhVar) {
        this.zze = zzfwkVar;
        this.zza = obj;
        this.zzb = collection;
        this.zzc = zzfwhVar;
        this.zzd = zzfwhVar == null ? null : zzfwhVar.zzb;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        zzb();
        boolean zIsEmpty = this.zzb.isEmpty();
        boolean zAdd = this.zzb.add(obj);
        if (zAdd) {
            this.zze.zzb++;
            if (zIsEmpty) {
                zza();
                return true;
            }
        }
        return zAdd;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = this.zzb.addAll(collection);
        if (!zAddAll) {
            return zAddAll;
        }
        int size2 = this.zzb.size();
        this.zze.zzb += size2 - size;
        if (size != 0) {
            return zAddAll;
        }
        zza();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.zzb.clear();
        this.zze.zzb -= size;
        zzc();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        zzb();
        return this.zzb.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        zzb();
        return this.zzb.containsAll(collection);
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        zzb();
        return this.zzb.equals(obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        zzb();
        return this.zzb.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzb();
        return new zzfwg(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        zzb();
        boolean zRemove = this.zzb.remove(obj);
        if (zRemove) {
            zzfwk zzfwkVar = this.zze;
            zzfwkVar.zzb--;
            zzc();
        }
        return zRemove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zRemoveAll = this.zzb.removeAll(collection);
        if (zRemoveAll) {
            int size2 = this.zzb.size();
            this.zze.zzb += size2 - size;
            zzc();
        }
        return zRemoveAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean zRetainAll = this.zzb.retainAll(collection);
        if (zRetainAll) {
            int size2 = this.zzb.size();
            this.zze.zzb += size2 - size;
            zzc();
        }
        return zRetainAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        zzb();
        return this.zzb.size();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        zzb();
        return this.zzb.toString();
    }

    public final void zza() {
        zzfwh zzfwhVar = this.zzc;
        if (zzfwhVar != null) {
            zzfwhVar.zza();
            return;
        }
        zzfwk zzfwkVar = this.zze;
        zzfwkVar.zza.put(this.zza, this.zzb);
    }

    public final void zzb() {
        zzfwh zzfwhVar = this.zzc;
        if (zzfwhVar != null) {
            zzfwhVar.zzb();
            zzfwh zzfwhVar2 = this.zzc;
            if (zzfwhVar2.zzb != this.zzd) {
                throw new ConcurrentModificationException();
            }
            return;
        }
        if (this.zzb.isEmpty()) {
            zzfwk zzfwkVar = this.zze;
            Collection collection = (Collection) zzfwkVar.zza.get(this.zza);
            if (collection != null) {
                this.zzb = collection;
            }
        }
    }

    public final void zzc() {
        zzfwh zzfwhVar = this.zzc;
        if (zzfwhVar != null) {
            zzfwhVar.zzc();
        } else if (this.zzb.isEmpty()) {
            zzfwk zzfwkVar = this.zze;
            zzfwkVar.zza.remove(this.zza);
        }
    }
}
