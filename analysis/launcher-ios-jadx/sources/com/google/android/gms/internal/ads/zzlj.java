package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzlj {
    public static final zzlj zza;
    public static final zzlj zzb;
    public final long zzc;
    public final long zzd;

    static {
        zzlj zzljVar = new zzlj(0L, 0L);
        zza = zzljVar;
        new zzlj(Long.MAX_VALUE, Long.MAX_VALUE);
        new zzlj(Long.MAX_VALUE, 0L);
        new zzlj(0L, Long.MAX_VALUE);
        zzb = zzljVar;
    }

    public zzlj(long j, long j2) {
        zzdi.zzd(j >= 0);
        zzdi.zzd(j2 >= 0);
        this.zzc = j;
        this.zzd = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzlj.class == obj.getClass()) {
            zzlj zzljVar = (zzlj) obj;
            if (this.zzc == zzljVar.zzc && this.zzd == zzljVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zzc) * 31) + ((int) this.zzd);
    }
}
