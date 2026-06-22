package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfxw<E> extends zzfxm<E> implements Set<E> {
    private transient zzfxr zza;

    public static int zzh(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            zzfuu.zzf(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zzfxv zzj(int i) {
        return new zzfxv(i);
    }

    public static zzfxw zzl(Collection collection) {
        if ((collection instanceof zzfxw) && !(collection instanceof SortedSet)) {
            zzfxw zzfxwVar = (zzfxw) collection;
            if (!zzfxwVar.zzf()) {
                return zzfxwVar;
            }
        }
        Object[] array = collection.toArray();
        return zzv(array.length, array);
    }

    public static zzfxw zzm(Object[] objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? zzv(length, (Object[]) objArr.clone()) : new zzfzu(objArr[0]) : zzfzj.zza;
    }

    public static zzfxw zzn() {
        return zzfzj.zza;
    }

    public static zzfxw zzo(Object obj) {
        return new zzfzu(obj);
    }

    public static zzfxw zzp(Object obj, Object obj2) {
        return zzv(2, obj, obj2);
    }

    public static zzfxw zzq(Object obj, Object obj2, Object obj3) {
        return zzv(3, obj, obj2, obj3);
    }

    public static zzfxw zzr(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzv(5, obj, obj2, obj3, obj4, obj5);
    }

    @SafeVarargs
    public static zzfxw zzs(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Object[] objArr2 = new Object[11];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, 5);
        return zzv(11, objArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzfxw zzv(int i, Object... objArr) {
        if (i == 0) {
            return zzfzj.zza;
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new zzfzu(obj);
        }
        int iZzh = zzh(i);
        Object[] objArr2 = new Object[iZzh];
        int i2 = iZzh - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj2 = objArr[i5];
            zzfzb.zza(obj2, i5);
            int iHashCode = obj2.hashCode();
            int iZza = zzfxj.zza(iHashCode);
            while (true) {
                int i6 = iZza & i2;
                Object obj3 = objArr2[i6];
                if (obj3 == null) {
                    objArr[i4] = obj2;
                    objArr2[i6] = obj2;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (!obj3.equals(obj2)) {
                    iZza++;
                }
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new zzfzu(obj4);
        }
        if (zzh(i4) < iZzh / 2) {
            return zzv(i4, objArr);
        }
        if (zzw(i4, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzfzj(objArr, i3, objArr2, i2, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzw(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzfxw) && zzu() && ((zzfxw) obj).zzu() && hashCode() != obj.hashCode()) {
            return false;
        }
        return zzfzt.zzd(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzfzt.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public zzfxr zzd() {
        zzfxr zzfxrVar = this.zza;
        if (zzfxrVar != null) {
            return zzfxrVar;
        }
        zzfxr zzfxrVarZzi = zzi();
        this.zza = zzfxrVarZzi;
        return zzfxrVarZzi;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zze */
    public abstract zzfzx iterator();

    public zzfxr zzi() {
        Object[] array = toArray();
        int i = zzfxr.zzd;
        return zzfxr.zzj(array, array.length);
    }

    public boolean zzu() {
        return false;
    }
}
