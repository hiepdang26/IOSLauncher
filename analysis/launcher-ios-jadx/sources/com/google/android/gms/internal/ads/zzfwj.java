package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
class zzfwj extends zzfwh implements List {
    final /* synthetic */ zzfwk zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfwj(zzfwk zzfwkVar, Object obj, List list, zzfwh zzfwhVar) {
        super(zzfwkVar, obj, list, zzfwhVar);
        this.zzf = zzfwkVar;
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        zzb();
        boolean zIsEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i, obj);
        this.zzf.zzb++;
        if (zIsEmpty) {
            zza();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = ((List) this.zzb).addAll(i, collection);
        if (!zAddAll) {
            return zAddAll;
        }
        int size2 = this.zzb.size();
        this.zzf.zzb += size2 - size;
        if (size != 0) {
            return zAddAll;
        }
        zza();
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzb();
        return ((List) this.zzb).get(i);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        zzb();
        return ((List) this.zzb).indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        zzb();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        zzb();
        return new zzfwi(this);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        zzb();
        Object objRemove = ((List) this.zzb).remove(i);
        zzfwk zzfwkVar = this.zzf;
        zzfwkVar.zzb--;
        zzc();
        return objRemove;
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        zzb();
        return ((List) this.zzb).set(i, obj);
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        zzb();
        List listSubList = ((List) this.zzb).subList(i, i2);
        zzfwh zzfwhVar = this.zzc;
        if (zzfwhVar == null) {
            zzfwhVar = this;
        }
        return this.zzf.zzh(this.zza, listSubList, zzfwhVar);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        zzb();
        return new zzfwi(this, i);
    }
}
