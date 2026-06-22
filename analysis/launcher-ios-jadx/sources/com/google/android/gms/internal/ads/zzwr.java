package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class zzwr implements zzxv {
    protected final zzcd zza;
    protected final int zzb;
    protected final int[] zzc;
    private final zzaf[] zzd;
    private int zze;

    public zzwr(zzcd zzcdVar, int[] iArr, int i) {
        int length = iArr.length;
        zzdi.zzf(length > 0);
        zzcdVar.getClass();
        this.zza = zzcdVar;
        this.zzb = length;
        this.zzd = new zzaf[length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.zzd[i2] = zzcdVar.zzb(iArr[i2]);
        }
        Arrays.sort(this.zzd, new Comparator() { // from class: com.google.android.gms.internal.ads.zzwq
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((zzaf) obj2).zzi - ((zzaf) obj).zzi;
            }
        });
        this.zzc = new int[this.zzb];
        for (int i3 = 0; i3 < this.zzb; i3++) {
            this.zzc[i3] = zzcdVar.zza(this.zzd[i3]);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzwr zzwrVar = (zzwr) obj;
            if (this.zza.equals(zzwrVar.zza) && Arrays.equals(this.zzc, zzwrVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zze;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.zzc) + (System.identityHashCode(this.zza) * 31);
        this.zze = iHashCode;
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final int zza(int i) {
        return this.zzc[i];
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final int zzb(int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            if (this.zzc[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final int zzc() {
        return this.zzc.length;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzaf zzd(int i) {
        return this.zzd[i];
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final zzcd zze() {
        return this.zza;
    }
}
