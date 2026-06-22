package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzfwu extends AbstractSet {
    final /* synthetic */ zzfxa zza;

    public zzfwu(zzfxa zzfxaVar) {
        this.zza = zzfxaVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Map mapZzl = this.zza.zzl();
        if (mapZzl != null) {
            return mapZzl.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int iZzw = this.zza.zzw(entry.getKey());
            if (iZzw != -1 && zzfur.zza(zzfxa.zzj(this.zza, iZzw), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzfxa zzfxaVar = this.zza;
        Map mapZzl = zzfxaVar.zzl();
        return mapZzl != null ? mapZzl.entrySet().iterator() : new zzfws(zzfxaVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Map mapZzl = this.zza.zzl();
        if (mapZzl != null) {
            return mapZzl.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        zzfxa zzfxaVar = this.zza;
        if (zzfxaVar.zzr()) {
            return false;
        }
        int iZzv = zzfxaVar.zzv();
        Object key = entry.getKey();
        Object value = entry.getValue();
        zzfxa zzfxaVar2 = this.zza;
        int iZzb = zzfxb.zzb(key, value, iZzv, zzfxa.zzi(zzfxaVar2), zzfxaVar2.zzA(), zzfxaVar2.zzB(), zzfxaVar2.zzC());
        if (iZzb == -1) {
            return false;
        }
        this.zza.zzq(iZzb, iZzv);
        zzfxa zzfxaVar3 = this.zza;
        zzfxaVar3.zzg--;
        this.zza.zzo();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }
}
