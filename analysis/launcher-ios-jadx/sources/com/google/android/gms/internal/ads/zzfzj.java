package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzfzj extends zzfxw {
    static final zzfzj zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzfzj(objArr, 0, objArr, 0, 0);
    }

    public zzfzj(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzb = objArr;
        this.zze = i;
        this.zzc = objArr2;
        this.zzf = i2;
        this.zzg = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.zzc;
            if (objArr.length != 0) {
                int iZzb = zzfxj.zzb(obj);
                while (true) {
                    int i = iZzb & this.zzf;
                    Object obj2 = objArr[i];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iZzb = i + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfxw, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzfxw, com.google.android.gms.internal.ads.zzfxm, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzg);
        return i + this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final int zzb() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfxw, com.google.android.gms.internal.ads.zzfxm
    /* JADX INFO: renamed from: zze */
    public final zzfzx iterator() {
        return zzd().listIterator(0);
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfxm
    public final Object[] zzg() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfxw
    public final zzfxr zzi() {
        return zzfxr.zzj(this.zzb, this.zzg);
    }

    @Override // com.google.android.gms.internal.ads.zzfxw
    public final boolean zzu() {
        return true;
    }
}
