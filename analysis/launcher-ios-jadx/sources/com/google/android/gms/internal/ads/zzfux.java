package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzfux implements Serializable, zzfuv {
    private final List zza;

    public final boolean equals(Object obj) {
        if (obj instanceof zzfux) {
            return this.zza.equals(((zzfux) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 306654252;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Predicates.and(");
        boolean z = true;
        for (Object obj : this.zza) {
            if (!z) {
                sb.append(',');
            }
            sb.append(obj);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfuv
    public final boolean zza(Object obj) {
        for (int i = 0; i < this.zza.size(); i++) {
            if (!((zzfuv) this.zza.get(i)).zza(obj)) {
                return false;
            }
        }
        return true;
    }
}
