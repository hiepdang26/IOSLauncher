package com.google.android.gms.internal.ads;

import defpackage.uo;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
final class zzfvl implements Serializable, zzfvk {
    final zzfvk zza;
    volatile transient boolean zzb;
    transient Object zzc;

    public zzfvl(zzfvk zzfvkVar) {
        this.zza = zzfvkVar;
    }

    public final String toString() {
        return uo.t("Suppliers.memoize(", (this.zzb ? uo.t("<supplier that returned ", String.valueOf(this.zzc), ">") : this.zza).toString(), ")");
    }

    @Override // com.google.android.gms.internal.ads.zzfvk
    public final Object zza() {
        if (!this.zzb) {
            synchronized (this) {
                try {
                    if (!this.zzb) {
                        Object objZza = this.zza.zza();
                        this.zzc = objZza;
                        this.zzb = true;
                        return objZza;
                    }
                } finally {
                }
            }
        }
        return this.zzc;
    }
}
