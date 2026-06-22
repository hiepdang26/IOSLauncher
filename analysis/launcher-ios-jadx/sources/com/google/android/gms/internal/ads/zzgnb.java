package com.google.android.gms.internal.ads;

import defpackage.uo;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzgnb {
    private final Class zza;
    private final Class zzb;

    public /* synthetic */ zzgnb(Class cls, Class cls2, zzgna zzgnaVar) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgnb)) {
            return false;
        }
        zzgnb zzgnbVar = (zzgnb) obj;
        return zzgnbVar.zza.equals(this.zza) && zzgnbVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        return uo.i(this.zza.getSimpleName(), " with primitive type: ", this.zzb.getSimpleName());
    }
}
