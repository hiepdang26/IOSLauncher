package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzvh {
    public final int zza;
    public final boolean zzb;

    public zzvh(int i, boolean z) {
        this.zza = i;
        this.zzb = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzvh.class == obj.getClass()) {
            zzvh zzvhVar = (zzvh) obj;
            if (this.zza == zzvhVar.zza && this.zzb == zzvhVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza * 31) + (this.zzb ? 1 : 0);
    }
}
