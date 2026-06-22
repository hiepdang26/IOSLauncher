package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzaze {
    final long zza;
    final String zzb;
    final int zzc;

    public zzaze(long j, String str, int i) {
        this.zza = j;
        this.zzb = str;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzaze)) {
            zzaze zzazeVar = (zzaze) obj;
            if (zzazeVar.zza == this.zza && zzazeVar.zzc == this.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.zza;
    }
}
