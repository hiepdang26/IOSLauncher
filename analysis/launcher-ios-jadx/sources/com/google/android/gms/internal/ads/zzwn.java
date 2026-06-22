package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzwn {
    public final long zza;
    public final long zzb;

    public zzwn(long j, long j2) {
        this.zza = j;
        this.zzb = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzwn)) {
            return false;
        }
        zzwn zzwnVar = (zzwn) obj;
        return this.zza == zzwnVar.zza && this.zzb == zzwnVar.zzb;
    }

    public final int hashCode() {
        return (((int) this.zza) * 31) + ((int) this.zzb);
    }
}
