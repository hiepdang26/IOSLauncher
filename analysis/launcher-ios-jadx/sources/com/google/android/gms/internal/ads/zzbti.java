package com.google.android.gms.internal.ads;

import defpackage.k92;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzbti extends zzbtb {
    final /* synthetic */ List zza;

    public zzbti(zzbtk zzbtkVar, List list) {
        this.zza = list;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zze(String str) {
        k92.e("Error recording click: ".concat(String.valueOf(str)));
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzf(List list) {
        k92.g("Recorded click: ".concat(this.zza.toString()));
    }
}
