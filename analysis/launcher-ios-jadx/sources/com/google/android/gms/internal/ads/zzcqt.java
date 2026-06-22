package com.google.android.gms.internal.ads;

import defpackage.n42;

/* JADX INFO: loaded from: classes.dex */
public final class zzcqt implements zzhfc {
    private final zzhfu zza;

    public zzcqt(zzhfu zzhfuVar) {
        this.zza = zzhfuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Boolean zzb() {
        boolean z = true;
        if (((zzcwh) this.zza).zza().zza() == null) {
            if (!((Boolean) n42.d.c.zza(zzbbw.zzeV)).booleanValue()) {
                z = false;
            }
        }
        return Boolean.valueOf(z);
    }
}
