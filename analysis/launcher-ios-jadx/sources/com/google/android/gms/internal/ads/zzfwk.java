package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes.dex */
abstract class zzfwk extends zzfwn implements Serializable {
    private final transient Map zza;
    private transient int zzb;

    public zzfwk(Map map) {
        zzfuu.zze(map.isEmpty());
        this.zza = map;
    }

    public static /* bridge */ /* synthetic */ void zzo(zzfwk zzfwkVar, Object obj) {
        Object objRemove;
        try {
            objRemove = zzfwkVar.zza.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            objRemove = null;
        }
        Collection collection = (Collection) objRemove;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            zzfwkVar.zzb -= size;
        }
    }

    public abstract Collection zza();

    public Collection zzb(Collection collection) {
        throw null;
    }

    public Collection zzc(Object obj, Collection collection) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzfyp
    public final int zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfwn
    public final Collection zzf() {
        return new zzfwm(this);
    }

    @Override // com.google.android.gms.internal.ads.zzfwn
    public final Iterator zzg() {
        return new zzfvu(this);
    }

    public final List zzh(Object obj, List list, zzfwh zzfwhVar) {
        return list instanceof RandomAccess ? new zzfwd(this, obj, list, zzfwhVar) : new zzfwj(this, obj, list, zzfwhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfwn
    public Map zzj() {
        throw null;
    }

    public final Map zzk() {
        Map map = this.zza;
        return map instanceof NavigableMap ? new zzfwb(this, (NavigableMap) map) : map instanceof SortedMap ? new zzfwe(this, (SortedMap) map) : new zzfvx(this, map);
    }

    @Override // com.google.android.gms.internal.ads.zzfwn
    public Set zzl() {
        throw null;
    }

    public final Set zzm() {
        Map map = this.zza;
        return map instanceof NavigableMap ? new zzfwc(this, (NavigableMap) map) : map instanceof SortedMap ? new zzfwf(this, (SortedMap) map) : new zzfwa(this, map);
    }

    @Override // com.google.android.gms.internal.ads.zzfyp
    public final void zzp() {
        Iterator it = this.zza.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfwn, com.google.android.gms.internal.ads.zzfyp
    public final boolean zzq(Object obj, Object obj2) {
        Collection collection = (Collection) this.zza.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.zzb++;
            return true;
        }
        Collection collectionZza = zza();
        if (!collectionZza.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.zzb++;
        this.zza.put(obj, collectionZza);
        return true;
    }
}
