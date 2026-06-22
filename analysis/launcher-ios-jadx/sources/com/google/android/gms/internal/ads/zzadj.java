package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzadj {
    public static final zzadj zza = new zzadj(0, 0);
    public final long zzb;
    public final long zzc;

    public zzadj(long j, long j2) {
        this.zzb = j;
        this.zzc = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzadj.class == obj.getClass()) {
            zzadj zzadjVar = (zzadj) obj;
            if (this.zzb == zzadjVar.zzb && this.zzc == zzadjVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zzb) * 31) + ((int) this.zzc);
    }

    public final String toString() {
        return "[timeUs=" + this.zzb + ", position=" + this.zzc + "]";
    }
}
