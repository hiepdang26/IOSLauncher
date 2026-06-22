package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class zzfxc extends zzfzc implements Serializable {
    final Comparator zza;

    public zzfxc(Comparator comparator) {
        this.zza = comparator;
    }

    @Override // com.google.android.gms.internal.ads.zzfzc, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.zza.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfxc) {
            return this.zza.equals(((zzfxc) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString();
    }
}
