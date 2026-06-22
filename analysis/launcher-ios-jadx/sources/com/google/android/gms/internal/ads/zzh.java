package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzh {
    public static final zzh zza = new zzh(0, 0, 1, 1, 0, null);
    private zzf zzb;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    public /* synthetic */ zzh(int i, int i2, int i3, int i4, int i5, zzg zzgVar) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzh.class != obj.getClass()) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return 486696559;
    }

    public final zzf zza() {
        if (this.zzb == null) {
            this.zzb = new zzf(this, null);
        }
        return this.zzb;
    }
}
