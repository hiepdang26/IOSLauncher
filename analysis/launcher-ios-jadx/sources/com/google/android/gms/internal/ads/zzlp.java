package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public final class zzlp {
    private final zzab zza;
    private final SparseArray zzb;

    public zzlp(zzab zzabVar, SparseArray sparseArray) {
        this.zza = zzabVar;
        SparseArray sparseArray2 = new SparseArray(zzabVar.zzb());
        for (int i = 0; i < zzabVar.zzb(); i++) {
            int iZza = zzabVar.zza(i);
            zzlo zzloVar = (zzlo) sparseArray.get(iZza);
            zzloVar.getClass();
            sparseArray2.append(iZza, zzloVar);
        }
        this.zzb = sparseArray2;
    }

    public final int zza(int i) {
        return this.zza.zza(i);
    }

    public final int zzb() {
        return this.zza.zzb();
    }

    public final zzlo zzc(int i) {
        zzlo zzloVar = (zzlo) this.zzb.get(i);
        zzloVar.getClass();
        return zzloVar;
    }

    public final boolean zzd(int i) {
        return this.zza.zzc(i);
    }
}
