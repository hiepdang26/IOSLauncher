package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class zzfxx {
    public static Object zza(Iterable iterable, Object obj) {
        zzfzm zzfzmVar = new zzfzm((zzfzn) iterable);
        return zzfzmVar.hasNext() ? zzfzmVar.next() : obj;
    }

    public static boolean zzb(Iterable iterable, zzfuv zzfuvVar) {
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            zzfuvVar.getClass();
            return zzd((List) iterable, zzfuvVar);
        }
        Iterator it = iterable.iterator();
        zzfuvVar.getClass();
        boolean z = false;
        while (it.hasNext()) {
            if (zzfuvVar.zza(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    private static void zzc(List list, zzfuv zzfuvVar, int i, int i2) {
        int size = list.size();
        while (true) {
            size--;
            if (size <= i2) {
                break;
            } else if (zzfuvVar.zza(list.get(size))) {
                list.remove(size);
            }
        }
        while (true) {
            i2--;
            if (i2 < i) {
                return;
            } else {
                list.remove(i2);
            }
        }
    }

    private static boolean zzd(List list, zzfuv zzfuvVar) {
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            Object obj = list.get(i);
            if (!zzfuvVar.zza(obj)) {
                if (i > i2) {
                    try {
                        list.set(i2, obj);
                    } catch (IllegalArgumentException unused) {
                        zzc(list, zzfuvVar, i2, i);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        zzc(list, zzfuvVar, i2, i);
                        return true;
                    }
                }
                i2++;
            }
            i++;
        }
        list.subList(i2, list.size()).clear();
        return i != i2;
    }
}
