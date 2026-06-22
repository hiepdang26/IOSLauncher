package com.google.android.gms.internal.ads;

import defpackage.k92;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzbth extends zzbtb {
    final /* synthetic */ List zza;

    public zzbth(zzbtk zzbtkVar, List list) {
        this.zza = list;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zze(String str) {
        k92.e("Error recording impression urls: ".concat(String.valueOf(str)));
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzf(List list) {
        k92.g("Recorded impression urls: ".concat(this.zza.toString()));
    }
}
