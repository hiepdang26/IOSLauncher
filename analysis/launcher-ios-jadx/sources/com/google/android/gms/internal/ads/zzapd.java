package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzapd {
    public final int zza;
    public final byte[] zzb;
    public final Map zzc;
    public final List zzd;
    public final boolean zze;

    private zzapd(int i, byte[] bArr, Map map, List list, boolean z, long j) {
        this.zza = i;
        this.zzb = bArr;
        this.zzc = map;
        this.zzd = list == null ? null : Collections.unmodifiableList(list);
        this.zze = z;
    }

    private static List zza(Map map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(new zzaoz((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }

    @Deprecated
    public zzapd(int i, byte[] bArr, Map map, boolean z, long j) {
        this(i, bArr, map, zza(map), z, j);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.TreeMap] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.Map] */
    public zzapd(int i, byte[] bArr, boolean z, long j, List list) {
        ?? treeMap;
        if (list == null) {
            treeMap = 0;
        } else if (list.isEmpty()) {
            treeMap = Collections.EMPTY_MAP;
        } else {
            treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzaoz zzaozVar = (zzaoz) it.next();
                treeMap.put(zzaozVar.zza(), zzaozVar.zzb());
            }
        }
        this(i, bArr, treeMap, list, z, j);
    }

    @Deprecated
    public zzapd(byte[] bArr, Map map) {
        this(200, bArr, map, zza(map), false, 0L);
    }
}
