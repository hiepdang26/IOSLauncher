package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzgan implements Serializable {
    private final int[] zza;
    private final int zzb;

    private zzgan(int[] iArr, int i, int i2) {
        this.zza = iArr;
        this.zzb = i2;
    }

    public static zzgan zzb(int[] iArr) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        return new zzgan(iArrCopyOf, 0, iArrCopyOf.length);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgan)) {
            return false;
        }
        zzgan zzganVar = (zzgan) obj;
        if (this.zzb != zzganVar.zzb) {
            return false;
        }
        for (int i = 0; i < this.zzb; i++) {
            if (zza(i) != zzganVar.zza(i)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            i = (i * 31) + this.zza[i2];
        }
        return i;
    }

    public final String toString() {
        int i = this.zzb;
        if (i == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(i * 5);
        sb.append('[');
        sb.append(this.zza[0]);
        for (int i2 = 1; i2 < this.zzb; i2++) {
            sb.append(", ");
            sb.append(this.zza[i2]);
        }
        sb.append(']');
        return sb.toString();
    }

    public final int zza(int i) {
        zzfuu.zza(i, this.zzb, "index");
        return this.zza[i];
    }
}
