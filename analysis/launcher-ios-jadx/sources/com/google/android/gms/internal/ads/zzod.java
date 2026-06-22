package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzod {
    public static final zzod zza;
    public final int zzb;
    public final int zzc;
    private final zzfxw zzd;

    static {
        zzod zzodVar;
        if (zzet.zza >= 33) {
            zzfxv zzfxvVar = new zzfxv();
            for (int i = 1; i <= 10; i++) {
                zzfxvVar.zzf(Integer.valueOf(zzet.zzh(i)));
            }
            zzodVar = new zzod(2, zzfxvVar.zzi());
        } else {
            zzodVar = new zzod(2, 10);
        }
        zza = zzodVar;
    }

    public zzod(int i, int i2) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzod)) {
            return false;
        }
        zzod zzodVar = (zzod) obj;
        return this.zzb == zzodVar.zzb && this.zzc == zzodVar.zzc && zzet.zzG(this.zzd, zzodVar.zzd);
    }

    public final int hashCode() {
        zzfxw zzfxwVar = this.zzd;
        return (((this.zzb * 31) + this.zzc) * 31) + (zzfxwVar == null ? 0 : zzfxwVar.hashCode());
    }

    public final String toString() {
        return "AudioProfile[format=" + this.zzb + ", maxChannelCount=" + this.zzc + ", channelMasks=" + String.valueOf(this.zzd) + "]";
    }

    public final int zza(int i, zzh zzhVar) {
        if (this.zzd != null) {
            return this.zzc;
        }
        if (zzet.zza >= 29) {
            return zzob.zza(this.zzb, i, zzhVar);
        }
        Integer num = (Integer) zzof.zzb.getOrDefault(Integer.valueOf(this.zzb), 0);
        num.getClass();
        return num.intValue();
    }

    public final boolean zzb(int i) {
        if (this.zzd == null) {
            return i <= this.zzc;
        }
        int iZzh = zzet.zzh(i);
        if (iZzh == 0) {
            return false;
        }
        return this.zzd.contains(Integer.valueOf(iZzh));
    }

    public zzod(int i, Set set) {
        this.zzb = i;
        zzfxw zzfxwVarZzl = zzfxw.zzl(set);
        this.zzd = zzfxwVarZzl;
        zzfzx it = zzfxwVarZzl.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, Integer.bitCount(((Integer) it.next()).intValue()));
        }
        this.zzc = iMax;
    }
}
