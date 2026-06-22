package com.google.android.gms.internal.ads;

import defpackage.uo;

/* JADX INFO: loaded from: classes.dex */
final class zzfvn implements zzfvk {
    private static final zzfvk zza = new zzfvk() { // from class: com.google.android.gms.internal.ads.zzfvm
        @Override // com.google.android.gms.internal.ads.zzfvk
        public final Object zza() {
            throw new IllegalStateException();
        }
    };
    private volatile zzfvk zzb;
    private Object zzc;

    public zzfvn(zzfvk zzfvkVar) {
        this.zzb = zzfvkVar;
    }

    public final String toString() {
        Object objT = this.zzb;
        if (objT == zza) {
            objT = uo.t("<supplier that returned ", String.valueOf(this.zzc), ">");
        }
        return uo.t("Suppliers.memoize(", String.valueOf(objT), ")");
    }

    @Override // com.google.android.gms.internal.ads.zzfvk
    public final Object zza() {
        zzfvk zzfvkVar = this.zzb;
        zzfvk zzfvkVar2 = zza;
        if (zzfvkVar != zzfvkVar2) {
            synchronized (this) {
                try {
                    if (this.zzb != zzfvkVar2) {
                        Object objZza = this.zzb.zza();
                        this.zzc = objZza;
                        this.zzb = zzfvkVar2;
                        return objZza;
                    }
                } finally {
                }
            }
        }
        return this.zzc;
    }
}
