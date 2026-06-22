package com.google.android.gms.internal.ads;

import defpackage.bf1;

/* JADX INFO: loaded from: classes.dex */
public final class zzbvk extends zzbvm {
    private final String zza;
    private final int zzb;

    public zzbvk(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzbvk)) {
            zzbvk zzbvkVar = (zzbvk) obj;
            if (bf1.c(this.zza, zzbvkVar.zza)) {
                if (bf1.c(Integer.valueOf(this.zzb), Integer.valueOf(zzbvkVar.zzb))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final String zzc() {
        return this.zza;
    }
}
