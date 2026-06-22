package com.google.android.gms.internal.ads;

import defpackage.uo;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzgnv {
    private final Class zza;
    private final Class zzb;

    public /* synthetic */ zzgnv(Class cls, Class cls2, zzgnu zzgnuVar) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgnv)) {
            return false;
        }
        zzgnv zzgnvVar = (zzgnv) obj;
        return zzgnvVar.zza.equals(this.zza) && zzgnvVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        return uo.i(this.zza.getSimpleName(), " with serialization type: ", this.zzb.getSimpleName());
    }
}
