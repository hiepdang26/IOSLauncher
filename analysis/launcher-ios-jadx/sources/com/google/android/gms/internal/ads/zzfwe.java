package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
class zzfwe extends zzfvx implements SortedMap {
    SortedSet zzd;
    final /* synthetic */ zzfwk zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfwe(zzfwk zzfwkVar, SortedMap sortedMap) {
        super(zzfwkVar, sortedMap);
        this.zze = zzfwkVar;
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return zzf().comparator();
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return zzf().firstKey();
    }

    public SortedMap headMap(Object obj) {
        return new zzfwe(this.zze, zzf().headMap(obj));
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return zzf().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new zzfwe(this.zze, zzf().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new zzfwe(this.zze, zzf().tailMap(obj));
    }

    public SortedMap zzf() {
        return (SortedMap) ((zzfvx) this).zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfyn
    public SortedSet zzg() {
        return new zzfwf(this.zze, zzf());
    }

    @Override // com.google.android.gms.internal.ads.zzfvx, com.google.android.gms.internal.ads.zzfyn, java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public SortedSet keySet() {
        SortedSet sortedSet = this.zzd;
        if (sortedSet != null) {
            return sortedSet;
        }
        SortedSet sortedSetZzg = zzg();
        this.zzd = sortedSetZzg;
        return sortedSetZzg;
    }
}
