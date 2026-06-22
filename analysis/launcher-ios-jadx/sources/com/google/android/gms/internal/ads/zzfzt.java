package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
public final class zzfzt {
    public static int zza(Set set) {
        Iterator it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    public static zzfzs zzb(Set set, Set set2) {
        zzfuu.zzc(set, "set1");
        zzfuu.zzc(set2, "set2");
        return new zzfzn(set, set2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.Collection, java.util.Set] */
    public static Set zzc(Set set, zzfuv zzfuvVar) {
        if (!(set instanceof SortedSet)) {
            if (!(set instanceof zzfzo)) {
                set.getClass();
                return new zzfzo(set, zzfuvVar);
            }
            zzfzo zzfzoVar = (zzfzo) set;
            return new zzfzo(zzfzoVar.zza, zzfuy.zza(zzfzoVar.zzb, zzfuvVar));
        }
        SortedSet sortedSet = (SortedSet) set;
        if (!(sortedSet instanceof zzfzo)) {
            sortedSet.getClass();
            return new zzfzp(sortedSet, zzfuvVar);
        }
        zzfzo zzfzoVar2 = (zzfzo) sortedSet;
        return new zzfzp((SortedSet) zzfzoVar2.zza, zzfuy.zza(zzfzoVar2.zzb, zzfuvVar));
    }

    public static boolean zzd(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean zze(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof zzfyz) {
            collection = ((zzfyz) collection).zza();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return zzf(set, collection.iterator());
        }
        Iterator it = set.iterator();
        collection.getClass();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean zzf(Set set, Iterator it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }
}
