package com.google.android.gms.internal.ads;

import androidx.appcompat.widget.ActivityChooserView;
import defpackage.k31;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzgwc extends zzgvy implements RandomAccess, zzgya, zzgzs {
    private static final zzgwc zza = new zzgwc(new boolean[0], 0, false);
    private boolean[] zzb;
    private int zzc;

    public zzgwc() {
        this(new boolean[10], 0, true);
    }

    public static zzgwc zzd() {
        return zza;
    }

    private final String zzi(int i) {
        return k31.j(i, this.zzc, "Index:", ", Size:");
    }

    private final void zzj(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzi(i));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgvy, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zzdJ();
        if (i < 0 || i > (i2 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzi(i));
        }
        int i3 = i + 1;
        boolean[] zArr = this.zzb;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i3, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zzb, i, zArr2, i3, this.zzc - i);
            this.zzb = zArr2;
        }
        this.zzb[i] = zBooleanValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzgvy, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzdJ();
        byte[] bArr = zzgyl.zzb;
        collection.getClass();
        if (!(collection instanceof zzgwc)) {
            return super.addAll(collection);
        }
        zzgwc zzgwcVar = (zzgwc) collection;
        int i = zzgwcVar.zzc;
        if (i == 0) {
            return false;
        }
        int i2 = this.zzc;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        boolean[] zArr = this.zzb;
        if (i3 > zArr.length) {
            this.zzb = Arrays.copyOf(zArr, i3);
        }
        System.arraycopy(zzgwcVar.zzb, 0, this.zzb, this.zzc, zzgwcVar.zzc);
        this.zzc = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgvy, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgwc)) {
            return super.equals(obj);
        }
        zzgwc zzgwcVar = (zzgwc) obj;
        if (this.zzc != zzgwcVar.zzc) {
            return false;
        }
        boolean[] zArr = zzgwcVar.zzb;
        for (int i = 0; i < this.zzc; i++) {
            if (this.zzb[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzj(i);
        return Boolean.valueOf(this.zzb[i]);
    }

    @Override // com.google.android.gms.internal.ads.zzgvy, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZza = 1;
        for (int i = 0; i < this.zzc; i++) {
            iZza = (iZza * 31) + zzgyl.zza(this.zzb[i]);
        }
        return iZza;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i = this.zzc;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zzb[i2] == zBooleanValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgvy, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zzdJ();
        zzj(i);
        boolean[] zArr = this.zzb;
        boolean z = zArr[i];
        if (i < this.zzc - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (r2 - i) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        zzdJ();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.zzb;
        System.arraycopy(zArr, i2, zArr, i, this.zzc - i2);
        this.zzc -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzgvy, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zzdJ();
        zzj(i);
        boolean[] zArr = this.zzb;
        boolean z = zArr[i];
        zArr[i] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgyk
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzgya zzf(int i) {
        if (i >= this.zzc) {
            return new zzgwc(Arrays.copyOf(this.zzb, i), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zzg(boolean z) {
        zzdJ();
        int i = this.zzc;
        boolean[] zArr = this.zzb;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[((i * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.zzb = zArr2;
        }
        boolean[] zArr3 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        zArr3[i2] = z;
    }

    public final boolean zzh(int i) {
        zzj(i);
        return this.zzb[i];
    }

    private zzgwc(boolean[] zArr, int i, boolean z) {
        super(z);
        this.zzb = zArr;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.ads.zzgvy, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Boolean) obj).booleanValue());
        return true;
    }
}
