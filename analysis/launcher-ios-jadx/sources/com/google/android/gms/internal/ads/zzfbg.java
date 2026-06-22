package com.google.android.gms.internal.ads;

import defpackage.do0;

/* JADX INFO: loaded from: classes.dex */
final class zzfbg implements zzfho {
    private final zzfcc zza;

    public zzfbg(zzfcc zzfccVar) {
        this.zza = zzfccVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfho
    public final do0 zza(zzfhp zzfhpVar) {
        zzfbh zzfbhVar = (zzfbh) zzfhpVar;
        return ((zzfbd) this.zza).zzb(zzfbhVar.zzb, zzfbhVar.zza, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfho
    public final void zzb(zzfhd zzfhdVar) {
        zzfhdVar.zza = ((zzfbd) this.zza).zza();
    }
}
