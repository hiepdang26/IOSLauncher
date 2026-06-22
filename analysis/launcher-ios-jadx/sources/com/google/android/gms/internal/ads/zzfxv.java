package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzfxv extends zzfxk {
    Object[] zzd;
    private int zze;

    public zzfxv() {
        super(4);
    }

    @Override // com.google.android.gms.internal.ads.zzfxk, com.google.android.gms.internal.ads.zzfxl
    public final /* bridge */ /* synthetic */ zzfxl zzb(Object obj) {
        zzf(obj);
        return this;
    }

    public final zzfxv zzf(Object obj) {
        obj.getClass();
        if (this.zzd != null) {
            int iZzh = zzfxw.zzh(this.zzb);
            Object[] objArr = this.zzd;
            if (iZzh <= objArr.length) {
                int length = objArr.length - 1;
                int iHashCode = obj.hashCode();
                int iZza = zzfxj.zza(iHashCode);
                while (true) {
                    int i = iZza & length;
                    Object[] objArr2 = this.zzd;
                    Object obj2 = objArr2[i];
                    if (obj2 == null) {
                        objArr2[i] = obj;
                        this.zze += iHashCode;
                        zza(obj);
                        return this;
                    }
                    if (obj2.equals(obj)) {
                        return this;
                    }
                    iZza = i + 1;
                }
            }
        }
        this.zzd = null;
        zza(obj);
        return this;
    }

    public final zzfxv zzg(Object... objArr) {
        if (this.zzd == null) {
            zzd(objArr, 2);
            return this;
        }
        for (int i = 0; i < 2; i++) {
            zzf(objArr[i]);
        }
        return this;
    }

    public final zzfxv zzh(Iterable iterable) {
        iterable.getClass();
        if (this.zzd == null) {
            zzc(iterable);
            return this;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzf(it.next());
        }
        return this;
    }

    public final zzfxw zzi() {
        zzfxw zzfxwVarZzv;
        int i = this.zzb;
        if (i == 0) {
            return zzfzj.zza;
        }
        if (i == 1) {
            Object obj = this.zza[0];
            Objects.requireNonNull(obj);
            return new zzfzu(obj);
        }
        if (this.zzd == null || zzfxw.zzh(i) != this.zzd.length) {
            zzfxwVarZzv = zzfxw.zzv(this.zzb, this.zza);
            this.zzb = zzfxwVarZzv.size();
        } else {
            int i2 = this.zzb;
            Object[] objArrCopyOf = this.zza;
            if (zzfxw.zzw(i2, objArrCopyOf.length)) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i2);
            }
            zzfxwVarZzv = new zzfzj(objArrCopyOf, this.zze, this.zzd, r6.length - 1, this.zzb);
        }
        this.zzc = true;
        this.zzd = null;
        return zzfxwVarZzv;
    }

    public zzfxv(int i) {
        super(i);
        this.zzd = new Object[zzfxw.zzh(i)];
    }
}
