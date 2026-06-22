package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class zzfxk extends zzfxl {
    Object[] zza;
    int zzb = 0;
    boolean zzc;

    public zzfxk(int i) {
        this.zza = new Object[i];
    }

    private final void zzf(int i) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i) {
            this.zza = Arrays.copyOf(objArr, zzfxl.zze(length, i));
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
    }

    public final zzfxk zza(Object obj) {
        obj.getClass();
        zzf(this.zzb + 1);
        Object[] objArr = this.zza;
        int i = this.zzb;
        this.zzb = i + 1;
        objArr[i] = obj;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfxl
    public /* bridge */ /* synthetic */ zzfxl zzb(Object obj) {
        throw null;
    }

    public final zzfxl zzc(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            zzf(collection.size() + this.zzb);
            if (collection instanceof zzfxm) {
                this.zzb = ((zzfxm) collection).zza(this.zza, this.zzb);
                return this;
            }
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzb(it.next());
        }
        return this;
    }

    public final void zzd(Object[] objArr, int i) {
        zzfzb.zzb(objArr, 2);
        zzf(this.zzb + 2);
        System.arraycopy(objArr, 0, this.zza, this.zzb, 2);
        this.zzb += 2;
    }
}
