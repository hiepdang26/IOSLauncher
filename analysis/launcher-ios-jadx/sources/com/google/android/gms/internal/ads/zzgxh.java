package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzgxh {
    private final Object zza;
    private final int zzb;

    public zzgxh(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgxh)) {
            return false;
        }
        zzgxh zzgxhVar = (zzgxh) obj;
        return this.zza == zzgxhVar.zza && this.zzb == zzgxhVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
